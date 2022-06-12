/*	--- FRONT USER INTERFACE --- */
package PASSWORD_OTP;								//package statement

import java.awt.EventQueue;						//EventQueue import

import javax.swing.JFrame;						//JFrame import
import java.awt.Font;							//Font import
import java.awt.Image;							//Image import
import java.awt.Color;							//Color import
import javax.swing.JLabel;						//JLabel import
import javax.swing.JButton;						//JButton import
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;			//ActionListener import
import java.awt.event.ActionEvent;
import java.awt.Toolkit;						//Toolkit import

public class FRONT 							//class name
{

	private JFrame FRAME;				// JFrame declaration

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 			//main function
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FRONT window = new FRONT();
					window.FRAME.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FRONT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		FRAME = new JFrame();		// FRAME DESIGN
		FRAME.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Atish kumar sahu\\eclipse-workspace\\My_Problem_Solver\\IMGCON\\FRAMEICON.png")); //icon on frame
		FRAME.setResizable(false);
		FRAME.getContentPane().setBackground(new Color(173, 216, 230));
		FRAME.setTitle("My Problem Solver");
		FRAME.setBounds(100, 100, 1050, 679);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Generating Password and OTP in Java"); 		//LABEL PROJECT NAME: "Generating Password and OTP in Java"
		lblNewLabel_1.setBounds(207, 66, 603, 55);
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 30));
		FRAME.getContentPane().add(lblNewLabel_1);
		
		JLabel SUBMITTED_BY = new JLabel("Created By:");						//LABEL "Submitted By"
		SUBMITTED_BY.setForeground(new Color(255, 69, 0));
		SUBMITTED_BY.setFont(new Font("Georgia", Font.BOLD, 20));
		SUBMITTED_BY.setBounds(567, 287, 129, 33);
		FRAME.getContentPane().add(SUBMITTED_BY);
		
		JLabel AKS = new JLabel("Atish Kumar Sahu");						//LABEL = My name
		AKS.setForeground(new Color(0, 0, 0));
		AKS.setFont(new Font("Georgia", Font.BOLD, 18));
		AKS.setBounds(601, 333, 181, 33);
		FRAME.getContentPane().add(AKS);
		
		JLabel GMAIL = new JLabel("kumarsahuatish280301@gmail.com");	//LABEL = Official Mail
		GMAIL.setForeground(new Color(0, 0, 0));
		GMAIL.setFont(new Font("Georgia", Font.BOLD, 18));
		GMAIL.setBounds(601, 379, 346, 33);
		FRAME.getContentPane().add(GMAIL);
		
		JLabel EDU = new JLabel("B.Tech, 8th Semester");			//LABEL = Current educational status 
		EDU.setForeground(new Color(0, 0, 0));
		EDU.setFont(new Font("Georgia", Font.BOLD, 18));
		EDU.setBounds(601, 425, 198, 27);
		FRAME.getContentPane().add(EDU);
		
		JLabel CSE = new JLabel("Computer Science & Engineering"); //LABEL = BRANCH
		CSE.setForeground(new Color(0, 0, 0));
		CSE.setFont(new Font("Georgia", Font.BOLD, 18));
		CSE.setBounds(601, 472, 311, 24);
		FRAME.getContentPane().add(CSE);
		
		JLabel LOC = new JLabel("Berhampur, Ganjam, Odisha- 760009"); //LABEL = LOCATION
		LOC.setForeground(new Color(0, 0, 0));
		LOC.setFont(new Font("Georgia", Font.BOLD, 18));
		LOC.setBounds(601, 509, 362, 33);
		FRAME.getContentPane().add(LOC);
		
		JButton Click = new JButton("Click");				//BUTTON = Click
		Click.addActionListener(new ActionListener() 							//ActionListener operation method
		{
			public void actionPerformed(ActionEvent e) 						//ActionEvent operation method
			{
				CHOICE.main(null);
				FRAME.dispose();
			}
		});
		Click.setToolTipText("Go To Project Section.");
		Click.setForeground(Color.BLUE);
		Click.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		Click.setBounds(20, 580, 117, 33);
		FRAME.getContentPane().add(Click);
		
		JButton ABOUTB = new JButton("About");					//BUTTON = About
		ABOUTB.addActionListener(new ActionListener() 									//ActionListener operation method
		{
			public void actionPerformed(ActionEvent arg0) 								//ActionEvent operation method
			{
				ABOUT_SECTION.main(null);
				FRAME.dispose();
			}
		});
		ABOUTB.setToolTipText("About Section");
		ABOUTB.setForeground(Color.BLUE);
		ABOUTB.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		ABOUTB.setBounds(455, 580, 117, 33);
		FRAME.getContentPane().add(ABOUTB);
		
		JButton Exit = new JButton("Exit");						//BUTTON = EXIT
		Exit.addActionListener(new ActionListener() 									//ActionListener operation method
		{
			public void actionPerformed(ActionEvent e) 								//ActionEvent operation method
			{
				System.exit(0);
			}
		});
		Exit.setForeground(Color.BLUE);
		Exit.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		Exit.setBounds(892, 580, 117, 33);
		FRAME.getContentPane().add(Exit);
	}
}
