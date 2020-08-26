import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeLast();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void TestPalindrome(){
        boolean d = palindrome.isPalindrome("a");
        assertTrue(d);
        d = palindrome.isPalindrome("racecar");
        assertTrue(d);
        boolean e = palindrome.isPalindrome("cocke");
        assertFalse(e);
        d = palindrome.isPalindrome("cocksusdfdcker");
        assertFalse(d);
        d = palindrome.isPalindrome("noon");
        assertTrue(d);
        d = palindrome.isPalindrome("noOn");
        assertFalse(d);
        d = palindrome.isPalindrome("flake", cc);
        assertTrue(d);
        d = palindrome.isPalindrome("flakes", cc);
        assertFalse(d);
        d = palindrome.isPalindrome("coochie", cc);
        assertFalse(d);
        d = palindrome.isPalindrome("racebbs", cc);
        assertTrue(d);
    }
}     //Uncomment this class once you've created your Palindrome class.