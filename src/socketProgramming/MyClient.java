package socketProgramming;
// A Java program for a Client
import java.net.*;
import java.util.Scanner;
import java.io.*;
 
public class MyClient
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  in  = null;
    private DataOutputStream out     = null;
 
    // constructor to put ip address and port
   
	public MyClient(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            // takes input from terminal
            in  = new DataInputStream(
            		new BufferedInputStream(socket.getInputStream()));
 
            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
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
        MyClient client = new MyClient("172.17.65.96", 5000);
        Scanner s = new Scanner(System.in);
        // string to read message from input
        String msgSend = "";
        String msgRecieved = "";
        // keep reading until "Over" is input
        do 
        {
        	msgRecieved = client.readNext();
        	System.out.println(msgRecieved);
        	msgSend = s.nextLine();
        	client.println(msgSend);
        }while(!msgSend.equals("Over"));
        s.close();
    }
}