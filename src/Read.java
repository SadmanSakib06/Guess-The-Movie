import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Read
{
    public static String array[] = new String[300];

    static String readFile() throws FileNotFoundException
    {
        File movieNames = new File("src/Movies.txt");
        Scanner read = new Scanner(movieNames);
        int i = 0;
        while(read.hasNextLine())
        {
            array[i] = read.nextLine();
            i += 1;
        }
        int index = randomIndex(i);

        return array[index];
    }

    static int randomIndex(int x)
    {
        Random roll = new Random();
        int number = roll.nextInt(x);
        return number;
    }
}

