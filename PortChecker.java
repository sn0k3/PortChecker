import java.net.ServerSocket;
import java.util.Scanner;

public class PortChecker {

	public static boolean isPortFree(int port) {
		if(port < 0) {
			throw new IllegalArgumentException("Invalid port number!");
		}
		
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
			
			return true;
		} catch(Exception e) {
			System.out.println("There is a process running on this port. The port " + port + " is not free.");
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Which port you want to check? ");
		int portInp = userInput.nextInt();
		
		if(PortChecker.isPortFree(portInp) == true) {
			System.out.println("The port is free.");
		}
		
		userInput.close();

	}

}
