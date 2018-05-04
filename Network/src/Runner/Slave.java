package Runner;

import Compression.Compression;
import Network.SocketInterface;

public class Slave extends Node implements SocketInterface {

	private JobQueue jobQueue;

	private int doneJobCounter;

	private int performingTaskCounter;

	// �v���O���������s����Ԋu(Slave���̏������d�����Ȃ�Ȃ��悤��)�D
	private int waitingTime = 10;

	public Slave() {
		super();
		doneJobCounter = 0;
		performingTaskCounter = 0;
		jobQueue = new JobQueue(nCPU);
	}

	public void runProgram() {
		Job job = jobQueue.unqueue();
		performingTaskCounter++;
		job.start();
		performingTaskCounter--;
		doneJobCounter++;
	}

	private void recieveTask() {
		// �l�b�g���[�N����

		boolean flag = false;
		do {

			if (flag)
				break;

		} while (true);
	}

	private JobQueue getJobQueue() {
		return jobQueue;
	}

	private int countJobInQueue() {
		return jobQueue.countJobs();
	}

	public static void main(String[] args) {
		Slave me = new Slave();
		me.recieveTask();

		try {
			for (int t = 0; t < me.countJobInQueue(); t++) {

				me.getJobQueue().get(t).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//result�f�B���N�g�����܂Ƃ߂�
		Compression.Compression("result");
		
		//Send outputFile
		
	}

}
