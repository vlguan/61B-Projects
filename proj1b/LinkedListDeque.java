public class LinkedListDeque<T> implements Deque<T>{
    Node head;
    Node tail;
    int size;
    class Node {
        T data;

        Node prev;
        Node next;
        Node(T d, Node p, Node n){
            data = d;
            prev = p;
            next = n;
        }
    }
    public LinkedListDeque(){
        head = null;
        tail = null;
        size = 0;
    }
    public LinkedListDeque(LinkedListDeque other){
        head = null;
        tail = null;
        size = 0;
        Node curr = other.head;
        while(curr != null){
            addLast((T) curr.data);
            curr = curr.next;
        }

    }
    public void addFirst(T d){
        if (isEmpty() == true) {
            head = new Node(d, null, null);
            tail = head;
        }else{
            head = new Node(d, null, head);

        }
        size++;
    }
    public void addLast(T d){
        Node x = head;
        if (isEmpty() == true) {
            head = new Node(d, null, null);
            tail = head;
        }else {
            while (x.next != null) {
                x = x.next;
            }
            x.next = new Node (d, x,null);
            tail = x.next;
        }
        size++;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node current = head;
        for(int i = 0; i < size; i++){
            T x = get(i);
            System.out.println(x);

        }

    }

    public T removeFirst(){
        if (isEmpty() == false){
            T temp1 = head.data;
            head = head.next;
            size--;
            return temp1;
        }else {
            return null;
        }
    }
    public T removeLast(){

        if (isEmpty() == false){
            //System.out.println("whatthefuckbitch");
            if (size == 1){
                T temp1 = removeFirst();
                return temp1;
            }else {
                Node temp = head;
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                T temp1 = temp.next.data;
                tail = temp;
                temp.next = null;
                size--;
                return temp1;
            }
        }else{
            return null;
        }

    }


    public T get(int index){
        int c = 0;
        Node x = head;

        while (x != null && c != index){


            x = x.next;
            c++;
        }
        return x.data;
    }
    public T getRecursive(int index){
        if (index == 0){
            return this.head.data;
        }
        index--;
        LinkedListDeque<T> temp = new LinkedListDeque<T>(this);
        temp.removeFirst();
        return temp.getRecursive(index);


    }

}