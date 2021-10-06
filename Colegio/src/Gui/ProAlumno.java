package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Arreglos.ArregloAlumnos;
import Clases.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

public class ProAlumno extends JDialog implements ActionListener, MouseListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField txtCodigoAlumno;
	private JTextField txtNombresAlumno;
	private JTextField txtApellidosAlumno;
	private JTextField txtDniAlumno;
	private JTextField txtEdadAlumno;
	private JTextField txtCelularAlumno;
	private JComboBox<Object> cboEstadoAlumno;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	DefaultTableModel model = new DefaultTableModel();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProAlumno dialog = new ProAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProAlumno() {
		setTitle("Mantenimiento | Alumno");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProAlumno.class.getResource("/Gui/img/estudiar.png")));
		setBounds(100, 100, 700, 489);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(26, 24, 62, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel.setBounds(26, 50, 62, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(26, 78, 62, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Dni");
		lblNewLabel_3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(26, 106, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Edad");
		lblNewLabel_4.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(26, 134, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Celular");
		lblNewLabel_5.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(26, 162, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(26, 191, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.addActionListener(this);
		txtCodigoAlumno.setBounds(98, 21, 70, 20);
		contentPanel.add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		txtNombresAlumno = new JTextField();
		txtNombresAlumno.addKeyListener(this);
		txtNombresAlumno.setBounds(98, 47, 209, 20);
		contentPanel.add(txtNombresAlumno);
		txtNombresAlumno.setColumns(10);
		
		txtApellidosAlumno = new JTextField();
		txtApellidosAlumno.addKeyListener(this);
		txtApellidosAlumno.setBounds(98, 75, 209, 20);
		contentPanel.add(txtApellidosAlumno);
		txtApellidosAlumno.setColumns(10);
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.addKeyListener(this);
		txtDniAlumno.setBounds(98, 103, 89, 20);
		contentPanel.add(txtDniAlumno);
		txtDniAlumno.setColumns(10);
		
		txtEdadAlumno = new JTextField();
		txtEdadAlumno.setBounds(98, 131, 89, 20);
		contentPanel.add(txtEdadAlumno);
		txtEdadAlumno.setColumns(10);
		
		txtCelularAlumno = new JTextField();
		txtCelularAlumno.setBounds(98, 159, 89, 20);
		contentPanel.add(txtCelularAlumno);
		txtCelularAlumno.setColumns(10);
		
		cboEstadoAlumno = new JComboBox<Object>();
		cboEstadoAlumno.addMouseListener(this);
		cboEstadoAlumno.setModel(new DefaultComboBoxModel<Object>(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstadoAlumno.setBounds(98, 187, 100, 22);
		contentPanel.add(cboEstadoAlumno);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnAdicionar.setForeground(Color.BLUE);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(556, 20, 106, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnModificar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.setBounds(556, 52, 106, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(556, 83, 106, 23);
		contentPanel.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 664, 153);
		contentPanel.add(scrollPane);
		
		table = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex,int columnIndex){
				return false;}
		};
		table.addKeyListener(this);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		model.addColumn("Código");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("Dni");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");
		table.setModel(model);
		
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(this);
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(98, 230, 89, 23);
		contentPanel.add(btnGuardar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(this);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(218, 230, 89, 23);
		contentPanel.add(btnLimpiar);
		
		//INICIALIZAR
		
		limpiar();
		txtCodigoAlumno.setEditable(false);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(ProAlumno.class.getResource("/Gui/img/lupaok.png")));
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(178, 19, 25, 24);
		contentPanel.add(btnBuscar);
		
		btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(ProAlumno.class.getResource("/Gui/img/checked3.png")));
		btnOk.addMouseListener(this);
		btnOk.addActionListener(this);
		btnOk.setBounds(207, 19, 25, 24);
		contentPanel.add(btnOk);
		
		/*Inicializar*/
		cboEstadoAlumno.setEnabled(false);
		listar();
		habilitarRegistro(false);
		editarFila();
		/* Cambiar color al JcomboBox*/
		UIManager.put( "ComboBox.disabledBackground", new Color(0,0,0,0) );
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		/* Ajustar ancho*/
		ajustarAnchoColumnas();
				
	}
	
	//Declarar variables
		ArregloAlumnos al = new ArregloAlumnos();
		private JButton btnBuscar;
		private JButton btnOk;
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtCodigoAlumno) {
			actionPerformedTxtCodigoAlumno(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		habilitarRegistro(true);
		btnAdicionar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnLimpiar.setEnabled(true);
		limpiar();
		cboEstadoAlumno.setEnabled(false);
		txtCodigoAlumno.setEditable(false);
		btnBuscar.setEnabled(true);
	}
	
	protected void actionPerformedBtnModificar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(false);
		if(al.tamaño()==0) {
			btnGuardar.setEnabled(false);
			habilitarRegistro(false);
			mensaje("No existen alumnos registrados");
			btnModificar.setEnabled(true);
		}
		else {
			editarFila();
			habilitarRegistro(true);
			btnGuardar.setEnabled(true);
			btnLimpiar.setEnabled(true);
			txtDniAlumno.setEditable(false);
			txtNombresAlumno.requestFocus();
			txtCodigoAlumno.setEditable(false);
			btnBuscar.setEnabled(true);
			
		}
	}
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		habilitarRegistro(false);
		//limpiar();
		if (al.tamaño() == 0)
			mensaje("No existen alumnos registrados");
		else {
			//editarFila();
			habilitarRegistro(false);
			txtCodigoAlumno.setEditable(false);
			btnBuscar.setEnabled(true);
			int estado = leerEstadoAlumno();
			Alumno x = al.buscarEstado(estado);
			if (x.getEstado() == 0) {
			int ok = confirmar("¿ Desea eliminar este registro ?");
				if (ok == 0) {
					al.eliminar(al.buscar(leerCodigoAlumnos()));
					listar();
					al.grabarAlumno();
					editarFila();
					
					/*limpiar();*/
				}
				
				if(ok==1) {

				}
			
			}
			else
				mensaje("Solo se puede eliminar alumnos en estado Registrado");
		}
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		int codAlumno = leerCodigoAlumnos(); 
		String nombres = leerNombres();
		if(nombres.length() > 0) {
			String apellidos = leerApellidos();
			if(apellidos.length() > 0 ) {
				String dni = leerDniAlumno();
				if(dni.length()>0) {
					try {
						int edad = leerEdadAlumno();
						if(leerEdadAlumno()>= 0) {
						try {
							int celular = leerCelularAlumno();
							if(leerCelularAlumno()>= 0) {
								int estado = leerEstadoAlumno();
								/*Validar DNI*/
								if(btnAdicionar.isEnabled() == false) {
									if(al.confirmarDNI(table,leerDniAlumno(),3)==false) {
										Alumno a = new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado);
										al.adicionar(a);
										al.grabarAlumno();
										btnAdicionar.setEnabled(true);
										listar();
										habilitarRegistro(false);
										mensaje("ALUMNO registrado exitosamente");
										
									}
									else
										error("El número de DNI ya se encuentra registrado", txtDniAlumno);
								}
									
									
								if(btnModificar.isEnabled() == false) {
										Alumno b = al.buscar(codAlumno);
										b.setNombres(nombres);
										b.setApellidos(apellidos);
										b.setDni(dni);
										b.setEdad(edad);
										b.setCelular(celular);
										b.setEstado(estado);
										al.grabarAlumno();
										mensaje("ALUMNO modificado");
										btnModificar.setEnabled(true);
										listar();
										habilitarRegistro(false);
									
								}	
	
							}
									else
									error("Ingrese un numero de celular válido" , txtCelularAlumno);
								}
							catch(Exception er) {
							error("Ingrese el numero de celular correctamente", txtCelularAlumno);
							}
						}
						else
							error("ingrese una edad correcta", txtEdadAlumno);
					}
					catch (Exception er) {
						error("Ingrese la edad correctamente", txtEdadAlumno);
					}
				}
				else
					error("Ingrese el dni correctamente", txtDniAlumno);
				
			}
			else
				error("Ingrese el Apellido correctamente", txtApellidosAlumno);
			
		}
		else
			error("Ingrese el Nombre correctamente", txtNombresAlumno);
	}
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		if(btnAdicionar.isEnabled() == false) {
			limpiar();
			
		}
		if(btnModificar.isEnabled() == false) {
			editarFila();
			limpiarMenosDni();
		}
		
		txtNombresAlumno.requestFocus();
	}
	
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		limpiarBuscarSinCod();
		habilitarRegistro(false);
		btnAdicionar.setEnabled(true);
		btnModificar.setEnabled(true);
		
		if(al.tamaño()==0) {
			mensaje("No existen alumnos registrados");
		}
			
			
			
		else {
			txtCodigoAlumno.setEditable(true);
			limpiarBuscar();
			txtCodigoAlumno.requestFocus();
			btnBuscar.setEnabled(false);
		}
			
		

	}
	
	protected void actionPerformedBtnOk(ActionEvent e) {
		consultar();
		
	}
	
	//Obtener 
	int leerCodigoAlumnos() {
		return Integer.parseInt(txtCodigoAlumno.getText().trim());
	}
	
	String leerNombres() {
		return txtNombresAlumno.getText().trim();
	}
	
	String leerApellidos() {
		return txtApellidosAlumno.getText().trim();
	}
	
	String leerDniAlumno() {
		return txtDniAlumno.getText().trim();
	}
	
	int leerEdadAlumno() {
		return Integer.parseInt(txtEdadAlumno.getText().trim());
	}
	
	int leerCelularAlumno() {
		return Integer.parseInt(txtCelularAlumno.getText().trim());
	}
	
	int leerEstadoAlumno() {
		return cboEstadoAlumno.getSelectedIndex();
	}

	
	void limpiar() {
		txtCodigoAlumno.setText(""+ al.codigoCorrelativo());
		txtNombresAlumno.setText("");
		txtApellidosAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		txtApellidosAlumno.setText("");
		cboEstadoAlumno.setSelectedIndex(0);	
	}
	
	void limpiarMenosDni() {
		txtNombresAlumno.setText("");
		txtApellidosAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		txtApellidosAlumno.setText("");
	}
	
	void limpiarBuscar() {
		txtCodigoAlumno.setText(""+2020);
		txtNombresAlumno.setText("");
		txtApellidosAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		txtApellidosAlumno.setText("");
		cboEstadoAlumno.setSelectedIndex(0);	
	}
	
	void limpiarBuscarSinCod() {
		txtNombresAlumno.setText("");
		txtApellidosAlumno.setText("");
		txtDniAlumno.setText("");
		txtEdadAlumno.setText("");
		txtCelularAlumno.setText("");
		txtApellidosAlumno.setText("");
		cboEstadoAlumno.setSelectedIndex(0);	
	}
	
	
	//MENSAJE Y ERROR
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void consultar() {
		if(btnBuscar.isEnabled() == false) {
			try {
				int codigo = leerCodigoAlumnos();
				if(codigo >= 0) {
					Alumno x = al.buscar(codigo);
					if(x != null) {
						txtCodigoAlumno.setEditable(false);
						txtNombresAlumno.setText(x.getNombres());
						txtApellidosAlumno.setText(x.getApellidos());
						txtDniAlumno.setText(x.getDni());
						txtEdadAlumno.setText("" + x.getEdad());
						txtCelularAlumno.setText("" + x.getCelular());
						cboEstadoAlumno.setSelectedIndex(x.getEstado());
						btnBuscar.setEnabled(true);
						listar();
					}
					else
						mensaje("El código no se encuentra registrado");
						btnBuscar.setEnabled(true);
						habilitarRegistro(false);
						txtCodigoAlumno.setEditable(false);
				}
				else 
					error("Ingrese un código no válido ", txtCodigoAlumno);
				
			}
			
			catch(Exception er) {
				error("Ingrese un código correctamente ", txtCodigoAlumno);
				
			}
		}
		
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	String enTextoEstado(int i) {
		return (String) cboEstadoAlumno.getItemAt(i);
	}
	
	void habilitarRegistro(boolean ToF) {
		btnGuardar.setEnabled(ToF);
		btnLimpiar.setEnabled(ToF);
		txtNombresAlumno.setEditable(ToF);
		txtApellidosAlumno.setEditable(ToF);
		txtDniAlumno.setEditable(ToF);
		txtEdadAlumno.setEditable(ToF);
		txtCelularAlumno.setEditable(ToF);
		txtApellidosAlumno.setEditable(ToF);
		
	}
	
	void listar() {
		int posFila = 0;
		if (model.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (model.getRowCount() == al.tamaño() - 1)
			posFila = al.tamaño() - 1;
		if (posFila == al.tamaño())
			posFila --;
	model.setRowCount(0);
	Alumno p;
	for (int i=0; i< al.tamaño(); i++) {
		p = al.obtener(i);
		Object[] fila = { p.getCodAlumno(),
						p.getNombres(),
						p.getApellidos(),
						p.getDni(),
						p.getEdad(),
						p.getCelular(),
						enTextoEstado(p.getEstado()) };
						model.addRow(fila);
		}
	if (al.tamaño() > 0)
		table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila() {
		if (al.tamaño() == 0)
			limpiar();
		else {
			Alumno p = al.obtener(table.getSelectedRow());
			txtCodigoAlumno.setText("" + p.getCodAlumno());
			txtNombresAlumno.setText(p.getNombres());
			txtApellidosAlumno.setText(p.getApellidos());
			txtDniAlumno.setText(p.getDni());
			txtEdadAlumno.setText(""+p.getEdad());
			txtCelularAlumno.setText(""+p.getCelular());
			cboEstadoAlumno.setSelectedIndex(p.getEstado());
		}

	}
	
	//Eventos de mouse
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == table) {
			mouseEnteredTable(e);
		}
		if (e.getSource() == cboEstadoAlumno) {
			mouseEnteredCboEstadoAlumno(e);
		}
		if (e.getSource() == btnOk) {
			mouseEnteredBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(e);
		}
		if (e.getSource() == btnLimpiar) {
			mouseEnteredBtnLimpiar(e);
		}
		if (e.getSource() == btnGuardar) {
			mouseEnteredBtnGuardar(e);
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
	protected void mouseEnteredBtnGuardar(MouseEvent e) {
		btnGuardar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnLimpiar(MouseEvent e) {
		btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnBuscar(MouseEvent e) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredBtnOk(MouseEvent e) {
		btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredCboEstadoAlumno(MouseEvent e) {
		cboEstadoAlumno.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	/*---------------- FIN EVENTO DE MOUSE -----------------*/
	protected void mouseEnteredTable(MouseEvent e) {
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseClickedTable(MouseEvent e) {
		habilitarRegistro(false);
		habilitarBotones(true);
		editarFila();
		txtCodigoAlumno.setEditable(false);
		
	}
	
	private void habilitarBotones(boolean VoF) {
		btnAdicionar.setEnabled(VoF);
		btnModificar.setEnabled(VoF);
		btnEliminar.setEnabled(VoF);
		btnBuscar.setEnabled(VoF);
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(15));  // Codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));  // Nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(30));  // Apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(15));  // Dni
		tcm.getColumn(4).setPreferredWidth(anchoColumna(15));  // Edad
		tcm.getColumn(5).setPreferredWidth(anchoColumna(15));  // Celular
		tcm.getColumn(6).setPreferredWidth(anchoColumna(15));  // Estado
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == table) {
			keyReleasedTable(e);
		}
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDniAlumno) {
			keyTypedTxtDniAlumno(e);
		}
		if (e.getSource() == txtApellidosAlumno) {
			keyTypedTxtApellidosAlumno(e);
		}
		if (e.getSource() == txtNombresAlumno) {
			keyTypedTxtNombresAlumno(e);
		}
	}
	protected void keyTypedTxtNombresAlumno(KeyEvent e) {
		char a = e.getKeyChar();
		if((a< 'a' || a>'z') && (a< 'A' || a>'Z')&& (a>' ')&&(a<'á'||a>'ú')&&(a<'Á'||a>'Ú')) e.consume();
		
	}
	protected void keyTypedTxtApellidosAlumno(KeyEvent e) {
		char a = e.getKeyChar();
		if((a< 'a' || a>'z') && (a< 'A' || a>'Z')&& (a>' ')&&(a<'á'||a>'ú')&&(a<'Á'||a>'Ú')) e.consume();
	}
	protected void keyTypedTxtDniAlumno(KeyEvent e) {
		char a = e.getKeyChar();
		if(a<'0' || a>'9') e.consume();
	}
	protected void keyReleasedTable(KeyEvent e) {
		habilitarRegistro(false);
		habilitarBotones(true);
		editarFila();
		txtCodigoAlumno.setEditable(false);
		
	}
	protected void actionPerformedTxtCodigoAlumno(ActionEvent e) {
		consultar();
	}
}//Fin
