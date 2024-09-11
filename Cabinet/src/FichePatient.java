import java.awt.EventQueue;

import javax.swing.JScrollPane;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

public class FichePatient extends JFrame {

	
	int selectedRow;
	
	private ArrayList<Patient> patients;
	private DefaultTableModel model;
	
	
	
	private JPanel contentPane;
	private JTextField chercheInput;
	private JTextField adresse;
	private JTextField telephone;
	private JTextField cin;
	private JTextField prenom;
	private JTextField nom;
	private JTable tablePatient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichePatient frame = new FichePatient();
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
	public FichePatient() {
		
		
		String [] nomcolonne = {"CIN","Nom","Prenom","Sexe","Telephone","Adresse"};
		patients=new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 245, 255));
		panel.setBounds(0, 0, 687, 534);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(218, 245, 255));
		panel_1.setBounds(512, 63, 154, 225);
		panel.add(panel_1);
		panel_1.setLayout(null);
		 Border border = BorderFactory.createLineBorder(Color.black);
		
		chercheInput = new JTextField();
		chercheInput.setBounds(45, 8, 90, 25);
		panel_1.add(chercheInput);
		chercheInput.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CIN:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(-2, 12, 46, 14);
		panel_1.add(lblNewLabel_2);
		JComboBox sexe = new JComboBox();
		sexe.setModel(new DefaultComboBoxModel(new String[] {"", "Homme", "Femme"}));
		sexe.setBounds(80, 122, 124, 22);
		panel_2.add(sexe);
		

		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\chercher.png"));
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				long chercheID= Integer.valueOf(chercheInput.getText());
				String schercheID= String.valueOf(chercheID);
				for (int i=0;i<tablePatient.getRowCount();i++) {
					if (tablePatient.getValueAt(i, 0).equals(schercheID)) {
						String cincher=tablePatient.getValueAt(i, 0).toString();
						String nomcher=tablePatient.getValueAt(i, 1).toString();
						String prenomcher=tablePatient.getValueAt(i, 2).toString();
						String sexecher=tablePatient.getValueAt(i, 3).toString();
						String telcher=tablePatient.getValueAt(i, 4).toString();
						String adressecher=tablePatient.getValueAt(i, 5).toString();
						nom.setText(nomcher);
						prenom.setText(prenomcher);
						cin.setText(cincher);
						sexe.setSelectedItem(sexecher);
						telephone.setText(telcher);
						adresse.setText(adressecher);	
					}
					 
				}
			}
		});
		 Border borderc = BorderFactory.createLineBorder(Color.black);
	      btnChercher.setBorder(borderc);
		btnChercher.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnChercher.setBackground(new Color(251, 235, 180));
		btnChercher.setBounds(8, 44, 130, 43);
		panel_1.add(btnChercher);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(28, 110, 107, 111);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\image-removebg-preview (12).png"));
		
		
		JLabel lblNewLabel = new JLabel("Patient");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(4, 2, 687, 56);
		panel.add(lblNewLabel);
		
		JButton ajout = new JButton("Ajouter");
		ajout.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\ajouter.png"));
		ajout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ajout.setBackground(new java.awt.Color(95, 141, 78));
			}
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	ajout.setBackground(new java.awt.Color(225, 255, 177));
		    }
