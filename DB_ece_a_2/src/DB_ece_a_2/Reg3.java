package DB_ece_a_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Reg3 {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg3 window = new Reg3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reg3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(177, 26, 149, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 86, 68, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fav Programming");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(26, 141, 140, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(201, 90, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		JComboBox c1 = new JComboBox();
		c1.setModel(new DefaultComboBoxModel(new String[] {"select", "C", "python", "java"}));
		c1.setBounds(201, 144, 111, 22);
		frame.getContentPane().add(c1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Roll No");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(26, 193, 68, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		t2 = new JTextField();
		t2.setBounds(201, 197, 86, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String fp=(String) c1.getSelectedItem();
				String roll=t2.getText();
				int rollno=Integer.parseInt(roll);
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ece_a","root","mrec");
					Statement sta=con.createStatement();
					String q="insert into mrecstudent values('"+n+"','"+fp+"','"+rollno+"')";
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton,"Done!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(112, 267, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
