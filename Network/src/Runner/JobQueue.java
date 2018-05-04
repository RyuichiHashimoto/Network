package Runner;

import java.util.ArrayList;
import java.util.List;

public class JobQueue implements JobStatus {

	private Job[] jobQueue;

	private final int maxQueueSize;
	private int jobCount;
	private int top; 
	
	public JobQueue(int maxQueueSize_) { 
		maxQueueSize = maxQueueSize_;
		jobQueue = new Job[maxQueueSize];
		jobCount = 0;
		top = 0;
	}
	
    public void enqueue(Job item) {  
        this.jobQueue[(this.top + this.jobCount) % this.maxQueueSize ] = item;
        this.jobCount++;
    }
    
    public Job unqueue() {
    	
        return jobQueue[0];
    }
	
    
	public int countJobs() {  
		return jobCount;
	}

	private int countSpecificJobs(String status) { 
		int ret = 0;
		for (int j = 0; j < countJobs(); j++) {
			if (jobQueue[j].getStatus().equals(status))
				ret++;
		}
		return ret;
	}

	public int countExecutingJobs() { 
		return countSpecificJobs(BUSYSTATUS);
	}

	public int countYetJobs() { 
		return countSpecificJobs(YETSTATUS);
	}

	
	
	
}
