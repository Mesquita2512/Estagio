package entity;

public class Emprestimo {

	private long id;
	private Servidor servidor;
	private Admin admin;
	private Material material;
	private String des_Material_Emprestado;
	private int qtd_emprestado;
	private String observacoes;

	public Emprestimo() {
		super();
	}

	public Emprestimo(Servidor servidor, Admin admin, Material material, String des_Material_Emprestado,
			int qtd_emprestado, String observacoes) {
		super();
		this.servidor = servidor;
		this.admin = admin;
		this.material = material;
		this.des_Material_Emprestado = des_Material_Emprestado;
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

	public String getDes_Material_Emprestado() {
		return des_Material_Emprestado;
	}

	public void setDes_Material_Emprestado(String des_Material_Emprestado) {
		this.des_Material_Emprestado = des_Material_Emprestado;
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
				+ ", des_Material_Emprestado=" + des_Material_Emprestado + ", qtd_emprestado=" + qtd_emprestado
				+ ", observacoes=" + observacoes + "]";
	}

}
