package sort;

import java.net.*;
import java.util.*;

public class UDPServer {

	public static void main(String[] args) {
		try{
		DatagramSocket ServerSocket = new DatagramSocket(4404);
		byte[] sendData = new byte[5], receiveData = new byte[5];
		int i;
		int n;
		while(true){
			DatagramPacket receivePkt, sendPkt;
			receivePkt = new DatagramPacket(receiveData,receiveData.length);
			ServerSocket.receive(receivePkt);
			InetAddress ClientIP = receivePkt.getAddress();
			int ClientPort = receivePkt.getPort();
			receiveData = receivePkt.getData();
			int len = receiveData.length;
				
			String sentence = new String (receiveData);
			System.out.println("received Data.. " + sentence);
			
			i=0;
			char[] q = new char[len];
			n = sentence.length();
			while(i<n){
				q[i] = sentence.charAt(i);
				i++;
			}
			
//			System.out.println(q);
			System.out.println("Sorting...");
			
			Arrays.sort(q);
			
//			System.out.println("aftersort");
/*			for(i=0;i<n;i++)
				System.out.print(q[i] + " - ");
*/			
			String returnSentence = String.valueOf(q);
			
//			System.out.println(returnSentence);
			sendData = returnSentence.getBytes();
			
			sendPkt = new DatagramPacket(sendData,sendData.length,ClientIP,ClientPort);
			ServerSocket.send(sendPkt);
			System.out.println("Sorted Data sent to " + ClientIP);
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
