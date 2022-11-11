import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * Class Panel is used to instantiate objects within JFrame
 * class inherits JPanel for graphics
 * GUI elements
 * @author John Fitzgerald, L00177804
 * 
 */
public class Panel extends JPanel {

    private ShapeManager manager;
    /**
     * Constructor for Panel Class uses composition to accept Class
     * Shapemanager as parameter, This allows Arraylist of Shapes  
     * to be displayed in Panel, mouselistner is also called within constructor
     * @param manager Object 
     */  
    Panel(ShapeManager manager){
        this.manager = manager;
        MouseClickListener(); // call mouselistner
    }

    /**
     * Method used to Control addMouselistiner from Mouselistner Class
     * This Override method with parameters specific to catch events needed
     * @param x Coordinate of X position of mouseClick
     * @param y Coordinate of Y position of mouseClick
     * @param right Boolean expression to change to true when condition is met
     */
    public void MouseClickListener(){

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                boolean right = false;
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("Left click: " + x + " , " + y); 
                }
                else if(e.getButton() == MouseEvent.BUTTON2){
                    System.out.println("Centre click: " + x + " , " + y);  
                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                    System.out.println("Right click: " + x + " , " + y);
                    right = true;
                }
                manager.checkPoints(e,right); // accept MouseEvent object and boolean parameter
                repaint(); // redraws all shapes by calling paintComponent  
            }
        });
    }
    /**
     * Retrives graphics from JComponent, indirectly by using java swing lib
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); // No real need 
        manager.drawShape(graphics); // draws original
   }
}
