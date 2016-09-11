
public class LinkedStack<T> implements Stack<T>{
	
	SinglyLinkedList<T> linkedList = new SinglyLinkedList<T>();
	
	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
		linkedList.addFirst(t);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return linkedList.removeFirst();
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		return linkedList.first();
	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return linkedList.isEmpty();
	}

}
