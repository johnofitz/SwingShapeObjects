
/**
 * Class Rotatable is an Interface Class, Used in Quadrilateral Class
 * to specify behaviour. An interface only stores the method signature and not
 * the method definition. Method Signatures make an Interface achieve complete
 * Abstraction by hiding the method implementation from the user.
 * @author John Fitzgerald, L00177804
 */
public interface Rotatable {
    /**
     * Interface Method used to rotate shape by 45 Degrees
     * Uses Trigonmetric identies, complex calculations are involved to achieve
     * rotation mathmatically.
     * @see https://en.wikipedia.org/wiki/Rotation_of_axes
     * @apiNote The Rotation point from which the point rotates must also be taken
     *          into to account, which subtracts points back to Orgin adds the
     *          rotation and the reverts to Original coordinates.
     */
    void rotate();
}
