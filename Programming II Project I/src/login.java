import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField cardNumInput;
	private JPasswordField passInput;
	
	private static dataBase data = new dataBase();
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public login() {
		initialize();
	}
	
	private void initialize() {
				
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cardNum = new JLabel("Card Number"); 
		cardNum.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cardNum.setBounds(60, 40, 200, 40);
		frame.getContentPane().add(cardNum);
		
		cardNumInput = new JTextField();
		cardNumInput.setBounds(70, 85, 200, 30);
		frame.getContentPane().add(cardNumInput);
		cardNumInput.setColumns(10);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.PLAIN, 26));
		pass.setBounds(60, 120, 200, 40);
		frame.getContentPane().add(pass);
		
		passInput = new JPasswordField();
		passInput.setColumns(10);
		passInput.setBounds(70, 173, 200, 30);
		frame.getContentPane().add(passInput);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String n = cardNumInput.getText() ;
				String p = passInput.getText();
				int i;
				
				for(i=0; i<data.myAccounts.length; i+=1) {
					if(data.myAccounts[i].validate(n, p))
						break;
				}
				
				if(i==data.myAccounts.length) {
					JOptionPane.showMessageDialog(null, "Unvalid Card Number or Password, please try again.");	
				}
				else {
					JOptionPane.showMessageDialog(null, "Login successful.");
					MainMenu.mainMainMenu(data.myAccounts[i]);
					frame.dispose();
				}
				
			}
		});
		btnLogin.setBounds(320, 215, 95, 25);
		frame.getContentPane().add(btnLogin);
	}
}
