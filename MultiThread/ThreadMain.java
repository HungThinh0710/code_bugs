package thread_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Thread_main extends JFrame {

	private JPanel contentPane;
	private JTextArea taData;
	private HighThread high;
	private LowThread low;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
;
					Thread_main frame = new Thread_main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the frame.
	 */
	public Thread_main() {
		setTitle("Thread Test HT0710");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		taData = new JTextArea();
		taData.setBounds(0, 0, 432, 253);
		contentPane.add(taData);
		
		high = new HighThread(taData);
		high.start();
		
		low = new LowThread(taData);
		low.start();
		
	}
	
	class HighThread extends Thread {
		private JTextArea display;
		public HighThread(JTextArea ta) {
			display = ta;
			setPriority(Thread.MAX_PRIORITY);
		}
		public void run() {
			for(int x = 1; x<=5;x++) {
				display.append("High Thread !! \n");
			}
		}
	}
	
	class LowThread extends Thread{
		private JTextArea display;
		public LowThread(JTextArea ta) {
			display = ta;
			setPriority(Thread.MIN_PRIORITY);
		}
		public void run() {
			for(int y = 1;y <= 5; y++) {
				display.append("Low Thread !! \n");
			}
		}
	}

}
