// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> iter;
    private boolean noSuchElement;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
        else {
            noSuchElement = true;
        }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (noSuchElement)
            throw new NoSuchElementException();
	    Integer result = next;
        if (iter.hasNext()) {
            next = iter.next();
        }
        else {
            noSuchElement = true;
        }
        return result;
	}
	
	@Override
	public boolean hasNext() {
	    return !noSuchElement;
	}
}
