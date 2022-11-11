import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

/**
 * Class used to Maintain the Shapes creted by use of an arrayList.
 * Methods contained within this class also control Mouseclick events to
 * allow implementation of Interface Classes "Rotatable" & "Moveable"
 *  @author John Fitzgerald, L00177804
 */
public class ShapeManager {
    // Fields for Arraylist to manage object storage
    private ArrayList<Shape> shapes = new ArrayList<>();
    private boolean displayBoundingBox;
    private boolean displayName;

    /**
     * Method used to show the name of the shape
     * 
     * @param displayName the displayName to set
     */
    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    /**
     * Method used to display the bounding box, although still drawn not visible
     * 
     * @param displayBoundingBox the displayBoundingBox to set
     */
    public void setDisplayBoundingBox(boolean displayBoundingBox) {
        this.displayBoundingBox = displayBoundingBox;
    }

    /**
     * Method which adds elements to ArrayList
     * 
     * @param shapeList adds classes to Arraylist
     */
    public void addShape(Shape shapeList) {
        shapes.add(shapeList);
    }

    /**
     * Method draw shape loops through arrayList of shapes
     * for each used to loop through arrayList and present the Objects for drawShape
     * 
     * @param displayName boolean expression to check if True/False
     * @param xPos        Calculates the Xcoor where the String is Drawn
     * @param yPos        Calculates the Ycoor where the String is Drawn
     * @param g           is graphics object used in which method is Override
     */
    public void drawShape(Graphics g) {
        for (Shape list : shapes) {
            list.drawShape(g);
            System.out.println(list.toString() + "\n");
            if (displayName) {
                String name = list.getClass().getSimpleName();
                int xPos = list.xCenter-(name.length()*2); //to accommodate String length
                int yPos = list.yCenter;
                g.setFont(new Font("Serif", Font.BOLD, 11));
                g.setColor(Color.BLACK);
                g.drawString(name, xPos, yPos); 
            }
            if (displayBoundingBox) {
                g.setColor(Color.PINK);
                list.drawBox(g);
            }
            else{
                list.boxOutline(); // getbox coordinates if set false
            }
        }
        System.out.println("********************************");
    }

    /**
     * Method checks arrayList for any shapes that contain interface
     * methods using isInstance, if true is returned the method is cast
     * to list object and excuted in run time. This Method is called in Class Panel
     * within the MousleListner Method and returns a True/False
     * 
     * @param e          MouseEvent Object returns X/Y Points through Points Class
     *                   object
     * @param right      Boolean True/False to check Right click
     * @param findPoints Private bounds Method returned to check if within Boundary
     *                   of box
     */
    public void checkPoints(MouseEvent e, boolean right) {
        for (Shape list : shapes) {
            boolean findPoints = bounds(list.getBox(), new Point(e.getX(), e.getY()));
            if (findPoints) {
                list.fill = !list.fill; // Always changing as never satisfied
                if (right) {
                    if (Rotatable.class.isInstance(list)) { // isInstance returns true checked at run time
                        ((Rotatable) list).rotate(); // Cast Rotatable to list object
                    }
                    else if (Movable.class.isInstance(list)) {
                        ((Movable) list).moveByTen();
                    }
                }
            }
        }
    }

    /**
     * Private method used to check if mouse event is contained within the
     * area of the Boundingbox of a shape. If so, a boolean true statment is
     * returned
     * Mouse Coordinates are checked against range of point, where width is between
     * X lower point
     * and X upper point and the Height is between the Y lower point and the Y upper
     * point
     * 
     * @param box       Object for bounding box
     * @param mouseCoor X/Y object for mouse coordinates
     * @return True/False
     */
    private boolean bounds(BoundingBox box, Point mouseCoor) {

        int xL = box.getLowerXy().getX();
        int yL = box.getLowerXy().getY();
        int xU = box.getUpperXy().getX();
        int yU = box.getUpperXy().getY();
        int mX = mouseCoor.getX();
        int mY = mouseCoor.getY();

        return ((mX >= xL) && (mX <= xU) && (mY <= yL) && (mY >= yU));
    }

}
