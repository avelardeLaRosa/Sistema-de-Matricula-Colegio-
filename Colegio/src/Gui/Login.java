package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import java.awt.Checkbox;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtU;
	private JPasswordField pswC;
	private Button button;
	private Button button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 423);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(SystemColor.activeCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(this);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Gui/img/graduado.png")));
		lblNewLabel.setBounds(133, 27, 134, 135);
		contentPane.add(lblNewLabel);
		
		lblUsuario = new JLabel("Usuario ");
		lblUsuario.setForeground(new Color(0, 0, 128));
		lblUsuario.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblUsuario.setBounds(59, 184, 264, 14);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(0, 0, 128));
		lblContrasea.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		lblContrasea.setBounds(59, 240, 264, 14);
		contentPane.add(lblContrasea);
		
		txtU = new JTextField();
		txtU.setBounds(59, 209, 264, 20);
		contentPane.add(txtU);
		txtU.setColumns(10);
		
		pswC = new JPasswordField();
		pswC.setBounds(59, 265, 264, 20);
		contentPane.add(pswC);
		
		button = new Button("Ingresar");
		button.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		button.addActionListener(this);
		button.setBounds(59, 318, 264, 22);
		contentPane.add(button);
		
		button_1 = new Button("Cerrar");
		button_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(this);
		button_1.setBounds(59, 350, 264, 22);
		contentPane.add(button_1);
		setUndecorated(true);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		String usuario = txtU.getText().trim();
		String contraseña = String.valueOf(pswC.getPassword());
		if(usuario.equals("avelarde@hotmail.com")&& contraseña.equals("123456")){
		this.dispose();
		JOptionPane.showMessageDialog(this, "BIENVENIDO ALEXANDER");
		Principal pri=new Principal();
		pri.setVisible(true);
		pri.setLocationRelativeTo(this);
		}
		else if(usuario.equals("jvelasquez@hotmail.com")&& contraseña.equals("123456")){
			this.dispose();
			JOptionPane.showMessageDialog(this, "BIENVENIDO JESUS");
			Principal pri=new Principal();
			pri.setVisible(true);
			pri.setLocationRelativeTo(this);
			}
		else if(usuario.equals("cconcha@hotmail.com")&& contraseña.equals("123456")){
			this.dispose();
			JOptionPane.showMessageDialog(this, "BIENVENIDO CHRISTOPHER");
			Principal pri=new Principal();
			pri.setVisible(true);
			pri.setLocationRelativeTo(this);
			}
		else{
			JOptionPane.showMessageDialog(this, "ERROR EN LOG IN");
		}
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		System.exit(0);
	}
}
