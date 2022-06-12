/* --- ACCOUNT CREATION USER INTERFACE --- */
package PASSWORD_OTP;			//PACKAGE STATEMENT

/* --- IMPORT STATEMENT FOR 
 	USER INTERFACE DESIGN
 	JDBC INSERTION OPERATION 
 	FILE CHOOSING FROM DEVICE
 */
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
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Toolkit;

public class ACCOUNTCREATE //MAIN CLASS
{
	public static String Path;
	private JFrame ACCCF;
	private JTextField NMTF;
	private JTextField MAILTF;
	private JTextField PASSWORD;
	private JLabel photo;
	
	private JButton refreshb;
	private JButton backb1;
	private JButton addb;
	private JButton createB;
	
	private static final String url = "jdbc:mysql://127.0.0.1:3306/account_details";	//JDBC CONNECTION FOR INSERTION OPERATION
	private static final String user = "root";											//USER NAME
	private static final String pass = "";												//PASSWORD
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 					//MIAN METHOD
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ACCOUNTCREATE window = new ACCOUNTCREATE();
					window.ACCCF.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	
	/**
	 * Create the application.
	 */
	public ACCOUNTCREATE() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ACCCF = new JFrame();				//JFRAME
		ACCCF.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Atish kumar sahu\\eclipse-workspace\\My_Problem_Solver\\IMGCON\\FRAMEICON.png")); //ICON
		ACCCF.getContentPane().setBackground(new Color(173, 216, 230));
		ACCCF.setTitle("My Problem Solver");
		ACCCF.setResizable(false);
		ACCCF.setBounds(100, 100, 1050, 679);
		ACCCF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ACCCF.getContentPane().setLayout(null);
		
		JLabel CYNA = new JLabel("Create Your New Account"); //JLABEL "CREATE ACCOUNT"
		CYNA.setForeground(new Color(255, 69, 0));
		CYNA.setFont(new Font("Georgia", Font.BOLD, 25));
		CYNA.setBounds(76, 55, 328, 24);
		ACCCF.getContentPane().add(CYNA);
		
		JLabel ACNAME = new JLabel("Name: ");					//JLABEL "NAME"
		ACNAME.setForeground(new Color(255, 69, 0));
		ACNAME.setFont(new Font("Georgia", Font.BOLD, 20));
		ACNAME.setBounds(76, 131, 72, 24);
		ACCCF.getContentPane().add(ACNAME);
		
		JLabel invalidname = new JLabel("");						//JLABEL FRO SHOWING INVALID ERROR
		invalidname.setForeground(Color.RED);
		invalidname.setFont(new Font("Tahoma", Font.ITALIC, 13));
		invalidname.setBounds(533, 139, 138, 16);
		ACCCF.getContentPane().add(invalidname);
		
		NMTF = new JTextField();								//NAME TEXTFIELD TO ENTER NAME
		NMTF.setToolTipText("User Name");
		NMTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				String namereg = "^[a-zA-Z_ ]*$";
				Pattern pat1 = Pattern.compile(namereg, Pattern.CASE_INSENSITIVE);
				Matcher mat1 = pat1.matcher(NMTF.getText());
				
