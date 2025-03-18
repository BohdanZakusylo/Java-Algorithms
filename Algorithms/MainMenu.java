package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//end run
		});
	}//end main

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Data Structures Software");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblTitle.setBounds(0, 11, 679, 48);
		frame.getContentPane().add(lblTitle);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnQuit.setBounds(10, 602, 128, 48);
		frame.getContentPane().add(btnQuit);

		JButton btnScore = new JButton("Binary Search Tree");
		btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnScore.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnScore.setBounds(172, 107, 328, 58);
		frame.getContentPane().add(btnScore);

		JButton btnCourse = new JButton("Queue");
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCourse.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnCourse.setBounds(172, 186, 328, 58);
		frame.getContentPane().add(btnCourse);

		JButton btnCourseSearch = new JButton("Stack");
		btnCourseSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCourseSearch.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnCourseSearch.setBounds(172, 266, 328, 58);
		frame.getContentPane().add(btnCourseSearch);

		JButton btnGraph = new JButton("Import Data");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGraph.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnGraph.setBounds(172, 345, 328, 58);
		frame.getContentPane().add(btnGraph);
	}//end initialize
}//end class
