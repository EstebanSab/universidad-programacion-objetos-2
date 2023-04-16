package junit_test;

import org.junit.Before;
import org.junit.Test;
import robot.Robot;
import robot.Tablero;

import static org.junit.Assert.*;

public class TableroTest {

    Tablero miTablero;
    Robot miRobot;

    @Before
    public void setUp() throws Exception {

        miTablero = new Tablero(5,10);
        miRobot = new Robot(4,5, 'N',miTablero);
    }

    @Test
    public void creandoTablero() {
        assertNotNull(miTablero);
    }

    @Test (expected = RuntimeException.class)
    public void exceptionTableroTest() {
        miTablero = new Tablero(-1,-20);
    }

    @Test
    public void pasaBordeNorteTest() {
        int esperado = 5;
        int obtenido = miTablero.pasaBordeNorte(miRobot.getY(),100);
    }

    @Test
    public void pasaBordeEsteTest() {
        int esperado = 10;
        int obtenido = miTablero.pasaBordeEste(miRobot.getX(),3);
    }

    @Test
    public void pasaBordeOesteTest() {
        int esperado = 7;
        int obtenido = miTablero.pasaBordeOeste(miRobot.getX(),3);
    }

    @Test
    public void pasaBordeSurTest() {
        int esperado = 3;
        int obtenido = miTablero.pasaBordeSur(miRobot.getX(),2);
    }
}