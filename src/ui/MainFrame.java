package ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.Library;

public class MainFrame extends JFrame{
	
	//Esta me lo genero el IDE para evitar una advertencia, mejor no tocarlo
	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private JPanel container;
	Library library;
	
	public MainFrame() {
		this.library = new Library();
		init();
		
		//Aqui van todo lo que tiene que ver con la ventana principal
		setBounds(0,0,800,600);
		setTitle("BIBLIOTECA 2.0");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		
		layout = new CardLayout();
		container = new JPanel(layout);
		
		MainPanel mainPanel = new MainPanel(this);
		OperationUserPanel OpUserPanel = new OperationUserPanel(this);
		MaterialOperationPanel OpMaterialPanel = new MaterialOperationPanel(this);
		LoanOperationPanel OpLoanPanel = new LoanOperationPanel(this);
		MaterialViewPanel SeeMaterialPanel = new MaterialViewPanel(this);
		UserViewPanel SeeUserPanel = new UserViewPanel(this);
		LoanViewPanel SeeLoanPanel = new LoanViewPanel(this);
		
		container.add(mainPanel,"Principal");
		container.add(OpUserPanel,"OpUser");
		container.add(OpMaterialPanel, "OpMaterial");
		container.add(OpLoanPanel,"OpLoan");
		container.add(SeeMaterialPanel,"SeeMaterial");
		container.add(SeeUserPanel,"SeeUser");
		container.add(SeeLoanPanel,"SeeLoan");
		
		layout.show(container, "Principal");
		
		
		add(container);
	}
	
	public void showPanel(String name) {
		layout.show(container, name);
	}
	
	public static void main(String[] args) {
		new MainFrame();
		
	}
}
