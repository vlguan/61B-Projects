public class Palindrome{
	public Deque<Character> wordToDeque(String word){
		ArrayDeque<Character> lld1 = new ArrayDeque<Character>();
		for (int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			lld1.addFirst(c);
		}
		return lld1;
	}
	public boolean isPalindrome(String word) {
		char check = 'x';
		char check1 = 'x';

		if (word.length() == 1 || word.length() == 0) {
			return true;
		}
		Deque<Character> x = wordToDeque(word);
		while (x.size() > 1) {
			check1 = x.removeFirst();
			check = x.removeLast();
			if (check == check1) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isPalindrome(String word, CharacterComparator cc){
		if (word.length() == 1 || word.length() == 0) {
			return true;
		}
		Deque<Character> x = wordToDeque(word);
		while (x.size() > 1) {

			if (cc.equalChars(x.removeFirst(), x.removeLast())) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}