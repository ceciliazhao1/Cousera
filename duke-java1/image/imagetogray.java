import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 image 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class imagetogray {
    public ImageResource setgray(ImageResource image){
        ImageResource outimage = new ImageResource(image.getWidth(), image.getHeight());
        for (Pixel pixel: outimage.pixels()) {
            Pixel prep= image.getPixel(pixel.getX(),pixel.getY());
            pixel.setRed((prep.getRed()+prep.getGreen()+prep.getBlue())/3);
            pixel.setGreen((prep.getRed()+prep.getGreen()+prep.getBlue())/3);
            pixel.setBlue((prep.getRed()+prep.getGreen()+prep.getBlue())/3);
        }
        return outimage;
    }
    
    void test(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource curimage= new ImageResource(f);
            ImageResource grayimage = setgray(curimage);
            grayimage.draw();
            String name= curimage.getFileName();
            String newname= "gray-"+name;
            grayimage.setFileName(newname);
            grayimage.save();
        }
    }

}
