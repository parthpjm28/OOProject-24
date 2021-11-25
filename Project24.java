import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


public class Project24 implements ActionListener {
	
	private JFrame frmProjectA;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField astartext;
	private JTextField dijkstratext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project24 window = new Project24();
					window.frmProjectA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new Project24();
	}

	/**
	 * Create the application.
	 */
	public Project24() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectA = new JFrame();
		frmProjectA.setTitle("Project 24 A Star");
		frmProjectA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectA.getContentPane().setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
	    int width = screenSize.width;
	    frmProjectA.setSize(3*width/4, 3*height/4);
	    frmProjectA.setLocationRelativeTo(null);
	    frmProjectA.setBackground(null);
		
		
		
		JLabel lblNewLabel = new JLabel("INPUT CO-ORDINATES OF CITIES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(182, 144, 202, 21);
		frmProjectA.getContentPane().add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 177, 552, 287);
		frmProjectA.getContentPane().add(textPane);
		
		JLabel lblNewLabel_1 = new JLabel("NO. OF CITIES");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(102, 74, 132, 13);
		frmProjectA.getContentPane().add(lblNewLabel_1);
		
		JTextField textField= new JTextField();
		textField.setBounds(258, 71, 96, 19);
		frmProjectA.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(601, 177, 512, 287);
		frmProjectA.getContentPane().add(textPane_1);
		
		JLabel lblNewLabel_2 = new JLabel("INPUT EDGES DISTANCES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(768, 148, 163, 17);
		frmProjectA.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(835, 71, 96, 19);
		frmProjectA.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NO. OF EDGES");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(694, 74, 110, 13);
		frmProjectA.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(573, 486, 96, 19);
		frmProjectA.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("QUERY(Start, Goal)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(437, 488, 126, 13);
		frmProjectA.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("A STAR DISTANCE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(108, 572, 126, 28);
		frmProjectA.getContentPane().add(lblNewLabel_5);
		
		astartext = new JTextField();
		astartext.setHorizontalAlignment(SwingConstants.CENTER);
		astartext.setBounds(243, 578, 96, 19);
		frmProjectA.getContentPane().add(astartext);
		astartext.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("DIJKSTRA DISTANCE");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(737, 576, 149, 21);
		frmProjectA.getContentPane().add(lblNewLabel_6);
		
		dijkstratext = new JTextField();
		dijkstratext.setHorizontalAlignment(SwingConstants.CENTER);
		dijkstratext.setBounds(896, 578, 96, 19);
		frmProjectA.getContentPane().add(dijkstratext);
		dijkstratext.setColumns(10);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(textField.getText()); //no of cities
				int m = Integer.parseInt(textField_1.getText());
				City c[] = new City[n];
				Scanner sc = new Scanner(textPane.getText());
				for(int i=0; i <n; i++){
					int v = sc.nextInt();   // adding cities
					int x = sc.nextInt();
					int y = sc.nextInt();
					c[i] = new City(v,x,y);
				}
				sc.close();
				sc = new Scanner(textPane_1.getText());
				for(int j =0; j<m; j++){
					int p = sc.nextInt();
					int q = sc.nextInt();
					int r = sc.nextInt();   // adding edges
					c[p].addEdge(r,c[q]);
					c[q].addEdge(r,c[p]);
				}
				
				sc.close();
				sc = new Scanner(textField_2.getText())	;						
				int temp1 = sc.nextInt();	// defining Start and Goal
				int temp2 = sc.nextInt();
				Input input = new Input(n,m,c,temp1,temp2);
				astartext.setText(input.a_star);
				dijkstratext.setText(input.dijkstra);

				
			}
		});
		
		btnNewButton.setBounds(526, 530, 85, 21);
		btnNewButton.addActionListener(this);
		frmProjectA.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("MOOGLE GAPS");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel_7.setBounds(487, 20, 163, 50);
		frmProjectA.getContentPane().add(lblNewLabel_7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
	}


}
