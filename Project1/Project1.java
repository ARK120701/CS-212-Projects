import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Container;
import java.util.StringTokenizer;
import java.io.IOException;

public class Project1 {
    public static void main(String args[]) {
        DateGUI myDateGUI = new DateGUI(); // initilizing the GUI
        String[] Unsorted = inputFromFile(args[0]); // inputting textfile from commandline argument into an array using
        // a TextFileInput
        printUnSorted(myDateGUI, Unsorted); // print method to print out the data in an Unsorted order into a GUI
        String[] Sorted = inputFromFile(args[0]); // print method to print out the data in Sorted Order in the GUI
        printSorted(myDateGUI, Sorted);

    }

    public static void printSorted(DateGUI dg, String[] array) {
        Container myContentPane = dg.getContentPane(); // add content pane on GUI
        TextArea myWritingArea = new TextArea();
        myContentPane.add(myWritingArea); // add text area so you can append what you want to write
        Date212[] SortedD = new Date212[20]; // create Date212 array to store values
        myWritingArea.append("Sorted List Of Dates:\n");
        for (int i = 0; i < array.length; i++) { // convert string to Date212 objects and store them in an array and
                                                 // then print them to the GUI
            if (array[i] != null)

            {
                Date212 d = new Date212(array[i]);
                if (d.isValidDate()) { // validity checker to see if you can convert the text into a Date212 object
                    SortedD[i] = d; // filling up Date212 array

                }
            }
        }

        // Array contains some null values, so implement a null sorter to push all nulls
        // to end of array

        for (int i = 0; i < SortedD.length - 1; i++) {
            for (int j = i + 1; j < SortedD.length; j++) {
                if (SortedD[i] == null && SortedD[j] != null) {
                    SortedD[i] = SortedD[j];
                    SortedD[j] = null;
                }
            }
        }

        Sort212(SortedD); // sort method to sort the dates from earliest to latest
        for (int i = 0; i < SortedD.length; i++) {
            if (SortedD[i] == null)
                break; // once it hits null, theres no more date212 objects so we break

            myWritingArea.append((SortedD[i]) + "\n"); // prints each Date212 object to the GUI
        }

    }

    public static void printUnSorted(DateGUI dg, String[] array) { // same as above method but were adding the string
                                                                   // values as read from text file
                                                                   // then adding it to a Date212 array to be printed to
                                                                   // GUI
        Container myContentPane = dg.getContentPane();
        TextArea myTextArea = new TextArea();

        myContentPane.add(myTextArea);

        Date212[] dArray = new Date212[20];
        

        myTextArea.append("Unsorted List Of Dates:\n");
        for (int i = 0; i < array.length; i++) { // convert string to Date212 objects and store them in an array and
                                                 // then print them to the GUI
            if (array[i] != null)

            {
                Date212 d = new Date212(array[i]);
                if (d.isValidDate()) {
                    dArray[i] = d;
                    myTextArea.append((dArray[i]) + "\n");
                }
            }
        }

    }

    /**
     * @param filename
     * @return
     */
    public static String[] inputFromFile(String filename) { // inputTextFile method to take in data from text file and
                                                            // store them in string array
        TextFileInput in = new TextFileInput(filename);
        String line = in.readLine();

        String[] List = new String[100]; // array where we will store the values
        int i = 0;
        while (line != null) {
            StringTokenizer myTokens = new StringTokenizer(line, ","); // implement a tokenizer to break apart any texts
                                                                       // with commas(,)

            while (myTokens.hasMoreTokens()) {
                List[i] = myTokens.nextToken();
                i++;
            }
            line = in.readLine();
        }

        in.close();
        return List;
    }

    public static void Sort212(Date212[] dateArray) { // sorting method to sort date212 objects

        int n = dateArray.length;

        for (int i = 1; i < n; i++) {
            if (dateArray[i] == null) // null values indicate no more date212 objects so we can break the loop
                break;
            Date212 key = dateArray[i];
            int j = i - 1;
            // need null breaker
            while (j >= 0 && dateArray[j].compareTo(key) == 1) { // well switch the values if the value of the next
                                                                 // index is bigger than current index
                dateArray[j + 1] = dateArray[j];
                j--;
            }

            dateArray[j + 1] = key;
        }
    }

}
