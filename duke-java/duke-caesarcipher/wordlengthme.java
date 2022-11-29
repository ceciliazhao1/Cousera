import edu.duke.*;
/**
 * 在这里给出对类 wordlengthme 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class wordlengthme {

    
    public void countWordLengths(FileResource fr, int []counts){
        int count=0;
        for (String word : fr.words()) {// process each word in turn
            count=word.length();
            if(Character.isLetter(word.charAt(0))==false){
                count=count-1;
            }
            if(Character.isLetter(word.charAt(word.length()-1))==false){
                count=count-1;
            }
            counts[count]++;    
        }
        
    }
    public int indexOfMax(int []values){
        int index=0;
        for(int i=0;i<31;i++){
            if(values[i]>index)
                index=values[i];
        }
        return index;
    }
    void test(){
        int counts[] = new int [31];
        
        FileResource fr = new FileResource();
        countWordLengths(fr,counts);
        for(int i=0;i<31;i++){
            System.out.println("wordlength of "+i+" is "+ counts[i]);
        }
        System.out.println(indexOfMax(counts));
    }
}
