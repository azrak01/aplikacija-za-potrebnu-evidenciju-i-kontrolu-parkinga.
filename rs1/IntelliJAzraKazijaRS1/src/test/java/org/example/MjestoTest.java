import org.junit.jupiter.api.Test;

public class MjestoTest {
    @Test
    public static void main(String[] args) {

        Mjesto mjesto = new Mjesto(1, Status.SLOBODNO);
        System.out.println("Broj mjesta: " + mjesto.getBrojMjesta());
        System.out.println("Status: " + mjesto.getStatus());

        mjesto.setStatus(Status.ZAUZETO);
        System.out.println("Novi status: " + mjesto.getStatus());
    }
}
