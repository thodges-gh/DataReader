import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Thomas Hodges on 7/8/15.
 * CMIS 141 - Week 8 Discussion
 * Reader.java
 * This program accepts text files that are tab-separated.
 * It will turn them into a 2D array and create it as an
 * object from the FileReader class.
 */
public class Reader {

    public void arrayMaker(String[] args) {
        // Try-catch is needed for passing args to method
        try {
            // Turns the txt file into one large string
            String content = new Scanner(new File(args[0]))
                    .useDelimiter("\\Z") // To the end of the file
                    .next();
            String[] rows = content.split("\n"); // Breaks up by new line
            // Creates a 2D array as "long" as the input file
            String[][] array = new String[rows.length][];

            // Fills the 2D array
            for (int i = 0; i < rows.length; i++) {
                array[i] = rows[i].split("\\t");
            }

            // Creates a new File object
            FileReader data = new FileReader(array);
            data.getAllData();
            data.lookForNumbers();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }



    public static void main(String[] args) {

        Reader reader = new Reader();
        reader.arrayMaker(args);

    }
}
