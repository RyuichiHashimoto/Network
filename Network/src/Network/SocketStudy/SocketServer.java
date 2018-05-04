package Network.SocketStudy;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import Network.SocketInterface;

public class SocketServer implements SocketInterface {

	void runSample() {
		ServerSocket sSocket = null;
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			sSocket = new ServerSocket();
			sSocket.bind(new InetSocketAddress("127.0.0.1", portNumber));

			// before the accept of the
			System.out.println("please read");

			// Keep waiting the number
			socket = sSocket.accept();

			// reader
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			writer = new PrintWriter(socket.getOutputStream(), true);
			String line = null;
			int num;

			while (true) {

				line = reader.readLine();

				if (line.equals(FINISHSTATUS))
					break;
				try {
					
					num = Integer.parseInt(line);

					if (num % 2 == 0)
						writer.println("OK!");
					else
						writer.println("NG!");
					
					
					
				} catch (NumberFormatException e) {
					writer.println("please input any number");
				}

				System.out.println("クライアントで入力された文字=" + line);
			}
		} catch (Exception e) {
			e.printStackTrace();	
		} finally {
			
			try {
				if (reader != null) 
					reader.close();
				
				if (writer != null) 
					writer.close();

				if (socket != null) 
					socket.close();				
				
				if (sSocket != null) 
					sSocket.close();
				
				System.out.println("finish the server");
			}  catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		SocketServer s1 = new SocketServer();
		s1.sendFile(args[0],"127.0.0.1");
	}
	
	
}
