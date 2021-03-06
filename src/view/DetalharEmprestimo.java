package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.DevolucaoDao;
import entity.Devolucao;
import entity.Emprestimo;
import views_Relatorios.Controla_Relatorios;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DetalharEmprestimo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tb_emprestimo;
	private JTable tb_Devolucao;

	Controla_views control_Views = new Controla_views();
	Controla_Relatorios control_Rel = new Controla_Relatorios();

	Devolucao dev = new Devolucao();
	DevolucaoDao dDao = new DevolucaoDao();
	private List<Devolucao> listaDevolucao;

	JScrollPane sp_Devolucao = new JScrollPane();
	JLabel lblSemDevoluo = new JLabel("Sem Devolução");

	String quemchamou = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DetalharEmprestimo dialog = new DetalharEmprestimo();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("serial")
	public DetalharEmprestimo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DetalharEmprestimo.class.getResource("/imagens/Icon_Devolver.png")));
		setTitle("Detalhes do Emprétimo");
		setForeground(new Color(240, 255, 255));
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					dispose();
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

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
			tb_emprestimo.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null, null},
				},
				new String[] {
					"C\u00F3digo", "Entregue por", "Entregue A", "Material", "Qtd Emprestada", "Data Entrega", "Hora Emprestimo", "Observa\u00E7\u00F5es"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tb_emprestimo.getColumnModel().getColumn(0).setResizable(false);
			tb_emprestimo.getColumnModel().getColumn(0).setPreferredWidth(50);
			tb_emprestimo.getColumnModel().getColumn(1).setPreferredWidth(100);
			tb_emprestimo.getColumnModel().getColumn(2).setPreferredWidth(100);
			tb_emprestimo.getColumnModel().getColumn(3).setPreferredWidth(140);
			tb_emprestimo.getColumnModel().getColumn(4).setResizable(false);
			tb_emprestimo.getColumnModel().getColumn(4).setPreferredWidth(60);
			tb_emprestimo.getColumnModel().getColumn(5).setResizable(false);
			tb_emprestimo.getColumnModel().getColumn(6).setResizable(false);
			tb_emprestimo.getColumnModel().getColumn(7).setPreferredWidth(100);
			sp_Empretimos.setViewportView(tb_emprestimo);
		}
		{
			sp_Devolucao.setVisible(false);
			sp_Devolucao.setBounds(25, 131, 737, 86);
			contentPanel.add(sp_Devolucao);
			{
				tb_Devolucao = new JTable();
				tb_Devolucao.setModel(
						new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
					},
					new String[] {
						"C\u00F3digo", "Qtd Devolucao", "Data Devolucao", "Hora recebimento", "Quem recebeu", "Observa\u00E7\u00F5es"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				tb_Devolucao.getColumnModel().getColumn(0).setResizable(false);
				tb_Devolucao.getColumnModel().getColumn(0).setPreferredWidth(50);
				tb_Devolucao.getColumnModel().getColumn(1).setResizable(false);
				tb_Devolucao.getColumnModel().getColumn(1).setPreferredWidth(55);
				tb_Devolucao.getColumnModel().getColumn(2).setResizable(false);
				tb_Devolucao.getColumnModel().getColumn(3).setResizable(false);
				tb_Devolucao.getColumnModel().getColumn(4).setPreferredWidth(150);
				tb_Devolucao.getColumnModel().getColumn(5).setPreferredWidth(150);
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
						if (quemchamou == "principal") {
							dispose();
							control_Views.abreTelaPrincipal();
						} else {
							dispose();
						}

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
						if (quemchamou == "principal") {
							dispose();
							control_Views.abreTelaPrincipal();
						} else {
							dispose();
						}
					}
				});
				cancelButton.setBackground(new Color(255, 255, 204));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void pegaEmprestimo(Emprestimo emprestimo) {
		// formatando a data do emprestimo
		Date DataFormatada = emprestimo.getDataEntrega();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatador.format(DataFormatada);

		// formatando a hora da devolução
		int hora1 = emprestimo.getHoraEntrega().get(Calendar.HOUR_OF_DAY);
		int minutos1 = emprestimo.getHoraEntrega().get(Calendar.MINUTE);
		String min1 = minutos1 + "";
		String horaformatada1;
		if (min1.length() == 1) {
			horaformatada1 = hora1 + ":0" + minutos1;
		} else {
			horaformatada1 = hora1 + ":" + minutos1;
		}
		if (hora1 < 12) {
			horaformatada1 = horaformatada1 + " AM";
		}

		DefaultTableModel tabelaEmpr = (DefaultTableModel) tb_emprestimo.getModel();
		tabelaEmpr.setNumRows(0);
		tabelaEmpr.addRow(new Object[] { emprestimo.getId(), emprestimo.getAdminEntrega().getNome(),
				emprestimo.getServidor().getNome(), emprestimo.getMaterial().getDescricao(),
				emprestimo.getQtdEmprestado(), data, horaformatada1, emprestimo.getObsEntrega() });

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

				// formatando a data da devolução
				Date DataFormatada1 = dev.getDataDevolucao();
				SimpleDateFormat formatador1 = new SimpleDateFormat("dd/MM/yyyy");
				String data1 = formatador1.format(DataFormatada1);

				// formatando a hora da devolução
				int hora = dev.getLocalDate().get(Calendar.HOUR_OF_DAY);
				int minutos = dev.getLocalDate().get(Calendar.MINUTE);
				String min = minutos + "";
				String horaformatada;
				if (min.length() == 1) {
					horaformatada = hora + ":0" + minutos;
				} else {
					horaformatada = hora + ":" + minutos;
				}
				if (hora < 12) {
					horaformatada = horaformatada + " AM";
				}

				tabelaBd.addRow(new Object[] { dev.getId(), dev.getQtdDevolvida(), data1, horaformatada,
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
