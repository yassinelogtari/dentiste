import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SecMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecMenu frame = new SecMenu();
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
	public SecMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 245, 255));
		panel.setBorder(new CompoundBorder());
		panel.setBounds(0, 0, 745, 441);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\deconnexion.png"));
		btnDeconnexion.setBackground(new Color(255, 237, 211));
		btnDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecMenu.super.dispose();
				Login log =new Login();
				log.setVisible(true);
			}
		});
		btnDeconnexion.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btnDeconnexion.setBounds(515, 315, 117, 33);
		panel.add(btnDeconnexion);
		
		JButton btnNewButton_1_1 = new JButton("Rendez_vous");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\rendez-vous (1).png"));
		btnNewButton_1_1.setBackground(new Color(209, 255, 164));
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecMenu.super.dispose();
				SecRendezvous ren =new SecRendezvous();
				ren.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(491, 230, 169, 47);
		panel.add(btnNewButton_1_1);
		
		JButton fichepatient = new JButton("Fiche Patient");
		fichepatient.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\informations-personnelles.png"));
		fichepatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecMenu.super.dispose();
				FichePatient fic =new FichePatient();
				fic.setVisible(true);
			}
		});
		fichepatient.setFont(new Font("Segoe UI", Font.BOLD, 15));
		fichepatient.setBackground(new Color(255, 255, 177));
		fichepatient.setBounds(489, 146, 170, 47);
		panel.add(fichepatient);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\image-removebg-preview (9).png"));
		lblNewLabel_1.setBounds(2, 8, 626, 411);
		panel.add(lblNewLabel_1);
	}
}
