package view;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sobre {

	private JFrame frmSobre;

	Controla_views control_View = new Controla_views();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre windowSobre = new Sobre();
					windowSobre.frmSobre.setVisible(true);
					windowSobre.frmSobre.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sobre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSobre = new JFrame();
		frmSobre.getContentPane().setBackground(new Color(224, 255, 255));
		frmSobre.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/imagens/Icon_SobrePQ.png")));
		frmSobre.setResizable(false);
		frmSobre.setBackground(Color.PINK);
		frmSobre.setTitle("Sobre");
		frmSobre.setBounds(100, 100, 800, 600);
		frmSobre.getContentPane().setLayout(null);

		JTextPane txtpnSistema = new JTextPane();
		txtpnSistema.setBackground(new Color(224, 255, 255));
		txtpnSistema.setEditable(false);
		txtpnSistema.setContentType("text/html");
		txtpnSistema.setText(
				"<html> <body> <p style = 'margin: 2px; text-align: justify; font-size: 12px;'> O Sistema de Gerenciamento e Controle de Empréstimos de Materiais é um software que visa controlar de maneira mais efeciente os emprétimos de materias e itens de consumo. Ele foi desenvolvido por um educando do INSTITUTO FEDERAL CATARINENSE - CAMPUS BLUMENAU em fase de estágio obrigatório do curso superior de ANÁLISE E DESENVOLVIMENTO DE SISTEMAS. A necessidade do sistema surgiu de uma demanda do setor de coordenação de tecnologia da informação que não tinha como realizar o controle mais efetivo desses materias próprios de informática. Para melhor gerenciar essa situação, deu-se inicio ao desenvolvimento do sistema em Agosto de 2021 e sendo finalizado em dezembro de 2021. O acompanhamento e orientação foram realizados pelo coordenador do curso Hylson Vescovi Neto. E pela supervisão de Emerson da Silva Matos responsável pelo setor de coordenação de tecnologia da informação do campus.</p> </body> </html>");
		txtpnSistema.setBounds(54, 75, 678, 232);
		frmSobre.getContentPane().add(txtpnSistema);

		JTextPane txtpnDesenvolvedor = new JTextPane();
		txtpnDesenvolvedor.setBackground(new Color(224, 255, 255));
		txtpnDesenvolvedor.setContentType("text/html");
		txtpnDesenvolvedor.setText(
				"<html> <body> <p style = 'margin: 2px; text-align: justify; font-size: 12px;'>  Antonio josé da Silva Mesquita inciou o curso superior de ANÁLISE E DESENVOLVIMENTO DE SISTEMAS em março de 2017. Após a conclusão de toda a grade curricular presencial, surgiu a necessidade da realização do estágio obrigatório do curso. Para verificar o conhecimento adquerido durante o curso, formou-se uma comissão com o intuito de desenvolver este sistema. O sistema ficará disponível na Instituição após este estágio afim de que seja implantado,  realizado melhorias, integrado aos sistemas existentes ou ainda para que sirva de base para outras implementações em outras linguagens de programação.</p> </body> </html>");
		txtpnDesenvolvedor.setEditable(false);
		txtpnDesenvolvedor.setBounds(54, 351, 678, 153);
		frmSobre.getContentPane().add(txtpnDesenvolvedor);

		JLabel lblNewLabel = new JLabel("SOBRE O SISTEMA");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(54, 41, 531, 22);
		frmSobre.getContentPane().add(lblNewLabel);

		JLabel lblSobreODesenvolvedor = new JLabel("SOBRE O DESENVOLVEDOR");
		lblSobreODesenvolvedor.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblSobreODesenvolvedor.setBounds(54, 318, 678, 22);
		frmSobre.getContentPane().add(lblSobreODesenvolvedor);

		JButton btn_Voltar = new JButton("Voltar");
		btn_Voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control_View.abreTelaPrincipal();
				getFrmSobre().dispose();
			}
		});
		btn_Voltar.setForeground(Color.BLACK);
		btn_Voltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Voltar.setBackground(new Color(240, 230, 140));
		btn_Voltar.setBounds(491, 521, 110, 25);
		frmSobre.getContentPane().add(btn_Voltar);

		JButton btn_Sair = new JButton("Logout");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (control_View.fecharSistema() == true) {
					getFrmSobre().dispose();
				}

			}
		});
		btn_Sair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_Sair.setBackground(new Color(255, 69, 0));
		btn_Sair.setBounds(640, 521, 92, 25);
		frmSobre.getContentPane().add(btn_Sair);

		frmSobre.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do Sistema?");

				if (conf == JOptionPane.YES_OPTION) {
					frmSobre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frmSobre.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}

			}
		});
	}

	public JFrame getFrmSobre() {
		return frmSobre;
	}

	public void setFrmSobre(JFrame frmSobre) {
		this.frmSobre = frmSobre;
	}

	public Controla_views getTelaPrincipal() {
		return control_View;
	}

	public void setTelaPrincipal(Controla_views telaPrincipal) {
		this.control_View = telaPrincipal;
	}
}
