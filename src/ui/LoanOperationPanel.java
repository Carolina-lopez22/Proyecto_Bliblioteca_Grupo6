package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import models.Book;
import models.Loan;
import models.User;

public class LoanOperationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblCarnet,lblTittle,lblDate,lblReturned,lblMaterial;
	JTextField txtMaterial,txtCarnet,txtDate;
	JRadioButton rdbReturned,rdbNotReturned;
	ButtonGroup buttonGroup;
	JButton bttBack, bttCreate, bttRead, bttUpdate, bttDelete;
	
	private MainFrame mainFrame;
	
	private Font fontRegular = new Font("Segoe UI",Font.PLAIN, 18);
	private Font fontTittle = new Font("Segoe UI",Font.BOLD, 28);
	
	public LoanOperationPanel(MainFrame window){
		this.mainFrame = window;
		init();
		
	}
	public void init() {
		setLayout(null);
		setBackground(new Color(245,245,245));
		lblCarnet = new JLabel("Carnet: ");
		lblDate = new JLabel("Fecha: ");
		lblTittle = new JLabel("Prestamos");
		lblReturned = new JLabel("Devuelto: ");
		lblMaterial = new JLabel("Codigo: ");
		
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
		
		txtDate.setEditable(false);
		
		txtCarnet.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        txtMaterial.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        txtDate.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		
		add(txtCarnet);
		add(txtMaterial);
		add(txtDate);
		
		buttonGroup = new ButtonGroup();
		rdbReturned = new JRadioButton("Si");
		rdbNotReturned = new JRadioButton("No");
		
		rdbReturned.setFont(fontRegular);
		rdbNotReturned.setFont(fontRegular);
		
		rdbReturned.setBackground(new Color(245,245,245));
		rdbNotReturned.setBackground(new Color(245,245,245));
		
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
		
		bttBack.setFocusPainted(false);
		bttBack.setBorderPainted(false);
		bttBack.setBackground(new Color(70,120,255));
		bttBack.setForeground(Color.WHITE);
        
		bttCreate.setFocusPainted(false);
		bttCreate.setBorderPainted(false);
		bttCreate.setBackground(new Color(70,120,255));
		bttCreate.setForeground(Color.WHITE);
        
		bttRead.setFocusPainted(false);
		bttRead.setBorderPainted(false);
		bttRead.setBackground(new Color(70,120,255));
		bttRead.setForeground(Color.WHITE);
        
		bttUpdate.setFocusPainted(false);
		bttUpdate.setBorderPainted(false);
		bttUpdate.setBackground(new Color(70,120,255));
		bttUpdate.setForeground(Color.WHITE);
        
		bttDelete.setFocusPainted(false);
		bttDelete.setBorderPainted(false);
        bttDelete.setBackground(new Color(70,120,255));
        bttDelete.setForeground(Color.WHITE);
		
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
		
		bttCreate.addActionListener(e -> enterLoan());
		bttRead.addActionListener(e -> searchLoan());
		bttUpdate.addActionListener(e -> updateLoan());
		bttDelete.addActionListener(e -> deleteLoan());
	}
	
	public void enterLoan() {
		String nm = txtMaterial.getText();
		String cn = txtCarnet.getText();
		
		if(nm.equals("") || cn.equals("") ) {JOptionPane.showMessageDialog(
				this, "Todos los campos se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		User user = mainFrame.library.findUserById(cn);
		Book book = mainFrame.library.findBookById(nm);
		
		if (user == null || book == null) {
			JOptionPane.showMessageDialog(
					this, "Libro o usuario no encontrado, pruebe otros identificadores.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(!mainFrame.library.loanBook(user,book,20)) {
			JOptionPane.showMessageDialog(
					this, "No es posible prestar el libro","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		txtMaterial.setText("");
		txtCarnet.setText("");
		txtDate.setText("");
		buttonGroup.clearSelection();
		JOptionPane.showMessageDialog(
				this, "Libro prestado con exito con exito.","Nuevo Libro",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void searchLoan() {
		String nm = txtMaterial.getText();
		String cn = txtCarnet.getText();
		
		Loan temp;
		
		if(nm.equals("") || cn.equals("") ) {JOptionPane.showMessageDialog(
				this, "Libro y Carnet se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		temp = mainFrame.library.searchLoan(nm, cn);
		
		if(temp == null) {
			JOptionPane.showMessageDialog(
					this, "No se encontró prestamo con usuario y libro.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		txtDate.setText(temp.getLoanDate().toString());
		if (temp.isReturned()) rdbReturned.setSelected(true);
		else rdbNotReturned.setSelected(true);
	}
	
	public void updateLoan() {
		String nm = txtMaterial.getText();
		String cn = txtCarnet.getText();
		
		if(nm.equals("") || cn.equals("") ) {JOptionPane.showMessageDialog(
				this, "Libro y Carnet se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		if (rdbReturned.isSelected()) {
			if(mainFrame.library.returnBook(cn, nm)) {
				JOptionPane.showMessageDialog(
						this, "Libro devuelto con exito.","Exito",JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(
						this, "No se pudo devolver el libro.","Advertencia",JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		
	}
	
	public void deleteLoan() {
		String nm = txtMaterial.getText();
		String cn = txtCarnet.getText();
		
		if(nm.equals("") || cn.equals("") ) {JOptionPane.showMessageDialog(
				this, "Libro y Carnet se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		if (!mainFrame.library.deleteLoan(cn,nm)) {
			JOptionPane.showMessageDialog(this, "No se pudo completar la operacion.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		txtMaterial.setText("");
		txtCarnet.setText("");
		txtDate.setText("");
		buttonGroup.clearSelection();
		JOptionPane.showMessageDialog(
				this, "Libro borrado con exito.","Borrado",JOptionPane.INFORMATION_MESSAGE);
	}
}

