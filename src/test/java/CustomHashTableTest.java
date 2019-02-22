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

    @Test
    public void hashTable1() {
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
        table.delete(4);
        assertEquals(table, tableNew);
    }


    @Test
    public void hashTable2() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        ArrayList listNew = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            listNew.add(i);
        }
        CustomHashTable tableNew = new CustomHashTable(listNew, 5);
        assertEquals(table, tableNew);
    }


    @Test
    public void hashTable3() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        Boolean bool = table.contains(4);
        assertEquals(bool, true);
    }


    @Test
    public void hashTable4() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        Boolean bool = table.contains(7);
        assertEquals(bool, false);
    }


    @Test
    public void hashTable5() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        ArrayList listNew = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            listNew.add(i);
        }
        CustomHashTable tableNew = new CustomHashTable(listNew, 5);
        Boolean bool = table.equals(tableNew);
        assertEquals(bool, true);
    }


    @Test
    public void hashTable6() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        ArrayList listNew = new ArrayList();
        for (int i = 0; i < 8 ; i++) {
            listNew.add(i);
        }
        CustomHashTable tableNew = new CustomHashTable(listNew, 5);
        Boolean bool = table.equals(tableNew);
        assertEquals(bool, false);
    }
}
