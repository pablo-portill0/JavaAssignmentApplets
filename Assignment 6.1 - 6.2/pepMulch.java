import java.text.DecimalFormat;

/**
 * Name:        Pablo Portillo
 * Date:        11/17/2019
 * Professor:   Fahringer
 * 
 * Mulch Class to calculate arbitrary size box of 3in. depth, and mulch bags
 * needed to fill such box space.
 */

 public class pepMulch
 {
    private double length;
    private double width;
    private double height;

    /**
     * Default No Argument Constructor sets all values at 2.0
     */

    public pepMulch()
    {
      length = 2.0;
      width = 2.0;
      height = 2.0;
    }

    /**
     * Constructor sets all dimensions to given value
     * @param value The value given to all dimensions
     */

    pepMulch(double value)
    {
      length = value;
      width = value;
      height = value;
    }

    /**
     * Constructor sets each individual dimension to given value
     * @param len The value to store in length
     * @param wid The value to store in width
     * @param ht The value to store in height
     */

    pepMulch(double len, double wid, double ht)
    {
      length = len;
      width = wid;
      height = ht;
    }
    
    /**
     * The setLength method stores a value in the length field. 
     * @param len The value to store in length.
     */

    public void setLength(double len)
    {
      length = len;
    }

    /**
     * The setWidth method stores a value in the width field.
     * @param wid The value to store in width.
     */

    public void setWidth(double wid)
    {
      width = wid;
    }

    /**
     * The setHeight method stores a value in the height field.
     * @param ht The value to store in height.
     */

    public void setHeight(double ht)
    {
      height = ht;
    }

    /**
     * The getLength method returns a Mulch object's length.
     * @return The value in the length field.
     */

    public double getLength()
    {
      return length;
    }

    /**
     * The getWidth method returns a Mulch object's width.
     * @return The value in the width field.
     */

    public double getWidth()
    {
      return width;
    }

    /**
     * The getHeight method returns a Mulch object's height.
     * @return The value in the height field.
     */

    public double getHeight()
    {
      return height;
    }

    /**
     * The getPerim method returns a Mulch object's perimeter.
     * @return The sum of twice the length and twice the width.
     */

    public double getPerim()
    {
      return (2*length)+(2*width);
    }

    /**
     * The getVol method returns a Mulch object's volume
     * @return The product of length times width times height
     */

    public double getVol()
    {
      return length*width*height;
    }

    /**
     * The getNumBags method returns the total bags necessary to fill the volume of a Mulch object.
     * @return Number of 2 cu. ft. (3456 cu. in.) volume bags of mulch to fill volume of Mulch object.
     */

    public double getNumBags()
    {
      return (length*width*height)/3456;
    }

    /**
     * toString method returns a stored/relevant info for the class
     * Also rounds getNumBags to 5 decimal places
     * @return A string with dimensions, perimeter, volume and bag number.
     */

    public String toString()
    {
      //A string describing the dimensions
      DecimalFormat df = new DecimalFormat("#.#####");
      String str = "Flowerbox Length: " + length +
                    "\nFlowerbox Width: " + width +
                    "\nFlowerbox Height: "+ height +
                    "\nFlowerbox Perimeter: " + getPerim() +
                    "\nFlowerbox volume: " + getVol() +
                    "\nMulch bags to fill volume: " + df.format(getNumBags());

      //Return string.
      return str;
    }
 }