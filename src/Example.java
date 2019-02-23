/**
 * Example
 * Runs (a / b) + 3
 */
public class Example extends StackMachine {
	public static int a = 4;
	public static int b = 2;

	@Override
	public void run() {
		push(0);
		push(a);

		while (true) {
			push(b);
			sub();
			swap();
			push(1);
			add();
			swap();
			dup();
			push(b);
			sub();
			if (jgz()) {
				continue;
			}
			drop();
			push(3);
			add();
			break;
		}

		print();
	}

	public static void main(String[] args) {
		new Example().run();
	}
}
