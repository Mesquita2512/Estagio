package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.DevolucaoDao;
import entity.Devolucao;
import entity.Emprestimo;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DetalharEmprestimo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tb_emprestimo;
	private JTable tb_Devolucao;

	Controla_views control_Views = new Controla_views();
	Devolucao dev = new Devolucao();
	DevolucaoDao dDao = new DevolucaoDao();
	private List<Devolucao> listaDevolucao;

	JScrollPane sp_Devolucao = new JScrollPane();
	JLabel lblSemDevoluo = new JLabel("Sem Devolução");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetalharEmprestimo dialog = new DetalharEmprestimo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DetalharEmprestimo() {
		setTitle("Detalhes do Emprétimo");
		setForeground(new Color(240, 255, 255));
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblDetalhes = new JLabel("Detalhes do Empréstimo");
		lblDetalhes.setForeground(new Color(60, 179, 113));
		lblDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetalhes.setBounds(25, 11, 404, 25);
		contentPanel.add(lblDetalhes);

		JScrollPane sp_Empretimos = new JScrollPane();
		sp_Empretimos.setBounds(25, 46, 737, 39);
		contentPanel.add(sp_Empretimos);
		{
			tb_emprestimo = new JTable();
			tb_emprestimo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tb_emprestimo
					.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
							new String[] { "Id", "Entregue por", "Entregue A", "Material", "Qtd Emp", "Data Ent",
									"Observa\u00E7\u00F5es" }));
			tb_emprestimo.getColumnModel().getColumn(0).setPreferredWidth(50);
			tb_emprestimo.getColumnModel().getColumn(1).setPreferredWidth(100);
			tb_emprestimo.getColumnModel().getColumn(2).setPreferredWidth(100);
			tb_emprestimo.getColumnModel().getColumn(3).setPreferredWidth(140);
			tb_emprestimo.getColumnModel().getColumn(4).setPreferredWidth(60);
			tb_emprestimo.getColumnModel().getColumn(6).setPreferredWidth(100);
			sp_Empretimos.setViewportView(tb_emprestimo);
		}
		{
			sp_Devolucao.setVisible(false);
			sp_Devolucao.setBounds(25, 131, 737, 86);
			contentPanel.add(sp_Devolucao);
			{
				tb_Devolucao = new JTable();
				tb_Devolucao.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
						new String[] { "ID", "Qtd Dev", "Data Dev", "Quem recebeu", "Observa\u00E7\u00F5es" }));
				tb_Devolucao.getColumnModel().getColumn(0).setPreferredWidth(50);
				tb_Devolucao.getColumnModel().getColumn(1).setPreferredWidth(55);
				tb_Devolucao.getColumnModel().getColumn(3).setPreferredWidth(150);
				tb_Devolucao.getColumnModel().getColumn(4).setPreferredWidth(150);
				sp_Devolucao.setViewportView(tb_Devolucao);
			}
		}
		{
			JLabel lblDetalhesDasDevoluo = new JLabel("Detalhes das Devoluções:");
			lblDetalhesDasDevoluo.setForeground(new Color(60, 179, 113));
			lblDetalhesDasDevoluo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblDetalhesDasDevoluo.setBounds(25, 95, 235, 25);
			contentPanel.add(lblDetalhesDasDevoluo);
		}
		{
			lblSemDevoluo.setVisible(false);
			lblSemDevoluo.setForeground(new Color(60, 179, 113));
			lblSemDevoluo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblSemDevoluo.setBounds(270, 95, 159, 25);
			contentPanel.add(lblSemDevoluo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(204, 255, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						control_Views.abreTelaPrincipal();
					}
				});
				okButton.setBackground(new Color(50, 205, 50));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						control_Views.abreTelaPrincipal();
					}
				});
				cancelButton.setBackground(new Color(255, 255, 204));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void pegaEmprestimo(Emprestimo emprestimo) {

		DefaultTableModel tabelaEmpr = (DefaultTableModel) tb_emprestimo.getModel();
		tabelaEmpr.setNumRows(0);
		tabelaEmpr.addRow(new Object[] { emprestimo.getId(), emprestimo.getAdminEntrega().getNome(),
				emprestimo.getServidor().getNome(), emprestimo.getMaterial().getDescricao(),
				emprestimo.getQtdEmprestado(), emprestimo.getDataEntrega(), emprestimo.getObsEntrega() });

		setListaDevolucao(dDao.listarTodasDevolucoes(emprestimo.getId()));

		int val = getListaDevolucao().size();
		int inc = 0;

		if (val == 0) {
			lblSemDevoluo.setVisible(true);
			sp_Devolucao.setVisible(false);
		} else {
			lblSemDevoluo.setVisible(false);
			sp_Devolucao.setVisible(true);
			DefaultTableModel tabelaBd = (DefaultTableModel) tb_Devolucao.getModel();
			tabelaBd.setNumRows(0);
			// Mostra os Emprestimos na tela
			while (val > 0) {
				dev = getListaDevolucao().get(inc);

				tabelaBd.addRow(new Object[] { dev.getId(), dev.getQtdDevolvida(), dev.getDataDevolucao(),
						dev.getAdminRecebe().getNome(), dev.getObsDevolucao() });

				val--;
				inc++;
				dev = new Devolucao();

			}

		}
	}

	public List<Devolucao> getListaDevolucao() {
		return listaDevolucao;
	}

	public void setListaDevolucao(List<Devolucao> listaDevolucao) {
		this.listaDevolucao = listaDevolucao;
	}

}
