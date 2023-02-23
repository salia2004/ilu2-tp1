package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbEtals;

	public Village(String nom, int nbVillageoisMaximum,int nbetals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.nbEtals=nbetals;}
	
	private Marchee marche=new Marchee(nbEtals);

	public String getNom() {
		return nom;}

	public void setChef(Chef chef) {
		this.chef = chef;}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;}
		}
		return null;}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
			System.out.println("la");}
		else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");}
		}
		return chaine.toString();
		}
	
	
	private static class Marchee{
		private Etal[] etals;

		private Marchee(int nbetals)
		{
			etals=new Etal[nbetals];}
		
		private void utiliserEtal(int indiceEtal,Gaulois vendeur,String produit,int nbProduit){
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);}
		
		private int trouverEtalLibre(){
			int indice=-1;
			for(int i=0;i < etals.length;i++)
			{
				if (!etals[i].isEtalOccupe()) {
					indice=i;
					break;}
			}
			return indice;}
		
		private Etal[] trouverEtals(String produit) {
			int curs=0;
			for(int i=0;i<etals.length;i++)
			{
				if (etals[i].isEtalOccupe()&& etals[i].contientProduit(produit))
					curs += 1;
			}
			Etal[] tableau= new Etal[curs];
			
			for (int j=0;j<tableau.length;j++)
				if (etals[j].contientProduit(produit))
				{
					tableau[j]=etals[j];
				}
			return tableau;}
			//return tableau;//system.arraycopy()}
		
	private Etal trouverVendeur(Gaulois gaulois) {
		Etal etalGaulois = null;
		for (int i = 0; i < etals.length && etalGaulois == null; i++) {
			if (etals[i].getVendeur().getNom().equals(gaulois.getNom())) {
				etalGaulois = etals[i];
			}
		}
		return etalGaulois;}
		
		private String afficherMarche(){
			int nbetalvide=0;
			for(int i=0;i<etals.length;i++)
				if(etals[i].isEtalOccupe())
				{
					etals[i].afficherEtal();
				}
				else
				{
					nbetalvide++;}
			
			return "Il reste " + nbetalvide + " étals non utilisés dans le marché.\n";}
		
	}
	
	
	//////fin classe interne
	
	public String installerVendeur(Gaulois vendeur, String produit,int nbProduit)
	{
		StringBuilder chaine = new StringBuilder();
		
		Etal etalvendeur= new Etal();
		if (marche.trouverEtalLibre()!=-1)
		{
			etalvendeur=marche.etals[marche.trouverEtalLibre()];
			etalvendeur.occuperEtal(vendeur, produit, nbProduit);
			chaine.append(vendeur.getNom()+"cherche un endroit pour vendre"+nbProduit+produit+".\n"+"le vendeur"+vendeur.getNom()+"vend des "+produit+"à l'étal n"+marche.trouverEtalLibre());
			}
		return chaine.toString();}
	
	public String rechercherVendeursProduit(String produit) {
		StringBuilder chaine = new StringBuilder();
		Etal[] tabEtal=marche.trouverEtals(produit);
		chaine.append("les vendeurs qui proposent des "+produit+ " sont:\n");
		for(int i=0;i<tabEtal.length;i++){
			chaine.append("-"+ tabEtal[i].getVendeur().getNom()+"\n");}
		
		return chaine.toString();}
	
	public Etal rechercherEtalVendeur(Gaulois vendeur) {
		return marche.trouverVendeur(vendeur);
		
	}
	
	public String partirVendeur(Gaulois vendeur) {
		StringBuilder chaine = new StringBuilder();
		Etal etalVendeur=rechercherEtalVendeur(vendeur);
		chaine.append(etalVendeur.libererEtal());
		return chaine.toString();
	}
	
	public String afficherMarche() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("le marche du village"+nom+"possède plusieurs étals:"+marche.afficherMarche());
		return chaine.toString();
	}
	
	
	
	
	
	
}