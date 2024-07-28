import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.awt.GridLayout;
import java.io.File;
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

public class Date212GUI extends JFrame {

    private ArrayList<Date212> UL;
    private ArrayList<Date212> SL;
    private TextArea TA;
    private TextArea sTA;

           /**
    
     * constructor for gui object
     */
    public Date212GUI() {
        setSize(500, 500); // sizeof the GUI
        setLocation(100, 100); // sets where on your screen you want the GUI
        setTitle("Date"); // sets the name at the top of your GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // adds a close option that exits tje GUI if clicked
        setLayout(new GridLayout(1, 2)); // divides the GUI into two different layers
        setVisible(true);// allows the GUI to be seen

        UL = new ArrayList<>();
        SL = new ArrayList<>();
        TA= new TextArea();
        sTA= new TextArea();
        createMenu();

    }

   public void read( String f){
      TextFileInput in = new TextFileInput(f);
        String line = in.readLine();
        UL.clear();
        SL.clear();
       

        while (line != null) {
            try {

                StringTokenizer myTokens = new StringTokenizer(line, ","); // implement a tokenizer to break apart any
                                                                           // texts
                                                                           // with commas(,)

                while (myTokens.hasMoreTokens()) {
                    Date212 d = new Date212(myTokens.nextToken());
                    if (d.isValidDate()) {
                        System.out.println(d.toString()+ " is a valid date");
                        UL.add(d);
                    }
                    else {
                        System.out.println(d.toString()+ " is a invalid date");

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

       
        SL.addAll(UL);
        Collections.sort(SL, new Date212.Sort());

        // print Unsorted
       // Container myContentPane = getContentPane();
       // TextArea TA = new TextArea();
        //myContentPane.add(TA);
        
        UL.trimToSize();
         TA.setText("");
         TA.append("Unsorted List Of Dates:\n");
        for (Date212 date : UL) {
            TA.append(date.toString() + "\n");
        }

        // Print Sorted
        //Container mCP = getContentPane(); // add content pane on GUI
        //TextArea sTA = new TextArea();
        //mCP.add(sTA);
       
        SL.trimToSize();
         sTA.setText("");
         sTA.append("Sorted List Of Dates:\n");
        for (Date212 date : SL) {
            sTA.append(date.toString() + "\n");
        }
   }
   
     public void display(int n){ 
    //Container mCP = getContentPane(); // add content pane on GUI
        //TextArea myWritingArea = new TextArea();
        //mCP.add(myWritingArea);
       //TA.setText("");
        sTA.setText("");
        sTA.append(" List Of Dates with year " + n +" :\n");
        SL.trimToSize();
        for (Date212 date : SL) {
            if (date.getYear() == n)
                sTA.append(date.toString() + "\n");
        }
   }
    
   
   
   private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem item;
        FileMenuHandler fmh = new FileMenuHandler(this);

        item = new JMenuItem("Open");
        item.addActionListener(fmh);
        fileMenu.add(item);

        fileMenu.addSeparator();

        item = new JMenuItem("Quit");
        item.addActionListener(fmh);
        fileMenu.add(item);

       /* EditMenuHandler emh = new EditMenuHandler(this);
        JMenu fileMenu1 = new JMenu("Edit");
        item = new JMenuItem("Search");
        item.addActionListener(emh);
        fileMenu1.add(item);*/

        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
       // menuBar.add(fileMenu1);
        Container mCP = getContentPane();
         mCP.add(TA);
         
         Container CP = getContentPane();
         CP.add(sTA);
        
        
    } // createMenu

}