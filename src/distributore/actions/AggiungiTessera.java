package distributore.actions;

import com.opensymphony.xwork2.ActionSupport;

import distributore.bean.Tessera;
import distributore.distributore.Distributore;

public class AggiungiTessera extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String codice;
	private String credito;
	private boolean valido;
	
	public AggiungiTessera() {
		super();
	}
	
	public String getCodice() {
		return codice;
	}
	
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getCredito() {
		return credito;
	}
	public void setCredito(String credito) {
		this.credito = credito;
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
		Distributore.getDistributore().aggiungiTessera(new Tessera(Integer.parseInt(codice), Float.parseFloat(credito)));
		return SUCCESS;
	}
	
	@Override
	public void validate() {
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		
		try {
			Float.parseFloat(credito);
		} catch (NumberFormatException e) {
			addFieldError("credito", getText("restrizione.inserireNumero"));
			valido = false;
		}
		try {
			Integer.parseInt(codice);
		} catch (NumberFormatException e) {
			addFieldError("codice", getText("restrizione.inserireNumero"));
			valido = false;
		}
		
		if(getFieldErrors().get("codice") == null)
			if(Distributore.getDistributore().getTesseraFromCodice(Integer.parseInt(codice)) != null) {
				addFieldError("codice", getText("restrizione.codiceMemorizzato"));
				valido = false;
			}
	}
}
