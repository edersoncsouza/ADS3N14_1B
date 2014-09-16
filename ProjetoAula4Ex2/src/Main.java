import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		for(int i=0;i<3;i++){
			String url = JOptionPane.showInputDialog("URL:");
			RequisitorPaginaHTML requisitor = new RequisitorPaginaHTML(url);
			new Thread(requisitor).start();
		}
	}
}
