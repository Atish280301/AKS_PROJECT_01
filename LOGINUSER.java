/*LOGIN USER UI FOR CONFIRM THAT THE USER IS VALID OR NOT*/
package PASSWORD_OTP;					//pacckage statement

/*IMPORT STATEMENT FOR FETCH OPERATION AND LOGIN VALIDATION*/
import java.awt.EventQueue;
import java.sql.*;
import net.proteanit.*;
import net.proteanit.sql.DbUtils;
import net.proteanit.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class LOGINUSER			//CLASS NAME
{

	private JFrame LOGINFRAME;
	private JTextField NAMETF;
	private JTextField MAILTF;
	private JButton BACKBB;
	private JTextField OTPTF;
	
	private static final String url = "jdbc:mysql://127.0.0.1:3306/account_details"; //JDBC CONNECTION
	private static final String user = "root";											//USER NAME
	private static final String pass = "";												//PASSWORD

	public static String name;
	public static String mail;
	public static String password;
	
	public static String takemail;
	
	Session newSession = null;
	MimeMessage mimeMessage = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 							//MAIN FUNCTION
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOGINUSER window = new LOGINUSER();
					window.LOGINFRAME.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public LOGINUSER() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LOGINFRAME = new JFrame();					//FRAME
		LOGINFRAME.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Atish kumar sahu\\eclipse-workspace\\My_Problem_Solver\\IMGCON\\FRAMEICON.png")); //ICON
		LOGINFRAME.getContentPane().setBackground(new Color(173, 216, 230));
		LOGINFRAME.setResizable(false);
		LOGINFRAME.setTitle("My Problem Solver");
		LOGINFRAME.setBounds(100, 100, 1050, 679);
		LOGINFRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LOGINFRAME.getContentPane().setLayout(null);
		
		JLabel ACCLOG = new JLabel("Account Login");	//JLABEL "ACCOUNT LOGIN"
		ACCLOG.setForeground(new Color(255, 69, 0));
		ACCLOG.setFont(new Font("Georgia", Font.BOLD, 25));
		ACCLOG.setBounds(71, 63, 184, 29);
		LOGINFRAME.getContentPane().add(ACCLOG);
		
		JLabel LOGNM = new JLabel("Name:");				//JLABEL "NAME"
		LOGNM.setForeground(new Color(255, 69, 0));
		LOGNM.setFont(new Font("Georgia", Font.BOLD, 20));
		LOGNM.setBounds(71, 141, 76, 24);
		LOGINFRAME.getContentPane().add(LOGNM);
		
		JLabel LOGMAIL = new JLabel("Gmail:");			//JLABEL "MAIL"
		LOGMAIL.setForeground(new Color(255, 69, 0));
		LOGMAIL.setFont(new Font("Georgia", Font.BOLD, 20));
		LOGMAIL.setBounds(71, 198, 76, 24);
		LOGINFRAME.getContentPane().add(LOGMAIL);
		
		JLabel LOGPAS = new JLabel("Password:");		//JLABEL "PASSWORD"
		LOGPAS.setForeground(new Color(255, 69, 0));
		LOGPAS.setFont(new Font("Georgia", Font.BOLD, 20));
		LOGPAS.setBounds(71, 265, 106, 24);
		LOGINFRAME.getContentPane().add(LOGPAS);
		
		NAMETF = new JTextField();										//NAME TEXTFIELD TO ENTER USER NAME
		NAMETF.setFont(new Font("Cambria Math", Font.BOLD, 18));
		NAMETF.setToolTipText("Enter Your Name");
		NAMETF.setBounds(194, 140, 328, 31);
		LOGINFRAME.getContentPane().add(NAMETF);
		NAMETF.setColumns(10);
		
		MAILTF = new JTextField();									//GMAIL TEXTFIELD TO ENTER PROVIDED GMAIL
		MAILTF.setFont(new Font("Cambria Math", Font.BOLD, 18));
		MAILTF.setToolTipText("Enter Gmail");
		MAILTF.setColumns(10);
		MAILTF.setBounds(196, 201, 326, 31);
		LOGINFRAME.getContentPane().add(MAILTF);
		
		
		PAASTF = new JPasswordField();								//PASSWORD TEXTFILED TO ENTER THE PROVIDED PASSWORD
		PAASTF.setFont(new Font("Cambria Math", Font.BOLD, 18));
		PAASTF.setEchoChar('*');
		PAASTF.setBounds(194, 264, 328, 31);
		LOGINFRAME.getContentPane().add(PAASTF);
		
		BACKBB = new JButton("Back");						//BACK BUTTON GO BACK TO THE CHOICE USER INTERFACE
		BACKBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CHOICE.main(null);
				LOGINFRAME.dispose();
			}
		});
		BACKBB.setForeground(Color.BLUE);
		BACKBB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		BACKBB.setBounds(20, 580, 117, 33);
		LOGINFRAME.getContentPane().add(BACKBB);
				
		JButton LOGBB = new JButton("Log In");					//LOGIN BUTTON FOR CHECKING THE USER IS VALID OR NOT
		LOGBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try				/*DATA FECTH OPERATION*/
				{
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					Connection con = DriverManager.getConnection(url, user, pass);
					Statement st = con.createStatement();
					
					PreparedStatement pst = con.prepareStatement("select * from users where Gmail = ?;");
					pst.setString(1, MAILTF.getText());
					ResultSet rs = pst.executeQuery();
					
					PreparedStatement pst1 = con.prepareStatement("select * from users where Password = ?;");
					pst1.setString(1, PAASTF.getText());
					ResultSet rs1 = pst1.executeQuery();
					
					PreparedStatement pst2 = con.prepareStatement("select * from users where Name = ?;");
					pst2.setString(1, NAMETF.getText());
					ResultSet rs3 = pst2.executeQuery();
					
					if(rs3.next() & rs1.next() & rs.next())
					{
						JOptionPane.showMessageDialog(null , "An OTP was Sent to "+MAILTF.getText()+" for verification"); //SHOW A MESSAGE DIALOG FOR VALID USER 
						OTP = (int)(Math.random()*147921) + 26835; //OTP GENERATION
						takemail = MAILTF.getText();
						MAILSEND.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null , "Incorrect Input Given By "+NAMETF.getText());	//SHOW A MESSAGE DIALOG FOR INVALID USER 
						NAMETF.setText(null);
						PAASTF.setText(null);
						MAILTF.setText(null);
					}
					
				}
				catch(Exception EE8)
				{
					JOptionPane.showMessageDialog(null , "ACCESS DENIED");  //ACCESS DENIED ERROR MESSAGE
					EE8.printStackTrace();
				}
			}
		});
		LOGBB.setForeground(Color.BLUE);
		LOGBB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		LOGBB.setBounds(200, 336, 117, 33);
		LOGINFRAME.getContentPane().add(LOGBB);
		
		OTPTF = new JTextField();				//OTP TEXT FIELD TO ENTER OTP
		OTPTF.setFont(new Font("Cambria Math", Font.BOLD, 18));
		OTPTF.setToolTipText("Enter OTP");
		OTPTF.setColumns(10);
		OTPTF.setBounds(609, 342, 257, 31);
		LOGINFRAME.getContentPane().add(OTPTF);
		
		JButton VERYB = new JButton("Verify Code");				//VERIFY BUTTON TO VERIFY WHETHER THE OTP IS SAME OR NOT
		VERYB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String otp = OTPTF.getText();
				int ootp = Integer.parseInt(otp);
				
				if(OTP == ootp)
				{
					JOptionPane.showMessageDialog(null , "Congratulation! You are the valid user");
					NAMETF.setText(null);
					PAASTF.setText(null);
					MAILTF.setText(null);
					OTPTF.setText(null);
				}
				else
				{
					JOptionPane.showMessageDialog(null , "Access Denied");
				}
			}
		});
		VERYB.setToolTipText("");
		VERYB.setForeground(Color.BLUE);
		VERYB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		VERYB.setBounds(878, 341, 130, 33);
		LOGINFRAME.getContentPane().add(VERYB);
		
		JButton EXITBB = new JButton("Exit");				//EXIT BUTTON
		EXITBB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		EXITBB.setToolTipText("");
		EXITBB.setForeground(Color.BLUE);
		EXITBB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		EXITBB.setBounds(891, 580, 117, 33);
		LOGINFRAME.getContentPane().add(EXITBB);	
	}
	public static int OTP ;
	private JPasswordField PAASTF;
}