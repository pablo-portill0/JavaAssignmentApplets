/**
 * Name: Pablo Portillo
 * Date: 10/07/2019  
 * Professor: Fahringer
 */
import javax.swing.JOptionPane;

public class PayDay
{
    public static void main(String[] args)
    {
        int payRate;
        double multiplier;
        int daysWorked;
        double totalPay;
        String input;

        // Get the pay from the first day
        input = JOptionPane.showInputDialog(null, "Enter your starting pay" +
                                                                " in cents");
        payRate = Integer.parseInt(input);

        // Verify the pay is non-zero and positive
        while(payRate < 0 )
        {
            input = JOptionPane.showInputDialog(null, "Enter 1 or " + 
                                                           "greater.");

            payRate = Integer.parseInt(input);
        }

        // Get the number of days worked
        input = JOptionPane.showInputDialog(null, "Enter the number of days" +
                                                                    " worked");
        daysWorked = Integer.parseInt(input);

        // Verify the pay is non-zero and positive
        while(daysWorked < 0 )
        {
            input = JOptionPane.showInputDialog(null, "Enter 1 or " + 
                                                           "greater.");

            daysWorked = Integer.parseInt(input);
        }

        // Get the daily multiplier
        input = JOptionPane.showInputDialog(null, "Enter the multiplier per"+
                                                                " days worked");
        multiplier = Double.parseDouble(input);

        totalPay = 0; //Set accumulator to zero.


        
        //Calculate and display the total.
        JOptionPane.showMessageDialog(null, "Day          Pay (in cents)\n" +
                                     "---------------------------\n");
            //Get the payment per day.
            for (int daysCalculated = 0; daysCalculated <= daysWorked; daysCalculated++)
            {
                double dailyPay = (payRate * (daysCalculated * multiplier));
                System.out.println(daysCalculated + "           " + dailyPay );
                totalPay += dailyPay; // Add day's pay to total.
            }

            String.format("Total Pay: %,.2f Cents. \n\n", totalPay);

        System.exit(0);
        JOptionPane.showMessageDialog(null,0);
    }
}