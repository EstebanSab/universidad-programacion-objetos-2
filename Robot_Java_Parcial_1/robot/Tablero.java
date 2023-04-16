package robot;

public class Tablero {
    private int nColumnas;
    private int mFilas;

    public Tablero(int n, int m) {

        if (n <= 100 && n > 0 && m <= 100 && m > 0) {
            this.nColumnas = n;
            this.mFilas = m;
        } else {
            throw new RuntimeException("Los valores del tablero estan incorrectos");
        }


    }

    public int getColumnas() {
        return this.nColumnas;
    }

    public int getFilas() {
        return this.mFilas;
    }

    public int pasaBordeNorte(int pos, int movimiento) {
        int aux = pos + movimiento;
        if (aux > this.getFilas()) {
            aux = this.getFilas();
        }
        return aux;
    }

    public int pasaBordeEste(int pos, int movimiento) {
        int aux = pos + movimiento;
        if (aux > this.getColumnas()) {
            aux = this.getColumnas();
        }
        return aux;
    }

    public int pasaBordeSur(int pos, int movimiento) {
        int aux = pos + movimiento;
        if (aux < 1) {
            aux = 1;
        }
        return aux;
    }

    public int pasaBordeOeste(int pos, int movimiento) {
        int aux = pos + movimiento;
        if (aux < 1) {
            aux = 1;
        }
        return aux;
    }


}



