package sort;
import java.io.*;
import java.net.*;
public class TCPClient {

	public static void main(String[] args) throws Exception {
		int i,presentNum;
		try{
			Socket clientSocket= new Socket("localhost",4404);
			
			BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream toSocket = new DataOutputStream(clientSocket.getOutputStream());
			DataInputStream inputFromServer = new DataInputStream(clientSocket.getInputStream());
			
			System.out.println("Server :" + clientSocket.getRemoteSocketAddress());
			for(i=0;i<5;i++){
				presentNum = Integer.parseInt(inputFromClient.readLine());
				toSocket.writeInt(presentNum);
			}
			
			i--;
			while(i>=0){
				presentNum = inputFromServer.readInt();
				System.out.println(presentNum);
				i--;
			}
			clientSocket.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
