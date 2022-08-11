import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class GuessTheMovie {
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<String> movieNames=new ArrayList<>();
        File file=new File("movieNames.txt");
        Scanner scanner = new Scanner(file);

//      Adds movies from file to movinames array
        while (scanner.hasNextLine()) {
            movieNames.add(scanner.nextLine());
        }
        int count = movieNames.size();
        int choice=(int)(Math.random()*count); // generating random no to choose a movie from the array
        String currentMovie=movieNames.get(choice);
        NewGame newGame=new NewGame(currentMovie);
        newGame.gameInstance(); // the game starts here
        System.out.println("The game has ended");
    }

}
