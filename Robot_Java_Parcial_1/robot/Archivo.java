package robot;
import java.io.*;
import java.util.*;


public class Archivo {
	public Robot leerArchivo(String archivoEntrada) throws FileNotFoundException {
		File archivoEn = new File(archivoEntrada);
		Scanner sc = new Scanner(archivoEn);

		String datos = sc.nextLine();
		String[] aux = datos.split(" ");
		int x = Integer.parseInt(aux[0]);
		int y = Integer.parseInt(aux[1]);
		char a = aux[2].charAt(0);
		int n = Integer.parseInt(aux[3]);
		int m = Integer.parseInt(aux[4]);
		Robot robot = new Robot(x, y, a, new Tablero(n, m));

		datos = "";

		while (sc.hasNext()) {
			datos += sc.nextLine();

			if (datos.length() > 250) {
				throw new RuntimeException("Las instrucciones sobrepasan el limite");
			}
		}

		robot.setInstrucciones(datos);
		sc.close();
		return robot;
	}

	public void crearArchivo(String archivoSalida, Robot robot) throws IOException {
		FileWriter archivoSal = new FileWriter(archivoSalida);
		PrintWriter salida = new PrintWriter(archivoSal);

		salida.println(robot.getX() + " " + robot.getY());

		salida.close();
	}
}