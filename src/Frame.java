import javax.swing.JFrame;
import java.awt.*;

/**
 * Class Frame Inherits from JFram Class and Allows a Frame to be drawn to
 * contain
 * Objects created in Class Panel
 * @author John Fitzgerald, L00177804
 */
public class Frame extends JFrame {
    // Fields declared final for frame height and width
    private final int frameHeight = 480;
    private final int frameWidth = 640;
    private Panel panel;

    /**
     * Constructor for Class Frame, draws frame for GUI.
     * Methods are used from JFrame to create a custom frame
     * 
     * @param manager Object argument to add Panel to frame
     */
    Frame(ShapeManager manager) {
        panel = new Panel(manager);
        // Add panel of shapes to frame
        add(panel, BorderLayout.CENTER);
        // pass final variables for dimensions of frame
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Shape Program");
        setVisible(true);

    }
}
