package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfirmerSenha {

	private JFrame frmTelaAtualizarSenha;
	Admin adm = new Admin();
	AdminDao aDao = new AdminDao();
	Controla_views control_View = new Controla_views();

	int siape;
	private JPasswordField txt_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmerSenha windowLogin = new ConfirmerSenha();
					windowLogin.frmTelaAtualizarSenha.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConfirmerSenha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaAtualizarSenha = new JFrame();
		frmTelaAtualizarSenha.getContentPane().setBackground(new Color(240, 255, 255));
		frmTelaAtualizarSenha.setResizable(false);
		frmTelaAtualizarSenha.setBackground(Color.PINK);
		frmTelaAtualizarSenha.setTitle("Confirmação");
		frmTelaAtualizarSenha.setBounds(100, 100, 300, 200);
		frmTelaAtualizarSenha.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTelaAtualizarSenha.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Confirmação de senha");
		lblNewLabel.setBounds(32, 11, 196, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmTelaAtualizarSenha.getContentPane().add(lblNewLabel);

		JLabel lblNovaSenha = new JLabel("Senha");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovaSenha.setBounds(32, 65, 92, 17);
		frmTelaAtualizarSenha.getContentPane().add(lblNovaSenha);

		JButton btn_Confirmar = new JButton("Confirmar");
		btn_Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String siape = System.getProperty("siape");
				adm = aDao.buscarPorSiape(Integer.parseInt(siape));
				String confirme = adm.getSenha();
				String senha = new String(txt_Senha.getPassword());
				String result = senha.replaceAll("\\s+", "");
				senha.trim();

				if (senha.equals("")) {
					JOptionPane.showMessageDialog(null, "As senhas não podem ser nulas!!!");
					return;
				}

				if (result.equals(confirme)) {

					control_View.abreTelaAdministrador();
					getFrmTelaAtualizarSenha().dispose();

				}else {
					JOptionPane.showMessageDialog(null, "Esta não é a senha do Adminitrador atual");
				}

			}
		});
		btn_Confirmar.setBackground(new Color(34, 139, 34));
		btn_Confirmar.setBounds(32, 122, 110, 23);
		frmTelaAtualizarSenha.getContentPane().add(btn_Confirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getFrmTelaAtualizarSenha().dispose();
				control_View.abreTelaServidor();

			}
		});
		btnCancelar.setBackground(new Color(240, 230, 140));
		btnCancelar.setBounds(152, 122, 115, 23);
		frmTelaAtualizarSenha.getContentPane().add(btnCancelar);

		txt_Senha = new JPasswordField();
		txt_Senha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btn_Confirmar.doClick();
				}
			}
		});
		txt_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Senha.setBounds(118, 63, 144, 20);
		frmTelaAtualizarSenha.getContentPane().add(txt_Senha);
	}

	public JFrame getFrmTelaAtualizarSenha() {
		return frmTelaAtualizarSenha;
	}

	public void setFrmTelaAtualizarSenha(JFrame frmTelaAtualizarSenha) {
		this.frmTelaAtualizarSenha = frmTelaAtualizarSenha;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}
}