				if(!mat1.matches())
				{
					invalidname.setText("*Invalid Input");
				}
				else
				{
					invalidname.setText("");
				}
			}
		});
		NMTF.setFont(new Font("Cambria Math", Font.BOLD, 18));
		NMTF.setBounds(200, 130, 328, 31);
		ACCCF.getContentPane().add(NMTF);
		NMTF.setColumns(10);
		
		JLabel ACMAIL = new JLabel("Gmail:");						//JLABEL "MAIL"
		ACMAIL.setForeground(new Color(255, 69, 0));
		ACMAIL.setFont(new Font("Georgia", Font.BOLD, 20));
		ACMAIL.setBounds(76, 191, 72, 24);
		ACCCF.getContentPane().add(ACMAIL);
		
		JLabel invalidmail = new JLabel("");					//JLABEL SHOW INVALID MAIL ERROR
		invalidmail.setForeground(new Color(255, 0, 0));
		invalidmail.setFont(new Font("Tahoma", Font.ITALIC, 13));
		invalidmail.setBounds(533, 191, 138, 16);
		ACCCF.getContentPane().add(invalidmail);
		
		MAILTF = new JTextField();								//MAIL TEXTFIELD TO ENTER GMAIL.
		MAILTF.setToolTipText("User Mail");
		MAILTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String mailregex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
				Pattern pat = Pattern.compile(mailregex, Pattern.CASE_INSENSITIVE);
				Matcher mat = pat.matcher(MAILTF.getText());
				
				if(!mat.matches())
				{
					invalidmail.setText("*Invalid Input");
				}
				else
				{
					invalidmail.setText("");
				}
			}
		});
		MAILTF.setFont(new Font("Cambria Math", Font.BOLD, 18));
		MAILTF.setColumns(10);
		MAILTF.setBounds(200, 190, 328, 31);
		ACCCF.getContentPane().add(MAILTF);
		
		JLabel ACPW = new JLabel("Password:");						//JLABEL "PASSWORD"
		ACPW.setForeground(new Color(255, 69, 0));
		ACPW.setFont(new Font("Georgia", Font.BOLD, 20));
		ACPW.setBounds(76, 251, 106, 16);
		ACCCF.getContentPane().add(ACPW);
		
		PASSWORD = new JTextField();									//PASSWORD TEXTFIELD FOR CREATE A AUTOMATIC PASSWORD
		PASSWORD.setFont(new Font("Cambria Math", Font.BOLD, 18));
		PASSWORD.setColumns(10);
		PASSWORD.setBounds(200, 246, 328, 31);
		ACCCF.getContentPane().add(PASSWORD);
		
		refreshb = new JButton("");								//REFERESH BUTTON FOR CREATE A PASSWORD
		refreshb.setToolTipText("Auto Generated Password");
		refreshb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String lower = "abcdefghijklmnopqrstuvwxyz";
				String number = "0123456789";
				String special = "~!@#$%^&*_-+|/?><";
				
				String total = upper + special + lower + number;
				
				int length = 15;
				char[] pas = new char[length];
				
				Random rn = new Random();
				for(int i = 0; i < length; i++)
				{
					pas[i] = total.charAt(rn.nextInt(total.length()));
				}
				String PAS = new String(pas);
				PASSWORD.setText(PAS);
			}
		});
		Image img1 = new ImageIcon(this.getClass().getResource("/refresh.png")).getImage(); //REFERESH ICON
		refreshb.setIcon(new ImageIcon(img1));
		refreshb.setBounds(540, 246, 41, 28);
		ACCCF.getContentPane().add(refreshb);
		
		photo = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/person.png")).getImage(); //DEFAULT PERSON PROFILE ICON
		photo.setIcon(new ImageIcon(img2));
		photo.setHorizontalAlignment(SwingConstants.CENTER);
		photo.setBounds(657, 101, 200, 200);
		ACCCF.getContentPane().add(photo);
		
		
		addb = new JButton("");										//BUTTON TO ADD A IMAGE ON PROFILE
		addb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser file = new JFileChooser();										//JFILECHOOSER TO TAKE IMAGE FILE FROM SYSTEM
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png", "gif", "jpeg");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectedFile = file.getSelectedFile();
					Path = selectedFile.getAbsolutePath();
					photo.setIcon(new ImageIcon(Path));
				}
				else if(result == JFileChooser.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(null, "File not found");
				}
			}
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		addb.setIcon(new ImageIcon(img3));
		addb.setBounds(869, 270, 41, 31);
		ACCCF.getContentPane().add(addb);
		
		backb1 = new JButton("Back");				//BACK BUTTON TO GO TO CHOICE USER INTERFACE
		backb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CHOICE.main(null);
				ACCCF.dispose();
			}
		});
		backb1.setForeground(Color.BLUE);
		backb1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		backb1.setBounds(20, 580, 117, 33);
		ACCCF.getContentPane().add(backb1);
		
		createB = new JButton("Create");				//CREATE BUTTON FOR CREATING ACCOUNT
		createB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				try							/*DATA INSERTION IN DATABASE*/
				{				
					Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement ps = con.prepareStatement("insert into users values(? , ? , ? , ?)");
					
					ps.setString(1, NMTF.getText());
					ps.setString(2, MAILTF.getText());
					ps.setString(3, PASSWORD.getText());
					FileInputStream fis = new FileInputStream(Path);
					ps.setBinaryStream(4, fis,fis.available());
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "User "+NMTF.getText()+" Added Successfully"); //MESSAGE SHOWING BOX
					clearfield();
					con.close();
				}
				catch(Exception E1)
				{
					JOptionPane.showMessageDialog(null, "Please Enter Complete data");
					NMTF.setText(null);
					MAILTF.setText(null);
					PASSWORD.setText(null);
					Image img4 = new ImageIcon(this.getClass().getResource("/person.png")).getImage();
					photo.setIcon(new ImageIcon(img4));
				}
			}
		});
		createB.setForeground(Color.BLUE);
		createB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		createB.setBounds(892, 580, 117, 33);
		ACCCF.getContentPane().add(createB);
	}
	
	private void clearfield()
	{
		NMTF.setText(null);
		MAILTF.setText(null);
		PASSWORD.setText(null);
		Image img4 = new ImageIcon(this.getClass().getResource("/person.png")).getImage();
		photo.setIcon(new ImageIcon(img4));
	}
}
