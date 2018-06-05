import java.security.*;

public class Exercise1 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		generator.initialize(1024);
		long starttime = 0;
		long endtime = 0;
		int loops = 1;
		long diff = 0;
		long avg = 0;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		
		loops =2;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		loops=3;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		loops=4;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		loops = 5;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		loops=6;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		loops=7;
		
		starttime = System.currentTimeMillis();
		for(int i = 0; i<loops;i++){
		KeyPair keys = generator.generateKeyPair();
		
		
		}
		endtime = System.currentTimeMillis();
		System.out.println("Loop number: " + loops);
		diff = endtime-starttime;
		avg = diff/loops;
		System.out.println(starttime +"\n"+endtime +"\n" +diff +"\n" + avg );
		System.out.println();
		
	}

}
