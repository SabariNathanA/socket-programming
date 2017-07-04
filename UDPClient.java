package sort;

import java.net.*;



import java.io.*;


public class UDPClient {

	public static void main(String[] args) throws Exception{
		InetAddress ServerIP = InetAddress.getByName("localhost");
		System.out.println(ServerIP.toString());
		String s;
//		s= s + 'r';
//		int n = s.length(),i=0;
//		char[] q = new char[100];
//		while(i<n){
//			q[i] = s.charAt(i);
//			i++;
//		}
//		Arrays.sort(q);
//		System.out.println(q);
		
		DatagramSocket ClientSocket = new DatagramSocket();
		
		BufferedReader inFromConsole = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter  to stop input");
		
		s = inFromConsole.readLine();
//		int len = s.length();
		byte[] sendData = new byte[5], receiveData = new byte[5];
		sendData = s.getBytes();
//		System.out.println(sendData);

		DatagramPacket sendPkt = new DatagramPacket(sendData, sendData.length,ServerIP, 4404);
		ClientSocket.send(sendPkt);
		
		DatagramPacket receivePkt = new DatagramPacket(receiveData,receiveData.length);
		ClientSocket.receive(receivePkt);
		
		String result = new String(receivePkt.getData());
		System.out.println("Received data..." + result);

		ClientSocket.close();
	}

}
