
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class Server{
    public static void main(String[] args) {
        
        try {
            //Create a server socket on a specific port
            ServerSocket serversocket=new ServerSocket(5743);
            System.out.println("Server socket started,waiting for client connections.....");

            //Socket accepts client's connection requests
            Socket socket=serversocket.accept();
            System.out.println("Client connected!");

            //Input and output streams for communication
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String message=input.readLine();
            System.out.println("Client:"+message);

            output.write("Hello from server!\n");
            output.flush();

            socket.close();
            input.close();
            output.close();
            serversocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}