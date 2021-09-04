package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Cadastro_Emprestimo {

	private JFrame frmNovoEmprestimo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Emprestimo window = new Cadastro_Emprestimo();
					window.frmNovoEmprestimo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro_Emprestimo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNovoEmprestimo = new JFrame();
		frmNovoEmprestimo.setResizable(false);
		frmNovoEmprestimo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 45));
		frmNovoEmprestimo.setTitle("Novo Emprestimo");
		frmNovoEmprestimo.setBounds(100, 100, 600, 450);
		frmNovoEmprestimo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCadastrarEmprstimo = new JLabel("Cadastrar Empr\u00E9stimo");
		lblCadastrarEmprstimo.setForeground(new Color(0, 0, 139));
		lblCadastrarEmprstimo.setFont(new Font("Tahoma", Font.PLAIN, 45));
		
		JLabel lblNewLabel = new JLabel("\u00CDtem/Material");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Entregue a");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2 = new JLabel("Data");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_3 = new JLabel("Observa\u00E7\u00F5es");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setForeground(Color.BLACK);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(0, 191, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBackground(new Color(240, 230, 140));
		
		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setBackground(new Color(255, 69, 0));
		
		JButton btnBuscar = new JButton("buscar materiais");
		btnBuscar.setBackground(new Color(240, 230, 140));
		
		JButton btnBuscarServidores = new JButton("buscar servidores");
		btnBuscarServidores.setBackground(new Color(240, 230, 140));
		
		JTextArea textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(frmNovoEmprestimo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCadastrarEmprstimo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1_2)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_1_1))
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_1_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnNewButton_1)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnNewButton_3)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnBuscarServidores, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnBuscar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))))
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))))
					.addGap(79))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCadastrarEmprstimo)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarServidores))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		frmNovoEmprestimo.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmNovoEmprestimo() {
		return frmNovoEmprestimo;
	}

	public void setFrmNovoEmprestimo(JFrame frmNovoEmprestimo) {
		this.frmNovoEmprestimo = frmNovoEmprestimo;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
	
}
