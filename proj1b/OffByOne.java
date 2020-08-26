import static java.lang.Math.abs;

public class OffByOne implements CharacterComparator{


    public boolean equalChars(char x, char y) {
        if (abs(x - y) <= 1){
            return true;
        }
        return false;
    }


}
