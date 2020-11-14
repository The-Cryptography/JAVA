/*
* Rail fence cipher
* The rail fence cipher (also called a zigzag cipher) is a form of transposition cipher. 
* It derives its name from the way in which it is encoded.
* 
* Code by @Rishabhpatel803
*/
class RailFenceBasic {
  int depth;

  String Encryption(String plainText, int depth) throws Exception {
    int r = depth, len = plainText.length();
    int c = len / depth;
    char mat[][] = new char[r][c];
    int k = 0;

    String cipherText = "";

    for (int i = 0; i < c; i++) {
      for (int j = 0; j < r; j++) {
        if (k != len)
          mat[j][i] = plainText.charAt(k++);
        else
          mat[j][i] = 'X';
      }
    }
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        cipherText += mat[i][j];
      }
    }
    return cipherText;
  }

  String Decryption(String cipherText, int depth) throws Exception {
    int r = depth, len = cipherText.length();
    int c = len / depth;
    char mat[][] = new char[r][c];
    int k = 0;

    String plainText = "";

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        mat[i][j] = cipherText.charAt(k++);
      }
    }
    for (int i = 0; i < c; i++) {
      for (int j = 0; j < r; j++) {
        plainText += mat[j][i];
      }
    }

    return plainText;
  }
}

class RailFence {
  public static void main(String args[]) throws Exception {
    RailFenceBasic rf = new RailFenceBasic();
    int depth = 3;

    String plainText = "railfencecipher";

    String cipherText = rf.Encryption(plainText, depth);
    System.out.println("Encrypted text is:\n" + cipherText);

    String decryptedText = rf.Decryption(cipherText, depth);

    System.out.println("Decrypted text is:\n" + decryptedText);

  }
}
