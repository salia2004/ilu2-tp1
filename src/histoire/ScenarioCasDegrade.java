package histoire;


import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;


public class ScenarioCasDegrade {

	public static void main(String[] args) {
		
//		System.out.println("hey");
		
		Etal etal = new Etal(); 
		etal.libererEtal(); 
		
		etal.acheterProduit(0, null);
		System.out.println("hey");
		etal.acheterProduit(-1, null);

	}

}
