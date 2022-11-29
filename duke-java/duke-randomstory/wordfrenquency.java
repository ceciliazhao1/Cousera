import java.util.*;
import edu.duke.*;
/**
 * 在这里给出对类 wordfrenquency 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class wordfrenquency {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public wordfrenquency(){
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    public void findunique(){
        myWords.clear();
        myFreqs.clear();
        FileResource fr = new FileResource();
        for(String s: fr.words()){
            s = s.toLowerCase();
            if(myWords.indexOf(s)==-1){
                myWords.add(s);
                myFreqs.add(1);
            }else{
                int value= myFreqs.get(myWords.indexOf(s));
                myFreqs.set(myWords.indexOf(s),value+1);
            }
        }
    }
    
    public int findIndexOfMax(){
        int ans= myFreqs.get(0);
        String ansname= myWords.get(0);
        for(int i =0;i<myFreqs.size();i++){
            if(myFreqs.get(i)>ans){
                ans=myFreqs.get(i);
                ansname=myWords.get(i);
            }
        }
        System.out.println(ansname + "" +ans);
        return ans;
    }
    
    public void tester(){
        findunique();
        
        for(int i=0; i < myWords.size(); i++){
            System.out.println(myWords.get(i) + "\t" + myFreqs.get(i));
        }
        findIndexOfMax();
        System.out.println("Number of unique words: " + myWords.size());
    }
    
}
