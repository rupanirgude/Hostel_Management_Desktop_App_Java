package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterFeesUSN extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField usn;
	private JTextField fees;
	private JTextField paid;
	private JTextField due;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterFeesUSN frame = new AfterFeesUSN("","","","");
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
	public AfterFeesUSN(String u,String Name,String paid1,String due1) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setIcon(new ImageIcon("C:\\Users\\shubh\\Desktop\\dbms_pro_img\\sas.png"));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(199, 72, 95, 32);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(345, 78, 116, 22);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(Name);
		name.setEditable(false);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon("C:\\Users\\shubh\\Desktop\\dbms_pro_img\\id-card(1).png"));
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsn.setBounds(199, 134, 72, 32);
		contentPane.add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(345, 140, 116, 22);
		contentPane.add(usn);
		usn.setColumns(10);
		usn.setText(u);
		
		JLabel lblFeesPaid = new JLabel("Fees");
		lblFeesPaid.setIcon(new ImageIcon("C:\\Users\\shubh\\Downloads\\transaction.png"));
		lblFeesPaid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeesPaid.setBounds(199, 195, 85, 32);
		contentPane.add(lblFeesPaid);
		
		fees = new JTextField();
		fees.setEditable(false);
		fees.setText("60000");
		fees.setBounds(345, 201, 116, 22);
		contentPane.add(fees);
		fees.setColumns(10);
		
		JLabel lblFeesPaid_1 = new JLabel("Paid");
		lblFeesPaid_1.setIcon(new ImageIcon("C:\\Users\\shubh\\Desktop\\dbms_pro_img\\debit-card(1).png"));
		lblFeesPaid_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeesPaid_1.setBounds(199, 259, 95, 43);
		contentPane.add(lblFeesPaid_1);
		
		paid = new JTextField();
		paid.setEditable(false);
		paid.setBounds(345, 270, 116, 22);
		contentPane.add(paid);
		paid.setColumns(10);
		paid.setText(paid1);
		
		JLabel lblDue = new JLabel("Due");
		lblDue.setIcon(new ImageIcon("C:\\Users\\shubh\\Desktop\\dbms_pro_img\\credit-card(1).png"));
		lblDue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDue.setBounds(199, 340, 79, 33);
		contentPane.add(lblDue);
		
		due = new JTextField();
		due.setEditable(false);
		due.setBounds(345, 346, 116, 22);
		contentPane.add(due);
		due.setColumns(10);
		due.setText(due1);
		due.setEditable(false);
		
		
		JLabel lblFeeStatus = new JLabel("FEE STATUS");
		lblFeeStatus.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblFeeStatus.setBounds(260, 13, 156, 32);
		contentPane.add(lblFeeStatus);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(289, 414, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\shubh\\Desktop\\ad.jpg"));
		label.setBounds(0, 0, 656, 478);
		contentPane.add(label);
	}
}
