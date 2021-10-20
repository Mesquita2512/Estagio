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

	public Admin(long siape, String nome, String email, boolean statusAtivo, String senha) {
		super(siape, nome, email, statusAtivo);
		this.senha = senha;
		// TODO Auto-generated constructor stub
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Admin [senha=" + senha + ", siape=" + siape + ", nome=" + nome + ", email=" + email + "]";
	}

	

}
