package testes;

import java.util.List;

import dao.MaterialDao;
import entity.Material;

public class BuscarMaterial {
	private List<Material> listaDeMateriais;

	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}

	
	public static void main(String[] args) {

		MaterialDao mDao = new MaterialDao();
		Material mat = new Material();

		BuscarMaterial bm = new BuscarMaterial();
		bm.setListaDeMateriais(mDao.getListaMaterial());

		System.out.println(bm.getListaDeMateriais().size());
		int val = bm.getListaDeMateriais().size();
		int inc = 0;
		while (val > 0) {

			mat = bm.getListaDeMateriais().get(inc);
			System.out.println(mat+"Lista de todos os Materiais");
			val--;
			inc++;

		}
		
		//coments
		bm.setListaDeMateriais(mDao.listarMaterialPorNome("'%lApis%'"));
		
		
		System.out.println(bm.getListaDeMateriais().size());
		 val = bm.getListaDeMateriais().size();
		 inc = 0;
		while (val > 0) {

			mat = bm.getListaDeMateriais().get(inc);
			System.out.println(mat+"Lista dos materias filtrados");
			val--;
			inc++;

		}

	}

}
