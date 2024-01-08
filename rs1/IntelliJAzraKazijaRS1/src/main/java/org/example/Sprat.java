package org.example;

import java.util.Vector;

public class Sprat {
    private int brojSprata;
    private Vector<Mjesto> mjesta;
    private double cijena;

    public Sprat(int brojSprata, double cijena) {
        this.brojSprata = brojSprata;
        this.mjesta = mjesta;
        this.cijena = cijena;
    }

    public int getBrojSprata() {
        return brojSprata;
    }

    public void setBrojSprata(int brojSprata) {
        this.brojSprata = brojSprata;
    }

    public Vector<Mjesto> getMjesta() {
        return mjesta;
    }

    public void setMjesta(Vector<Mjesto> mjesta) {
        this.mjesta = mjesta;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }
}