//
		});
		
		

		
		ajout.setForeground(Color.BLACK);
		ajout.setBackground(new Color(225, 255, 177));
		ajout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long test=Integer.valueOf(cin.getText());
				String myString = String.valueOf(test);
				int length = myString.length();
				
				long test1=Integer.valueOf(telephone.getText());
				String myString1 = String.valueOf(test1);
				int length1 = myString1.length();
				
				if(nom.getText().isEmpty() ||prenom.getText().isEmpty() || adresse.getText().isEmpty() || sexe.getSelectedItem().toString()==""||telephone.getText()==""||cin.getText()=="") {
					JOptionPane.showMessageDialog(ajout,"remplissez tous le champs");
				}
				
				else if((length < 8)||(length > 8)) {
					
					JOptionPane.showMessageDialog(ajout,"Entrez 8 nombres dans le champ cin");
					 
				}
				else if((length1 < 8)||(length1 > 8)) {
					
					JOptionPane.showMessageDialog(ajout,"Entrez 8 nombres dans le champ telephone");
				}
				else {
					String Nom,Prenom,Adresse,Sexe;;
					long Tel,CIN;
					
					Nom=nom.getText();
					Prenom=prenom.getText();
					Adresse=adresse.getText();
					Sexe=sexe.getSelectedItem().toString();
					Tel= Integer.valueOf(telephone.getText());
					CIN=Integer.valueOf(cin.getText());
					
					String cinCherche = Long.toString(CIN);
			        boolean cinTrouve = false;
					
					 try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\logtari\\Desktop\\patient.txt"))) {
				            String ligne;
				            while ((ligne = br.readLine()) != null) {
				                if (ligne.contains(cinCherche)) {
				                    cinTrouve = true;
				                    break;
				                }
				            }
				        } catch (IOException et) {
				            System.err.println("Erreur lors de la lecture du fichier : " + et.getMessage());
				        }
				        
				        if (cinTrouve) {
				        	JOptionPane.showMessageDialog(ajout,"Ce patient est deja existé ");
				        }else {
								Patient pat = new Patient(CIN, Nom, Prenom, Sexe, length, Adresse);
								patients.add(pat);
								
								try {
							            
									
									FileWriter lu=new FileWriter("C:\\Users\\logtari\\Desktop\\patient.txt",true);
									
									BufferedWriter out =new BufferedWriter(lu);
									out.write(String.valueOf(CIN));
									out.write("/");
									out.write(Nom);
									out.write("/");
									out.write(Prenom);
									out.write("/");
									out.write(Sexe);
									out.write("/");
									out.write(String.valueOf(Tel));
									out.write("/");
									out.write(Adresse);
									lu.write("\n");
									out.close();
									JOptionPane.showMessageDialog(ajout,"Le patient a été enregistré avec succès ");
								} catch (IOException e1) {
									
									e1.printStackTrace();
								}
								
							
							}
				        }
			        
			        nom.setText("");
					prenom.setText("");
					cin.setText("");
					adresse.setText("");
					telephone.setText("");
					sexe.getEditor().setItem("");
								}
				
		});
		ajout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ajout.setBounds(20, 247, 122, 43);
		panel.add(ajout);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)tablePatient.getModel();
				File inputFile = new File("C:\\Users\\logtari\\Desktop\\patient.txt");
		        File tempFile = new File("C:\\Users\\logtari\\Desktop\\patient1.txt");
		        String lineToRemove = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+"Détartrage");
		        String lineToRemove1 = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+"Plombage");
		        String lineToRemove2 = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+"Dévitalisation dentaire");
		        String lineToRemove3 = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+"Prothèses dentaires");
		        String lineToRemove4 = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+"Extraction dentaire");
		        String lineToRemove5 = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()+"/"+"Scellement des sillons");
		        String lineToRemove7 = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText());
		        String lineToRemove6="";
		        
		        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

		        
		           
		            String currentLine;

		            boolean isFirstLine = true;
		            while ((currentLine = reader.readLine()) != null) {
		                if (!currentLine.equals(lineToRemove) && !currentLine.equals(lineToRemove1) && !currentLine.equals(lineToRemove2) &&
		                    !currentLine.equals(lineToRemove3) && !currentLine.equals(lineToRemove4) && !currentLine.equals(lineToRemove5) &&
		                    !currentLine.equals(lineToRemove7) && !currentLine.equals(lineToRemove6)) {
		                    if (!isFirstLine) {
		                        writer.write(System.getProperty("line.separator"));
		                    } else {
		                        isFirstLine = false;
		                    }
		                    writer.write(currentLine);
		                }
		            }

		            writer.close();
		            reader.close();
		            if (inputFile.delete()) {
		                tempFile.renameTo(inputFile);
		                System.out.println("La ligne a été supprimée avec succès !");
		                JOptionPane.showMessageDialog(btnSupprimer,"Le patient a été supprimé avec succès ");
		            } else {
		                System.out.println("La suppression de la ligne a échoué...");
		            }
		           
		        } catch (FileNotFoundException eb) {
		            System.out.println("Le fichier n'a pas été trouvé : " + eb.getMessage());
		        } catch (IOException ec) {
		            System.out.println("Erreur lors de la lecture ou de l'écriture du fichier : " + ec.getMessage());
		        }
				
		        model.removeRow(selectedRow);
		        nom.setText("");
				prenom.setText("");
				cin.setText("");
				adresse.setText("");
				telephone.setText("");
				sexe.getEditor().setItem("");
		        
		      
		        
			
				 	
			}
			
		});
		btnSupprimer.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\supprimer.png"));
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSupprimer.setBackground(new java.awt.Color(230, 72, 72));
			}
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnSupprimer.setBackground(new java.awt.Color(255, 237, 211));
		    }
		});
		
		btnSupprimer.setForeground(Color.BLACK);
		btnSupprimer.setBackground(new Color(255, 237, 211));
		btnSupprimer.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSupprimer.setBounds(198, 247, 128, 43);
		panel.add(btnSupprimer);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\edition.png"));
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModifier.setBackground(new java.awt.Color(8, 131,149));
			}
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	
		    	btnModifier.setBackground(new java.awt.Color(134, 229, 255));
		    }
		});
		btnModifier.setForeground(Color.BLACK);
		btnModifier.setBackground(new Color(134, 229, 255));
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String fichier = "C:\\Users\\logtari\\Desktop\\patient.txt"; 
			      String cinRecherche = Integer.valueOf(cin.getText()).toString();
			      String nouvelleLigne = (cin.getText()+"/"+nom.getText()+"/"+prenom.getText()+"/"+sexe.getSelectedItem().toString()+"/"+telephone.getText()+"/"+adresse.getText()).toString(); 
			      
			      try {
			       
			         FileInputStream fstream = new FileInputStream(fichier);
			         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			         
			    
			         StringBuffer buffer = new StringBuffer();
			         
			         String ligne;
			         
			         
			         
			         boolean isFirstLine = true;
			         ligne = nouvelleLigne;
			         while ((ligne = br.readLine()) != null) {
			           
			            if (ligne.contains(cinRecherche)) {
			               ligne = nouvelleLigne;
			               isFirstLine = false;
			            }
			            
			            if (!isFirstLine) {
			            buffer.append("\n");
			            
			            }
			            else {
			            	isFirstLine = false;
			            }
			            buffer.append(ligne);
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
			            DefaultTableModel model = (DefaultTableModel)tablePatient.getModel();
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

		            
		            tablePatient.setModel(modeleVide);
			        
			        
			        String filePathe = "C:\\Users\\logtari\\Desktop\\patient.txt";
			        File filee = new File(filePathe);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(filee));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tablePatient.getModel();
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
					sexe.getEditor().setItem("");
			      
			      
			   }
			
			

		}
			);
		btnModifier.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModifier.setBounds(372, 247, 119, 43);
		panel.add(btnModifier);
		
		
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(218, 245, 255));
		panel_2.setBounds(20, 64, 471, 172);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		adresse = new JTextField();
		adresse.setHorizontalAlignment(SwingConstants.CENTER);
		adresse.setColumns(10);
		adresse.setBounds(325, 123, 125, 20);
		panel_2.add(adresse);
		

		
			
		
		telephone = new JTextField();
		telephone.setHorizontalAlignment(SwingConstants.CENTER);
		telephone.setColumns(10);
		telephone.setBounds(325, 74, 125, 20);
		panel_2.add(telephone);
		
		cin = new JTextField();
		cin.setHorizontalAlignment(SwingConstants.CENTER);
		cin.setColumns(10);
		cin.setBounds(325, 26, 125, 20);
		panel_2.add(cin);
		
		JLabel lblNewLabel_1_3 = new JLabel("CIN:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(196, 26, 89, 14);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telephone:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(225, 74, 83, 20);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adresse :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(222, 123, 74, 14);
		panel_2.add(lblNewLabel_1_2);
		
		
		
		prenom = new JTextField();
		prenom.setHorizontalAlignment(SwingConstants.CENTER);
		prenom.setColumns(10);
		prenom.setBounds(79, 74, 125, 20);
		panel_2.add(prenom);
		
		nom = new JTextField();
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setColumns(10);
		nom.setBounds(79, 26, 125, 20);
		panel_2.add(nom);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(5, 26, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(5, 74, 64, 14);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("Sexe :");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(5, 123, 46, 14);
		panel_2.add(lblNewLabel_1_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FichePatient.super.dispose();
				SecMenu log =new SecMenu();
				log.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\retour.png"));
		btnNewButton.setBackground(new Color(218, 245, 255));
		btnNewButton.setBounds(20, 11, 42, 33);
		panel.add(btnNewButton);
		model= new DefaultTableModel(nomcolonne,0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 312, 644, 151);
		panel.add(scrollPane);
		
		tablePatient = new JTable();
		scrollPane.setViewportView(tablePatient);
		tablePatient.setModel( new DefaultTableModel(
				new Object [][] {
					
				},
				new String[] {
						"CIN","Nom","Prenom","Sexe","Telephone","Adresse"
				})
				);
		tablePatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 selectedRow=tablePatient.getSelectedRow();
				if (e.getButton()==MouseEvent.BUTTON1) {
					int indice = tablePatient.getSelectedRow();
					if(indice != -1) {
						cin.setText(model.getValueAt(indice, 0).toString());
						nom.setText(model.getValueAt(indice, 1).toString());
						prenom.setText(model.getValueAt(indice, 2).toString());
						sexe.setSelectedItem(model.getValueAt(indice, 3));
						telephone.setText(model.getValueAt(indice, 4).toString());
						adresse.setText(model.getValueAt(indice, 5).toString());
						
					
						
					}
				}else if (e.getButton()==MouseEvent.BUTTON3) {
					nom.setText("");
					prenom.setText("");
					cin.setText("");
					adresse.setText("");
					telephone.setText("");
					sexe.setSelectedItem("");
					tablePatient.clearSelection();
				}
			}
		});
		tablePatient.setModel(model);
		
		JButton btnImporter = new JButton("");
		btnImporter.setBounds(296, 463, 63, 43);
		panel.add(btnImporter);
		btnImporter.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\importer.png"));
		btnImporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String filePath = "C:\\Users\\logtari\\Desktop\\patient.txt";
			        File file = new File(filePath);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(file));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tablePatient.getModel();
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
			        
			        btnImporter.setEnabled(false);
			}
		});
		btnImporter.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnImporter.setBackground(new Color(247, 255, 147));
		
		JTableHeader header = tablePatient.getTableHeader(); 
		header.setBackground(new Color(247, 239, 229));
		
		
		
		
}
	}
