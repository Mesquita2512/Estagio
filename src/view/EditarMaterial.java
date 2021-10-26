package view;

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
import java.util.List;
import java.awt.event.ActionEvent;

public class EditarMaterial {

	private JFrame frmEditarMaterial;
	private JTextField txt_Codigo;
	private JTextField txt_Descricao;
	private JTextField txt_Quantidade;
	private JTextField txt_Val_aprox;
	private JTextField txt_Est_conservacao;
	private JButton btn_Atualizar;
	private JButton btn_Voltar;
	private JButton btn_Sair;

	private List<Material> listaDeMateriais;
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
					EditarMaterial window = new EditarMaterial();
					window.frmEditarMaterial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditarMaterial() {
		initialize();
		txt_Quantidade.setDocument(new Numeros());
		txt_Val_aprox.setDocument(new config.DoubleMonterario());

	}

	public void pegaMaterial(Material mate) {

		txt_Codigo.setText(mate.getId() + "");
		txt_Descricao.setText(mate.getDescricao());
		txt_Est_conservacao.setText(mate.getEst_conservacao());
		txt_Quantidade.setText(mate.getQtd() + "");
		txt_Val_aprox.setText(mate.getVal_estimado() + "");

		material = mate;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarMaterial = new JFrame();
		frmEditarMaterial.setTitle("Cadastro de Materiais");
		frmEditarMaterial.setBounds(100, 100, 600, 450);
		frmEditarMaterial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblNewLabel = new JLabel("Editar material");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		JLabel lb_Desc_Material = new JLabel("Nova descrição");
		lb_Desc_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_Qtd_Material = new JLabel("Nova quantidade");
		lb_Qtd_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_Val_Material = new JLabel("Valor aproximado");
		lb_Val_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_EstCons_Material = new JLabel("Estado de conserva\u00E7\u00E3o");
		lb_EstCons_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Descricao = new JTextField();
		txt_Descricao.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setColumns(10);

		txt_Val_aprox = new JTextField();
		txt_Val_aprox.setColumns(10);

		txt_Est_conservacao = new JTextField();
		txt_Est_conservacao.setColumns(10);

		btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.setBackground(new Color(34, 139, 34));
		btn_Atualizar.setForeground(new Color(0, 0, 0));
		btn_Atualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int qtdCarateres = 0;
				int qtdPontos = 0;

				material.setDescricao(txt_Descricao.getText());

				if (txt_Quantidade.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "informe um valor válido");
					return;
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

				if (material.getDescricao().equalsIgnoreCase("")) {
					txt_Quantidade.setText(material.getQtd() + "");
					JOptionPane.showMessageDialog(null, "A descrição do material deve ser informada");
				} else {

					mDao.atualizar(material);
					control_view.abreTelaMateriais();
					getFrmEditarMaterial().dispose();
					material = new Material();
					JOptionPane.showMessageDialog(null, "Material Atualizado com sucesso!!!");
				}

			}
		});

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_view.abreTelaMateriais();
				getFrmEditarMaterial().dispose();

			}
		});
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setForeground(new Color(0, 0, 0));
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_view.fecharSistema();
				getFrmEditarMaterial().setVisible(false);

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lb_Cod_Material = new JLabel("Código Material");
		lb_Cod_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Codigo = new JTextField();
		txt_Codigo.setEditable(false);
		txt_Codigo.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmEditarMaterial.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lb_Desc_Material, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lb_Qtd_Material, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86,
										Short.MAX_VALUE)
								.addComponent(lb_Val_Material, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lb_EstCons_Material, Alignment.LEADING).addComponent(lb_Cod_Material,
										Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_Codigo, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, 272,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Val_aprox, GroupLayout.PREFERRED_SIZE, 272,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Descricao, 272, 272, 272).addComponent(txt_Est_conservacao,
										GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(73).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btn_Atualizar, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addGap(49)
										.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 110,
												GroupLayout.PREFERRED_SIZE)
										.addGap(39).addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(78, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(29).addComponent(lblNewLabel).addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_Cod_Material, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Codigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lb_Desc_Material)
								.addComponent(txt_Descricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_Qtd_Material, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_Val_Material, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Val_aprox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lb_EstCons_Material, GroupLayout.PREFERRED_SIZE, 17,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_Est_conservacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(57)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Atualizar)
								.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(45, Short.MAX_VALUE)));
		frmEditarMaterial.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmEditarMaterial() {
		return frmEditarMaterial;
	}

	public void setFrmEditarMaterial(JFrame frmEditarMaterial) {
		this.frmEditarMaterial = frmEditarMaterial;
	}

	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}
}
