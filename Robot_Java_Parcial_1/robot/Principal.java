package robot;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Archivo a = new Archivo();

        // Inicializacion del Robot (metodo leerArchivo() devuelve un objeto de tipo robot)

        Robot miRobot = a.leerArchivo("Direccion del ROBOT.IN");

        //moverse() carga las instrucciones para el robot y lo mueve.

        miRobot.moverse();

        a.crearArchivo("DIRECCION DONDE SE CREA ROBOT.OUT",miRobot);


    }
}
