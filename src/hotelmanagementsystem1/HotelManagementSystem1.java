
package hotelmanagementsystem1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem1 extends JFrame implements ActionListener {
    HotelManagementSystem1(){
    setSize(1166,565);
    setLocation(100, 50);
    setLayout(null);
    ImageIcon il =new ImageIcon(ClassLoader.getSystemResource("icons/icons/first.jpg"));
    JLabel image =new JLabel(il);
    image.setBounds(0,0,1166,565);//locationx,locationy,length,breath
    add(image);
    
    JLabel text=new JLabel("HOTAL MANAGEMENT SYSTEM");
    text.setBounds(20,430,1000,90);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("serit",Font.PLAIN,50));
    image.add(text);
    
    JButton next =new JButton("NEXT");
    next.setBounds(980,450,150,50);
   next.setBackground(Color.WHITE);
   next.addActionListener(this);
    image.add(next);
    setVisible(true);
    
    while(true){
    text.setVisible(false);
   try{
   Thread.sleep(500);
   }catch(Exception e){
   e.printStackTrace();
   }
    text.setVisible(true);
    try{
    Thread.sleep(500);
    }catch(Exception e){
    e.printStackTrace();
    }
    }
    }
    public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new Login();
            
            
    }
  
    public static void main(String[] args) {
       new HotelManagementSystem1();
    }
    
}
