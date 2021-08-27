package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Login {

	private JFrame frmTelaLogin;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmTelaLogin.setVisible(true);
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

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("ENTRAR");

		JLabel lblSiape = new JLabel("Siape");
		lblSiape.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JLabel lblLogin = new JLabel("Login Sistema");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GroupLayout groupLayout = new GroupLayout(frmTelaLogin.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(82)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.TRAILING).addComponent(lblSiape).addComponent(lblSenha))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176,
										Short.MAX_VALUE)
								.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176,
										Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
						.addGap(81))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(111)
						.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE).addGap(107)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(35)
						.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSiape)
								.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(textField)))
						.addGap(24)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addGroup(groupLayout.createSequentialGroup().addGap(1).addComponent(textField_1))
								.addComponent(lblSenha))
						.addGap(28).addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
						.addGap(65)));
		frmTelaLogin.getContentPane().setLayout(groupLayout);
	}
}
