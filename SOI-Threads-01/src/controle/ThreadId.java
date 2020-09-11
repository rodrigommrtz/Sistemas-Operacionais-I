package controle;

public class ThreadId extends Thread {
	
	private int Id;
	
	
	public ThreadId(int Id) {
		this.Id = Id;
	}

	
	@Override
	public void run() {
		System.out.println("Thread " +(Id+1));
	}
			
}
