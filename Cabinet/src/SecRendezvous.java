import java.awt.EventQueue;
import java.io.RandomAccessFile;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
public class SecRendezvous extends JFrame {

	int selectedRow;
	
	private ArrayList<Rendezvous> rdv;
	private DefaultTableModel model;
	
	
	private JPanel contentPane;
	private JTextField email;
	private JTable tablerdv;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecRendezvous frame = new SecRendezvous();
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
	public SecRendezvous() {
		
		
		
		

		String [] nomcolonne = {"Patient","Date","Heure","Email"};
		rdv=new ArrayList<>();
		 DefaultTableModel model = new DefaultTableModel();
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
		
		JLabel lblRendezVous = new JLabel("Rendez Vous");
		lblRendezVous.setBackground(new Color(132, 169, 217));
		lblRendezVous.setHorizontalAlignment(SwingConstants.CENTER);
		lblRendezVous.setFont(new Font("SimSun", Font.BOLD, 25));
		lblRendezVous.setBounds(0, 0, 687, 56);
		panel.add(lblRendezVous);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(218, 245, 255));
		panel_1.setBounds(519, 66, 158, 221);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setForeground(new Color(0, 0, 0));
		panel_2.setBackground(new Color(218, 245, 255));
		panel_2.setBounds(24, 66, 479, 157);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		
		JComboBox patient = new JComboBox();
		patient.setModel(new DefaultComboBoxModel(new String[] {""}));
	
