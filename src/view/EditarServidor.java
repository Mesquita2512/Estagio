package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import config.Numeros;
import dao.ServidorDao;
import entity.Servidor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class EditarServidor {

	private JFrame frmEditarServidor;
	private JTextField txt_Nom_Servidor;
	private JTextField txt_Siape_Servidor;
	private JTextField txt_Email_Servidor;

	Controla_views control_View = new Controla_views();
	Login login = new Login();
	Servidor servidor = new Servidor();
	ServidorDao sDao = new ServidorDao();
	private JLabel lblNewLabel;
	private JLabel ln_Nome_Servidor;
	private JLabel lb_Siape_Servidor;
	private JLabel lb_Email_Servidor;
	private JButton btn_Atualizar;
	private JButton btn_Voltar;
	private JButton btn_Sair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarServidor window = new EditarServidor();
					window.frmEditarServidor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Verifica se Existe Servidor cadastrado com o Siape informado
	public Servidor buscaServSiapeCadastro(long siape) {
		Servidor servidor = new Servidor();
		servidor = sDao.buscarPorSiape(siape);
		return servidor;
	}

	/**
	 * Create the application.
	 */
	public EditarServidor() {
		initialize();
		txt_Siape_Servidor.setDocument(new Numeros());
		frmEditarServidor.getContentPane().setLayout(null);
		frmEditarServidor.getContentPane().add(lblNewLabel);
		frmEditarServidor.getContentPane().add(ln_Nome_Servidor);
		frmEditarServidor.getContentPane().add(lb_Siape_Servidor);
		frmEditarServidor.getContentPane().add(txt_Nom_Servidor);
		frmEditarServidor.getContentPane().add(txt_Siape_Servidor);
		frmEditarServidor.getContentPane().add(lb_Email_Servidor);
		frmEditarServidor.getContentPane().add(txt_Email_Servidor);
		frmEditarServidor.getContentPane().add(btn_Atualizar);
		frmEditarServidor.getContentPane().add(btn_Voltar);
		frmEditarServidor.getContentPane().add(btn_Sair);
	}

	public void pegaServidor(Servidor servidor) {

		txt_Siape_Servidor.setText(servidor.getSiape() + "");
		txt_Nom_Servidor.setText(servidor.getNome());
		txt_Email_Servidor.setText(servidor.getEmail());

		this.servidor = servidor;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarServidor = new JFrame();
		frmEditarServidor.setIconImage(Toolkit.getDefaultToolkit().getImage(EditarServidor.class.getResource("/imagens/Icon_ServidorPQ.png")));
		frmEditarServidor.getContentPane().setBackground(new Color(240, 255, 255));
		frmEditarServidor.setTitle("Cadastro de Servidor");
		frmEditarServidor.setBounds(100, 100, 600, 350);

		frmEditarServidor.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmEditarServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmEditarServidor.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});

		lblNewLabel = new JLabel("Editar Servidor");
		lblNewLabel.setBounds(94, 39, 414, 55);
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));

		ln_Nome_Servidor = new JLabel("Nome *");
		ln_Nome_Servidor.setBounds(96, 165, 48, 17);
		ln_Nome_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Siape_Servidor = new JLabel("Siape *");
		lb_Siape_Servidor.setBounds(94, 124, 56, 17);
		lb_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lb_Email_Servidor = new JLabel("Email *");
		lb_Email_Servidor.setBounds(94, 209, 56, 17);
		lb_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));

		txt_Nom_Servidor = new JTextField();
		txt_Nom_Servidor.setBounds(154, 162, 354, 23);
		txt_Nom_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Nom_Servidor.setColumns(10);

		txt_Siape_Servidor = new JTextField();
		txt_Siape_Servidor.setEditable(false);
		txt_Siape_Servidor.setBounds(154, 121, 354, 23);
		txt_Siape_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Siape_Servidor.setColumns(10);

		txt_Email_Servidor = new JTextField();
		txt_Email_Servidor.setBounds(154, 203, 354, 23);
		txt_Email_Servidor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Email_Servidor.setColumns(10);

		btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.setBounds(94, 255, 129, 25);
		btn_Atualizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// verica o nome do servidor
				String nome = getTxt_Nom_Servidodr().getText().trim();
				if (nome.equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o nome do Servidor");
					txt_Nom_Servidor.setText("");
					return;
				}

				// verifica o email do Servidor
				String email = getTxt_Email_Servidor().getText().trim();
				int position = email.indexOf("@");
				// Verifica se o email tem texto antes e depois do "@" considera 3 caracteres
				// antes e 5 depois
				try {
					email.substring(position + 1, position + 6);
					email.substring(position - 3, position - 1);

				} catch (Exception r) {
					JOptionPane.showMessageDialog(null, "Informe o Email do Servidor no formato Maria@maria.com");
					return;
				}

				servidor.setNome(nome.toUpperCase());
				servidor.setEmail(email.toUpperCase());

				sDao.atualizar(servidor);
				getFrmEditarServidor().dispose();
				control_View.abreTelaServidor();
				JOptionPane.showMessageDialog(null, "Servidor atualizado com sucesso!!!");

			}
		});
		btn_Atualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Atualizar.setBackground(new Color(34, 139, 34));

		btn_Voltar = new JButton("Voltar");
		btn_Voltar.setBounds(276, 255, 91, 25);
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaServidor();
				getFrmEditarServidor().dispose();

			}
		});
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));

		btn_Sair = new JButton("Logout");
		btn_Sair.setBounds(417, 255, 91, 25);
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control_View.fecharSistema() == true) {
					getFrmEditarServidor().dispose();
				}

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
	}

	public JFrame getFrmEditarServidor() {
		return frmEditarServidor;
	}

	public void setFrmEditarServidor(JFrame frmEditarServidor) {
		this.frmEditarServidor = frmEditarServidor;
	}

	public JTextField getTxt_Nom_Servidodr() {
		return txt_Nom_Servidor;
	}

	public void setTxt_Nom_Servidodr(JTextField txt_Nom_Servidodr) {
		this.txt_Nom_Servidor = txt_Nom_Servidodr;
	}

	public JTextField getTxt_Siape_Servidor() {
		return txt_Siape_Servidor;
	}

	public void setTxt_Siape_Servidor(JTextField txt_Siape_Servidor) {
		this.txt_Siape_Servidor = txt_Siape_Servidor;
	}

	public JTextField getTxt_Email_Servidor() {
		return txt_Email_Servidor;
	}

	public void setTxt_Email_Servidor(JTextField txt_Email_Servidor) {
		this.txt_Email_Servidor = txt_Email_Servidor;
	}

}
