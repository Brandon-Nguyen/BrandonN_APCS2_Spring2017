package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		
		Spreadsheet excel = new Spreadsheet();
		
		TestsALL.Helper th = new TestsALL.Helper();
        System.out.println(th.getText());
        ;
		
		Scanner input = new Scanner(System.in);
		while(input.equals("quit") != true){
			System.out.println("What do you want to do?");
			String command = input.nextLine();
			System.out.println(excel.processCommand(command));
		}
	}
		
}
