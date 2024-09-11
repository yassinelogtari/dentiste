import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DentisteFichePatient extends JFrame {
	private DefaultTableModel model;

	private JPanel contentPane;
	private JTable tableDentisteP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DentisteFichePatient frame = new DentisteFichePatient();
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
	public DentisteFichePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 245, 255));
		panel.setBounds(0, 0, 687, 474);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 118, 614, 313);
		panel.add(scrollPane);
		
		tableDentisteP = new JTable();
		scrollPane.setViewportView(tableDentisteP);
		tableDentisteP.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"CIN","Nom","Prenom","Sexe","Telephone","Adresse","Soins"
			}
		));
		model = (DefaultTableModel)tableDentisteP.getModel();
		 String filePath = "C:\\Users\\logtari\\Desktop\\patient.txt";
	        File file = new File(filePath);
	        
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(file));
	          
	            String firstLine = br.readLine().trim();
	            String[] columnsName = firstLine.split(",");
	            model.setColumnIdentifiers(columnsName);
	            

	            Object[] tableLines = br.lines().toArray();
	            br.close();
	            
	            for(int i = 0; i < tableLines.length; i++)
	            {
	                String line = tableLines[i].toString().trim();
	                String[] dataRow = line.split("/");
	                model.addRow(dataRow);
	            }
	            
	            
	        } catch (Exception ex) {
	           ex.printStackTrace();
	        }
	        String [] nomcolonne = {"CIN","Nom","Prenom","Sexe","Telephone","Adresse"};
	        model= new DefaultTableModel(nomcolonne,0) {
				@Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
			};
		
		JLabel lblRendezVous = new JLabel("Patients");
		lblRendezVous.setHorizontalAlignment(SwingConstants.CENTER);
		lblRendezVous.setFont(new Font("SimSun", Font.BOLD, 25));
		lblRendezVous.setBounds(0, 11, 687, 56);
		panel.add(lblRendezVous);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DentisteFichePatient.super.dispose();
				MenuDentiste dentM =new MenuDentiste();
				dentM.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\retour.png"));
		btnNewButton.setBackground(new Color(218, 245, 255));
		btnNewButton.setBounds(35, 22, 42, 33);
		panel.add(btnNewButton);
	}
}
