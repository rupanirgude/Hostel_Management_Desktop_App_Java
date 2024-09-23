package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AfterStuUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField usn;
	private JTextField contact;
	private JTextField email;
	private JTextField pcontact;
	private JTextField rno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterStuUpdate frame = new AfterStuUpdate("a","as","","","","","","");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *///FirstName,LastName,USN,CourseId,Contact,Email,PContact,RoomNo
	public AfterStuUpdate(String FirstName,String LastName,String USN,String CourseId,String Contact,String Email,String PContact,String RoomNo) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 734
				);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/sas.png")));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(41, 113, 138, 32);
		contentPane.add(lblName);
		
		fname = new JTextField();
		fname.setBounds(255, 119, 179, 22);
		contentPane.add(fname);
		fname.setColumns(10);
		fname.setText(FirstName);
		fname.setEditable(false);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(80, 164, 88, 16);
		contentPane.add(lblLastName);
		
		lname = new JTextField();
		lname.setBounds(255, 162, 179, 22);
		contentPane.add(lname);
		lname.setColumns(10);
		lname.setText(LastName);
		lname.setEditable(false);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsn.setBounds(41, 217, 78, 24);
		contentPane.add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(255, 219, 116, 22);
		contentPane.add(usn);
		usn.setColumns(10);
		usn.setText(USN);
		usn.setEditable(false);
		JLabel lblCourseId = new JLabel("Course Id");
		lblCourseId.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/scholarship.png")));
		lblCourseId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCourseId.setBounds(41, 271, 138, 32);
		contentPane.add(lblCourseId);
		
		String cids[]=new String[] {"B.Tech","MBA"};
		JComboBox<String> cid = new JComboBox<>(cids);
		cid.setBounds(255, 281, 116, 22);
		contentPane.add(cid);
		cid.setSelectedItem(CourseId);
		JLabel lblContact = new JLabel("Contact");
		lblContact.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/asa.png")));
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContact.setBounds(41, 333, 107, 32);
		contentPane.add(lblContact);
		
		contact = new JTextField();
		contact.setBounds(255, 339, 116, 22);
		contentPane.add(contact);
		contact.setColumns(10);
		contact.setText(Contact);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/qw.png")));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(41, 396, 107, 24);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(255, 398, 116, 22);
		contentPane.add(email);
		email.setColumns(10);
		email.setText(Email);
		
		JLabel lblParentsContact = new JLabel("Parent's Contact");
		lblParentsContact.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/asa.png")));
		lblParentsContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblParentsContact.setBounds(41, 465, 179, 24);
		contentPane.add(lblParentsContact);
		
		pcontact = new JTextField();
		pcontact.setBounds(255, 467, 116, 22);
		contentPane.add(pcontact);
		pcontact.setColumns(10);
		pcontact.setText(PContact);
		
		JLabel lblUpdate = new JLabel("UPDATE");
		lblUpdate.setBounds(138, 13, 186, 64);
		contentPane.add(lblUpdate);
		lblUpdate.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/change(1).png")));
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a=email.getText();
				
				if(a.indexOf("@saividya.ac.in")==-1)
				{
					JOptionPane.showMessageDialog(null,"Invalid email,works only for saividya email ids");
				}
				else
				{	try
					{
					Class.forName("com.mysql.jdbc.Driver");
					String u=usn.getText();
					
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
                    String sql="Update`register`SET FirstName=?,LastName=?,CourseId=?,Contact=?,Email=?,PContact=?,RoomNo=? Where USN=?";
                    PreparedStatement ps4 = con.prepareStatement(sql);
                    

                    ps4.setString(1,fname.getText());
                    ps4.setString(2, lname.getText());
                    
                    
                  ps4.setString(3,(String) cid.getSelectedItem());
                    ps4.setString(4,contact.getText());
                    ps4.setString(5,email.getText());
                  
                    ps4.setString(6,pcontact.getText());
                    ps4.setString(7,rno.getText());
                    ps4.setString(8,u);
                    ps4.executeUpdate();
                    con.close();
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"Updated");
					//Date date = new Date(datePicker.getvalue().toEpochDay());
					}
					catch(Exception e)
				{
						System.out.println(e);
				}
				}
				
			}
		
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(138, 593, 131, 37);
		contentPane.add(btnSubmit);
		
		JLabel lblRoomNo = new JLabel("Room No.");
		lblRoomNo.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/room-key.png")));
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRoomNo.setBounds(41, 528, 120, 24);
		contentPane.add(lblRoomNo);
		
		rno = new JTextField();
		rno.setBounds(255, 530, 116, 22);
		contentPane.add(rno);
		rno.setColumns(10);
		rno.setText(RoomNo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/checked.png")));
		lblNewLabel_1.setBounds(295, 593, 41, 37);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/house.png")));
		btnNewButton.setBounds(12, 13, 54, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/back.png")));
		btnNewButton_1.setBounds(12, 601, 54, 51);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterStuUpdate.class.getResource("/images/ad.jpg")));
		lblNewLabel.setBounds(0, 0, 442, 687);
		contentPane.add(lblNewLabel);
	}
}
