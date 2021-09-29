package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.MaterialDao;
import entity.Material;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BuscarMaterial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoNome;
	private JTable tb_Material;

	private List<Material> listaDeMateriais;
	MaterialDao mDao = new MaterialDao();
	Material mat = new Material();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarMaterial dialog = new BuscarMaterial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarMaterial() {
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("Buscar Material");
		getContentPane().add(contentPanel, BorderLayout.WEST);

		JLabel lblBuscarMaterial = new JLabel("Buscar Material");
		lblBuscarMaterial.setForeground(new Color(0, 0, 205));
		lblBuscarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JLabel lblCdigoOuNome = new JLabel("C\u00F3digo ou Nome");
		lblCdigoOuNome.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txtCodigoNome = new JTextField();
		txtCodigoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoNome.setColumns(10);

		JButton btnBuscarMaterial = new JButton("Buscar");
		btnBuscarMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtCodigoNome.getText().equals("")) {

					MaterialDao mDao = new MaterialDao();
					Material mat = new Material();

					BuscarMaterial bm = new BuscarMaterial();
					bm.setListaDeMateriais(mDao.getListaMaterial());

					int val = bm.getListaDeMateriais().size();
					int inc = 0;

					DefaultTableModel tabelaBd = (DefaultTableModel) tb_Material.getModel();
					tabelaBd.setNumRows(0);

					while (val > 0) {
						mat = bm.getListaDeMateriais().get(inc);

						tabelaBd.addRow(new Object[] { mat.getId(), mat.getDescricao(), mat.getQtd(),
								mat.getQtd_emprestado(), mat.getVal_estimado(), mat.getEst_conservacao() });

						val--;
						inc++;

					}

				} else {
					JOptionPane.showConfirmDialog(null, "Vamos buscar alguma coisa");
				}

			}
		});
		btnBuscarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addGap(57).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBuscarMaterial, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
								.addGroup(
										gl_contentPanel.createSequentialGroup().addComponent(lblCdigoOuNome).addGap(18)
												.addComponent(txtCodigoNome, GroupLayout.PREFERRED_SIZE, 230,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnBuscarMaterial))))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(11).addComponent(lblBuscarMaterial).addGap(29)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(lblCdigoOuNome))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodigoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscarMaterial)))
				.addGap(31).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
				.addGap(25)));

		tb_Material = new JTable();
		tb_Material.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Descri\u00E7\u00E3o",
				"Qtd Estoque", "Qtd Emprestada", "Valor (R$)", "Estado Conserva\u00E7\u00E3o" }));
		scrollPane.setViewportView(tb_Material);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String capta = tb_Material.getValueAt(tb_Material.getSelectedRow(), 0).toString();
						int captaId = Integer.parseInt(capta);

						mat = mDao.buscarPorId(captaId);
		
						dispose();

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
	}

	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

}
