import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.spec.PKCS8EncodedKeySpec;

public class SendingAHash {

	public static void main(String[] args) {
		Path path = Paths.get("privatekey");
		byte[] privatekey = Files.readAllBytes(path);
		
		PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(privatekey);
		

	}

}
