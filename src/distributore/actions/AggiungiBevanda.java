package distributore.actions;

import com.opensymphony.xwork2.ActionSupport;

import distributore.bean.Bevanda;
import distributore.distributore.Distributore;

public class AggiungiBevanda extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String nome, codice;
	private String prezzo;
	private boolean valido;
	
	public AggiungiBevanda() {}
	
	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	
	public String execute() {
		valido = true;
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		Distributore.getDistributore().aggiungiBevanda(new Bevanda(nome, codice, Float.parseFloat(prezzo)));
		return SUCCESS;
	}

	public void validate() {
		if(Distributore.getDistributore() == null)
			Distributore.setDistributore(new Distributore());
		try {
			Float.parseFloat(prezzo);
		} catch (NumberFormatException e) {
			addFieldError("prezzo", getText("restrizione.inserireNumero"));
			valido = false;
		}
		if(Distributore.getDistributore().getBevandaFromCodice(codice) != null) {
			addFieldError("codice", getText("restrizione.codiceMemorizzato"));
			valido = false;
		}
	}
}
