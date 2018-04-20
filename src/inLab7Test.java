/* */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
class inLab7Test {
    @Test
    void exceptionError() {
        int array[] = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {inLab7.calculateReturn(array, 9);});
        assertEquals("Array of size zero is not allowed", exception.getMessage());
    }
    @Test
    void negativeValue() {
        int array[] = {1, 5, 10, 25};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {inLab7.calculateReturn(array, -1);});
        assertEquals("Value cannot be negative", exception.getMessage());
    }
    //Reconstruct test to suit dynamically generated solution
    //Old test case code below (Non-dynamic)
    @Test
    void minValue() {
        int[] array = {1, 5, 10, 25};
        int[][] intArray = null; // = {1};
        Arrays.sort(intArray);
        assertArrayEquals(intArray, inLab7.calculateReturn(array, 1));
    }
    //Reconstruct test to suit dynamically generated solution
    //Old test case code below (Non-dynamic)
    @Test
    void expectedResult() {
        int array[] = {1, 5, 10, 25};
        int[][] intArray = null; //= //{25, 25, 10, 25, 10};
        Arrays.sort(intArray);
        assertArrayEquals(intArray, inLab7.calculateReturn(array, 95));
    }
}