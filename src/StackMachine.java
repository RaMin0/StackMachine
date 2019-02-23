import java.util.Stack;

public abstract class StackMachine {
	private Stack<Integer> stack = new Stack<Integer>();

	public void push(int n) {
		stack.push(n);
	}

	public void add() {
		stack.push(stack.pop() + stack.pop());
	}

	public void sub() {
		int y = stack.pop();
		int x = stack.pop();
		stack.push(x - y);
	}

	public void mul() {
		stack.push(stack.pop() * stack.pop());
	}

	public void div() {
		int y = stack.pop();
		int x = stack.pop();
		stack.push(x / y);
	}

	public void swap() {
		int x = stack.pop();
		int y = stack.pop();
		stack.push(x);
		stack.push(y);
	}

	public void drop() {
		stack.pop();
	}

	public void dup() {
		stack.push(stack.peek());
	}

	public void over() {
		int first = stack.pop();
		int second = stack.peek();
		stack.push(first);
		stack.push(second);
	}

	public boolean jz() {
		return stack.pop() == 0;
	}

	public boolean jnz() {
		return !jz();
	}

	public boolean jgz() {
		return stack.pop() > 0;
	}

	public boolean jlz() {
		return stack.pop() < 0;
	}

	public void clear() {
		stack.clear();
	}

	public boolean matches(int[] a) {
		if (a.length != stack.size()) {
			return false;
		}

		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i) != a[i]) {
				return false;
			}
		}

		return true;
	}

	public abstract void run();

	public void print() {
		System.out.println(stack);
	}
}
