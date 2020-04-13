package code;

public class RemoveElmLL {

    Node head = null;

    public static void main(String[] args) {
        Boolean t = Boolean.TRUE;
        Boolean s = null;
        while (!(s == t))
            ;
        System.out.println(s);
        /*
         * RemoveElmLL ll = new RemoveElmLL();
         * ll.insert(5).insert(1).insert(3).insert(7).insert(9); ll.display();
         * ll.remove(3); ll.remove(5); ll.display(); ll = new RemoveElmLL();
         * ll.insert(3).insert(3).insert(3).insert(3); ll.display();
         * ll.remove(3); ll.display();
         */
    }

    public RemoveElmLL insert(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(val);
        }
        return this;
    }

    public void display() {
        if (head != null) {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }
        }
        System.out.print("NULL\n");
    }

    public Node remove(int val) {
        if (head != null) {
            Node prev = head;
            Node curr = head.next;
            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }
            if (head.val == val) {
                head = head.next;
            }
        }
        return head;
    }

    class Node {
        int val;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

}
