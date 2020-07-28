import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        11/9/2019
 * Professor:   Fahringer
 * 
 * Purpose: To demonstrate pepMulch class methods.
 */

 public class pepMulchDemoDeux
 {
  public static void main(String[] args)
  {
    int dialogResult;
    String input;
    Double length;
    Double width;
    Double height;

    //We first ask whether the user would like to initialize with with default
    //values or if they have values to input
    dialogResult = JOptionPane.showConfirmDialog(null, "Start using \n" + 
                            "default values (Yes), or input new values (No)?");

    //We'll set up a set of nested if statements to let show off defaults
    //along with both 1 argument and 3 argument init.
    //We start with testing for the default init.
    if(dialogResult == JOptionPane.YES_OPTION)
    {
      defaultInit();
    }
    else
    {
      //Now we can ask if the user wants to use one value or three
      dialogResult = JOptionPane.showConfirmDialog(null, "Use 1 value (Yes)" +
                                                          " or 3 values (No)?");

      if(dialogResult == JOptionPane.YES_OPTION)
      {
        //We as for the dimension value to give to the init method
        input = JOptionPane.showInputDialog("What is the dimension value?");

        oneArgInit(Double.parseDouble(input));
      }
      else if(dialogResult == JOptionPane.NO_OPTION)
      {
        //We ask for each dimension individually to give to our init method
        input = JOptionPane.showInputDialog("What is the length");
        length = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("What is the width");
        width = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("What is the height");
        height = Double.parseDouble(input);

        threeArgInit(length, width, height);
      }
    }

  }

  /**
   * Using the no arg constructor to display defaults
   * @return The toString method with defaults of pepMulch class
   */
  public static void defaultInit()
  {
    //Initialize pepMulch with no arguments
    pepMulch box = new pepMulch();

    //Using toString implicitly to display default values
    JOptionPane.showMessageDialog(null, box);
  }

  /**
   * Using 1 arg constructor and displaying toString method of pepMulch class
   * @param dimension Value to pass to pepMulch constructor
   * @return Passed & calculated values of pepMulch class, toString method
   */
  public static void oneArgInit(double dimension)
  {
    //Initialize pepMulch with 1 argument
    pepMulch box = new pepMulch(dimension);

    //Using toString implicitly to display all values
    JOptionPane.showMessageDialog(null, box);
  }

  /**
   * Using 3 arg constructor and displaying toString method of pepMulch Class
   * @param lvalue Length value to pass to pepMulch constructor
   * @param wvalue Width value to pass to pepMulch constructor
   * @param hvalue height value to pass to pepMulch constructor
   */
  public static void threeArgInit(double lvalue, double wvalue, double hvalue)
  {
    pepMulch box = new pepMulch(lvalue, wvalue, hvalue);
    
    JOptionPane.showMessageDialog(null, box);
  }
 }