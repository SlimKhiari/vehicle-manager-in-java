package miniprojet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Sauvegarder {

	public static void enregistrer(ArrayList<Vehicule> liste,File fichier) {
		try {
			FileOutputStream fo = new FileOutputStream(fichier);
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(liste);
			oo.close();
			fo.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Vehicule> charger(File fichier,ArrayList<Vehicule> vehicules) {
		try {
			FileInputStream fi = new FileInputStream(fichier);
			ObjectInputStream oi = new ObjectInputStream(fi);
			vehicules = (ArrayList<Vehicule>) oi.readObject();
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			try {
				fichier.createNewFile();
				enregistrer(vehicules,fichier);
			} catch (IOException ee) {
				System.exit(0);
			}
		} catch (IOException | ClassNotFoundException e) {
			System.exit(0);
		}
		return vehicules;
	}

}
