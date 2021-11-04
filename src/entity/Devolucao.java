package entity;

import java.util.Calendar;
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
public class Devolucao {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@OneToOne
	@JoinColumn(name = "Id_Emprestimo", nullable = false)
	private Emprestimo emprestimo;

	@OneToOne
	@JoinColumn(name = "Siape_Admin_Recebe")
	private Admin adminRecebe;

	@Column(name = "Data_Devolucao")
	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;

	@Column(name = "Qtd_Devolvida")
	private int qtdDevolvida;

	@Column(name = "Obs_Devolucao")
	private String obsDevolucao;
	
	@Column(name="Hora_Devolucao")
	@Temporal(TemporalType.DATE)
	private Calendar localDate;

	public Devolucao() {
		super();
	}

	public Devolucao(Emprestimo emprestimo, Admin adminRecebe, Date dataDevolucao, int qtdDevolvida,
			String obsDevolucao) {
		super();
		this.emprestimo = emprestimo;
		this.adminRecebe = adminRecebe;
		this.dataDevolucao = dataDevolucao;
		this.qtdDevolvida = qtdDevolvida;
		this.obsDevolucao = obsDevolucao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Admin getAdminRecebe() {
		return adminRecebe;
	}

	public void setAdminRecebe(Admin adminRecebe) {
		this.adminRecebe = adminRecebe;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public int getQtdDevolvida() {
		return qtdDevolvida;
	}

	public void setQtdDevolvida(int qtdDevolvida) {
		this.qtdDevolvida = qtdDevolvida;
	}

	public String getObsDevolucao() {
		return obsDevolucao;
	}

	public void setObsDevolucao(String obsDevolucao) {
		this.obsDevolucao = obsDevolucao;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Calendar getLocalDate() {
		return localDate;
	}

	public void setLocalDate(Calendar localDate) {
		this.localDate = localDate;
	}

	@Override
	public String toString() {
		return "Devolucao [id=" + id + ", emprestimo=" + emprestimo + ", adminRecebe=" + adminRecebe
				+ ", dataDevolucao=" + dataDevolucao + ", qtdDevolvida=" + qtdDevolvida + ", obsDevolucao="
				+ obsDevolucao + "]";
	}

}
