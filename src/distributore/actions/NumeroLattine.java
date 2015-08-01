package distributore.actions;

import com.opensymphony.xwork2.ActionSupport;

import distributore.distributore.Distributore;

public class NumeroLattine extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private int lattineDisponibili;
	private String codiceBevanda;
	private boolean valido;
	
	public NumeroLattine() {
		super();
	}
	
	public int getLattineDisponibili() {
		return lattineDisponibili;
	}

	public void setLattineDisponibili(int lattineDisponibili) {
		this.lattineDisponibili = lattineDisponibili;
	}
	
	public String getCodiceBevanda() {
		return codiceBevanda;
	}
	
	public void setCodiceBevanda(String codicebevanda) {
		this.codiceBevanda = codicebevanda;
	}
	
	public boolean isValido() {
		return valido;
	}
	
	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public String execute() {
		valido = true;
		lattineDisponibili = 0;
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		lattineDisponibili = Distributore.getDistributore().lattineDisponibili(codiceBevanda);
		return SUCCESS;
	}
	
	public void validate() {
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		
		if(getFieldErrors().get("codiceBevanda") == null)		
		if(Distributore.getDistributore().getBevandaFromCodice(codiceBevanda) == null) {
			addFieldError("codiceBevanda", getText("restrizione.codiceBevandaInesistente"));
			valido = false;
		}
	}
}
