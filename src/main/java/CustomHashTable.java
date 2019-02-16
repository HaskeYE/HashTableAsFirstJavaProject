import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashTable {

    ArrayList<LinkedList<Integer>> numerals;
    private int hashDiv; //хеш-функция деления

    public CustomHashTable(@NotNull ArrayList<Integer> list, @NotNull int hashDiv) {
        numerals = new ArrayList<>(hashDiv - 1);
        this.hashDiv = hashDiv;
        for (Integer i : list) {
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
        int index = indexForHash(hash(num));
        if (numerals.get(index) != null) {
            numerals.get(index).add(num);
        } else {
            LinkedList listNew = new LinkedList<>();
            listNew.add(num);
            numerals.add(index, listNew);
        }

    }

    public boolean delete(int num) {
        LinkedList<Integer> list = numerals.get(indexForHash(hash(num)));
        for (int numeral : list)
            if (numeral == num) {
                list.remove(numeral);
                return true;
            }
        return false;
    }

    public boolean contains(int num) {
        return (numerals.get(indexForHash(hash(num))).contains(num));
    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof CustomHashTable) &&
                ((CustomHashTable) obj).numerals.equals(numerals) &&
                ((CustomHashTable) obj).hashDiv == hashDiv);
    }
}
