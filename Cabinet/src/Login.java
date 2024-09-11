import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 354, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\logtari\\Desktop\\dental.PNG"));
		lblNewLabel.setBounds(0, 0, 354, 483);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(27, 76, 140));
		panel_1.setBounds(355, 0, 332, 483);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Se connecter");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel_1.setBounds(40, 49, 255, 54);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Utilisateur");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(40, 151, 255, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\logtari\\Desktop\\icons8_user_20px_1.png"));
		lblNewLabel_5.setBounds(238, 177, 35, 23);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mot de passe");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_3_1.setBounds(40, 219, 255, 14);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5_1.setIcon(new ImageIcon("C:\\Users\\logtari\\Desktop\\icons8_eye_20px_1.png"));
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setBounds(241, 247, 35, 22);
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setBounds(217, 274, 35, 32);
		panel_1.add(lblNewLabel_5_2);
		
		JComboBox role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"Dentiste", "Secrétaire"}));
		role.setBounds(40, 303, 200, 26);
		panel_1.add(role);
		 

		
		JButton btnLogin = new JButton("Se connecter");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new java.awt.Color(132,169,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new java.awt.Color(132,169,217));
			}
		});
		btnLogin.setBackground(new Color(132, 169, 217));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(username.getText().equals("sec") && password.getText().equals("sec123") && role.getSelectedItem().toString().equals("Secrétaire") ) {
					Login.super.dispose();
					SecMenu sec =new SecMenu();
					sec.setVisible(true);
				}
				else if(username.getText().equals("admin") && password.getText().equals("admin") && role.getSelectedItem().toString().equals("Dentiste") ) {
					Login.super.dispose();
					MenuDentiste dentM =new MenuDentiste();
					dentM.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Enter a correct username and password");
					username.setText("");
					password.setText("");
				}
			}
		});
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogin.setBounds(42, 407, 199, 32);
		panel_1.add(btnLogin);
		
		username = new JTextField();
		username.setBounds(40, 176, 200, 26);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(40, 244, 200, 27);
		panel_1.add(password);
		
			}
}
