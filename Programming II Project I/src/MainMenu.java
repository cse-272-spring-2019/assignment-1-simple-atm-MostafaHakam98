import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Label;

public class MainMenu {

	public JFrame frame;
	private JFrame transFrame;
	
	private static account bankAccount;
	private static String amountInString;
	private static boolean type;
	private static history navigation = new history();
	
	public static void mainMainMenu(account account) {
		
		bankAccount = account;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 100, 700, 150);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Label lblNewLabel = new Label("");
		lblNewLabel.setBounds(0, 0, 700, 150);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBackground(Color.white);
		lblNewLabel.setAlignment(Label.CENTER);
		
		JButton bWithdraw = new JButton("Withdraw");
		bWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type = false;
				frame.setVisible(false);
				transFrame.setVisible(true);
			}
		});
		bWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 24));
		bWithdraw.setBounds(100, 300, 200, 50);
		frame.getContentPane().add(bWithdraw);
		
		JButton balInquiry = new JButton("Balance Inquiry");
		balInquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("Your current balance is: $" + bankAccount.getBalance());
			}
		});
		balInquiry.setFont(new Font("Tahoma", Font.PLAIN, 24));
		balInquiry.setBounds(350, 300, 200, 50);
		frame.getContentPane().add(balInquiry);
		
		JButton bDeposit = new JButton("Deposit");
		bDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				type = true;
				frame.setVisible(false);
				transFrame.setVisible(true);
			}
		});
		bDeposit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		bDeposit.setBounds(600, 300, 200, 50);
		frame.getContentPane().add(bDeposit);
		
		JButton bPrev = new JButton("Previous");
		bPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(navigation.getpTop()>0 && navigation.getPrevious() != null) {
					lblNewLabel.setText(navigation.getPrevious());
					navigation.undo();
				}
				else 
					JOptionPane.showMessageDialog(null, "History navigation limit reached.");
			}
		});
		bPrev.setFont(new Font("Tahoma", Font.PLAIN, 24));
		bPrev.setBounds(200, 400, 200, 50);
		frame.getContentPane().add(bPrev);
		
		JButton bNext = new JButton("Next");
		bNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(navigation.getnTop()>0 && navigation.getNext() != null) {
					lblNewLabel.setText(navigation.getNext());
					navigation.redo();
				}
				else 
					JOptionPane.showMessageDialog(null, "History navigation limit reached.");
			}
		});
		bNext.setFont(new Font("Tahoma", Font.PLAIN, 24));
		bNext.setBounds(500, 400, 200, 50);
		frame.getContentPane().add(bNext);
		
		/* First Frame 
		 * ............................................................................................ 
		 * ............................................................................................*/
		
		transFrame = new JFrame();
		transFrame.setBounds(100, 100, 290, 475);
		transFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		transFrame.getContentPane().setLayout(null);
		
		JPanel transPanel = new JPanel();
		transPanel.setBounds(50, 30, 175, 50);
		transFrame.getContentPane().add(transPanel);
		transPanel.setLayout(null);
		
		Label transLabel = new Label("");
		transLabel.setAlignment(Label.CENTER);
		transLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		transLabel.setBounds(0, 0, 175, 50);
		transPanel.add(transLabel);
		transLabel.setBackground(Color.white);
		
		JButton seven = new JButton("7");
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "7";
				}
				else 
					amountInString += "7";
				transLabel.setText(amountInString);
			}
		});
		seven.setFont(new Font("Tahoma", Font.PLAIN, 20));
		seven.setBounds(50, 93, 50, 50);
		transFrame.getContentPane().add(seven);
		
		JButton eight = new JButton("8");
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "8";
				}
				else 
					amountInString += "8";
				transLabel.setText(amountInString);
			}
		});
		eight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eight.setBounds(112, 93, 50, 50);
		transFrame.getContentPane().add(eight);
		
		JButton nine = new JButton("9");
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "9";
				}
				else 
					amountInString += "9";
				transLabel.setText(amountInString);
			}
		});
		nine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nine.setBounds(174, 93, 50, 50);
		transFrame.getContentPane().add(nine);
		
		JButton four = new JButton("4");
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "4";
				}
				else 
					amountInString += "4";
				transLabel.setText(amountInString);
			}
		});
		four.setFont(new Font("Tahoma", Font.PLAIN, 20));
		four.setBounds(50, 156, 50, 50);
		transFrame.getContentPane().add(four);
		
		JButton five = new JButton("5");
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "5";
				}
				else 
					amountInString += "5";
				transLabel.setText(amountInString);
			}
		});
		five.setFont(new Font("Tahoma", Font.PLAIN, 20));
		five.setBounds(112, 156, 50, 50);
		transFrame.getContentPane().add(five);
		
		JButton six = new JButton("6");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "6";
				}
				else 
					amountInString += "6";
				transLabel.setText(amountInString);
			}
		});
		six.setFont(new Font("Tahoma", Font.PLAIN, 20));
		six.setBounds(175, 156, 50, 50);
		transFrame.getContentPane().add(six);
		
		JButton two = new JButton("2");
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "2";
				}
				else
					amountInString += "2";
				transLabel.setText(amountInString);
			}
		});
		two.setFont(new Font("Tahoma", Font.PLAIN, 20));
		two.setBounds(112, 219, 50, 50);
		transFrame.getContentPane().add(two);
		
		JButton three = new JButton("3");
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "3";
				}
				else 
					amountInString += "3";
				transLabel.setText(amountInString);
			}
		});
		three.setFont(new Font("Tahoma", Font.PLAIN, 20));
		three.setBounds(174, 219, 50, 50);
		transFrame.getContentPane().add(three);
		
		JButton one = new JButton("1");
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "1";
				}
				else
					amountInString += "1";
				transLabel.setText(amountInString);
			}
		});
		one.setFont(new Font("Tahoma", Font.PLAIN, 20));
		one.setBounds(50, 219, 50, 50);
		transFrame.getContentPane().add(one);
		
		JButton zero = new JButton("0");
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					amountInString = "0";
				}
				else
					amountInString += "0";
				transLabel.setText(amountInString);
			}
		});
		zero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		zero.setBounds(112, 282, 50, 50);
		transFrame.getContentPane().add(zero);
		
		JButton delete = new JButton("c");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (amountInString != null && amountInString.length() > 0) {
			    	amountInString = amountInString.substring(0, amountInString.length() - 1);
			    }
				transLabel.setText(amountInString);
			}
		});
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		delete.setBounds(174, 282, 50, 50);
		transFrame.getContentPane().add(delete);
		
		JButton fraction = new JButton(".");
		fraction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amountInString == null) {
					JOptionPane.showMessageDialog(null, "Please enter a number first");
				}
				else {
					amountInString += ".";
					transLabel.setText(amountInString);
				}
			}
		});
		fraction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fraction.setBounds(50, 282, 50, 50);
		transFrame.getContentPane().add(fraction);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!type && Double.parseDouble(amountInString) > Double.parseDouble(bankAccount.getBalance())) {
					JOptionPane.showMessageDialog(null, "Unsufficient balance");
				}
				else if(amountInString == null) {
					JOptionPane.showMessageDialog(null, "Unavailable transfer amount");
				}
				else {
					if (type){
						bankAccount.deposit(amountInString);
						lblNewLabel.setText("Deposited $" + amountInString);
						navigation.add("Deposited $" + amountInString);
					}
					else {
						bankAccount.withdraw(amountInString);
						lblNewLabel.setText("Withdrawn $" + amountInString);
						navigation.add("Withdrawn $" + amountInString);
					}
					transLabel.setText("");
					amountInString = null;
					frame.setVisible(true);
					transFrame.dispose();
				}
			}
		});
		confirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confirm.setBounds(50, 345, 112, 50);
		transFrame.getContentPane().add(confirm);
		
		JButton back = new JButton("<");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				amountInString = null;
				frame.setVisible(true);
				transFrame.dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setBounds(174, 345, 50, 50);
		transFrame.getContentPane().add(back);
	}
}
