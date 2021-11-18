package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import config.Numeros;
import dao.AdminDao;
import entity.Admin;
import fabricaConexao.FabricaJpa;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login {

	private JFrame frmTelaLogin;
	private JTextField txtSiape;
	private JPasswordField txtSenha;

	Controla_views control_View = new Controla_views();
	AdminDao adao = new AdminDao();
	Admin admin = new Admin();

	int siape;
	private JLabel lblLogin;
	private JButton btn_Entrar;
	private JLabel lblSiape;
	private JLabel lblSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login windowLogin = new Login();
					windowLogin.frmTelaLogin.setVisible(true);
					windowLogin.frmTelaLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		txtSiape.setDocument(new Numeros());
		frmTelaLogin.getContentPane().setLayout(null);
		frmTelaLogin.getContentPane().add(lblLogin);
		frmTelaLogin.getContentPane().add(btn_Entrar);
		frmTelaLogin.getContentPane().add(lblSiape);
		frmTelaLogin.getContentPane().add(lblSenha);
		frmTelaLogin.getContentPane().add(txtSiape);
		frmTelaLogin.getContentPane().add(txtSenha);

		try {
			FabricaJpa.getEntityManagerFactory().createEntityManager();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaLogin = new JFrame();
		frmTelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaLogin.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaLogin.setResizable(false);
		frmTelaLogin.setBackground(Color.PINK);
		frmTelaLogin.setTitle("Tela Login");
		frmTelaLogin.setBounds(100, 100, 400, 300);
	
		txtSiape = new JTextField(15);
		txtSiape.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_Entrar.doClick();
				}
			}
		});
		txtSiape.setBounds(160, 119, 153, 20);
		txtSiape.setColumns(10);

		btn_Entrar = new JButton("ENTRAR");
		btn_Entrar.setBounds(67, 203, 246, 31);
		btn_Entrar.setBackground(new Color(0, 250, 154));

		btn_Entrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_Entrar.doClick();
				}
			}
		});

		btn_Entrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int siape1 = 0;
				if (txtSiape.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Siape não pode ser nulo!!!");
					return;
				}

				String verificaSenhaNula = new String(txtSenha.getPassword()).trim();

				if (verificaSenhaNula.equals("")) {
					JOptionPane.showMessageDialog(null, "Senha não pode ser nula!!!");
					return;
				}
				try {
					siape1 = Integer.parseInt(txtSiape.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Siape fora do padrão");
					return;
				}

				admin = adao.buscarPorSiape(siape1);

				if (admin == null) {
					JOptionPane.showMessageDialog(null, "Siape Inválido!!!");
					txtSiape.setText("");
					txtSenha.setText("");
					return;
				}
				if (admin.isStatusAtivo() == "Inativo") {
					JOptionPane.showMessageDialog(null, "Você nao pode acessar o sistema, consulte seu supervisor");
					return;
				}
				if (admin.getSiape() == Integer.parseInt(txtSiape.getText())
						&& admin.getSenha().equals(verificaSenhaNula)) {

					String siape = String.valueOf(admin.getSiape());
					System.setProperty("siape", siape);// Salva o Siape do Administrador para uso posterior

					control_View.abreTelaPrincipal();
					getFrmTelaLogin().dispose();

				} else {
					JOptionPane.showMessageDialog(null, "Senha Inválida!!!");

				}

			}
		});

		lblSiape = new JLabel("Siape");
		lblSiape.setBounds(67, 118, 34, 19);
		lblSiape.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(67, 153, 37, 19);
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		lblLogin = new JLabel("");
		lblLogin.setText(
				"<html><p style=\"width:200px; text-align: justify\">Sistema de Gerenciamento e controle de empréstimos de materiais</p></html>");
		lblLogin.setBounds(67, 11, 260, 96);
		lblLogin.setForeground(new Color(72, 61, 139));
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 21));

		txtSenha = new JPasswordField();
		txtSenha.setBounds(160, 154, 153, 20);
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_Entrar.doClick();
				}
			}
		});
	}

	public JFrame getFrmTelaLogin() {
		return frmTelaLogin;
	}

	public void setFrmTelaLogin(JFrame frmTelaLogin) {
		this.frmTelaLogin = frmTelaLogin;
	}

	public JTextField getTxtSiape() {
		return txtSiape;
	}

	public void setTxtSiape(JTextField txtSiape) {
		this.txtSiape = txtSiape;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}
}
