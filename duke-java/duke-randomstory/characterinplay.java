import java.util.*;
import edu.duke.*;
/**
 * 在这里给出对类 characterinpaly 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class characterinplay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;
    
    public characterinplay(){
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    public void findAllCharacters(){
        FileResource f = new FileResource();
        for (String s: f.lines()){
            if(s.indexOf('.')>-1){
                update(s.substring(0,s.indexOf('.')));
            }
        }
    }   
    public void update(String person){
        if (names.indexOf(person)== -1){
            names.add(person);
            counts.add(1);
        }else{
            int index=names.indexOf(person);
            counts.set(index,counts.get(index)+1);
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for(int i=0;i<names.size();i++){
            if(counts.get(i)>num1 && counts.get(i)<num2) 
                System.out.println(names.get(i));
        }
    }
    public void tester(){
        counts.clear();
        names.clear();
        findAllCharacters();
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) > 1){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10,15);
    }
}
