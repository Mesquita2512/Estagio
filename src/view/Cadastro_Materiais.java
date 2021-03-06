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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

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
		frmCadastroDeMateriais.setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_Materiais.class.getResource("/imagens/Icon_MateriaisPQ.png")));
		frmCadastroDeMateriais.getContentPane().setBackground(new Color(240, 255, 255));
		frmCadastroDeMateriais.setTitle("Cadastro de Materiais");
		frmCadastroDeMateriais.setBounds(100, 100, 600, 400);

		frmCadastroDeMateriais.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
			int conf =	JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");
				
				if(conf == JOptionPane.YES_OPTION) {
					frmCadastroDeMateriais.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					frmCadastroDeMateriais.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
				
			}
		});

		JLabel lblNewLabel = new JLabel("Cadastro de material");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		JLabel lblNewLabel_1 = new JLabel("Descri????o *");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_1 = new JLabel("Quantidade *");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_2 = new JLabel("Valor aproximado *");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblNewLabel_1_3 = new JLabel("Estado de conserva????o *");
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

				// tratando a descri????o
				String descricao = txt_Descricao.getText().trim();
				if (descricao.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe A descri????o do material");
					txt_Descricao.setText("");
					return;
				}

				// tratando a quantidade
				int quant = Integer.parseInt(txt_Quantidade.getText().trim());
				// verifica se a quantidade ?? menor ou igual a zero
				if (quant <= 0) {
					JOptionPane.showMessageDialog(null, "A quantidade de material deve ser superior a zero!!!");
					txt_Quantidade.setText("");
					return;
				}

				// tratando o valor aproximado
				String valAprox = txt_Val_aprox.getText().trim();
				if (valAprox.equals("")) {
					JOptionPane.showMessageDialog(null, "O valor do material ?? obrigat??rio");
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
						JOptionPane.showMessageDialog(null, "Informe um valor v??lido");
						txt_Val_aprox.setText("");
						return;
					}

				}

				// tratndo o campo de observa????es
				String estCons = txt_Est_conservacao.getText().trim();
				if (estCons.equals("")) {
					JOptionPane.showMessageDialog(null, "O estado de conserva????o do material ?? obrigat??rio");
					txt_Est_conservacao.setText("");
					return;
				}
				

				material.setQtd_emprestado(0);
				material.setDescricao(descricao.toUpperCase());
				material.setQtd(Integer.parseInt(txt_Quantidade.getText()));
				material.setVal_estimado(Double.parseDouble(txt_Val_aprox.getText()));
				material.setEst_conservacao(estCons.toUpperCase());

				mDao.Salvar(material);
				txt_Descricao.setText("");
				txt_Quantidade.setText("");
				txt_Est_conservacao.setText("");
				txt_Val_aprox.setText("");
				material = new Material();
				JOptionPane.showMessageDialog(null, "Material salvo com sucesso!!!");

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

				control_view.abreTelaMateriais();
				getFrmCadastroDeMateriais().dispose();

			}
		});
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setForeground(new Color(0, 0, 0));
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_view.fecharSistema() == true) {
					getFrmCadastroDeMateriais().dispose();
				}

			}
		});
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeMateriais.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btn_Salvar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addComponent(txt_Est_conservacao)
								.addComponent(txt_Val_aprox)
								.addComponent(txt_Quantidade)
								.addComponent(txt_Descricao))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txt_Descricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Quantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Val_aprox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_Est_conservacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Salvar)
						.addComponent(btn_Limpar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Sair, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_Voltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		frmCadastroDeMateriais.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmCadastroDeMateriais() {
		return frmCadastroDeMateriais;
	}

	public void setFrmCadastroDeMateriais(JFrame frmCadastroDeMateriais) {
		this.frmCadastroDeMateriais = frmCadastroDeMateriais;
	}

	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}

}
