import edu.duke.*;
import java.io.*;
/**
 * 在这里给出对类 imagetoinvert 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class imagetoinvert {

    public ImageResource setinvert(ImageResource image){
        ImageResource outimage = new ImageResource(image.getWidth(), image.getHeight());
        for (Pixel pixel: outimage.pixels()) {
            Pixel prep= image.getPixel(pixel.getX(),pixel.getY());
            pixel.setRed(255-prep.getRed());
            pixel.setGreen(255-prep.getGreen());
            pixel.setBlue(255-prep.getBlue());
        }
        return outimage;
    }
    
    void test(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource curimage= new ImageResource(f);
            ImageResource grayimage = setinvert(curimage);
            grayimage.draw();
            String name= curimage.getFileName();
            String newname= "invert-"+name;
            grayimage.setFileName(newname);
            grayimage.save();
        }
    }

}

