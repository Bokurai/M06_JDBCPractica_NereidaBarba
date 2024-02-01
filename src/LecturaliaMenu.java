import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Clase que representa el menú de la Biblioteca Digital de Lecturalia.
 */
public class LecturaliaMenu {

    private int op;

    /**
     * Constructor de la clase LecturaliaMenu.
     */
    public LecturaliaMenu(){
        super();
    }

    /**
     * Muestra el menú principal y devuelve la opción seleccionada por el usuario.
     *
     * @return La opción seleccionada por el usuario.
     */
    public int menuPrincipal(){
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("✎✧˚ ༘ ⋆｡˚Bienvenido a la Biblioteca Digital de Lecturalia ✎✧˚ ༘ ⋆｡˚");
            System.out.println("Escoja una de las siguientes opciones: ");
            System.out.println("˚ ༘ ⋆｡CONSULTA˚ ༘ ⋆｡");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar libros de un autor en concreto");
            System.out.println("3. Mostrar libros pertenecientes a un tema");
            System.out.println("4. Mostrar todos los temas disponibles");
            System.out.println("˚ ༘ ⋆｡MODIFICACIÓN/ELIMINACIÓN˚ ༘ ⋆｡");
            System.out.println("5. Escoger un libro y modificar su información");
            System.out.println("6. Eliminar información de un libro");
            System.out.println("˚ ༘ ⋆｡RESTABLECIMIENTO˚ ༘ ⋆｡");
            System.out.println("7. Borrar tablas de la Biblioteca Digital");
            System.out.println("8. Crear tablas de la Biblioteca Digital");
            System.out.println("9. Poblar las tablas con datos");
            System.out.println("10. Salir");
            try {
                op = Integer.parseInt(lector.readLine());
            } catch (IOException e) {
                System.out.println("El input no es un número/Escoja el número correpondiente a la operación");
                e.printStackTrace();
            }

        }
        while (op > 0 && op < 13);
        return op;
    }

}
