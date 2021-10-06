package Gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloAlumnos;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Alumno;
import Clases.Matricula;
import Clases.Curso;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;


public class ReportAlum extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JComboBox cboReporte;
	private JTextArea txtA;
	ArregloAlumnos aa=new ArregloAlumnos();
	ArregloMatricula am=new ArregloMatricula();
	ArregloCurso ac = new ArregloCurso();
	private JButton btnLimpiar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportAlum dialog = new ReportAlum();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportAlum() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReportAlum.class.getResource("/Gui/img/estudiar.png")));
		setTitle("Reporte | Alumno");
		setBounds(100, 100, 480, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			cboReporte = new JComboBox();
			cboReporte.addMouseListener(this);
			cboReporte.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			cboReporte.setModel(new DefaultComboBoxModel(new String[] {"Alumnos con matricula pendiente", "Alumnos con matricula vigente", "Alumnos matriculados por curso"}));
			cboReporte.setBounds(26, 26, 320, 29);
			contentPanel.add(cboReporte);
		}
		{
			btnNewButton = new JButton("Mostrar");
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.addMouseListener(this);
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnNewButton.setBounds(365, 26, 89, 26);
			contentPanel.add(btnNewButton);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 76, 444, 300);
			contentPanel.add(scrollPane);
			{
				txtA = new JTextArea();
				scrollPane.setViewportView(txtA);
			}
			
			
		}
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addMouseListener(this);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(196, 401, 89, 23);
		contentPanel.add(btnLimpiar);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		int lista=leerLista();
		switch (lista) {
		case 0:	pendiente();	break;
		case 1: matriculado();	break;
		default:matriculaCurso();break;
		}
	
		
	}
	int leerLista(){
		return cboReporte.getSelectedIndex();
	}
	void imprimir(String s){
		txtA.append(s+"\n");
	}
	
	void pendiente() {
		Alumno ar;
		txtA.setText("");
		for(int i=0; i<aa.tamaño(); i++) {
			ar = aa.obtener(i);
			if(aa.obtener(i).getEstado() == 0) {
				imprimir("Codigo de Alumno : "+ar.getCodAlumno());
				imprimir("Nombres : "+ar.getNombres());
				imprimir("Apellidos : "+ar.getApellidos());
				imprimir("Dni : "+ar.getDni());
				imprimir("Edad : "+ar.getEdad());
				imprimir("Celular : "+ar.getCelular());
				imprimir("");
			}
		}
	}
	
	void matriculado() {
		Alumno ar;
		txtA.setText("");
		for(int i=0; i<aa.tamaño(); i++) {
			ar = aa.obtener(i);
			if(aa.obtener(i).getEstado() == 1) {
				imprimir("Codigo de Alumno : "+ar.getCodAlumno());
				imprimir("Nombres : "+ar.getNombres());
				imprimir("Apellidos : "+ar.getApellidos());
				imprimir("Dni : "+ar.getDni());
				imprimir("Edad : "+ar.getEdad());
				imprimir("Celular : "+ar.getCelular());
				imprimir("");
			}
		}
	}
	void matriculaCurso() {
		Matricula m;
		Alumno a;
		Curso c;
		txtA.setText("");
		for(int i=0; i<am.tamaño(); i++){
			if(am.tamaño()==0){
				imprimir("");
			}
			else {
				m = am.obtener(i);
				a = aa.buscar(m.getCodAlumno());
				c = ac.buscar(m.getCodCurso());
				imprimir("Número de matrícula : " + m.getNumMatricula());
				imprimir("Nombres : " + a.getNombres());
				imprimir("Apellidos : " + a.getApellidos());
				imprimir("Curso : " + c.getAsignatura());
				imprimir("");
			}
		}
		}
	
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		txtA.setText("");
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnLimpiar) {
			mouseEnteredBtnLimpiar(e);
		}
		if (e.getSource() == cboReporte) {
			mouseEnteredCboReporte(e);
		}
		if (e.getSource() == btnNewButton) {
			mouseEnteredBtnNewButton(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnNewButton(MouseEvent e) {
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredCboReporte(MouseEvent e) {
		cboReporte.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnLimpiar(MouseEvent e) {
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
