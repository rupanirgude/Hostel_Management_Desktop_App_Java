package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AfterSalaryEID extends JFrame {

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
					AfterSalaryEID frame = new AfterSalaryEID("","","","","");
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
	public AfterSalaryEID(String u,String Name,String Salary,String paid1,String due1) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setIcon(new ImageIcon(AfterSalaryEID.class.getResource("/images/manager.png")));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(12, 72, 95, 32);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(119, 78, 116, 22);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(Name);
		name.setEditable(false);
		
		JLabel lblUsn = new JLabel("EID");
		lblUsn.setIcon(new ImageIcon(AfterSalaryEID.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsn.setBounds(12, 117, 85, 32);
		contentPane.add(lblUsn);
		
		usn = new JTextField();
		usn.setBounds(119, 123, 116, 22);
		contentPane.add(usn);
		usn.setColumns(10);
		usn.setText(u);
		
		JLabel lblFeesPaid = new JLabel("Salary");
		lblFeesPaid.setIcon(new ImageIcon(AfterSalaryEID.class.getResource("/images/debit-card.png")));
		lblFeesPaid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeesPaid.setBounds(12, 179, 85, 32);
		contentPane.add(lblFeesPaid);
		
		fees = new JTextField();
		fees.setEditable(false);
		fees.setText(Salary);
		fees.setBounds(119, 185, 116, 22);
		contentPane.add(fees);
		fees.setColumns(10);
		
		JLabel lblFeesPaid_1 = new JLabel("Paid");
		lblFeesPaid_1.setIcon(new ImageIcon(AfterSalaryEID.class.getResource("/images/credit-card.png")));
		lblFeesPaid_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFeesPaid_1.setBounds(12, 235, 82, 20);
		contentPane.add(lblFeesPaid_1);
		
		paid = new JTextField();
		paid.setEditable(false);
		paid.setBounds(119, 233, 116, 22);
		contentPane.add(paid);
		paid.setColumns(10);
		paid.setText(paid1);
		
		JLabel lblDue = new JLabel("Balance");
		lblDue.setIcon(new ImageIcon(AfterSalaryEID.class.getResource("/images/id-card.png")));
		lblDue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDue.setBounds(12, 293, 80, 20);
		contentPane.add(lblDue);
		
		due = new JTextField();
		due.setEditable(false);
		due.setBounds(119, 291, 116, 22);
		contentPane.add(due);
		due.setColumns(10);
		due.setText(due1);
		due.setEditable(false);
		
		
		JLabel lblFeeStatus = new JLabel("SALARY");
		lblFeeStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFeeStatus.setBounds(102, 13, 85, 16);
		contentPane.add(lblFeeStatus);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setBounds(90, 345, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterSalaryEID.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 264, 402);
		contentPane.add(label);
	}

}
