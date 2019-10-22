/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SİMAY
 */
public class server {
     public static void main(String[] args) throws IOException {
          String clientGelen;
          ServerSocket serverSocket = null;
          Socket clientSocket = null;

          int sayi;

          try {
               //*Server 7755 portundan Client'ı dinliyor *//
               serverSocket = new ServerSocket(6959);
          } catch (Exception e) {
               System.out.println("Port Hatası!");
          }
          System.out.println("SERVER BAŞLANTI İÇİN HAZIR...");
          clientSocket = serverSocket.accept();
 
          //* Client'a veri gönderimi için kullandığımız PrintWriter nesnesi oluşturulur *//
          PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 
          //* Client'dan gelen verileri tutan BufferedReader nesnesi oluşturulur *//
          BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
          while((clientGelen = in.readLine()) != null) {
               System.out.println("Client'dan gelen veri = " + clientGelen);
               sayi = Integer.valueOf(clientGelen);
               out.println(sayi*sayi);
          }
          out.close();
          in.close();
          clientSocket.close();
          serverSocket.close();
    
}
}