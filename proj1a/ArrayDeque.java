public class ArrayDeque<T> implements Deque<T>{
    private T[] data;
    private int size;
    public ArrayDeque(){
        data = (T[]) new Object[8];
        size = 0;
    }
    public ArrayDeque(ArrayDeque other){
        size = other.size();
        for(int i = 0; i < other.size; i++){
            //if (other.get(i) != null){
            data[i] = (T)other.data[i];
            //}
        }
    }
    @Override
    public void addFirst(T item){
        if (data.length == size){
            data = resize();
            T[] x = (T[]) new Object[size+1];
            System.arraycopy(data, 0, x, 1, size);
            x[0] = item;
            data = x;
            size++;
        }else{
            if(size == 0){
                data[0] = item;
                size++;
            }else{
                T[] x = (T[]) new Object[size+1];
                System.arraycopy(data, 0, x, 1, size);
                x[0] = item;
                data = x;
                size++;
            }
        }
    }
    @Override
    public void addLast(T item){
        if (data.length == size){
            data = resize();
            data[size] = item;
            size++;
        }else{
            if(size == 0){
                data[0] = item;
                size++;
            }else{
                data[size] = item;
                size++;
            }
        }
    }
    @Override
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        for (int i = 0; i < size; i++){
            System.out.println(data[i]);
        }
    }
    @Override
    public T removeFirst(){
        if (isEmpty() == false){
            T temp = data[0];
            T[] x = (T[]) new Object[size];
            System.arraycopy(data, 1, x, 0, size);
            data = x;
            size--;
            return temp;
        }
        return null;
    }
    @Override
    public T removeLast(){
        if (isEmpty() == false){
            T temp = data[size-1];
            data[size-1] = null;
            size--;
            return temp;
        }
        return null;
    }
    @Override
    public T get(int index){
        return data[index];
    }
    @Override
    public T[] resize(){
        T[] x = (T[]) new Object[size+1];
        System.arraycopy(data, 0, x, 0, size);
        return x;
    }
}