import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatCliente
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  JTextField textoParaEnviar;
  Socket socket;
  PrintWriter escritor;
  static String nome;
  static String ip;
  JTextArea textoRecebido;
  Scanner leitor;
  
  private class EscutaServidor
    implements Runnable
  {
    private EscutaServidor() {}
    
    public void run()
    {
      try
      {
        String texto;
        while ((texto = ChatCliente.this.leitor.nextLine()) != null) {
          ChatCliente.this.textoRecebido.append(texto + "\n");
        }
      }
      catch (Exception e) {}
    }
  }
  
  public ChatCliente(String nome, String ip)
  {
    super("Chat : " + nome);
    nome = nome;
    
    Font fonte = new Font("Serif", 0, 26);
    this.textoParaEnviar = new JTextField();
    this.textoParaEnviar.setFont(fonte);
    JButton botao = new JButton("Enviar");
    botao.setFont(fonte);
    botao.addActionListener(new EnviarListener());
    Container envio = new JPanel();
    envio.setLayout(new BorderLayout());
    envio.add("Center", this.textoParaEnviar);
    envio.add("East", botao);
    
    this.textoRecebido = new JTextArea();
    this.textoRecebido.setFont(fonte);
   
    textoRecebido.setEditable(false); // Bloqueia a edição das mensagens recebidas
    
 // Adiciona o action Listener pra receber o Enter Dado
    textoParaEnviar.addActionListener(new EnviarListener());
    
    JScrollPane scroll = new JScrollPane(this.textoRecebido);
    
    getContentPane().add("Center", scroll);
    getContentPane().add("South", envio);
    
    configurarRede(ip);
    
    setDefaultCloseOperation(3);
    setSize(500, 500);
    setVisible(true);
    
    this.textoParaEnviar.requestFocus();
  }
  
  private class EnviarListener
    implements ActionListener
  {
    private EnviarListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      ChatCliente.this.escritor.println(ChatCliente.nome + " : " + ChatCliente.this.textoParaEnviar.getText());
      ChatCliente.this.escritor.flush();
      ChatCliente.this.textoParaEnviar.setText("");
      ChatCliente.this.textoParaEnviar.requestFocus();
    }
  }
  
  private void configurarRede(String ip)
  {
    try
    {
      this.ip = ip;
      
      this.socket = new Socket(ip, 5000);
      this.escritor = new PrintWriter(this.socket.getOutputStream());
      this.leitor = new Scanner(this.socket.getInputStream());
      new Thread(new EscutaServidor()).start();
    }
    catch (Exception e) {}
  }
  
  public static void main(String[] args)
  {
    ip = JOptionPane.showInputDialog(null, "Digite o IP do servidor");
    nome = JOptionPane.showInputDialog(null, "Digite seu nome:");
    new ChatCliente(nome, ip);
  }
}
