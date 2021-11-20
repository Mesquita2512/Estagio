package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import config.Numeros;
import dao.AdminDao;
import dao.EmprestimoDao;
import dao.MaterialDao;
import dao.ServidorDao;
import entity.Admin;
import entity.Emprestimo;
import entity.Material;
import entity.Servidor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

public class EditarEmprestimo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JFrame frmEditarEmprestimo;
	private JTextField txt_Material;
	private JTextField txt_Quantidade;
	private JTextField txt_EntregueA;

	private List<Material> listaDeMateriais;
	private List<Servidor> listaDeServidores;
	Date date = new Date();

	MaterialDao mDao = new MaterialDao();
	Material mat = new Material();

	Servidor serv = new Servidor();
	ServidorDao sDao = new ServidorDao();

	Admin adm = new Admin();
	AdminDao aDao = new AdminDao();

	Emprestimo emp = new Emprestimo();
	EmprestimoDao eDao = new EmprestimoDao();

	Controla_views control_View = new Controla_views();
	private JTextField txt_Observacoes;
	private JButton btn_Voltar;
	private JButton btn_Sair;
	private JLabel lblCadastrarEmprstimo;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2;
	private JButton btn_Salvar;

	JDateChooser dc_dataEntrega = new JDateChooser();
	private JTextField txt_Id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarEmprestimo window = new EditarEmprestimo();
					window.frmEditarEmprestimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditarEmprestimo() {
		initialize();
		txt_Quantidade.setDocument(new Numeros());
		frmEditarEmprestimo.getContentPane().setLayout(null);
		frmEditarEmprestimo.getContentPane().add(btn_Voltar);
		frmEditarEmprestimo.getContentPane().add(btn_Sair);
		frmEditarEmprestimo.getContentPane().add(lblCadastrarEmprstimo);
		frmEditarEmprestimo.getContentPane().add(lblNewLabel_1);
		frmEditarEmprestimo.getContentPane().add(lblNewLabel_1_3);
		frmEditarEmprestimo.getContentPane().add(lblNewLabel);
		frmEditarEmprestimo.getContentPane().add(lblNewLabel_1_1);
		frmEditarEmprestimo.getContentPane().add(lblNewLabel_1_2);
		frmEditarEmprestimo.getContentPane().add(txt_Observacoes);
		frmEditarEmprestimo.getContentPane().add(txt_Quantidade);
		frmEditarEmprestimo.getContentPane().add(txt_Material);
		frmEditarEmprestimo.getContentPane().add(txt_EntregueA);
		frmEditarEmprestimo.getContentPane().add(btn_Salvar);

		dc_dataEntrega.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
		dc_dataEntrega.setBounds(139, 208, 127, 25);
		dc_dataEntrega.setDate(new Date());
		frmEditarEmprestimo.getContentPane().add(dc_dataEntrega);

		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(43, 80, 88, 17);
		frmEditarEmprestimo.getContentPane().add(lblId);

		txt_Id = new JTextField();
		txt_Id.setEditable(false);
		txt_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Id.setColumns(10);
		txt_Id.setBounds(137, 77, 129, 23);
		frmEditarEmprestimo.getContentPane().add(txt_Id);
	}

	public void pegaEmprestimo(Emprestimo emprestimo) {

		txt_Id.setText(emprestimo.getId() + "");
		txt_Material.setText(emprestimo.getMaterial().getDescricao());
		txt_Quantidade.setText(emprestimo.getQtdEmprestado() + "");
		dc_dataEntrega.setDate(emprestimo.getDataEntrega());
		txt_EntregueA.setText(emprestimo.getServidor().getNome());
		txt_Observacoes.setText(emprestimo.getObsEntrega());

		emp = emprestimo;
		mat = emp.getMaterial();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmEditarEmprestimo = new JFrame();
		frmEditarEmprestimo.setIconImage(Toolkit.getDefaultToolkit().getImage(EditarEmprestimo.class.getResource("/imagens/Icon_AdicionarPQ.png")));
		frmEditarEmprestimo.getContentPane().setBackground(new Color(240, 255, 255));
		frmEditarEmprestimo.setResizable(false);
		frmEditarEmprestimo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 45));
		frmEditarEmprestimo.setTitle("Novo Emprestimo");
		frmEditarEmprestimo.setBounds(100, 100, 600, 500);
		
		frmEditarEmprestimo.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmEditarEmprestimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmEditarEmprestimo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

		lblCadastrarEmprstimo = new JLabel("Editar Empréstimo");
		lblCadastrarEmprstimo.setBounds(43, 11, 435, 43);
		lblCadastrarEmprstimo.setForeground(new Color(0, 0, 139));
		lblCadastrarEmprstimo.setFont(new Font("Tahoma", Font.PLAIN, 35));

		lblNewLabel = new JLabel("Material");
		lblNewLabel.setBounds(43, 123, 78, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setBounds(43, 168, 86, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_1 = new JLabel("Entregue a");
		lblNewLabel_1_1.setBounds(43, 257, 86, 17);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_2 = new JLabel("Data");
		lblNewLabel_1_2.setBounds(43, 216, 86, 17);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_3 = new JLabel("Observações");
		lblNewLabel_1_3.setBounds(43, 301, 86, 17);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Material = new JTextField();
		txt_Material.setEditable(false);
		txt_Material.setBounds(139, 120, 129, 23);
		txt_Material.setEnabled(true);
		txt_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setBounds(139, 165, 129, 23);
		txt_Quantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Quantidade.setColumns(10);

		txt_EntregueA = new JTextField();
		txt_EntregueA.setBounds(139, 254, 129, 23);
		txt_EntregueA.setEditable(false);
		txt_EntregueA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_EntregueA.setColumns(10);

		btn_Salvar = new JButton("Atualizar");
		btn_Salvar.setBounds(43, 404, 156, 25);
		btn_Salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Date dataAtual = new Date();
				Date dataRemota = null;

				try {
					dataRemota = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021");
				} catch (ParseException e) {

					e.printStackTrace();
				}
				if (txt_Quantidade.getText().equals("") || Integer.parseInt(txt_Quantidade.getText()) == 0) {
					JOptionPane.showMessageDialog(null, "Informe um valor válido!!!");
				} else if (dc_dataEntrega.getDate() == null || dc_dataEntrega.getDate().compareTo(dataAtual) > 0
						|| dc_dataEntrega.getDate().compareTo(dataRemota) < 0) {
					JOptionPane.showMessageDialog(null, "Date inválida, favor verifique a data informada");

				} else if ((mat.getQtd() + emp.getMaterial().getQtd_emprestado()) < Integer
						.parseInt(txt_Quantidade.getText())) {
					JOptionPane.showMessageDialog(null, "Não há em estoque a quantidade informada!!!");
				}

				else {

					String siape = System.getProperty("siape");
					adm = aDao.buscarPorSiape(Integer.parseInt(siape));

					emp.setQtdEmprestado(Integer.parseInt(txt_Quantidade.getText()));
					emp.setObsEntrega(txt_Observacoes.getText());
					emp.setDataEntrega(dc_dataEntrega.getDate());
					emp.setAdminEntrega(adm);

					mat.setQtd((mat.getQtd() + emp.getMaterial().getQtd_emprestado())
							- Integer.parseInt(txt_Quantidade.getText()));
					mat.setQtd_emprestado(mat.getQtd_emprestado()
							+ (Integer.parseInt(txt_Quantidade.getText()) - emp.getMaterial().getQtd_emprestado()));
					mDao.atualizar(mat);
					eDao.atualizarEmprestimo(emp);

					serv = new Servidor();
					mat = new Material();
					emp = new Emprestimo();

					JOptionPane.showMessageDialog(null, "Empréstimo Editado com sucesso!!!");

				}

			}
		});
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Salvar.setBackground(new Color(34, 139, 34));
		btn_Salvar.setForeground(Color.BLACK);

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.setBounds(232, 404, 135, 25);
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmEditarEmprestimo().dispose();

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(393, 404, 112, 25);
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (control_View.fecharSistema() == true) {
					getFrmEditarEmprestimo().dispose();
				}

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));

		txt_Observacoes = new JTextField();
		txt_Observacoes.setBounds(139, 298, 127, 61);
		txt_Observacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Observacoes.setColumns(10);

	}

	public JFrame getFrmEditarEmprestimo() {
		return frmEditarEmprestimo;
	}

	public void setFrmEditarEmprestimo(JFrame frmEditarEmprestimo) {
		this.frmEditarEmprestimo = frmEditarEmprestimo;
	}

	public JTextField getTxt_Material() {
		return txt_Material;
	}

	public void setTxt_Material(JTextField txt_Material) {
		this.txt_Material = txt_Material;
	}

	public JTextField getTxt_Quantidade() {
		return txt_Quantidade;
	}

	public void setTxt_Quantidade(JTextField txt_Quantidade) {
		this.txt_Quantidade = txt_Quantidade;
	}

	public JTextField getTxt_EntregueA() {
		return txt_EntregueA;
	}

	public void setTxt_EntregueA(JTextField txt_EntregueA) {
		this.txt_EntregueA = txt_EntregueA;
	}

	public JTextField getTxt_Observacoes() {
		return txt_Observacoes;
	}

	public void setTxt_Observacoes(JTextField txt_Observacoes) {
		this.txt_Observacoes = txt_Observacoes;
	}

	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}

	public List<Servidor> getListaDeServidores() {
		return listaDeServidores;
	}

	public void setListaDeServidores(List<Servidor> listaDeServidores) {
		this.listaDeServidores = listaDeServidores;
	}
}
