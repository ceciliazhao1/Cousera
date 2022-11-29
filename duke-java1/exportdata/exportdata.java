 import edu.duke.*;
 import org.apache.commons.csv.*;
 import java.io.File;
 
/**
 * 在这里给出对类 exportdata 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class exportdata {
    void tester(){
        FileResource fr = new FileResource("exports/exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        String s=countryInfo (parser,"Nauru");
        System.out.println(s);
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser,"cotton","flowers");
        parser = fr.getCSVParser();
        int num=numberOfExporters(parser,"cocoa");
        System.out.println(num);
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
    
    
    public String countryInfo (CSVParser parser, String country){
       String ss= "";
       int count=0;
       for (CSVRecord csvRecord : parser) {
           if(csvRecord.get(0).equals(country)){
               for(String s: csvRecord){ // record : list<String>
                   if(count==2){
                        ss+=s;
                        return ss;
                    }else{
                        ss+=s;
                        ss+=":";
                        count++;
                    }
                }
            }
               
        }
        return "not found" ;
    }
    public void listExportersTwoProducts (CSVParser parser, String exportItem1, String exportItem2){
       
       int i=0;
       for (CSVRecord csvRecord : parser) {
           if(csvRecord.get(1).indexOf(exportItem1)>-1 && csvRecord.get(1).indexOf(exportItem2)>-1){              
               System.out.println(csvRecord.get(0));
            }
               
        }
    }
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count=0;
        for (CSVRecord csvRecord : parser) {
            if(csvRecord.get("Exports").contains(exportItem)){
                count++;
            }
        }
        
        return count;
    }
    public void bigExporters(CSVParser parser, String dollar){
        
        for (CSVRecord csvRecord : parser) {
            if(csvRecord.get("Value (dollars)").length()>dollar.length()){
                System.out.println(csvRecord.get(0)+" "+ csvRecord.get(2));
            }
        }
    }
        
        
        
}
