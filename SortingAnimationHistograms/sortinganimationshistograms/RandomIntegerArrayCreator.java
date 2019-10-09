package sortinganimationshistograms;

import java.util.Random;

/**
 * Class in charge of generating random int[] arrays. Separated as it only has one job and is used multiple times.
 */
public class RandomIntegerArrayCreator {

    /**
     * Generate random int arrays based on the given length.
     * @param length integer indicating how long the array should be.
     * @return int[] array with numbers from 1 to length numerical value.
     */
    public static int[] generateArrayOfRandomIntegers(int length) {
        //Prepare a random number generator, could also use static version but rather give it a name
        Random randNumGenerator = new Random();

        //Declare an array with 'length' number of items
        int[] array = new int[length];
        //Generate an array of integers from 1 to length
        for (int i = 0; i < array.length; i++) {
            //Increase the value of the next integer by one
            array[i] = i + 1;
        }

        //Shuffle the items in the array
        for (int i = 0; i < array.length; i++) {
            //Pick a random index from the array.
            int index = randNumGenerator.nextInt(array.length);

            //Swap the values in the following way:
            //Take the current value of where i (cursor) is at the moment.
            int temp = array[i];
            //Set the array value at index i (cursor) to the value in the random index generated above
            array[i] = array[index];
            //Set the value to of the random index above to the value of the saved above (temp).
            array[index] = temp;
        }
        //Return shuffled array.
        return array;
    }

}
