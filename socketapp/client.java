
package socketapp;
   import java.io.*;
   import java.net.*;
 

public class client {
     public static void main(String[] args) throws IOException {
          islem();
     }
 
     public static void islem() throws UnknownHostException, IOException {
          Socket socket = null;
          PrintWriter out = null;
          BufferedReader in = null;
          String deger;
          try {
              
               socket = new Socket("127.0.0.1",6959);
          }
          catch (Exception e) {
               System.out.println("Port Hatası!");
          }

          out = new PrintWriter(socket.getOutputStream(), true);
          in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          
          System.out.println("Server'a gönderilecek sayısı giriniz:");
          BufferedReader data = new BufferedReader(new InputStreamReader(System.in));
          
           while((deger = data.readLine()) != null) {
               out.println(deger);
               System.out.println("Server'dan gelen sonuç = " + in.readLine());
               System.out.println("Server'a gönderilecek saysı giriniz");
          }
          out.close();
          in.close();
          data.close();
          socket.close();
     }
          
     }
        