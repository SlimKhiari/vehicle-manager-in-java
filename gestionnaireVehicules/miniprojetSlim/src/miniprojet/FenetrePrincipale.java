package miniprojet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;


public class FenetrePrincipale extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static JTextField zoneDeFiltre =new JTextField("Votre couleur");
	static JTextField zoneMarque =new JTextField("Marque");
	static JTextField zoneColor =new JTextField("Couleur");
	static JTextField zoneModel =new JTextField("Modele");
	ImageIcon icone = new ImageIcon("imageVehicule.png");
	JLabel image = new JLabel(icone);
	JButton imageAjoutButton = new JButton(icone);
	ImageIcon iconeLoupe = new ImageIcon("loupe.png");
	JButton tableButton = new JButton(iconeLoupe);
	ImageIcon iconeAdd = new ImageIcon("add.png");
	JButton ajouterButton = new JButton(iconeAdd);
	ImageIcon iconeExist = new ImageIcon("exist.png");
	JButton existButton = new JButton(iconeExist);
	static ImageIcon iconeSale = new ImageIcon("carSale.png");
	static JButton supButtons = new JButton(iconeSale);
	JLabel labelinfo = new JLabel(" Les informations du vehicule a ajouter");
	JLabel labelaffich = new JLabel(" Rechercher des vehicules par couleur (ou sans)");
	JLabel labelvente = new JLabel(" Vendre un vehicule (saisir son indice)");
	JLabel labelverif = new JLabel(" Verifier l'existence d'un vehicule (Marque - Modele)");
	String[] typeVehicules = new String[] {"moto","auto","camion"};
	JComboBox<String> vehiculestypes = new JComboBox<>(typeVehicules);
	ArrayList<String> vehiculesListMarques = new ArrayList<String>();
	JComboBox<String> vehiculesMarques= new JComboBox<String>();
	ArrayList<String> vehiculesListModels = new ArrayList<String>();
	JComboBox<String> vehiculesModels= new JComboBox<String>();	
	SpinnerModel model = new SpinnerNumberModel(0, 0, 999999999, 1); 
	JSpinner zoneDesupp = new JSpinner(model);
	JSeparator separateur = new JSeparator();
	JSeparator separateurBis = new JSeparator();
	JSeparator separateurTrois = new JSeparator();
	static String marqueVehicule = " ";
	static String typeVehicule = " ";
	String marqueAchercher = " ";
	String modelAchercher = " ";
	static String couleurVehicule = " ";
	static String modeleVehicule=" ";
	static String filtre="";
	static int supp;
	JTextPane imageArea = new JTextPane();
	JFileChooser choose;
	static ImageIcon vehiculePhoto;
	private JPanel conteneur = new JPanel();
	static int photoMise=0;
	
	public FenetrePrincipale() {
		setTitle("Gestion des vehicules");
	    setResizable(false);
		setSize(472,678 );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JOptionPane.showMessageDialog(null, "Vous pouvez gérer ici vos véhicules \n 1) Le logiciel se compose de 4 parties independantes (ajout/affichage/vente/verification). \n 2) Dans la partie 3, veuillez mettre l'indice du vehicule a vendre (pour le trouver, il faut afficher les vehicules via le bouton : de la partie affichage).\n 3) Pour filtrer les vehicules selon la couleur, il suffit de saisir la couleur dans le champ de texte dans la deuxieme partie et de cliquer sur la loupe.\n     Pour voir l'ensemble des vehiules  sans filtrage, il faut enlever la couleur saisie et cliquer sur la loupe\n 4) La sauvegarde des vehicules se fait d'une maniere automatique.\n 5) les dimensions de l'image du vehicule doivent  etre egale a 150x150.\n 6) l'insertion d'une image est obligatoire.", "Bienvenue", JOptionPane.INFORMATION_MESSAGE);
		
		//Partie 1 de la fenetre (ajout)
		labelinfo.setBounds(8,5,443,50);
		labelinfo.setFont(new Font("LucidaSans", Font.BOLD, 18));
		labelinfo.setBorder( BorderFactory.createLoweredBevelBorder());
		conteneur.add(labelinfo);
		zoneMarque.setBounds(8,60,220,30);
		zoneMarque.setFont(new Font("Comic", Font.ITALIC, 15));
		zoneMarque.setBackground(Color.lightGray);
		zoneMarque.setForeground(Color.darkGray);
		conteneur.add(zoneMarque);
		vehiculestypes.setBounds(8,90,220,30);
		vehiculestypes.setFont(new Font("Comic", Font.PLAIN, 15));
		conteneur.add(vehiculestypes);
		zoneColor.setBounds(8,120,220,30);
		zoneColor.setFont(new Font("Comic", Font.ITALIC, 15));
		zoneColor.setBackground(Color.lightGray);
		zoneColor.setForeground(Color.darkGray);
		conteneur.add(zoneColor);
		zoneModel.setBounds(8,150,220,30);
		zoneModel.setFont(new Font("Comic", Font.ITALIC, 15));
		zoneModel.setBackground(Color.lightGray);
		zoneModel.setForeground(Color.darkGray);
		conteneur.add(zoneModel);
        image.setBounds(200,150, 250, 100);
        imageAjoutButton.setBounds(11,190,35,35);
        imageAjoutButton.setFont(new Font("Comic", Font.PLAIN, 15));
		conteneur.add(imageAjoutButton);
		imageArea.setBounds(270,63,150,150);
		imageArea.setFont(new Font("Comic", Font.PLAIN, 15));
		imageArea.setBorder(new LineBorder(Color.white));
		imageArea.setEditable(false);
		imageArea.setText("\n\n\n\s\sImage du vehicule");
        conteneur.add(imageArea);
    	ajouterButton.setBounds(190,190,35,35);
		ajouterButton.setBackground(Color.orange);
		ajouterButton.setFont(new Font("Comic", Font.PLAIN, 15));
		conteneur.add(ajouterButton);
		
		separateur.setBounds(0,240,1000,100);
		conteneur.add(separateur);
		
		//Partie 2 de la fenetre (affichge des vehicules + filtrage)
		labelaffich.setBounds(8,255,443,50);
		labelaffich.setFont(new Font("LucidaSans", Font.BOLD, 16));
		labelaffich.setBorder( BorderFactory.createLoweredBevelBorder() );
		conteneur.add(labelaffich);
		conteneur.add(zoneDeFiltre);
		zoneDeFiltre.setBounds(90,313,220,30);
		zoneDeFiltre.setFont(new Font("Comic", Font.ITALIC, 15));
		zoneDeFiltre.setBackground(Color.lightGray);
		zoneDeFiltre.setForeground(Color.darkGray);
		tableButton.setBounds(320,310,35,35);
		tableButton.setFont(new Font("Comic", Font.PLAIN, 15));
		conteneur.add(tableButton);
		
		separateurBis.setBounds(0,360,1000,100);
		conteneur.add(separateurBis);
		
		//Partie 3 de la fenetre  (vente des vehicules)
		labelvente.setBounds(8,375,443,50);
		labelvente.setFont(new Font("LucidaSans", Font.BOLD, 18));
		labelvente.setBorder( BorderFactory.createLoweredBevelBorder() );
		conteneur.add(labelvente);
		supButtons.setBounds(240,430,35,35);
		supButtons.setFont(new Font("Comic", Font.PLAIN, 15));
		conteneur.add(supButtons);
		zoneDesupp.setBounds(160,430,70,30);
		zoneDesupp.setFont(new Font("Comic", Font.ITALIC, 15));
		zoneDesupp.setBackground(Color.GRAY);
		conteneur.add(zoneDesupp);
	
		separateurTrois.setBounds(0,480,1000,100);
		conteneur.add(separateurTrois);
		
		//partie 4 (verifiaction de l'exisatnce d un vehicule
		Main.vehicules = Sauvegarder.charger(Main.fichierVehicules,Main.vehicules);
		//mise en place de mes combobox
		for(int i=0; i<Main.vehicules.size();i++)
		{
			vehiculesListMarques.add(Main.vehicules.get(i).getMarque());
			vehiculesMarques.addItem(Main.vehicules.get(i).getMarque());
			if(Main.vehicules.get(i).getType().equals("auto")) {
				vehiculesListModels.add(((Autos) Main.vehicules.get(i)).getModel());
				vehiculesModels.addItem(((Autos) Main.vehicules.get(i)).getModel());			}
			else if(Main.vehicules.get(i).getType().equals("moto")) {
				vehiculesListModels.add(((Motos) Main.vehicules.get(i)).getModel());
				vehiculesModels.addItem(((Motos) Main.vehicules.get(i)).getModel());			}
			else if(Main.vehicules.get(i).getType().equals("camion")) {
				vehiculesListModels.add(((Camions) Main.vehicules.get(i)).getModel());
				vehiculesModels.addItem(((Camions) Main.vehicules.get(i)).getModel());			}
		}
		labelverif.setBounds(8,495,443,50);
		labelverif.setFont(new Font("LucidaSans", Font.BOLD, 16));
		labelverif.setBorder( BorderFactory.createLoweredBevelBorder() );
		conteneur.add(labelverif);
		vehiculesMarques.setBounds(8,550,200,30);
		conteneur.add(vehiculesMarques);
		vehiculesModels.setBounds(250,550,200,30);
		conteneur.add(vehiculesModels);
		existButton.setBounds(210,595,35,35);
		existButton.setBackground(Color.lightGray);
		existButton.setFont(new Font("Comic", Font.PLAIN, 15));
	    conteneur.add(existButton);
		
		//Configuration des différents boutons de la fenetre
		if(Main.vehicules.isEmpty()) { // Je bloque le bouton si la liste vehicule est vide
			supButtons.setEnabled(false);
		}
		imageAjoutButton.addActionListener(this::ajouterimagevehicule); // bouton pour ajouter une image du vehicule (l'image du vehicule n est pas obligatoire)
		ajouterButton.addActionListener(this::ajouterButtonListener); // bouton pour ajouter les caracteristiques du vehicule
		supButtons.addActionListener(this::deleteButtonListener); // bouton pour vendre un vehicule (un vehicule vendu = un vehicule supprime de la liste des vehicules)
		tableButton.addActionListener(this::tableButtonListener); // bouton pour afficher la table de mes vehicules non vendus
		existButton.addActionListener(this::existvehicule); // bouton pour savoir si une marque + modele existent dans la liste des vehicules
	
		setContentPane(conteneur);
		setLayout(null);
	}	
	
	private void existvehicule (ActionEvent event) {
		marqueAchercher= (String) vehiculesMarques.getSelectedItem();
		modelAchercher = (String) vehiculesModels.getSelectedItem();
		int trouve=0;
		for(int i=0; i <Main.vehicules.size();i++) {
			if( Main.vehicules.get(i).getType().equals("auto") && Main.vehicules.get(i).getMarque().equals(marqueAchercher) && ((Autos) Main.vehicules.get(i)).getModel().equals(modelAchercher)) {
					trouve=1;
					break;
					
			}
			else if( Main.vehicules.get(i).getType().equals("camion") && Main.vehicules.get(i).getMarque().equals(marqueAchercher) && ((Camions) Main.vehicules.get(i)).getModel().equals(modelAchercher)) {
					trouve=1;
					break;
			}
			else if( Main.vehicules.get(i).getType().equals("moto") && Main.vehicules.get(i).getMarque().equals(marqueAchercher) && ((Motos) Main.vehicules.get(i)).getModel().equals(modelAchercher)) {
					trouve=1;
					break;
			}
			else {
					trouve=0;
				}
		}
		if(trouve == 1) {
			JOptionPane.showMessageDialog(null,marqueAchercher + " " +  modelAchercher +" existe.", "Verification de l'existence d'un vehicule", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null,marqueAchercher + " " +  modelAchercher +" n'existe pas.", "Verification de l'existence d'un vehicule", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	private void ajouterimagevehicule (ActionEvent event) {
		imageArea.setText("");
		choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int res = choose.showOpenDialog(null);
		if (res == JFileChooser.APPROVE_OPTION) {
		      File file = choose.getSelectedFile();
		      vehiculePhoto = new ImageIcon(file.getAbsolutePath());
		      if(vehiculePhoto.getIconWidth() > 150 || vehiculePhoto.getIconWidth() > 150) {
		    	  JOptionPane.showMessageDialog(null,"Les dimensions de l'image doivent etre inferieur a 150x150. ", "Image trop grande", JOptionPane.ERROR_MESSAGE);
		      }
		      if(vehiculePhoto.getIconWidth() < 150 || vehiculePhoto.getIconWidth() < 150) {
		    	  JOptionPane.showMessageDialog(null,"Les dimensions de l'image doivent etre inferieur a 150x150. ", "Image trop petite", JOptionPane.ERROR_MESSAGE);
		      }
		      else { imageArea.insertIcon(vehiculePhoto);  photoMise=1;}
		 }
	}
	
	private void ajouterButtonListener (ActionEvent event) {
		Main.setBloqueAjout(1);
		marqueVehicule = zoneMarque.getText();
		typeVehicule = (String) vehiculestypes.getSelectedItem();
		couleurVehicule = zoneColor.getText();
		modeleVehicule = zoneModel.getText();
		supButtons.setEnabled(true);
		vehiculesMarques.addItem(marqueVehicule);
		vehiculesModels.addItem(modeleVehicule);
	}
		
	private void deleteButtonListener (ActionEvent event) {
		Main.setBloqueVente(1);
		supp = (int) zoneDesupp.getValue();
		vehiculesMarques.removeItem(supp);
		vehiculesModels.removeItem(supp);
	}
	
	private void tableButtonListener (ActionEvent event) {
		  new TableauGraphique().setVisible(true);
	}
	
}
