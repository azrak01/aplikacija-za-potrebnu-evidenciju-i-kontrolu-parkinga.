package org.example;

enum Status {
    SLOBODNO,
    ZAUZETO
}

public class Mjesto {
    private int broj;
    private Status status;

    public Mjesto(int brojMjesta, Status status) {
        this.brojMjesta = brojMjesta;
        this.status = status;
    }

    public int getBrojMjesta() {
        return brojMjesta;
    }

    public void setBrojMjesta(int brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
