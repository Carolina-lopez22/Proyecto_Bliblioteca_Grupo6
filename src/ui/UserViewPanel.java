package ui;

import java.awt.Color;
import java.awt.Font;
import models.Admin;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UserViewPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblTittle;
	JButton bttBack;
	private JTable tableUsers;
	private JScrollPane scroll;
	UserTableModel model;
	
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Segoe UI",Font.PLAIN, 18);
	private Font fontTittle = new Font("Segoe UI",Font.BOLD, 28);
	
	public UserViewPanel(MainFrame window){
		this.mainFrame = window;
		init();
		
	}
	
	public void init() {
		setLayout(null);
		setBackground(new Color(245,245,245));
		lblTittle = new JLabel("Usuarios");
		
		lblTittle.setFont(fontTittle);
		
		lblTittle.setBounds(330, 40, 300, 40);
		
		add(lblTittle);
		
		model = new UserTableModel(mainFrame.library.getUsers(),mainFrame.currentUser instanceof Admin);
		
		tableUsers = new JTable(model);
		
		tableUsers.setFont(fontRegular);
		
		tableUsers.setRowHeight(35);

		tableUsers.getTableHeader().setFont(
		    new Font("Segoe UI", Font.BOLD, 14)
		);

		tableUsers.getTableHeader().setBackground(
		    new Color(70,120,255)
		);

		tableUsers.getTableHeader().setForeground(Color.WHITE);
		
		scroll = new JScrollPane(tableUsers);
		
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
			model.fireTableDataChanged();
		});
	}
}

