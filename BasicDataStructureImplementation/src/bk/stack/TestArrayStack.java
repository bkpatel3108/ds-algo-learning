package bk.stack;

public class TestArrayStack {
	public static void main(String[] args)
	{
		
		ArrayStack<Integer> arrayStack = new ArrayStack<Integer>(5);
		
		//check empty
		System.out.println("arrayStack.isEmpty() >> "+arrayStack.isEmpty());
		
		//push
		arrayStack.push(4);
		arrayStack.push(2);
		
		//check size
		System.out.println("arrayStack.size() >> "+arrayStack.size());
		
		//top
		System.out.println("arrayStack.top() >> "+arrayStack.top());
		System.out.println("arrayStack.size() >> "+arrayStack.size());
		
		//pop
		System.out.println("arrayStack.pop() >> "+arrayStack.pop());
		System.out.println("arrayStack.size() >> "+arrayStack.size());
		
		//top
		System.out.println("arrayStack.top() >> "+arrayStack.top());
	}
}
