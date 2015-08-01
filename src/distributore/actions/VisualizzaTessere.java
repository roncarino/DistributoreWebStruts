package distributore.actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import distributore.bean.Tessera;
import distributore.distributore.Distributore;

public class VisualizzaTessere extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Tessera> listaTessera;
	
	public VisualizzaTessere() {}

	public List<Tessera> getListaTessera() {
		return listaTessera;
	}

	public void setListaTessera(List<Tessera> listaTessera) {
		this.listaTessera = listaTessera;
	}
	
	public String execute() {
		if(Distributore.getDistributore() == null) 
			Distributore.setDistributore(new Distributore());
		listaTessera = new ArrayList<Tessera>();
		listaTessera = Distributore.getDistributore().getTessere();
		return SUCCESS;
	}

}
