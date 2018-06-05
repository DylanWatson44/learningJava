import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UDP {

static String message = "Hello";	

	

	public static void main(String[] args) throws IOException{
	
	DatagramSocket socket = new DatagramSocket();	

	
	String server = args[0];
	
	int port = Integer.parseInt(args[1]);

	
	// create byte array for putting into UDP packets.
	
	
		byte[] buf = message.getBytes();
	
	
		// lookup the server's IP address
		

		InetAddress address = InetAddress.getByName(server);
	
	
	// Create the datagram packet
		
	
	DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);

	
	// Send it into the socket
		

		socket.send(packet);

	
	// Be a tidy Kiwi
	        
	
	socket.close();
	}

}

		
