import javax.swing.JOptionPane;
public class Project0 { 
    public static void main (String[] args){
     
      while(true){  // loop to keep on running so user can constantly put inputs
       String name = JOptionPane.showInputDialog("Enter a sentence or Stop to quit"); // produces image with phrase in parenthesis
       int countE=0, counte=0;  // counter variables to count amount of E and e
       System.out.println(name);
        if( name.equalsIgnoreCase("stop")) break; // break out of loop if user inputs stop, or any variation of stop with upper/lower case letters
        for(int i=0; i<name.length();i++){
            char current=name.charAt(i);   // variable to store the char at index. for loop traverses through the whole phrase. Charat returns the char at index i
            if(current=='e') counte++;
            else if (current=='E') countE++;
        }
        String message = "# of E is: "+ countE + " \n # of e is:"+ counte; 
        JOptionPane.showMessageDialog(null,  message );// produces image that outputs variable message
       
      


        


    }
}
}