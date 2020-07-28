/**
 * Name: PABLO PORTILLO
 * Date: 9/20/2019
 * Class: CPS 121 FALL 2019
 * Purpose: TO PROMPT USER FOR INPUT AND OUTPUT IT IN DIFFERENT FORM
 */
import java.util.Scanner;

public class InputOutput 
{
    public static void main(String[] args) 
    {
        String firstName;
        String lastName;
        int birthMonth;
        int birthDay;
        int birthYear;

        Scanner keyboard = new Scanner(System.in);

        /**
         * Since using nextInt() would cause us to deal with nextLine()'s new line issue,
         * we prempt it and start with the prompts for strings rather than integers.
         */
        System.out.print("Please enter your first name: ");
        firstName = keyboard.nextLine();

        System.out.print("Please enter your last name: ");
        lastName = keyboard.nextLine();

        System.out.print("Please enter your birthday Month in format MM: ");
        birthMonth = keyboard.nextInt();

        System.out.print("Please enter your birth Day in format DD: ");
        birthDay = keyboard.nextInt();

        System.out.print("Please enter your birth Year in format YY: ");
        birthYear = keyboard.nextInt();

        //Simple concatenation
        System.out.println("Name: " + lastName + ", " + firstName);

        //I decided to omit the 
        System.out.println("Birthday: " + birthMonth + "/" + birthDay + "/" + birthYear);

        /**
         * It isn't best practice to leave resources open, leaking memory.
         * That being said, in this case it is not necessary, especially since 
         * System.in would be closed, making interacting with any part of the program
         * beyond  this point impossible. Since it is the end of the program, however,
         * I can close it out.
         */

        keyboard.close();
    }
}