/**
 * Created by Thomas Hodges on 7/8/15.
 * CMIS 141 - Week 8 Discussion
 * FileReader.java
 * This class deals with the data given as a command
 * line argument as an object.
 */
public class FileReader {

    // Private data fields
    private String[][] fileData;
    private int intValues;
    private int doubleValues;
    private int stringValues;

    // Default constructor
    public FileReader(String[][] data) {
        this.fileData = data;
    }

    // Returns the entire array
    public void getAllData() {
        for (String[] row : fileData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }

    // Finds the numbers
    public void lookForNumbers() {
        for (String[] row : fileData) {
            for (String cell : row) {

                try {
                    Integer.parseInt(cell);
                    this.intValues++;

                } catch (NumberFormatException e) {
                    // Not an integer
                }
                try {
                    Double.parseDouble(cell);
                    this.doubleValues++;
                } catch (NumberFormatException e) {
                    // Not a number
                    this.stringValues++;
                }
            }
        }

        this.doubleValues = this.doubleValues - this.intValues;
        System.out.println("\nNumber of strings: " + this.stringValues);
        System.out.println("Number of doubles: " + this.doubleValues);
        System.out.println("Number of ints: " + this.intValues);

    }

}
