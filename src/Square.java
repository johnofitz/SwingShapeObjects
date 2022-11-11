import java.awt.Color;
import java.awt.Graphics;
/**
 * Class Square Inherits all methods from Class Rectangle
 * This Class uses all super implementation methods to draw the object
 * as a square is so common to a Rectangle no other fields need to 
 * be declared.
 * @author John Fitzgerald, L00177804
 */
public class Square extends Rectangle {

    public Square(Color color, int xCenter, int yCenter, boolean fill, int width, int height) {
        super(color, xCenter, yCenter, fill, width, height);
    }

    @Override
    void boxOutline() {
        super.boxOutline();
    }

    @Override
    void drawBox(Graphics g) {
    
        super.drawBox(g);
    }

    @Override
    void drawShape(Graphics g) {
        
        super.drawShape(g);
    }

    @Override
    public void moveByTen() {
       
        super.moveByTen();
    }

    @Override
    public String toString() {
       
        return super.toString();
    }
   
}
