import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class GuessTheMovie {
    public static void main(String[] args) throws FileNotFoundException{
        String[] movieNames=new String[25];
        File file=new File("movieNames.txt");
        Scanner scanner = new Scanner(file);
        int count=0;
        /* Adds movies from file to movinames array
        //TODO implement arraylist instead of array
         */

        while (scanner.hasNextLine()){
            movieNames[count]=scanner.nextLine();
            count++;
        }
        int choice=(int)(Math.random()*count); // generating random no to choose a movie from the array
        String currentMovie=movieNames[choice];
        NewGame newGame=new NewGame(currentMovie);
        newGame.gameInstance(); // the game starts here
        System.out.println("The game has ended");
    }

}
