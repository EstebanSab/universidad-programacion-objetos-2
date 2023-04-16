package robot;

public class Robot {
    private int x;
    private int y;
    private int direccion;
    private Tablero tablero;
    private String instrucciones;

    public Robot(int x, int y, char n, Tablero tablero) {
        this.tablero = tablero;
        direccionar(n);
        this.x = x;
        this.y = y;
    }


    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getDireccion() {
        return this.direccion;

    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void setInstrucciones(String movimientos) {
        this.instrucciones = movimientos;
    }

    public String getInstrucciones() {
        return this.instrucciones;
    }


    public void direccionar(int giros) {
        //0 norte,1 este, 2 sur ,3 oeste
        int aux = giros + this.getDireccion();
        aux = aux % 4;

        this.setDireccion(aux);
    }

    public void direccionar(char d) {
        //0 norte,1 este, 2 sur ,3 oeste
        if (d == 'N') {
            this.setDireccion(0);
        }
        if (d == 'E') {
            this.setDireccion(1);
        }
        if (d == 'S') {
            this.setDireccion(2);
        }
        if (d == 'O') {
            this.setDireccion(3);
        }
    }

    public void avanzar(int num) {
        int aux;
        if (this.getDireccion() == 0) {
            aux = this.tablero.pasaBordeNorte(this.getY(), num);
            setY(aux);
        }

        if (this.getDireccion() == 1) {
            aux = this.tablero.pasaBordeEste(this.getX(), num);
            setX(aux);
        }

        if (this.getDireccion() == 2) {
            aux = this.tablero.pasaBordeSur(this.getY(), (-num));
            setY(aux);
        }

        if (this.getDireccion() == 3) {
            aux = this.tablero.pasaBordeOeste(this.getX(), (-num));
            setX(aux);
        }
    }


    public void moverse() {
        String movimientos = this.getInstrucciones();
        char funcion;
        int auxA, auxR, tamaño;
        tamaño = movimientos.length();

        if (tamaño > 250) {
            tamaño = 250;
        }

        for (int i = 0; i < tamaño - 1; i += 2) {
            funcion = movimientos.charAt(i);
            if (funcion == 'A') {
                auxA = Integer.parseInt(Character.toString(movimientos.charAt(i + 1)));
                this.avanzar(auxA);
            }
            if (funcion == 'R') {
                auxR = Integer.parseInt(Character.toString(movimientos.charAt(i + 1)));
                this.direccionar(auxR);

            }
        }


    }


}
    
    
    
    
    
    
 