package Gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloAlumnos;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Clases.Alumno;
import Clases.Curso;
import Clases.Matricula;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class RegistroMatricula extends JDialog implements ActionListener, ItemListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JLabel lblCurso;
	private JTextField txtNroMatri;
	private JButton btnMatricular;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JLabel lblAlumno;
	private JTextField txtCodAlu;
	private JScrollPane scrollPane;
	private JTable table;
	ArregloCurso ac=new ArregloCurso();
	ArregloAlumnos aa=new ArregloAlumnos();
	ArregloMatricula am=new ArregloMatricula();
	/*instancia de defaulTableModel*/
	DefaultTableModel model=new DefaultTableModel();
	private JTable tblMatricula;
	private JTextField txtCodCur;
	private JLabel label;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroMatricula dialog = new RegistroMatricula();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroMatricula() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroMatricula.class.getResource("/Gui/img/estudiar.png")));
		setTitle("Registro | Matricula");
		setBounds(100, 100, 629, 474);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodigo = new JLabel("Nro. Matricula");
		lblCodigo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 33, 102, 20);
		contentPanel.add(lblCodigo);
		
		lblCurso = new JLabel("Cod. Curso");
		lblCurso.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblCurso.setBounds(10, 114, 102, 20);
		contentPanel.add(lblCurso);
		
		txtNroMatri = new JTextField();
		txtNroMatri.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtNroMatri.setBounds(131, 33, 102, 20);
		contentPanel.add(txtNroMatri);
		txtNroMatri.setColumns(10);
		
		btnMatricular = new JButton("Grabar");
		btnMatricular.addMouseListener(this);
		btnMatricular.addItemListener(this);
		btnMatricular.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnMatricular.addActionListener(this);
		btnMatricular.setBounds(243, 29, 108, 23);
		contentPanel.add(btnMatricular);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(472, 33, 102, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLUE);
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnModificar.setBounds(472, 71, 102, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Cancelar");
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnEliminar.setBounds(472, 110, 102, 23);
		contentPanel.add(btnEliminar);
		
		lblAlumno = new JLabel("Cod. Alumno");
		lblAlumno.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblAlumno.setBounds(10, 75, 102, 20);
		contentPanel.add(lblAlumno);
		
		txtCodAlu = new JTextField();
		txtCodAlu.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtCodAlu.addKeyListener(this);
		txtCodAlu.setBounds(131, 72, 102, 20);
		contentPanel.add(txtCodAlu);
		txtCodAlu.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 593, 233);
		contentPanel.add(scrollPane);
		
		tblMatricula = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblMatricula.addKeyListener(this);
		tblMatricula.addMouseListener(this);
		scrollPane.setViewportView(tblMatricula);

		model.addColumn("Nro. Matricula");
		model.addColumn("Codigo Alumno");
		model.addColumn("Codigo Curso");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		tblMatricula.setModel(model);
		
		
		txtCodCur = new JTextField();
		txtCodCur.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtCodCur.addKeyListener(this);
		txtCodCur.setBounds(131, 111, 102, 20);
		contentPanel.add(txtCodCur);
		txtCodCur.setColumns(10);
		

		btnMatricular.setEnabled(false);
		txtNroMatri.setEditable(false);
		
		label = new JLabel("Buscar ");
		label.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		label.setBounds(10, 397, 63, 20);
		contentPanel.add(label);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(83, 394, 130, 20);
		contentPanel.add(txtBuscar);
		
		btnBuscar = new JButton("");
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(RegistroMatricula.class.getResource("/Gui/img/lupaok.png")));
		btnBuscar.setBounds(223, 393, 28, 22);
		contentPanel.add(btnBuscar);
		
		btnOk = new JButton("");
		btnOk.addMouseListener(this);
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(RegistroMatricula.class.getResource("/Gui/img/checked3.png")));
		btnOk.setBounds(259, 393, 28, 23);
		contentPanel.add(btnOk);
		listar();
		editarFila();
		txtCodAlu.setEditable(false);
		txtCodCur.setEditable(false);
		txtBuscar.setEditable(false);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			actionPerformedBtnOk(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedButton(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnMatricular) {
			actionPerformedBtnMatricular(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnMatricular.setEnabled(true);
		limpieza();
		habilitarEntradas(true);
		txtCodAlu.requestFocus();
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
		
	}
	
	protected void actionPerformedBtnMatricular(ActionEvent arg0) {
		try {
			Alumno a=aa.buscar(leerCodAlumno()); 
			Curso c=ac.buscar(leerCodCurso()); 
			Matricula lo = am.buscarMatriculaPorCodigo(leerCodAlumno());
			int nroMatricula = leerNroMatricula(); 
			String fecha = fechaActual();
			String hora = horaActual();
			try{
				if(leerCodAlumno()>=0){
					int codAlumno = leerCodAlumno();
					try{
						if(leerCodCurso()>=0){
							int codCurso=leerCodCurso();
							if(a!=null) {
								if(c!=null){
									a.setEstado(1);  
									aa.grabarAlumno(); 	 
									if(btnAdicionar.isEnabled() == false) {
											if(lo == null) {
												Matricula m=new Matricula(nroMatricula, codAlumno, codCurso, fecha, hora);
												am.adicionar(m);
												am.grabarMatricula();
												btnAdicionar.setEnabled(true);
												listar();
												habilitarRegistro(false);
												confirmacion("MATRICULA SATISFACTORIA");
												}
											else{
												error("El ALUMNO , ya se encuentra matriculado", txtCodAlu);
												txtCodCur.setText("");
												btnAdicionar.setEnabled(true);
											}
										}
											
										if(btnModificar.isEnabled() == false) {
											Matricula m=am.buscar(nroMatricula);
											m.setCodAlumno(codAlumno);
											m.setCodCurso(codCurso);
											m.setFecha(fecha);
											m.setHora(hora);
											confirmacion("MATRICULA MODIFICADA SATISFACTORIAMENTE");
										}
											am.grabarMatricula();
											btnModificar.setEnabled(true);
											listar();
											habilitarRegistro(false);
											btnMatricular.setEnabled(true);
								}
										
								else {
									error("CODIGO de Curso no existe", txtCodCur);
								}
								
								}	
							
							else {
									error("CODIGO de alumno no existe", txtCodAlu);
								 }
						}
							else 
								error("Ingrese CODIGO CURSO correcto", txtCodCur);
						}
						catch(Exception e){
							mensaje("Ingrese CODIGO CURSO correcto");
						}
					}
					else error("Ingrese CODIGO ALUMNO correcto", txtCodAlu);
				
				}
				catch(Exception e){
					mensaje("Ingrese CODIGO ALUMNO correcto");
				}	
		}
		catch(Exception e) {
			mensaje("Rellene los campos correctamente");
		}
		
	}

	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void confirmacion(String s){
		JOptionPane.showMessageDialog(this,s);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}

	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblMatricula.getSelectedRow();
		if (model.getRowCount() == am.tamaño() - 1)
			posFila = am.tamaño() - 1;
		if (posFila == am.tamaño())
			posFila --;
		model.setRowCount(0);
		Matricula m;
		for (int i=0; i<am.tamaño(); i++) {
			m = am.obtener(i);
			Object[] fila = {m.getNumMatricula(),
					        m.getCodAlumno(),
							m.getCodCurso(),
							m.getFecha(),
							m.getHora()};
			
							  model.addRow(fila);
		}
		if (am.tamaño() > 0)
			tblMatricula.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	
	void editarFila() {
		if (am.tamaño() == 0)
			limpieza();
		else {
			Matricula m = am.obtener(tblMatricula.getSelectedRow());
			txtNroMatri.setText("" + m.getNumMatricula());
			txtCodAlu.setText(""+m.getCodAlumno());
			txtCodCur.setText(""+m.getCodCurso());
		}
	}
	void limpieza() {
		txtNroMatri.setText(""+am.codigoCorrelativo());
		txtCodAlu.setText("");
		txtCodCur.setText("");
	}
	
	void habilitarRegistro(boolean ToF) {
		btnMatricular.setEnabled(ToF);
		txtNroMatri.setEditable(ToF);
		txtCodAlu.setEditable(ToF);
		txtCodCur.setEditable(ToF);
	}
	void habilitarEntradas(boolean sino) {
		btnMatricular.setEnabled(sino);
		txtCodAlu.setEditable(sino);
		txtCodCur.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	int leerBuscar(){
		return Integer.parseInt(txtBuscar.getText().trim());
	}
	
	int leerNroMatricula(){
		return Integer.parseInt(txtNroMatri.getText().trim());
	}
	int leerCodAlumno(){
		return Integer.parseInt(txtCodAlu.getText().trim());
	}
	int leerCodCurso(){
		return Integer.parseInt(txtCodCur.getText().trim());
	}

	
	
	String fechaActual() {
			int dd, mm, aa;
			Calendar c = new GregorianCalendar();
			dd = c.get(Calendar.DAY_OF_MONTH);
			mm = c.get(Calendar.MONTH) + 1;
			aa = c.get(Calendar.YEAR);
			return ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
		}
	String horaActual() {
			int hh, mm, ss;
			Calendar c = new GregorianCalendar();
			hh = c.get(Calendar.HOUR_OF_DAY);
			mm = c.get(Calendar.MINUTE);
			ss = c.get(Calendar.SECOND);
			return ajustar(hh) + ":" + ajustar(mm) + ":" + ajustar(ss);
		}
		
	String ajustar(int numero) {
			return String.format("%02d", numero);
		}
	
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		try {
			btnAdicionar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnMatricular.setEnabled(false);
			txtBuscar.setEditable(false);
			btnBuscar.setEnabled(true);
			txtCodCur.setEditable(false);
			Alumno a=aa.buscar(leerCodAlumno());
			if (am.tamaño() == 0)
				mensaje("No existe MATRICULA");
			else {
				if(a.getEstado()!=2) {
					editarFila();
					habilitarEntradas(false);
					int ok = confirmar("¿ Desea cancelar matricula ?");
					if (ok == 0) {
						am.eliminar(am.buscar(leerNroMatricula()));
						am.grabarMatricula();
						listar();
						editarFila();
					}
				}
				else {
					mensaje("No puede cancelar una Matricula con alumnos retirados");
				}
				
				
			}
		}
		catch(Exception e) {
			mensaje("Busque el codigo a eliminar");
		}
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
		
		if (am.tamaño() == 0) {
			btnMatricular.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existe matricula");	
		}
		else {
			editarFila();
			btnMatricular.setEnabled(true);
			habilitarEntradas(true);
			txtCodAlu.setEditable(false);
			txtCodAlu.requestFocus();
		}
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == btnMatricular) {
			itemStateChangedBtnMatricular(arg0);
		}
	}
	protected void itemStateChangedBtnMatricular(ItemEvent arg0) {
		
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		if(am.tamaño()==0) {mensaje("No existen cursos registrados");}	
		else {
			txtBuscar.setEditable(true);
			limpieza();
			txtBuscar.setText(null);
			txtBuscar.requestFocus();
			btnBuscar.setEnabled(false);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent arg0) {
		if(btnBuscar.isEnabled() == false) {
			try {
				int buscar = leerBuscar();
				if( buscar >= 0) {
					Matricula m = am.buscar(buscar);
					if(m != null) {
						txtCodCur.setText(""+m.getCodCurso());
						txtCodAlu.setText(""+m.getCodAlumno());
						txtNroMatri.setText(""+m.getNumMatricula());
						btnBuscar.setEnabled(true);
						listar();
					}
					else
						mensaje("El Número de Matricula no se encuentra registrado");
						btnBuscar.setEnabled(true);
						habilitarEntradas(false);
						txtBuscar.setEditable(false);
				}
				else 
					error("Ingrese un código válido ", txtBuscar);
				
			}
			
			catch(Exception er) {
				error("Ingrese código correcto ", txtBuscar);
				
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblMatricula) {
			mouseClickedTblMatricula(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == tblMatricula) {
			mouseEnteredTblMatricula(e);
		}
		if (e.getSource() == btnOk) {
			mouseEnteredBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(e);
		}
		if (e.getSource() == btnMatricular) {
			mouseEnteredBtnMatricular(e);
		}
		if (e.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			mouseEnteredBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnAdicionar(MouseEvent e) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnModificar(MouseEvent e) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnEliminar(MouseEvent e) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnMatricular(MouseEvent e) {
		btnMatricular.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnOk(MouseEvent e) {
		btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredTblMatricula(MouseEvent e) {
		tblMatricula.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseClickedTblMatricula(MouseEvent e) {
		habilitarRegistro(false);
		habilitarBotones(true);
		editarFila();
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);

	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblMatricula) {
			keyReleasedTblMatricula(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodCur) {
			keyTypedTxtCodCur(e);
		}
		if (e.getSource() == txtCodAlu) {
			keyTypedTxtCodAlu(e);
		}
	}
	protected void keyReleasedTblMatricula(KeyEvent e) {
		habilitarRegistro(false);
		habilitarBotones(true);
		editarFila();
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
	}
	protected void keyTypedTxtCodAlu(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
	
	protected void keyTypedTxtCodCur(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
}//Fin de clase
