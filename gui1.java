import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui1 implements ActionListener {
private int count;
private JFrame frame;
private  JPanel panel;
private JLabel label1;

public gui1() {


// make a frame 
frame = new JFrame();
// make a panel 
 panel = new JPanel();
// Set border from the frame, set a layout and set elements to the layout.
panel.setBorder(BorderFactory.createEmptyBorder(30,10,10,30));
panel.setLayout(new GridLayout(0,1));
frame.add(panel,BorderLayout.CENTER);
// Set what happen when you close the frame 
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Set the title 
frame.setTitle("OUR GUID");
// Set window to match a certain size
frame.pack();
// set the visable and in focus
frame.setVisible(true);


// now lets make a buttton and make it clickable and responsive

JButton button = new JButton("Click me");
panel.add(button);
// now to to make buttom responsive
button.addActionListener(this);



 // how to make a label 
label1 = new JLabel("Numb of Clicks : ");
 panel.add(label1);

}

    public static void main(String[] args) {
        new gui1();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        count++;
        label1.setText("Numb of count: " + count);
        
    }
}
