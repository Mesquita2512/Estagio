package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name = "Servidor")
public class Servidor {
	
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false, name = "Siape")
	private long siape;
	
	@Column(nullable = false, name = "Nome")
	private String nome;
	
	@Column(nullable = false, name = "Email")
	private String email;

	
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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servidor [id=" + id + ", siape=" + siape + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	

}
