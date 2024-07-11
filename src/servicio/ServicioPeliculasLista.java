package servicio;

import dominio.Pelicula;
import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {
    
    private final List<Pelicula> peliculas;
    
    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("--- Listado de Peliculas ---");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // indexOf nos retorna un indice y en caso de no encontrar la pelicula, retorna -1
        int indice = peliculas.indexOf(pelicula);
        
        if (indice == -1) {
            System.out.println("No se encontro la pelicula: " + pelicula);
        } else {
            System.out.println("Pelicula encontrada en el indice: " + indice);
        }
    }
    
    
    // Este main solo fue creado para realizar pruebas, no es el main principal
    public static void main(String[] args) {
        
        // Agregar peliculas
        Pelicula pelicula1 = new Pelicula("Spiderman");
        Pelicula pelicula2 = new Pelicula("Avengers");
        
        // Crear instancia del servicio
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        
        // Agregar peliculas
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        
        // Mostrar lista de peliculas
        servicioPeliculas.listarPeliculas();
        
        // Buscar pelicula
        servicioPeliculas.buscarPelicula(pelicula2);
        servicioPeliculas.buscarPelicula(new Pelicula("Rapido y Furioso"));
    }
    
    
    
}
