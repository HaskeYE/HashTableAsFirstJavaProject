package com.hashtable.haskeye;

import com.sun.istack.internal.NotNull;

import java.util.*;

import static java.lang.Math.abs;


/**
 * HashTable is based on hash-function of dividing. It provides faster access to data.
 * It contains <tt>Integer</tt> type numerals.
 * Its performance is provided by number of buckets dependent on number of numerals included.
 */
public class CustomHashTable {


    /*private static float DEFAULT_LOAD_FACTOR = 0.75f;*/
    private Map<Integer, Set<Integer>> numerals;
    private int hashDiv; //хеш-функция деления
    private int loadFactor;
    private int capacity;

    /**
     * Now we are going to construct the table itself. So here is <tt>Constructor</tt>.
     * It gets two parameters:
     * @param list - list of numerals that can be included in table
     * @param hashDiv - number, that will be divider of hash-function
     *                We will construct (hashDiv) empty buckets:
     *                0 ->
     *                1 ->
     *                2 ->
     *                3 ->
     *                ...
     *           And then add numerals in it.
     * Capacity will be set as default value = 16
     */
    public CustomHashTable(@NotNull List<Integer> list, int hashDiv) {
        //Adding empty buckets
        loadFactor = 0;
        capacity = 16;
        numerals = new HashMap<>(hashDiv);
        this.hashDiv = hashDiv;
        for (int i = 0; i < hashDiv; i++) {
            numerals.put(i, new HashSet<>());
        }
        //Adding list of numerals which must be held by HashTable
            for (Integer i : list) {
            add(i);
        }
    }

    /**
     * Adding operation adds numeral in bucket that matches the remainder of
     * dividing the numeral by numeral from hash-function.
     * If there will be too much numerals our table will be rehashed
     */
    //Adding new numeral to HashTable
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


    //Getting bucket number
    private int hash(int numeral) {
        return abs(numeral) % hashDiv;
    }

    /**
     * Also we will need deleting operation that should delete the number from table.
     * This function will firstly search correct bucket by hashing incoming numeral and then
     * will delete it from that bucket. But that all will be done only if there will be such numeral
     * in our table.
     */
    //Deleting numeral from HashTable
     public boolean delete(int num) {
        Set<Integer> list = numerals.get(hash(num));
        if (list.contains(num)) {
            list.remove(num);
            return true;
            // collection magic
        }
        return false;
    }


    public boolean contains(int num) {
        return (numerals.get(hash(num)).contains(num));
    }

    /**
     * Besides our table can be tested for equality to other one by comparing their hash-functions
     * and their content.
     */
    @Override
    public boolean equals(Object obj) {
        return ((obj instanceof CustomHashTable) &&
                ((CustomHashTable) obj).numerals.equals(numerals) &&
                ((CustomHashTable) obj).hashDiv == hashDiv);
    }

    /**
     * And about rehashing - this operation increases capacity by two times by increasing
     * <tt>hashDiv</tt> by two times and reconstructing table with it.
     */
    private void rehash() {
        Map<Integer, Set<Integer>> table = new HashMap<>(hashDiv * 2);
        capacity = capacity * 2;
        for (int i = 0; i < hashDiv * 2; i++) {
            table.put(i, new HashSet<>());
        }
        for (int i = 0; i < hashDiv; i++) {
            for (Integer j : numerals.get(i)) {
                table.get(abs(j) % (hashDiv * 2)).add(j);
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
