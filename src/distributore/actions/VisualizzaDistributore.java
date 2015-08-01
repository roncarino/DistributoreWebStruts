package distributore.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import distributore.bean.Colonna;
import distributore.distributore.Distributore;

public class VisualizzaDistributore extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Colonna> listaColonne;
	
	public VisualizzaDistributore() {}
	
	public List<Colonna> getListaColonne() {
		return listaColonne;
	}

	public void setListaColonne(List<Colonna> listaColonne) {
		this.listaColonne = listaColonne;
	}

	public String execute() {
		if(Distributore.getDistributore() == null) 
			Distributore.setDistributore(new Distributore());
		listaColonne = new ArrayList<Colonna>();
		listaColonne = Distributore.getDistributore().getColonne();
		return SUCCESS;
	}

}
