package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    public static final int FIRST_INDEX = 0;

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> al = new ArrayList<Integer>();
        for (int i = 1000; i < 2000; i++) {
            al.addLast(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> ll = new LinkedList<Integer>(al);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        int tmp = al.getLast();
        al.set(al.size() - 1, al.getFirst());
        al.set(FIRST_INDEX, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int i : al) {
            IO.println(i);
        }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long timeAL = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            al.addFirst(i);
        }
        timeAL = System.nanoTime() - timeAL;
        IO.println(timeAL);

        long timeLL = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            ll.addFirst(i);
        }
        timeLL = System.nanoTime() - timeLL;
        IO.println(timeLL);

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int middleIndex = al.size() / 2;

        timeAL = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            tmp = al.get(middleIndex);
        }
        timeAL = System.nanoTime() - timeAL;
        IO.println(timeAL);

        timeLL = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            tmp = ll.get(middleIndex);
        }
        timeLL = System.nanoTime() - timeLL;
        IO.println(timeLL);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> worldMap = new HashMap<>();
        worldMap.put("Africa", 1_110_635_000L);
        worldMap.put("Americas", 972_005_000L);
        worldMap.put("Antarctica", 0L);
        worldMap.put("Asia", 4_298_723_000L);
        worldMap.put("Europe", 742_452_000L);
        worldMap.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPop = 0;
        for (long i : worldMap.values()) {
            worldPop += i;
        }
        IO.println(worldPop);
    }
}
