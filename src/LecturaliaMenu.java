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
            System.out.println("✎✧˚ ༘ ⋆｡˚Bienvenido a la BBDD de Lecturalia ✎✧˚ ༘ ⋆｡˚");
            System.out.println("Escoja una de las siguientes opciones: ");
            System.out.println("˚ ༘ ⋆｡CONSULTA˚ ༘ ⋆｡");
            System.out.println("1. Mostrar todos los libros");
            System.out.println("2. Mostrar libros de un autor en concreto");
            System.out.println("3. Mostrar libros pertenecientes a un tema");
            System.out.println("4. Mostrar libros con varios autores");
            System.out.println("˚ ༘ ⋆｡MODIFICACIÓN/ELIMINACIÓN˚ ༘ ⋆｡");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("˚ ༘ ⋆｡RESTABLECIMIENTO˚ ༘ ⋆｡");
            System.out.println("5. Reiniciar tablas de la base de datos");
            System.out.println("6. Rellenar las tablas con datos");
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
