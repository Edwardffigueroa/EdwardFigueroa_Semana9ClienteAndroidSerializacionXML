package contenido;

import java.io.Serializable;

/**
 * Created by edward on 30/09/16.
 */
public class Bolita implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    int x;
    int y;
    int diam;
    int r;
    int g;
    int b;



    public Bolita(int x, int y, int diam, int r, int g , int  b ){
        this.x=x;
        this.y=y;
        this.diam=diam;
        this.r=r;
        this.g=g;
        this.b=b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiam() {
        return diam;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
