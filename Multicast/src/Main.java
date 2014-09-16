/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author lhries
 */
public class Main {
	static InetAddress grupo;
	static MulticastSocket socket;

    public static void main(String[] args) {
        socket = null;

        try{
            grupo = InetAddress.getByName("228.5.6.7");
            socket = new MulticastSocket(6789);
            socket.joinGroup(grupo);
            
            socket.setTimeToLive(255);
            System.out.println(grupo.isMulticastAddress());
            new Thread(new Runnable() {
				
				@Override
				public void run() {
		            String msg="";
		            do{
			            msg = JOptionPane.showInputDialog("Digite a mensagem: ");
			            DatagramPacket mensagemOut = new DatagramPacket(msg.getBytes(), msg.getBytes().length,grupo, 6789);
			            try {
							socket.send(mensagemOut);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		            }while(!msg.toUpperCase().equals("SAIR"));
					
				}
			}).start();
            
            for(int i=0;i<100;i++)
            {
                byte[] buffer = new byte[1000];
                DatagramPacket mensagemIn = new DatagramPacket(buffer, buffer.length);
                
                socket.receive(mensagemIn);
                System.out.println("Recebido de "+InetAddress.getByAddress(mensagemIn.getAddress().getAddress())
                        +" a mensagem: "+new String(mensagemIn.getData()));
            }
            socket.leaveGroup(grupo);
        }catch(SocketException se){System.out.println("Problema no Socket: "+se.getMessage());
        }catch(IOException ie){System.out.println("Problema no I/O: "+ie.getMessage());
        }finally{if(socket!=null) socket.close();
        }
    }
}

 