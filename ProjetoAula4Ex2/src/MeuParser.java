import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MeuParser {
	public static void main(String[] args) {
		String arquivo = "C:\\Users\\lhries\\Desktop\\a.html";
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
				System.out.println("Found a " + m.group(3) + ".");
				links.add(m.group(3));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
