package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Emp_Update extends JFrame {

	private JPanel contentPane;
	private JTextField desig;
	private JTextField sal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emp_Update frame = new Emp_Update("","","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Emp_Update(String eid1,String Name1,String Designation,String Department,String Salary,String Age) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEid = new JLabel("Update");
		lblEid.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/change(1).png")));
		lblEid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEid.setBounds(123, 13, 152, 64);
		contentPane.add(lblEid);
		
		JLabel lblEid_1 = new JLabel("EID");
		lblEid_1.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/employee-card.png")));
		lblEid_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEid_1.setBounds(35, 116, 65, 32);
		contentPane.add(lblEid_1);
		
		JLabel eid = new JLabel("");
		eid.setFont(new Font("Tahoma", Font.BOLD, 16));
		eid.setBounds(204, 116, 71, 32);
		contentPane.add(eid);
		eid.setText(eid1);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/sas.png")));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(35, 171, 94, 32);
		contentPane.add(lblName);
		
		
		JLabel name = new JLabel("");
		name.setFont(new Font("Tahoma", Font.BOLD, 15));
		name.setBounds(214, 171, 152, 32);
		contentPane.add(name);
		name.setText(Name1);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/manager.png")));
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDesignation.setBounds(35, 236, 133, 32);
		contentPane.add(lblDesignation);
		
		desig = new JTextField();
		desig.setBounds(205, 242, 138, 22);
		contentPane.add(desig);
		desig.setColumns(10);
		desig.setText(Designation);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/portfolio.png")));
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(35, 302, 138, 26);
		contentPane.add(lblDepartment);
		String cids[]=new String[] {"Mess","Office","Security"};
		JComboBox dept = new JComboBox(cids);
		dept.setBounds(204, 305, 101, 23);
		contentPane.add(dept);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/credit-card(1).png")));
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(35, 371, 133, 32);
		contentPane.add(lblSalary);
		
		sal = new JTextField();
		sal.setBounds(205, 377, 116, 22);
		contentPane.add(sal);
		sal.setColumns(10);
		sal.setText(Salary);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/circular-line-with-word-age-in-the-center(1).png")));
		lblAge.setBounds(35, 434, 94, 32);
		contentPane.add(lblAge);
		
		JLabel age = new JLabel("");
		age.setFont(new Font("Tahoma", Font.BOLD, 15));
		age.setBounds(204, 434, 71, 32);
		contentPane.add(age);
		age.setText(Age);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AfterEmpUpdate aeu=new AfterEmpUpdate();
				aeu.setVisible(true);
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/back.png")));
		button.setBounds(3, 13, 54, 52);
		contentPane.add(button);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=age.getText();
				
				String desig1=desig.getText();
				String dept1=(String) dept.getSelectedItem();
				String sala1=sal.getText();
				
				String e=eid1;
				if(text.matches("[0-9]+")&&sala1.matches("[0-9]+")&&Integer.parseInt(text)<100)
				{
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    
                    PreparedStatement ps123 = con.prepareStatement("Select Paid from Salary Where Eid=?");
                   
                    
                    ps123.setString(1, eid.getText());
                    ResultSet  rs=ps123.executeQuery();
                    if(rs.next())
                    {
                    String bal=rs.getString(1);
                    int paid=Integer.parseInt(bal);
                    int sal1=Integer.parseInt(sal.getText());
                    int bal1=sal1-paid;
                    String bal12=Integer.toString(bal1);
                    PreparedStatement ps12 = con.prepareStatement("Update`Salary`SET Salary=?, Balance=? Where Eid=?");
            		ps12.setString(1, sal.getText());
            		ps12.setString(2,bal12);
            		ps12.setString(3,eid.getText());
            		ps12.executeUpdate();
            		String sql="Update`EMPLOYEE`SET Designation=?,Department=?,Salary=? Where Eid=?";
                    
                    PreparedStatement ps4 = con.prepareStatement(sql);
                    ps4.setString(2,(String) dept.getSelectedItem());
                    ps4.setString(1,desig.getText());
                    ps4.setString(3,sal.getText());
                    ps4.setString(4,eid.getText());
                    ps4.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Updated");
                    
                    
                    
                    
                    
				}
                    else
                    {
                    	JOptionPane.showMessageDialog(null,"Employee doesn't exist");
                    }
                    con.close();
				}
                    
				catch(Exception e2)
				{
					System.out.println(e2);
				}
				
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Details");
				}
			
			}
		});
		btnSubmit.setBounds(145, 491, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Emp_Update.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 408, 529);
		contentPane.add(label);
	}
}
