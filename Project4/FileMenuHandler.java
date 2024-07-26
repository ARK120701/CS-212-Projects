import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Container;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Container;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileMenuHandler  implements ActionListener {
    private Date212GUI dg;

    public FileMenuHandler(Date212GUI jf) {
        dg = jf;
    }

    
    /** 
     * creates Actionevent object for when an option o the GUI is clicked, if "open" is clicked it opens any file
     * if "quit" is clicked it exits the GUI
     * @param event
     */
    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Open"))
            openFile();
        else if (menuName.equals("Quit"))
            System.exit(0);
    } // actionPerformed

    private void openFile() {
        int status;
        JFileChooser chooser = new JFileChooser();
        status = chooser.showOpenDialog(null);
        readSource(chooser.getSelectedFile());
    } // openFile

    
    /** 
     *  reads the opened file and posts it to the GUI 
     * @param chosenFile
     */
    private void readSource(File chosenFile) {
        String chosenFileName = chosenFile.getAbsolutePath();
        dg.read(chosenFileName);
        /*TextFileInput in = new TextFileInput(chosenFileName);
        String line = in.readLine();
        ArrayList<Date212> UL = new ArrayList<Date212>();

        while (line != null) {
            try {

                StringTokenizer myTokens = new StringTokenizer(line, ","); // implement a tokenizer to break apart any
                                                                           // texts
                                                                           // with commas(,)

                while (myTokens.hasMoreTokens()) {
                    Date212 d = new Date212(myTokens.nextToken());
                    if (d.isValidDate()) {
                        UL.add(d);
                    }

                }
            }

            catch (IllegalDate212Exception e) {
                System.out.println(e.getMessage());
            }

            finally {
                line = in.readLine();
            }
        }

        in.close();

        ArrayList<Date212> SL = new ArrayList<Date212>();
        SL.addAll(UL);
        Collections.sort(SL, new Date212.Sort());

        // print Unsorted
        Container myContentPane = dg.getContentPane();
        TextArea myTextArea = new TextArea();
        myContentPane.add(myTextArea);
        myTextArea.append("Unsorted List Of Dates:\n");
        UL.trimToSize();
        for (Date212 date : UL) {
            myTextArea.append(date.toString() + "\n");
        }

        // Print Sorted
        Container mCP = dg.getContentPane(); // add content pane on GUI
        TextArea myWritingArea = new TextArea();
        mCP.add(myWritingArea);
        myWritingArea.append("Sorted List Of Dates:\n");
        SL.trimToSize();
        for (Date212 date : SL) {
            myWritingArea.append(date.toString() + "\n");
        }

        dg.setVisible(true);
        */

    }

}