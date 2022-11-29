
/**
 * 在这里给出对类 manyGenes 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {

    public int findStopCodon ( String dna, int startIndex, String stopCodon ){
        //This method returns the index of the first occurrence of stopCodon
        //that appears past startIndex and is a multiple of 3 away from 
        //startIndex.
        
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = (currIndex - startIndex) % 3;
            if (diff == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
        }
        return dna.length();
    }
    
    void testFindStopCodon(){
    }
    
    public String findGene(String dna){
        int atgCodon = dna.indexOf("ATG");
        
        if (atgCodon == -1) {
            return "NO ATG CODON FOUND";
        }
        int taaCodon = findStopCodon(dna, atgCodon, "TAA");
        int tagCodon = findStopCodon(dna, atgCodon, "TAG");
        int tgaCodon = findStopCodon(dna, atgCodon, "TGA");
        int tempCodon = Math.min(taaCodon, tagCodon);
        int dnaFin = Math.min(tempCodon, tgaCodon);
        if (dnaFin == dna.length()) {
            return "NO GENE FOUND";
        }
        return dna.substring(atgCodon, dnaFin+3);
    }
    
    void testFindGene(){
    }
    public void prrintAllGenes(){
        String dna= "aaaaaaATGaaaaaaaaaTAGTTATGTAGTAGTAGAaaa"; 
        
        while (true) {
            System.out.println("printing genes" + findGene(dna));
            if (dna.indexOf(findGene(dna)) == -1) {
                break;
            }
            dna=dna.substring(dna.indexOf(findGene(dna))+findGene(dna).length());
            
            
        }
    }
    
    
}
