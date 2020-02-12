import java.util.*;
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Edem Ahorlu
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;
		for (int i = 0; i<size; i++) {
			myWords[i] = source[start];
			start++;
		}


	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return the number of words stored in instance variable myWords
	 */
	public int length(){
		return myWords.length;
	}


	/**
	 * Complete appropriate comment here
	 * @param o	is checked to see if it's a WordGram object
	 * @return false if o is not a WordGram, otherwise return true
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof WordGram) || o == null) {
			return false;
		} else {
			for (int g = 0; g < myWords.length; g++) {
				if (!(myWords[g].equals(((WordGram) o).wordAt(g)))) {
					return false;
				}
			}
			return true;
		}
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		myHash = this.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is the string at the last index of the new WordGram
	 * @return new WordGram (with k entries) whose first k-1 entries
	 * are the same as the last k-1 entries of the original WordGram
	 */
	public WordGram shiftAdd(String last) {
		String[] newword = new String[myWords.length];
		System.arraycopy(myWords, 1,newword,0,myWords.length-1);
		newword[newword.length-1] = last;
		WordGram wg = new WordGram(newword,0,myWords.length);
		// TODO: Complete this method
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method
		List<String> wordlist = Arrays.asList( myWords);
		myToString = String.join(" ", wordlist);
		return myToString;
	}
}
