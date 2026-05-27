package ui;

import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.Admin;
import models.Library;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtUser;
    private JPasswordField txtPassword;

    private JButton bttLogin;

    private JLabel lblUser;
    private JLabel lblPassword;

    private Library library;

    public LoginFrame() {

        library = new Library();

        // Componentes
        lblUser = new JLabel("Usuario:");
        lblPassword = new JLabel("Contraseña:");
        
        lblUser.setFont(new Font("Arial", Font.BOLD, 18));
        lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
        txtUser = new JTextField(10);
        txtPassword = new JPasswordField(10);

        bttLogin = new JButton("Login");

        bttLogin.addActionListener(e -> login());

        setLayout(new GridLayout(6, 2, 2, 2));

        ((javax.swing.JComponent) getContentPane())
                .setBorder(
                    javax.swing.BorderFactory
                    .createEmptyBorder(30, 40, 30, 40)
                );

        // Agregar componentes
        add(lblUser);
        add(txtUser);

        add(lblPassword);
        add(txtPassword);

        add(new JLabel(""));
        add(bttLogin);

        // Configuración ventana
        setTitle("Iniciar Sesión");

        setSize(600, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void login() {

        String user = txtUser.getText();

        String pass =
                new String(txtPassword.getPassword());

        Admin u = library.login(user, pass);

        if (u == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos"
            );

            return;
        }

        MainFrame mf =
                new MainFrame(library, u);

        mf.setVisible(true);

        dispose();
    }
}