import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("127.0.0.1", 39877);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		BufferedReader cbr = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.print("Type your massage: ");
			String input = cbr.readLine();

			bufferedWriter.write(input + "\n");
			bufferedWriter.flush(); // flush - remove bufferedWriter

			if (input.contains("exit")) {

				break;
			}

			String line = bufferedReader.readLine();
			System.out.println("Server response: " + line);
		}

		bufferedReader.close();
		bufferedWriter.close();
		socket.close();

		System.out.println("Client finish");

	}
}