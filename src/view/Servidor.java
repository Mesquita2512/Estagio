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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Servidor {

	private JFrame frmTelaServidor;

	Controla_views control_View = new Controla_views();
	private JTextField txt_buscarServidor;

	JButton btn_Editar = new JButton("Editar");
	JButton btn_Buscar = new JButton("Buscar");

	Controla_views control = new Controla_views();
	private JTable tb_Servidor;

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

			if (admin1 == "Servidor") {
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
	public Servidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmTelaServidor = new JFrame();
		frmTelaServidor.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Servidor.class.getResource("/imagens/Icon_ServidorPQ.png")));
		frmTelaServidor.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaServidor.setResizable(false);
		frmTelaServidor.setBackground(Color.PINK);
		frmTelaServidor.setTitle("Servidor");
		frmTelaServidor.setBounds(100, 100, 625, 420);

		frmTelaServidor.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmTelaServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmTelaServidor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});
		frmTelaServidor.getContentPane().setLayout(null);

		JScrollPane sp_Materiais = new JScrollPane();
		sp_Materiais.setBounds(30, 103, 559, 214);
		frmTelaServidor.getContentPane().add(sp_Materiais);

		tb_Servidor = new JTable();
		tb_Servidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
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
		btn_Voltar.setBounds(512, 335, 77, 25);
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.abreTelaPrincipal();
				getFrmTelaServidor().dispose();
			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		frmTelaServidor.getContentPane().add(btn_Voltar);

		JButton btn_Arquivar = new JButton("Ativar/Inativar");
		btn_Arquivar.setBounds(234, 335, 125, 25);
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
		frmTelaServidor.getContentPane().add(btn_Arquivar);
		btn_Editar.setBounds(135, 335, 89, 25);

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
					serv = sDao.buscarPorSiape(captaId);

					if (serv.isStatusAtivo() == "Inativo") {
						JOptionPane.showMessageDialog(null, "Não é possível editar um servidor inativo");
					} else {
						control_View.abreTelaEditarServidor(serv);
						getFrmTelaServidor().dispose();
					}

				}

			}
		});
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Editar.setBackground(new Color(0, 191, 255));
		frmTelaServidor.getContentPane().add(btn_Editar);

		btn_Buscar.setBounds(369, 67, 88, 25);
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
		frmTelaServidor.getContentPane().add(btn_Buscar);

		txt_buscarServidor = new JTextField();
		txt_buscarServidor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_Buscar.doClick();
				}
			}
		});
		txt_buscarServidor.setBounds(117, 68, 230, 23);
		txt_buscarServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_buscarServidor.setColumns(10);
		frmTelaServidor.getContentPane().add(txt_buscarServidor);

		JLabel lblServidor = new JLabel("Servidor");
		lblServidor.setBounds(30, 69, 77, 21);
		lblServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmTelaServidor.getContentPane().add(lblServidor);

		JButton btn_AdicionarServidor = new JButton("Adicionar");
		btn_AdicionarServidor.setBounds(30, 335, 95, 25);
		btn_AdicionarServidor.setBackground(new Color(34, 139, 34));
		btn_AdicionarServidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_AdicionarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control.abreTelaCadastroServidor();
				getFrmTelaServidor().dispose();

			}
		});
		btn_AdicionarServidor.setIcon(null);
		frmTelaServidor.getContentPane().add(btn_AdicionarServidor);

		JLabel lblControleServidor = new JLabel("Controle Servidor");
		lblControleServidor.setBounds(30, 21, 175, 25);
		lblControleServidor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmTelaServidor.getContentPane().add(lblControleServidor);

		JButton btn_Administradores = new JButton("Administradores");
		btn_Administradores.setBounds(369, 335, 133, 25);
		btn_Administradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaConfirmerSenha();
				getFrmTelaServidor().dispose();

			}
		});
		btn_Administradores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Administradores.setBackground(new Color(135, 206, 250));
		frmTelaServidor.getContentPane().add(btn_Administradores);

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
