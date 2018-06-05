import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class googleConnect {
	public static void main(String[] args) throws IOException {
		InetAddress serverIP = InetAddress.getByName("google.com");
		int port = 80;

		Socket receiver = new Socket(serverIP, port);

		String request = "GET /robots.txt\r\n\r\n";

		PrintWriter out = new PrintWriter(receiver.getOutputStream(), true);
		out.println(request);
		out.flush();

		BufferedReader in = new BufferedReader(new InputStreamReader(receiver.getInputStream()));
		while (in.readLine() != null) {
			System.out.println(in.readLine());
		}
		
		receiver.close();
	}
}
