import java.awt.*;

/**
 * Abstract class used to declare various constructors to cater for specific
 * shapes.
 * Uses polymorphism to allow all shapes to inherit the methods declared in
 * class.
 * Multiple Constructor to accomadate the differnt types of shapes drawn
 * 
 * @author John Fitzgerald, L00177804
 */
abstract class Shape {
    // Field declare as protected for inheritance use
    protected Color color;
    protected boolean fill;
    protected int xCenter, yCenter;
    protected BoundingBox box;

    /**
     * Shape constructor with default parameters
     */
    Shape() {
        this(0, 0);
    }

    /**
     * Shape constructor accepts a color and fill
     * 
     * @param color Type of color for shape
     * @param fill  True/False to fill the shape drawn
     */
    Shape(Color color, boolean fill) {
        this.color = color;
        this.fill = fill;
    }

    /**
     * Shape constructor which accepts X and Y center points
     * 
     * @param xCenter XCoor shape willl be drawn from
     * @param yCenter YCoor shape willl be drawn from
     */
    Shape(int xCenter, int yCenter) {
        this(Color.BLACK, xCenter, yCenter);
    }

    /**
     * Shape constructor which accepts X and Y center points
     * 
     * @param color   Type of color for shape
     * @param xCenter XCoor shape willl be drawn from
     * @param yCenter YCoor shape willl be drawn from
     */
    Shape(Color color, int xCenter, int yCenter) {
        this(color, xCenter, yCenter, true);
    }

    /**
     * 
     * @param color   Type of color for shape
     * @param xCenter XCoor shape willl be drawn from
     * @param yCenter YCoor shape willl be drawn from
     * @param fill    True/False to fill the shape drawn
     */

    Shape(Color color, int xCenter, int yCenter, boolean fill) {
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.fill = fill;
    }

    /**
     * Method used to Draw shape Inherited by all subclasses
     * using polymorphism in subclasses to draw specific shapes
     * 
     * @param g object from java.awt overloaded by subclass to draw shapes and set
     *          color
     */
    abstract void drawShape(Graphics g);

    /**
     * Method used to Draw Bounding box Inherited by all subclasses
     * using polymorphism in subclasses to draw specific shapes all
     * subclassses uses the same parameters to draw the outline, therefore
     * a super implementation can be used
     * 
     * @param g object from java.awt overloaded by subclass to draw bounding box
     *          which contains shape
     */
    void drawBox(Graphics g) {
        boxOutline();
        int x = box.getLowerXy().getX();
        int y = box.getUpperXy().getY();
        int width = box.getUpperXy().getX() - box.getLowerXy().getX();
        int height = box.getLowerXy().getY() - box.getUpperXy().getY();
        g.drawRect(x, y, width, height);
    };

    /**
     * Method used to set limits of the Bounding box.
     * The parameters created in this method are Points from the Points class
     * and a BoundingBox object box. This method should be called within the
     * constructors, or
     * for simplicity within drawBox method for each shape Class
     */
    abstract void boxOutline();

    /**
     * Method used to return Bounding box for each Object shape
     * 
     * @return Object box
     */
    BoundingBox getBox() {
        return this.box;
    }
    @Override
    public String toString() {
        return "Shape [color=" + color + ", fill=" + fill + ", xCenter=" + xCenter + ", yCenter=" + yCenter + ", box="
                + box + "]";
    }
}
