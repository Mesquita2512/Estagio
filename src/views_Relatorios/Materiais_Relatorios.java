package views_Relatorios;

import java.awt.EventQueue;
import javax.swing.JFrame;
import view.Controla_views;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import dao.MaterialDao;
import entity.Material;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Materiais_Relatorios {

	private JFrame frmTelaMateriais_Relatorios;

	Controla_views control_View = new Controla_views();
	Controla_Relatorios control_rel = new Controla_Relatorios();
	String filtro = "Lista de todos os materiais";

	MaterialDao mDao = new MaterialDao();
	private List<Material> listaMaterial;
	Material mate = new Material();
	private JTable tb_Materiais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materiais_Relatorios windowMateRel = new Materiais_Relatorios("todos");
					windowMateRel.frmTelaMateriais_Relatorios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Materiais_Relatorios(String filtroMate) {
		if (filtroMate == "ativos") {
			filtro = filtro + " ativos";
		}
		if (filtroMate == "inativos") {
			filtro = filtro + " inativos";
		}

		initialize();
	}

	public void carregaRelatorio(String filtroMate) {

		if (filtroMate == "todos") {
			setListaMaterial(mDao.getListaMaterial());
			carregar();

		}
		if (filtroMate == "ativos") {
			setListaMaterial(mDao.listarMaterialPorStatus());
			carregar();

		}
		if (filtroMate == "inativos") {
			setListaMaterial(mDao.listarMaterialPorStatusInativos());
			carregar();
		}

	}

	public void carregar() {
		int val = getListaMaterial().size();
		int inc = 0;

		DefaultTableModel tabelaBd = (DefaultTableModel) tb_Materiais.getModel();
		tabelaBd.setNumRows(0);
		// Mostra os Materias na tela
		while (val > 0) {
			// pegando os materiais do indice
			mate = getListaMaterial().get(inc);

			// Adicinando o Material na tabela
			tabelaBd.addRow(new Object[] { mate.getId(), mate.getDescricao(), mate.getQtd(), mate.getQtd_emprestado(),
					mate.getEst_conservacao(), mate.isStatusAtivo() });

			val--;
			inc++;
			mate = new Material();

		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frmTelaMateriais_Relatorios = new JFrame();
		frmTelaMateriais_Relatorios.getContentPane().setBackground(new Color(224, 255, 255));
		frmTelaMateriais_Relatorios.setResizable(false);
		frmTelaMateriais_Relatorios.setBackground(Color.PINK);
		frmTelaMateriais_Relatorios.setTitle("Relatório Materiais");
		frmTelaMateriais_Relatorios.setBounds(100, 100, 700, 600);
		frmTelaMateriais_Relatorios.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTelaMateriais_Relatorios.getContentPane().setLayout(null);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control_rel.abretelaRelatorios();
				getFrmTelaMateriais_Relatorios().dispose();
			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setBounds(490, 516, 73, 25);
		frmTelaMateriais_Relatorios.getContentPane().add(btn_Voltar);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_View.fecharSistema() == true) {
					getFrmTelaMateriais_Relatorios().dispose();
				}
			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(572, 516, 91, 25);
		frmTelaMateriais_Relatorios.getContentPane().add(btn_Sair);

		JLabel lblNewLabel = new JLabel(filtro);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(31, 22, 482, 64);
		frmTelaMateriais_Relatorios.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 109, 632, 383);
		frmTelaMateriais_Relatorios.getContentPane().add(scrollPane);

		tb_Materiais = new JTable();
		tb_Materiais.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Descri\u00E7\u00E3o", "Qtd Estoque", "Qtd Emprestado", "Estado Conserva\u00E7\u00E3o", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tb_Materiais.getColumnModel().getColumn(0).setResizable(false);
		tb_Materiais.getColumnModel().getColumn(0).setPreferredWidth(60);
		tb_Materiais.getColumnModel().getColumn(1).setResizable(false);
		tb_Materiais.getColumnModel().getColumn(1).setPreferredWidth(210);
		tb_Materiais.getColumnModel().getColumn(2).setResizable(false);
		tb_Materiais.getColumnModel().getColumn(3).setResizable(false);
		tb_Materiais.getColumnModel().getColumn(4).setResizable(false);
		tb_Materiais.getColumnModel().getColumn(4).setPreferredWidth(120);
		tb_Materiais.getColumnModel().getColumn(5).setResizable(false);
		tb_Materiais.setRowSelectionAllowed(false);
		scrollPane.setViewportView(tb_Materiais);
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public JFrame getFrmTelaMateriais_Relatorios() {
		return frmTelaMateriais_Relatorios;
	}

	public void setFrmTelaMateriais_Relatorios(JFrame frmTelaMateriais_Relatorios) {
		this.frmTelaMateriais_Relatorios = frmTelaMateriais_Relatorios;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}

	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}

}
