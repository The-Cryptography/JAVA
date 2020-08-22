/*
* Base64_cipher
* Base 64 is an encoding scheme that converts binary data into text format 
* so that encoded textual data can be easily transported over network un-corrupted and without any data loss.(
* @Code by Rishabhpatel803
*/
import java.util.*;
public class base64_cipher {

    //encrypt function to encrypt the original message
    public static String encrypt(String message)
    {
        //Base64 class function used to encrypt the string
        //getEncoder() is used to get encoder of Base64 class 
        //and encodeToString() is encoding the received message to string
        //getBytes() is used to convert original message to byte
        String cipher=Base64.getEncoder().encodeToString(message.getBytes());
        return cipher;
    }

    //decrypt function to decrypt the encoded message
    public static String decrypt(String message)
    {
        //getDecoder() is used to get Decoder instance from Base64 class
        //decode() is used to decode the encrypted message to bytes
        byte[] actualmsg=Base64.getDecoder().decode(message);
        //converting byte array to string
        String plain=new String(actualmsg);
        return plain;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        System.out.print("Enter text to be encrypted : ");
        String plainMSG=sc.nextLine();
        String cipher=encrypt(plainMSG);
        
        System.out.println("Encrypted Message : "+cipher);
        System.out.println("Decrypted Message : "+decrypt(cipher));
        
        sc.close();
    }
}
