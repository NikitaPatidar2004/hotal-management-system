
package hotelmanagementsystem1;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;
public class Checkout extends JFrame implements ActionListener {

         Choice ccustomer;   
         JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
         JButton checkout, back;
    
        Checkout(){
          getContentPane().setBackground(Color.white);
          setLayout(null);
          
          JLabel text = new JLabel("Checkout");
          text.setBounds(100,20,100,30);
          text.setForeground(Color.blue);
          text.setFont(new Font("Tahoma",Font.PLAIN,20));
          add(text);
          
          JLabel lblid= new JLabel("Customer Id");
          lblid.setBounds(30,80,100,30);
          add(lblid);
          
           ccustomer = new Choice();
          ccustomer.setBounds(150,80,120,25);
         add(ccustomer);
         
         
         
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        lblroomnumber= new JLabel();
        lblroomnumber.setBounds(150,130,100,30);
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);
        
         lblcheckintime= new JLabel();
        lblcheckintime.setBounds(150,180,100,30);
        add(lblcheckintime);
        
          JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);
        
        Date date = new Date();
        
         lblcheckouttime= new JLabel("" + date);
        lblcheckouttime.setBounds(150,230,150,30);
        add(lblcheckouttime);
        
        checkout= new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
         back= new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);
        
         try{
             Conn c= new Conn();
             ResultSet rs=c.s.executeQuery("select * from customer");
             while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblcheckintime.setText(rs.getString("checkintime"));
             }
            
         
         }catch (Exception e){
             
             e.printStackTrace();
         }
          
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/sixth.jpg"));
     Image i5= i4.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
     ImageIcon i6= new ImageIcon(i5);
     JLabel image = new JLabel(i6);
     image.setBounds(350,50,400,250);
     add(image);
     
        
        setBounds(300,200,800,400);
        setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()== checkout){
               String query1 ="delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
               String query2 = "update room set availability ='Available' where roomnumber='"+lblroomnumber.getText()+"'";
               
               try{
                    Conn c = new Conn();
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Checkout Done");
                    setVisible(false);
                    new Reception();
               
               }catch(Exception e){
                  e.printStackTrace();
               }
               
            }else {
              setVisible(false);
              new Reception();
            }       
        
        }
        
     public static void main(String[] aa)   {
        new Checkout();
     
     }
}
