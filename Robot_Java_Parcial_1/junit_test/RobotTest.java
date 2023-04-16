package junit_test;

import org.junit.Before;
import org.junit.Test;
import robot.*;

import static org.junit.Assert.*;

public class RobotTest {

    Tablero miTablero = new Tablero(5,10);
    Robot miRobot;

    @Before
    public void setUp() throws Exception {

        miRobot = new Robot(1,1,'n',miTablero);
    }

    @Test
    public void creandoRobot() {
        assertNotNull(miRobot);
    }

    @Test
    public void testDireccionar(){
        int esperado = 2;
        miRobot.direccionar(2);
        int obtenido = miRobot.getDireccion();

        assertEquals(esperado,obtenido);

    }

    @Test
    public void testDireccionar2(){
        int esperado = 3;
        miRobot.direccionar('O');
        int obtenido = miRobot.getDireccion();

        assertEquals(esperado,obtenido);

    }

    @Test
    public void testAvanzar(){
        //Como esta inicializado en sentido al norte, avanzará hacia el norte
        int esperado = 8;
        miRobot.avanzar(7);
        int obtenido = miRobot.getY();

        assertEquals(esperado,obtenido);

    }


}