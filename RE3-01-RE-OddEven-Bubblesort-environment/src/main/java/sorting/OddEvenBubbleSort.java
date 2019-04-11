package sorting;

import util.Util;

public class OddEvenBubbleSort<T extends Comparable<T>> extends
        AbstractSorting<T> {


@Override
    public void sort(T[]array,int leftIndex,int rightIndex){

        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < rightIndex -1; i+= 2) {
                if (array[i].compareTo(array[i+1]) == 1) {
                    Util.swap(array, i, i+1);
                    sorted = false; }
            }
            for (int j = 1; j < rightIndex - 1 ; j+= 2) {
                if (array[j].compareTo(array[j+1]) == 1) {
                    Util.swap(array, j, j+1);
                    sorted = false; }
            }
        }
    }

}

