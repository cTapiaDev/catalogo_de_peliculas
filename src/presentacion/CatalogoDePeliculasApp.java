package presentacion;

import dominio.Pelicula;
import java.util.Scanner;
import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivos;
import servicio.ServicioPeliculasLista;

public class CatalogoDePeliculasApp {
    
    public static void main(String[] args) {
        
        boolean salir = false;
        Scanner input = new Scanner(System.in);
        
        // Implementacion del Servicio
//        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivos();
        
        while (!salir) {
            
            try {
                mostrarMenu();
                salir = ejecutarOpciones(input, servicioPeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
            
        }
    }
    
    // Crear funcion para mostrar Menu
    private static void mostrarMenu() {
        System.out.println("""
                           *** Catalogo de Peliculas ***
                           1. Agregar pelicula
                           2. Listar peliculas
                           3. Buscar pelicula
                           4. Salir
                           Elige una opcion
                           """);
        
    }
    
    private static boolean ejecutarOpciones(Scanner input, IServicioPeliculas servicioPeliculas) {
        
        int opcion = Integer.parseInt(input.nextLine());
        boolean salir = false;
        
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula");
                String nombrePelicula = input.nextLine();
                servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 -> {
                System.out.println("Introduce la pelicula que quieres buscar");
                String buscar = input.nextLine();
                servicioPeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("Hasta pronto!!");
                salir = true;
            }
            default -> {
                System.out.println("Opcion no reconocida " + opcion);
            }
        }
        
        return salir;
    }
    
}
