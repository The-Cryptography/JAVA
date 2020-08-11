/*
* @XOR_cipher
* XOR cipher is a type of additive cipher,an encryption algorithm in this logic, a string of text 
* can be encrypted by applying the bitwise XOR operator to every character using a given key. 
* To decrypt the output, merely reapplying the XOR function with the key will remove the cipher.
*
* code by Rishabh Patel
*/

import java.util.*;
public class XOR_cipher {
    
    //the function xorImplementation is doing the xor of the characters
    //coming from the message with the key
    public static String xorImplementation(String message,char key){
        int len=message.length();
        String text="";
        for(int i=0;i<len;i++)
        {
            char ch=message.charAt(i);
            //doing xor with the key
            text=text+Character.toString((char) (ch^key));
        }
        return text;
    
}
    //main
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String plainText,cipherText="",originalText="";
        char key;
        //taking message from user to be encrypted
        System.out.print("Enter text to encrypt : ");
        plainText=sc.nextLine();
        //taking key as input from user
        System.out.print("Enter one character as key : ");
        key=sc.next().charAt(0);
        //passing message and key to be encrypted
        cipherText=xorImplementation(plainText,key);
        
        System.out.println("***********************************");
        System.out.println("Plain Text : "+plainText);
        System.out.println("Cipher Text : "+cipherText);
        //passing key and cipher text to be decrypted
        originalText=xorImplementation(cipherText,key);
        System.out.println("Original Message : "+originalText);
        System.out.println("***********************************");
        sc.close();
    }
}
