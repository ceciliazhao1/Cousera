
/**
 * 在这里给出对类 testquiz 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class testquiz {
public void findAbc(String input) {
    int index = input.indexOf("abc");
    while (true) {
        if (index == -1) {
            break;
        }
        if(index+2 >= input.length()-1) break;
        String found = input.substring(index+1, index+4);
        System.out.println(found);
        index = input.indexOf("abc", index+4);
    }
}
   public void test() {
    //no code yet
     
     findAbc("yabcyabc");
     //findAbc("eusabce");
     //findAbc("aaaaabc");
     //findAbc("abcbbbabcdddabc");
     findAbc("woiehabchi");
     //findAbc("abcdefabcghi");
}
}
