package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne
	@JoinColumn(name = "Siape_Servidor", nullable = false)
	private Servidor servidor;

	@OneToOne
	@JoinColumn(name = "Siape_Admin", nullable = false)
	private Admin admin;

	@OneToOne
	@JoinColumn(name = "Id_Material", nullable = false)
	private Material material;

	@Column(name = "Qtd_Emprestada", nullable = false)
	private int qtd_emprestado;

	@Column(name = "Qtd_Devolvida")
	private int qtd_devolvida;

	@Column(name = "Data_Entrega", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data_Entrega;

	@Column(name = "Data_Devolucao")
	@Temporal(TemporalType.DATE)
	private Date data_Devolu��o;

	@Column(name = "Observacoes")
	private String observacoes;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Servidor servidor, Admin admin, Material material, int qtd_emprestado, int qtd_devolvida,
			Date data_Entrega, Date data_Devolu��o, String observacoes) {
		super();
		this.servidor = servidor;
		this.admin = admin;
		this.material = material;
		this.qtd_emprestado = qtd_emprestado;
		this.qtd_devolvida = qtd_devolvida;
		this.data_Entrega = data_Entrega;
		this.data_Devolu��o = data_Devolu��o;
		this.observacoes = observacoes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getQtd_devolvida() {
		return qtd_devolvida;
	}

	public void setQtd_devolvida(int qtd_devolvida) {
		this.qtd_devolvida = qtd_devolvida;
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

	public Date getData_Entrega() {
		return data_Entrega;
	}

	public void setData_Entrega(Date data_Entrega) {
		this.data_Entrega = data_Entrega;
	}

	public Date getData_Devolu��o() {
		return data_Devolu��o;
	}

	public void setData_Devolu��o(Date data_Devolu��o) {
		this.data_Devolu��o = data_Devolu��o;
	}

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", servidor=" + servidor + ", admin=" + admin + ", material=" + material
				+ ", qtd_emprestado=" + qtd_emprestado + ", qtd_devolvida=" + qtd_devolvida + ", data_Entrega="
				+ data_Entrega + ", data_Devolu��o=" + data_Devolu��o + ", observacoes=" + observacoes + "]";
	}

}
