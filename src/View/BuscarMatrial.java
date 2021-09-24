package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class BuscarMatrial extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable tabelaMateriais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarMatrial dialog = new BuscarMatrial();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarMatrial() {
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("Buscar Material");
		getContentPane().add(contentPanel, BorderLayout.WEST);
		
		JLabel lblBuscarMaterial = new JLabel("Buscar Material");
		lblBuscarMaterial.setForeground(new Color(0, 0, 205));
		lblBuscarMaterial.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JLabel lblCdigoOuNome = new JLabel("C\u00F3digo ou Nome");
		lblCdigoOuNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		tabelaMateriais = new JTable();
		tabelaMateriais.setEnabled(false);
		tabelaMateriais.setCellSelectionEnabled(true);
		tabelaMateriais.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabelaMateriais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		tabelaMateriais.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Qtd Estoque", "Qtd Emprestado", "Valor (R$)"
			}
		));
		tabelaMateriais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tabelaMateriais.setColumnSelectionAllowed(true);
		
		JButton btnBuscarMaterial = new JButton("Buscar");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBuscarMaterial, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCdigoOuNome)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscarMaterial))
						.addComponent(tabelaMateriais, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblBuscarMaterial)
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCdigoOuNome))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(2)
							.addComponent(btnBuscarMaterial)))
					.addGap(81)
					.addComponent(tabelaMateriais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
