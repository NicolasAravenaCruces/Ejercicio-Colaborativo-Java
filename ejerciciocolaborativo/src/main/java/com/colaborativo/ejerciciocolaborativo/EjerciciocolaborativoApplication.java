package com.colaborativo.ejerciciocolaborativo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

@SpringBootApplication
public class EjerciciocolaborativoApplication {



/*Ejercicio
vamos a pedir al usuario que ingrese la cantidad alumnos a los cuales les asignará una nota, luego de que ingrese la catidad de notas de cada alumnos, se va a desplegar un menú.
las opciones del menú serán la siguentes:
1.- mostrar el promedio de notas
2.- mostrar si la nota es aprobatoria o reprobatoria
3.- mosatrar si la nota está por sobre o por debajo del promedio del curso
*/

//funciones
// 1.- mostrar el promedio de notas
public static Double promedioNotas(ArrayList<Double> notas){
	Double suma =0.0;
	for (int i = 0; i < notas.size(); i++) {
		suma= suma+notas.get(i);
	}
	return suma/notas.size();
}

// 2.- mostrar si la nota es aprobatoria o reprobatoria 
// verificar si esta aprobado o aprobado el promedio del alumno 

public static Boolean aprobado(ArrayList<Double> notas,Double notaAprobatoria){
	Double promedio = promedioNotas(notas);
	if(promedio >= 4.0){
		return true;
	}
	else{

		return false;
	}
}

//3.- mosatrar si la nota está por sobre o por debajo del promedio del curso

public static void sobrePromedio(Double promedioGeneral,ArrayList<Double> notas,String nomAlum){
	Double promedioAlumno = promedioNotas(notas);
	if(promedioAlumno> promedioGeneral){
		System.out.println("El alumno "+ nomAlum+" esta sobre el promedio");

	}
	else if(promedioAlumno == promedioGeneral){
		System.out.println("El alumno "+ nomAlum+" tiene un promedio igual al promedio general");

	}
	else{
		System.out.println("El alumno "+ nomAlum+" esta bajo el promedio");
	}

}


	public static void main(String[] args) {

		
		// lo que hice yo 
		// pedir cuantos alumnos seran y cuantas notas seran 
		/*System.out.print("Cuantos alumnos ingresaras?: ");
		int cantAlumnos = teclado.nextInt();
		System.out.print("Cuantas notas ingresaras por alumno?: ");
		int cantNotas = teclado.nextInt();
		//array para guardar las notas
		ArrayList<Integer> arrayNotas = new ArrayList<Integer>();
        	      
	    for (int i = 0; i < cantAlumnos; i++) {
		 int cont=0;
		 System.out.println("Ingresa notas del alumno "+ (i+1) );
		 while (cont<=cantNotas) {
			System.out.print("Ingresa nota: ");
			int nota = teclado.nextInt();
			if(arrayNotas.size()<=cantNotas){
				arrayNotas.add(nota);
			    alumNota.put(i, arrayNotas); 
			}
			cont++;
		  }
	    }
        System.out.println(alumNota);*/


		// lo que haremos con la pame
		String nomAlmun="";
		Double notaAprobatoria = 4.0;
		HashMap <String, ArrayList<Double>> libroClase = new HashMap<String, ArrayList<Double>>();
		
		Scanner teclado = new Scanner(System.in);
		int cantAlum;
		int cantNotas;
        // verificar que los alumnos no sean 0 
		do {
			System.out.print("Indique cantidad de alumnos a ingresar : ");
			cantAlum = teclado.nextInt(); // pide cantidad de alumnos
			if (cantAlum<=0) {
				System.out.println("La cantidad de alumnos debe ser mayor a 0, vuelve a ingresar");
			}

			
		} while (cantAlum<0);
         // verificar que las notas no sean 0 
		do {
			System.out.print("Indique cantidad de notas a ingresar : ");
		    cantNotas= teclado.nextInt(); // pide cantidad de notas 
			if (cantNotas<=0) {
				System.out.println("La cantidad de notas debe ser mayor a 0, vuelve a ingresar");
			}
			
		} while (cantNotas<0);
        // guardar las notas + el nombre del alumno en un hashmap 
		for (int i = 1; i <= cantAlum; i++) {
			ArrayList<Double> notasAlumnos = new ArrayList<Double>(); 
			teclado.nextLine();
			System.out.print("Ingrese nombre del alumno: ");
			nomAlmun = teclado.nextLine();
			for (int x = 1; x <= cantNotas; x++) {
				System.out.print("Ingrese nota "+x+" del alumno "+nomAlmun+" :");
			    Double nota = teclado.nextDouble();
				notasAlumnos.add(nota);
			}	
			libroClase.put(nomAlmun, notasAlumnos);	
			//notasAlumnos.clear();
			//verificar si la defino global, donde deberia limpiar el arreglo 
		}

		/*for(String i : libroClase.keySet()){
			System.out.println("key: "+ i + " Valor:" + libroClase.get(i));
		}*/

		//MENU
        int opcion=1;
		while(opcion!=0){
			do {
				System.out.println("**************Comienzo de Menú***************");
				System.out.println("Bienvenido/a");
				System.out.println("Seleccione 1 si quiere obtener el promedio de las notas.");
				System.out.println("Seleccione 2 si quiere ver si el alumno aprueba o reprueba");
				System.out.println("Seleccione 3 para ver si la nota está sobre o por debajo del promedio general");
				System.out.println("Seleccione 0 para salir del menú");
				opcion=teclado.nextInt();

			} while (opcion < 0 || opcion > 3);
			if(opcion==1){
				for(String i : libroClase.keySet()){
					Double promAlumno = promedioNotas(libroClase.get(i));
		            System.out.println("El promedio del alumno "+ i + " es de:" + promAlumno);
				}
			}
			else if(opcion ==2){
				for(String i : libroClase.keySet()){
					Boolean aprobar = aprobado(libroClase.get(i), notaAprobatoria);
					if (aprobar) {
						System.out.println("El alumno "+i+" esta aprobado");
					}
					else{
						System.out.println("El alumno "+i+" esta reprobado");
					}
				}
			}
			else if(opcion==3){
				Double sumaPromedio=0.0;
				for(String i : libroClase.keySet()){
					sumaPromedio = sumaPromedio + promedioNotas(libroClase.get(i));
					
				}
				//saca el promedio general
				Double promedioGeneral = sumaPromedio/cantAlum;

				for(String i : libroClase.keySet()){
				    sobrePromedio(promedioGeneral, libroClase.get(i), i);
				}


			}




			

          
		}







		





       
		
		







	}
}



