package com.vonzhou.learn.jvm.oom;

/** P55
 * -Xss2M
 */
public class JavaVMStackOOM {
	private void donotStop(){
		while(true){
			
		}
	}
	
	public void stackLeakByThread(){
		while(true){
			Thread thread = new Thread(new Runnable() {
				public void run() {
					donotStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
