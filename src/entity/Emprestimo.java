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
	@JoinColumn(name = "Siape_Admin_Entrega", nullable = false)
	private Admin adminEntrega;

	@OneToOne
	@JoinColumn(name = "Id_Material", nullable = false)
	private Material material;

	@Column(name = "Qtd_Emprestada", nullable = false)
	private int qtdEmprestado;

	@Column(name = "Qtd_Tot_Devolvida", nullable = false)
	private int qtdTotalDevolvida;

	@Column(name = "Data_Entrega", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataEntrega;

	@Column(name = "Obs_Entrega")
	private String obsEntrega;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Servidor servidor, Admin adminEntrega, Material material, int qtdEmprestado,
			int qtdTotalDevolvida, Date dataEntrega, String obsEntrega) {
		super();
		this.servidor = servidor;
		this.adminEntrega = adminEntrega;
		this.material = material;
		this.qtdEmprestado = qtdEmprestado;
		this.qtdTotalDevolvida = qtdTotalDevolvida;
		this.dataEntrega = dataEntrega;
		this.obsEntrega = obsEntrega;
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

	public Admin getAdminEntrega() {
		return adminEntrega;
	}

	public void setAdminEntrega(Admin adminEntrega) {
		this.adminEntrega = adminEntrega;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getQtdEmprestado() {
		return qtdEmprestado;
	}

	public void setQtdEmprestado(int qtdEmprestado) {
		this.qtdEmprestado = qtdEmprestado;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getObsEntrega() {
		return obsEntrega;
	}

	public void setObsEntrega(String obsEntrega) {
		this.obsEntrega = obsEntrega;
	}

	public int getQtdTotalDevolvida() {
		return qtdTotalDevolvida;
	}

	public void setQtdTotalDevolvida(int qtdTotalDevolvida) {
		this.qtdTotalDevolvida = qtdTotalDevolvida;
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
		return "Emprestimo [id=" + id + ", servidor=" + servidor + ", adminEntrega=" + adminEntrega + ", material="
				+ material + ", qtdEmprestado=" + qtdEmprestado + ", qtdTotalDevolvida=" + qtdTotalDevolvida
				+ ", dataEntrega=" + dataEntrega + ", obsEntrega=" + obsEntrega + "]";
	}

}
