import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class RequisitorPaginaFiguras implements Runnable {
	private String url, diretorio;
	
	public RequisitorPaginaFiguras(String diretorio, String url) {
		this.diretorio = diretorio;
		this.url = url;
	}

	@Override
	public void run() {
		String file = download(diretorio, url);		

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
			
			
			//Obtem o nome do arquivo a partir da url (dá um split pela "/" e pega o ultimo elemento)
			String s[] = url.split("/");
			nomeArquivo = s[s.length-1];
			System.out.println(diretorio+"/"+nomeArquivo);

			File arquivo = new File(diretorio+"/"+nomeArquivo);
			if(!arquivo.exists())
				arquivo.createNewFile();
			FileOutputStream writer = new FileOutputStream(arquivo);
			
			int leitura = stream.read();			
			while (leitura!=-1) {
				writer.write(leitura);
				leitura = stream.read();	
			}
			writer.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return(diretorio+"/"+nomeArquivo);
		
	}

}
