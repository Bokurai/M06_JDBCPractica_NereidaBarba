import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class LecturaliaMenu {

    private int op;

    public LecturaliaMenu(){
        super();
    }

    public int menuPrincipal(){
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("✎✧˚ ༘ ⋆｡˚Bienvenido a la Biblioteca Digital de Lecturalia ✎✧˚ ༘ ⋆｡˚");
            System.out.println("Escoja una de las siguientes opciones: ");
            System.out.println("˚ ༘ ⋆｡CONSULTA˚ ༘ ⋆｡");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar libros de un autor en concreto");
            System.out.println("3. Mostrar libros pertenecientes a un tema");
            System.out.println("4. Mostrar libros con varios autores");
            System.out.println("˚ ༘ ⋆｡MODIFICACIÓN/ELIMINACIÓN˚ ༘ ⋆｡");
            System.out.println("5. Escoger un libro y modificar su información");
            System.out.println("6. Escoger varios libros y modificar su información");
            System.out.println("7. Eliminar información de un libro");
            System.out.println("8. Eliminar información de varios libros");
            System.out.println("˚ ༘ ⋆｡RESTABLECIMIENTO˚ ༘ ⋆｡");
            System.out.println("9. Reiniciar tablas de la base de datos");
            System.out.println("10. Rellenar las tablas con datos");
            System.out.println("7. ");
            System.out.println("11. Salir");
            try {
                op = Integer.parseInt(lector.readLine());
            } catch (IOException e) {
                System.out.println("El input no es un número/Escoja el número correpondiente a la operación");
                e.printStackTrace();
            }

        }
        while (op > 0 && op < 12);
        return op;
    }

}