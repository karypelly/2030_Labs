package eecs2030.lab2;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

/**
 * A class that represents domino tiles. A domino is a rectangular
 * tile with a line dividing its playing face into two sides.
 * Each side of the playing face is marked with pips (dots) similar
 * to a standard 6-sided die. The number of pips on each side
 * of the playing face ranges from Domino.MIN_VALUE to
 * Domino.MAX_VALUE (inclusive).
 * 
 * <p>
 * In simpler terms, each domino tile has two integer values
 * that range from Domino.MIN_VALUE to Domino.MAX_VALUE (inclusive).
 *
 */
public class Domino implements Comparable<Domino> {

	// YOU NEED TO ADD SOME public static final FIELDS HERE
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 6;
	
	
	// YOU NEED TO ADD SOME FIELDS FOR THE STATE OF A DOMINO HERE
	
	public int one;
	public int two;

	
	/**
	 * Initializes this domino so that both of its values are
	 * equal to <code>Domino.MIN_VALUE</code>.
	 */
	public Domino() {
		this.one = MIN_VALUE;
		this.two = MIN_VALUE;
	}

	/**
	 * Initializes this domino to have the specified values.
	 * 
	 * @param value1
	 *            a value
	 * @param value2
	 *            another value
	 * @pre. Domino.isValueOK(value1) && Domino.isValueOK(value2)
	 * @throws IllegalArgumentException
	 *             if value1 or value2 is not a legal domino value
	 */
	public Domino(int value1, int value2) {
		this.one = value1;
		this.two = value2;
		if (value1 < MIN_VALUE || value1 > MAX_VALUE) {
			throw new IllegalArgumentException("value not legal");
		}
		if (value2 < MIN_VALUE || value2 > MAX_VALUE) {
			throw new IllegalArgumentException("value not legal");
		}
	}

	/**
	 * Initializes this domino so that its values are the same as the specified
	 * other domino.
	 * 
	 * @param other
	 *            a domino
	 */
	public Domino(Domino other) {
		this.one = other.one;
		this.two = other.two;
	}
	

