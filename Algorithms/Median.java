/*
 * Solution to the problem found at:
 *   https://www.hackerrank.com/challenges/median
 *
 * Written By: Qi Li
 * Copyright (c) 2012-2013
 */
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.Scanner;

import java.util.PriorityQueue;

class MaxHeap {
    Long[] array;
    int size;
    MaxHeap(int num) {
        array = new Long[num];
        size = 0;
    }

    public void add(long x) {
        array[size] = x;
        heapUp();
        size++;
    }
    public void heapUp() {
        for (int i = size; i > 0;) {
            if (i % 2 == 1 && array[i] > array[i / 2]) {
                long temp = array[i];
                array[i] = array[i / 2];
                array[i / 2] = temp;
                i = i / 2;
            } else if (i % 2 == 0 && array[i] > array[i / 2 - 1]) {
                long temp = array[i];
                array[i] = array[i / 2 - 1];
                array[i / 2 - 1] = temp;
                i = i / 2 - 1;
            } else
                break;
        }

    }
    public void heapDown(int size) {
        int maxIndex;
        long maxVal;

        for (int i = 0; i < size;) {
            if (i * 2 + 1 >= size)
                break;

            if (i * 2 + 2 >= size) { //can only happen when there are only 2 elements
                if (array[i] < array[i * 2 + 1]) {
                    long temp = array[i];
                    array[i] = array[i * 2 + 1];
                    array[i * 2 + 1] = temp;
                    break;
                } else
                    break;
            }

            if (array[i * 2 + 1] > array[i * 2 + 2]) {
                maxIndex = i * 2 + 1;
                maxVal = array[i * 2 + 1];
            } else {
                maxVal = array[i * 2 + 2];
                maxIndex = i * 2 + 2;
            }
            if (array[i] < maxVal) {
                long temp = maxVal;
                array[maxIndex] = array[i];
                array[i] = temp;
                i = maxIndex;
            } else
                break;
        }

    }
    public long peek() {
        return array[0];
    }
    public long remove() {
        long val = array[0];
        if (size == 1) {
            array[0] = null;
        } else {
            array[0] = array[size - 1];
            array[size - 1] = null;
            heapDown(size - 1);
        }
        size--;
        return val;
    }
}

public class Median {
    public static int minSize = 0;
    public static int maxSize = 0;

    public static void main(String[] args) throws FileNotFoundException {

        PriorityQueue < Long > minHeap = new PriorityQueue < Long > (100000);
        MaxHeap maxHeap = new MaxHeap(100000);

        Scanner in = new Scanner(System. in );

        Hashtable < Long, Integer > t = new Hashtable < Long, Integer > (100000);
        Hashtable < Long, Integer > removeT = new Hashtable < Long, Integer > (100000);
        DecimalFormat df = new DecimalFormat("#.#");
        int N = in .nextInt();
        //PrintWriter writer = new PrintWriter(new File("input.txt"));
        for (int i = 0; i < N; i++) {
            char op = in .next().charAt(0);
            long num = in .nextLong();
            Long Num = new Long(num);
            if (i == 1328) {
                int x = 0;
            }
            if (op == 'r') {
                if (!t.containsKey(Num)) {
                    //writer.println("Wrong!");
                    //getMedian(t, minHeap,maxHeap);
                    System.out.println("Wrong!");
                } else {

                    if (!removeT.containsKey(Num))
                        removeT.put(Num, 1);
                    else
                        removeT.put(Num, removeT.get(Num) + 1);
                    removeElement(t, removeT, minHeap, maxHeap, num); // not necessary to check all the rest
                    t.put(Num, t.get(Num) - 1);
                    if (t.get(Num) == 0)
                        t.remove(Num);
                    if (t.isEmpty()) {
                        System.out.println("Wrong!");
                        //writer.println("Wrong");
                        //getMedian(t, minHeap,maxHeap);
                        continue;
                    }
                    //writer.println(df.format(getMedian(t, minHeap,maxHeap)));
                    System.out.println(df.format(getMedian(t, removeT, minHeap, maxHeap)));
                }
            } else if (op == 'a') {
                if (!t.containsKey(Num))
                    t.put(Num, 1);
                else
                    t.put(Num, t.get(Num) + 1);
                addElement(minHeap, maxHeap, num);
                //writer.println(df.format(getMedian(t, minHeap,maxHeap)));
                System.out.println(df.format(getMedian(t, removeT, minHeap, maxHeap)));

            }
        }
        //writer.close();
    }
    public static boolean removeElement(Hashtable < Long, Integer > t, Hashtable < Long, Integer > removeT, PriorityQueue < Long > minHeap, MaxHeap maxHeap, long x) {

        if (minSize == maxSize) {
            Long max = maxHeap.peek();
            if (x == max) {
                maxHeap.remove();

                removeT.put(max, removeT.get(max) - 1);
                if (removeT.get(max) == 0)
                    removeT.remove(max);

                maxSize--;
                return true;
            } else if (x < max) {
                maxSize--;
                return false;
            } else if (x > minHeap.peek()) {
                maxSize--;
                minHeap.add(maxHeap.remove());
                return false;
            } else if (x == minHeap.peek()) {
                Long min = minHeap.peek();
                minHeap.remove();

                removeT.put(min, removeT.get(min) - 1);
                if (removeT.get(min) == 0)
                    removeT.remove(min);

                maxSize--;
                minHeap.add(maxHeap.remove());
                return true;
            }
        } else if (minSize > maxSize) {
            if (minHeap.peek() == x) {
                Long min = minHeap.peek();

                removeT.put(min, removeT.get(min) - 1);
                if (removeT.get(min) == 0)
                    removeT.remove(min);

                minHeap.remove();
                minSize--;
                return true;
            } else if (x == (maxHeap.peek())) {
                Long max = maxHeap.peek();

                removeT.put(max, removeT.get(max) - 1);
                if (removeT.get(max) == 0)
                    removeT.remove(max);

                maxHeap.remove();
                maxHeap.add(minHeap.remove());
                minSize--;
                return true;
            } else if (x < (maxHeap.peek())) {
                maxHeap.add(minHeap.remove());
                minSize--;
                return false;
            } else if (x > (minHeap.peek())) {
                minSize--;
                return false;
            }
        }
        return false;
    }

