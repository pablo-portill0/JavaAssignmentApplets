import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        11/9/2019
 * Professor:   Fahringer
 * 
 * Purpose: To demonstrate pepMulch class methods.
 */

 public class pepMulchDemo
 {
  public static void main(String[] args)
  {
    //Since we can immediately pass input into the Mulch class, we don't need any other variables except input.
    String input;

    //We initialize our mulch class here as 'box' for clarity and ease of typing
    pepMulch box = new pepMulch();

    input = JOptionPane.showInputDialog("How long is the flower bed in inches?");
    
    //Since InputDialog returns a string, we must first parse it into a double
    //for box.setLength()
    box.setLength(Double.parseDouble(input));

    input = JOptionPane.showInputDialog("How wide is the flower bed in inches?");

    //Same as setLength, we parse the string object input to a double.
    box.setWidth(Double.parseDouble(input));

    //Here we see all of the get* methods, getting all inputs and displaying
    //all possible calculations. I have also referenced showMessageDialog()
    //documentation to use the other possible arguments for the method.
    JOptionPane.showMessageDialog(null, "Entered Length: " + box.getLength() + "in." + 
    "\n" + "Entered Width: " + box.getWidth() + " in." +
    "\n" + "Calculated Perimeter: " + box.getPerim() + " in." +
    "\n" + "Calculated Volume: " + box.getVol() + " cu. in." + 
    "\n" + "Calculated Number of Bags Necessary: " + box.getNumBags() + " bags.", "MulchDemo", JOptionPane.INFORMATION_MESSAGE);

  }
 }