package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Principal extends JFrame implements ActionListener, MouseListener {

	private JPanel lblLogo;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenu mnNewMenu_5;
	private JMenuItem mntmMatricula;
	private JMenuItem mntmRetiro;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso;
	private JMenu mnAyuda;
	private JMenuItem mntmACercaDe;
	private JMenuItem mntmAlumno_1;
	private JLabel lblCole;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setAutoRequestFocus(false);
		setFont(new Font("Verdana", Font.PLAIN, 14));
		setTitle("Colegio La Merced");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Gui/img/estudiar.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 462);
		
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 0, 7, 0));
		menuBar.setForeground(Color.BLACK);
		menuBar.setBackground(new Color(152, 201, 241));
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.addMouseListener(this);
		mnNewMenu.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/mantenimiento.png")));
		menuBar.add(mnNewMenu);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addMouseListener(this);
		mntmAlumno.addActionListener(this);
		mntmAlumno.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/alumno.png")));
		mnNewMenu.add(mntmAlumno);
		
		mntmCurso = new JMenuItem("Curso");
		mntmCurso.addMouseListener(this);
		mntmCurso.addActionListener(this);
		mntmCurso.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/curso0.png")));
		mnNewMenu.add(mntmCurso);
		
		mnNewMenu_3 = new JMenu("Registro");
		mnNewMenu_3.addMouseListener(this);
		mnNewMenu_3.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/registro0.png")));
		menuBar.add(mnNewMenu_3);
		
		mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.addMouseListener(this);
		mntmMatricula.addActionListener(this);
		mntmMatricula.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/curso.png")));
		mnNewMenu_3.add(mntmMatricula);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addMouseListener(this);
		mntmRetiro.addActionListener(this);
		mntmRetiro.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/retiro.png")));
		mnNewMenu_3.add(mntmRetiro);
		
		mnNewMenu_4 = new JMenu("Consulta");
		mnNewMenu_4.addMouseListener(this);
		mnNewMenu_4.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/consulta.png")));
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem = new JMenuItem("Alumno - Curso");
		mntmNewMenuItem.addMouseListener(this);
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/alumno.png")));
		mnNewMenu_4.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Matricula - Retiro");
		mntmNewMenuItem_1.addMouseListener(this);
		mntmNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/curso.png")));
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		mnNewMenu_5 = new JMenu("Reporte");
		mnNewMenu_5.addMouseListener(this);
		mnNewMenu_5.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/reporte.png")));
		menuBar.add(mnNewMenu_5);
		
		mntmAlumno_1 = new JMenuItem("Alumno");
		mntmAlumno_1.addMouseListener(this);
		mntmAlumno_1.addActionListener(this);
		mntmAlumno_1.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/alumno.png")));
		mnNewMenu_5.add(mntmAlumno_1);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.addMouseListener(this);
		mnAyuda.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/ayuda.png")));
		menuBar.add(mnAyuda);
		
		mntmACercaDe = new JMenuItem("Acerca de Nosotros");
		mntmACercaDe.addMouseListener(this);
		mntmACercaDe.addActionListener(this);
		mntmACercaDe.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/group.png")));
		mnAyuda.add(mntmACercaDe);
		getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/Gui/img/cibertec.png")));
		lblNewLabel_1.setBounds(186, 132, 176, 110);
		getContentPane().add(lblNewLabel_1);
		 

	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmACercaDe) {
			actionPerformedMntmACercaDe(arg0);
		}
		if (arg0.getSource() == mntmAlumno_1) {
			actionPerformedMntmAlumno_1(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(arg0);
		}
		if (arg0.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(arg0);
		}
		if (arg0.getSource() == mntmMatricula) {
			actionPerformedMntmMatricula(arg0);
		}
		if (arg0.getSource() == mntmCurso) {
			actionPerformedMntmCurso(arg0);
		}
		if (arg0.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(arg0);
		}
	}
	protected void actionPerformedMntmAlumno(ActionEvent arg0) {
		ProAlumno alu=new ProAlumno();
		alu.setVisible(true);
		alu.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmCurso(ActionEvent arg0) {
		ProCurso cur=new ProCurso();
		cur.setVisible(true);
		cur.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmMatricula(ActionEvent arg0) {
		RegistroMatricula rmatri=new RegistroMatricula();
		rmatri.setVisible(true);
		rmatri.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmRetiro(ActionEvent arg0) {
		RegistroRetiro rtiro=new RegistroRetiro();
		rtiro.setVisible(true);
		rtiro.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent arg0) {
		ConsultaAluCurso alucu=new ConsultaAluCurso();
		alucu.setVisible(true);
		alucu.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent arg0) {
		ConsultaMatriRetiro matrire=new ConsultaMatriRetiro();
		matrire.setVisible(true);
		matrire.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmAlumno_1(ActionEvent arg0) {
		ReportAlum ralu=new ReportAlum();
		ralu.setVisible(true);
		ralu.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmACercaDe(ActionEvent arg0) {
		Desarrolladores desa=new Desarrolladores();
		desa.setVisible(true);
		desa.setLocationRelativeTo(this);
		
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == mntmACercaDe) {
			mouseEnteredMntmACercaDe(e);
		}
		if (e.getSource() == mntmAlumno_1) {
			mouseEnteredMntmAlumno_1(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			mouseEnteredMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			mouseEnteredMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmRetiro) {
			mouseEnteredMntmRetiro(e);
		}
		if (e.getSource() == mntmMatricula) {
			mouseEnteredMntmMatricula(e);
		}
		if (e.getSource() == mntmCurso) {
			mouseEnteredMntmCurso(e);
		}
		if (e.getSource() == mntmAlumno) {
			mouseEnteredMntmAlumno(e);
		}
		if (e.getSource() == mnAyuda) {
			mouseEnteredMnAyuda(e);
		}
		if (e.getSource() == mnNewMenu_5) {
			mouseEnteredMnNewMenu_5(e);
		}
		if (e.getSource() == mnNewMenu_4) {
			mouseEnteredMnNewMenu_4(e);
		}
		if (e.getSource() == mnNewMenu_3) {
			mouseEnteredMnNewMenu_3(e);
		}
		if (e.getSource() == mnNewMenu) {
			mouseEnteredMnNewMenu(e);
		}
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredMnNewMenu(MouseEvent e) {
		mnNewMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMnNewMenu_3(MouseEvent e) {
		mnNewMenu_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMnNewMenu_4(MouseEvent e) {
		mnNewMenu_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMnNewMenu_5(MouseEvent e) {
		mnNewMenu_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMnAyuda(MouseEvent e) {
		mnAyuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmAlumno(MouseEvent e) {
		mntmAlumno.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmCurso(MouseEvent e) {
		mntmCurso.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmMatricula(MouseEvent e) {
		mntmMatricula.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmRetiro(MouseEvent e) {
		mntmRetiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmNewMenuItem(MouseEvent e) {
		mntmNewMenuItem.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmNewMenuItem_1(MouseEvent e) {
		mntmNewMenuItem_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmAlumno_1(MouseEvent e) {
		mntmAlumno_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	protected void mouseEnteredMntmACercaDe(MouseEvent e) {
		mntmACercaDe.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
