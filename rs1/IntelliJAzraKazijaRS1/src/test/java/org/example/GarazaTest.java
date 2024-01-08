
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;

        import java.util.ArrayList;
        import java.util.List;

public class GarazaTest {

    @Test

    public void testGetBrojSpratova() {
        List<Sprat> spratovi = new ArrayList<>();
        spratovi.add(new Sprat(1, new ArrayList<>(), 10.0));
        spratovi.add(new Sprat(2, new ArrayList<>(), 12.0));
        spratovi.add(new Sprat(3, new ArrayList<>(), 15.0));

        Garaza garaza = new Garaza("Moja garaža", "Neznam neki grad", spratovi);


        int brojSpratova = garaza.getBrojSpratova();


        Assertions.assertEquals(3, brojSpratova, "Broj spratova treba da bude 3");
    }
}
