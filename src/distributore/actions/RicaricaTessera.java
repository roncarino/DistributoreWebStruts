package distributore.actions;

import com.opensymphony.xwork2.ActionSupport;

import distributore.distributore.Distributore;

public class RicaricaTessera extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String codice;
	private String importo;
	private boolean valido;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
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
		Distributore.getDistributore().getTesseraFromCodice(Integer.parseInt(codice)).caricaTessera(Float.parseFloat(importo));
		return SUCCESS;
	}
	
	public void validate() {
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		
		try {
			Integer.parseInt(codice);
		} catch (NumberFormatException e) {
			addFieldError("codice", getText("restrizione.inserireNumero"));
			valido = false;
		}
		
		try {
			Float.parseFloat(importo);
		} catch (NumberFormatException e) {
			addFieldError("importo", getText("restrizione.inserireNumero"));
			valido = false;
		}
		
		if(getFieldErrors().get("codice") == null)
		if(Distributore.getDistributore().getTesseraFromCodice(Integer.parseInt(codice)) == null) {
			addFieldError("codice", getText("restrizione.codiceMemorizzato"));
			valido = false;
		}
	}
}
