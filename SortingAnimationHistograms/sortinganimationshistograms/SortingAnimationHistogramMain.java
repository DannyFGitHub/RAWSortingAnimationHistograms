package sortinganimationshistograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Program to show histogram animations of sorting principles. Currently configured to show Bubble Sort, Insertion Sort and Selection Sort
 */
public class SortingAnimationHistogramMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {

            BubbleSort bubbleSort = new BubbleSort(RandomIntegerArrayCreator.generateArrayOfRandomIntegers(30), "Bubble Sort");
            InsertionSort insertionSort = new InsertionSort(RandomIntegerArrayCreator.generateArrayOfRandomIntegers(30), "Insertion Sort");
            SelectionSort selectionSort = new SelectionSort(RandomIntegerArrayCreator.generateArrayOfRandomIntegers(30), "Selection Sort");

            VBox verticalShelf = new VBox();

            verticalShelf.getChildren().add(insertionSort);
            verticalShelf.getChildren().add(selectionSort);
            verticalShelf.getChildren().add(bubbleSort);

            primaryStage.setScene(new Scene(verticalShelf));
            primaryStage.show();


        } catch (Exception ex) {
            // Notify user through console.
            System.out.println(ex);
        }
    }


}

