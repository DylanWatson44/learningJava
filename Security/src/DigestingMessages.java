import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class DigestingMessages {

	public static void main(String[] args) throws NoSuchAlgorithmException, GeneralSecurityException, IOException {
		//get my public key from local file
		Path path = Paths.get("publickey");
		byte[] bytes = Files.readAllBytes(path);
		X509EncodedKeySpec ksx = new X509EncodedKeySpec(bytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey pubkey = kf.generatePublic(ksx);
		
		//get my private key from local file
		path = Paths.get("privatekey");
		bytes = Files.readAllBytes(path);
		PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
		kf = KeyFactory.getInstance("RSA");
		PrivateKey prvtkey = kf.generatePrivate(ks);
		
		//get document thats going to be hashed
		path = Paths.get("Hash document");
		byte[] docobytes = Files.readAllBytes(path);
		
		//hash it
		MessageDigest digestor = MessageDigest.getInstance("SHA-1");
		byte[] hash = digestor.digest(docobytes);
		
		String hashstring = new String(hash);
		System.out.println(hashstring);
		
		Cipher mycipher = Cipher.getInstance("RSA");
		mycipher.init(Cipher.ENCRYPT_MODE, prvtkey);
		byte[] EncryptedHash = mycipher.doFinal(hash);
		
		mycipher.init(Cipher.DECRYPT_MODE, pubkey);
		byte[] decryptedHash = mycipher.doFinal(EncryptedHash);
		System.out.println(new String(decryptedHash));
		
	
		

	}

}
