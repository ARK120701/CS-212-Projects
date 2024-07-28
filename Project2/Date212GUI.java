import javax.swing.JFrame;
import java.awt.GridLayout;

public class Date212GUI extends JFrame {

    /**
     * consturctor for gui object
     */
    public Date212GUI() {
        setSize(500, 500); // sizeof the GUI
        setLocation(100, 100); // sets where on your screen you want the GUI
        setTitle("Date"); // sets the name at the top of your GUI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // adds a close option that exits tje GUI if clicked
        setLayout(new GridLayout(1, 2)); // divides the GUI into two different layers
        setVisible(true);// allows the GUI to be seen
    }
}