import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class encrypting {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidKeySpecException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
	Cipher mycipher = Cipher.getInstance("RSA");
	
	Path path = Paths.get("privatekey");
	byte[] bytes = Files.readAllBytes(path);
	
	PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
	KeyFactory kf = KeyFactory.getInstance("RSA");
	PrivateKey pvt = kf.generatePrivate(ks);
	//System.out.println(pvt);
	
	path = Paths.get("publickey");
	bytes = Files.readAllBytes(path);
	
	X509EncodedKeySpec ksx = new X509EncodedKeySpec(bytes);
	PublicKey pub = kf.generatePublic(ksx);
	
	
	mycipher.init(mycipher.ENCRYPT_MODE, pub);
	String topsecretstring = "Super secret stuff.";
	byte[] byto = mycipher.doFinal(topsecretstring.getBytes());
	System.out.println(new String(byto));
	
	mycipher.init(mycipher.DECRYPT_MODE, pvt);
	byto = mycipher.doFinal(byto);
	String decryptedString = new String(byto);
	System.out.println(decryptedString);
	

	}

}
