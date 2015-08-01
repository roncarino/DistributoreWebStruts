package distributore.actions;

import com.opensymphony.xwork2.ActionSupport;

import distributore.distributore.Distributore;

public class AggiornaColonna extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private String codice;
	private String numColonna, numLattine;
	private boolean valido;

	public AggiornaColonna() {
		super();
	}

	public boolean getValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNumColonna() {
		return numColonna;
	}

	public void setNumColonna(String numColonna) {
		this.numColonna = numColonna;
	}

	public String getNumLattine() {
		return numLattine;
	}

	public void setNumLattine(String numLattine) {
		this.numLattine = numLattine;
	}

	public String execute() {
		valido = true;
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		Distributore.getDistributore().aggiornaColonna(Integer.parseInt(numColonna), Distributore.getDistributore().getBevandaFromCodice(codice), Integer.parseInt(numLattine));
		return SUCCESS;
	}
	
	public void validate() {
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
			
		if(getFieldErrors().get("numLattine") == null)
		try {
			Integer.parseInt(numLattine);
		} catch (NumberFormatException e) {
			addFieldError("numLattine", getText("restrizione.inserireNumero"));
			valido = false;
		}
		
		if(getFieldErrors().get("numColonna") == null)
			try {
				Integer.parseInt(numColonna);
			} catch (NumberFormatException e) {
				addFieldError("numColonna", getText("restrizione.inserireNumero"));
				valido = false;
			}
		
		if(Distributore.getDistributore().getBevandaFromCodice(codice) == null) {
			addFieldError("codice", getText("restrizione.specificareCodice"));
			valido = false;
		}
	}
		
}
