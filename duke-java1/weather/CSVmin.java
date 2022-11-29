import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * 在这里给出对类 CSVmax 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class CSVmin {

    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord r= null;
        for(CSVRecord record: parser){
            if(r==null){
                r=record;
            }
            double temp=Double.parseDouble(record.get("TemperatureF"));
            double pre=Double.parseDouble(r.get("TemperatureF"));
            if(temp<pre && !record.get("TemperatureF").equals("-9999")){
                r=record;
            }
        }
        return r;
    }
    
    
    
    void testColdestHourInFile() {
        FileResource fr=new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord r=coldestHourInFile(parser);
        System.out.println(r.get("TemperatureF"));
    }
    
    
    public String fileWithColdestTemperature(){
        String name=null;
        CSVRecord csvr=null;
        File file=null;
        DirectoryResource dr = new  DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord record =coldestHourInFile(parser);
            if(csvr==null){
                csvr=record;
            }
            double temp=Double.parseDouble(record.get("TemperatureF"));
            double pre=Double.parseDouble(csvr.get("TemperatureF"));
            if(temp<pre){
                csvr=record;
                name=f.getName();
                file=f;
            }
        }
        System.out.println("Coldest day was in file " + name);
        System.out.println("Coldest temperature on that day was " + csvr.get("TemperatureF"));
        System.out.println("All the Temperatures on the coldest day were:");
        
            FileResource fr=new FileResource(file);
            CSVParser parser = fr.getCSVParser();
            for(CSVRecord record :parser){
                System.out.println(record.get("TemperatureF")+record.get("DateUTC")+record.get("TimeEST")+record.get("TimeEDT"));
            }
        
        return name;
    }
    void testfileWithColdestTemperature(){
        String name =fileWithColdestTemperature();
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord r= null;
        for(CSVRecord record: parser){
            if(record.get("Humidity").equals("N/A")){
                continue;
            }
            if(r==null){
                r=record;
            }
            double temp=Double.parseDouble(record.get("Humidity"));
            double pre=Double.parseDouble(r.get("Humidity"));
            if(temp<pre){
                r=record;
            }
        }
        return r;//If there is a tie, then return the first such record that was found
    }
    void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity")+csv.get("DateUTC")+csv.get("TimeEDT"));
    }
    public CSVRecord lowestHumidityInManyFiles(){
        
        CSVRecord csvr=null;
        DirectoryResource dr = new  DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr=new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord record =lowestHumidityInFile(parser);
            if(csvr==null){
                csvr=record;
            }
            double temp=Double.parseDouble(record.get("Humidity"));
            double pre=Double.parseDouble(csvr.get("Humidity"));
            if(temp<pre){
                csvr=record;
            }
        }
        return csvr;
    }
    void testLowestHumidityInManyFiles(){
        CSVRecord csv=lowestHumidityInManyFiles();
        System.out.print("Lowest Humidity was " + csv.get("Humidity")+csv.get("DateUTC"));
    }
    
    public double averageTemperatureInFile (CSVParser parser){
        double tem=0.0;
        int count=0;
        for(CSVRecord record: parser){
            if(!record.get("TemperatureF").equals("-9999")){
                tem+=Double.parseDouble(record.get("TemperatureF"));
                count++;
            }
        }
        return tem/count;
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        double tem=0.0;
        int count=0;
        for(CSVRecord record: parser){
            if(Double.parseDouble(record.get("Humidity"))>(double)value){
                tem+=Double.parseDouble(record.get("TemperatureF"));
                count++;
            }
        }
        return tem/count;
    }
    void averageTemperature(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double num = averageTemperatureInFile (parser);
        System.out.print("averageTemperature was " + num);
    }
    void averageTemperatureTHAN80(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double num = averageTemperatureWithHighHumidityInFile(parser,80);
        System.out.print("averageTemperature THAN 80 was " + num);
    }
}
