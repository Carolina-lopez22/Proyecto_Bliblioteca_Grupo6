package ui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	//Esta me lo generó el IDE para evitar una advertencia, mejor no tocarlo
	private static final long serialVersionUID = 1L;
	private CardLayout layout;
	private JPanel container;	
	
	public MainFrame() {
		
		init();
		//Aqui van todo lo que tiene que ver con la ventana principal
		setBounds(0,0,800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		
		layout = new CardLayout();
		container = new JPanel(layout);
		
		MainPanel mainPanel = new MainPanel(this);
		OperationUserPanel OpUserPanel = new OperationUserPanel(this);
		
		container.add(mainPanel,"Principal");
		container.add(OpUserPanel,"OpUser");
		
		
		layout.show(container, "Principal");
		
		
		add(container);
	}
	
	public void showPanel(String name) {
		layout.show(container, name);
	}
	
	public static void main(String[] args) {
		
	}
}
