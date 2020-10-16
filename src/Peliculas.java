import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

interface RentaPeliculas{
	Scanner ent = new Scanner(System.in);
	public void insertar();
	public void eliminar();
	public void mostrarCima();
	public void mostrarCantidadElementos();
	
}//interface RentaPeliculas


class Pelicula {
	private String titulo;
	private String genero;
	
	public Pelicula() {}
	public Pelicula(String titulo, String genero) {
		this.titulo = titulo;
		this.genero = genero;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", genero=" + genero + "]";
	}
}//class Pelicula



class ImplementacionPilaEstatica implements RentaPeliculas{
	Pelicula peliculas[];
	int cima;
	
	public ImplementacionPilaEstatica() {}
	public ImplementacionPilaEstatica(Pelicula[] peliculas, int cima) {
		this.peliculas = peliculas;
		this.cima = cima;
	}

	public ImplementacionPilaEstatica(int tamaño) {
		peliculas = new Pelicula [tamaño];
		cima = -1;
	}
		
	public void insertar() {
		if(cima>=peliculas.length-1){
            System.out.println("La pila está llena");
        }else
        {
        	cima+=1;
            System.out.println("Ingresa el título de la pelicula");
            peliculas[cima].setTitulo(ent.nextLine());
            System.out.println("Ingresa el genero de la pelicula");
            peliculas[cima].setGenero(ent.nextLine());
        }
		
        
	}

	public void eliminar() {
		if(cima==-1){
            System.out.println("La pila esta vacia");
        }else{
            System.out.println("Se elimino un elemento de la pila");
            peliculas[cima].setTitulo("");
            peliculas[cima].setGenero("");
            cima--;
        }
	}

	
	public void mostrarCima() {
		System.out.println("Titulo: " + peliculas[cima].getTitulo());
		System.out.println("Titulo: " + peliculas[cima].getGenero());
	}


	public void mostrarCantidadElementos() {
	System.out.println("Hay " + cima + " pelicula(s) disponible(s) para rentar");
		
	}
	
}//class ImplementacionPilaEstatica



class ImplementacionPilaDinamica implements RentaPeliculas{
	Stack<Pelicula> peliculas = new Stack <Pelicula> ();
	
	public void insertar() {
	System.out.println("Ingresa el titulo de la pelicula");
	String t = ent.nextLine();
	System.out.println("Ingresa el genero de la pelicula");
	String g = ent.nextLine();
	
	Pelicula p1 = new Pelicula(t,g);
	peliculas.push(p1);
	
	}
	
	public void eliminar() {
	peliculas.pop();
		
	}

	public void mostrarCima() {
	peliculas.peek();
	}

	
	public void mostrarCantidadElementos() {
		
		
	}
	
}//class ImplementacionPilaDinamica

public class Peliculas {

	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		boolean salir = false;
		
		do {
			System.out.println("1) Usar pila estática");
			System.out.println("2) Usar pila dinámica");
			System.out.println("3) Salir");
			
			try {
				System.out.println("Elije una opción: ");
				int op = ent.nextInt();
				
				switch(op) {
					case 1 : 
						boolean salir1 = false;
						do {
							System.out.println("1) Cargar BD de peliculas");
							System.out.println("2) Rentar pelicula");
							System.out.println("3) Devolver pelicula");
							System.out.println("4) Mostrar cantidad de peliculas disponibles");
							System.out.println("5) Salir");
							
							try {
								System.out.println("Elije una opción: ");
								int op1 = ent.nextInt();
								 ImplementacionPilaEstatica ipe = new  ImplementacionPilaEstatica();
								
								switch(op1) {
									case 1 :
										
										break;
										
									case 2 :
										ipe.eliminar();
										break;
										
									case 3 :
										ipe.insertar();
										break;
										
									case 4 :
										ipe.mostrarCantidadElementos();
										break;
										
									case 5 :
										salir = true;
										break;
										
									default :
										System.out.println("Debes ingresar números entre 1 y 5");

								}
								
							} catch (InputMismatchException e) {
								System.out.println("Debes ingresar un número");
				                ent.next();
							}
							
						}while(!salir1);
						
						break;
					
					case 2 :
						boolean salir2 = false;
						do {
							System.out.println("1) Cargar BD de peliculas");
							System.out.println("2) Rentar pelicula");
							System.out.println("3) Devolver pelicula");
							System.out.println("4) Mostrar cantidad de peliculas disponibles");
							System.out.println("5) Salir");
							
							try {
								System.out.println("Elije una opción: ");
								int op2 = ent.nextInt();
								ImplementacionPilaDinamica ipd = new  ImplementacionPilaDinamica();
								
								switch(op2) {
									case 1 :
										break;
										
									case 2 :
										ipd.eliminar();
										break;
										
									case 3 :
										ipd.insertar();
										break;
										
									case 4 :
										ipd.mostrarCantidadElementos();
										break;
										
									case 5 :
										salir = true;
										break;
										
									default :
										System.out.println("Debes ingresar números entre 1 y 5");

								}
								
							} catch (InputMismatchException e) {
								System.out.println("Debes ingresar un número");
				                ent.next();
							}
							
						}while(!salir2);
						
						break;
						
					case 3 :
						salir = true;
						break;
						
					default :
						System.out.println("Debes ingresar números entre 1 y 3");
				}
	
			} catch (InputMismatchException e) {
				System.out.println("Debes ingresar un número");
                ent.next();
			}
			
		}while(!salir);
		
	
		
		
		
		

	}

}
