import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.io.*;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class TCPclient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		  String sentence;
		  int port = Integer.parseInt(args[0]);
		  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		  Socket clientSocket = new Socket(InetAddress.getLocalHost(), port);
		  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		  sentence = inFromUser.readLine();
		  outToServer.writeBytes(sentence + '\n' );
		 
		  clientSocket.close();
	}

}
