package bearmaps;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    int i = 0;
    private ArrayList<PriorityNode> items;
    private int index;
    public static HashMap<Object, Object> tmp;
    public ArrayHeapMinPQ() {
        tmp = new HashMap<Object, Object>();
        items = new ArrayList<>();
        index = 0;
    }

    @Override
    public void add(T item, double priority) {
        if (tmp.containsKey(item)){
            throw new IllegalArgumentException();
        }

        if(size() != 0 ){
            items.add(new PriorityNode(item, priority));
            tmp.put(item, size()-1);
            int current = size() -1;
//            swim(index);
//            index++;
            // System.out.println(items.get(current).getPriority());

            while(current != 0) {

                if (items.get(current).compareTo(items.get(parent(current))) < 0) {

                    swap(current, parent(current));

                }

                current = parent(current);

            }

        }else{
        items.add(new PriorityNode(item, priority));
        tmp.put(item, size()-1);
        }

    }

    @Override
    public boolean contains(T item) {
        return tmp.containsKey(item);
    }

    @Override
    public T getSmallest() {
        if (size() == 0){
            throw new NoSuchElementException("PQ is empty");
        }
        return items.get(0).item;
    }

    @Override
    public T removeSmallest() {
        if (size() == 0) {
            throw new NoSuchElementException("PQ is empty");
        }
        swap(0,size() - 1);
        items.remove(size()-1);
        swimdown(0);
        return null;

    }
    public void swimdown(int pos){
        if (!isLeaf(pos)){
            if (Right(pos) > size() - 1){
                System.out.println("here");
                if(items.get(pos).compareTo(items.get(Left(pos))) > 0){
                    swap(pos,Left(pos));
                    swimdown(Left(pos));
                }
            }
            if(items.get(pos).compareTo(items.get(Left(pos))) > 0 ||
                    items.get(pos).compareTo(items.get(Right(pos))) > 0){
                if(items.get(Right(pos)).compareTo(items.get(Left(pos))) < 0){
                    System.out.println("left");

                    swap(pos, Left(pos));
                    swimdown(Left(pos));
                }else{
                    System.out.println("right");
                    swap(pos, Right(pos));
                    swimdown(Right(pos));

                }

            }
        }


    }

    @Override
    public int size() {
        return items.size();
    }


    @Override
    public void changePriority(T item, double priority) {
        if (contains(item) == false) {
            throw new NoSuchElementException("PQ does not contain " + item);
        }
        int pos = (int) tmp.get(item);
        items.get(pos).setPriority(priority);
    }
    public int parent(int pos){
        return ((pos - 1)/2)  ;
    }
    public int Left(int pos){
        return (pos * 2) + 1;
    }
    public int Right(int pos){
        return (pos * 2) + 2;
    }
    public boolean isLeaf(int pos){

        if (pos >= ((size()-1) / 2) && size()-1 <= pos){
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }
    public void swap(int pos1, int pos2){
        T pos1Item = items.get(pos1).item;
        T pos2Item = items.get(pos2).item;
        PriorityNode temp = items.get(pos1);
        items.set(pos1, items.get(pos2));
        items.set(pos2, temp);
        tmp.put(pos1Item, pos2);
        tmp.put(pos2Item, pos1);
    }
    public void minHeap(){

        System.out.println("minHeap:    " + i);
        i++;
        for(int pos = ((size()/2)); pos > 1; pos--){
            System.out.println("interation:          " + pos);
            heapify(pos - 1);
        }
    }
    public void heapify(int i){
        if (!isLeaf(i)){
            if (items.get(i).compareTo(items.get(Left(i))) <= 0 ||
                    items.get(i).compareTo(items.get(Right(i))) <= 0){
                if(items.get(Right(i)).compareTo(items.get(Left(i))) >= 0){
                    System.out.println("left");
                    swap(i, Left(i));
//                    heapify(Left(i));
                }else{
                    System.out.println("right");
                    swap(i, Right(i));
//                    heapify(Right(i));

                }

            }

        }
    }
    public double printPriority(int i){
        return items.get(i).getPriority();
    }
    private class PriorityNode implements Comparable<ArrayHeapMinPQ.PriorityNode> {
        private T item;
        private double priority;

        PriorityNode(T e, double p) {
            this.item = e;
            this.priority = p;
        }

        T getItem() {
            return item;
        }

        double getPriority() {
            return priority;
        }

        void setPriority(double priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(ArrayHeapMinPQ.PriorityNode other) {
            if (other == null) {
                return -1;
            }
            return Double.compare(this.getPriority(), other.getPriority());
        }

        @Override
        @SuppressWarnings("unchecked")
        public boolean equals(Object o) {
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            } else {
                return ((ArrayHeapMinPQ.PriorityNode) o).getItem().equals(getItem());
            }
        }

        @Override
        public int hashCode() {
            return item.hashCode();
        }
    }

}
