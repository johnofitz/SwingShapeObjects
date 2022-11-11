import java.awt.*;

/**
 * 
 * App Class has Main method which allows program to be compiled.
 * It instantiates all shape Objects in Memory and adds them to the ArrayList
 * class.
 * 
 * @apiNote This class also contains private static methods used to find the
 *          center points of
 *          the quadrilateral to be drawn,
 *          as there center points cannot be directly input into the object of
 *          class only the exception of the constructor that accepts a Rectangle
 *          as a parameter
 *          Quadrilateral as it
 *          is based of coordinates of points.
 * @author John Fitzgerald, L00177804
 */
public class App {
    public static void main(String[] args) throws Exception {
        // Coordinates for Quadlrilateral that accepts array as parameter
        // Top left-top right-bottom right-bottom left
        int xCoor[] = { 300, 400, 420, 320 };
        int yCoor[] = { 260, 260, 300, 300 };
        // Object created for center points of quadArray uses centroid method to find
        Point centerP1 = new Point(centroid(xCoor), centroid(yCoor));
        // Object of points declared to accept single Points as parameter for
        Point p1 = new Point(440, 340);
        Point p2 = new Point(470, 340);
        Point p3 = new Point(490, 440);
        Point p4 = new Point(400, 430);
        // Center point is computed by the total points divided by sum points for quad
        int xC = (p1.getX() + p2.getX() + p3.getX() + p4.getX()) / 4;
        int yC = (p1.getY() + p2.getY() + p3.getY() + p4.getY()) / 4;
        // allow object to be drawn and rotate from center
        Point centerP2 = new Point(xC, yC);
        // Objects of Shapes create to be displayed in Panel
        Rectangle rect = new Rectangle(Color.blue, 100, 50, true, 150, 60);
        Square square = new Square(Color.MAGENTA, 100, 360, true, 100, 100);
        Quadrilateral qrec = new Quadrilateral(Color.LIGHT_GRAY, 120, 160, true, rect);
        Quadrilateral quadP = new Quadrilateral(Color.ORANGE, true, p1, p2, p3, p4, centerP2);
        Circle circle = new Circle(Color.CYAN, 420, 150, true, 40);
        // Object shapes instantiated to add shapes to panel
        ShapeManager shapes = new ShapeManager();
        // ShapeManger class setters to set display True/False
        shapes.setDisplayBoundingBox(true);
        shapes.setDisplayName(true);
        // Pass object constructor to method quad to create object and add to arrayList
        shapes.addShape(quad(Color.PINK, true, xCoor, yCoor, centerP1));
        shapes.addShape(circle);
        shapes.addShape(quadP);
        shapes.addShape(rect);
        shapes.addShape(qrec);
        shapes.addShape(square);
        // Create frame Object to display GUI
        new Frame(shapes);
    }

    /**
     * Method that instantiates quadrilateral object
     * 
     * @param color Type of color
     * @param xArr  Xcoordinates for quadrilateral points
     * @param yArr  Ycoordinates for quadrilateral points
     * @param b     true/false to fill the quadrilateral
     * @param c     Center points for quadrilaterl
     * @return Object of type quadrilateral
     */
    private static Quadrilateral quad(Color color, boolean b, int xArr[], int yArr[], Point c) {
        Point points[] = new Point[4]; // Set point class as Array of size 4
        for (int i = 0; i < points.length; i++) { // Itterate through Points and add x/y to pos
            points[i] = new Point(xArr[i], yArr[i]);
        }
        Quadrilateral q = new Quadrilateral(color, b, c, points);
        return q;
    }

    /**
     * Method calculates the centre points of quadrilateral
     * 
     * @param arr Array of points for quadrilaterl x or y
     * @return center point of shape
     */
    private static int centroid(int[] arr) {
        int total = 0; // Variable total to add element
        int sum = 0; // Variable sum to get num elements
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            sum++;
        }
        return total / sum;
    }
}
