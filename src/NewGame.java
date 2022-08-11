import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NewGame {
    public String movieName="";
    int movieLength=0;
    int chances=10;
    ArrayList<Character> wrongGuessedChars=new ArrayList<>();
    int wrongGuesses=0;
    //Constructor setting the movie name.
    NewGame(String movieName){
        this.movieName =movieName;
    }
    // returns the updated char array after correct user entry.
    public char[] setString(char[] partialString, ArrayList<Integer> charLocations, char input){
        int loc;
        for (Integer charLocation : charLocations) {
            loc = charLocation;
            partialString[loc] = input;
        }
        return partialString;
    }
    // returns an Integer ArrayList with locations in the movie string of the character entered by the user.
    public ArrayList<Integer> whereCharacters(char input) {
        ArrayList<Integer> charLocations =new ArrayList<>();
        int currIndex=0;
        for (int i = 0; i < movieLength; i++) {
            if (input==movieName.charAt(i)) {
                charLocations.add(i);
            }
        }
        //System.out.println("CharLocations: "+ charLocations);

        return charLocations;
    }
    // checks if the user-entered character is in the movie string.
    public boolean compareChar(char input){
        boolean hasLetter=false;
        for (int i=0;i<movieLength;i++) {
            if (input == movieName.charAt(i)) {
                hasLetter = true;
                break;
            }
        }
        return hasLetter;
    }
    // Creates a string with '-' for each character and retains spaces of the movieName String
    public char[] setSpaces() {
        char[] spacedString=new char[movieLength];
        for(int i=0;i<movieLength;i++){
            if (movieName.charAt(i)==' ') {
                spacedString[i] = ' ';
            } else spacedString[i]='-';
        }
        return spacedString;
    }
    /*
     this method checks whether the player has won or not i.e. if the user has guessed
     all the characters correctly.
    */
    public boolean checkWin(char [] partialString){
        return !String.valueOf(partialString).contains("-");
    }

    // New instance of game.
    public void gameInstance(){
        movieLength=movieName.length();
        char[] partialString=setSpaces();

//        Arrays.fill(wrongGuessedChars, ' ');

        Scanner scanner=new Scanner(System.in);
        System.out.println("You are guessing: "+ String.valueOf(partialString));
        System.out.println(" Guess one letter of this movie title:");

        while(chances>0) {
            char userInput= scanner.next().charAt(0);
            boolean result=compareChar(userInput);
//            System.out.println(result);
            if (result) {
                if (String.valueOf(partialString).contains(String.valueOf(userInput))){
                    System.out.println("You have already guessed that, try something else!");
                } else{
                partialString=setString(partialString, whereCharacters(userInput),userInput);
                System.out.println("Correct!");
                }
            }
            else {
                if (!wrongGuessedChars.contains(userInput)) {
                    wrongGuessedChars.add(userInput);
                    chances--;
                }
                System.out.println("Oops! That doesn't seem correct");
                System.out.println("Your wrong guesses:" + wrongGuessedChars.toString());
                System.out.println("attempts left: " + chances);
            }
            System.out.println("You are guessing: "+String.valueOf(partialString));
            if(checkWin(partialString)) {
                System.out.println("Congratulation, You have guessed correctly");
                return;
            }


        }
        System.out.println("Sorry! You are out of attempts, the movie you were trying to guess was: "+movieName);
    }



}
