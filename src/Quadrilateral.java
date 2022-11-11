import java.awt.*;
import java.util.Arrays;

/**
 * Class Quadrilateral Inherits Shape Class Fields and Overrides methods.
 * Quadrilateral Implements Interface Class Rotatable and rotates Object drawn
 * at a 45 degrees rotation clockwise from the center of the object. Three types
 * of Quadrilaterals can be drawn from this Class using the constructor defined
 * one Accepts an array of points from Points class object, single Points from
 * Points class
 * and a Rectangle object from clas Rectangle
 * 
 * @author John Fitzgerald, L00177804
 * 
 */
public class Quadrilateral extends Shape implements Rotatable {
    // private fields declared for holding coordinates of quadrilateral
    private int[] xPoints = new int[4];
    private int[] yPoints = new int[4];
    // Private Instance fields created using composition for bounding box
    private Point bottomLeft;
    private Point topRight;
    private int height;
    private int width;

    /**
     * Constructor accepts an Array of points from Points Class as argument
     * 
     * @param color  Type of color for shape
     * @param fill   True/False to fill the shape drawn
     * @param center Center points from which Quad will be drawn
     * @param points Array of Coordinates for shape
     */
    Quadrilateral(Color color, boolean fill, Point center, Point[] points) {
        
        this.xCenter = center.getX(); // returns as horizontal x position
        this.yCenter = center.getY(); // returns a vertical y position
        passArray(points, xPoints, yPoints); // Method accepts points object and fields as parameters
        this.color = color;
        this.fill = fill;
    }

    /**
     * Constructor accepts single points from Points class as parameters
     * 
     * @param color  Type of color for shape
     * @param fill   true/ false to fill the shape drawn
     * @param center Center points from which Quad will be drawn
     * @param p1     X & Y Top Left
     * @param p2     X & Y Top Right
     * @param p3     X & Y Bottem Right
     * @param p4     X & Y Bottem Left
     */
    Quadrilateral(Color color, boolean fill, Point p1, Point p2, Point p3, Point p4, Point center) {
        super(color, fill);
        this.xPoints[0] = p1.getX();
        this.xPoints[1] = p2.getX();
        this.xPoints[2] = p3.getX();
        this.xPoints[3] = p4.getX();

        this.yPoints[0] = p1.getY();
        this.yPoints[1] = p2.getY();
        this.yPoints[2] = p3.getY();
        this.yPoints[3] = p4.getY();
        this.xCenter = center.getX();
        this.yCenter = center.getY();
    }

    /**
     * Constructor used to accept Rectangle Class as an argument for Quadrilateral
     * 
     * @param color   Type of color for shape
     * @param xCenter Xcenter Coordinate
     * @param yCenter Ycenter Coordinate
     * @param fill    True/False to fill the shape drawn
     * @param rect    Object from class Rectangle
     */
    Quadrilateral(Color color, int xCenter, int yCenter, boolean fill, Rectangle rect) {
        super(color, fill);
        this.width = rect.getWidth();
        this.height = rect.getHeight();
        // Allows quad to spin and be drawn from center
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        // Calculations made to draw Quad from the center
        this.xPoints[0] = xCenter - (width) / 2;
        this.yPoints[0] = yCenter - (height) / 2;

        this.xPoints[1] = xCenter + (width) / 2;
        this.yPoints[1] = yCenter - (height) / 2;

        this.xPoints[2] = xCenter + (width) / 2;
        this.yPoints[2] = yCenter + (height) / 2;

        this.xPoints[3] = xCenter - (width) / 2;
        this.yPoints[3] = yCenter + (height) / 2;
    }

    /**
     * Method used to pass Point Coordinates to field parameters
     * 
     * @param obj Object of points passed as argument
     */
    private void passArray(Point[] obj, int[] xArr, int[] yArr) {
        for (int i = 0; i < obj.length; i++) {
            xArr[i] = obj[i].getX();
            yArr[i] = obj[i].getY();
        }
    }

    @Override
    public void drawShape(Graphics g) {
        if (fill) {
            g.setColor(color);
            g.fillPolygon(xPoints, yPoints, 4);
        } else {
            g.setColor(color);
            g.drawPolygon(xPoints, yPoints, 4);
        }
    }

    @Override
    public void boxOutline() {
        // Get min/max X and y point from array using private methods
        int minX = minMax("min", xPoints);
        int maxX = minMax("max", xPoints);
        int minY = minMax("min", yPoints);
        int maxY = minMax("max", yPoints);
        // Create new Point Object and Pass in min/max values
        bottomLeft = new Point(minX, maxY);
        topRight = new Point(maxX, minY);
        // Create new Bounding box object and pass in Point objects
        box = new BoundingBox(bottomLeft, topRight);
    }

    @Override
    void drawBox(Graphics g) {
        super.drawBox(g);
    }
    /**
     * Interface Method to rotate a given shape
     * 
     * @param angle  Converts degrees to radians
     * @param xTemp  Stores x Orgin variable
     * @param yTemp  Store y Orgin variable
     * @param xPrime Trigonometric ratio for x
     * @param yPrime Trigonometric ratio for y
     */
    @Override
    public void rotate() {
        double ang = 45*(Math.PI/180.0);

        for (int j = 0; j < xPoints.length; j++) {
            // Get Diference for Origin
            int xTemp = xPoints[j] - xCenter;
            int yTemp = yPoints[j] - yCenter;
            // Rotation formula
            double xPrime = xTemp * Math.cos(ang) - yTemp * Math.sin(ang);
            double yPrime = xTemp * Math.sin(ang) + yTemp * Math.cos(ang);
            // Revert to orignal
            xPoints[j] = (int)((xPrime) + xCenter);
            yPoints[j] = (int)((yPrime) + yCenter);
        }
        
      
    
    }

    /**
     * Method finds the Max/Min Points of Quadrilateral
     * 
     * @param s        String Argument to check if Max/Min
     * @param checkArr Array of Points passed as Argumet
     * @return Max or Min value of Array passed
     */
    private int minMax(String s, int[] checkArr) {
        int tempVal = checkArr[0]; // Create a temporary variable to store 1st position
        for (int i = 1; i < checkArr.length; i++) { // itterate through array
            if (s == "max") {
                if (checkArr[i] > tempVal) { // Condition to check max
                    tempVal = checkArr[i];
                }
            } else if (s == "min") {
                if (checkArr[i] < tempVal) { // condition to check mimimum
                    tempVal = checkArr[i];
                }
            }
        }
        return tempVal;
    }

    /**
     * Method toString used for testing
     */
    @Override
    public String toString() {
        return getClass() + " [xPoints=" + Arrays.toString(xPoints) + ", yPoints=" + Arrays.toString(yPoints)
                + " Xcenter = " + xCenter + " Ycenter= " + yCenter + "]";
    }
}
