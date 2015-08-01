package distributore.actions;

import com.opensymphony.xwork2.ActionSupport;

import distributore.distributore.Distributore;

public class EffettuaErogazione extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String codiceBevanda;
	private String codiceTessera;
	private int numColonna;
	private boolean valido;
	
	public EffettuaErogazione() {
		super();
	}
	
	public int getNumColonna() {
		return numColonna;
	}

	public void setNumColonna(int numColonna) {
		this.numColonna = numColonna;
	}

	public String getCodiceBevanda() {
		return codiceBevanda;
	}

	public void setCodiceBevanda(String codiceBevanda) {
		this.codiceBevanda = codiceBevanda;
	}

	public String getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(String codiceTessera) {
		this.codiceTessera = codiceTessera;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}
	
	public String execute() {
		valido = true;
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		if(valido)
			numColonna = Distributore.getDistributore().eroga(codiceBevanda, Integer.parseInt(codiceTessera));
		return SUCCESS;
	}
	
	public void validate() {
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		
		if(getFieldErrors().get("codiceTessera") == null)
			try {
				Integer.parseInt(codiceTessera);
			} catch (NumberFormatException e) {
				addFieldError("codiceTessera", getText("restrizione.inserireNumero"));
				valido = false;
			}
		
		if(getFieldErrors().get("codiceTessera") == null)
		if(Distributore.getDistributore().getTesseraFromCodice(Integer.parseInt(codiceTessera)) == null) {
			addFieldError("codiceTessera", getText("restrizione.codiceTesseraInesistente"));
			valido = false;
		}
		
		if(getFieldErrors().get("codiceBevanda") == null)		
		if(Distributore.getDistributore().getBevandaFromCodice(codiceBevanda) == null) {
			addFieldError("codiceBevanda", getText("restrizione.codiceBevandaInesistente"));
			valido = false;
		}
	}

}
