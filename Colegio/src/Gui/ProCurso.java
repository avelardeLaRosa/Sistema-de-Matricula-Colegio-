/*
   FALTA INGRESAR CODIGO EN ORDEN 
 */
package Gui;

import Clases.Alumno;
/*Se importa la clase curso, arregloCurso y el tablemodel para modificacion en el jtable*/
import Clases.Curso;
import Clases.Matricula;
import Arreglos.ArregloAlumnos;
import Arreglos.ArregloCurso;
import Arreglos.ArregloMatricula;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.awt.event.KeyListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

public class ProCurso extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCod;
	private JTextField txtAsig;
	private JTextField txtCre;
	private JTextField txtHor;
	private JTable tblCurso;
	private JButton btnAdicionar;
	private JButton btnGrabar;
	private JButton btnModificar;
	private JButton btnEliminar;
	
	
	ArregloCurso ac=new ArregloCurso();
	DefaultTableModel model=new DefaultTableModel();
	private JComboBox comboCiclo;
	private JLabel lblBuscar;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton button;
	ArregloMatricula ar = new ArregloMatricula();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProCurso dialog = new ProCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProCurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProCurso.class.getResource("/Gui/img/estudiar.png")));
		setTitle("Mantenimiento| Curso");
		setBounds(100, 100, 629, 487);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("C\u00F3digo");
			lblCodigo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblCodigo.setBounds(10, 35, 107, 20);
			contentPanel.add(lblCodigo);
		}
		{
			JLabel lblAsignatura = new JLabel("Asignatura");
			lblAsignatura.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblAsignatura.setBounds(10, 60, 107, 20);
			contentPanel.add(lblAsignatura);
		}
		{
			JLabel lblNewLabel = new JLabel("Ciclo");
			lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 85, 107, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de Cr\u00E9ditos");
			lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(10, 110, 139, 20);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas");
			lblCantidadDeHoras.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblCantidadDeHoras.setBounds(10, 135, 139, 20);
			contentPanel.add(lblCantidadDeHoras);
		}
		{
			txtCod = new JTextField();
			txtCod.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtCod.addKeyListener(this);
			txtCod.setBounds(184, 32, 122, 20);
			contentPanel.add(txtCod);
			txtCod.setColumns(10);
		}
		{
			txtAsig = new JTextField();
			txtAsig.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtAsig.addKeyListener(this);
			txtAsig.setColumns(10);
			txtAsig.setBounds(184, 60, 122, 20);
			contentPanel.add(txtAsig);
		}
		{
			txtCre = new JTextField();
			txtCre.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtCre.addKeyListener(this);
			txtCre.setColumns(10);
			txtCre.setBounds(184, 110, 122, 20);
			contentPanel.add(txtCre);
		}
		{
			txtHor = new JTextField();
			txtHor.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			txtHor.addKeyListener(this);
			txtHor.setColumns(10);
			txtHor.setBounds(184, 135, 122, 20);
			contentPanel.add(txtHor);
		}
		{
			btnAdicionar = new JButton("Adicionar");
			btnAdicionar.setForeground(Color.BLUE);
			btnAdicionar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnAdicionar.addMouseListener(this);
			btnAdicionar.addActionListener(this);
			btnAdicionar.setBounds(476, 32, 107, 23);
			contentPanel.add(btnAdicionar);
		}
		{
			btnModificar = new JButton("Modificar");
			btnModificar.setForeground(Color.BLUE);
			btnModificar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnModificar.addMouseListener(this);
			btnModificar.addActionListener(this);
			btnModificar.setBounds(476, 59, 107, 23);
			contentPanel.add(btnModificar);
		}
		{
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnEliminar.setForeground(Color.BLUE);
			btnEliminar.addMouseListener(this);
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(476, 85, 107, 23);
			contentPanel.add(btnEliminar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 177, 593, 219);
			contentPanel.add(scrollPane);
			/*Adicion de filas y columnas*/
			tblCurso = new JTable(){
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex,int columnIndex){
					return false;}
			};
			tblCurso.addKeyListener(this);
			tblCurso.addMouseListener(this);
	
			scrollPane.setViewportView(tblCurso);
			model.addColumn("Código");
			model.addColumn("Asignatura");
			model.addColumn("Ciclo");
			model.addColumn("Nro. Creditos");
			model.addColumn("Cant. Horas");
			tblCurso.setModel(model);
			
			btnGrabar = new JButton("Grabar");
			btnGrabar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnGrabar.addMouseListener(this);
			btnGrabar.addActionListener(this);
			btnGrabar.setBounds(316, 31, 89, 23);
			contentPanel.add(btnGrabar);
			
		
			
			habilitarEntradas(false);
			txtCod.setEditable(false);
			
			
			
			comboCiclo = new JComboBox();
			comboCiclo.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			comboCiclo.addMouseListener(this);
			comboCiclo.setModel(new DefaultComboBoxModel(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto"}));
			comboCiclo.setBounds(184, 85, 122, 20);
			contentPanel.add(comboCiclo);
			
			comboCiclo.setEnabled(false);
			
			lblBuscar = new JLabel("Buscar ");
			lblBuscar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblBuscar.setBounds(10, 410, 63, 20);
			contentPanel.add(lblBuscar);
			
			txtBuscar = new JTextField();
			txtBuscar.setBounds(75, 407, 130, 20);
			contentPanel.add(txtBuscar);
			txtBuscar.setColumns(10);
			
			btnBuscar = new JButton("");
			btnBuscar.addMouseListener(this);
			btnBuscar.addActionListener(this);
			btnBuscar.setIcon(new ImageIcon(ProCurso.class.getResource("/Gui/img/lupaok.png")));
			btnBuscar.setBounds(215, 407, 28, 22);
			contentPanel.add(btnBuscar);
			
			button = new JButton("");
			button.addMouseListener(this);
			button.addActionListener(this);
			button.setIcon(new ImageIcon(ProCurso.class.getResource("/Gui/img/checked3.png")));
			button.setBounds(252, 406, 28, 23);
			contentPanel.add(button);
			listar();
			editarFila();
			txtBuscar.setEditable(false);
			
		}
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnGrabar.setEnabled(true);
		txtCod.setEditable(true);
		
		limpieza();
		habilitarEntradas(true);
		txtCod.requestFocus();
		comboCiclo.setEnabled(true);
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
					int ciclo = leerCiclo();
					try{if(leerCodigo()>0){int codigo = leerCodigo();
					try{if(leerCreditos()>0){int credito = leerCreditos();
					try{if(leerHoras()>0){int hora = leerHoras();
					String asignatura = leerAsignatura();
					if (asignatura.length() > 0){
						if (btnAdicionar.isEnabled() == false){
							if(ac.buscarCodigo(tblCurso, codigo, 0)==false){
							Curso nuevo = new Curso(asignatura, ciclo, credito, hora, codigo);
							ac.adicionar(nuevo);
							ac.grabarCurso();
							btnAdicionar.setEnabled(true);
							confirmacion("CURSO REGISTADO EXITOSAMENTE");}
							else {
								error("CODIGO se encuentra registrado", txtCod);
									btnAdicionar.setEnabled(true);
									limpieza();
								}
							}
						if (btnModificar.isEnabled() == false){
							Curso c = ac.buscar(codigo);
							c.setAsignatura(asignatura);
							c.setCiclo(ciclo);
							c.setNroCreditos(credito);
							c.setCantHoras(hora);
							c.setCodigoAsignatura(codigo);
							ac.grabarCurso();
							btnModificar.setEnabled(true);
							confirmacion("CURSO MODIFICADO SATISFACTORIAMENTE");}
						listar();
						habilitarEntradas(false);
						txtCod.setEditable(false);
						comboCiclo.setEnabled(false);
						}else error("Ingrese ASIGNATURA correcta", txtAsig);
						}else{mensaje("Ingrese HORA correcta");}}catch(Exception e){mensaje("Ingrese HORA correcta");}
						}else{mensaje("Ingrese CREDITO correcto");}}catch(Exception e){mensaje("Ingrese CREDITO correcto");}
						}else{mensaje("Ingrese CODIGO valido");}}catch(Exception e){mensaje("Ingrese CODIGO valido");}		
				}//fin clase
	
	/*LECTURA DE DATA*/
	String leerAsignatura(){return txtAsig.getText().trim();}
	int leerCiclo(){return comboCiclo.getSelectedIndex();}
	int leerCreditos(){return Integer.parseInt(txtCre.getText().trim());}
	int leerHoras(){return Integer.parseInt(txtHor.getText().trim());}
	int leerCodigo(){return Integer.parseInt(txtCod.getText().trim());}
	int leerBusqueda(){return Integer.parseInt(txtBuscar.getText().trim());}
	
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		txtCod.setEditable(false);
		txtBuscar.setEditable(false);
		btnBuscar.setEnabled(true);
		if (ac.tamaño() == 0) {
			btnGrabar.setEnabled(false);
			habilitarEntradas(false);
			mensaje("No existe curso");	
		}
		else {
			editarFila();
			btnGrabar.setEnabled(true);
			habilitarEntradas(true);
			txtAsig.requestFocus();
			comboCiclo.setEnabled(true);
		}
	}

	void habilitarEntradas(boolean sino) {
		
		btnGrabar.setEnabled(sino);
		txtAsig.setEditable(sino);
		txtCre.setEditable(sino);
		txtHor.setEditable(sino);
		
	}
	void confirmacion(String s){
		JOptionPane.showMessageDialog(this,s);
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void editarFila() {
		if (ac.tamaño() == 0)
			limpieza();
		else {
			Curso c = ac.obtener(tblCurso.getSelectedRow());
			txtCod.setText( "" + c.getCodigoAsignatura());
			txtAsig.setText(c.getAsignatura());
			comboCiclo.setSelectedIndex(c.getCiclo());
			txtCre.setText( "" + c.getNroCreditos());
			txtHor.setText( "" + c.getCantHoras());
		}
		
	}
	void limpieza() {
		txtCod.setText("");
		txtAsig.setText("");
		txtCre.setText("");
		txtHor.setText("");
		comboCiclo.setSelectedIndex(0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	String cboPrint(int i) {
		return (String)comboCiclo.getItemAt(i);
	}
	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = tblCurso.getSelectedRow();
		if (model.getRowCount() == ac.tamaño() - 1)
			posFila = ac.tamaño() - 1;
		if (posFila == ac.tamaño())
			posFila --;
		model.setRowCount(0);
		Curso c;
		for (int i=0; i<ac.tamaño(); i++) {
			c = ac.obtener(i);
			Object[] fila = {c.getCodigoAsignatura(),
							c.getAsignatura(),
							cboPrint(c.getCiclo()),
							c.getNroCreditos(),
							c.getCantHoras()};
			
							  model.addRow(fila);
		}
		if (ac.tamaño() > 0)
			tblCurso.getSelectionModel().setSelectionInterval(posFila, posFila);
		}
	
	

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		// Un curso puede eliminarse sólo cuando ningún alumno esté matriculado en él
		int codcurso=leerCodigo();
		Matricula mt = ar.buscarCodigoCursoRegistrado(codcurso);
		
		if(ac.tamaño()>0) {
			btnAdicionar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnGrabar.setEnabled(false);
			txtBuscar.setEditable(false);
			btnBuscar.setEnabled(true);
			habilitarEntradas(false);
			if (ac.tamaño() == 0)
				mensaje("No existen cursos");
			else {
					if(mt == null) {
						//editarFila();
						habilitarEntradas(false);
						int ok = confirmar("¿ Desea eliminar el registro ?");
						if (ok == 0) {
							ac.eliminar(ac.buscar(leerCodigo()));
							ac.grabarCurso();
							listar();
							editarFila();
					}
				
				}
					else
						mensaje("No puede eliminar un curso, mientras existan alumnos matriculados");
			}
			
		}
			else 
			mensaje("Se encuentran alumnos registrados en el curso");
		//Validar
		
		
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtCod.setEditable(false);
		txtBuscar.setText(null);
		if(ac.tamaño()==0) {mensaje("No existen cursos registrados");}	
		else {
			txtBuscar.setEditable(true);
			limpieza();
			txtBuscar.requestFocus();
			btnBuscar.setEnabled(false);
		}
			
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		if(btnBuscar.isEnabled() == false) {
			try {
				int buscar = leerBusqueda();
				if( buscar >= 0) {
					Curso c = ac.buscar(buscar);
					if(c != null) {
						txtCod.setText(""+c.getCodigoAsignatura());
						txtAsig.setText(c.getAsignatura());
						txtCre.setText(""+c.getNroCreditos());
						txtHor.setText(""+c.getCantHoras());
						comboCiclo.setSelectedIndex(c.getCiclo());
						btnBuscar.setEnabled(true);
						listar();
					}
					else
						mensaje("El código no se encuentra registrado");
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
		if (e.getSource() == tblCurso) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == button) {
			mouseEnteredButton(e);
		}
		if (e.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(e);
		}
		if (e.getSource() == comboCiclo) {
			mouseEnteredComboCiclo(e);
		}
		if (e.getSource() == btnGrabar) {
			mouseEnteredBtnGrabar(e);
		}
		if (e.getSource() == tblCurso) {
			mouseEnteredTblCurso(e);
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
	protected void mouseEnteredTblCurso(MouseEvent e) {
		tblCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnGrabar(MouseEvent e) {
		btnGrabar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredComboCiclo(MouseEvent e) {
		comboCiclo.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredButton(MouseEvent e) {
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseClickedTable(MouseEvent e) {
		btnBuscar.setEnabled(true);
		habilitarEntradas(false);
		txtCod.setEditable(false);
		editarFila();
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtBuscar.setEditable(false);
		
	}
	
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblCurso) {
			keyReleasedTblCurso(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtAsig) {
			keyTypedTxtAsig(e);
		}
		if (e.getSource() == txtHor) {
			keyTypedTxtHor(e);
		}
		if (e.getSource() == txtCre) {
			keyTypedTxtCre(e);
		}
		if (e.getSource() == txtCod) {
			keyTypedTxtCod(e);
		}
	}
	protected void keyReleasedTblCurso(KeyEvent e) {
		btnBuscar.setEnabled(true);
		habilitarEntradas(false);
		txtCod.setEditable(false);
		editarFila();
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		txtBuscar.setEditable(false);
	}
	protected void keyTypedTxtCod(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
	protected void keyTypedTxtCre(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
	protected void keyTypedTxtHor(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
	protected void keyTypedTxtAsig(KeyEvent e) {
		char a = e.getKeyChar();
		if((a< 'a' || a>'z') && (a< 'A' || a>'Z')&& (a>' ')&&(a<'á'||a>'ú')&&(a<'Á'||a>'Ú')) e.consume();
	}
}//FIN DE CLASE
