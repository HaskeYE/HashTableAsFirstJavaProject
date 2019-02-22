import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class CustomHashTable {

        // Check HashSet
    ArrayList<LinkedList<Integer>> numerals;// Проверить типы данных LinkedList -? область видимости
    private int hashDiv; //хеш-функция деления

    public CustomHashTable(@NotNull ArrayList<Integer> list, @NotNull int hashDiv) {
        numerals = new ArrayList<>(hashDiv);
        this.hashDiv = hashDiv;
        for (int i = 0; i < hashDiv; i++) {
            numerals.add(i, new LinkedList<Integer>());
        }
        for (Integer i: list) {
            add(i);
        }
    }

    private int hash(int numeral) {
        return numeral % hashDiv;
    }

    private int indexForHash(int hash) {
    //Ддя возможно необходимых дальнейших операций
        return hash;
    }

    public void add(int num) {
        if (!numerals.contains(num)) {
            int index = indexForHash(hash(num));
            if (numerals.get(index) != null) {
                numerals.get(index).add(num);
            } else {
                LinkedList listNew = new LinkedList<>();
                listNew.add(num);
                numerals.add(index, listNew);
            }
        }
    }

    public boolean delete(int num) {
        LinkedList<Integer> list = numerals.get(indexForHash(hash(num)));
            if (list.contains(num)) {
                if (list.size() > 1) {
                    list.remove(num);
                    numerals.remove(indexForHash(hash(num)));
                    numerals.add(indexForHash(hash(num)), list);
                    return true;
                } else {
                    numerals.remove(indexForHash(hash(num)));
                    numerals.add(indexForHash(hash(num)), new LinkedList<Integer>());
                }
            }
        return false;
    }

    public boolean contains(int num) {
        return (numerals.get(indexForHash(hash(num))).contains(num));  //HOW TO OPTIMIZE SPEED?
    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof CustomHashTable) &&
                ((CustomHashTable) obj).numerals.equals(numerals) &&
                ((CustomHashTable) obj).hashDiv == hashDiv);
    }

    //REHASH
}
