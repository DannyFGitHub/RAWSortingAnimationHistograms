package sortinganimationshistograms;

import javafx.application.Platform;

public class BubbleSort extends SortingHistogram {

    public BubbleSort(int[] arrayToSort, String name) {
        super(arrayToSort, name);
    }

    @Override
    public void run() {
        try {
            int i;
            int j;
            int temp;
            for (i = array.length - 1; i > 0; i--) {
                for (j = 0; j < i; j++) {
                    if (array[j] > array[j + 1]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }// end inner loop

                //Draw graph
                int lastSortedArray = j;
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
