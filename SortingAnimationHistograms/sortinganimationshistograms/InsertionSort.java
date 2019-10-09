package sortinganimationshistograms;

import javafx.application.Platform;

public class InsertionSort extends SortingHistogram {

    public InsertionSort(int[] arrayToSort, String name) {
        super(arrayToSort, name);
    }

    @Override
    public void run() {
        try {
            int i, j, temp;
            for (j = 1; j < array.length; j++) {
                temp = array[j];
                i = j; // range 0 to j-1 is sorted
                while (i > 0 && array[i - 1] >= temp) {
                    array[i] = array[i - 1];
                    i--;
                }
                array[i] = temp;


                //Draw graph
                int lastSortedArray = j;
                Platform.runLater(() -> {
                    updateBarChart(dataSeries, array, lastSortedArray);
                });
                //Sleep as per assignment requirement and to be able to appreciate the graph.
                Thread.sleep(800);

            }
        } catch (Exception ex) {
            //Exception occured.
        }
    }
}
