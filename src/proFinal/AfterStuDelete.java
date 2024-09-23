package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterStuDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterStuDelete frame = new AfterStuDelete();
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
	public AfterStuDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setIcon(new ImageIcon(AfterStuDelete.class.getResource("/images/id-card(1).png")));
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblUsn.setBounds(235, 136, 104, 45);
		contentPane.add(lblUsn);
		
		textField = new JTextField();
		textField.setBounds(185, 194, 195, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String u=textField.getText();
				DeleteDialog dg=new DeleteDialog(u);
				dg.setVisible(true);
			}
		});
		btnDelete.setBounds(246, 275, 97, 25);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AfterStuDelete.class.getResource("/images/delete-photo.png")));
		lblNewLabel.setBounds(197, 268, 32, 32);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AfterUpdate au=new AfterUpdate();
				au.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(AfterStuDelete.class.getResource("/images/back.png")));
		button.setBounds(25, 393, 56, 45);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AfterStuDelete.class.getResource("/images/house.png")));
		btnNewButton.setBounds(12, 13, 56, 45);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterStuDelete.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 534, 466);
		contentPane.add(label);
	}

}
