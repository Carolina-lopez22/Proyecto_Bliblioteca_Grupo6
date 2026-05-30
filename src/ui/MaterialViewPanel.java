package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MaterialViewPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblTittle;
	JButton bttBack;
	private JTable tableMaterials;
	private JScrollPane scroll;
	MaterialTableModel model;
	
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Segoe UI",Font.PLAIN, 18);
	private Font fontTittle = new Font("Segoe UI",Font.BOLD, 28);
	
	public MaterialViewPanel(MainFrame window){
		this.mainFrame = window;
		init();
		
	}
	
	public void init() {
		setLayout(null);
		setBackground(new Color(245,245,245));
		lblTittle = new JLabel("Materiales");
		
		lblTittle.setFont(fontTittle);
		
		lblTittle.setBounds(330, 40, 300, 40);
		
		add(lblTittle);
		
		model = new MaterialTableModel(mainFrame.library.getBooks());
		
		tableMaterials = new JTable(model);
		
		tableMaterials.setFont(fontRegular);
		
		tableMaterials.setRowHeight(35);

		tableMaterials.getTableHeader().setFont(
		    new Font("Segoe UI", Font.BOLD, 14)
		);

		tableMaterials.getTableHeader().setBackground(
		    new Color(70,120,255)
		);

		tableMaterials.getTableHeader().setForeground(Color.WHITE);
		
		scroll = new JScrollPane(tableMaterials);
		
		scroll.setBounds(30,100,740,400);
		
		add(scroll);
		
		bttBack = new JButton("Regresar");
		
		bttBack.setBounds(20,20,200,40);
		
		bttBack.setFocusPainted(false);
		bttBack.setBorderPainted(false);
		bttBack.setBackground(new Color(70,120,255));
		bttBack.setForeground(Color.WHITE);
		
		add(bttBack);
		
		bttBack.addActionListener(e -> {
			mainFrame.showPanel("Principal");
		});
	}
}

