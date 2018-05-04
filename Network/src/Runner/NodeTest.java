package Runner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.InetAddress;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	void testGetHostName() {
		Node node = new Node();
		assertEquals(node.getHostName(),"Doctor");
	}

	@Test
	void testGetIpAdress() {
		Node node = new Node();
		assertEquals(node.getIpAdress(),"192.168.0.2");		
	}

	@Test
	void testGetnCPU() {
		Node node = new Node();
		assertEquals(node.getnCPU(),8);
	}

}
