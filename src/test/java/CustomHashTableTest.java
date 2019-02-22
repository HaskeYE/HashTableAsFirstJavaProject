import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class CustomHashTableTest {
/*0->
    1->
    2->
    3->
    4->*/
    @Test
    public void hashTable() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        ArrayList listNew = new ArrayList();
        for (int i = 0; i < 4 ; i++) {
            listNew.add(i);
        }
        CustomHashTable tableNew = new CustomHashTable(listNew, 5);
        tableNew.add(4);
assertEquals(table, tableNew);
    }
}
