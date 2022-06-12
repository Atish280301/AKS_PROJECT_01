/* --- USER INTERFACE FOR CHOICE ONE OPTION LOGIN OR SIGNIN --- */
package PASSWORD_OTP;			//package statement

/*IMPORT STATEMENT FRO DESIGN UI*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/*IMPORT STATEMENTS END*/

public class CHOICE 							//CLASS DECLARATION
{

	private JFrame CFRAME;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 			//MAIN FUNCTION
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHOICE window = new CHOICE();
					window.CFRAME.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CHOICE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CFRAME = new JFrame();												//FRAME
		CFRAME.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Atish kumar sahu\\eclipse-workspace\\My_Problem_Solver\\IMGCON\\FRAMEICON.png")); //ICON
		CFRAME.setResizable(false);
		CFRAME.getContentPane().setBackground(new Color(173, 216, 230));
		CFRAME.setTitle("My Problem Solver");
		CFRAME.setBounds(100, 100, 1050, 679);
		CFRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CFRAME.getContentPane().setLayout(null);
		
		JButton SIGNINbb = new JButton("Sign In");		//SIGNIN BUTTON
		SIGNINbb.addActionListener(new ActionListener() 		//ACTIONLISTENER
		{
			public void actionPerformed(ActionEvent e) //ACTIONEVENT
			{
				
				ACCOUNTCREATE.main(null);
				CFRAME.dispose();
			}
		});
		SIGNINbb.setForeground(Color.BLUE);
		SIGNINbb.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		SIGNINbb.setBounds(793, 261, 117, 33);
		CFRAME.getContentPane().add(SIGNINbb);
		
		JLabel SIGNINL = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/person.png")).getImage(); //IMAGE
		SIGNINL.setIcon(new ImageIcon(img));
		SIGNINL.setBounds(801, 139, 96, 109);
		CFRAME.getContentPane().add(SIGNINL);
		
		JLabel Newu = new JLabel("New User");		//JLABEL "NEW USER"
		Newu.setFont(new Font("Georgia", Font.BOLD, 20));
		Newu.setBounds(797, 88, 98, 38);
		CFRAME.getContentPane().add(Newu);
		
		JButton Backb = new JButton("Back");			//BACK BUTTON TO GO TO FRONT USER INTERFACE
		Backb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FRONT.main(null);
				CFRAME.dispose();
			}
		});
		Backb.setForeground(Color.BLUE);
		Backb.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		Backb.setBounds(20, 580, 117, 33);
		CFRAME.getContentPane().add(Backb);
		
		JLabel Oldu = new JLabel("Old User");    // JLABEL "OLD USER"
		Oldu.setFont(new Font("Georgia", Font.BOLD, 20));
		Oldu.setBounds(170, 88, 98, 38);
		CFRAME.getContentPane().add(Oldu);
		
		JLabel LOGINL = new JLabel("");
		Image img44 = new ImageIcon(this.getClass().getResource("/person.png")).getImage(); //IMAGE
		LOGINL.setIcon(new ImageIcon(img44));
		LOGINL.setBounds(170, 139, 96, 109);
		CFRAME.getContentPane().add(LOGINL);
		
		JButton LOGINbb = new JButton("LogIn");					//LOGIN BUTTON
		LOGINbb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LOGINUSER.main(null);
				CFRAME.dispose();
			}
		});
		LOGINbb.setForeground(Color.BLUE);
		LOGINbb.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		LOGINbb.setBounds(161, 261, 117, 33);
		CFRAME.getContentPane().add(LOGINbb);
	}
}