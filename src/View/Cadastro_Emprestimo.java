package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import config.Numeros;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class Cadastro_Emprestimo {

	private JFrame frmNovoEmprestimo;
	private JTextField txt_Material;
	private JTextField txt_Quantidade;
	private JTextField txt_EntregueA;

	Controla_views control_View = new Controla_views();
	private JTextField txt_Observacoes;

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
		txt_Quantidade.setDocument(new Numeros());
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

		txt_Material = new JTextField();
		txt_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Material.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Quantidade.setColumns(10);

		txt_EntregueA = new JTextField();
		txt_EntregueA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_EntregueA.setColumns(10);

		JButton btn_Salvar = new JButton("SALVAR");
		btn_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Salvar.setBackground(new Color(34, 139, 34));
		btn_Salvar.setForeground(Color.BLACK);

		JButton btn_Limpar = new JButton("Limpar");
		btn_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getTxt_EntregueA().setText("");
				getTxt_Material().setText("");
				getTxt_Quantidade().setText("");
				getTxt_Observacoes().setText("");
				

			}
		});
		btn_Limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Limpar.setBackground(new Color(0, 191, 255));
		btn_Limpar.setForeground(new Color(0, 0, 0));

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmNovoEmprestimo().setVisible(false);

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		JButton btn_Sair = new JButton("Sair");
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control_View.fecharSistema();
				getFrmNovoEmprestimo().setVisible(false);

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));

		JButton btnBuscar = new JButton("buscar materiais");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control_View.abreTelaBuscaMateriais();
				
				
			}
		});
		btnBuscar.setBackground(new Color(240, 230, 140));

		JButton btnBuscarServidores = new JButton("buscar servidores");
		btnBuscarServidores.setBackground(new Color(240, 230, 140));

		JFormattedTextField txt_Data = new JFormattedTextField(new Date());
		txt_Data.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txt_Observacoes = new JTextField();
		txt_Observacoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Observacoes.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmNovoEmprestimo.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCadastrarEmprstimo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
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
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txt_Material, Alignment.LEADING)
										.addComponent(txt_Quantidade, Alignment.LEADING)
										.addComponent(txt_EntregueA, Alignment.LEADING)
										.addComponent(txt_Data, Alignment.LEADING))
									.addGap(101)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnBuscarServidores, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnBuscar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btn_Salvar, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btn_Limpar)
									.addGap(18)
									.addComponent(btn_Voltar, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addGap(14)
									.addComponent(btn_Sair))
								.addComponent(txt_Observacoes, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))))
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
						.addComponent(txt_Material, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(txt_EntregueA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarServidores))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(txt_Data, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(txt_Observacoes, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Salvar)
						.addComponent(btn_Limpar)
						.addComponent(btn_Sair)
						.addComponent(btn_Voltar))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		frmNovoEmprestimo.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmNovoEmprestimo() {
		return frmNovoEmprestimo;
	}

	public void setFrmNovoEmprestimo(JFrame frmNovoEmprestimo) {
		this.frmNovoEmprestimo = frmNovoEmprestimo;
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
	
}
