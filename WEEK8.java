class MyThread extends Thread {
	long time;
	private volatile boolean running = true;

	MyThread() {
		System.out.println("Default");
	}

	MyThread(String name, long time) {
		super(name);
		this.time = time;
	}

	public void pause() {
		running = false;
	}

	public void run() {
		try {
			while (running) {
				System.out.println(this.getName());
				Thread.sleep(time * 1000);
			}
		} catch (InterruptedException ie) {
			System.out.println("Exception caught in method");
		}

	}
}

class ThreadRunner {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread("BMS", 10);
		MyThread mt2 = new MyThread("CSE", 2);
		mt1.start();
		mt2.start();
		try {
			Thread.sleep(20 * 1000);
			mt1.pause();
			mt2.pause();
		} catch (InterruptedException ie) {
			System.out.println("Exception caught in main");
		}
	}

}
