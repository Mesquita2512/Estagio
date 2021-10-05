package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Descricao", nullable = false)
	private String descricao;
	
	@Column(name = "Qtd_Estoque", nullable = false)
	private int qtd;
	
	@Column(name = "Qtd_Emprestado")
	private int qtd_emprestado;
	
	@Column(name = "Valor_Estimado")
	private double val_estimado;
	
	@Column(name = "Estado_De_Conservacao")
	private String est_conservacao;

	public Material() {
		super();
	}

	public Material(String descricao, int qtd, int qtd_emprestado, double val_estimado, String est_conservacao) {
		super();
		this.descricao = descricao;
		this.qtd = qtd;
		this.qtd_emprestado = qtd_emprestado;
		this.val_estimado = val_estimado;
		this.est_conservacao = est_conservacao;
	}


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public double getVal_estimado() {
		return val_estimado;
	}

	public void setVal_estimado(double val_estimado) {
		this.val_estimado = val_estimado;
	}

	public String getEst_conservacao() {
		return est_conservacao;
	}

	public void setEst_conservacao(String est_conservacao) {
		this.est_conservacao = est_conservacao;
	}
	

	public int getQtd_emprestado() {
		return qtd_emprestado;
	}

	public void setQtd_emprestado(int qtd_emprestado) {
		this.qtd_emprestado = qtd_emprestado;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		Material other = (Material) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", descricao=" + descricao + ", qtd=" + qtd + ", qtd_emprestado=" + qtd_emprestado
				+ ", val_estimado=" + val_estimado + ", est_conservacao=" + est_conservacao + "]";
	}


}
