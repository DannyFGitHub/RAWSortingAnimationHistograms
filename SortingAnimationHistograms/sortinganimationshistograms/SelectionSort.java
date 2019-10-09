package sortinganimationshistograms;

import javafx.application.Platform;

public class SelectionSort extends SortingHistogram {

    public SelectionSort(int[] arrayToSort, String name) {
        super(arrayToSort, name);
    }

    @Override
    public void run() {
        try {
            int i, j, temp, minimumPosition;
            for (i = 0; i < array.length; i++) {
                minimumPosition = i;
                for (j = i + 1; j < array.length; j++) {
                    if (array[j] < array[minimumPosition]) {
                        if (array[j] < array[minimumPosition]) {
                            minimumPosition = j;
                        }
                    }
                }//end inner for loop
                if (minimumPosition != i) {
                    temp = array[i];
                    array[i] = array[minimumPosition];
                    array[minimumPosition] = temp;
                }

                //Draw graph
                int lastSortedArray = i;
                Platform.runLater(() -> {
                    updateBarChart(dataSeries, array, lastSortedArray);
                });
                //Wait 0.8 seconds
                Thread.sleep(800);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
