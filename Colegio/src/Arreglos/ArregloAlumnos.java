package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Clases.Alumno;
import Clases.Curso;

public class ArregloAlumnos {
	
	private ArrayList <Alumno> alumno;
	
	public ArregloAlumnos() {
		alumno = new ArrayList <Alumno> ();
		cargarAlumno();
		
	}
	
	public void adicionar(Alumno x) {
		alumno.add(x);
	}
	
	public int tamaño() {
		return alumno.size();
	}
	
	public Alumno obtener(int pos) {
		return alumno.get(pos);
	}
	
	
	public Alumno buscar(int codigoalumno) {
		for (int i=0; i < tamaño() ; i++)
			if (obtener(i).getCodAlumno() == codigoalumno) 
				return obtener(i);
		return null;
	}
	/*VALIDAR DNI REPETIDO*/
	public Alumno buscarDni(String dnialumno) {
		for (int i=0; i < tamaño() ; i++)
			if (obtener(i).getDni().equals(dnialumno)) 
				return obtener(i);
		return null;
	}
	
	public boolean confirmarDNI(JTable tabla,String info,int columna) {
		boolean Existe=false;
		for(int i =0 ; i<tabla.getRowCount();i++) {
			if(tabla.getValueAt(i,columna).equals(info)) {
				Existe=true;
			}
		}
		return Existe;
		}
	
	
	/*---------*/
	
	public Alumno buscarEstado(int estado) {
		for (int i=0; i < tamaño() ; i++)
			if (obtener(i).getEstado() == estado) 
				return obtener(i);
		return null;
	}
	
	public void eliminar(Alumno x) {
		alumno.remove(x);
	}
	
	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 202010001;
		else
			return obtener(tamaño()-1).getCodAlumno() + 1;
	}
	
	/*Grabar curso en archivo txt*/
	public void grabarAlumno() {
		
		try {
			PrintWriter pw;
			String linea;
			Alumno a;
			pw=new PrintWriter(new FileWriter("alumno.txt"));
			for (int i=0; i<tamaño(); i++) {
				a = obtener(i);
				linea= 	a.getCodAlumno() + ";" +
						a.getNombres() + ";" +
						a.getApellidos() + ";" +
						a.getDni() + ";" +
						a.getEdad()+";"+
						a.getCelular()+";"+
						a.getEstado();
				pw.println(linea);
	
			}
			pw.close();	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	public void cargarAlumno() {
			try {
				BufferedReader br;
				String linea;
				String[] s;
				int codAlumno,edad,celular,estado;
				String nombres,apellidos,dni;
				br = new BufferedReader(new FileReader("alumno.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codAlumno = Integer.parseInt(s[0].trim());
					nombres = s[1].trim();
					apellidos = s[2].trim();
					dni = s[3].trim();
					edad = Integer.parseInt(s[4].trim());
					celular=Integer.parseInt(s[5].trim());
					estado=	Integer.parseInt(s[6].trim());	
					adicionar(new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
	
	
	
	
}//Final
