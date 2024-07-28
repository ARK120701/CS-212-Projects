import java.util.StringTokenizer;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Container;
import java.util.StringTokenizer;
import java.io.IOException;
public class Project2 {

    
    /** 
     *@author Abdurrahman Khan
     *@version 1.0
     * @param args[] takes in command line arguments for the data file and stores it in args[0]
     */
    public  static void main(String args[]) {
        Date212GUI dg = new Date212GUI();
        SortedDate212List SL =  new SortedDate212List();
        UnsortedDate212List UL = new UnsortedDate212List();
        printUS(UL, args[0], dg);
        printSL(SL, args[0], dg);
    }

    
    /** 
     *Prints unsorted linked list
     * 
     * <p>  we use our TextfileInput class toread in our data file, and label it as in. we create a string variable to store each data from the textfile.
     * <p> we use a string tokenizer along with out Textfile input to read through the data file and add them to our linked list by first converting it to a Date212 object, then checking if its a valid object, and then add it to our unsortedlinked list
     * <p> create an area on our gui to display the dates. we travers through the linked list and print them to our gui
     * <p>
     * @param UL  unsorted linked list that will be printed
     * @param fn  the filename in which we have our data
     * @param dg name of our gui that will rint out our unsorted linkedlist
     */
    public static void printUS( UnsortedDate212List UL, String fn, Date212GUI dg) {
        TextFileInput in = new TextFileInput(fn);
        String line = in.readLine();

        while (line != null)

        {
            StringTokenizer myTokens = new StringTokenizer(line, ","); // implement a tokenizer to break apart any texts
                                                                       // with commas(,)

            while (myTokens.hasMoreTokens()) {
                Date212 d = new Date212(myTokens.nextToken());
                if (d.isValidDate()) {
                    UL.add(d);
                }

            }
            line = in.readLine();
        }

        in.close();


        // print now
        Container myContentPane = dg.getContentPane();
        TextArea myTextArea = new TextArea();
         myContentPane.add(myTextArea);
         myTextArea.append("Unsorted List Of Dates:\n");

         // traverse through linked list and print data
         
         Date212Node current = UL.first;
         while((current = current.next) != null) {
         myTextArea.append(current.data + "\n");
         }
         
     }










    

    
    /** 
    *Prints unsorted linked list
     * 
     * <p>  we use our TextfileInput class to read in our data file, and label it as in. we create a string variable to store each data from the textfile.
     * <p> we use a string tokenizer along with out Textfile input to read through the data file and add them to our linked list by first converting it to a Date212 object, then checking if its a valid object, and then add it to our Sortedlinked list
     * <p> create an area on our gui to display the dates. we travers through the linked list and print them to our gui
     * <p>
     * @param SL Sorted Linkedlist which well use to add nodes and then print to gui
     * @param fn file name that contains the data
     * @param dg gui where well print our dates
     */
    public static  void printSL(SortedDate212List SL, String fn, Date212GUI dg) {
        TextFileInput in = new TextFileInput(fn);
        String line = in.readLine();

        while (line != null)

        {
            StringTokenizer myTokens = new StringTokenizer(line, ","); // implement a tokenizer to break apart any texts
                                                                       // with commas(,)

            while (myTokens.hasMoreTokens()) {
                Date212 d = new Date212(myTokens.nextToken());
                if (d.isValidDate()) {
                    SL.add(d);
                }
            }
            line = in.readLine();
        }

        in.close();

        // print
        Container myContentPane = dg.getContentPane(); // add content pane on GUI
        TextArea myWritingArea = new TextArea();
        myContentPane.add(myWritingArea);
        myWritingArea.append("Sorted List Of Dates:\n");
       
        Date212Node current = SL.first;
         while((current = current.next) != null) {
         myWritingArea.append(current.data + "\n");
         }
       

        
    }
}
