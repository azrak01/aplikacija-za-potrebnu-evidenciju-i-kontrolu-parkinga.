package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpratTest {
    @Test
    public static void main(String[] args) {

        Sprat sprat = new Sprat(1, createMjesta(), 10.0);
        System.out.println("Broj sprata: " + sprat.getBrojSprata());
        System.out.println("Cijena parkinga: " + sprat.getCijena());
        System.out.println("Broj mjesta na spratu: " + sprat.getMjesta().size());
        System.out.println();


        System.out.println("Slobodna mjesta na spratu " + sprat.getBrojSprata() + ":");
        List<Mjesto> slobodnaMjesta = sprat.getSlobodnaMjesta();
        for (Mjesto mjesto : slobodnaMjesta) {
            System.out.println("Mjesto " + mjesto.getBrojMjesta());
        }
        System.out.println();


        Mjesto mjesto = sprat.getMjesta().get(0);
        System.out.println("Status mjesta " + mjesto.getBrojMjesta() + ": " + mjesto.getStatus());
        mjesto.setStatus(Status.ZAUZETO);
        System.out.println("Novi status mjesta " + mjesto.getBrojMjesta() + ": " + mjesto.getStatus());
    }

    private static List<Mjesto> createMjesta() {
        List<Mjesto> mjesta = new ArrayList<>();
        mjesta.add(new Mjesto(1, Status.SLOBODNO));
        mjesta.add(new Mjesto(2, Status.SLOBODNO));
        mjesta.add(new Mjesto(3, Status.SLOBODNO));
        return mjesta;
    }
}