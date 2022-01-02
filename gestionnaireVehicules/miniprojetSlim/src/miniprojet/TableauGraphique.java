package miniprojet;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableauGraphique extends JFrame{
	
	private static final long serialVersionUID = 6536086750067972760L;
	String header[] = {"Indice","Marque","Modele","Couleur","Type","Image"};
	DefaultTableModel model = new DefaultTableModel(header, 0);
	
    public TableauGraphique() {
    	
        this.setSize(1000,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Mes véhicules");
        
        JTable table = new JTable( model )
        {          
			private static final long serialVersionUID = 1L;
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int colonne)
            {
                return getValueAt(0, colonne).getClass();
            }
        };
        table.setEnabled(false);
        table.setBackground(Color.black);
        table.setForeground(Color.white);
        table.setRowHeight(150);
        
       String filtre = FenetrePrincipale.zoneDeFiltre.getText();
        
        // Affichage de mes vehicules sans filtrage
        if(filtre.equals("Votre couleur") || filtre.equals("")) {
        	for(int i = 0; i<Main.vehicules.size();i++) {
	        	if(Main.vehicules.get(i).getType().equals("auto")) {
	        		model.addRow( new Object[]{i,Main.vehicules.get(i).getMarque(),((Autos) Main.vehicules.get(i)).getModel(),Main.vehicules.get(i).getCouleur(),Main.vehicules.get(i).getType(), Main.vehicules.get(i).getPhoto() });
				}
				else if(Main.vehicules.get(i).getType().equals("moto")) {
					model.addRow( new Object[]{i,Main.vehicules.get(i).getMarque(),((Motos) Main.vehicules.get(i)).getModel(),Main.vehicules.get(i).getCouleur(),Main.vehicules.get(i).getType(), Main.vehicules.get(i).getPhoto() });
				}
				else if(Main.vehicules.get(i).getType().equals("camion")) {
					model.addRow( new Object[]{i,Main.vehicules.get(i).getMarque(),((Camions) Main.vehicules.get(i)).getModel(),Main.vehicules.get(i).getCouleur(),Main.vehicules.get(i).getType(), Main.vehicules.get(i).getPhoto()});
				}
        	}
        }
        //Affichage de mes vehicules avec filtrage
        else if(!filtre.equals("Votre couleur")) {
    		for (int j=0; j<Main.vehicules.size();j++)
    		{	
    			if(filtre.equals(Main.vehicules.get(j).getCouleur())) {
    				if(Main.vehicules.get(j).getType().equals("auto")) {
    	        		model.addRow( new Object[]{j,Main.vehicules.get(j).getMarque(),((Autos) Main.vehicules.get(j)).getModel(),Main.vehicules.get(j).getCouleur(),Main.vehicules.get(j).getType(), Main.vehicules.get(j).getPhoto() });
    				}
    				else if(Main.vehicules.get(j).getType().equals("moto")) {
    					model.addRow( new Object[]{j,Main.vehicules.get(j).getMarque(),((Motos) Main.vehicules.get(j)).getModel(),Main.vehicules.get(j).getCouleur(),Main.vehicules.get(j).getType(),  Main.vehicules.get(j).getPhoto() });
    				}
    				else if(Main.vehicules.get(j).getType().equals("camion")) {
    					model.addRow( new Object[]{j,Main.vehicules.get(j).getMarque(),((Camions) Main.vehicules.get(j)).getModel(),Main.vehicules.get(j).getCouleur(),Main.vehicules.get(j).getType(),Main.vehicules.get(j).getPhoto()});
    				}
    			}
    		}
    	}      
       this.getContentPane().add(new JScrollPane(table));
    }
}