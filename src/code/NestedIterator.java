package code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> nestedIterators;
    Integer nextInt = null;

    public NestedIterator(List<NestedInteger> nestedList) {
	nestedIterators = new Stack<>();
	Iterator<NestedInteger> root = nestedList.iterator();
	nestedIterators.push(root);
	while (hasNextHelper() && nextInt == null) {
	    nextInt = nextHelper();
	}
    }

    @Override
    public Integer next() {
	Integer retNextInt = nextInt;
	nextInt = nextHelper();
	while (hasNextHelper() && nextInt == null) {
	    nextInt = nextHelper();
	}
	return retNextInt;
    }

    private Integer nextHelper() {
	if (hasNextHelper()) {
	    NestedInteger topInteger = nestedIterators.peek().next();
	    while (!topInteger.isInteger()) {
		List<NestedInteger> nl = topInteger.getList();
		Iterator<NestedInteger> nestedIterator = nl.iterator();
		nestedIterators.push(nestedIterator);
		if (nestedIterator.hasNext()) {
		    topInteger = nestedIterator.next();
		    nl = topInteger.getList();
		} else {
		    break;
		}
	    }
	    return topInteger.getInteger();
	}
	return null;
    }

    @Override
    public boolean hasNext() {
	return nextInt == null ? false : true;
    }

    private boolean hasNextHelper() {
	while (!nestedIterators.isEmpty()
		&& nestedIterators.peek().hasNext() == false) {
	    nestedIterators.pop();
	}
	if (nestedIterators.isEmpty())
	    return false;
	return nestedIterators.peek().hasNext();
    }

    public static void main(String[] args) {
	List<NestedInteger> l = new ArrayList<NestedInteger>() {
	    {
		add(new NestedInteger(1));
		add(new NestedInteger(2));
		add(new NestedInteger(3));
	    }
	};
	Iterator<Integer> it = new NestedIterator(l);
	while (it.hasNext()) {
	    System.out.println(it.next());
	}
    }
}

class NestedInteger {

    Integer val;

    NestedInteger(int c) {
	val = c;
    }

    public boolean isInteger() {
	return val == null ? false : true;
    }

    public Integer getInteger() {
	return val;
    }

    public List<NestedInteger> getList() {
	return null;
    }
}
