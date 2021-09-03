package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Emprestimo {

	@Id
	@Column(name = "Id")
	private long id;

	@OneToOne
	@JoinColumn(name = "Siape_Servidor")
	private Servidor servidor;

	@OneToOne
	@JoinColumn(name = "Siape_Admin")
	private Admin admin;

	@OneToOne
	@JoinColumn(name = "Id_Material")
	private Material material;

	@Column(name = "Qtd_Emprestada")
	private int qtd_emprestado;

	@Column(name = "Observacoes")
	private String observacoes;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Servidor servidor, Admin admin, Material material, int qtd_emprestado, String observacoes) {
		super();
		this.servidor = servidor;
		this.admin = admin;
		this.material = material;
		this.qtd_emprestado = qtd_emprestado;
		this.observacoes = observacoes;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getQtd_emprestado() {
		return qtd_emprestado;
	}

	public void setQtd_emprestado(int qtd_emprestado) {
		this.qtd_emprestado = qtd_emprestado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Emprestimo other = (Emprestimo) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", servidor=" + servidor + ", admin=" + admin + ", material=" + material
				+ ", qtd_emprestado=" + qtd_emprestado + ", observacoes=" + observacoes + "]";
	}

}
