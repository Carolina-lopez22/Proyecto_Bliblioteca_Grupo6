package ui;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoanOperationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblCarnet,lblTittle,lblDate,lblReturned,lblMaterial;
	JTextField txtMaterial,txtCarnet,txtDate;
	JRadioButton rdbReturned,rdbNotReturned;
	ButtonGroup buttonGroup;
	JButton bttBack, bttCreate, bttRead, bttUpdate, bttDelete;
	
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Arial",Font.PLAIN, 30);
	private Font fontTittle = new Font("Arial",Font.BOLD, 40);
	
	public LoanOperationPanel(MainFrame window){
		this.mainFrame = window;
		init();
		
	}
	public void init() {
		setLayout(null);
		lblCarnet = new JLabel("Estudiante: ");
		lblDate = new JLabel("Fecha: ");
		lblTittle = new JLabel("Prestamos");
		lblReturned = new JLabel("Devuelto: ");
		lblMaterial = new JLabel("Material: ");
		
		lblTittle.setFont(fontTittle);
		lblCarnet.setFont(fontRegular);
		lblDate.setFont(fontRegular);
		lblReturned.setFont(fontRegular);
		lblMaterial.setFont(fontRegular);
		
		lblTittle.setBounds(330, 50, 300, 40);
		lblDate.setBounds(30,310,200,35);
		lblCarnet.setBounds(30,150,200,30);
		lblReturned.setBounds(30,390,200,30);
		lblMaterial.setBounds(30,230,200,30);
		
		add(lblCarnet);
		add(lblDate);
		add(lblTittle);
		add(lblReturned);
		add(lblMaterial);

		txtMaterial = new JTextField();
		txtCarnet = new JTextField();
		txtDate = new JTextField();
		
		txtCarnet.setBounds(230, 140,400,50);
		txtMaterial.setBounds(230,220,400,50);
		txtDate.setBounds(230,300,400,50);
		
		txtCarnet.setFont(fontRegular);
		txtMaterial.setFont(fontRegular);
		txtDate.setFont(fontRegular);
		
		add(txtCarnet);
		add(txtMaterial);
		add(txtDate);
		
		buttonGroup = new ButtonGroup();
		rdbReturned = new JRadioButton("Si");
		rdbNotReturned = new JRadioButton("No");
		
		rdbReturned.setFont(fontRegular);
		rdbNotReturned.setFont(fontRegular);
		
		rdbReturned.setBounds(230,380,80,50);
		rdbNotReturned.setBounds(430,380,80,50);
		
		add(rdbReturned);
		add(rdbNotReturned);
		buttonGroup.add(rdbReturned);
		buttonGroup.add(rdbNotReturned);
		
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

