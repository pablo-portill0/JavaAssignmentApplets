import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        11/3/2019
 * Professor:   Fahringer
 * 
 * Program Purpose: To translate alphabetic telephone numbers to all numbers.
 */

 public class pepTelephoneTranslator
 {
     public static void main(String[] args)
     {
         String input;

         /**
          * These arrays are matched, with any alphabet[i] corresponding with
            numbers[i]. This way, we can use the same index for the replacement
            function, simplifying the method greatly. This is also much more maintainable and extendible. 
          */
         String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

         String[] numbers = {"2","2","2","3","3","3","4","4","4","5","5","5","6","6","6","7","7","7","7","8","8","8","9","9","9","9"};

         StringBuilder finalNumber = new StringBuilder();

         input = JOptionPane.showInputDialog( "Input your alphabetic phone" +
                            "number.\nUse only hypens (-) to seperate sets!" +
                            "\nUse pattern XXX-XXX-XXXX");

        // This method helps avoid any issue with cases not matching.
         input = input.toUpperCase();

         // We can now put this input through our conversion method and get the
         // final converted number
         finalNumber.append(convertAlphaNumeral(input, alphabet, numbers));

         // We now give this number back to the user, converted.
         JOptionPane.showMessageDialog(null, "Your converted phone number is " +
                                                                finalNumber);
        
     }

     // This is the method we'll use to convert all the letters in the phone # 
     // to digits. It ignores any numbers existing and 
     public static String convertAlphaNumeral(String str, String[] arrayL, String[] arrayN)
     {
         // This replaces each letter and number pair with each iteration
        for (int index = 0; index < arrayL.length && index < arrayN.length; index++)
        {
            String strTempL = arrayL[index];
            String strTempN = arrayN[index];
            str = str.replace(strTempL, strTempN);
        }

        // We now return the completely converted string back to main.
        return str;
     }
 }