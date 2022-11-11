
/**
 * Class Moveable is an Interface Class, Used in Rectangle Class
 * to specify behaviour. An interface only stores the method signature and not
 * the method definition. Method Signatures make an Interface achieve complete
 * Abstraction by hiding the method implementation from the user.
 * @author John Fitzgerald, L00177804
 */
public interface Movable {
    /**
     * Abstract method used to Move object 10 Pixles to the right along its X-axis
     * This does not require complex calculations as no Translation required om the
     * Y-Axis
     * @param xCenter +=10
     */
    void moveByTen();
}
