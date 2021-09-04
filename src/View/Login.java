package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import config.Numeros;
import dao.AdminDao;
import entity.Admin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmTelaLogin;
	private JTextField txtSiape;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login windowLogin = new Login();
					windowLogin.frmTelaLogin.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaLogin = new JFrame();
		frmTelaLogin.setResizable(false);
		frmTelaLogin.setBackground(Color.PINK);
		frmTelaLogin.setTitle("Tela Login");
		frmTelaLogin.setBounds(100, 100, 400, 300);
		frmTelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtSiape = new JTextField(15);
		txtSiape.setColumns(10);

		JButton btn_Entrar = new JButton("ENTRAR");

		btn_Entrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AdminDao adao = new AdminDao();
				Admin admin = new Admin();
				int siape = Integer.parseInt(txtSiape.getText());
				admin = adao.buscarPorSiape(siape);

				if (admin == null) {
					JOptionPane.showMessageDialog(null, "Dados Inválidos");
				} else {
					try {
						Principal windowPrincipal = new Principal();
						windowPrincipal.getFrmTelaPrincipal().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		});

		JLabel lblSiape = new JLabel("Siape");
		lblSiape.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblLogin = new JLabel("Login Sistema");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		txtSenha = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frmTelaLogin.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addGap(82)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING).addComponent(lblSiape).addComponent(lblSenha))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtSiape, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(btn_Entrar, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
						.addComponent(txtSenha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
				.addGap(81))
				.addGroup(groupLayout.createSequentialGroup().addGap(111)
						.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE).addGap(107)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(35)
				.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSiape)
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(txtSiape,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(24)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblSenha)
						.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(txtSenha,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGap(28)
				.addComponent(btn_Entrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(65)));
		frmTelaLogin.getContentPane().setLayout(groupLayout);
	}
}
