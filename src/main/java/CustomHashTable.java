

import com.sun.istack.internal.NotNull;

import java.util.*;

import static java.lang.Math.abs;
// пакеты
public class CustomHashTable {


    /*private static float DEFAULT_LOAD_FACTOR = 0.75f;*/
    private Map<Integer, Set<Integer>> numerals;
    private int hashDiv; //хеш-функция деления
    private int loadFactor;
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
        return abs(numeral) % hashDiv;
    }


    //Adding new numeral to HashTable
    // область видимости
    public boolean add(int num) {
        //Trying to realize if this numeral already in HashTable
        if (!contains(num)) {
            int index = hash(num);
            numerals.get(index).add(num);
            loadFactor++;
            if ((capacity * 0.75) <= loadFactor) {
                rehash();
            }
            return true;
        } else return false;
    }

    //Deleting numeral from HashTable
     public boolean delete(int num) {
        Set<Integer> list = numerals.get(hash(num));
        if (list.contains(num)) {
            if (list.size() > 1) {
                list.remove(num);
                return true;               // duplication
            } else {
                //Replacing set with one numeral by empty one
                numerals.replace(hash(num), new HashSet<>()); //use-case
                return true;
            }
        }
        return false;
    }


    public boolean contains(int num) {
        return (numerals.get(hash(num)).contains(num));
    }

    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof CustomHashTable) &&
                ((CustomHashTable) obj).numerals.equals(numerals) &&
                ((CustomHashTable) obj).hashDiv == hashDiv);
    }

    // map
    void rehash() {
        Map<Integer, Set<Integer>> table = new HashMap<>(hashDiv * 2);
        capacity = capacity * 2;
        for (int i = 0; i < hashDiv; i++) {
            table.put(i, new HashSet<>());
        }
        for (int i = 0; i < hashDiv; i++) {
            for (Integer j : numerals.get(i)) {
                table.get(hash(j)).add(j);
            }
        }
        hashDiv = hashDiv * 2;
        numerals = table;
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
