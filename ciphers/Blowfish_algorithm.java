/*
* Blowfish Algorithm
* Blowfish has a 64-bit block size and a variable key length from 32 bits up to 448 bits.[3] 
* It is a 16-round Feistel cipher and uses large key-dependent S-boxes. In structure it resembles CAST-128, which uses fixed S-boxes. 
* 
* Code by @Anvikshajain
*/

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;
import javax.xml.bind.DatatypeConverter;

public class JBlowfish 
{
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

	// Converts byte array to hex string
	// From: http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java
	public static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for ( int j = 0; j < bytes.length; j++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	public static void main(String[] args) throws Exception
	{

		if ( ( args.length != 2 ) || !( args[0].equals("-e") | args[0].equals("-d") ) )
		{
			System.out.println( "Usage:\n\tjava JBlowfish <-e|-d> <encrypted_password>" );
			return;
		}

		String mode = args[0];

		// Configuration
		byte[] key	= "secret".getBytes();
		String IV  	= "12345678";

		
		System.out.println("-- Settings -----------");
		System.out.println("KEY:\t " + bytesToHex(key));
		System.out.println("IV:\t " + bytesToHex(IV.getBytes()));
		
		// Create new Blowfish cipher
		SecretKeySpec keySpec = new SecretKeySpec(key, "Blowfish"); 
		Cipher cipher = Cipher.getInstance("Blowfish/CBC/PKCS5Padding"); 
		String out = null;

		if ( mode.equals("-e") )
		{
			String secret = args[1];
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, new javax.crypto.spec.IvParameterSpec(IV.getBytes())); 
			byte[] encoding = cipher.doFinal(secret.getBytes());

			System.out.println("-- Encrypted -----------");
			System.out.println("Base64:\t " + DatatypeConverter.printBase64Binary(encoding));
			System.out.println("HEX:\t " + bytesToHex(encoding));
		} 
		else
		{
			// Decode Base64
			byte[] ciphertext = DatatypeConverter.parseBase64Binary(args[1]);

			// Decrypt 
			cipher.init(Cipher.DECRYPT_MODE, keySpec, new javax.crypto.spec.IvParameterSpec(IV.getBytes()));
			byte[] message = cipher.doFinal(ciphertext);

			System.out.println("-- Decrypted -----------");
			System.out.println("HEX:\t " + bytesToHex(message));
			System.out.println("PLAIN:\t " + new String(message));
			 
		}
	}
}	
