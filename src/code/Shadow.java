package code;

import java.util.ArrayList;
import java.util.List;

class Foo {
    public static void testme() {
	System.out.println("Foo");
    }
}

class Bar extends Foo {
    public static void testme() {
	System.out.println("Bar");
    }
}

public class Shadow {

    public static void main(String[] args) {
	List<? super Integer> mylist = new ArrayList<>();
	Long ll = 1l;
	Object obj = 1;
	mylist.add((Integer) obj);
	Number n = 1;
	mylist.add((Integer) n);

    }

}
