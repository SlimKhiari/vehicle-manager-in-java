package miniprojet;

import java.io.File;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
	
	static int estAjout=0;
	static int estVente=0;
	public static void setBloqueAjout(int b) { estAjout = b; }
	public static int getBloqueAjout() { return estAjout; }
	public static void setBloqueVente(int b) { estVente = b; }
	public static int getBloqueVente() { return estVente; }
	
	
	static ArrayList<Vehicule> vehicules = new ArrayList<>();
	static File fichierVehicules = new File("vehicules.dat");
	
	  public static void main(String[] args) throws UnsupportedLookAndFeelException {
		  UIManager.setLookAndFeel(new NimbusLookAndFeel());
		  FenetrePrincipale fenetreAccueil = new FenetrePrincipale();
		  fenetreAccueil.setVisible(true); 
		  
		  vehicules = Sauvegarder.charger(fichierVehicules,vehicules);
		  
		  while(1>0) {
			  estAjout = getBloqueAjout();
			  estVente = getBloqueVente();
			  
			  while(estAjout==0 && estVente==0) {System.out.print("");}
			  
			  estAjout = getBloqueAjout();
			  estVente = getBloqueVente();
			  
			  //Dans le cas ou l utilisateur a ajouté un vehicule
			  if(estAjout == 1) {
				  Vehicule.ajouter(FenetrePrincipale.marqueVehicule,FenetrePrincipale.couleurVehicule,FenetrePrincipale.typeVehicule,FenetrePrincipale.modeleVehicule,FenetrePrincipale.vehiculePhoto);
				  setBloqueAjout(0);
			  	}
			  //Dans le cas ou l utilisateur a vendu un vehicule
			  else if(estVente == 1) {
				  Vehicule.vendre(FenetrePrincipale.supp);				  
				  setBloqueVente(0);
			  	}
			  Sauvegarder.enregistrer(Main.vehicules,fichierVehicules);
			  }
		  
	  }
}
