import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.*;
import java.io.*;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class TCPserverSimplest {

	public static void main(String[] args) throws IOException {
	System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
	
	ServerSocket ServSocket = new ServerSocket(0);
	Socket worker = null;
	int portnum = ServSocket.getLocalPort();
	System.out.println(portnum);
	Boolean state = true;
	while(state){
	worker = ServSocket.accept();
	
	BufferedReader in = new BufferedReader(new InputStreamReader(worker.getInputStream()));
	if(in.equals("close server"))
		state = false;
	System.out.println(in.readLine());
	//Process process = new ProcessBuilder("C:\\Users\\watsondyla\\workspace\\NetClient\\src", ""+portnum).start();
	}
	worker.close();
	ServSocket.close();
	
	}
}
