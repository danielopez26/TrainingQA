import org.junit.jupiter.api.*;

public class TestChrome {

    GoogleSearch googleSearch = new GoogleSearch();

    @Test
    public void testSearch(){
        googleSearch.search();
    }
}
