package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperationUserPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JLabel lblNombre,lblTitulo,lblCarnet;
	JTextField txtNombre,txtCarnet;
	JButton bttBack, bttCreate, bttRead, bttUpdate, bttDelete;
	
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Arial",Font.PLAIN, 30);
	private Font fontTittle = new Font("Arial",Font.BOLD, 40);
	
	public OperationUserPanel(MainFrame window){
		this.mainFrame = window;
		init();
		
	}
	public void init() {
		setLayout(null);
		lblNombre = new JLabel("Nombre: ");
		lblCarnet = new JLabel("Carnet: ");
		lblTitulo = new JLabel("Usuarios");
		
		lblTitulo.setFont(fontTittle);
		lblNombre.setFont(fontRegular);
		lblCarnet.setFont(fontRegular);
		
		lblCarnet.setBounds(30,200,200,30);
		lblNombre.setBounds(30,300,200,30);
		lblTitulo.setBounds(330, 50, 300, 40);
		
		add(lblNombre);
		add(lblCarnet);
		add(lblTitulo);
		
		txtNombre = new JTextField();
		txtCarnet = new JTextField();
		
		txtCarnet.setBounds(230, 200,400,50);
		txtNombre.setBounds(230,300,400,50);
		
		txtCarnet.setFont(fontRegular);
		txtNombre.setFont(fontRegular);
		
		add(txtCarnet);
		add(txtNombre);
		
		bttBack = new JButton("Regresar");
		bttCreate = new JButton("Guardar");
		bttRead = new JButton("Buscar");
		bttUpdate = new JButton("Actualizar");
		bttDelete = new JButton("Borrar");
		
		bttBack.setBounds(20,20,200,40);
		bttCreate.setBounds(40,520,150,40);
		bttRead.setBounds(230,520,150,40);
		bttUpdate.setBounds(420,520,150,40);
		bttDelete.setBounds(610,520,150,40);
		
		add(bttBack);
		add(bttCreate);
		add(bttRead);
		add(bttUpdate);
		add(bttDelete);
		
		bttBack.addActionListener(e -> {
			mainFrame.showPanel("Principal");
		});
	}
}
