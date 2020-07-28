import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

public class pepGuessingGame
{
    public static void main(String[] args)
    {
        String input;
        int userGuess = 0;
        int numOfGuesses = 0;
        
        do 
        {
            //This creates a random number bounded by the given range
            int randomNum = ThreadLocalRandom.current().nextInt(1, 1025);
            input = JOptionPane.showInputDialog("Guess the random number!");
            userGuess = Integer.parseInt(input);
            numOfGuesses++;

            //While the user has not guessed the number, we iterate through
            //this code.
            while (userGuess != randomNum){
                
                if (userGuess > randomNum)
                {
                    input = JOptionPane.showInputDialog("Too high, guess lower!");
                }
                else if (userGuess < randomNum)
                {
                    input = JOptionPane.showInputDialog("Too low, guess higher!");
                }
                userGuess = Integer.parseInt(input);
                numOfGuesses++;
            }
        //When the player finishes, the dialog prompts to either end the program
        //or continue to iterate and play the game.
        } while (JOptionPane.showConfirmDialog(null,"You got it! It took " +
                                numOfGuesses + " guesses. Play again?") == 0);
    }
}