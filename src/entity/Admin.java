package entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Admin extends Servidor {

	@Column(name = "Senha", nullable = false)
	private char[] senha;

	public Admin() {
		super();
	}

	public Admin(long siape, String nome, String email, char[] senha) {
		super(siape, nome, email);
		this.senha = senha;
		// TODO Auto-generated constructor stub
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Admin [senha=" + Arrays.toString(senha) + ", siape=" + siape + ", nome=" + nome + ", email=" + email
				+ "]";
	}

}
