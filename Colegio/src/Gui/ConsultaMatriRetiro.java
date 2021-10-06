package Gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloMatricula;
import Arreglos.ArregloRetiro;
import Clases.Curso;
import Clases.Matricula;
import Clases.Retiro;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class ConsultaMatriRetiro extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMatricula;
	private JTextField txtRetiro;
	private JScrollPane scrollPane;
	private JTextArea txtA;
	private JButton btnConsultarMatricula;
	ArregloMatricula am=new ArregloMatricula();
	ArregloRetiro ar=new ArregloRetiro();
	private JButton btnConsultarRetiro;
	private JButton btnLimpiar;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultaMatriRetiro dialog = new ConsultaMatriRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaMatriRetiro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaMatriRetiro.class.getResource("/Gui/img/estudiar.png")));
		setTitle("Consulta | Matricula - Retiro");
		setBounds(100, 100, 567, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nro. Matricula");
			lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 29, 110, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNroRetiro = new JLabel("Nro. Retiro");
			lblNroRetiro.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNroRetiro.setBounds(10, 54, 110, 20);
			contentPanel.add(lblNroRetiro);
		}
		{
			txtMatricula = new JTextField();
			txtMatricula.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtMatricula.addKeyListener(this);
			txtMatricula.setBounds(130, 24, 102, 20);
			contentPanel.add(txtMatricula);
			txtMatricula.setColumns(10);
		}
		{
			txtRetiro = new JTextField();
			txtRetiro.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtRetiro.addKeyListener(this);
			txtRetiro.setColumns(10);
			txtRetiro.setBounds(130, 51, 102, 20);
			contentPanel.add(txtRetiro);
		}
		{
			btnConsultarMatricula = new JButton("Consultar Matricula");
			btnConsultarMatricula.setForeground(Color.BLUE);
			btnConsultarMatricula.addMouseListener(this);
			btnConsultarMatricula.addActionListener(this);
			btnConsultarMatricula.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnConsultarMatricula.setBounds(378, 22, 163, 23);
			contentPanel.add(btnConsultarMatricula);
		}
		{
			btnConsultarRetiro = new JButton("Consultar Retiro");
			btnConsultarRetiro.setForeground(Color.BLUE);
			btnConsultarRetiro.addMouseListener(this);
			btnConsultarRetiro.addActionListener(this);
			btnConsultarRetiro.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnConsultarRetiro.setBounds(378, 50, 163, 23);
			contentPanel.add(btnConsultarRetiro);
		}
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 531, 302);
		contentPanel.add(scrollPane);
		
		txtA = new JTextArea();
		txtA.setBounds(10, 82, 531, 299);
		contentPanel.add(txtA);
		{
			btnLimpiar = new JButton("LIMPIAR");
			btnLimpiar.setForeground(Color.BLUE);
			btnLimpiar.addMouseListener(this);
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(238, 392, 89, 23);
			contentPanel.add(btnLimpiar);
		}
		{
			btnBuscar = new JButton("Buscar");
			btnBuscar.addMouseListener(this);
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(242, 22, 89, 23);
			contentPanel.add(btnBuscar);
			//Inicializar
			txtMatricula.setEditable(false);
			txtRetiro.setEditable(false);
			btnBuscar.setEnabled(false);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnConsultarRetiro) {
			actionPerformedBtnConsultarRetiro(arg0);
		}
		if (arg0.getSource() == btnConsultarMatricula) {
			actionPerformedBtnConsultarMatricula(arg0);
		}
	}
	protected void actionPerformedBtnConsultarMatricula(ActionEvent arg0) {
		txtMatricula.setEditable(true);
		txtRetiro.setEditable(false);
		btnBuscar.setEnabled(true);
		txtMatricula.setText(null);
		txtMatricula.requestFocus();
		btnConsultarMatricula.setEnabled(false);
		txtRetiro.setText(null);
		btnConsultarRetiro.setEnabled(true);
		
	}
	int leerNroMatricula(){
		return Integer.parseInt(txtMatricula.getText().trim());
	}
	int leerRetiro(){
		return Integer.parseInt(txtRetiro.getText().trim());
	}
	void limpiar(){
		txtA.setText("");
	}
	void imprimir(String s){
		txtA.append(s+"\n");
	}

	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	protected void actionPerformedBtnConsultarRetiro(ActionEvent arg0) {
		txtRetiro.setEditable(true);
		txtMatricula.setEditable(false);
		btnBuscar.setEnabled(true);
		btnConsultarMatricula.setEnabled(true);
		txtRetiro.requestFocus();
		btnConsultarRetiro.setEnabled(false);
		txtMatricula.setText(null);
		
		//FIN
		
	}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		txtA.setText("");
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		
		if(btnConsultarMatricula.isEnabled() == false) {
			try {
				 if(leerNroMatricula()>0){
					int nroMatricula= leerNroMatricula();
					Matricula m = am.buscar(nroMatricula);
					if(m!=null){
						txtA.setText("");
						btnBuscar.setEnabled(false);
						txtMatricula.setEditable(false);
						btnConsultarMatricula.setEnabled(true);
						imprimir("Nro. de Matricula : "+m.getNumMatricula());
						imprimir("Codigo de Alumno : "+m.getCodAlumno());
						imprimir("Codigo de Curso : "+m.getCodCurso());
						imprimir("Fecha de Matricula : "+m.getFecha());
						imprimir("Hora de Matricula : " + m.getHora());}
					else
						{
						mensaje("NRO. DE MATRICULA no existe");
						txtMatricula.requestFocus();
					}
				}
				 else{
					mensaje("ingrese NRO. DE MATRICULA correcto");
				}
				
			} catch (Exception e) {
				error("NRO. DE MATRICULA errado",txtMatricula);
			}
		}
			if(btnConsultarRetiro.isEnabled() == false) {
				try {
					 if(leerRetiro()>0){
						int nroRetiro= leerRetiro();
						Retiro r = ar.buscar(nroRetiro);
						if(r!=null){
							txtRetiro.setEditable(false);
							btnConsultarRetiro.setEnabled(true);
							btnBuscar.setEnabled(false);
							imprimir("Nro. de Retiro : "+r.getNumRetiro());
							imprimir("Nro. de Matricula : "+r.getNumMatricula());
							imprimir("Fecha de Retiro : "+r.getFecha());
							imprimir("Hora de Retiro : "+r.getHora());}
						else
							{
							mensaje("NRO. DE RETIRO no existe");
							txtRetiro.requestFocus();
							}
					}else{
						mensaje("ingrese NRO. DE RETIRO correcto");
					}
					
				} catch (Exception e) {
					error("NRO. DE RETIRO errado",txtRetiro);
				}
			}
		
	}//FIN METODO
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnLimpiar) {
			mouseEnteredBtnLimpiar(e);
		}
		if (e.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(e);
		}
		if (e.getSource() == btnConsultarRetiro) {
			mouseEnteredBtnConsultarRetiro(e);
		}
		if (e.getSource() == btnConsultarMatricula) {
			mouseEnteredBtnConsultarMatricula(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnConsultarMatricula(MouseEvent e) {
		btnConsultarMatricula.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnConsultarRetiro(MouseEvent e) {
		btnConsultarRetiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnLimpiar(MouseEvent e) {
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtRetiro) {
			keyTypedTxtRetiro(e);
		}
		if (e.getSource() == txtMatricula) {
			keyTypedTxtMatricula(e);
		}
	}
	protected void keyTypedTxtMatricula(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
	protected void keyTypedTxtRetiro(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
}//FIN DE CLASE
