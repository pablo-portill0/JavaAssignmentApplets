import javax.swing.JOptionPane;     //For dialog/message boxes

public class ShippingCharges
{
    public static void main(String[] args)
    {
        // Declarations
        String input;
        double weight;
        int length;
        int width;
        int height;
        //We'll declare a variable to hold the volume so we only need
        //to calculate once.
        double volume;
        /**
         * I want to use some string comparisons as well as mathematical
         * operations, so I will create two variables to hold the zip code.
         */
        String strZipCode;
        int intZipCode;
        //I had issues compling when I didn't initialize this variable with
        //a number to start with, so I gave it a value to start.
        double baseCharge = 1.0;
        double surCharge;
        double totalCharge;


        //User input section
        strZipCode = JOptionPane.showInputDialog(null, "What is the destination Zip Code? ");
        
        //Here we give a value to both of our zip code variables.
        intZipCode = Integer.parseInt(strZipCode);
        
        input = JOptionPane.showInputDialog(null, "How much does your package weigh? ");

        weight = Double.parseDouble(input);

        input = JOptionPane.showInputDialog(null, "How long is your package?");

        length = Integer.parseInt(input);

        input = JOptionPane.showInputDialog(null, "How wide is your package?");

        width = Integer.parseInt(input);
        
        input = JOptionPane.showInputDialog(null, "How tall is your package?");

        height = Integer.parseInt(input);

        //Calculating the volume beforehand to make later code more legible.
        volume = (length * width * height);

        //The top if statement is to figure out if a package is above 5 lbs.
        if (weight <= 5.0) 
        {
            baseCharge = 10.0;
        }
        else 
        {
            //This nested if figures the volume charge for packages above 5 lbs.
            if (volume > 5.0 & volume <= 15.0)
            {
                baseCharge = 12.0;
            }
            else if (volume > 15.0 & volume <= 30.0)
            {
                baseCharge = 14.0;
            }
            else if (volume > 30.0 & volume <= 45.0)
            {
                baseCharge = 16.0;
            }
            else if (volume > 45.0 & volume <= 60.0)
            {
                baseCharge = 18.0;
            }
            else if (volume > 60.0)
            {
                baseCharge = 25.0;
            }
            //I also set an exit state to prevent nonsensical volume charges
            else
            {
            JOptionPane.showMessageDialog(null, "Invalid volume!");
            System.exit(0);
            }
        }

        //To parse the Zip code, I start with string comparisons to find the
        // initial surcharge percentage.
        if (strZipCode.startsWith("4"))
        {
            surCharge = 5;
        }
        else if (strZipCode.contains("6"))
        {
            surCharge = 7;
        }
        else
        {
            surCharge = 9;
        }
        
        //Now we use the integer version for the even/odd additional surcharge
        if (intZipCode % 2 == 0)
        {
            surCharge = surCharge + 2;
        }
        
        //The final charge calculation, with the surcharge being used as a
        // decimal.
        totalCharge = baseCharge * (1 + (surCharge/100));

        //Output to user
        JOptionPane.showMessageDialog(null, "Your package is going to:\n" +
                                strZipCode + "\nand has volume of: \n" + 
                                length + " x " + width + " x " + height);

        //I used whole numbers for the surcharge to simplify formatting at this //stage.
        JOptionPane.showMessageDialog(null, "As such, " + 
                                "your base shipping cost will be:\n" +
                                 "$" + baseCharge +
                                "\nand your additional surcharge will be\n" + 
                                surCharge + "%\n" + 
                                "making your total charge: \n" +
                                String.format("$%.2f", totalCharge));
    }
}