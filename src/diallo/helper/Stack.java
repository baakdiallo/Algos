package diallo.helper;

public class Stack {

	int min = Integer.MAX_VALUE;
	int max = 5;
	int lastIndex = 0;
	int[] stack = new int[max];
	
	public Stack(){}
	
	public void push(int i){
		if(i < min)
			min = i;
		
		if(lastIndex == max)
			resize();
		
		stack[lastIndex] = i;
		lastIndex++;
	}
	
	public int pop(){
		int i = stack[lastIndex - 1];
		lastIndex--;
		return i;
	}
	
	public int peek(){
		return stack[lastIndex - 1];
	}
	
	public int min(){
		return min;
	}
	
	public int size(){
		return lastIndex;
	}
	
	public void resize(){
		max *= 2;
		int[] temp = new int[max];
		for(int i = 0; i < temp.length; i++)
			temp[i] = stack[i];
		stack = temp;
	}
	
}
