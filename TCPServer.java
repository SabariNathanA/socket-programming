package sort;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.io.*;

public class TCPServer {

	public static void main(String[] args) {
		int[] toSort = new int[5];
		int i;
		try{
			ServerSocket welcomeSocket = new ServerSocket(4404);
			welcomeSocket.setSoTimeout(10000);
			while(true){
				
				Socket connectionSocket = welcomeSocket.accept();
				DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
				DataOutputStream toClient = new DataOutputStream(connectionSocket.getOutputStream());
				
				System.out.println("Client: " + connectionSocket.getRemoteSocketAddress() );
				for(i=0;i<5;i++){
					toSort[i] = inFromClient.readInt();
//					System.out.println(toSort[i]);
				}
				Arrays.sort(toSort);
				i--;
				
				while(i>=0){
//					System.out.println(toSort[i]);
					toClient.writeInt(toSort[i]);
					i--;
				}			
				
				connectionSocket.close();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
