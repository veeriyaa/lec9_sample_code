import java.net.*;
import java.io.*;

public class EchoServer extends Thread {

    protected static boolean serverContinue = true;
    protected Socket clientSocket;
	protected int id;

    public static void main(String[] args) throws IOException {
        int n = 0;
		ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(10008);
            System.out.println("Connection Socket Created");
            try {
                while (serverContinue) {
                    System.out.println("Waiting for Connection");
                    new EchoServer(serverSocket.accept(),n++);
                }
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 10008.");
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Could not close port: 10008.");
                System.exit(1);
            }
        }
    }

    public EchoServer(Socket clientSoc, int id) {
        clientSocket = clientSoc;
		this.id = id;
        start();
    }

    public void run() {
        System.out.println("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client#"+id+" says:"+inputLine);
                if (inputLine.equals("Bye.")) {
					out.println("Bye bye!");
                    break;
                }
				out.println(inputLine);
                if (inputLine.equals("End Server.")) {
                    System.exit(1);
                }
            }
			System.out.println("Client#"+id+" has left.");
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
            System.exit(1);
        }
    }
} 
