import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void TestEqualChar(){
        boolean d = offByOne.equalChars('s','s');
        assertTrue(d);
        d = offByOne.equalChars('e','s');
        assertFalse(d);
        d = offByOne.equalChars('t','s');
        assertTrue(d);
        d = offByOne.equalChars('r','s');
        assertTrue(d);
    }
    // Your tests go here.
}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.