package sortinganimationshistograms;

import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Abstract class that partially implements important methods. Allowing the subclasses to simply implement the algorithm to sort.
 */
public abstract class SortingHistogram extends VBox implements Runnable {

    /**
     * Protected so only subclass can access directly.
     */
    protected int[] array;
    protected BarChart graph;
    protected XYChart.Series<String, Integer> dataSeries;
    protected String name;

    public SortingHistogram(int[] arrayToSort, String name) {
        try {
            this.name = name;
            this.array = arrayToSort;

            Label nameOfGraph = new Label(name);
            nameOfGraph.setFont(new Font("Arial", 24));
            this.getChildren().add(nameOfGraph);

            //Initiates graph and returns dataseries to be able to manipulate during thread execution.
            dataSeries = convertToBarChart(arrayToSort, 0);

            //Adds the graph to itself (VBox).
            this.getChildren().add(this.graph);

            //Set the alignment of items within the VBox (itself)
            this.setAlignment(Pos.CENTER);

            //Self Launches the thread.
            Thread thread = new Thread(this);
            thread.start();
        } catch (Exception ex){
            System.out.println("The program was unable to launch, try running the program again.");
        }
    }

    /**
     * Abstract class, must Override in order to use.
     */
    @Override
    public abstract void run();

    /**
     *
     * @param array
     * @param lastSortedArray
     * @return
     */
    public XYChart.Series<String, Integer> convertToBarChart(int[] array, int lastSortedArray) {
        CategoryAxis xAxis = new CategoryAxis();
        //xAxis.setLabel("");
        xAxis.setVisible(false);
        xAxis.setOpacity(0);
        xAxis.setTickLabelsVisible(false);
        NumberAxis yAxis = new NumberAxis();
        //yAxis.setLabel("");
        yAxis.setVisible(false);
        yAxis.setOpacity(0);
        yAxis.setTickLabelsVisible(false);

        BarChart barChart = new BarChart(xAxis, yAxis);

        //Initiate value to prevent nullPointerException, its ok as this object will not be used.
        XYChart.Data lastNodeToColorAfterDrawing = new XYChart.Data("", 1);

        XYChart.Series<String, Integer> dataSeries1 = new XYChart.Series();
        dataSeries1.setName("");

        for (int i = 0; i < array.length; i++) {
            XYChart.Data integer = new XYChart.Data(i + "", array[i]);
            dataSeries1.getData().add(integer);

            if (i == lastSortedArray) {
                lastNodeToColorAfterDrawing = integer;
            }
        }

        barChart.getData().add(dataSeries1);

        //Encapsulate in try in case of nullpointer exception:
        try {
            //Now we can color the node as it is part of the graph:
            lastNodeToColorAfterDrawing.getNode().setStyle("-fx-bar-fill: BLACK");
        } catch (Exception ex) {
            //Simply ignore.
        }

        //Make legend invisible
        barChart.setLegendVisible(false);
        //Make all grid lines invisible
        barChart.setVerticalGridLinesVisible(false);
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setHorizontalZeroLineVisible(false);

        //Remove gaps between bars
        barChart.setBarGap(0);
        barChart.setCategoryGap(0);

        barChart.setAnimated(false);

        //Return the drawn barChart
        graph = barChart;

        return dataSeries1;
    }

    public static void updateBarChart(XYChart.Series<String, Integer> dataSeries, int[] array, int lastSortedArray){
        //Initiate value to prevent nullPointerException, its ok as this object will not be used.
        XYChart.Data lastNodeToColorAfterDrawing = new XYChart.Data("", 1);

        for (int i = 0; i < array.length; i++) {
            XYChart.Data integer = new XYChart.Data(i + "", array[i]);
            dataSeries.getData().set(i ,integer);

            if (i == lastSortedArray) {
                lastNodeToColorAfterDrawing = integer;
            }
        }

        //Encapsulate in try in case of nullpointer exception:
        try {
            //Now we can color the node as it is part of the graph:
            lastNodeToColorAfterDrawing.getNode().setStyle("-fx-bar-fill: BLACK");
        } catch (Exception ex) {
            //Simply ignore.
        }

    }

}
