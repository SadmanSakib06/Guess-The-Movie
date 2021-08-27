import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gameplay
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String pickedMovie = Read.readFile();
        char[] movie = pickedMovie.toCharArray();

        gameInterface(movie);
    }

    public static void gameInterface(char[] movie)
    {
        Scanner read = new Scanner(System.in);
        char input = '0';
        int right = 0;
        int countMatch = 0;
        int countSpace = 0;
        int wrongGuess = 0;
        char[] wrongGuesses = new char[20];
        char[] inputedName = new char[movie.length];
        boolean end = false;

        System.out.print("You are guessing:");
        for(int i = 0; i < movie.length; i++)
        {
            if(movie[i] != ' ')
            {
                inputedName[i] = '_';
            }
            else
            {
                inputedName[i] = ' ';
                countSpace++;
            }
            System.out.print(inputedName[i]);
        }
        System.out.print("\n");

        while(!end)
        {

            System.out.print("You have guessed (" + wrongGuess + ") wrong letters:");
            for(int i = 0; wrongGuesses[i] != '\0' ; i++){
                System.out.print(wrongGuesses[i] + " ");
            }
            System.out.print("\n");

            System.out.print("Guess a letter :");



            input = read.next().charAt(0);

            for(int i = 0; i < movie.length; i++) {
                if(input == movie[i]){
                    if(inputedName[i] != movie[i])
                        countMatch++;
                    inputedName[i] = movie[i];

                }
            }
            if(countMatch == 0)
            {
                wrongGuesses[wrongGuess] = input;
                wrongGuess++;
            }
            else
            {
                right += countMatch;
            }

            if(wrongGuess >= 10)
            {
                System.out.println("You Lose!");
                System.out.println("You couldn't guess '" + String.valueOf(movie) + "' correctly");
                break;
            }
            if(right + countSpace == movie.length)
            {
                System.out.println("You win!!!");
                System.out.println("You have guessed '" + String.valueOf(movie) + "' correctly");
                break;
            }

            System.out.print("You are guessing:");
            countMatch = 0;
            for(int i = 0; i < movie.length; i++)
            {
                System.out.print(inputedName[i]);
            }
            System.out.print("\n");
        }
    }
}
