/*
  * Author: William Kingsley
  * Date: 4/20/2018
  * Overview: JUnit tests for inLab7.java class.
  *
*/
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
class inLab7Test {
    @Test
    void emptyCoinArrayError() {
        int array[] = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {inLab7.calculateReturn(array, 9);});
        assertEquals("Array of size zero is not allowed", exception.getMessage());
    }
    @Test
    void negativeValueError() {
        int array[] = {1, 5, 10, 25};
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
        {inLab7.calculateReturn(array, -1);});
        assertEquals("Value cannot be negative", exception.getMessage());
    }
    @Test
    void zeroValueResult() {
        int[] array = {1, 5, 10, 25};
        int resultArray[] = {0};
        assertArrayEquals(resultArray, inLab7.calculateReturn(array, 0));
    }
    @Test
    void expectedValueResult() {
        int array[] = {1, 5, 10, 25};
        int resultArray[] = {25, 25, 25, 10, 10};
        assertArrayEquals(resultArray, inLab7.calculateReturn(array, 95));
    }
}