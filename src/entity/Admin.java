package entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends Servidor {
	
	@Column(name = "Senha")
	private String senha;

	public Admin() {
		super();
	}

	public Admin(long siape, String nome, String email, String senha) {
		super(siape, nome, email);
		this.senha = senha;
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "admin [senha=" + senha + ", toString()=" + super.toString() + "]";
	}
	
	

}
