package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
	Controla_views control_View = new Controla_views();
	Material material = new Material();
	MaterialDao mDao = new MaterialDao();
	private JLabel lb_Desc_Material;
	private JLabel lb_Qtd_Material;
	private JLabel lb_Val_Material;
	private JLabel lb_EstCons_Material;
	private JLabel lb_Cod_Material;
	private JLabel lblNewLabel;

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
		frmEditarMaterial.getContentPane().setLayout(null);
		frmEditarMaterial.getContentPane().add(lb_Desc_Material);
		frmEditarMaterial.getContentPane().add(lb_Qtd_Material);
		frmEditarMaterial.getContentPane().add(lb_Val_Material);
		frmEditarMaterial.getContentPane().add(lb_EstCons_Material);
		frmEditarMaterial.getContentPane().add(lb_Cod_Material);
		frmEditarMaterial.getContentPane().add(txt_Codigo);
		frmEditarMaterial.getContentPane().add(txt_Quantidade);
		frmEditarMaterial.getContentPane().add(txt_Val_aprox);
		frmEditarMaterial.getContentPane().add(txt_Descricao);
		frmEditarMaterial.getContentPane().add(txt_Est_conservacao);
		frmEditarMaterial.getContentPane().add(lblNewLabel);
		frmEditarMaterial.getContentPane().add(btn_Atualizar);
		frmEditarMaterial.getContentPane().add(btn_Voltar);
		frmEditarMaterial.getContentPane().add(btn_Sair);

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
		frmEditarMaterial.getContentPane().setBackground(new Color(240, 255, 255));
		frmEditarMaterial.setTitle("Cadastro de Materiais");
		frmEditarMaterial.setBounds(100, 100, 600, 450);
		frmEditarMaterial.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		lblNewLabel = new JLabel("Editar material");
		lblNewLabel.setBounds(73, 29, 290, 55);
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		lb_Desc_Material = new JLabel("Nova descrição");
		lb_Desc_Material.setBounds(73, 153, 143, 17);
		lb_Desc_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Qtd_Material = new JLabel("Nova quantidade");
		lb_Qtd_Material.setBounds(73, 191, 143, 17);
		lb_Qtd_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Val_Material = new JLabel("Valor aproximado");
		lb_Val_Material.setBounds(73, 229, 143, 17);
		lb_Val_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_EstCons_Material = new JLabel("Estado de conserva\u00E7\u00E3o");
		lb_EstCons_Material.setBounds(73, 267, 143, 17);
		lb_EstCons_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Descricao = new JTextField();
		txt_Descricao.setBounds(234, 153, 272, 20);
		txt_Descricao.setColumns(10);

		txt_Quantidade = new JTextField();
		txt_Quantidade.setBounds(234, 191, 272, 20);
		txt_Quantidade.setColumns(10);

		txt_Val_aprox = new JTextField();
		txt_Val_aprox.setBounds(234, 229, 272, 20);
		txt_Val_aprox.setColumns(10);

		txt_Est_conservacao = new JTextField();
		txt_Est_conservacao.setBounds(234, 267, 272, 20);
		txt_Est_conservacao.setColumns(10);

		btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.setBounds(73, 344, 143, 25);
		btn_Atualizar.setBackground(new Color(34, 139, 34));
		btn_Atualizar.setForeground(new Color(0, 0, 0));
		btn_Atualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int qtdCarateres = 0;
				int qtdPontos = 0;

				// tratando a descrição
				String descricao = txt_Descricao.getText().trim();
				if (descricao.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe A descrição do material");
					txt_Descricao.setText("");
					return;
				}

				// tratando a quantidade
				int quant = Integer.parseInt(txt_Quantidade.getText().trim());
				// verifica se a quantidade é menor ou igual a zero
				if (quant <= 0) {
					JOptionPane.showMessageDialog(null, "A quantidade de material deve ser superior a zero!!!");
					txt_Quantidade.setText("");
					return;
				}

				// tratando o valor aproximado
				String valAprox = txt_Val_aprox.getText().trim();
				if (valAprox.equals("")) {
					JOptionPane.showMessageDialog(null, "O valor do material é obrigatório");
					txt_Val_aprox.setText("");
					return;
				}

				// Tratar o double para nao ter mais de um ponto
				if (txt_Val_aprox.getText().contains(".")) {

					while (qtdCarateres < txt_Val_aprox.getText().length()) {
						if (txt_Val_aprox.getText().substring(qtdCarateres, qtdCarateres + 1).equals(".")) {
							qtdPontos++;

						}
						qtdCarateres++;
					}
					if (qtdPontos > 1) {
						JOptionPane.showMessageDialog(null, "Informe um valor válido");
						txt_Val_aprox.setText("");
						return;
					}

				}

				// tratando o campo de observações
				String estCons = txt_Est_conservacao.getText().trim();
				if (estCons.equals("")) {
					JOptionPane.showMessageDialog(null, "O estado de conservação do material é obrigatório");
					txt_Est_conservacao.setText("");
					return;
				}

				material.setDescricao(descricao.toUpperCase());
				material.setQtd(Integer.parseInt(txt_Quantidade.getText()));
				material.setVal_estimado(Double.parseDouble(txt_Val_aprox.getText()));
				material.setEst_conservacao(estCons.toUpperCase());

				mDao.atualizar(material);
				txt_Descricao.setText("");
				txt_Quantidade.setText("");
				txt_Est_conservacao.setText("");
				txt_Val_aprox.setText("");
				material = new Material();

				getFrmEditarMaterial().dispose();
				control_View.abreTelaMateriais();
				JOptionPane.showMessageDialog(null, "Material Editado com sucesso!!!");

			}
		});

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.setBounds(265, 344, 110, 25);
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaMateriais();
				getFrmEditarMaterial().dispose();

			}
		});
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setForeground(new Color(0, 0, 0));
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(414, 344, 92, 25);
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_View.fecharSistema() == true) {
					getFrmEditarMaterial().dispose();
				}

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Cod_Material = new JLabel("Código Material");
		lb_Cod_Material.setBounds(73, 115, 143, 17);
		lb_Cod_Material.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Codigo = new JTextField();
		txt_Codigo.setBounds(234, 115, 272, 20);
		txt_Codigo.setEditable(false);
		txt_Codigo.setColumns(10);
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