    public static void addElement(PriorityQueue < Long > minHeap, MaxHeap maxHeap, long x) {
        if (minSize == 0) {
            minHeap.add(x);
            minSize = minSize + 1;
        } else if (x >= minHeap.peek()) {
            if (minSize == maxSize) {
                minHeap.add(x);
                minSize++;
            } else {
                minHeap.add(x);
                maxHeap.add(minHeap.remove());
                maxSize++;

            }
        } else {
            if (minSize != maxSize) {
                maxHeap.add(x);
                maxSize++;
            } else {
                maxHeap.add(x);
                maxSize++;
                minHeap.add(maxHeap.remove());
                minSize++;
                maxSize--;
            }
        }
    }
    public static double getMedian(Hashtable < Long, Integer > t, Hashtable < Long, Integer > removeT, PriorityQueue < Long > minHeap, MaxHeap maxHeap) {
        while (true) {
            Long min = null;
            Long max = null;

            if (maxSize != 0) {
                min = minHeap.peek();
                max = maxHeap.peek();
            } else {
                min = minHeap.peek();
                if (t.containsKey(min) && !removeT.containsKey(min)) {
                    return min;
                } else {
                    minHeap.remove();
                    removeT.put(min, removeT.get(min) - 1);
                    if (removeT.get(min) == 0)
                        removeT.remove(min);
                    continue;
                }
            }
            if (minSize == maxSize) {
                if (t.containsKey(min) && removeT.containsKey(min)) {
                    minHeap.remove();
                    removeT.put(min, removeT.get(min) - 1);
                    if (removeT.get(min) == 0)
                        removeT.remove(min);
                    continue;
                }
                if (t.containsKey(max) && removeT.containsKey(max)) {
                    maxHeap.remove();
                    removeT.put(max, removeT.get(max) - 1);
                    if (removeT.get(max) == 0)
                        removeT.remove(max);
                    continue;
                }

                if (t.containsKey(min) && t.containsKey(max)) {
                    //(new Long(minHeap.peek())+ new Long(maxHeap.peek()))/2.0;
                    return (min + max) / 2.0;
                } else if (!t.containsKey(min) && !t.containsKey(max)) {
                    minHeap.remove();
                    maxHeap.remove();

                    removeT.remove(min);
                    removeT.remove(max);
                } else if (!t.containsKey(min)) {
                    minHeap.remove();
                    removeT.remove(min);
                } else {
                    maxHeap.remove();
                    removeT.remove(max);
                }
            } else if (minSize > maxSize) {
                if (t.containsKey(min) && removeT.containsKey(min)) {
                    minHeap.remove();
                    removeT.put(min, removeT.get(min) - 1);
                    if (removeT.get(min) == 0)
                        removeT.remove(min);
                    continue;
                }
                if (t.containsKey(min)) {
                    return min;
                } else {
                    minHeap.remove();
                    removeT.remove(min);
                }
            }
        }
    }
}