package distributore.distributore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import distributore.bean.Bevanda;
import distributore.bean.Colonna;
import distributore.bean.Tessera;

public class Distributore {
	private static Distributore distributore = null;
	private List<Bevanda> bevandeDisponibili;
	private List<Colonna> colonne;
	private List<Tessera> tessere;

	public Distributore() {
		this.bevandeDisponibili = new ArrayList<Bevanda>();
		this.colonne = new ArrayList<Colonna>();
		this.tessere = new ArrayList<Tessera>();
		distributore = this;
		int i;
		for (i=0; i<4; i++)
			colonne.add(null);
	}
	
	public static Distributore getDistributore() {
		return distributore;
	}

	public static void setDistributore(Distributore distributore) {
		Distributore.distributore = distributore;
	}
	
	public List<Bevanda> getBevandeDisponibili() {
		return bevandeDisponibili;
	}
	
	public void setBevandeDisponibili(List<Bevanda> bevandeDisponibili) {
		this.bevandeDisponibili = bevandeDisponibili;
	}
	
	public List<Tessera> getTessere() {
		return tessere;
	}
	
	public List<Colonna> getColonne() {
		return colonne;
	}
		
	public void setTessere(List<Tessera> tessere) {
		this.tessere = tessere;
	}

	public void setColonne(List<Colonna> colonne) {
		this.colonne = colonne;
	}

	public int lattineDisponibili(String codiceBevanda) {
		Colonna c = new Colonna();
		int numLattine = 0;
		Iterator<Colonna> it = colonne.iterator();
		while (it.hasNext()) {
			c = it.next();
			if (c != null && c.getBevanda().getCodice().equals(codiceBevanda))
				numLattine += c.getNumLattine();
		}
		return numLattine;
	}

	public void aggiungiBevanda(Bevanda bevanda) {
		if (bevandeDisponibili.contains(bevanda))
			System.out.println("Bevanda già inserita");
		else {
			bevandeDisponibili.add(bevanda);
			System.out.println("Bevanda " + bevanda.getName() + " inserita");
		}
	}

	public void aggiungiTessera(Tessera tessera) {
		if (tessere.contains(tessera))
			System.out.println("Tessera già inserita");
		else {
			tessere.add(tessera);
			System.out.println("Tessera " + tessera.getCodice() + " inserita");
		}
	}

	public void aggiornaColonna(int numColonna, Bevanda bevanda, int numLattine) {
		try {
			colonne.remove(numColonna - 1);
		} catch (IndexOutOfBoundsException e) {
		}
		colonne.add(numColonna - 1, new Colonna(bevanda, numLattine));
		System.out.println("Colonna " + numColonna + " aggiornata");
	}

	public int eroga(String codiceBevanda, int codiceTessera) {
		Bevanda bevanda = getBevandaFromCodice(codiceBevanda);
		Tessera tessera = getTesseraFromCodice(codiceTessera);
		if (tessera.getCredito() < bevanda.getPrezzo()) {
			System.out.println("Credito nella tessera non sufficiente");
			return -2;
		}

		Iterator<Colonna> it = colonne.iterator();
		boolean bevandaPresente = false;
		Colonna c;
		int numColonna;
		while (it.hasNext() && !bevandaPresente) {
			c = it.next();
			if (c != null && c.getBevanda().equals(bevanda) && c.getNumLattine() > 0) {
				bevandaPresente = true;
				c.setNumLattine(c.getNumLattine() - 1);
				tessera.setCredito(tessera.getCredito()
						- c.getBevanda().getPrezzo());
				numColonna = colonne.indexOf(c) + 1;
				System.out.println("Bevanda erogata dalla colonna "
						+ numColonna);
				return numColonna;
			}
		}
		System.out.println("La bevanda richiesta non è presente nel distributore");
		return -1;
	}

	public Bevanda getBevandaFromCodice(String codiceBevanda) {
		Iterator<Bevanda> it = bevandeDisponibili.iterator();
		Bevanda bevanda = new Bevanda();

		while (it.hasNext()) {
			bevanda = it.next();
			if (bevanda.getCodice().equals(codiceBevanda))
				return bevanda;
		}
		return null;
	}

	public Tessera getTesseraFromCodice(int codiceTessera) {
		Iterator<Tessera> it = tessere.iterator();
		Tessera tessera = new Tessera();
		while (it.hasNext()) {
			tessera = it.next();
			if (tessera.getCodice() == codiceTessera)
				return tessera;
		}
		return null;
	}

}
