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

public class AtualizarSenha {

	private JFrame frmTelaAtualizarSenha;
	Admin adm = new Admin();
	AdminDao aDao = new AdminDao();
	Controla_views control_View = new Controla_views();

	int siape;
	private JPasswordField txt_Senha_conf;
	private JPasswordField txt_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarSenha windowLogin = new AtualizarSenha();
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
	public AtualizarSenha() {
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
		frmTelaAtualizarSenha.setTitle("Materiais");
		frmTelaAtualizarSenha.setBounds(100, 100, 300, 200);
		frmTelaAtualizarSenha.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmTelaAtualizarSenha.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Atualização de senha");
		lblNewLabel.setBounds(32, 11, 196, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmTelaAtualizarSenha.getContentPane().add(lblNewLabel);

		JLabel lblNovaSenha = new JLabel("Nova Senha");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovaSenha.setBounds(32, 50, 92, 17);
		frmTelaAtualizarSenha.getContentPane().add(lblNovaSenha);

		JLabel lblConfirmaoDeSenha = new JLabel("Confirmação");
		lblConfirmaoDeSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmaoDeSenha.setBounds(32, 87, 77, 17);
		frmTelaAtualizarSenha.getContentPane().add(lblConfirmaoDeSenha);

		JButton btn_Atualizar = new JButton("Atualizar");
		btn_Atualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String senha = new String(txt_Senha.getPassword());
					String senhaConf = new String(txt_Senha_conf.getPassword());
					String result = senha.replaceAll("\\s+","");
					senha.trim();
					
					if(!senha.equals(senhaConf)) {
						JOptionPane.showMessageDialog(null, "As senhas não conferem!!!");
						return;
					}
					if (senha.equals("") && senhaConf.equals("")) {
						JOptionPane.showMessageDialog(null, "As senhas não podem ser nulas!!!");
						return;
					}
					
					if (result.equals(senhaConf)) {

						String siape = System.getProperty("siape");
						adm = aDao.buscarPorSiape(Integer.parseInt(siape));
						
						adm.setSenha(result);
						aDao.atualizar(adm);

						JOptionPane.showMessageDialog(null, "Sua senha foi atualizada com sucesso!!!");
						getFrmTelaAtualizarSenha().dispose();
						control_View.abreTelaServidor();

					}

					else {

						JOptionPane.showMessageDialog(null, "As senhas não conferem");
						txt_Senha.setText("");
						txt_Senha_conf.setText("");
						return;
					}

			}
		});
		btn_Atualizar.setBackground(new Color(34, 139, 34));
		btn_Atualizar.setBounds(32, 122, 110, 23);
		frmTelaAtualizarSenha.getContentPane().add(btn_Atualizar);

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
		
		txt_Senha_conf = new JPasswordField();
		txt_Senha_conf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Senha_conf.setBounds(118, 87, 144, 20);
		frmTelaAtualizarSenha.getContentPane().add(txt_Senha_conf);
		
		txt_Senha = new JPasswordField();
		txt_Senha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_Senha.setBounds(118, 50, 144, 20);
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