		patient.setEditable(true);
		patient.setBounds(96, 25, 125, 22);
		panel_2.add(patient);
		
		
		String nomFichier = "C:\\Users\\logtari\\Desktop\\patient.txt";
		 ArrayList<Patient> patientss = new ArrayList<>(); 
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
            while ((ligne = br.readLine()) != null) {
            	if(ligne.length()==0){
            		
            	}
            	else {
            		 String[] champs = ligne.split("/");
                     String cin = champs[0];
                     String nom = champs[1];
                     String prenom = champs[2];
                     String sex = champs[3];
                     String tel = champs[4]; 
                     String adresse = champs[5];
                     Patient ele = new Patient(Long.parseLong(cin),nom,prenom,sex,Integer.parseInt(tel),adresse);
                     patientss.add(ele); 

            	}
                               
               
                
         
            }
        } catch (IOException e) {
            System.err.format("Erreur de lecture du fichier: %s%n", e);
        }
        
        Patient[] tableauEtudiants = patientss.toArray(new Patient[0]);
       
        String nomprenom;
        for(int i=0;i<tableauEtudiants.length;i++) {
        	 nomprenom=tableauEtudiants[i].getNom()+" "+tableauEtudiants[i].getPrenom();
        	 if (nomprenom.length()>1) {
        		 patient.addItem(nomprenom);
        	 }
        	 else {
        		System.out.println("error");
        	 }
        	
        }

		
		
	
		
		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.CENTER);
		email.setColumns(10);
		email.setBounds(332, 25, 125, 20);
		panel_2.add(email);
	
		
		JComboBox heure = new JComboBox();
		heure.setModel(new DefaultComboBoxModel(new String[] {"", "8h", "8:30h", "9h", "9:30h", "10h", "10:30h", "11h", "13h", "13:30h", "14h", "14:30h", "15h", "15:30h", "16h"}));
		heure.setEditable(true);
		heure.setBounds(332, 91, 125, 22);
		panel_2.add(heure);
		
		JButton btnSupprimerRendezvous = new JButton("Supprimer");
		
		btnSupprimerRendezvous.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\supprimer.png"));
		btnSupprimerRendezvous.setForeground(Color.BLACK);
		btnSupprimerRendezvous.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSupprimerRendezvous.setBackground(new Color(255, 237, 211));
		btnSupprimerRendezvous.setBounds(12, 96, 132, 43);
		panel_1.add(btnSupprimerRendezvous);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				
				 String fichier = "C:\\Users\\logtari\\Desktop\\rendezvous.txt"; 
			      String patRecherche = patient.getSelectedItem().toString();
			      String nouvelleLigne = (patient.getSelectedItem().toString()+"/"+date.getText()+"/"+heure.getSelectedItem().toString()+"/"+email.getText());
		
			      try {
			       
			         FileInputStream fstream = new FileInputStream(fichier);
			         BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			         
			    
			         StringBuffer buffer = new StringBuffer();
			         
			         String ligne;
			         boolean isFirstLine = true;
			         ligne = nouvelleLigne;
			         while ((ligne = br.readLine()) != null) {
			           
			            if (ligne.contains(patRecherche)) {
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
			      
			      String filePath = "C:\\Users\\logtari\\Desktop\\rendezvous.txt";
			        File file = new File(filePath);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(file));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tablerdv.getModel();
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

		            
		            tablerdv.setModel(modeleVide);
			        
			        
			        String filePathe = "C:\\Users\\logtari\\Desktop\\rendezvous.txt";
			        File filee = new File(filePathe);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(filee));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tablerdv.getModel();
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
			        
			        patient.setSelectedIndex(0);;
					date.setText("");
					heure.setSelectedIndex(0);
					email.setText("");

			      
			}
		});
		btnModifier.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\edition.png"));
		btnModifier.setForeground(Color.BLACK);
		btnModifier.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnModifier.setBackground(new Color(134, 229, 255));
		btnModifier.setBounds(13, 25, 130, 43);
		panel_1.add(btnModifier);
		
		JButton btnImporter = new JButton("Importer");
		btnImporter.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\importer.png"));
		btnImporter.setBounds(14, 167, 130, 43);
		panel_1.add(btnImporter);
		btnImporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String filePath = "C:\\Users\\logtari\\Desktop\\rendezvous.txt";
			        File file = new File(filePath);
			        
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(file));
			          
			            String firstLine = br.readLine().trim();
			            String[] columnsName = firstLine.split(",");
			            DefaultTableModel model = (DefaultTableModel)tablerdv.getModel();
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
		btnImporter.setBackground(new Color(251, 235, 180));
		
		
		
		JLabel lblNewLabel_1_5 = new JLabel("Patient :");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(10, 29, 76, 14);
		panel_2.add(lblNewLabel_1_5);
		
		
		
		
	
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(258, 25, 64, 14);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel heurep = new JLabel("Heure :");
		heurep.setHorizontalAlignment(SwingConstants.CENTER);
		heurep.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		heurep.setBounds(258, 92, 64, 14);
		panel_2.add(heurep);
		
	
	
		
		JLabel datep = new JLabel("Date :");
		datep.setHorizontalAlignment(SwingConstants.CENTER);
		datep.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		datep.setBounds(22, 92, 46, 14);
		panel_2.add(datep);
		
		date = new JTextField();
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setColumns(10);
		date.setBounds(96, 93, 125, 20);
		panel_2.add(date);
		
		
		
	
		btnSupprimerRendezvous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int ligneSelectionnee = tablerdv.getSelectedRow();

	            if (ligneSelectionnee != -1) {
	            	tablerdv.setSelectionBackground(Color.RED);
	                Timer timer = new Timer(2000, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                    	
	                    	DefaultTableModel model = (DefaultTableModel)tablerdv.getModel();
	        				File inputFile = new File("C:\\Users\\logtari\\Desktop\\rendezvous.txt");
	        		        File tempFile = new File("C:\\Users\\logtari\\Desktop\\rendezvous1.txt");
	        		        String lineToRemove = (patient.getSelectedItem().toString()+"/"+date.getText()+"/"+heure.getSelectedItem().toString()+"/"+email.getText());
	        		       
	        		        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        		             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

	        		        
	        		           
	        		            String currentLine;

	        		            
	        		            boolean isFirstLine = true;
	        		            while ((currentLine = reader.readLine()) != null) {
	        		                if (!currentLine.equals(lineToRemove)) {
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
	        		            } else {
	        		                System.out.println("La suppression de la ligne a échoué...");
	        		            }
	        		           
	        		        } catch (FileNotFoundException eb) {
	        		            System.out.println("Le fichier n'a pas été trouvé : " + eb.getMessage());
	        		        } catch (IOException ec) {
	        		            System.out.println("Erreur lors de la lecture ou de l'écriture du fichier : " + ec.getMessage());
	        		        }
	        				
	        		        model.removeRow(selectedRow);
	        		        patient.setSelectedIndex(0);
	        		        date.setText("");
	        				email.setText("");
	        				heure.setSelectedIndex(0);

	                    	
	                       
	                    }
	                });
	                timer.start();
	                Timer annulationTimer = new Timer(3000, new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                    	tablerdv.setSelectionBackground(Color.white);
	                        timer.stop();
	                    }
	                });
	                annulationTimer.start();
	            }
				
			
				
		        
			}
		});
		
		JButton ajout = new JButton("Ajouter");
		ajout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(patient.getSelectedItem().toString()=="" ||date.getText().isEmpty() || heure.getSelectedItem().toString()=="" ||email.getText()=="") {
					JOptionPane.showMessageDialog(ajout,"remplissez tous le champs");
				}
				
				else {
					String Patient,Date,Heure,Email;
		
					
					Patient=patient.getSelectedItem().toString();
					Date=date.getText();
					Heure=heure.getSelectedItem().toString();
					Email=email.getText();

						Rendezvous rendez=new Rendezvous(Patient, Date, Heure, Email);
						rdv.add(rendez);
						try {
							FileWriter lu=new FileWriter("C:\\Users\\logtari\\Desktop\\rendezvous.txt",true);
							
							BufferedWriter out =new BufferedWriter(lu);
							
							out.write(Patient);
							out.write("/");
							out.write(Date);
							out.write("/");
							out.write(Heure);
							out.write("/");
							out.write(Email);
							lu.write("\n");
							out.close();
							
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						
					
					}
					patient.getEditor().setItem("");
					date.setText("");
					heure.getEditor().setItem("");
					email.setText("");
					 JOptionPane.showMessageDialog(ajout,"RendezVous Enregistrer");
					
								}
			
		});
		ajout.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\ajouter.png"));
		ajout.setForeground(Color.BLACK);
		ajout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		ajout.setBackground(new Color(225, 255, 177));
		ajout.setBounds(114, 249, 111, 43);
		panel.add(ajout);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SecRendezvous.super.dispose();
				SecMenu log =new SecMenu();
				log.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\retour.png"));
		btnNewButton.setBackground(new Color(218, 245, 255));
		btnNewButton.setBounds(25, 11, 42, 33);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 312, 653, 151);
		panel.add(scrollPane);
		
		tablerdv = new JTable();
		scrollPane.setViewportView(tablerdv);
		tablerdv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)tablerdv.getModel();
				 selectedRow=tablerdv.getSelectedRow();
					if (e.getButton()==MouseEvent.BUTTON1) {
						int indice = tablerdv.getSelectedRow();
						if(indice != -1) {
							patient.setSelectedItem(model.getValueAt(indice, 0));
							date.setText(model.getValueAt(indice, 1).toString());
							heure.setSelectedItem(model.getValueAt(indice, 2));
							email.setText(model.getValueAt(indice, 3).toString());
						
							
						
							
						}
					}else if (e.getButton()==MouseEvent.BUTTON3) {
						patient.getEditor().setItem("");
						date.setText("");
						heure.getEditor().setItem("");
						email.setText("");
					}
			}
		});
		tablerdv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient", "Date", "Heure", "Email"
			}
		));
		tablerdv.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		
		JButton annuler = new JButton("Annuler");
		annuler.setBounds(286, 249, 128, 43);
		panel.add(annuler);
		annuler.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\annuler.png"));
		annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				email.setText("");
				heure.setSelectedIndex(0);
				patient.setSelectedIndex(0);
 		        date.setText("");
 				email.setText("");
	            }
			

		            
			
			});
		JTableHeader header = tablerdv.getTableHeader(); 
		header.setBackground(new Color(247, 239, 229));
		
		annuler.setBackground(new Color(255, 255, 255));
		annuler.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\logtari\\Downloads\\image-removebg-preview (11).png"));
		lblNewLabel.setBounds(557, 11, 104, 124);
		panel.add(lblNewLabel);
	}
}
