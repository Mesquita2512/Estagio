package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ServidorDao;

public class Servidor {

	private JFrame frmTelaServidor;

	Controla_views control_View = new Controla_views();
	private JTextField txt_buscarServidor;

	Controla_views control = new Controla_views();
	private JTable tb_Servidor;

	private List<entity.Servidor> listaServidor;
	entity.Servidor serv = new entity.Servidor();
	ServidorDao sDao = new ServidorDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor windowServidor = new Servidor();
					windowServidor.frmTelaServidor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void listarServidores() {
		int val = getListaServidor().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tb_Servidor.getModel();
		tabelaBd.setNumRows(0);
		// Mostra os Emprestimos na tela
		while (val > 0) {
			serv = getListaServidor().get(inc);

			tabelaBd.addRow(new Object[] { serv.getSiape(), serv.getNome(), serv.getEmail(), serv.isStatusAtivo() });

			val--;
			inc++;
			serv = new entity.Servidor();

		}

	}

	/**
	 * Create the application.
	 */
	public Servidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaServidor = new JFrame();
		frmTelaServidor.setResizable(false);
		frmTelaServidor.setBackground(Color.PINK);
		frmTelaServidor.setTitle("Servidor");
		frmTelaServidor.setBounds(100, 100, 600, 420);
		frmTelaServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaServidor.getContentPane().setLayout(null);

		JScrollPane sp_Materiais = new JScrollPane();
		sp_Materiais.setBounds(30, 147, 534, 170);
		frmTelaServidor.getContentPane().add(sp_Materiais);

		tb_Servidor = new JTable();
		tb_Servidor.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "Siape", "Nome", "Email", "Status" }));
		tb_Servidor.getColumnModel().getColumn(0).setPreferredWidth(118);
		tb_Servidor.getColumnModel().getColumn(1).setPreferredWidth(230);
		tb_Servidor.getColumnModel().getColumn(2).setPreferredWidth(196);
		sp_Materiais.setViewportView(tb_Servidor);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control.abreTelaLogin();
				getFrmTelaServidor().dispose();

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(476, 335, 88, 25);
		frmTelaServidor.getContentPane().add(btn_Sair);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.abreTelaPrincipal();
				getFrmTelaServidor().dispose();
			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setBounds(346, 335, 107, 25);
		frmTelaServidor.getContentPane().add(btn_Voltar);

		JButton btn_Arquivar = new JButton("Arquivar/Desarquivar");
		btn_Arquivar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Arquivar.setBackground(new Color(0, 206, 209));
		btn_Arquivar.setBounds(161, 335, 161, 25);
		frmTelaServidor.getContentPane().add(btn_Arquivar);

		JButton btn_Editar = new JButton("Editar");
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Editar.setBackground(new Color(0, 191, 255));
		btn_Editar.setBounds(30, 335, 111, 25);
		frmTelaServidor.getContentPane().add(btn_Editar);

		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Buscar.setBackground(new Color(0, 206, 209));
		btn_Buscar.setBounds(476, 72, 88, 25);
		frmTelaServidor.getContentPane().add(btn_Buscar);

		txt_buscarServidor = new JTextField();
		txt_buscarServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_buscarServidor.setColumns(10);
		txt_buscarServidor.setBounds(216, 73, 230, 23);
		frmTelaServidor.getContentPane().add(txt_buscarServidor);

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServidor.setBounds(129, 74, 77, 21);
		frmTelaServidor.getContentPane().add(lblServidor);

		JButton btn_AdicionarServidor = new JButton("");
		btn_AdicionarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control.abreTelaCadastroServidor();
				getFrmTelaServidor().dispose();

			}
		});
		btn_AdicionarServidor.setIcon(new ImageIcon(Servidor.class.getResource("/imagens/Icon_AdicionarPQ.png")));
		btn_AdicionarServidor.setBounds(47, 64, 54, 61);
		frmTelaServidor.getContentPane().add(btn_AdicionarServidor);

		JLabel lblControleServidor = new JLabel("Controle Servidor");
		lblControleServidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblControleServidor.setBounds(30, 21, 534, 25);
		frmTelaServidor.getContentPane().add(lblControleServidor);

	}

	public JFrame getFrmTelaServidor() {
		return frmTelaServidor;
	}

	public void setFrmTelaServidor(JFrame frmTelaServidor) {
		this.frmTelaServidor = frmTelaServidor;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}

	public List<entity.Servidor> getListaServidor() {
		return listaServidor;
	}

	public void setListaServidor(List<entity.Servidor> listaServidor) {
		this.listaServidor = listaServidor;
	}

}
