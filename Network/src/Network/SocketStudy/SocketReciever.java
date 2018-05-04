package Network.SocketStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Network.SocketInterface;

public class SocketReciever implements SocketInterface{

	void runSample() {
		
		Socket cSocket = null;
		BufferedReader csInput = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		
		try {
			cSocket = new Socket("127.0.0.1",portNumber);			
			
			csInput = new BufferedReader(new InputStreamReader(System.in));
			
			writer = new PrintWriter(cSocket.getOutputStream(),true);
			
			reader = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
			
			String line = null;
			while (true) {
				System.out.println("----------------------------------");
				System.out.println("please input the even number");
				System.out.println("----------------------------------");
				
				line = csInput.readLine();
				
				writer.println(line);
				
				if (line.equals(FINISHSTATUS))
					break;
				
				System.out.println("A responce from Server is: "+reader.readLine());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
				if (csInput != null) {
					csInput.close();
				}
				if (cSocket != null) {
					cSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	        System.out.println("クライアント側終了です");
		}		
	}

	public static void main(String[] args) {
		SocketReciever socketReciever = new SocketReciever();
		
//		socketReciever.runSample();
		socketReciever.recieveFile(args[0]);
	}
	
}
