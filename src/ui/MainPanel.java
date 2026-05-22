package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	private static final long serialVersionUID = 2L;
	
	//Declaro todos los elementos que voy a usar en la interfaz
	private JLabel lblTittle, lblMaterial, lblUser, lblLoans;
	private JButton bttOpMaterial, bttOpUser, bttOpLoan;
	private JButton bttSeeMaterial, bttSeeUser, bttSeeLoans;
	private JButton bttExit;
	//Esta variable es para guardar la ventana principal, para cambiar entre layouts
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Arial",Font.PLAIN, 20);
	private Font fontTittle = new Font("Arial",Font.BOLD, 30);
	
	public MainPanel(MainFrame window) {
		this.mainFrame = window;
		init();
	}
	
	public void init(){
		this.setLayout(null);
		
		lblTittle = new JLabel("BIBLIOTECA 2.0");
		lblMaterial = new JLabel("Materiales");
		lblUser = new JLabel("Usuarios");
		lblLoans = new JLabel("Prestamos");
		
		lblTittle.setBounds(300, 50, 300, 30);
		lblMaterial.setBounds(125, 120, 100, 20);
		lblUser.setBounds(350, 120, 100, 20);
		lblLoans.setBounds(575, 120, 100, 20);
		
		lblTittle.setFont(fontTittle);
		lblMaterial.setFont(fontRegular);
		lblUser.setFont(fontRegular);
		lblLoans.setFont(fontRegular);
		
		add(lblTittle);
		add(lblMaterial);
		add(lblUser);
		add(lblLoans);

		bttOpMaterial = new JButton("Operaciones");
		bttOpUser = new JButton("Operaciones");
		bttOpLoan = new JButton("Operaciones");
		
		bttSeeMaterial = new JButton("Ver Materiales");
		bttSeeUser = new JButton("Ver Materiales");
		bttSeeLoans = new JButton("Ver Materiales");
		
		bttExit = new JButton("Salir");
		
		bttOpMaterial.setBounds(60,180,200,40);
		bttOpUser.setBounds(300,180,200,40);
		bttOpLoan.setBounds(540,180,200,40);
		
		bttSeeMaterial.setBounds(60,260,200,40);
		bttSeeUser.setBounds(300,260,200,40);
		bttSeeLoans.setBounds(540,260,200,40);
		
		bttExit.setBounds(300,400,200,40);
		
		add(bttOpMaterial);
		add(bttOpUser);
		add(bttOpLoan);
		add(bttSeeMaterial);
		add(bttSeeUser);
		add(bttSeeLoans);
		add(bttExit);
		
		bttOpMaterial.setFont(fontRegular);
		bttOpUser.setFont(fontRegular);
		bttOpLoan.setFont(fontRegular);
		bttSeeMaterial.setFont(fontRegular);
		bttSeeUser.setFont(fontRegular);
		bttSeeLoans.setFont(fontRegular);
		bttExit.setFont(fontRegular);
		
		bttOpUser.addActionListener(e -> {
			mainFrame.showPanel("OpUser");
		});
		
		bttOpMaterial.addActionListener(e -> {
			mainFrame.showPanel("OpMaterial");
		});
		
		bttOpLoan.addActionListener(e -> {
			mainFrame.showPanel("OpLoan");
		});
		
		bttExit.addActionListener(e -> {
			System.exit(0);
		});
		

	}
	
	
}
