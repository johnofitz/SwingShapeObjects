import java.awt.Color;
import java.awt.Graphics;

/**
 * Class Rectangle Inherits Class Shape and Implements moveable method from
 * Interface Class Moveable. This Class Allows a Rectangle shape to be drawn
 * and moved by 10 pixles with each right mouse click
 * @author John Fitzgerald, L00177804
 */
public class Rectangle extends Shape implements Movable {
    // Fields declared for Rectangle, standard Width and height
    private int width;
    private int height;
    /**
     * Constructor accepts parameters for shape to be drawn
     * 
     * @param color   Type of color for shape
     * @param xCenter XCoor shape willl be drawn from
     * @param yCenter YCoor shape willl be drawn from
     * @param fill    True/False to fill the shape drawn
     * @param width   Xaxis
     * @param height  Yaxis
     */
    public Rectangle(Color color, int xCenter, int yCenter, boolean fill, int width, int height) {
        super(color, xCenter, yCenter, fill);
        this.width = width;
        this.height = height;
    }
    @Override
    void drawShape(Graphics g) {
        
        if (fill) {
            g.setColor(color);
            g.fillRect(xCenter - width / 2, yCenter - height / 2, width, height);
        } else {
            g.setColor(color);
            g.drawRect(xCenter - width / 2, yCenter - height / 2, width, height);
        }
    }

    @Override
    void boxOutline() {
        // Create new Point Object and Pass in min/max values
        Point bottomLeft = new Point(xCenter - width / 2, yCenter + height / 2);
        Point topRight = new Point(xCenter + width / 2, yCenter - height / 2);
        // Create new Bounding box object and pass in Point objects
        box = new BoundingBox(bottomLeft, topRight);
    }



    @Override
    void drawBox(Graphics g) {
        super.drawBox(g);
    }

    @Override
    public void moveByTen() {
        xCenter += 10;
    }

    @Override
    public String toString() {
        return getClass() + " [width= " + width + ", height= " + height + " X-Center= " + xCenter + " Y-Center= "
                + yCenter + "]";
    }
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }
}
