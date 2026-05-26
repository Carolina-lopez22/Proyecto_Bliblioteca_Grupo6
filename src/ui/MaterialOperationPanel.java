package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Book;

public class MaterialOperationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	JLabel lblName,lblTittle,lblCode,lblAuthor, lblYear,lblCopies;
	JTextField txtName,txtCode,txtAuthor,txtYear,txtCopies;
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
		lblCopies = new JLabel("Copias: ");
		
		lblTittle.setFont(fontTittle);
		lblName.setFont(fontRegular);
		lblCode.setFont(fontRegular);
		lblAuthor.setFont(fontRegular);
		lblYear.setFont(fontRegular);
		lblCopies.setFont(fontRegular);
		
		lblTittle.setBounds(330, 50, 300, 40);
		lblCode.setBounds(30,150,200,35);
		lblName.setBounds(30,230,200,30);
		lblAuthor.setBounds(30,310,200,30);
		lblYear.setBounds(30,390,200,30);
		lblCopies.setBounds(30,450,200,30);
		
		add(lblName);
		add(lblCode);
		add(lblTittle);
		add(lblAuthor);
		add(lblYear);
		add(lblCopies);
		
		txtName = new JTextField();
		txtCode = new JTextField();
		txtAuthor = new JTextField();
		txtYear = new JTextField();
		txtCopies = new JTextField();
		
		txtCode.setBounds(230, 150,400,50);
		txtName.setBounds(230,230,400,50);
		txtAuthor.setBounds(230,310,400,50);
		txtYear.setBounds(230,390,400,50);
		txtCopies.setBounds(230,450,400,50);
		
		txtCode.setFont(fontRegular);
		txtName.setFont(fontRegular);
		txtAuthor.setFont(fontRegular);
		txtYear.setFont(fontRegular);
		txtCopies.setFont(fontRegular);
		
		add(txtCode);
		add(txtName);
		add(txtAuthor);
		add(txtYear);
		add(txtCopies);
		
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
		
		bttCreate.addActionListener(e -> enterMaterial());
		bttRead.addActionListener(e -> searchMaterial());
		bttUpdate.addActionListener(e -> updateMaterial());
		bttDelete.addActionListener(e -> deleteMaterial());
		
	}
	
	public void enterMaterial() {
		String nm = txtName.getText();
		String cn = txtCode.getText();
		String au = txtAuthor.getText();
		String ye = txtYear.getText();
		String cp = txtCopies.getText();
		
		if(nm.equals("") || cn.equals("") || au.equals("") || ye.equals("") || cp.equals("")) {JOptionPane.showMessageDialog(
				this, "Todos los campos se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		if(! ye.matches("[0-9]+") || ! cp.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(
					this, "Los Valores en Año y Copias deben ser enteros." + ye + ", " + cp,"Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		int year = Integer.parseInt(ye);
		int copies = Integer.parseInt(cp);
		
		if(!mainFrame.library.newBook(cn,nm,au,year,copies)) {
			JOptionPane.showMessageDialog(
					this, "Codigo no disponible","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		txtName.setText("");
		txtCode.setText("");
		txtAuthor.setText("");
		txtYear.setText("");
		txtCopies.setText("");
		JOptionPane.showMessageDialog(
				this, "Libro añadido con exito.","Nuevo Libro",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void searchMaterial() {
		String id = txtCode.getText();
		String title = txtName.getText();
		
		Book temp;
		
		if(id.equals("")) {
			if (title.equals("")) {
			JOptionPane.showMessageDialog(
				this, "El panel de codigo y de nombre se encuentra vacio.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;}
			else {
				temp = mainFrame.library.findBookByTitle(title);
				if (temp == null) {
					JOptionPane.showMessageDialog(
							this, "El titulo ingresado no se encuentra disponible","Advertencia",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		} else {
			temp = mainFrame.library.findBookById(id);
			if (temp == null) {JOptionPane.showMessageDialog(
					this, "El codigo ingresado no se encuentra disponible","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;}
		}

		txtName.setText(temp.getTitle());
		txtCode.setText(temp.getUniqueCode());
		txtAuthor.setText(temp.getAuthor());
		txtYear.setText( String.valueOf( temp.getYear() ) ); 
		txtCopies.setText( String.valueOf( temp.getCopies() ) );
	}
	
	public void updateMaterial() {
		String nm = txtName.getText();
		String cn = txtCode.getText();
		String au = txtAuthor.getText();
		String ye = txtYear.getText();
		String cp = txtCopies.getText();
		
		if(nm.equals("") || cn.equals("") || au.equals("") || ye.equals("") || cp.equals("")) {JOptionPane.showMessageDialog(
				this, "Todos los campos se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		if(! ye.matches("[0-9]+") || ! cp.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(
					this, "Los Valores en Año y Copias deben ser enteros." + ye + ", " + cp,"Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		int year = Integer.parseInt(ye);
		int copies = Integer.parseInt(cp);
		
		if(!mainFrame.library.updateBook(cn,nm,au,year,copies)){
			JOptionPane.showMessageDialog(this, "No se encontró libro con ID","Advertencia",JOptionPane.WARNING_MESSAGE);
		}
		JOptionPane.showMessageDialog(
				this, "Libro actualizado con exito.","Borrado",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void deleteMaterial() {
		String cn = txtCode.getText();
		
		if (cn.equals("")) {
			JOptionPane.showMessageDialog(
					this, "El campo de código se encuentra vacio.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (!mainFrame.library.deleteBook(cn)) {
			JOptionPane.showMessageDialog(this, "No se encontró libro con tal código.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		txtName.setText("");
		txtCode.setText("");
		txtAuthor.setText("");
		txtYear.setText("");
		txtCopies.setText("");
		JOptionPane.showMessageDialog(
				this, "Libro borrado con exito.","Borrado",JOptionPane.INFORMATION_MESSAGE);
	}
}
