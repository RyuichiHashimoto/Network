package Runner;

import java.io.File;
import java.io.IOException;

public class Job extends Thread implements Runnable, JobStatus {

	private final String command;

	private String Status;

	public Job(String _command) {
		command = _command;
	}

	@Override
	public void run() {
		try {
			Status = BUSYSTATUS;
			System.out.println(Executer.executeBat(command));
			Status = SUCCESSSTATUS;
		} catch (Exception e) {
			e.printStackTrace();
			Status = ERRORSTATUS;
		}
	}
	public String getCommand() {
		return command;
	}
	
	public String getStatus() {
		return Status;
	}
	public static void main(String[] args) {
		String path = new File(".").getAbsoluteFile().getParent();
		String command = "cmd.exe /c call " + path + "\\do.bat";
		System.out.println(path );
		Job runner = new Job(command);
		runner.run();
		System.out.println(runner.getStatus());
	}
}
