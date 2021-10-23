package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.MaterialDao;

public class Materiais {

	private JFrame frmTelaMaterias;

	Controla_views control_View = new Controla_views();

	int siape;
	private JTextField textField;
	private JTable tb_Materiais;

	private List<entity.Material> listaMaterial;
	entity.Material mate = new entity.Material();
	MaterialDao mDao = new MaterialDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materiais windowLogin = new Materiais();
					windowLogin.frmTelaMaterias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void listarMateriais() {
		int val = getListaMaterial().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tb_Materiais.getModel();
		tabelaBd.setNumRows(0);
		// Mostra os Emprestimos na tela
		while (val > 0) {
			mate = getListaMaterial().get(inc);

			tabelaBd.addRow(new Object[] { mate.getDescricao(), mate.getQtd(), mate.getQtd_emprestado(),
					mate.getVal_estimado(), mate.getEst_conservacao(), mate.isStatusAtivo() });

			val--;
			inc++;
			mate = new entity.Material();

		}

	}

	/**
	 * Create the application.
	 */
	public Materiais() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaMaterias = new JFrame();
		frmTelaMaterias.setResizable(false);
		frmTelaMaterias.setBackground(Color.PINK);
		frmTelaMaterias.setTitle("Materiais");
		frmTelaMaterias.setBounds(100, 100, 600, 400);
		frmTelaMaterias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Controle Materiais");
		lblNewLabel.setBounds(25, 22, 534, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btn_AdicionarMaterial = new JButton("");
		btn_AdicionarMaterial.setBounds(54, 65, 54, 61);
		btn_AdicionarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaCadatroMateriais();
				getFrmTelaMaterias().dispose();
			}
		});
		btn_AdicionarMaterial.setIcon(new ImageIcon(Materiais.class.getResource("/imagens/Icon_AdicionarPQ.png")));

		textField = new JTextField();
		textField.setBounds(199, 74, 254, 23);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);

		JLabel lblMaterialservidor = new JLabel("Material");
		lblMaterialservidor.setBounds(136, 75, 45, 21);
		lblMaterialservidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Buscar = new JButton("Buscar");
		btn_Buscar.setBounds(471, 73, 88, 25);
		btn_Buscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Buscar.setBackground(new Color(0, 206, 209));

		JScrollPane sp_Materiais = new JScrollPane();
		sp_Materiais.setBounds(25, 132, 534, 170);

		JButton btn_Editar = new JButton("Editar");
		btn_Editar.setBounds(25, 320, 111, 25);
		btn_Editar.setBackground(new Color(0, 191, 255));
		btn_Editar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(471, 320, 88, 25);
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaLogin();
				frmTelaMaterias.dispose();

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.setBounds(319, 320, 107, 25);
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				frmTelaMaterias.dispose();

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btn_Arquivar = new JButton("Arquivar");
		btn_Arquivar.setBounds(174, 320, 107, 25);
		btn_Arquivar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Arquivar.setBackground(new Color(0, 206, 209));

		tb_Materiais = new JTable();
		tb_Materiais.setModel(new DefaultTableModel(new Object[][] { { "", null, null, null, null, null }, },
				new String[] { "Descri\u00E7\u00E3o", "Qtd Est", "Qtd Emp", "(R$)", "Est Conserv", "Status" }));
		tb_Materiais.getColumnModel().getColumn(0).setPreferredWidth(158);
		tb_Materiais.getColumnModel().getColumn(1).setPreferredWidth(55);
		tb_Materiais.getColumnModel().getColumn(2).setPreferredWidth(60);
		tb_Materiais.getColumnModel().getColumn(3).setPreferredWidth(60);
		tb_Materiais.getColumnModel().getColumn(4).setPreferredWidth(114);
		sp_Materiais.setViewportView(tb_Materiais);
		frmTelaMaterias.getContentPane().setLayout(null);
		frmTelaMaterias.getContentPane().add(btn_Editar);
		frmTelaMaterias.getContentPane().add(btn_Arquivar);
		frmTelaMaterias.getContentPane().add(btn_Voltar);
		frmTelaMaterias.getContentPane().add(btn_Sair);
		frmTelaMaterias.getContentPane().add(lblNewLabel);
		frmTelaMaterias.getContentPane().add(btn_AdicionarMaterial);
		frmTelaMaterias.getContentPane().add(lblMaterialservidor);
		frmTelaMaterias.getContentPane().add(textField);
		frmTelaMaterias.getContentPane().add(btn_Buscar);
		frmTelaMaterias.getContentPane().add(sp_Materiais);
	}

	public JFrame getFrmTelaMaterias() {
		return frmTelaMaterias;
	}

	public void setFrmTelaMaterias(JFrame frmTelaMaterias) {
		this.frmTelaMaterias = frmTelaMaterias;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}

	public List<entity.Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<entity.Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

}
