/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_client;

//import org.json.simple.*;
import com.google.gson.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import static json_client.Fighter.*;
import static json_client.Network.*;
//import com.google.gson.Gson;

public class JSON_client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException{   
        Fighter figter1 = new Fighter();
        //Fighter figter2 = new Fighter();
                     
        //System.out.println("Первый игрок");
        figter1.printFighters();
        /*System.out.println("Второй игрок");
        figter2.printFighters();
        battleRun(figter1,figter2);
                
        figter2=JSONinFighter(createJSON(figter1));
        writeFile(createJSON(figter1),"message.js");
        readFile("message.js");*/
           
        
        Scanner scanner = new Scanner(System.in);      
        System.out.println("Введите номер порта 3345 или 3346");
        int port = scanner.nextInt();
        Socket socket;
        //try{
            socket = new Socket("localhost", port);
            //if(socket.isOutputShutdown()){socket = new Socket("localhost", 3346);}
            //if(socket.isClosed()){socket = new Socket("localhost", 3346);}
        /*}catch(java.net.ConnectException e){
            socket = new Socket("localhost", 3346);
        }*/
        
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры.
           // BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = createJSON(figter1);
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
            System.out.println();

            //while (true) {
                //line = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.                
                out.flush(); // заставляем поток закончить передачу данных.
                
                line = in.readUTF();// ждем пока сервер отошлет строку текста.
                System.out.println("The server was very polite. It sent me this : " + line);
                //System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
               // out
            //}
            /*outputStream.writeObject("C:\\my documents\\NetBeansProjects\\la1 client_server\\MatrixA.out");
            outputStream.writeObject("C:\\my documents\\NetBeansProjects\\la1 client_server\\MatrixB.out");
            Object object = inputStream.readObject();*/
    }                      
}
    

