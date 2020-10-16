
interface RentaPeliculas{
	int datos[] = new int[6];
	int cima = -1;
		
	
	

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

public class Peliculas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
