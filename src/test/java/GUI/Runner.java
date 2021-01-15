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
	static JLabel label1 = new JLabel();
	static JLabel label2 = new JLabel();
	static JLabel label4 = new JLabel();

	public static void main(String[] args) {

		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1.setBounds(95, 50, 210, 110);
		label2.setBounds(95, 120, 210, 110);
		label4.setBounds(70, 190, 210, 110);
		frame.add(label1);
		JButton btn = new JButton("Home page");
		btn.setBounds(90, 50, 120, 40);
		JButton btn1 = new JButton("test2");
		btn1.setBounds(90, 120, 120, 40);
		JButton btn2 = new JButton("test3");
		btn2.setBounds(90, 190, 120, 40);
		frame.add(btn);

		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					TestNG testng = new TestNG();
					List<String> suites = Lists.newArrayList();
					suites.add("C:\\Users\\royko\\git\\Steimatzky-project\\src\\test\\java\\GUI\\Home_Page.xml");
					testng.setTestSuites(suites);
					testng.run();
					label1.setText("Home page test pass");
				} catch (Exception e) {
					e.printStackTrace();
					label1.setText("Home page test fail");
				}

			}
		});
//
	}
//
}
