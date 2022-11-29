import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 CaesarCipherme 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class CaesarCipherme {
    public String encrypt(String input, int key){
    String apha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String aphachange=apha.substring(key);
    aphachange+=apha.substring(0,key);
    String aphalowcase=aphachange.toLowerCase();
    StringBuilder sb= new StringBuilder(input);
    for(int i=0;i<input.length();i++){
        if(apha.indexOf(input.charAt(i))>-1){
            int inew=apha.indexOf(input.charAt(i));
            sb.setCharAt(i,aphachange.charAt(inew));
        }else if(aphalowcase.indexOf(input.charAt(i))>-1){
            int inew=apha.toLowerCase().indexOf(input.charAt(i));
            sb.setCharAt(i,aphalowcase.charAt(inew));
        }
    }
        return sb.toString();
    }
    
    
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, 10);
        System.out.println("key is " + 10 + "\n" + encrypted);
    }
    
    public String encrypt2keys(String input, int key1, int key2){
        String first=encrypt(input,key1);
        String second=encrypt(input,key2);
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<input.length();i++){
            if(i%2==0) ans.append(first.charAt(i));
            if(i%2==1) ans.append(second.charAt(i));
        }
    
        return ans.toString();
    }
    
    public void testCaesar2(){
        
        String encrypted = encrypt2keys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21);
        System.out.println("key is " + "8+21" + "\n" + encrypted);
    }
}
