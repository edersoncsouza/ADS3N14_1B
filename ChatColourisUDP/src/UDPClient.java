/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ederson
 */
import java.net.*;
import java.io.*;

public class UDPClient {

    public static void main(String args[]) {
// args give message contents and server hostname
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            //byte[] m = args[0].getBytes();
            byte[] m = "Hello World!".getBytes();
            //InetAddress aHost = InetAddress.getByName(args[1]);
            InetAddress aHost = InetAddress.getByName("localhost");
            int serverPort = 6789;
            //DatagramPacket request = new DatagramPacket(m, m.length(), aHost, serverPort);
            DatagramPacket request = new DatagramPacket(m, "Hello World!".length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }
}
