package Day_17;

import org.junit.Test;

import static Day_17.BiggestNumber.biggest;
import static org.junit.Assert.assertEquals;

public class BiggestNumberTest {


    @Test
    public  void testBiggest(){
        int arr[]={12,3,7,22,32,43};
        assertEquals(43, biggest(arr));
    }

}

