


import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Rectangle;


public class Slide_l extends JFrame {
   static int x = 0;
   JButton bNext = new JButton();
   JButton bPrevious = new JButton();
   TitledBorder titledBorder1 = new TitledBorder("");
   JLabel lblPhoto = new JLabel();
   TitledBorder titledBorder2 = new TitledBorder("");
   public Slide_l() {
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
      this.addWindowListener(new Slide_l_this_windowAdapter(this));
      lblPhoto.setFont(new java.awt.Font("Arial", Font.BOLD, 30));
      lblPhoto.setHorizontalAlignment(JLabel.CENTER);
      lblPhoto.setBorder(titledBorder2);
      lblPhoto.setBounds(new Rectangle(2, 0, 1000, 560));
      bNext.setBounds(new Rectangle(710, 560, 118, 46));
      bNext.setToolTipText("Show next image");
      bNext.setText("Next");
      bNext.addMouseListener(new Slide_l_bNext_mouseAdapter(this));
      bNext.addActionListener(new Slide_l_bNext_actionAdapter(this));
      bNext.setMnemonic('N');
      bPrevious.setBounds(new Rectangle(471, 560, 118, 46));
      bPrevious.setToolTipText("Show Previous Photo");
      bPrevious.setText("Previous");
      bPrevious.addActionListener(new Slide_l_bPrevious_actionAdapter(this));
      bPrevious.setMnemonic('P');
      this.getContentPane().add(lblPhoto);
      this.getContentPane().add(bNext);
      this.getContentPane().add(bPrevious);
      this.viewSlide_l();
   }
   public void viewSlide_l(){
      String file = "slide_l" + Integer.toString(x) + ".jpg";
      File f = new File(file);
      if (!f.exists()) {
         x = -1;
      }
      ImageIcon i = new ImageIcon(file);
      lblPhoto.setIcon(i);
   }
   public static void main(String args[]){
      Slide_l pho = new Slide_l();
   }
   public void bPrevious_actionPerformed(ActionEvent e) {
      if(x>0) {
         x--;
         this.viewSlide_l();
      }
   }
   public void bNext_actionPerformed(ActionEvent e) {
      if (x < 24){
		x++;
		this.viewSlide_l();
	  } else {
		System.exit(0);
		setVisible(false); //you can't see me!
		this.dispose(); //Destroy the JFrame object
	  }
   } 
}
class Slide_l_this_windowAdapter extends WindowAdapter {
   private Slide_l adaptee;
   Slide_l_this_windowAdapter(Slide_l adaptee) {
      this.adaptee = adaptee;
   }
}
class Slide_l_bNext_mouseAdapter extends MouseAdapter {
   private Slide_l adaptee;
   Slide_l_bNext_mouseAdapter(Slide_l adaptee) {
      this.adaptee = adaptee;
   }
}
class Slide_l_bNext_actionAdapter implements ActionListener {
   private Slide_l adaptee;
   Slide_l_bNext_actionAdapter(Slide_l adaptee) {
      this.adaptee = adaptee;
   }
   public void actionPerformed(ActionEvent e) {
      adaptee.bNext_actionPerformed(e);
   }
}
class Slide_l_bPrevious_actionAdapter implements ActionListener {
   private Slide_l adaptee;
   Slide_l_bPrevious_actionAdapter(Slide_l adaptee) {
      this.adaptee = adaptee;
   }
   public void actionPerformed(ActionEvent e) {
      adaptee.bPrevious_actionPerformed(e);
   }
}