package Runner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class JobTest implements JobStatus{

	@Test
	void testJob() {
		String command = "perform program";
		Job job = new Job("perform program");
		
		assertEquals(job.getCommand(),"perform program");
		assertEquals(job.getStatus(),null);
	}

	@Test
	void testRun() {
		Job job = new Job("do.bat");

		job.run();
		System.out.println(job.getStatus());
		assertEquals(job.getStatus(), SUCCESSSTATUS);

	}

	@Test
	void testGetStatus() {
		fail("Not yet implemented");
	}

}
