package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.AdminDao;
import dao.ServidorDao;
import entity.Admin;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class Administrador {

	private JFrame frmTelaServidor;

	Controla_views control_View = new Controla_views();
	private JTextField txt_buscarServidor;

	Controla_views control = new Controla_views();
	private JTable tb_Servidor;
	JButton btn_Editar = new JButton("Editar");

	private List<entity.Servidor> listaServidor;
	entity.Servidor serv = new entity.Servidor();
	ServidorDao sDao = new ServidorDao();
	Admin adm = new Admin();
	AdminDao aDao = new AdminDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador windowServidor = new Administrador();
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
		// Mostra os Servidores na tela
		while (val > 0) {
			serv = getListaServidor().get(inc);
			@SuppressWarnings("unused")
			String admin1;
			try {
				adm = (Admin) serv;
				admin1 = "Administrador";
			} catch (Exception e) {
				admin1 = "Servidor";
			}

			if (admin1 == "Administrador") {
				tabelaBd.addRow(new Object[] { serv.getSiape(), serv.getNome(), serv.getEmail(), admin1,
						serv.isStatusAtivo() });

				serv = new entity.Servidor();
			}
			val--;
			inc++;

		}

	}

	/**
	 * Create the application.
	 */
	public Administrador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmTelaServidor = new JFrame();
		frmTelaServidor.setIconImage(Toolkit.getDefaultToolkit().getImage(Administrador.class.getResource("/imagens/Icon_Fundo.jpg")));
		frmTelaServidor.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaServidor.setResizable(false);
		frmTelaServidor.setBackground(Color.PINK);
		frmTelaServidor.setTitle("Admistradores");
		frmTelaServidor.setBounds(100, 100, 620, 420);
		frmTelaServidor.getContentPane().setLayout(null);

		frmTelaServidor.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
			int conf =	JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");
				
				if(conf == JOptionPane.YES_OPTION) {
					frmTelaServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					frmTelaServidor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
				
			}
		});

		JScrollPane sp_Materiais = new JScrollPane();
		sp_Materiais.setBounds(30, 103, 559, 214);
		frmTelaServidor.getContentPane().add(sp_Materiais);

		tb_Servidor = new JTable();
		tb_Servidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(arg0.getClickCount() == 2) {
					btn_Editar.doClick();
				}
			}
		});
		tb_Servidor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tb_Servidor.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "Siape", "Nome", "Email", "Tipo de Usuario", "Status" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tb_Servidor.getColumnModel().getColumn(0).setResizable(false);
		tb_Servidor.getColumnModel().getColumn(0).setPreferredWidth(60);
		tb_Servidor.getColumnModel().getColumn(1).setResizable(false);
		tb_Servidor.getColumnModel().getColumn(1).setPreferredWidth(200);
		tb_Servidor.getColumnModel().getColumn(2).setResizable(false);
		tb_Servidor.getColumnModel().getColumn(2).setPreferredWidth(180);
		tb_Servidor.getColumnModel().getColumn(3).setResizable(false);
		tb_Servidor.getColumnModel().getColumn(3).setPreferredWidth(100);
		tb_Servidor.getColumnModel().getColumn(4).setResizable(false);
		tb_Servidor.getColumnModel().getColumn(4).setPreferredWidth(62);
		sp_Materiais.setViewportView(tb_Servidor);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.abreTelaServidor();
				getFrmTelaServidor().dispose();
			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setBounds(349, 335, 106, 25);
		frmTelaServidor.getContentPane().add(btn_Voltar);

		JButton btn_Arquivar = new JButton("Ativar/Inativar");
		btn_Arquivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String capta = "";
				if (tb_Servidor.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Servidor da lista");
				} else if (tb_Servidor.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um Servidor da lista");
				} else {
					capta = tb_Servidor.getValueAt(tb_Servidor.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);
					serv = sDao.buscarPorSiape(captaId);

					if (serv.isStatusAtivo() == "Ativo") {
						String siape = System.getProperty("siape");
						adm = aDao.buscarPorSiape(Integer.parseInt(siape));
						if (adm.getSiape() == serv.getSiape()) {
							JOptionPane.showMessageDialog(null, "Você não pode arquivar este servidor");
							return;
						}

						int verifica = JOptionPane.showConfirmDialog(null, "Deseja Arquivar esse Servidor?");
						if (verifica == JOptionPane.YES_OPTION) {
							serv.setStatusAtivo(false);
							sDao.atualizar(serv);
							serv = new entity.Servidor();
							JOptionPane.showMessageDialog(null, "Servidor arquivado com sucesso!!!");
							// Abre nova Tela atualizando a lista
							getFrmTelaServidor().dispose();
							control_View.abreTelaServidor();
						}
					} else {
						int verifica = JOptionPane.showConfirmDialog(null, "Deseja Desarquivar esse Servidor?");
						if (verifica == JOptionPane.YES_OPTION) {
							serv.setStatusAtivo(true);
							sDao.atualizar(serv);
							serv = new entity.Servidor();
							JOptionPane.showMessageDialog(null, "Servidor desarquivado com sucesso!!!");
							// Abre nova Tela atualizando a lista
							getFrmTelaServidor().dispose();
							control_View.abreTelaServidor();
						}
					}

				}

			}
		});
		btn_Arquivar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Arquivar.setBackground(new Color(255, 248, 220));
		btn_Arquivar.setBounds(166, 335, 173, 25);
		frmTelaServidor.getContentPane().add(btn_Arquivar);

		btn_Editar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String capta = "";
				if (tb_Servidor.getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione um Servidor da lista");
				} else if (tb_Servidor.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "Selecione apenas um Servidor da lista");
				} else {
					capta = tb_Servidor.getValueAt(tb_Servidor.getSelectedRow(), 0).toString();
					int captaId = Integer.parseInt(capta);
					adm = aDao.buscarPorSiape(captaId);

					if (serv.isStatusAtivo() == "Inativo") {
						JOptionPane.showMessageDialog(null, "Não é possível editar um servidor inativo");
					} else {
						control_View.abreTelaEditarAdmin(adm);
						getFrmTelaServidor().dispose();
					}

				}

			}
		});
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Editar.setBackground(new Color(0, 191, 255));
		btn_Editar.setBounds(30, 335, 126, 25);
		frmTelaServidor.getContentPane().add(btn_Editar);

		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String txt_Servidor = txt_buscarServidor.getText().trim();

				if (txt_Servidor.equals("")) {

					setListaServidor(sDao.getListaServidor());

					listarServidores();

				} else {

					txt_Servidor = "'%" + txt_Servidor + "%'";
					setListaServidor(sDao.listarTodosServidoresPorNome(txt_Servidor));

					if (getListaServidor().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Não foi localizado nenhum nenhum com a descrição informada");
					} else {

						listarServidores();

					}
				}

			}
		});
		btn_Buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Buscar.setBackground(new Color(0, 206, 209));
		btn_Buscar.setBounds(379, 67, 88, 25);
		frmTelaServidor.getContentPane().add(btn_Buscar);

		txt_buscarServidor = new JTextField();
		txt_buscarServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_buscarServidor.setColumns(10);
		txt_buscarServidor.setBounds(139, 68, 230, 23);
		frmTelaServidor.getContentPane().add(txt_buscarServidor);

		JLabel lblServidor = new JLabel("Administrador");
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblServidor.setBounds(30, 69, 95, 21);
		frmTelaServidor.getContentPane().add(lblServidor);

		JLabel lblControleServidor = new JLabel("Controle Administradores");
		lblControleServidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblControleServidor.setBounds(30, 21, 253, 25);
		frmTelaServidor.getContentPane().add(lblControleServidor);
		
		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control_View.abreTelaLogin();
				getFrmTelaServidor().dispose();
			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(465, 335, 124, 25);
		frmTelaServidor.getContentPane().add(btn_Sair);

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
