import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class Soins extends JFrame {

	int selectedRow;
	 private List<String> listeSoins;
	
	private ArrayList<Soinsp> soins;
	
	private DefaultTableModel model;
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adresse;
	private JTextField telephone;
	private JTextField cin;
	private JTable tableSoins;
	private JTextField chercheInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Soins frame = new Soins();
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
	public Soins() {
		
		
		
		
		
		
		listeSoins = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 245, 255));
		panel.setBounds(0, 0, 688, 474);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nom = new JTextField();
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setColumns(10);
		nom.setBounds(92, 46, 125, 20);
		panel.add(nom);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(18, 46, 46, 14);
		panel.add(lblNewLabel_1);
		
		prenom = new JTextField();
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setColumns(10);
		prenom.setBounds(92, 94, 125, 20);
		panel.add(prenom);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(18, 94, 64, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Sexe :");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(18, 143, 46, 14);
		panel.add(lblNewLabel_1_5);
		
		JComboBox sexe = new JComboBox();
		sexe.setModel(new DefaultComboBoxModel(new String[] {"", "Homme", "Femme"}));
		sexe.setBounds(93, 142, 124, 22);
		panel.add(sexe);
		
		adresse = new JTextField();
		adresse.setHorizontalAlignment(SwingConstants.CENTER);
		adresse.setColumns(10);
		adresse.setBounds(338, 143, 125, 20);
		panel.add(adresse);
		
		telephone = new JTextField();
		telephone.setHorizontalAlignment(SwingConstants.CENTER);
		telephone.setColumns(10);
		telephone.setBounds(338, 94, 125, 20);
		panel.add(telephone);
		
		cin = new JTextField();
		cin.setHorizontalAlignment(SwingConstants.CENTER);
		cin.setColumns(10);
		cin.setBounds(338, 46, 125, 20);
		panel.add(cin);
		
		JLabel lblNewLabel_1_3 = new JLabel("CIN:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(209, 46, 89, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telephone:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(238, 94, 83, 20);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adresse :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(235, 143, 74, 14);
		panel.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 289, 639, 174);
		panel.add(scrollPane);
		
		tableSoins = new JTable();
		tableSoins.setModel( new DefaultTableModel(
				new Object [][] {
					
				},
				new String[] {
						"CIN","Nom","Prenom","Sexe","Telephone","Adresse"
				})
				);
		scrollPane.setViewportView(tableSoins);
		model = (DefaultTableModel)tableSoins.getModel();
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Soins:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 229, 74, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JComboBox soins = new JComboBox();
		soins.setModel(new DefaultComboBoxModel(new String[] {"", "Détartrage", "Plombage", "Dévitalisation dentaire", "Prothèses dentaires", "Extraction dentaire", "Scellement des sillons"}));
		soins.setBounds(93, 222, 124, 31);
		panel.add(soins);
		
		JButton btnAjouterSoins = new JButton("Ajouter Soins");
		btnAjouterSoins.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\ajouter.png"));
		btnAjouterSoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				
					  String fichier = "C:\\Users\\logtari\\Desktop\\patient.txt"; 
				      String patRecherche = cin.getText();
				      String nouvelleLigne = cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+soins.getSelectedItem().toString();
				      
				      try {
				       
				         FileInputStream fstream = new FileInputStream(fichier);
				         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				         
				    
				         StringBuffer buffer = new StringBuffer();
				         
				         String ligne;
				   
				         while ((ligne = br.readLine()) != null) {
				           
				            if (ligne.contains(patRecherche)) {
				               ligne = nouvelleLigne;
				            }
				           
				            buffer.append(ligne);
				            buffer.append("\n");
				         }
				         
				         
				         br.close();
				         
				       
				         FileOutputStream fos = new FileOutputStream(fichier);
				         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				         
				       
				         bw.write(buffer.toString());
				         
				         
				         bw.close();
				         
				      } catch (IOException et) {
				         System.err.println("Erreur : " + et.getMessage());
				      }
				      
				      String filePath = "C:\\Users\\logtari\\Desktop\\patient.txt";
				        File file = new File(filePath);
				        
				        try {
				            BufferedReader br = new BufferedReader(new FileReader(file));
				          
				            String firstLine = br.readLine().trim();
				            String[] columnsName = firstLine.split(",");
				            DefaultTableModel model = (DefaultTableModel)tableSoins.getModel();
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
				        
				        
				        DefaultTableModel modeleVide = new DefaultTableModel();

			            
			            tableSoins.setModel(modeleVide);
				        
				        
				        String filePathe = "C:\\Users\\logtari\\Desktop\\patient.txt";
				        File filee = new File(filePathe);
				        
				        try {
				            BufferedReader br = new BufferedReader(new FileReader(filee));
				          
				            String firstLine = br.readLine().trim();
				            String[] columnsName = firstLine.split(",");
				            DefaultTableModel model = (DefaultTableModel)tableSoins.getModel();
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
				        
				        nom.setText("");
						prenom.setText("");
						cin.setText("");
						adresse.setText("");
						telephone.setText("");
						sexe.setSelectedItem(1);
						soins.setSelectedItem(1);
						
						 JOptionPane.showMessageDialog(btnAjouterSoins,"Le soin a été ajouté");
					
								}
		});
		
		
		
		
		
		
		
		btnAjouterSoins.setForeground(Color.BLACK);
		btnAjouterSoins.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAjouterSoins.setBackground(new Color(225, 255, 177));
		btnAjouterSoins.setBounds(261, 198, 146, 31);
		panel.add(btnAjouterSoins);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(518, 40, 146, 124);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\chercher.png"));
		btnChercher.setBounds(10, 59, 130, 43);
		panel_1.add(btnChercher);
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				long chercheID= Integer.valueOf(chercheInput.getText());
				String schercheID= String.valueOf(chercheID);
				for (int i=0;i<tableSoins.getRowCount();i++) {
					if (tableSoins.getValueAt(i, 0).equals(schercheID)) {
						String cincher=tableSoins.getValueAt(i, 0).toString();
						String nomcher=tableSoins.getValueAt(i, 1).toString();
						String prenomcher=tableSoins.getValueAt(i, 2).toString();
						String sexecher=tableSoins.getValueAt(i, 3).toString();
						String telcher=tableSoins.getValueAt(i, 4).toString();
						String adressecher=tableSoins.getValueAt(i, 5).toString();
		
						nom.setText(nomcher);
						prenom.setText(prenomcher);
						cin.setText(cincher);
						sexe.setSelectedItem(sexecher);
						telephone.setText(telcher);
						adresse.setText(adressecher);
						chercheInput.setText("");
					}
					 
				}
			
				
			}
		});
		btnChercher.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnChercher.setBackground(new Color(251, 235, 180));
		
		
		chercheInput = new JTextField();
		chercheInput.setBounds(50, 11, 90, 25);
		panel_1.add(chercheInput);
		chercheInput.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CIN:");
		lblNewLabel_2.setBounds(0, 16, 46, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnModifierSoins = new JButton("Modifier Soins");
		btnModifierSoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String fichier = "C:\\Users\\logtari\\Desktop\\patient.txt"; 
			      String patRecherche = cin.getText();
			      String nouvelleLigne = cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+soins.getSelectedItem().toString();
			      
			      try {
			       
			         FileInputStream fstream = new FileInputStream(fichier);
			         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			         
			    
			         StringBuffer buffer = new StringBuffer();
			         
			         String ligne;
			   
			         while ((ligne = br.readLine()) != null) {
			           
			            if (ligne.contains(patRecherche)) {
			               ligne = nouvelleLigne;
			            }
			           
			            buffer.append(ligne);
			            buffer.append("\n");
			         }
			         
			         
			         br.close();
			         
			       
			         FileOutputStream fos = new FileOutputStream(fichier);
			         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			         
			       
			         bw.write(buffer.toString());
			         
			         
			         bw.close();
			         
			      } catch (IOException et) {
			         System.err.println("Erreur : " + et.getMessage());
			      }
			      
			      String filePath = "C:\\Users\\logtari\\Desktop\\patient.txt";
			        File file = new File(filePath);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(file));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tableSoins.getModel();
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
			        
			        
			        DefaultTableModel modeleVide = new DefaultTableModel();

		            
		            tableSoins.setModel(modeleVide);
			        
			        
			        String filePathe = "C:\\Users\\logtari\\Desktop\\patient.txt";
			        File filee = new File(filePathe);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(filee));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tableSoins.getModel();
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
			        
			        nom.setText("");
					prenom.setText("");
					cin.setText("");
					adresse.setText("");
					telephone.setText("");
					sexe.setSelectedItem(1);
					soins.setSelectedItem(1);
					
					 JOptionPane.showMessageDialog(btnAjouterSoins,"Le soin a été modifier");
			}
		});
		btnModifierSoins.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\edition.png"));
		btnModifierSoins.setForeground(Color.BLACK);
		btnModifierSoins.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnModifierSoins.setBackground(new Color(134, 229, 255));
		btnModifierSoins.setBounds(261, 247, 146, 31);
		panel.add(btnModifierSoins);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\image-removebg-preview (10).png"));
		lblNewLabel.setBounds(545, 164, 110, 123);
		panel.add(lblNewLabel);
		
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
	        String nomcher="";
			String prenomcher="";
	        
			if(PlannigRendezVous.nomprenom!= null) {
				String[] parties = PlannigRendezVous.nomprenom.split(" ");
				
				 nomcher=parties[1];
				 prenomcher=parties[0];
			}
	    	
	
			for (int i=0;i<tableSoins.getRowCount();i++) {
				
				if (tableSoins.getValueAt(i,1).equals(prenomcher) && tableSoins.getValueAt(i,2).equals(nomcher)) {
					tableSoins.setRowSelectionInterval(i,i);
					cin.setText(tableSoins.getValueAt(i, 0).toString());
					nom.setText(tableSoins.getValueAt(i, 1).toString());
					prenom.setText(tableSoins.getValueAt(i, 2).toString());
					sexe.setSelectedItem(tableSoins.getValueAt(i, 3));
					telephone.setText(tableSoins.getValueAt(i, 4).toString());
					adresse.setText(tableSoins.getValueAt(i, 5).toString());
					soins.setSelectedItem(tableSoins.getValueAt(i, 6));
				}
			}
	        tableSoins.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 selectedRow=tableSoins.getSelectedRow();
					if (e.getButton()==MouseEvent.BUTTON1) {
						int indice = tableSoins.getSelectedRow();
						if(indice != -1) {
							cin.setText(tableSoins.getValueAt(indice, 0).toString());
							nom.setText(tableSoins.getValueAt(indice, 1).toString());
							prenom.setText(tableSoins.getValueAt(indice, 2).toString());
							sexe.setSelectedItem(tableSoins.getValueAt(indice, 3));
							telephone.setText(tableSoins.getValueAt(indice, 4).toString());
							adresse.setText(tableSoins.getValueAt(indice, 5).toString());
							soins.setSelectedItem(tableSoins.getValueAt(indice, 6));
						
							
						}
					}else if (e.getButton()==MouseEvent.BUTTON3) {
						nom.setText("");
						prenom.setText("");
						cin.setText("");
						adresse.setText("");
						telephone.setText("");
						sexe.setSelectedItem("");
						tableSoins.clearSelection();
					}
				}
			});
			tableSoins.setModel(model);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Soins.super.dispose();
					PlannigRendezVous log =new PlannigRendezVous();
					log.setVisible(true);
				}
			});
			btnNewButton.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\retour.png"));
			btnNewButton.setBackground(new Color(218, 245, 255));
			btnNewButton.setBounds(18, 2, 42, 33);
			panel.add(btnNewButton);
	    	
	        String [] nomcolonne = {"Patient","Date","Heure","Email"};
	        model= new DefaultTableModel(nomcolonne,0) {
				@Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
			};
			JTableHeader header = tableSoins.getTableHeader(); 
			header.setBackground(new Color(247, 239, 229));
			
			
		
	}
}
