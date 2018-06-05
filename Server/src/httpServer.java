import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class httpServer {
	
	public static void main(String[] args) throws IOException {
		System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
		
		ServerSocket ServSocket = new ServerSocket(0);
		Socket worker = null;
		int portnum = ServSocket.getLocalPort();
		System.out.println(portnum);
		Boolean state = true;
		
		worker = ServSocket.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(worker.getInputStream()));
		
		while(state){
		
		
		
		if(in.equals("close server"))
			state = false;
		System.out.println(in.readLine());
		//Process process = new ProcessBuilder("C:\\Users\\watsondyla\\workspace\\NetClient\\src", ""+portnum).start();
		}
		worker.close();
		ServSocket.close();
		
		}
	}
