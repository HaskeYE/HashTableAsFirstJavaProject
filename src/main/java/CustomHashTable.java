import com.sun.istack.internal.NotNull;

import java.util.*;

public class CustomHashTable {

        // Check HashSet
    private HashMap<Integer, Set<Integer>> numerals;
    private int hashDiv; //хеш-функция деления

    CustomHashTable(@NotNull ArrayList<Integer> list, @NotNull int hashDiv) {
        numerals = new HashMap<>(hashDiv);
        this.hashDiv = hashDiv;
        for (int i = 0; i < hashDiv; i++) {
            numerals.put(i, new HashSet<>());
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

    void add(int num) {
        if (!numerals.containsValue(num)) {
            int index = indexForHash(hash(num));
            if (numerals.get(index) != null) {
                numerals.get(index).add(num);
            } else {
                Set listNew = new HashSet();
                listNew.add(num);
                numerals.put(index, listNew);
            }
        }
    }

    boolean delete(int num) {
        Set<Integer> list = numerals.get(indexForHash(hash(num)));
            if (list.contains(num)) {
                if (list.size() > 1) {
                    list.remove(num);
                    numerals.replace(indexForHash(hash(num)), list);
                    return true;
                } else {
                    numerals.replace(indexForHash(hash(num)), new HashSet<>());
                }
            }
        return false;
    }

    boolean contains(int num) {
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
