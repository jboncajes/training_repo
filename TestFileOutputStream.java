package org.ssglobal.training.codes.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestFileOutputStream {

	public static void main(String[] args) {
		// Need a file pointer first
		
		File file = new File("./src/config/poem.txt"); // Automatically creates a file
		Scanner scan = new Scanner(System.in);
		
			// Setup this first
			try (FileOutputStream fos = new FileOutputStream(file);) {	// try-with-resources
				 // Composition design pattern
				while (true) {
					System.out.println("Enter a message: ");
					String message = scan.nextLine();
					String messageLine = String.join("", message, "\n");	// to append \n or line feed
					byte[] msgBytes = messageLine.getBytes();	// convert texts to bytes
					fos.write(msgBytes);
					if (message.length() == 0) {
						break;
					}
				}
			//	fos.flush();	// always flush before closing
			//	fos.close();	// (always close) add catch clause
			} catch (FileNotFoundException e) {	// surround try catch
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		
		scan.close();
		
	}

}
