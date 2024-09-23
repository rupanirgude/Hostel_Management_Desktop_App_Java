package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AfterEmpAdd extends JFrame {

	private JPanel contentPane;
	private JTextField fn;
	private JTextField eid;
	private JTextField des;
	private JTextField sal;
	private JTextField age;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterEmpAdd frame = new AfterEmpAdd();
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
	public AfterEmpAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/sas.png")));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(91, 92, 90, 34);
		contentPane.add(lblName);
		
		fn = new JTextField();
		fn.setBounds(300, 99, 167, 22);
		contentPane.add(fn);
		fn.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/employee-card.png")));
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeeId.setBounds(91, 147, 149, 22);
		contentPane.add(lblEmployeeId);
		
		eid = new JTextField();
		eid.setBounds(300, 148, 116, 22);
		contentPane.add(eid);
		eid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Designation");
		lblNewLabel.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/manager.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(91, 194, 149, 34);
		contentPane.add(lblNewLabel);
		
		des = new JTextField();
		des.setBounds(300, 201, 116, 22);
		contentPane.add(des);
		des.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/portfolio.png")));
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(91, 253, 149, 39);
		contentPane.add(lblDepartment);
		
		
		
		String cids[]=new String[] {"Mess","Office","Security"};
		JComboBox<String> dept = new JComboBox<>(cids);
		dept.setBounds(300,262,116,22);
	contentPane.add(dept);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/debit-card(1).png")));
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(91, 317, 149, 34);
		contentPane.add(lblSalary);
		
		sal = new JTextField();
		sal.setBounds(300, 324, 116, 22);
		contentPane.add(sal);
		sal.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/circular-line-with-word-age-in-the-center(1).png")));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(91, 379, 90, 34);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setBounds(300, 386, 116, 22);
		contentPane.add(age);
		age.setColumns(10);
		
		JLabel lblAdd = new JLabel("ADD");
		lblAdd.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/plus.png")));
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdd.setBounds(186, 0, 167, 66);
		contentPane.add(lblAdd);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=age.getText();
				String name=fn.getText();
				String desig=des.getText();
				String dept1=(String) dept.getSelectedItem();
				String sala=sal.getText();
				String age1=age.getText();
				//String design=
				if(age1.matches("[0-9]+")&&sala.matches("[0-9]+")&&Integer.parseInt(age1)<100)
				{
				try {
					Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                PreparedStatement ps1 = con.prepareStatement("INSERT INTO `employee` (Eid,Name,Designation,Department,Salary,Age)VALUES (?,?,?,?,?,?)");
                ps1.setString(1, eid.getText());
                ps1.setString(2,name);
                ps1.setString(3, desig);
                ps1.setString(4,dept1);
                ps1.setString(5, sala);
                ps1.setString(6, text);
                ps1.executeUpdate();
                PreparedStatement ps12 = con.prepareStatement("INSERT INTO `salary`(Eid,Name,Salary,Paid,Balance) VALUES (?, ?, ?, ?,?)");
        		ps12.setString(1, eid.getText());
        		ps12.setString(2, name);
        		ps12.setString(3, sala);
        		ps12.setString(4, "0");
        		ps12.setString(5, sala);
        		ps12.executeUpdate();
                JOptionPane.showMessageDialog(null,"Updated");
                setVisible(false);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Details");
				}
			}
			
		});
		btnSubmit.setBounds(214, 445, 97, 25);
		contentPane.add(btnSubmit);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/house.png")));
		button.setBounds(12, 13, 60, 53);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterEmployee ae=new AfterEmployee();
				ae.show();
				setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/back.png")));
		button_1.setBounds(12, 434, 60, 53);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterEmpAdd.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 529, 500);
		contentPane.add(label);
	}
	public AfterEmpAdd(String eid1,String n,String desig,String depat,String sala,String Age) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(12, 81, 56, 16);
		contentPane.add(lblName);
		
		fn = new JTextField();
		fn.setBounds(162, 79, 116, 22);
		contentPane.add(fn);
		fn.setColumns(10);
		fn.setText(n);
				
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeeId.setBounds(12, 126, 103, 16);
		contentPane.add(lblEmployeeId);
		
		eid = new JTextField();
		eid.setBounds(162, 124, 116, 22);
		contentPane.add(eid);
		eid.setColumns(10);
		eid.setEditable(false);
		eid.setText(eid1);
		JLabel lblNewLabel = new JLabel("Designation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 169, 103, 20);
		contentPane.add(lblNewLabel);
		
		des = new JTextField();
		des.setBounds(162, 167, 116, 22);
		contentPane.add(des);
		des.setColumns(10);
		des.setText(desig);
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDepartment.setBounds(12, 215, 103, 16);
		contentPane.add(lblDepartment);
		
		
		
		String cids[]=new String[] {"Mess","Office","Security"};
		JComboBox<String> dept = new JComboBox<>(cids);
		dept.setBounds(162, 213, 92, 22);
		contentPane.add(dept);
		dept.setSelectedItem(depat);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalary.setBounds(12, 262, 56, 16);
		contentPane.add(lblSalary);
		
		sal = new JTextField();
		sal.setBounds(162, 260, 116, 22);
		contentPane.add(sal);
		sal.setColumns(10);
		sal.setText(sala);
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAge.setBounds(12, 313, 56, 16);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setBounds(162, 311, 116, 22);
		contentPane.add(age);
		age.setColumns(10);
		age.setText(Age);
		JLabel lblAdd = new JLabel("Update");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAdd.setBounds(176, 13, 56, 34);
		contentPane.add(lblAdd);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=age.getText();
				String name=n;
				String desig1=desig;
				String dept1=depat;
				String sala1=sala;
				String age1=Age;
				String e=eid1;
				if(age1.matches("[0-9]+")&&sala1.matches("[0-9]+")&&Integer.parseInt(age1)<100)
				{
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    String sql="Update`EMPLOYEE`SET Name=?,Designation=?,Department=?,Salary=? Where Eid=?";
                    PreparedStatement ps4 = con.prepareStatement(sql);
                    

                    ps4.setString(1,fn.getText());
                    
                    
                    
                    ps4.setString(3,(String) dept.getSelectedItem());
                    ps4.setString(2,des.getText());
                    ps4.setString(4,sal.getText());
                    ps4.setString(5,eid.getText());
                    ps4.executeUpdate();
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
		btnSubmit.setBounds(162, 368, 97, 25);
		contentPane.add(btnSubmit);
	}
}
