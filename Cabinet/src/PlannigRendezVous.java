import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class PlannigRendezVous extends JFrame {
	int selectedRow;
	public static String nomprenom;
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTable tableRendezvousD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlannigRendezVous frame = new PlannigRendezVous();
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
	public PlannigRendezVous() {
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
		

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(183, 77, 177, 26);
		panel.add(dateChooser);
		
		
	        String [] nomcolonne = {"Patient","Date","Heure","Email"};
	        model= new DefaultTableModel(nomcolonne,0) {
				@Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
			};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 132, 614, 313);
		panel.add(scrollPane);
		
		tableRendezvousD = new JTable();
		scrollPane.setViewportView(tableRendezvousD);
		tableRendezvousD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Patient","Date","Heure","Email"
			}
		));
		
		JTableHeader header = tableRendezvousD.getTableHeader(); 
		header.setBackground(new Color(247, 239, 229));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlannigRendezVous.super.dispose();
				MenuDentiste dentM =new MenuDentiste();
				dentM.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(218, 245, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\retour.png"));
		btnNewButton.setBounds(35, 11, 42, 33);
		panel.add(btnNewButton);
		
		JLabel lblRendezVous = new JLabel("Rendez Vous");
		lblRendezVous.setHorizontalAlignment(SwingConstants.CENTER);
		lblRendezVous.setFont(new Font("SimSun", Font.BOLD, 25));
		lblRendezVous.setBounds(0, 0, 687, 56);
		panel.add(lblRendezVous);
		
		
		final int[] clickCount = { 0 };
		
		
		JButton btnImporter = new JButton("");
		btnImporter.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\importer.png"));
		btnImporter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (++clickCount[0]> 1) {
					  
					  Date selectedDate = dateChooser.getDate();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String dateString = dateFormat.format(selectedDate);
						
						int k=0;
					
						try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\logtari\\Desktop\\rendezvous.txt"))) {
					        String line;
					        while ((line = reader.readLine()) != null) {
					            if (line.contains(dateString)) {
					            	
					               
					                String[] fields = line.split("/");
					                Object[] rowData = new Object[4];
					               rowData[0] = fields[0];
					                rowData[1] = fields[1];
					                rowData[2] = fields[2];
					                rowData[3] = fields[3];
					                k=1;
					                
					               model.addRow(rowData);
					            
					            }
					          
					        }
					        if(k==0) {
					        	JOptionPane.showMessageDialog(btnImporter,"Pas de rendez vous dans cette date");
					        }
					    } catch (IOException ex) {
					        ex.printStackTrace();
					    }
						tableRendezvousD.setModel(model);
		        }
				else {
					Date selectedDate = dateChooser.getDate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String dateString = dateFormat.format(selectedDate);
					
					int k=0;
				
					try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\logtari\\Desktop\\rendezvous.txt"))) {
				        String line;
				        while ((line = reader.readLine()) != null) {
				            if (line.contains(dateString)) {
				            	
				                
				                String[] fields = line.split("/");
				                Object[] rowData = new Object[4];
				               rowData[0] = fields[0];
				                rowData[1] = fields[1];
				                rowData[2] = fields[2];
				                rowData[3] = fields[3];
				                k=1;
				              
				               model.addRow(rowData);
				              
				            }
				          
				        }
				        if(k==0) {
				        	JOptionPane.showMessageDialog(btnImporter,"Pas de rendez vous dans cette date");
				        }
				    } catch (IOException ex) {
				        ex.printStackTrace();
				    }
					tableRendezvousD.setModel(model);
				}
				
				
			}
		});
		
		tableRendezvousD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 selectedRow=tableRendezvousD.getSelectedRow();
				if (e.getButton()==MouseEvent.BUTTON1) {
					int indice = tableRendezvousD.getSelectedRow();
					if(indice != -1) {
						
					nomprenom=tableRendezvousD.getValueAt(indice, 0).toString();
					//System.out.println(nomprenom);
						
						PlannigRendezVous.super.dispose();
						Soins soin =new Soins();
						soin.setVisible(true);
					}
				
				}
			}
		});
		btnImporter.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnImporter.setBackground(new Color(251, 235, 180));
		btnImporter.setBounds(368, 77, 24, 26);
		panel.add(btnImporter);
		
	}
}
