package View;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.MaterialDao;
import entity.Material;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BuscarMaterial extends JFrame {

	MaterialDao mDao = new MaterialDao();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	
	private List<Material> listaDeMateriais;
	@SuppressWarnings("rawtypes")
	JList listaFrame = new JList();
	
	

	
	
	public void buscarTodos() {
		listaDeMateriais = mDao.getListaMaterial();
		System.out.println(getListaDeMateriais().toString());
		//listaFrame =  (JList<Material>) getListaDeMateriais();
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarMaterial frame = new BuscarMaterial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscarMaterial() {
		setTitle("Buscar Material");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		buscarTodos();
		add(BorderLayout.CENTER, listaFrame);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		
		JLabel lblBuscaDeMateriasi = new JLabel("Busca de Materiais");
		lblBuscaDeMateriasi.setVerticalAlignment(SwingConstants.TOP);
		lblBuscaDeMateriasi.setForeground(new Color(0, 0, 205));
		lblBuscaDeMateriasi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		lblNewLabel = new JLabel("C\u00F3digo ou Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setListaDeMateriais(mDao.getListaMaterial());
				
			}
		});
		btnBuscar.setForeground(new Color(72, 61, 139));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(90)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblBuscaDeMateriasi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnBuscar)))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(lblBuscaDeMateriasi)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addContainerGap(297, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public List<Material> getListaDeMateriais() {
		return listaDeMateriais;
	}

	public void setListaDeMateriais(List<Material> listaDeMateriais) {
		this.listaDeMateriais = listaDeMateriais;
	}
}
