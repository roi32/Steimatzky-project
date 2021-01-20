package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.testng.TestNG;
import org.testng.collections.Lists;

public class Runner {
	static JFrame frame = new JFrame("Steimatzky-project‬");
	public static JLabel label1 = new JLabel();
	public static JLabel label2 = new JLabel();
	public static JLabel label3 = new JLabel();

	public static void main(String[] args) {

		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setBounds(90, 50, 210, 110);
		label2.setBounds(100, 120, 210, 110);
		label3.setBounds(90, 190, 210, 110);
		frame.add(label1);
		frame.add(label2);
		JButton btn = new JButton("Home page");
		btn.setBounds(90, 50, 120, 40);
		JButton btn1 = new JButton("Login");
		btn1.setBounds(90, 120, 120, 40);
		JButton btn2 = new JButton("test3");
		btn2.setBounds(90, 190, 120, 40);
		frame.add(btn);
		frame.add(btn1);

		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				try {
					TestNG testng = new TestNG();
					List<String> suites = Lists.newArrayList();
					suites.add("Home_Page.xml");
					testng.setTestSuites(suites);
					testng.run();
				} catch (Exception e) {
					e.printStackTrace();
					label1.setText("Home page test fail");
				}
			}
		});
		
		btn1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				try {
					TestNG testng = new TestNG();
					List<String> suites = Lists.newArrayList();
					suites.add("Login.xml");
					testng.setTestSuites(suites);
					testng.run();
					label2.setText("Login test ended");
				} catch (Exception e) {
					e.printStackTrace();
					label2.setText("Login test fail");
				}
			}
		});
//
	}
//
}
