import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuDentiste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDentiste frame = new MenuDentiste();
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
	public MenuDentiste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 688, 474);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(253, 226, 243));
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(251, 107, 164, 126);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Home");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(4, 84, 164, 30);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\abri.png"));
		lblNewLabel_6.setBounds(44, 10, 81, 77);
		panel_3.add(lblNewLabel_6);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_1.setBackground(new Color(253, 226, 243));
		panel_3_1.setBounds(470, 107, 164, 128);
		panel.add(panel_3_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuDentiste.super.dispose();
				PlannigRendezVous plan =new PlannigRendezVous();
				plan.setVisible(true);
			}
		});
		lblNewLabel.setBounds(43, 11, 81, 77);
		panel_3_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\rendez-vous (3).png"));
		
		JLabel lblNewLabel_2_1 = new JLabel("Rendez Vous");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(10, 87, 164, 30);
		panel_3_1.add(lblNewLabel_2_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuDentiste.super.dispose();
				Soins soin =new Soins();
				soin.setVisible(true);
			}
		});
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_2.setBackground(new Color(253, 226, 243));
		panel_3_2.setBounds(249, 285, 165, 122);
		panel.add(panel_3_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Soins");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(10, 81, 164, 30);
		panel_3_2.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\medical.png"));
		lblNewLabel_3.setBounds(54, 6, 81, 77);
		panel_3_2.add(lblNewLabel_3);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_3.setBackground(new Color(253, 226, 243));
		panel_3_3.setBounds(470, 285, 164, 122);
		panel.add(panel_3_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Patient");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2_1_2.setBounds(0, 81, 164, 30);
		panel_3_3.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuDentiste.super.dispose();
				DentisteFichePatient fichep =new DentisteFichePatient();
				fichep.setVisible(true);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\patient (1).png"));
		lblNewLabel_4.setBounds(47, 0, 81, 77);
		panel_3_3.add(lblNewLabel_4);
		
		JButton btnDeconnexion = new JButton("");
		btnDeconnexion.setBounds(642, 16, 31, 33);
		panel.add(btnDeconnexion);
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDentiste.super.dispose();
				Login log =new Login();
				log.setVisible(true);
			}
		});
		btnDeconnexion.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\deconnexion.png"));
		btnDeconnexion.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDeconnexion.setBackground(new Color(255, 226, 243));
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(-4, -55, 168, 592);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\logtari\\Desktop\\dentback.PNG"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\logtari\\Desktop\\fou9.PNG"));
		lblNewLabel_1.setBounds(168, -3, 518, 79);
		panel.add(lblNewLabel_1);
	}
}
