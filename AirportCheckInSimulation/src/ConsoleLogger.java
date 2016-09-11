
public class ConsoleLogger {

	public static Integer mode = 2;

	public void logln(String s) {
		if (mode == 1) {
			System.out.println(s);
		}
	}

	public void log(String s) {
		if (mode == 1) {
			System.out.print(s);
		}
	}

	public void setMode(Integer mode) {
		this.mode = mode;

	}

}
