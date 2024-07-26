import javax.swing.JOptionPane;
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

public class EditMenuHandler implements ActionListener {
    private Date212GUI jframe;

    public EditMenuHandler(Date212GUI jf) {
        jframe = jf;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand();
        if (menuName.equals("Search"))
            displayDates();
        // openFile();
        // else if (menuName.equals("Quit"))
        // System.exit(0);
    } // actionPerformed

    public void displayDates() {
        String n = JOptionPane.showInputDialog(null, "Please enter a number: ");
        int x = Integer.parseInt(n);
         jframe.display(x);
        // create new gui that will display dates
       /*  TextFileInput in = new TextFileInput("dym.txt");
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

        Container mCP = jframe.getContentPane(); // add content pane on GUI
        TextArea myWritingArea = new TextArea();
        mCP.add(myWritingArea);
        myWritingArea.append("Sorted List Of Dates:\n");
        SL.trimToSize();
        for (Date212 date : SL) {
            if (date.getYear() == x)
                myWritingArea.append(date.toString() + "\n");
        }
        */
    }
}
