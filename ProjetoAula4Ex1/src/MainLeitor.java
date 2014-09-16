import javax.swing.JOptionPane;


public class MainLeitor {

	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			String caminho = JOptionPane.showInputDialog("Caminho:");
			MyThread minhaThread = new MyThread(caminho);
			new Thread(minhaThread).start();//Utilizando Threads
			//minhaThread.run();//Rodando direto
		}

	}

}
