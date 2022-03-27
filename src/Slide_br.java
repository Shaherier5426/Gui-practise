


import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Rectangle;


public class Slide_br extends JFrame {
   static int x = 0;
   JButton bNext = new JButton();
   JButton bPrevious = new JButton();
   TitledBorder titledBorder1 = new TitledBorder("");
   JLabel lblPhoto = new JLabel();
   TitledBorder titledBorder2 = new TitledBorder("");
   public Slide_br() {
      try {
         jbInit();
      }
         catch (Exception e) {
         }
   }
   private void jbInit() throws Exception {
      getContentPane().setLayout(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setResizable(false);
      this.setTitle("Simple Photo Viewer");
      this.setBounds(50,10,1010,660);
      this.setVisible(true);
      this.addWindowListener(new Slide_br_this_windowAdapter(this));
      lblPhoto.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
      lblPhoto.setHorizontalAlignment(JLabel.CENTER);
      lblPhoto.setBorder(titledBorder2);
      lblPhoto.setBounds(new Rectangle(2, 0, 1000, 560));
      bNext.setBounds(new Rectangle(710, 560, 118, 46));
      bNext.setToolTipText("Show next image");
      bNext.setText("Next");
      bNext.addMouseListener(new Slide_br_bNext_mouseAdapter(this));
      bNext.addActionListener(new Slide_br_bNext_actionAdapter(this));
      bNext.setMnemonic('N');
      bPrevious.setBounds(new Rectangle(471, 560, 118, 46));
      bPrevious.setToolTipText("Show Previous Photo");
      bPrevious.setText("Previous");
      bPrevious.addActionListener(new Slide_br_bPrevious_actionAdapter(this));
      bPrevious.setMnemonic('P');
      this.getContentPane().add(lblPhoto);
      this.getContentPane().add(bNext);
      this.getContentPane().add(bPrevious);
      this.viewSlide_br();
   }
   public void viewSlide_br(){
      String file = "slide_br" + Integer.toString(x) + ".jpg";
      File f = new File(file);
      if (!f.exists()) {
         x = -1;
      }
      ImageIcon i = new ImageIcon(file);
      lblPhoto.setIcon(i);
   }
   public static void main(String args[]){
      Slide_br pho = new Slide_br();
   }
   public void bPrevious_actionPerformed(ActionEvent e) {
      if(x>0) {
         x--;
         this.viewSlide_br();
      }
   }
   public void bNext_actionPerformed(ActionEvent e) {
      if (x < 24){
		x++;
		this.viewSlide_br();
	  } else {
		System.exit(0);
		setVisible(false); //you can't see me!
		this.dispose(); //Destroy the JFrame object
	  }
   } 
}
class Slide_br_this_windowAdapter extends WindowAdapter {
   private Slide_br adaptee;
   Slide_br_this_windowAdapter(Slide_br adaptee) {
      this.adaptee = adaptee;
   }
}
class Slide_br_bNext_mouseAdapter extends MouseAdapter {
   private Slide_br adaptee;
   Slide_br_bNext_mouseAdapter(Slide_br adaptee) {
      this.adaptee = adaptee;
   }
}
class Slide_br_bNext_actionAdapter implements ActionListener {
   private Slide_br adaptee;
   Slide_br_bNext_actionAdapter(Slide_br adaptee) {
      this.adaptee = adaptee;
   }
   public void actionPerformed(ActionEvent e) {
      adaptee.bNext_actionPerformed(e);
   }
}
class Slide_br_bPrevious_actionAdapter implements ActionListener {
   private Slide_br adaptee;
   Slide_br_bPrevious_actionAdapter(Slide_br adaptee) {
      this.adaptee = adaptee;
   }
   public void actionPerformed(ActionEvent e) {
      adaptee.bPrevious_actionPerformed(e);
   }
}