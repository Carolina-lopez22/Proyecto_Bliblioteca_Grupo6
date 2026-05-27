package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.User;

public class OperationUserPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JLabel lblName,lblTittle,lblCarnet;
	JTextField txtName,txtCarnet;
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
		lblName = new JLabel("Nombre: ");
		lblCarnet = new JLabel("Carnet: ");
		lblTittle = new JLabel("Usuarios");
		
		lblTittle.setFont(fontTittle);
		lblName.setFont(fontRegular);
		lblCarnet.setFont(fontRegular);
		
		lblCarnet.setBounds(30,200,200,30);
		lblName.setBounds(30,300,200,30);
		lblTittle.setBounds(330, 50, 300, 40);
		
		add(lblName);
		add(lblCarnet);
		add(lblTittle);
		
		txtName = new JTextField();
		txtCarnet = new JTextField();
		
		txtCarnet.setBounds(230, 200,400,50);
		txtName.setBounds(230,300,400,50);
		
		txtCarnet.setFont(fontRegular);
		txtName.setFont(fontRegular);
		
		add(txtCarnet);
		add(txtName);
		
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
		
		bttCreate.addActionListener(e -> enterUser());
		bttRead.addActionListener(e -> searchUser());
		bttUpdate.addActionListener(e -> updateUser());
		bttDelete.addActionListener(e -> deleteUser());
		
	}
	
	public void enterUser() {
		String nm = txtName.getText();
		String cn = txtCarnet.getText();
		
		if(nm.equals("") || cn.equals("")) {JOptionPane.showMessageDialog(
				this, "Todos los campos se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		boolean updated = mainFrame.library.newUser(cn,nm);
		if(!updated){
			JOptionPane.showMessageDialog(
					this, "Carnet no disponible","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		txtName.setText("");
		txtCarnet.setText("");
		JOptionPane.showMessageDialog(
				this, "Usuario añadido con exito.","Nuevo Usuario",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void searchUser() {
		String id = txtCarnet.getText();
		if(id.equals("")) {JOptionPane.showMessageDialog(
				this, "El panel de carnet se encuentra vacio.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		User temp = mainFrame.library.findUserById(id);
		if (temp == null) {JOptionPane.showMessageDialog(
				this, "El carnet ingresado no se encuentra disponible","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		txtName.setText(temp.getName());
		txtCarnet.setText(temp.getId());
	}
	
	public void updateUser() {
		String nm = txtName.getText();
		String cn = txtCarnet.getText();
		
		if(nm.equals("") || cn.equals("")) {JOptionPane.showMessageDialog(
				this, "Todos los campos se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
		return;}
		
		if(!mainFrame.library.updateUser(cn,nm)){
			JOptionPane.showMessageDialog(this, "No se encontró usuario con id.","Advertencia",JOptionPane.WARNING_MESSAGE);
		} else {
			
        txtName.setText("");
        txtCarnet.setText("");
        JOptionPane.showMessageDialog(this, "Usuario actualizado.", "Actualización", JOptionPane.INFORMATION_MESSAGE);
    }
		
	}
	
	public void deleteUser() {
		String cn = txtCarnet.getText();
		
		if (cn.equals("")) {
			JOptionPane.showMessageDialog(
					this, "Todos los campos se encuentran vacios.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (!mainFrame.library.deleteUser(cn)) {
			JOptionPane.showMessageDialog(this, "No se encontró usuario con id.","Advertencia",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		txtName.setText("");
		txtCarnet.setText("");
		JOptionPane.showMessageDialog(
				this, "Usuario borrado con exito.","Borrado",JOptionPane.INFORMATION_MESSAGE);
	}

}
