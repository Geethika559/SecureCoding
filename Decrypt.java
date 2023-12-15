import java.io.*;
import java.util.*;
public class Decrypt{
  public static final String Alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public static String decrypt(String message,int shift){
    message=message.toUpperCase();
    String decryptedText=" ";
    for(int i=0;i<message.length();i++){
     int charPos=Alphabet.indexOf(message.charAt(i));
     int keyVal=(charPos-shift)%26;
     if(keyVal<0){
       keyVal=Alphabet.length()+keyVal;
     }
     char replacedVal=Alphabet.charAt(keyVal);
     decryptedText+=replacedVal;
   }
   return decryptedText;
  }
  public static void main(String args[]){
      Scanner sc=new Scanner(System.in);  
      System.out.println("Enter the cipher text");
      String message=sc.next();
      System.out.println("Enter the shift key");
      int shift=sc.nextInt();
      System.out.println("CipherText: "+message);
      System.out.println("Shift: "+shift);
      System.out.println("Text:"+decrypt(message,shift));
   }
}
  

