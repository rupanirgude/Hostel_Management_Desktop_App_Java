package proFinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AfterUpdate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterUpdate frame = new AfterUpdate();
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
	public AfterUpdate() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 662, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUpdate.setBounds(24, 132, 69, 16);
		contentPane.add(lblUpdate);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(AfterUpdate.class.getResource("/images/search(1).png")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AfterShowDetails asd=new AfterShowDetails();
				asd.show();
				setVisible(false);
			}
		});
		btnUpdate.setBounds(288, 188, 69, 73);
		contentPane.add(btnUpdate);
		
		JLabel lblShow = new JLabel("Show");
		lblShow.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblShow.setBounds(286, 132, 56, 16);
		contentPane.add(lblShow);
		
		JButton btnShow = new JButton("");
		btnShow.setIcon(new ImageIcon(AfterUpdate.class.getResource("/images/saq.png")));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a="Hi";
				AfterUpdateButton aub=new AfterUpdateButton(a);
				aub.show();
				setVisible(false);
				
			}
		});
		btnShow.setBounds(24, 188, 69, 73);
		contentPane.add(btnShow);
		
		JButton btnRemove = new JButton("");
		btnRemove.setIcon(new ImageIcon(AfterUpdate.class.getResource("/images/delete.png")));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterStuDelete asd=new AfterStuDelete();
				asd.setVisible(true);
				setVisible(false);
			}
		});
		btnRemove.setBounds(548, 188, 69, 73);
		contentPane.add(btnRemove);
		
		JLabel lblRemove = new JLabel("Remove");
		lblRemove.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemove.setBounds(548, 132, 87, 16);
		contentPane.add(lblRemove);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		btnNewButton.setIcon(new ImageIcon(AfterUpdate.class.getResource("/images/back.png")));
		btnNewButton.setBounds(12, 386, 56, 39);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setIcon(new ImageIcon(AfterUpdate.class.getResource("/images/house.png")));
		button.setBounds(12, 13, 56, 39);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AfterUpdate.class.getResource("/images/ad.jpg")));
		label.setBounds(0, 0, 656, 478);
		contentPane.add(label);
	}

}
