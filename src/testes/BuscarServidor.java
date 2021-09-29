package testes;

import java.util.List;
import dao.ServidorDao;
import entity.Servidor;

public class BuscarServidor {

	private List<Servidor> listaDeServidores;

	public List<Servidor> getListaDeServidores() {
		return listaDeServidores;
	}

	public void setListaDeServidores(List<Servidor> listaDeServidores) {
		this.listaDeServidores = listaDeServidores;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		ServidorDao sDao = new ServidorDao();
		Servidor serv = new Servidor();
		BuscarServidor bs = new BuscarServidor();
		
		bs.setListaDeServidores(sDao.getListaServidor());

		System.out.println(bs.getListaDeServidores().size());
		int val = bs.getListaDeServidores().size();
		int inc = 0;
		while (val > 0) {

			serv = bs.getListaDeServidores().get(inc);
			System.out.println(serv);
			val--;
			inc++;

		}

	}

}
