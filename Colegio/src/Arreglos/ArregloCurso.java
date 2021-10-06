package Arreglos;
import java.io.BufferedReader;
import java.io.FileReader;
/*Importa clase filewriter y printwriter para escritura y guardado*/
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import Clases.Curso;

public class ArregloCurso{
	
	private ArrayList<Curso>curso;
	
	public ArregloCurso(){
		curso = new ArrayList<Curso>();	
		cargarCurso();
		}
	
	public void adicionar(Curso c){
		curso.add(c);
		Collections.sort(curso);
	}
	
	public Curso obtener(int pos){
		return curso.get(pos);
	}
	
	public int tamaño(){
		return curso.size();
	}
	
	public void eliminar(Curso c){
		curso.remove(c);
	}
	
	/*Busqueda de curso*/
	public Curso buscar(int codigoCurso) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigoAsignatura() == codigoCurso)
				return obtener(i);
		return null;
	}
	public boolean buscarCodigo(JTable tabla,int valor, int columna){
		boolean existe=false;
		for(int i=0; i<tabla.getRowCount(); i++){
			if(tabla.getValueAt(i, columna).equals(valor))
				existe=true;}
		return existe;
	}
	
	/*Grabar curso en archivo txt*/
	public void grabarCurso() {
		
		try {
			PrintWriter pw;
			String linea;
			Curso c;
			pw=new PrintWriter(new FileWriter("curso.txt"));
			for (int i=0; i<tamaño(); i++) {
				c = obtener(i);
				linea= 	c.getCodigoAsignatura() + ";" +
						c.getAsignatura() + ";" +
						c.getCiclo() + ";" +
						c.getNroCreditos() + ";" +
						c.getCantHoras();
				pw.println(linea);
	
			}
			pw.close();	
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
		public void cargarCurso() {
			try {
				BufferedReader br;
				String linea;
				String[] s;
				int codigoCurso,ciclo,creditos,horas;
				String asignatura;
				br = new BufferedReader(new FileReader("curso.txt"));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codigoCurso = Integer.parseInt(s[0].trim());
					asignatura = s[1].trim();
					ciclo = Integer.parseInt(s[2].trim());
					creditos = Integer.parseInt(s[3].trim());
					horas = Integer.parseInt(s[4].trim());
					adicionar(new Curso(asignatura, ciclo,creditos , horas, codigoCurso));
				}
				br.close();
			}
			catch (Exception e) {
			}
		}
	}
	
	
	

