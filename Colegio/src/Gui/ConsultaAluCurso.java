package Gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Arreglos.ArregloAlumnos;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Alumno;
import Clases.Curso;
import Clases.Matricula;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
public class ConsultaAluCurso extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodAlu;
	private JLabel lblCodigoCurso;
	private JTextField txtCodCur;
	private JButton btnConsultarCurso;
	private JScrollPane scrollPane;
	private JTextArea txtA;
	private JButton btnConsultar;
	
	ArregloCurso ac=new ArregloCurso();
	ArregloAlumnos aa=new ArregloAlumnos();
	ArregloMatricula ama = new ArregloMatricula();
	private JButton btnLimpiar;
	private JButton btnBuscar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultaAluCurso dialog = new ConsultaAluCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultaAluCurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaAluCurso.class.getResource("/Gui/img/estudiar.png")));
		setTitle("Consulta | Alumo - Curso");
		setBounds(100, 100, 567, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIngreseCodigo = new JLabel("Cod. Alumno");
			lblIngreseCodigo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblIngreseCodigo.setBounds(10, 42, 94, 20);
			contentPanel.add(lblIngreseCodigo);
		}
		{
			txtCodAlu = new JTextField();
			txtCodAlu.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtCodAlu.addKeyListener(this);
			txtCodAlu.setBounds(124, 39, 102, 20);
			contentPanel.add(txtCodAlu);
			txtCodAlu.setColumns(10);
		}
		{
			btnConsultar = new JButton("Consultar Alumno");
			btnConsultar.setForeground(Color.BLUE);
			btnConsultar.addMouseListener(this);
			btnConsultar.addActionListener(this);
			btnConsultar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnConsultar.setBounds(381, 38, 160, 23);
			contentPanel.add(btnConsultar);
		}
		
		lblCodigoCurso = new JLabel("Cod. Curso");
		lblCodigoCurso.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblCodigoCurso.setBounds(10, 73, 94, 20);
		contentPanel.add(lblCodigoCurso);
		
		txtCodCur = new JTextField();
		txtCodCur.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtCodCur.addKeyListener(this);
		txtCodCur.setBounds(124, 70, 102, 20);
		contentPanel.add(txtCodCur);
		txtCodCur.setColumns(10);
		
		btnConsultarCurso = new JButton("Consultar Curso");
		btnConsultarCurso.setForeground(Color.BLUE);
		btnConsultarCurso.addMouseListener(this);
		btnConsultarCurso.addActionListener(this);
		btnConsultarCurso.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnConsultarCurso.setBounds(381, 72, 160, 23);
		contentPanel.add(btnConsultarCurso);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 531, 288);
		contentPanel.add(scrollPane);
		
		txtA = new JTextArea();
		txtA.setBounds(10, 106, 531, 286);
		contentPanel.add(txtA);
		txtA.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setForeground(Color.BLUE);
		btnLimpiar.addMouseListener(this);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(236, 403, 89, 23);
		contentPanel.add(btnLimpiar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(236, 38, 89, 23);
		contentPanel.add(btnBuscar);
		//modificar
		txtCodAlu.setEditable(false);
		txtCodCur.setEditable(false);
		btnBuscar.setEnabled(false);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnConsultarCurso) {
			actionPerformedBtnConsultarCurso(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		txtCodAlu.setEditable(true);
		txtCodCur.setEditable(false);
		btnBuscar.setEnabled(true);
		txtCodAlu.setText(null);
		txtCodAlu.requestFocus();
		btnConsultar.setEnabled(false);
		txtCodCur.setText(null);
		btnConsultarCurso.setEnabled(true);
		
		/*Ingresar un código de alumno y mostrar sus datos completos. Si está matriculado
visualizar los datos completos del curso.*/
		
	}
	int leerCodAlumno(){
		return Integer.parseInt(txtCodAlu.getText().trim());
	}
	int leerCodCurso(){
		return Integer.parseInt(txtCodCur.getText().trim());
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
	
	protected void actionPerformedBtnConsultarCurso(ActionEvent arg0) {
		txtCodCur.setEditable(true);
		txtCodAlu.setEditable(false);
		btnBuscar.setEnabled(true);
		btnConsultar.setEnabled(true);
		txtCodCur.requestFocus();
		btnConsultarCurso.setEnabled(false);
		txtCodAlu.setText(null);

	}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		txtA.setText("");
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		ProAlumno alu=new ProAlumno();
		
		if(btnConsultar.isEnabled() == false) {
			try {
				if(leerCodAlumno()>0){
					int codAlumno= leerCodAlumno();
					Alumno a = aa.buscar(codAlumno);
					if(a!=null){
						txtA.setText("");
						btnBuscar.setEnabled(false);
						txtCodAlu.setEditable(false);
						btnConsultar.setEnabled(true);
						imprimir("Codigo de Alumno : "+a.getCodAlumno());
						imprimir("Nombres : "+a.getNombres());
						imprimir("Apellidos : "+a.getApellidos());
						imprimir("Dni : "+a.getDni());
						imprimir("Edad : "+a.getEdad());
						imprimir("Celular : "+a.getCelular());
						imprimir("Estado : " + alu.enTextoEstado(a.getEstado()));
							if(a.getEstado() == 1 ) {
								try {
									Matricula m = ama.buscarMatriculaPorCodigo(codAlumno);
									Curso mc=ac.buscar(m.getCodCurso());
									imprimir("Codigo Curso: "+mc.getCodigoAsignatura());
									imprimir("Ciclo: "+mc.getCiclo());
									imprimir("Asignatura: " + mc.getAsignatura());
									imprimir("Creditos: "+mc.getNroCreditos());
									imprimir("Horas: "+mc.getCantHoras());
								}
								catch(Exception e) {
									mensaje("El Alumno no se encuentra matriculado");
									
								}
								
							}
					}
					else {
						mensaje("El codigo de alumno es incorrecto");
						txtCodAlu.requestFocus();
						
					}
					
				}
					
			} catch (Exception e) {
				error("CODIGO errado",txtCodCur);
			}
		}
		
		if(btnConsultarCurso.isEnabled() == false) {
			try {
				if(leerCodCurso()>0){
					int codCurso= leerCodCurso();
					Curso c = ac.buscar(codCurso);
					if(c!=null){
						txtA.setText("");
						imprimir("Codigo Curso: "+c.getCodigoAsignatura());
						imprimir("Ciclo: "+c.getCiclo());
						imprimir("Asignatura: " + c.getAsignatura());
						imprimir("Creditos: "+c.getNroCreditos());
						imprimir("Horas: "+c.getCantHoras());
						txtCodCur.setEditable(false);
						btnConsultarCurso.setEnabled(true);
						btnBuscar.setEnabled(false);
					}
					else{
						mensaje("CODIGO no existe");
						txtCodCur.requestFocus();
						}
				}
				else{
					mensaje("ingrese CODIGO correcto");
					txtCodCur.requestFocus();
				}
				
			} 
			catch (Exception e) {
				error("CODIGO errado",txtCodCur);
			}
		}

	}
	
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnLimpiar) {
			mouseEnteredBtnLimpiar(e);
		}
		if (e.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(e);
		}
		if (e.getSource() == btnConsultarCurso) {
			mouseEnteredBtnConsultarCurso(e);
		}
		if (e.getSource() == btnConsultar) {
			mouseEnteredBtnConsultar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnConsultar(MouseEvent e) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnConsultarCurso(MouseEvent e) {
		btnConsultarCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnLimpiar(MouseEvent e) {
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCodCur) {
			keyTypedTxtCodCur(arg0);
		}
		if (arg0.getSource() == txtCodAlu) {
			keyTypedTxtCodAlu(arg0);
		}
	}
	protected void keyTypedTxtCodAlu(KeyEvent arg0) {
		char a = arg0.getKeyChar();
		if(a<'0' || a>'9') arg0.consume();
	}
	protected void keyTypedTxtCodCur(KeyEvent arg0) {
		char a = arg0.getKeyChar();
		if(a<'0' || a>'9') arg0.consume();
	}
	
}//FIN DE CLASE
		

