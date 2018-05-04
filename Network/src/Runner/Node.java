package Runner;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Node {

	protected String myName;
	protected String ipAdress;
	protected int nCPU;

	public Node() {
		try {
			myName = InetAddress.getLocalHost().getHostName();
			ipAdress = InetAddress.getLocalHost().getHostAddress();
			nCPU = Runtime.getRuntime().availableProcessors();
		} catch (UnknownHostException e) {
			myName = "unkonw";
			ipAdress = "127.0.0.1";
			nCPU = 0;
		}
	}

	public String getHostName() {
		return myName;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public int getnCPU() {
		return nCPU;
	}
}
