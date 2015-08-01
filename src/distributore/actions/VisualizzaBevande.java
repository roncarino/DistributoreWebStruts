package distributore.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import distributore.bean.Bevanda;
import distributore.distributore.Distributore;

public class VisualizzaBevande extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private List<Bevanda> listaBevande;
	
	public VisualizzaBevande() {}
	
	public List<Bevanda> getListaBevande() {
		return listaBevande;
	}

	public void setListaBevande(List<Bevanda> listaBevande) {
		this.listaBevande = listaBevande;
	}

	public String execute() {
		if(Distributore.getDistributore() == null) 
			Distributore.setDistributore(new Distributore());
		listaBevande = new ArrayList<Bevanda>();
		listaBevande = Distributore.getDistributore().getBevandeDisponibili();
		return SUCCESS;
	}
}
