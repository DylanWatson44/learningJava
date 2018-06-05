import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class HashServer {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		System.out.println(InetAddress.getLocalHost().getCanonicalHostName());

		ServerSocket ServSocket = new ServerSocket(0);
		Socket worker = null;
		int portnum = ServSocket.getLocalPort();
		System.out.println(portnum);

		worker = ServSocket.accept();
		InputStream in = worker.getInputStream();
		DataInputStream dataIn = new DataInputStream(in);
		
		
		int len = dataIn.readInt();
		System.out.println(len);
		
		byte[] RecHashArray = new byte[len];
		
		
		dataIn.readFully(RecHashArray);
		
		//System.out.println(new String(RecHashArray));
		
		Path path = Paths.get("Timpublickey");
		byte[] bytes = Files.readAllBytes(path);
		
		KeyFactory kf = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec ksx = new X509EncodedKeySpec(bytes);
		PublicKey pub = kf.generatePublic(ksx);
		
		Cipher mycipher = Cipher.getInstance("RSA");
		mycipher.init(Cipher.DECRYPT_MODE, pub);
		byte[] Decrypt = mycipher.doFinal(RecHashArray);
		
		int messagelen = dataIn.readInt();
		byte[] messageArray = new byte[messagelen];
		dataIn.readFully(messageArray);
		
		MessageDigest digestor = MessageDigest.getInstance("SHA-1");
		byte[] myHashArray = digestor.digest(messageArray);
		
		if(myHashArray==Decrypt){
			System.out.println("Success");
		}
		
		
		//worker.close();
		//ServSocket.close();

	}
}
