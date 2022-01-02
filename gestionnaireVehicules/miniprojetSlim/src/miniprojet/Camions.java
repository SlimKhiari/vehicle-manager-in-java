package miniprojet;

import javax.swing.ImageIcon;

public class Camions extends Vehicule{
	private static final long serialVersionUID = 1L;
	protected String modele;
	protected String typeVehicule;
	
	public Camions(String marque, String couleur, String modele,String type,ImageIcon photo) {
		super(marque, couleur,type,photo);
		this.modele=modele;
	}
	
	public String getModel(){return this.modele;}

}
