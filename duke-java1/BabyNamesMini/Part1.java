import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Part1 {
    void test(){
        FileResource fr= new FileResource("us_babynames_by_year/yob1900.csv");
        System.out.println(totalbirth(fr.getCSVParser(false)));
    }
    
    public int totalbirth(CSVParser parser){
        int girlnum=0;
        int boynum=0;
        int girlname=0;
        int boyname=0;
        for(CSVRecord record: parser){
            if(record.get(1).equals("F")){
                girlnum+=Integer.parseInt(record.get(2));
                girlname++;
            }
            if(record.get(1).equals("M")){
                boynum+=Integer.parseInt(record.get(2));
                boyname++;
            }
            
        }
        System.out.println("girls names "+girlname);
        System.out.println("boyss names "+ boyname);
        System.out.println("names "+girlname+boyname);
        return girlnum+boynum;
    }
    void test4(){
        System.out.println(getRank(1971,"Frank","M"));
    }
    public int getRank (int year, String name, String gender){
        int rank=0;
        String nam="us_babynames_by_year/yob"+year+".csv";
        FileResource fr= new FileResource(nam);
        
        for(CSVRecord record: fr.getCSVParser(false)){
            if(record.get(1).contains(gender)){
                rank++;
                if(record.get(0).equals(name)){
                    return rank;
                }
            }
            
        }
        return -1;
    }
    
    public String getName(int year, int rank, String gender){
        String ansname=null;
        
        String nam="us_babynames_by_year/yob"+year+".csv";
        FileResource fr= new FileResource(nam);
        
        for(CSVRecord record: fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                rank--;
                if(rank==0){
                    return record.get(0);
                }
            }
           
            
        }
        return "no name";
    }
    public void whatIsNameInYear(String name,int year, int newyear, String gender){
        int rank= getRank(year,name,gender);
        String newname=getName(newyear,rank,gender);
        System.out.println(name +"is born in"+year+"would be"+newname +"if in" + newyear);
    }
    public int yearOfHighestRank (String name,String gender){
        int rank=1000000000;
        int ranknow=0;
        int year=0;
        for(int i=1880;i<2015;i++){
            ranknow=getRank(i,name,gender);
            
            if(ranknow<rank && ranknow!=-1 ){
                rank=ranknow;
                year=i;
            }
        }
        if(rank==1000000000)
            return -1;
        System.out.println(year);
        return rank;
    }
    public void test2(){
        System.out.println(yearOfHighestRank ("Mich","M"));
        System.out.println(yearOfHighestRank ("Genevieve","F"));
    }
    public double getAverageRank(String name,String gender){
        
        int ranknow=0;
        int sum=0;
        for(int i=1880;i<2015;i++){
            ranknow=getRank(i,name,gender);
            if(ranknow==-1){
                continue;
            }
            
            sum+=ranknow;
            
        }
        return (double)sum/135;
    }
    void test3(){
        System.out.println(getAverageRank("Robert","M"));
    }
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
         int ranknow=getRank(year,name,gender);
         int sum=0;
         String nam="us_babynames_by_year/yob"+year+".csv";
         FileResource fr= new FileResource(nam);
         for(CSVRecord record: fr.getCSVParser(false)){
            if(record.get(1).equals(gender)){
                if(ranknow==1){
                    break;
                }
                sum+=Integer.parseInt(record.get(2));
                ranknow--;
            }
         }
         return sum;
    }
}
