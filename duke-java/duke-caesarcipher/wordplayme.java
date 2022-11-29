import java.io.*;
/**
 * 在这里给出对类 wordplayme 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class wordplayme {

    
    public boolean IsVowel(char ch){
        ch= Character.toLowerCase(ch);
        if(ch == 'a' ||ch == 'e'|| ch == 'i'|| ch == 'o'||ch == 'u'){
            return true;
        }
        return false;
    }
    public void test_isVowel(){
        char test1 = 'e';
        char test2 = 'a';
        char test3 = 'B';
      System.out.println("Is " +test1 + " vowel " + IsVowel(test1));
      System.out.println("Is " +test2 + " vowel " + IsVowel(test2));
      System.out.println("Is " +test3 + " vowel " + IsVowel(test3));
    }
    public String replaceVowels(String s, char ch){
        StringBuilder sb = new StringBuilder (s);
        for(int i=0;i<s.length();i++){
            if(IsVowel(sb.charAt(i))){
                sb.setCharAt(i,ch);
            }
        }
        return sb.toString();
    }
    
    public void test_replaceVowels(){
    System.out.println("Hello World" + " " + replaceVowels("HELLO World",'*'));    
    }
    
    public String emphasize(String s, char ch){
        int index=s.indexOf(ch);
        StringBuilder sb = new StringBuilder (s);
        for(int i=0;i<s.length();i++){
            if(Character.toLowerCase(sb.charAt(i))==ch && i%2==0){
                sb.setCharAt(i,'*');
            }
            if(Character.toLowerCase(sb.charAt(i))==ch && i%2==1){
                sb.setCharAt(i,'+');
            }
        }
        
        return sb.toString();
    }
    public void test_emphasize(){
    String test1 = "dna ctgaaactga";
    String test2 = "Mary Bella Abracadabra";
    System.out.println(test1);
    System.out.println(emphasize(test1,'a'));
    System.out.println(test2);
    System.out.println(emphasize(test2,'a'));
    }
    
   
}
