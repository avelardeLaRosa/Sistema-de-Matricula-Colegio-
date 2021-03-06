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
import javax.swing.JComboBox;
import javax.net.ssl.ExtendedSSLSession;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloAlumnos;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;
import Arreglos.ArregloRetiro;
import Clases.Alumno;
import Clases.Curso;
import Clases.Matricula;
import Clases.Retiro;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class RegistroRetiro extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRetiro;
	private JButton btnGrabar;
	private JLabel lblFecha;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable tblRetiro;
	/*instancia de defaulTableModel*/
	ArregloCurso ac=new ArregloCurso();
	ArregloAlumnos aa=new ArregloAlumnos();
	ArregloMatricula am=new ArregloMatricula();
	DefaultTableModel model=new DefaultTableModel();
	ArregloRetiro ar=new ArregloRetiro();
	private JTextField txtMatricula;
	private JLabel label;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroRetiro dialog = new RegistroRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroRetiro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroRetiro.class.getResource("/Gui/img/estudiar.png")));
		setTitle("Registro | Retiro");
		setBounds(100, 100, 629, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("Numero Retiro");
			lblCodigo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblCodigo.setBounds(10, 31, 139, 20);
			contentPanel.add(lblCodigo);
		}
		
		txtRetiro = new JTextField();
		txtRetiro.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtRetiro.setBounds(141, 28, 107, 20);
		contentPanel.add(txtRetiro);
		txtRetiro.setColumns(10);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addMouseListener(this);
		btnGrabar.addActionListener(this);
		btnGrabar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnGrabar.setBounds(258, 27, 120, 23);
		contentPanel.add(btnGrabar);
		
		lblFecha = new JLabel("Numero Matricula");
		lblFecha.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblFecha.setBounds(10, 76, 139, 20);
		contentPanel.add(lblFecha);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnAdicionar.setBounds(446, 27, 128, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLUE);
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnModificar.setBounds(446, 61, 128, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnEliminar.setBounds(446, 95, 128, 23);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 593, 271);
		contentPanel.add(scrollPane);
		
		tblRetiro = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		tblRetiro.setFillsViewportHeight(true);
		tblRetiro.addKeyListener(this);
		tblRetiro.addMouseListener(this);
		scrollPane.setViewportView(tblRetiro);
		model.addColumn("Nro. Retiro");
		model.addColumn("Nro. Matricula");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		tblRetiro.setModel(model);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		txtMatricula.addKeyListener(this);
		txtMatricula.setBounds(141, 73, 107, 20);
		contentPanel.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtRetiro.setEditable(false);
		btnGrabar.setEnabled(false);
		
		label = new JLabel("Buscar ");
		label.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		label.setBounds(10, 414, 63, 20);
		contentPanel.add(label);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(83, 411, 130, 20);
		contentPanel.add(txtBuscar);
		
		btnBuscar = new JButton("");
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(RegistroRetiro.class.getResource("/Gui/img/lupaok.png")));
		btnBuscar.setBounds(223, 411, 28, 22);
		contentPanel.add(btnBuscar);
		
		btnOk = new JButton("");
		btnOk.addMouseListener(this);
		btnOk.addActionListener(this);
		btnOk.setIcon(new ImageIcon(RegistroRetiro.class.getResource("/Gui/img/checked3.png")));
		btnOk.setBounds(258, 411, 28, 23);
		contentPanel.add(btnOk);
		
		listar();
		editarFila();
		txtMatricula.setEditable(false);
		txtBuscar.setEditable(false);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			actionPerformedBtnOk(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		
		int numRetiro = leerNroRetiro();
		String fecha = fechaActual();
		String hora = horaActual();
		try{if(leerNumMatricula()>=0){ int nroMatricula = leerNumMatricula();
			Matricula m = am.buscar(leerNumMatricula());//BUSCAR NRO DE MATRICULA
			if(m!=null){//SI ME RETORNA DATA 
				Alumno a =aa.buscar(m.getCodAlumno());//BUSCAR CODIGO DE ALUMNO Y QUE CAPTURE LA DATA DE MATRICULA
				if(a!=null){ // SI RETORNA DATA 
				    a.setEstado(2); //SET ESTADO 2
				     aa.grabarAlumno();
			if(btnAdicionar.isEnabled() == false) {
					Retiro r=new Retiro(numRetiro, nroMatricula, fecha, hora);
					ar.adicionar(r);
					ar.grabarRetiro();
					btnAdicionar.setEnabled(true);
					listar();
					habilitarRegistro(false);
					confirmacion("SE REALIZO EL RETIRO SATISFACTORIAMENTE");}
			if(btnModificar.isEnabled() == false) {
					Retiro r=ar.buscar(numRetiro);
					r.setNumMatricula(nroMatricula);
					r.setFecha(fecha);
					r.setHora(hora);
					ar.grabarRetiro();
					confirmacion("RETIRO MODIFICADO");}
					btnModificar.setEnabled(true);
					listar();
					habilitarRegistro(false);
					btnGrabar.setEnabled(true);
			}else{mensaje("NRO. DE MATRICULA no existe");}
			}else error("Ingrese NRO. MATRICULA correcto", txtMatricula);}}catch(Exception e){mensaje("Ingrese NRO MATRICULA correcto");}
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
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
			posFila = tblRetiro.getSelectedRow();
		if (model.getRowCount() == ar.tama?o() - 1)
			posFila = ar.tama?o() - 1;
		if (posFila == ar.tama?o())
			posFila --;
		model.setRowCount(0);
		Retiro r;
		for (int i=0; i<ar.tama?o(); i++) {
			r = ar.obtener(i);
			Object[] fila = {r.getNumRetiro(),
							 r.getNumMatricula(),
						     r.getFecha(),
						     r.getHora()};
			
							  model.addRow(fila);
							  
		}
		if (ar.tama?o() > 0)
			tblRetiro.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	
	void editarFila() {
		if (ar.tama?o() == 0)
			limpieza();
		else {
			Retiro r = ar.obtener(tblRetiro.getSelectedRow());
			txtRetiro.setText("" + r.getNumRetiro());
			txtMatricula.setText(""+r.getNumMatricula());
		}
	}
	void limpieza() {
		txtRetiro.setText(""+ar.codigoCorrelativo());
		txtMatricula.setText("");
	}
	void confirmacion(String s){
		JOptionPane.showMessageDialog(this,s);
	}
	void habilitarRegistro(boolean ToF) {
		btnGrabar.setEnabled(ToF);
		txtMatricula.setEditable(ToF);
	}
	void habilitarEntradas(boolean sino) {
		btnGrabar.setEnabled(sino);
		txtMatricula.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
	}
	
	int leerNroRetiro(){
		return Integer.parseInt(txtRetiro.getText().trim());
	}
	int leerNumMatricula(){
		return Integer.parseInt(txtMatricula.getText().trim());
	}
	int leerBusqueda(){
		return Integer.parseInt(txtBuscar.getText().trim());
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
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnGrabar.setEnabled(true);
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
		
		limpieza();
		habilitarEntradas(true);
		txtMatricula.requestFocus();
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
		if (ar.tama?o() == 0) {
			btnGrabar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existe retiro");	
		}
		else {
			editarFila();
			btnGrabar.setEnabled(true);
			habilitarEntradas(true);
			txtMatricula.requestFocus();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnGrabar.setEnabled(false);
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
		//editarFila();
		habilitarEntradas(false);
		int matri = leerNumMatricula();
		Matricula m = am.buscar(matri);
		Alumno a =aa.buscar(m.getCodAlumno());
		if (ar.tama?o() == 0)
			mensaje("No existe MATRICULA");
		else {
			try {
				
				if(a.getEstado()==2) {
					int ok = confirmar("? Desea cancelar retiro ?");
						if (ok == 0) {
							ar.eliminar(ar.buscar(leerNroRetiro()));
							ar.grabarRetiro();
							listar();
							editarFila();
						}
			
				}
				else {
					mensaje("Solo puede cancelar un retiro, si el Alumno se encuentra retirado ");
				}
							
			}
			catch(Exception e) {
				mensaje("No existe el n?mero de matricula o Alumno");
			}
			
			
		}
		
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		if(ar.tama?o()==0) {mensaje("No existen cursos registrados");}	
		else {
			txtBuscar.setEditable(true);
			limpieza();
			txtBuscar.requestFocus();
			btnBuscar.setEnabled(false);
		}
	}
	protected void actionPerformedBtnOk(ActionEvent arg0) {
		if(btnBuscar.isEnabled() == false) {
			try {
				int buscar = leerBusqueda();
				if( buscar >= 0) {
					Retiro r = ar.buscar(buscar);
					if(r != null) {
						txtMatricula.setText(""+r.getNumMatricula());
						txtRetiro.setText(""+r.getNumRetiro());
						btnBuscar.setEnabled(true);
						listar();
					}
					else
						mensaje("El c?digo no se encuentra registrado");
						btnBuscar.setEnabled(true);
						habilitarEntradas(false);
						txtBuscar.setEditable(false);
				}
				else 
					error("Ingrese un c?digo v?lido ", txtBuscar);
				
			}
			
			catch(Exception er) {
				error("Ingrese c?digo correcto ", txtBuscar);
				
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRetiro) {
			mouseClickedTblRetiro(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == tblRetiro) {
			mouseEnteredTblRetiro(e);
		}
		if (e.getSource() == btnOk) {
			mouseEnteredBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(e);
		}
		if (e.getSource() == btnGrabar) {
			mouseEnteredBtnGrabar(e);
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
	protected void mouseEnteredBtnGrabar(MouseEvent e) {
		btnGrabar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnOk(MouseEvent e) {
		btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredTblRetiro(MouseEvent e) {
		tblRetiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblRetiro) {
			keyReleasedTblRetiro(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtMatricula) {
			keyTypedTxtMatricula(e);
		}
	}
	protected void keyReleasedTblRetiro(KeyEvent e) {
		habilitarRegistro(false);
		habilitarBotones(true);
		editarFila();
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);

	}
	protected void mouseClickedTblRetiro(MouseEvent e) {
		habilitarRegistro(false);
		habilitarBotones(true);
		editarFila();
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);

	}
	protected void keyTypedTxtMatricula(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
}