	/**
	 * Returns true if the specified value is a legal domino value, and false
	 * otherwise.
	 * 
	 * @param value
	 *            a value to check
	 * @return true if the specified value is a legal domino value, and false
	 *         otherwise
	 */
	public static boolean isValueOK(int value) {
		if (value >= 0 && value <= 6) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Returns a list of size 28 containing all of the tiles of the double-six
	 * set (see test document for details).
	 * 
	 * @return a list of size 28 containing all of the tiles of the double-six
	 *         set
	 */
	public static List<Domino> allDominoes() {
		
		ArrayList<Domino> List = new ArrayList<>();		
		for (int i = 0; i <= 6; i ++) {
			for (int j = i; j <= 6; j++) {
				Domino x = new Domino(i, j);
				List.add(x);
			}
		}
		return List;
	}
	
	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue2</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue1() {
		
		return this.one;
	}

	/**
	 * Returns the value of one of the two sides of the domino (the value of the
	 * other side of the domino is returned by <code>getValue1</code>).
	 * 
	 * @return the value of one of the two sides of the domino
	 */
	public int getValue2() {
		
		return this.two;
	}

	/**
	 * Returns the smaller of the two values of this domino. If both
	 * values of this domino are equal to the same value then that
	 * value is returned.
	 * 
	 * @return the smaller of the two values of this domino
	 */
	public int getSmallerValue() {
		if (this.one < this.two) {
			return this.one;
		} else if (this.one > this.two) {
			return this.two;
		} else {
			return this.one;
		}
	}

	/**
	 * Returns the larger of the two values of this domino. If both
	 * values of this domino are equal to the same value then that
	 * value is returned.
	 * 
	 * @return the larger of the two values of this domino
	 */
	public int getLargerValue() {
		if (this.one > this.two) {
			return this.one;
		} else if (this.one < this.two) {
			return this.two;
		} else {
			return this.one;
		}
	}

	
	/**
	 * Returns true if this domino matches the specified domino, and
	 * false otherwise.
	 *
	 * <p>
	 * Two dominoes match if they have at least one value in common.
	 * Note that the side on which
	 * a value appears is not considered for the purposes of matches;
	 * for instance, <code>m</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 2);  // a and b have the value 4 in common
	 * boolean m = a.matches(b);
	 * </pre>
	 * 
	 * @param other a domino
	 * @return true if this domino matches the specified domino,
	 *         and false otherwise
	 */
	public boolean matches(Domino other) {
		if (this.one == other.one || this.one == other.two || other.two == this.two) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Compares two dominoes by their values. The smaller values on
	 * the two dominoes are compared first; if the smaller values of
	 * both dominoes are equal then the larger values of the two
	 * dominoes are compared.
	 * 
	 * <p>
	 * If the two dominoes are equal then {@code 0} is returned.
	 * 
	 * <p>
	 * This domino is less than the other domino if the smaller value
	 * of this domino is less than the smaller value of the other
	 * domino, or if the larger value of this domino is less than
	 * the larger value of the other domino and the smaller values
	 * of both dominoes are equal.
	 * 
	 * <p>
	 * This domino is greater than the other domino if the smaller value
	 * of this domino is greater than the smaller value of the other
	 * domino, or if the larger value of this domino is greater than
	 * the larger value of the other domino and the smaller values
	 * of both dominoes are equal.
	 * 
	 * @param other the other domino to compare to this domino
	 * @return the value 0 if this domino is equal to other;
	 * a value less than 0 if this domino is less than the other
	 * domino; and a value greater than 0 if this domino is greater than
	 * the other domino 
	 */
	@Override
	public int compareTo(Domino other) {
		if (this.getSmallerValue() < other.getSmallerValue()) {
			return -1;
		}else if (this.getSmallerValue() > other.getSmallerValue()){
			return 1;
		}else{
			if (this.getLargerValue() < other.getLargerValue()) {
				return -1;
			}else if (this.getLargerValue() < other.getLargerValue()) {
				return 1;
			}else {
				return 0;
			}
		}
		
	}
	
	
	/**
	 * Compares this domino to the specified object. The result is
	 * true if and only if the argument is a Domino object having the
	 * same values as this domino object. Note that the side on which
	 * a value appears is not considered for the purposes of equals;
	 * for instance, <code>eq</code> will be true in the example below:
	 * 
	 * <pre>
	 * Domino a = new Domino(1, 4);
	 * Domino b = new Domino(4, 1);
	 * boolean eq = a.equals(b);
	 * </pre>
	 * 
	 * @param obj an object to compare
	 * @return true if this domino is equal to the specified object,
	 *         and false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}else if (obj == null) {
			return false;
		}else if (this.getClass() != obj.getClass()) {
			return false;
		}
		Domino other = (Domino) obj;
		if (this.one == other.one && this.two == other.two) {
			return true;
		}else if (this.one == other.two && this.two == other.one) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Returns a hash code for this domino. The hash code value
	 * is equal to the smaller value of this domino plus eleven times
	 * the larger value of this domino.
	 * 
	 * @return the smaller value of this domino plus eleven times
	 * the larger value of this domino
	 */
	@Override
	public int hashCode() {
		return this.getSmallerValue() + 11 * this.getLargerValue();
	}
	
	/**
	 * Returns a string representation of this domino. The returned
	 * string is the smaller value of this domino followed by
	 * a space, a colon, a space, and finally the larger value of
	 * this domino all inside a pair of square brackets; for example,
	 * if {@code d = new Domino(5, 3)} then {@code d.toString()} returns
	 * the string {@code "[3 : 5]"}.  
	 * 
	 * @return a string representation of this domino
	 */
	@Override
	public String toString() {
		
		return "[" + Integer.toString(this.getSmallerValue()) + " : " + Integer.toString(this.getLargerValue()) + "]";
	}
	
}
