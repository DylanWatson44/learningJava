import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SaveKeys {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		KeyPair keys = generator.generateKeyPair();
		
		PublicKey publickey = keys.getPublic();
		PrivateKey privatekey = keys.getPrivate();
		
		PrintStream printer = new PrintStream(new File("publickey"));
		printer.write(publickey.getEncoded());
		
		printer = new PrintStream(new File("privatekey"));
		printer.write(privatekey.getEncoded());
	}

}
