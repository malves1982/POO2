package aula05;

import java.applet.Applet;

public class AppletLifeCicle extends Applet {
	
	private String message;

	public void init() {
		showMessage("init: A firma esta aberta...");
	}
	

	public void start() {
		showMessage("\nstart: Maos a obra pessoal!");
	}
	

	public void stop() {
		showMessage("\nstop: Sismei de \"dar um tempo\"...");
	}
	

	public void destroy() {
		showMessage("\ndestroy: Expediente encerrado.");
	}


	private void showMessage(String string) {
		System.out.println(string);
	}	
}
