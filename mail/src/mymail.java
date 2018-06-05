

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class mymail {

	public static void main(String[] args) throws IOException {
		InetAddress server = InetAddress.getByName("mail.ecs.vuw.ac.nz");
		Socket client = new Socket(server, 25);
		
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		String outString = "HELO bats.ecs.vuw.ac.nz";
		
		out.println(outString);
		
		BufferedReader response = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println(response.readLine());
		
		outString = "MAIL FROM:<watsondyla@ecs.vuw.ac.nz>";
		out.println(outString);
		
		System.out.println(response.readLine());
		
		outString = "RCPT TO:<watsondylan444@gmail.com>";
		out.println(outString);
		
		System.out.println(response.readLine());
		
		outString = "DATA";
		out.println(outString);
		
		out.println("This is my java email");
		response.readLine();
		out.println(".");
		
		System.out.println(response.readLine());
		
	}

}
