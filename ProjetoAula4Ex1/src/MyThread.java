import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MyThread implements Runnable{

	private String caminho;
	public MyThread(String caminho)
	{
		this.caminho = caminho;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileReader file;
		try {
			file = new FileReader(caminho);
			BufferedReader reader = new BufferedReader(file);
			String linha = reader.readLine();
			while(linha!=null)				
			{
				System.out.println(linha);
				linha = reader.readLine();
			}
			reader.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
