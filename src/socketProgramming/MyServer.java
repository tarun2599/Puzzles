package socketProgramming;
import java.net.*;
import java.io.*;
 
public class MyServer
{
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    public DataInputStream in       =  null;
    public DataOutputStream out = null;
    
    // constructor with port
    public MyServer(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            
            out = new DataOutputStream(socket.getOutputStream());
 
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    
    public String readNext() {
    	String line = "";
    	try{
            line = in.readUTF();
        }catch(IOException e){
            System.out.println(e);
        }
    	return line;
    }
    
    public void println(String str) {
    	try {
			out.writeUTF(str);
		} catch (IOException e) {
			System.out.println(e);
		}
    }
    public static void main(String args[])
    {
        MyServer server = new MyServer(5000);
        String input;
        do {
        	server.println("Server: Send me a message...");
        	input = server.readNext();
        	System.out.println(input);
        }
        while(!input.equalsIgnoreCase("Over"));
    }
}