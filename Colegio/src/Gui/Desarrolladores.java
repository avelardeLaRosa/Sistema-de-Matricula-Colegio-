package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Desarrolladores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAlexanderVelarde;
	private JLabel lblNewLabel;
	private JLabel lblProfErickRosas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Desarrolladores dialog = new Desarrolladores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Desarrolladores() {
		setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Desarrolladores.class.getResource("/Gui/img/group.png")));
		setTitle("Desarrolladores");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblJesusVelasquez = new JLabel("Jesus Velasquez");
			lblJesusVelasquez.setHorizontalAlignment(SwingConstants.CENTER);
			lblJesusVelasquez.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
			lblJesusVelasquez.setBounds(114, 80, 183, 39);
			contentPanel.add(lblJesusVelasquez);
		}
		
		lblAlexanderVelarde = new JLabel("Alexander Velarde");
		lblAlexanderVelarde.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlexanderVelarde.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
		lblAlexanderVelarde.setBounds(114, 129, 194, 39);
		contentPanel.add(lblAlexanderVelarde);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Desarrolladores.class.getResource("/Gui/img/guiDesa.png")));
		lblNewLabel.setBounds(10, 11, 66, 81);
		contentPanel.add(lblNewLabel);
		
		lblProfErickRosas = new JLabel("Prof. Erick Rosas Wan Kun");
		lblProfErickRosas.setBounds(265, 236, 159, 14);
		contentPanel.add(lblProfErickRosas);
	}
}
