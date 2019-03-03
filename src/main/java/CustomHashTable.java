

import com.sun.istack.internal.NotNull;

import java.util.*;

public class CustomHashTable {


    /*private static float DEFAULT_LOAD_FACTOR = 0.75f;*/
    private HashMap<Integer, Set<Integer>> numerals;
    private int hashDiv; //хеш-функция деления
    private float loadFactor;
    private int capacity;


    public CustomHashTable(@NotNull List<Integer> list, int hashDiv) {//NotNull check
        //Adding empty buckets
        loadFactor = 0;
        capacity = 16;
        numerals = new HashMap<>(hashDiv);
        this.hashDiv = hashDiv;
        for (int i = 0; i < hashDiv; i++) {
            numerals.put(i, new HashSet<>());
        }
        //Adding list of numerals which must be held by HashTable
        if (!list.equals(Collections.emptyList()))
            for (Integer i : list) {
            add(i);
        }
    }

    //Getting bucket number
    private int hash(int numeral) {
        return numeral % hashDiv;
    }

    private int indexForHash(int hash) {
        //Ддя возможно необходимых дальнейших операций
        return hash;
    }

    //Adding new numeral to HashTable
    boolean add(int num) {
        //Trying to realize if this numeral already in HashTable
        if (!numerals.get(indexForHash(hash(num))).contains(num)) {
            int index = indexForHash(hash(num));
            numerals.get(index).add(num);
            loadFactor++;
            if ((capacity * 0.75) <= loadFactor) {
                rehash();
            }
            return true;
        } else return false;
    }

    //Deleting numeral from HashTable
    boolean delete(int num) {
        Set<Integer> list = numerals.get(indexForHash(hash(num)));
        if (list.contains(num)) {
            if (list.size() > 1) {
                list.remove(num);
                return true;
            } else {
                //Replacing set with one numeral by empty one
                numerals.replace(indexForHash(hash(num)), new HashSet<>());
                return true;
            }
        }
        return false;
    }

    boolean contains(int num) {
        return (numerals.get(indexForHash(hash(num))).contains(num));
    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof CustomHashTable) &&
                ((CustomHashTable) obj).numerals.equals(numerals) &&
                ((CustomHashTable) obj).hashDiv == hashDiv);
    }


    void rehash() {
        CustomHashTable table = new CustomHashTable(Collections.emptyList(),
                (hashDiv * 2));
        table.capacity = capacity * 2;
        capacity = capacity * 2;
        for (int i = 0; i < hashDiv; i++) {
            for (Integer j : numerals.get(i)) {
                table.add(j);
            }
        }
        hashDiv = hashDiv * 2;
        numerals = table.numerals;
    }
    //REHASH
    /*double loadFactor = (1.0 * size) / numBuckets;
     if (loadFactor > DEFAULT_LOAD_FACTOR) {
    rehash();}
     private void rehash()
    {//Увеличение всех типов данных по вместимости
    Rehash keys and increase size of table
    ...Maybe need only to increase max length of Sets....
    }*/
}
