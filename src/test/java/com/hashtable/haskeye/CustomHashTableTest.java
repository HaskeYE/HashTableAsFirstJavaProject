package com.hashtable.haskeye;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

// package
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
        List listNew = new ArrayList();
        for (int i = 0; i < 4 ; i++) {
            listNew.add(i);
        }
        CustomHashTable tableNew = new CustomHashTable(listNew, 5);
        tableNew.add(4);
Assertions.assertEquals(table, tableNew);
    }

    @Test
    public void hashTableAdd1() {
        List list = new ArrayList();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        table.delete(8);
        assertEquals(false, table.delete(8));
    }


    @Test
    public void hashTableDelete() {
        List list = new ArrayList();
        for (int i = 0; i < 25 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        List listNew = new ArrayList();
        for (int i = 0; i < 24 ; i++) {
            listNew.add(i);
        }
        CustomHashTable tableNew = new CustomHashTable(listNew, 5);
        table.delete(24);
        assertEquals(table, tableNew);
    }

    @Test
    public void hashTableEqualsAdd() {
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
    public void hashTableContains() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        Boolean bool = table.contains(4);
        assertEquals(bool, true);
    }


    @Test
    public void hashTableContains1() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 5 ; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
        Boolean bool = table.contains(7);
        assertEquals(bool, false);
    }


    @Test
    public void hashTableEquals() {
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
    public void hashTableEquals1() {
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

    @Test
    public void HashTableRehash() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        CustomHashTable table = new CustomHashTable(list, 5);
    }
}
