package org.example;

import java.util.List;

public class Garaza {
    private String naziv;
    private String lokacija;
    private List<Sprat> spratovi;

    public Garaza(String naziv, String lokacija, List<Sprat> spratovi) {
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.spratovi = spratovi;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public List<Sprat> getSpratovi() {
        return spratovi;
    }

    public void setSpratovi(List<Sprat> spratovi) {
        this.spratovi = spratovi;
    }

    public int getBrojSpratova() {
        return spratovi.size();
    }
}
