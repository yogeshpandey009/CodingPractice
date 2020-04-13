package threads;

public class SimulateDeadlock {

	public static void main(String[] args) {
		boolean f1 = false;
		boolean f2 = false;
		Thread t1 = new Thread() {
			public void run() {
				while(!f1) {
					f1 = true
					wait();
					while(!f2) {
						f1 = false;
					}
				}
				
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				while(!f2) {
					f2 = true
					wait();
					while(!f1) {
						f1 = true;
					}
				}
				
			}
		};
		t1.start();
		t2.start();
	}
}
