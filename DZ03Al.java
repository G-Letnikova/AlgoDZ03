class sList{
    Node head;
    class Node{
        int value;
        Node next;
    }

    void push_front(int value){
        Node node = new Node();
        node.value = value;

        node.next = head;
        head = node;
    }

        void print(){
        Node cur = head;
        while(cur != null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    void reverseSlist() {
        if (head != null && head.next != null) {
            Node curN = head.next;
            head.next = null;
            while(curN != null){
                Node nextN = curN.next;
                curN.next = head;
                head = curN;
                curN = nextN;
            }
        }
    }
}
class dList{
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node prev;
    }

    void push_front(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    void print(){
        Node cur = head;
        while(cur != null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    void reverseDlist() {
        Node curN = head;

        while (curN != null) {
            Node nextN = curN.next;
            Node prevN = curN.prev;
            curN.next = prevN;
            curN.prev = nextN;
            if (prevN == null) tail = curN;
            if (nextN == null) head = curN;
            curN = nextN;
        }
    }
}

public class DZ03Al {
    public static void main(String[] args) {

        sList listS = new sList();
        dList listD = new dList();

        for(int i=1; i<=5; i++) {
            listS.push_front(i);
            listD.push_front(i+5);

        }
        System.out.println("------- разворот односвязного списка -----------");
        listS.print();
        listS.reverseSlist();
        listS.print();

        System.out.println("------- разворот двусвязного списка -----------");
        listD.print();
        listD.reverseDlist();
        listD.print();

    }
}