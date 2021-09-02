package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servidor {
	
	@Id
	@Column(nullable = false, name = "Siape")
	protected long siape;
	
	@Column(nullable = false, name = "Nome")
	protected String nome;
	
	@Column(nullable = false, name = "Email")
	protected String email;

	
	public Servidor() {
		super();
	}

	public Servidor(long siape, String nome, String email) {
		super();
		this.siape = siape;
		this.nome = nome;
		this.email = email;
	}


	public long getSiape() {
		return siape;
	}

	public void setSiape(long siape) {
		this.siape = siape;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (siape ^ (siape >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servidor other = (Servidor) obj;
		if (siape != other.siape)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servidor [siape=" + siape + ", nome=" + nome + ", email=" + email + "]";
	}

	
	
	
	

}
