import java.util.*;

class Vigenere {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Key: ");
        String key = scan.nextLine();
        System.out.print("Encrypt/Decrypt (e/d): ");
        String doesEncrypt = scan.nextLine();
        if(doesEncrypt.equals("e")){
           System.out.print("plaintext: ");
           String plaintext = scan.nextLine();
           System.out.println("encrypted text:" + encrypt(key,plaintext));
       } else {
           System.out.print("cyphertext: ");
           String cyphertext = scan.nextLine();
           System.out.println("plaintext: " + decrypt(key,cyphertext));
       }    
    }
    
    private static String encrypt(String key, String plain){
      String retur = "";
      int index = 0;
      for(char c : plain.toCharArray()){
         int intValue = (int)c - (int)'a' + 1;
         int keyValue = (int)key.charAt(index++ % key.length()) - (int)'a' + 1;
         int newValue = (intValue + keyValue)%26 + (int)'a' - 1;
         retur += (char)newValue;
      }
      return retur;
    }
    private static void f(String in){System.out.println(in);}
    // encrypt is the exact same as encrpyt but it subtracts the key
    // it also adds 26 before mod to make sure it isn't negative
    private static String decrypt(String key, String encr){
      String retur = "";
      int index = 0;
      for(char c : encr.toCharArray()){
         int intValue = (int)c - (int)'a' + 1;
         int keyValue = (int)key.charAt(index++ % key.length()) - (int)'a' + 1;
         int newValue = (26 + intValue - keyValue)%26 + (int)'a' - 1;
         retur += (char)newValue;
      }
      return retur;
    }
    
}