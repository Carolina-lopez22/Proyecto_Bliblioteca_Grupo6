package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MaterialOperationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblName,lblTittle,lblCode,lblAuthor, lblYear;
	JTextField txtName,txtCarnet,txtAuthor,txtYear;
	JButton bttBack, bttCreate, bttRead, bttUpdate, bttDelete;
	
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Arial",Font.PLAIN, 30);
	private Font fontTittle = new Font("Arial",Font.BOLD, 40);
	
	public MaterialOperationPanel(MainFrame window){
		this.mainFrame = window;
		init();
		
	}
	public void init() {
		setLayout(null);
		lblName = new JLabel("Titulo: ");
		lblCode = new JLabel("Codigo: ");
		lblTittle = new JLabel("Materiales");
		lblAuthor = new JLabel("Autor: ");
		lblYear = new JLabel("Año: ");
		
		lblTittle.setFont(fontTittle);
		lblName.setFont(fontRegular);
		lblCode.setFont(fontRegular);
		lblAuthor.setFont(fontRegular);
		lblYear.setFont(fontRegular);
		
		lblTittle.setBounds(330, 50, 300, 40);
		lblCode.setBounds(30,150,200,35);
		lblName.setBounds(30,230,200,30);
		lblAuthor.setBounds(30,310,200,30);
		lblYear.setBounds(30,390,200,30);
		
		add(lblName);
		add(lblCode);
		add(lblTittle);
		add(lblAuthor);
		add(lblYear);
		
		txtName = new JTextField();
		txtCarnet = new JTextField();
		txtAuthor = new JTextField();
		txtYear = new JTextField();
		
		txtCarnet.setBounds(230, 150,400,50);
		txtName.setBounds(230,230,400,50);
		txtAuthor.setBounds(230,310,400,50);
		txtYear.setBounds(230,390,400,50);
		
		txtCarnet.setFont(fontRegular);
		txtName.setFont(fontRegular);
		txtAuthor.setFont(fontRegular);
		txtYear.setFont(fontRegular);
		
		add(txtCarnet);
		add(txtName);
		add(txtAuthor);
		add(txtYear);
		
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
