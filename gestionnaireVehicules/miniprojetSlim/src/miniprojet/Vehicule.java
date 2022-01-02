package miniprojet;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
 
public  class Vehicule extends ArrayList<Vehicule>{   
	
	private static final long serialVersionUID = 1L;
	protected String marque;
	protected String couleur;
	protected String type;
	protected ImageIcon photo;
	
	public Vehicule(String marqueVehicule,String couleur,String type,ImageIcon photo) {
		this.marque = marqueVehicule;
		this.couleur=couleur;
		this.type=type;
		this.photo=photo;
	}
      
	public String getMarque(){return this.marque;}
	public String getCouleur(){return this.couleur;}
	public String getType(){return this.type;}
	public ImageIcon getPhoto(){return this.photo;}
	
	public static void ajouter(String marque,String couleur,String type,String modele,ImageIcon photo)
	{
		if(FenetrePrincipale.zoneMarque.getText().equals("") || FenetrePrincipale.photoMise==0 || FenetrePrincipale.zoneMarque.getText().equals("Marque") ||  FenetrePrincipale.zoneColor.getText().equals("") || FenetrePrincipale.zoneColor.getText().equals("Couleur") ||  FenetrePrincipale.zoneModel.getText().equals("") || FenetrePrincipale.zoneModel.getText().equals("Modele")) {
			JOptionPane.showMessageDialog(null,
				    "Veuillez remplir tous les champs !",
				    "Informations manquantes",
				    JOptionPane.ERROR_MESSAGE);
		}
		else {
			if(type.equals("auto")) {
				Autos auto = new Autos(marque,couleur,modele,type,photo);
				Main.vehicules.add(auto);
				JOptionPane.showMessageDialog(null,"Le vehicule a bien ete ajoute !","Ajout d'un véhicule",JOptionPane.INFORMATION_MESSAGE, null);  
			}
			else if(type.equals("camion")) {
				Camions camion  = new Camions(marque,couleur,modele,type,photo);
				Main.vehicules.add(camion);
				JOptionPane.showMessageDialog(null,"Le vehicule a bien ete ajoute !","Ajout d'un véhicule",JOptionPane.INFORMATION_MESSAGE, null);   
			}
			else if (type.equals("moto")) {
				Motos moto  = new Motos(marque,couleur,modele,type,photo);
				Main.vehicules.add(moto);
				JOptionPane.showMessageDialog(null,"Le vehicule a bien ete ajoute !","Ajout d'un véhicule",JOptionPane.INFORMATION_MESSAGE, null);  
				}
			}
	}
		
	public static void vendre(int indice)
	{
			if(indice >= Main.vehicules.size()) {
				JOptionPane.showMessageDialog(null,"Le vehicule a vendre n'existe pas !","Vente d'un vehicule",JOptionPane.WARNING_MESSAGE, null);  
			}
			else {
				Main.vehicules.remove(indice);
				JOptionPane.showMessageDialog(null,"Le vehicule a bien ete vendu !","Vente d'un vehicule",JOptionPane.INFORMATION_MESSAGE, null); 
			}
			if(Main.vehicules.isEmpty()) {
				FenetrePrincipale.supButtons.setEnabled(false);
			}
	}
} 

