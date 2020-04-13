package code;

class Node {
    public Node next = null;
    public int val;

    Node(int v) {
        this.val = v;
    }
}

class LinkedList {
    Node head;

    public void insert(int v) {
        Node node = new Node(v);
        Node temp;
        temp = head;
        head = node;
        node.next = temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void displayReverse() {
        recurPrintRev(head);
    }

    private void recurPrintRev(Node head) {
        if (head != null) {
            recurPrintRev(head.next);
            System.out.println(head.val);
        }
    }

    public void reverse() {
        // head = recurReverse(head);
        recurReverse2(head);
    }

    private Node recurReverse(Node head) {
        if (head != null) {
            if (head.next == null) {
                return head;
            }
            Node new_head = recurReverse(head.next);
            Node last = head.next;
            last.next = head;
            head.next = null;
            return new_head;
        }
        return null;
    }

    public void recurReverse2(Node head) {
        if (head != null) {
            if (head.next == null) {
                this.head = head;
            } else {
                recurReverse2(head.next);
                Node last = head.next;
                last.next = head;
                head.next = null;
            }
        }
    }

    public void iterReverse() {
        Node start = head, new_head = null;
        if (start != null) {
            while (start.next != null) {
                new_head = start.next;
                start.next = new_head.next;
                new_head.next = head;
                head = new_head;
            }
        }
    }

    public void iterPrintRev() {
        Node temp = head;
        while (temp != null) {
            // TODO:
        }
    }

    public void incrementBy1() {
        incrementAndReturnIfCarry(head);
    }

    private boolean incrementAndReturnIfCarry(Node curr) {
        boolean carry = false;
        if (curr != null) {
            if (curr.next == null) {
                if (curr.val == 9) {
                    curr.val = 0;
                    carry = true;
                } else {
                    curr.val++;
                    carry = false;
                }
                return carry;
            } else {
                carry = incrementAndReturnIfCarry(curr.next);
                if (carry) {
                    if (curr != head) {
                        if (curr.val == 9) {
                            curr.val = 0;
                            carry = true;
                        } else {
                            curr.val++;
                            carry = false;
                        }
                    } else {
                        if (carry) {
                            if (curr.val == 9) {
                                curr.val = 0;
                                carry = true;
                                Node new_node = new Node(1);
                                new_node.next = curr;
                                head = new_node;
                            } else {
                                curr.val++;
                                carry = false;
                            }
                            return false;
                        }
                    }
                }
                return carry;
            }
        }
        return false;
    }

    public Node oddEvenList() {
        Node evenListHead = new Node(-1);
        Node oddListLast = head;
        Node evenListLast = evenListHead;
        Node curr = head.next;
        int i = 2;
        while (curr != null) {
            if (i % 2 == 0) {
                evenListLast.next = curr;
                evenListLast = curr;
            } else {
                oddListLast.next = curr;
                oddListLast = curr;
            }
            i++;
            curr = curr.next;
        }
        oddListLast.next = evenListHead.next;
        return head;
    }
}

public class MyLinkedList {

    public static void main(String... args) {

        LinkedList ll = new LinkedList();
        ll.insert(1);
        // ll.insert(2);
        // ll.insert(3);
        // ll.insert(4);
        // ll.insert(5);
        // ll.reverse();
        // ll.oddEvenList();
        // ll.display();
        // ll.display();
        // ll.displayReverse();
        ll.iterReverse();
        // ll.display();
        // ll.incrementBy1();
        ll.display();
    }

}
