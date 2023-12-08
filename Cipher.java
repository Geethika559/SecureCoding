import java.io.*;
import java.util.*;
public class Cipher{
public static String encrypt(String message,int shift){
  message=message.toUpperCase();
  String cipherText=" ";
  for(int i=0;i<message.length();i++){
    char ch=(char)(((int)message.charAt(i)+shift-65)%26+65);
    cipherText=cipherText+ch;
  }
  return cipherText;  
}
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);  
    Random random=new Random();
    int min=1;
    int max=25;
    int shift=random.nextInt(max-min+1)+min;
    System.out.println("Enter the string");
    String message=sc.next();
    System.out.println("String: "+message);
    System.out.println("Shift: "+shift);
    System.out.println("Cipher:"+encrypt(message,shift));
    }
  }
  
