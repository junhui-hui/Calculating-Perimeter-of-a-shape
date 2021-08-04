import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0;
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
        // initialise count to be 0
        int count = 0;
        // for each loop to iterate through points in shape s
        for(Point currPt: s.getPoints()){
            count += 1; //update total count
        }
        // return total count
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        // Asign num of points in shape to No_of_points
        int No_of_points = getNumPoints(s);
        // Assign Total perimeter of shape to TPerim
        double TPerim = getPerimeter(s);
        // Calculate Average Length
        double AveLength = TPerim/ No_of_points;
        return AveLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        // Initialise larget side to be 0 and named Lside
        double Lside = 0;
        // Initialise starting point to be the last point of the shape
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            // Calculate distance from previous point to current point
            double currDist = prevPt.distance(currPt);
            if(currDist > Lside){
                Lside = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return Lside;
    }

    public double getLargestX(Shape s) {
        // Put code here
        // Initialise Largest X as 0 and named LX
        double LX = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            //get X of point: if X > LX, assign LX as X
            double X = currPt.getX();
            if(X > LX){
                LX = X;
            }
            prevPt = currPt;
    }
    return LX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double LPerim = 0;
        FileResource largestFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > LPerim) {
                LPerim = perim;
            }
        }
        return LPerim;
       
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double LPerim = 0;
        File LFile = null;

        for(File f : dr.selectedFiles()){
            FileResource file = new FileResource(f);
            Shape shape = new Shape(file);
            double perim = getPerimeter(shape);
            if(perim > LPerim) {
                LPerim = perim;
                LFile = f;
            }
        }

        return LFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double AverageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.println("Perimeter: " + length);
        System.out.println("Number of Points: " + numPoints);
        System.out.println("Average Length: " + AverageLength);
        System.out.println("Largest Side: " + largestSide);
        System.out.println("Largest X: " + largestX );
        testPerimeterMultipleFiles();
        testFileWithLargestPerimeter();
    }
    
    public void testPerimeterMultipleFiles() { 
        double LPerim = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter: " + LPerim);
    }

    public void testFileWithLargestPerimeter() {
        String file = getFileWithLargestPerimeter();
        System.out.println("Largest perimeter file: " + file);
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
        System.out.println("Perimeter: "+peri);
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
