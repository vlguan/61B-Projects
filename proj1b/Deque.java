public interface Deque<T>{
	default public boolean isEmpty(){
		if (size() == 0){
            return true;
        }else {
            return false;
        }
	}
	public void addFirst(T d);
	public void addLast(T d);
	public int size();
	//public boolean isEmpty();
	public void printDeque();
	public T removeFirst();
	public T removeLast();
	public T get(int index);
}