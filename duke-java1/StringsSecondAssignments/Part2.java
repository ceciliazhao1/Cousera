
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int count = 0;
        int firstOccur = stringb.indexOf(stringa);
        if (firstOccur > -1) {
            count = count+1;
       
            while (stringb.indexOf(stringa, firstOccur) != -1 && firstOccur != -1) {
                count = count +1;
                firstOccur = stringb.indexOf(stringa, firstOccur+stringa.length());
            }
            count = count -1;
        }else {
            count=0;
        }
        return count;
    }
    public void testHowMany(){
        String stringa = "GAA";
        String stringb = "ATGAACGAATTGAATC";
        howMany(stringa,stringb);
        if (howMany(stringa,stringb) == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println("Last Count is: " + howMany(stringa,stringb));
        }
        stringa = "AA";
        stringb = "ATAAAA";
        howMany(stringa,stringb);
        if (howMany(stringa,stringb) == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println("Last Count is: " + howMany(stringa,stringb));
        }
        stringa = "AA";
        stringb = "ATABABAB";
        howMany(stringa,stringb);
        if (howMany(stringa,stringb) == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println("Last Count is: " + howMany(stringa,stringb));
        }
        stringa = "ACAB";
        stringb = "AAAAACABACABAAAACABACABAA";
        howMany(stringa,stringb);
        if (howMany(stringa,stringb) == 0) {
            System.out.println("no occurrence found");
        }
        else{
            System.out.println("Last Count is: " + howMany(stringa,stringb));
        }
        }
}



/*"GAA" -- "ATGAACGAATTGAATC"
si indexof es  > -1 , count = count +1
while indexof(gaa,anterior) > -1 count = count +1
return count;
else return -1(?)*/