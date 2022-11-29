import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 Part4 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part4 {
    
public void method(){
    int tryCount = 10;
    
    while (tryCount > 0) {
        try {
            URLResource ur= new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html"); 
            for(String s: ur.words()){
                String pre=s;
                s=s.toLowerCase();
                if(s.indexOf("youtube.com")>-1){
                    int beg = s.lastIndexOf("\"",s.indexOf("youtube.com"));
                    int end = s.indexOf("\"", s.indexOf("youtube.com")+1);
                    System.out.println(pre.substring(beg+1,end));
                }
            }
            break;
        } catch (Exception e) {
            tryCount--;
        }
    }
    

}
        
}
