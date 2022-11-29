
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part2 {
    public String findSimpleGene(String dna, int start, int stop){
        String ans="";
        boolean big=true;
        if(dna.indexOf("a")>-1){
            dna=dna.toUpperCase();
            big = false;
        }
        if(dna.indexOf("ATG")>-1){
            int index1=dna.indexOf("ATG");
            
            if(dna.indexOf("TAA")>index1){
                int index2= dna.indexOf("TAA");
                if((index2-index1)%3==0){
                    if(big){
                        return dna.substring(index1,index2+3);
                    }else{
                        dna=dna.toLowerCase();
                        return dna.substring(index1,index2+3);
                    }
                }else{
                    return ans;
                }
            }else {
                return ans;
            }
        }
        
        return ans;
    }
    void testSimpleGene(){
        String dna1="TGTGTGTGTGTAATTTTTT";//NO ATG
        System.out.println("NO ATG"+findSimpleGene(dna1,0,dna1.length()-1));
        String dna2="TGTGTATGTGTGGTGGTGG";//NO TAA
        System.out.println("NO TAA"+findSimpleGene(dna2,0,dna2.length()-1));
        String dna3="TGAGTGTGTGTGGTGGTGG";//WITH no ATG TAA
        System.out.println("WITH ATG TAA"+findSimpleGene(dna3,0,dna3.length()-1));
        String dna4="TAAGTATGTGTAATGGTGG";//MULTIPLE OF 3
        System.out.println("MULTIPLE OF 3"+findSimpleGene(dna4,0,dna4.length()-1));
        String dna5="TAAGTATGTGGGTAATGGTGG";//NO MULTIPLE OF 3
        System.out.println("no MULTIPLE OF 3"+findSimpleGene(dna5,0,dna5.length()-1));
        
        System.out.println("quiz"+findSimpleGene("AAATGCCCTAACTAGATTAAGAAACC",0,25));
    }
}
