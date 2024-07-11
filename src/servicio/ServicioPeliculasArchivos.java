package servicio;

import dominio.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivos implements IServicioPeliculas {
    
    private final String NOMBRE_ARCHIVO = "peliculas.txt";
    
    public ServicioPeliculasArchivos() {
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            // Si ya existe el archivo
            if (archivo.exists()) {
                System.out.println("El archivo ya existe");
            } else {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("El archivo se ha creado correctamente");
            }
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error al abrir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            
            System.out.println("---- Lista de Peliculas ----");
            
            // Estamos leyendo el archivo .txt, lo abrimos en modo lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            String linea;
            // Tenemos que leer nuestro .txt linea por linea
            linea = entrada.readLine();
            
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                
                // Con esto nos aseguramos de leer la siguiente linea
                // evitamos generar un ciclo infinito
                linea = entrada.readLine();
            }
            
            entrada.close();
            
            
        } catch (Exception e) {
            System.out.println("Se genero un error al listar las peliculas: " + e.getMessage());
        }
        
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            // Verificamos si el archivo existe o no, retorna true o false
            anexar = archivo.exists();
            
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego la pelicula: " + pelicula);
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error al agregar la pelicula: " + e.getMessage());
        }
        
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        File archivo = new File(NOMBRE_ARCHIVO);
        
        try {
            
            // Abrir el archivo texto en modo lectura
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            String linea = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;
            String peliculaBuscar = pelicula.getNombre();
            
            while (linea != null) {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(linea)) {
                    encontrada = true;
                    break;
                }
                
                linea = entrada.readLine();
                indice++;
            }
            
            // Ahora tenemos que mostrar por consola
            if (encontrada) {
                System.out.println("Pelicula " + linea 
                        + " encontrada - linea " + indice);
            } else {
                System.out.println("No se encontro la pelicula que buscas: " 
                        + pelicula.getNombre());
            }
            
            
            
            
        } catch (Exception e) {
            System.out.println("Se genero un error al buscar una pelicula: " 
                    + e.getMessage());
        }
    }
    
}
