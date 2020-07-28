import javax.swing.JOptionPane;

/**
 * Name:        Pablo Portillo
 * Date:        10/27/2019
 * Professor:   Fahringer
 * 
 * Program Purpose: To Grade NFL Quarterbacks
 */

 public class pepSportGrades
 {
     public static void main(String[] args)
     {
        String name;
        String input;
        double passes;
        double attempts;
        double receivingYards;
        double passingTDs;
        double passingIntercept;
        double rushedYards;

        int scorePercentComplete;
        int scoreYardsGained;
        int scoreTDPasses;
        int scoreIntercepts;
        int scoreRushing;
        int total;

        name = JOptionPane.showInputDialog("What is the QB's Name?");

        input = JOptionPane.showInputDialog("How many passes were completed?");
        passes = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("How many passes were attempted?");
        attempts = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("How many recieved yards?");
        receivingYards = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("How many passes were Touchdowns?");
        passingTDs = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("How many passes were intercepted?");
        passingIntercept = Double.parseDouble(input);

        input = JOptionPane.showInputDialog("How many yards were rushed?");
        rushedYards = Double.parseDouble(input);

        scorePercentComplete = percentComplete(passes, attempts);
        scoreYardsGained = avrYardGained(receivingYards, attempts);
        scoreTDPasses        = touchdownPasses(passingTDs, attempts);
        scoreIntercepts      = percentIntercept(passingIntercept, attempts);
        scoreRushing         = rushingYards(rushedYards);
        total = sum(scorePercentComplete, scoreYardsGained, scoreTDPasses, scoreIntercepts, scoreRushing);

        showStats(name, passes, attempts, receivingYards, passingTDs, passingIntercept, rushedYards);

        showScore(name, scorePercentComplete, scoreYardsGained, scoreTDPasses, scoreIntercepts, scoreRushing, total);
        
     }

     

     public static int percentComplete(double completes, double attempts)
     {
        double percent = ((completes / attempts) * 100);
        percent -= 30.0;
        double rating = (percent * 0.05)*8;
        if ((int)rating < 0)
         {
            int scorePercentComplete = 0;
            return scorePercentComplete;
            
         }
         else if ((int)rating >20)
         {
            int scorePercentComplete = 20;
            return scorePercentComplete;
         }
         else
         {
            int scorePercentComplete = (int)rating;
            return scorePercentComplete;
         }
     }

     public static int avrYardGained(double yards, double attempts) 
     {
         double yardsPerAttempt = yards / attempts;
         double rating = ((yardsPerAttempt-3)*.25)*9;
         if ((int)rating < 0)
         {
            int scoreYardsGained = 0;
            return scoreYardsGained;
         }
         else if ((int)rating >20)
         {
            int scoreYardsGained = 20;
            return scoreYardsGained;
         }
         else
         {
            int scoreYardsGained = (int)rating;
            return scoreYardsGained;
         }
         
     }

     public static int touchdownPasses(double touchdowns, double attempts)
     {
         double touchdownPercent = (touchdowns / attempts) * 100;
         double rating = (touchdownPercent*0.2)*9;
         if ((int)rating < 0)
         {
            int scoreTDPasses = 0;
            return scoreTDPasses;
         }
         else if ((int)rating > 20)
         {
            int scoreTDPasses = 20;
            return scoreTDPasses;
         }
         else 
         {
            int scoreTDPasses = (int)rating;
            return scoreTDPasses;
         }
     }

     public static int percentIntercept(double interceptions, double attempts)
     {
         double interceptPercent = (interceptions / attempts) * 100;
         double rating = (2.375-(interceptPercent*0.25))*10;
         if ((int)rating < 0)
         {
            int scoreIntercepts = 0;
            return scoreIntercepts;
         }
         else if ((int)rating > 20)
         {
            int scoreIntercepts = 20;
            return scoreIntercepts;
         }
         else 
         {
            int scoreIntercepts = (int)rating;
            return scoreIntercepts;
         }
     }

     public static int rushingYards(double yards)
     {
         int rating = (int)(yards / 5);
         if ((int)rating < 0)
         {
            int scoreRushing = 0;
            return scoreRushing;
         }
         else if ((int)rating > 20)
         {
            int scoreRushing = 20;
            return scoreRushing;
         }
         else 
         {
            int scoreRushing = (int)rating;
            return scoreRushing;
         }
     }

     public static int sum(int score0, int score1, int score2, int score3,  int score4) 
     {
        int total = score0 + score1 + score2 + score3 + score4;
        return total;
     }

     public static void showStats(String name, double passes, double attempts, double receivingYards, double passingTDs, double passingIntercept, double rushedYards)
     {
         JOptionPane.showMessageDialog(null, String.format(
         " %s's stats were:\n"  + 
         "Completed Passes.........................%.0f \n" + 
         "Attempted Passes.........................%.0f \n" + 
         "Receiving Yards..........................%.0f \n" + 
         "Passing Touchdowns.......................%.0f \n" + 
         "Passing Intercepts.......................%.0f \n" + 
         "Rushed Yards.............................%.0f", name, passes, attempts, receivingYards, passingTDs, passingIntercept, rushedYards);
     }
     
     public static void showScore(String name, int scorePercentComplete, int scoreYardsGained, int scoreTDPasses, int scoreIntercepts, int scoreRushing, int total)
     {
         JOptionPane.showMessageDialog(null, name +  "'s scores were:\n"  + 
        "% of Completions...................." + scorePercentComplete + "\n" + 
        "Average Yards Gained Per Attempt...." + scoreYardsGained + "\n" + 
        "% of Touchdown Passes..............." + scoreTDPasses + "\n" + 
        "% of Interceptions.................." + scoreIntercepts + "\n" + 
        "Rushing Yards......................." + scoreRushing + "\n" +
        "TOTAL..............................." + total + "\n");
     }
}