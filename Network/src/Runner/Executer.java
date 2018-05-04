package Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Executer {

	public static int executeBat(String path) {
	    String[] cmds = { "cmd.exe", "/c", "echo|" + path };
	    try {
	        return execCommand(cmds);
	    } catch (Exception e) {
//	        e.printStackTrace();;
			return 0;
	    }
	}

	private static int execCommand(String cmd) throws IOException, InterruptedException {
	    return execCommand(new String[] { cmd });
	}

	private static int execCommand(String[] cmds) throws IOException, InterruptedException {
	    ProcessBuilder pb = new ProcessBuilder(cmds);
	            // �W���G���[�o�͂�W���o�͂Ƀ}�[�W����
	    pb.redirectErrorStream(true);
	    Process process = pb.start();
	    InputStream in = null;
	    BufferedReader br = null;
	    try {
	        in = process.getInputStream();
	        br = new BufferedReader(new InputStreamReader(in, "MS932"));
	        String stdout = "";
	        while ( (stdout = br.readLine()) != null) {
	            // �s�v�ȃ��b�Z�[�W��\�����Ȃ�
	            if (stdout.isEmpty())
	                continue;
	            if (stdout.contains("echo off "))
	                continue;
	            if (stdout.contains("���s����ɂ͉����L�[�������Ă������� "))
	                continue;
	            System.out.println(stdout);
	        }
	        
	        System.out.println();
	        return process.waitFor();
	    } finally {
	        br.close();
	        in.close();
	    }
	}
	
}
