package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import config.Numeros;
import dao.MaterialDao;
import entity.Material;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
	private JButton btn_Sair;

	Controla_views control_view = new Controla_views();
	Material material = new Material();
	MaterialDao mDao = new MaterialDao();

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
		txt_Val_aprox.setDocument(new config.DoubleMonterario());
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

		txt_Val_aprox = new JTextField();
		txt_Val_aprox.setColumns(10);

		txt_Est_conservacao = new JTextField();
		txt_Est_conservacao.setColumns(10);

		btn_Salvar = new JButton("Salvar");
		btn_Salvar.setBackground(new Color(34, 139, 34));
		btn_Salvar.setForeground(new Color(0, 0, 0));
		btn_Salvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int qtdCarateres = 0;
				int qtdPontos = 0;

				material.setDescricao(txt_Descricao.getText());

				if (txt_Quantidade.getText().equals("")) {
					material.setQtd(0);
					txt_Quantidade.setText("");
				} else {
					material.setQtd(Integer.parseInt(txt_Quantidade.getText()));
					txt_Quantidade.setText("");
				}

				if (txt_Val_aprox.getText().equals("")) {
					material.setVal_estimado(0);
					txt_Val_aprox.setText("");

					// Tratar o double para nao ter mais de um ponto
				} else if (txt_Val_aprox.getText().contains(".")) {

					while (qtdCarateres < txt_Val_aprox.getText().length()) {
						if (txt_Val_aprox.getText().substring(qtdCarateres, qtdCarateres + 1).equals(".")) {
							qtdPontos++;

						}
						qtdCarateres++;
					}
					if (qtdPontos > 1) {
						JOptionPane.showMessageDialog(null, "Informe um valor válido");
						return;
					}

				}

				else {

					material.setVal_estimado(Double.parseDouble(txt_Val_aprox.getText()));
					txt_Val_aprox.setText("");
				}

				material.setEst_conservacao(txt_Est_conservacao.getText());

				material.setQtd_emprestado(0);

				if (material.getDescricao().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "A descrição do material deve ser informada");
				} else if (material.getQtd() <= 0) {
					JOptionPane.showMessageDialog(null, "A quantidade de material deve ser superior a zero!!!");
				} else if (mDao.Salvar(material)) {
					txt_Descricao.setText("");
					txt_Est_conservacao.setText("");
					material = new Material();
					JOptionPane.showMessageDialog(null, "Material salvo com sucesso!!!");
				}

			}
		});

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

		btn_Sair = new JButton("Sair");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_view.fecharSistema();
				getFrmCadastroDeMateriais().setVisible(false);

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
																.addGap(18).addComponent(btn_Sair,
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
						.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
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
