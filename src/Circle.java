import java.awt.Color;
import java.awt.Graphics;

/**
 * Class Circle Inherits Parameters and Overrides Methods from class Shape
 * @author John Fitzgerald, L00177804
 */
public class Circle extends Shape {
    // Declare fields for class circle
    private int radius;

    /**
     * @param color   Type of color for shape
     * @param xCenter XCoor shape willl be drawn from
     * @param yCenter YCoor shape willl be drawn from
     * @param fill    True/False to fill the shape drawn
     * @param radius  Width of circle from center points
     */
    public Circle(Color color, int xCenter, int yCenter, boolean fill, int radius) {
        super(color, xCenter, yCenter, fill);
        this.radius = radius;
    }

    @Override
    void drawShape(Graphics g) {
        int diameter = radius * 2;
        if (fill) {
            g.setColor(color);
            g.fillOval(xCenter - radius, yCenter - radius, diameter, diameter);
        } else {
            g.setColor(color);
            g.drawOval(xCenter - radius, yCenter - radius, diameter, diameter);
        }
    }

    @Override
    void drawBox(Graphics g) {
        super.drawBox(g);
    }

    @Override
    void boxOutline() {
        // Create new Point Object and Pass in min/max values
        Point bottomLeft = new Point(xCenter - radius, yCenter + radius);
        Point topRight = new Point(xCenter + radius, yCenter - radius);
        // Create new Bounding box object and pass in Point objects
        box = new BoundingBox(bottomLeft, topRight);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass() + " [radius=" + radius + " Xcenter= " + xCenter+ " Ycenter= "+yCenter +";]";
    } 
}
