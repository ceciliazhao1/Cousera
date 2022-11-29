
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    public String findSimpleGene(String dna){
        String ans="";
        if(dna.indexOf("ATG")>-1){
            int index1=dna.indexOf("ATG");
            
            if(dna.indexOf("TAA")>index1){
                int index2= dna.indexOf("TAA");
                if((index2-index1)%3==0)
                    return dna.substring(index1,index2+3);
            }else{
                return ans;
            }
        }else {
            return ans;
        }
        return ans;
    }
    void testSimpleGene(){
        String dna1="TGTGTGTGTGTAATTTTTT";//NO ATG
        System.out.println("NO ATG"+findSimpleGene(dna1));
        String dna2="TGTGTATGTGTGGTGGTGG";//NO TAA
        System.out.println("NO TAA"+findSimpleGene(dna2));
        String dna3="TGAGTGTGTGTGGTGGTGG";//WITH no ATG TAA
        System.out.println("WITH ATG TAA"+findSimpleGene(dna3));
        String dna4="TAAGTATGTGTAATGGTGG";//MULTIPLE OF 3
        System.out.println("MULTIPLE OF 3"+findSimpleGene(dna4));
        String dna5="TAAGTATGTGGGTAATGGTGG";//NO MULTIPLE OF 3
        System.out.println("no MULTIPLE OF 3"+findSimpleGene(dna5));
        
        System.out.println("quiz"+findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC"));
    }
}
