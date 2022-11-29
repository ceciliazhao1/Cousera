import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num=0;
        for (Point currPt : s.getPoints()){
            num++;
        }
       
        return num;
    }

    public double getAverageLength(Shape s) {
        
        double perimeter = getPerimeter (s);
        int num = getNumPoints (s);
        double ave = (double) perimeter/ num;
        return ave;
    }

    public double getLargestSide(Shape s) {
        double num = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            num= Math.max(num,currDist);
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return num;
    }

    public double getLargestX(Shape s) {
        double num = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        double prevx= prevPt.getX();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currx = currPt.getX();
            // Update totalPerim by currDist
            num= Math.max(currx,prevx);
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return num;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double max= 0.0;
        DirectoryResource source= new DirectoryResource();
        for(File f: source.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double peri = getPerimeter(s);
            max= Math.max(peri,max);
        }
        return max;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        double preperi= 0.0;
        File temp = null;
        DirectoryResource source= new DirectoryResource();
        for(File f: source.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double peri = getPerimeter(s);
            if(peri > preperi){
                temp=f;
                preperi= peri;
            }
        }
        
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int num = getNumPoints(s);
        System.out.println("NumPoints = " + num);
        
        double ave=getAverageLength(s);
        System.out.println("AverageLength = " + ave);
       
        double bigside = getLargestSide (s);
        System.out.println("largestside = " + bigside);
        
        double bigx = getLargestX (s);
        System.out.println("largestX = " + bigx);
       
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double num = getLargestPerimeterMultipleFiles();
        System.out.println("largestPerimeterMultipleFiles = " + num);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String name = getFileWithLargestPerimeter() ;
        System.out.println("getFileWithLargestPerimeter = " + name);
    }
    

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
