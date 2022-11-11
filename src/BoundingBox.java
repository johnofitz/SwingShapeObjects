 /**
  * Class Bounding box uses Composition by taking 
  * Points Class as fields. This allows an (X,Y) Coordinate
  * for the Lower and Upper X/Y Positions to be drawn around each 
  * Object. It is also used to store points to allow MouseEvent 
  * Object to check when within limits and used by ShapesManager Class
  * to position the String Name.
  */

public class BoundingBox
{
    // Fields Objects declared
    private Point lowerXy;
    private Point upperXy;
    /**
     * Constructor used to create Upper and Lower X/Y Positions
     * @param lowerXy Object that accepts Lower X/Y Coordinates
     * @param upperXy Object that accepts Upper X/Y Coordinates
     */
    public BoundingBox(Point lowerXy, Point upperXy)
    {
        this.lowerXy = lowerXy;
        this.upperXy = upperXy;
    }

    /**
     * @return the lowerXy
     */
    public Point getLowerXy() {
        return lowerXy;
    }

    /**
     * @param lowerXy the lowerXy to set
     */
    public void setLowerXy(Point lowerXy) {
        this.lowerXy = lowerXy;
    }

    /**
     * @return the upperXy
     */
    public Point getUpperXy() {
        return upperXy;
    }

    /**
     * @param upperXy the upperXy to set
     */
    public void setUpperXy(Point upperXy) {
        this.upperXy = upperXy;
    }
    

}
