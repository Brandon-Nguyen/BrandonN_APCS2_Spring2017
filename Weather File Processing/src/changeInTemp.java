//Brandon Nguyen, 2nd Period, 2/23/17

import java.io.*;
import java.util.*;

public class changeInTemp {
	public static void main (String[] args) throws FileNotFoundException{
		Scanner input = new Scanner (new File ("./data/weather.txt"));
		double currentTemp = input.nextDouble();
		for(int i = 0; i < 7; i++){
			double nextTemp = input.nextDouble();
			int difference = (int)((nextTemp - currentTemp) * 10);
			double diffInTemp = (double) difference / 10.0;
			System.out.println(currentTemp + " to " + nextTemp + 
					", change  = " + (diffInTemp));
			currentTemp = nextTemp;
		}
		input.close();
	}
}
