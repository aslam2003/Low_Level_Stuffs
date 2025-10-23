import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.io.IOException;

public class Client {
    public static void main(String[] args) {
        
        try {
       
            //Create a client socket
            Socket socket=new Socket("localhost",5743);
            System.out.println("Connected to the server!");

            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            output.write("Hello from Client!\n");
            output.flush();

            String message=input.readLine();
            System.out.println("Server says:"+message);

            input.close();
            output.close();
            socket.close();


         } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
