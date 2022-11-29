import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 caesarbreakerme 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class caesarbreakerme {
public int [] countLetters(String message ){
    int [] counts = new int [26];
    for (char cha : message.toLowerCase().toCharArray()) {// process each char
            int num=cha-'a';
            if(num<26 && num>=0){
                counts[num]++;
            }
    }
    
    return counts;
}

public int maxIndex(int [] values){
    int maxLength =0;
        int indexOfMax =0;
        
        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
    return indexOfMax;
}

public String decrypt(String encrypted){
    CaesarCipherme cc = new CaesarCipherme();
    int key=getKey(encrypted);
    return cc.encrypt(encrypted, (26 - key));
}

public void testDecrypt(){
    FileResource fr= new FileResource();
    String encrypted= fr.asString();
    System.out.println(decrypt(encrypted));
}

public String halfofstrings( String message , int ind){
    String s="";
    for (int i=0;i<message.length();i++){
        if(i%2==ind)
            s+=message.charAt(i);

    }
    return s;
}
 


public int getKey (String s){
       int[] freqs = countLetters(s);
       int maxDex = maxIndex(freqs);
       int dkey = maxDex-4;
       if (maxDex < 4) {
           dkey = 26 - (4-maxDex);
        }
    return dkey;
}

public void decryptTwoKeys (String encrypted){
    String s1=halfofstrings(encrypted,0);

    String s2=halfofstrings(encrypted,1);
    
    String ss1=decrypt(s1);
    String ss2=decrypt(s2);
    StringBuilder sb= new StringBuilder();
    if(ss1.length()==ss2.length()){
        for(int i=0;i<ss1.length();i++){
            sb.append(ss1.charAt(i));
            sb.append(ss2.charAt(i));
        }
    }
    if(ss1.length()>ss2.length()){
        for(int i=0;i<ss2.length();i++){
            sb.append(ss1.charAt(i));
            sb.append(ss2.charAt(i));
        }
        sb.append(ss1.charAt(ss1.length()-1));
    }
    System.out.println(sb.toString());
}

void testfile2key(){
    FileResource fr= new FileResource();
    decryptTwoKeys (fr.asString());
}
}
