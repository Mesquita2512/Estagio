package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import config.Numeros;
import entity.Material;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Cadastro_Materiais {

	private JFrame frmCadastroDeMateriais;
	private JTextField txt_Descricao;
	private JTextField txt_Quantidade;
	private JTextField txt_Val_aprox;
	private JTextField txt_Est_conservacao;
	private JButton btn_Salvar;
	private JButton btn_Limpar;
	private JButton btn_Voltar;
	private JButton btnSair;

	Controla_views control_view = new Controla_views();
	Material material = new Material();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Materiais window = new Cadastro_Materiais();
					window.frmCadastroDeMateriais.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro_Materiais() {
		initialize();
		txt_Quantidade.setDocument(new Numeros());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeMateriais = new JFrame();
		frmCadastroDeMateriais.setTitle("Cadastro de Materiais");
		frmCadastroDeMateriais.setBounds(100, 100, 600, 450);
		frmCadastroDeMateriais.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Cadastro de materiais");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1 = new JLabel("Quantidade");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Valor aproximado");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Estado de conserva\u00E7\u00E3o");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Descricao = new JTextField();
		txt_Descricao.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setColumns(10);

		txt_Val_aprox = null;
		try {
			txt_Val_aprox = new JFormattedTextField(new MaskFormatter("####.##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txt_Val_aprox.setColumns(10);

		txt_Est_conservacao = new JTextField();
		txt_Est_conservacao.setColumns(10);

		btn_Salvar = new JButton("Salvar");
		btn_Salvar.setBackground(new Color(34, 139, 34));
		btn_Salvar.setForeground(new Color(0, 0, 0));
		btn_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_Limpar = new JButton("Limpar");
		btn_Limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_Descricao.setText("");
				txt_Est_conservacao.setText("");
				txt_Quantidade.setText("");
				txt_Val_aprox.setText("");
				
			}
		});
		btn_Limpar.setBackground(new Color(0, 191, 255));
		btn_Limpar.setForeground(new Color(0, 0, 0));
		btn_Limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				control_view.abreTelaPrincipal();
				getFrmCadastroDeMateriais().setVisible(false);
				
			}
		});
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setForeground(new Color(0, 0, 0));
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_view.fecharSistema();
				getFrmCadastroDeMateriais().setVisible(false);

			}
		});
		btnSair.setBackground(new Color(255, 69, 0));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeMateriais.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(73)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btn_Salvar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86,
												Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18).addGroup(
										groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, 272,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_Val_aprox, GroupLayout.PREFERRED_SIZE, 272,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_Descricao, 272, 272, 272)
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
																.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE,
																		93, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE,
																		77, GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(btnSair,
																		GroupLayout.PREFERRED_SIZE, 67,
																		GroupLayout.PREFERRED_SIZE))
														.addComponent(txt_Est_conservacao, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 272,
																GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(77, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(29).addComponent(lblNewLabel).addGap(27)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1).addComponent(txt_Descricao,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Val_aprox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Est_conservacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btn_Salvar)
						.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(101, Short.MAX_VALUE)));
		frmCadastroDeMateriais.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmCadastroDeMateriais() {
		return frmCadastroDeMateriais;
	}

	public void setFrmCadastroDeMateriais(JFrame frmCadastroDeMateriais) {
		this.frmCadastroDeMateriais = frmCadastroDeMateriais;
	}

}
