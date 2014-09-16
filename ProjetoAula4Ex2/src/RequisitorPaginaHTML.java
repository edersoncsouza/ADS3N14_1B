import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequisitorPaginaHTML implements Runnable {
	private static int dir=1;
	private String url;

	public RequisitorPaginaHTML(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		String diretorio = criarDiretorio();
		String file = download(diretorio, url);		
		parser(diretorio,file);

	}
	
	private void parser(String diretorio, String arquivo) {
		try {
			FileReader filereader = new FileReader(arquivo);
			BufferedReader reader = new BufferedReader(filereader);
			StringBuffer buffer = new StringBuffer();
			String linha = reader.readLine();
			while(linha!=null){
				buffer.append(linha);
				linha = reader.readLine();
			}
			//Primeiro parênteses captura toda a tag, o segundo captura o src e o terceiro só pega o link

			Pattern p = Pattern.compile("(<img.*?(src=\"(.*?)\").*?>)");
			Matcher m = p.matcher(buffer.toString());
			List<String> links = new ArrayList<>();
			while (m.find()) {
				//group(3): pega o grupo dentro do grupo dentro do grupo.
				//Mais detalhes em http://tutorials.jenkov.com/java-regex/matcher.html#group-method
				links.add(m.group(3));
				RequisitorPaginaFiguras requisitor = new RequisitorPaginaFiguras(diretorio, m.group(3));
				new Thread(requisitor).start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
	}

	private String criarDiretorio(){
		String diretorio = "C:/Temp/diret"+dir++;
		File arquivo = new File(diretorio);
		if(arquivo.exists())
			arquivo.delete();
		arquivo.mkdir();
		return(diretorio);
	}
	
	private String download(String diretorio, String url)
	{
		System.setProperty("http.proxyHost", "192.168.0.3");
		System.setProperty("http.proxyPort", "8080");
		URL u;
		String nomeArquivo = null;
		try {
			u = new URL(url);
			URLConnection conexao = u.openConnection();
			InputStream stream = conexao.getInputStream();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(stream));
			
			//Obtem o nome do arquivo a partir da url (dá um split pela "/" e pega o ultimo elemento)
			String s[] = url.split("/");
			nomeArquivo = s[s.length-1];
			System.out.println(diretorio+"/"+nomeArquivo);

			File arquivo = new File(diretorio+"/"+nomeArquivo);
			if(!arquivo.exists())
				arquivo.createNewFile();
			FileWriter writer = new FileWriter(arquivo, false);
			
			String str = in.readLine();
			while (str != null) {
				writer.append(str);
				str = in.readLine();
			}
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(diretorio+"/"+nomeArquivo);
		
	}

}
