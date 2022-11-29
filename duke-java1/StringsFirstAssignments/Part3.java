
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part3 {
    public boolean twoOccurrences(String a, String b){
        if(b.indexOf(a)>-1){
            int pos2 =b.indexOf(a,b.indexOf(a)+1);
            if(pos2>-1)
                return true;
        }
        return false;
    }
    public String lastPart(String a, String b){
        if(b.indexOf(a)>-1){
            b=b.substring(b.indexOf(a)+a.length());
            return b;
        }
        return b;
    }
            
    void testString(){
        System.out.println("expected:true:"+ twoOccurrences("an","banana"));
        System.out.println("expected:false:"+ twoOccurrences("zoo","forest"));
        System.out.println("expected:ana:"+lastPart ("an","banana"));
        System.out.println("expected:forest:"+lastPart ("zoo","forest"));
    }
}
