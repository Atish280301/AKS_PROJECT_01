/* --- USER INTERFACE OF ABOUT SECTION --- */
package PASSWORD_OTP;				//Package Statement

/* Import statements for design the UI*/
import java.awt.EventQueue;			
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
/* Import statements end*/

public class ABOUT_SECTION  //class declaration
{

	private JFrame ABFRAME;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 			//main method
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABOUT_SECTION window = new ABOUT_SECTION();
					window.ABFRAME.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABOUT_SECTION() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ABFRAME = new JFrame();				//JFrame design
		ABFRAME.getContentPane().setBackground(new Color(173, 216, 230));
		ABFRAME.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Atish kumar sahu\\eclipse-workspace\\My_Problem_Solver\\IMGCON\\FRAMEICON.png")); //icon on frame
		ABFRAME.setResizable(false);
		ABFRAME.setTitle("My Problem Solver");
		ABFRAME.setBounds(100, 100, 1050, 679);
		ABFRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ABFRAME.getContentPane().setLayout(null);
		
		JLabel HEADING = new JLabel("About:");			//JLabel "About"
		HEADING.setForeground(new Color(255, 69, 0));
		HEADING.setFont(new Font("Georgia", Font.BOLD, 20));
		HEADING.setBounds(69, 60, 84, 24);
		ABFRAME.getContentPane().add(HEADING);
		
		JLabel MIMG = new JLabel(""); 				//JLabel
		Image img = new ImageIcon(this.getClass().getResource("/ABIMG.png")).getImage(); //IMAGE in Label
		MIMG.setIcon(new ImageIcon(img));
		MIMG.setBounds(687, 120, 200, 200);
		ABFRAME.getContentPane().add(MIMG);
		
		JButton BKB = new JButton("Back"); 				//Back button to go back to front page.
		BKB.addActionListener(new ActionListener() 		//ActionListener
		{
			public void actionPerformed(ActionEvent e) 	//ActionEvent
			{
				FRONT.main(null);
				ABFRAME.dispose();
			}
		});
		BKB.setForeground(Color.BLUE);
		BKB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		BKB.setBounds(892, 580, 117, 33);
		ABFRAME.getContentPane().add(BKB);
		
		JLabel TEXT = new JLabel(""); 			//JLabel "About Atish Kumar Sahu."
		Image img78 = new ImageIcon(this.getClass().getResource("/ABOUTJ.png")).getImage(); //SS of Atish's about section.
		TEXT.setIcon(new ImageIcon(img78));
		TEXT.setBounds(69, 120, 600, 300);
		ABFRAME.getContentPane().add(TEXT);
	}
}
