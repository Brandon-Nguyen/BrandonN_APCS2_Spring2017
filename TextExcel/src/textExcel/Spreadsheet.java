//Brandon Nguyen, 2nd Period
package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] array = new Cell [getRows()][getCols()];
	
	public Spreadsheet(){
		//creates a new spredsheet
		newSheet();
	}
	
	@Override
	public String processCommand(String command)
	{
		//checks to see if the input is anything, if not just ends here
		if(command.length() == 0 || command.equals("quit")){
			return "";
		}
		
		//splits the input by spaces
		String[] split = command.split(" ");
		
		//gets rid of issue if the input has lowercases or uppercases
		// for columns
		split[0] = split[0].toUpperCase();
		
		//checks to see if the input is only 3 characters or less
		//which could only be a cell and returns the value
		if(command.length() <= 3){
			return inspectCell(split[0]);
		
		// the first value is all uppercase
		// checks to see if the first word is clear
		}else if(split[0].contains("CLEAR")){
			
			// means that its clear with a cell so clears the cell
			if(split.length == 2){
				clearCell(split[1]);
				
				//returns how the grid looks like afterwards
				return getGridText();
				
			}else{
				
				//clears the entire grid by making an entirely new grid
				newSheet();
				
				//returns the new grid
				return getGridText();
			}
			
		//checks the length, if more than three,
		//then use to set values at a cell
		}else if(command.contains("\"")){
			
			//incase the input has multiple spaces so there are multiple splits
			//for the input or value being set
			//sets for the first value or string
			String combinedStr = split[2];
			
			//the next value of the split array
			int i = 3;
			while(i < split.length){
				//adds the space that was taken out and the next part of the value
				combinedStr += " " + split[i];
				i++;
			}
			
			//calls method to set the cell
			setCellValue(split[0] ,combinedStr);
			// returns the new grid with the new cell and value
			return getGridText();
			
			//checks to see if it has a percentage
		}else if(command.contains("%")){
			setPercentCell(split[0], split[2]);
			return getGridText();
			
			//checks for any sort of operators to call formula cell
		}else if(command.contains("-") || command.contains("+") || command.contains("/") || command.contains("*") 
				&& split.length > 3){
			setFormulaCell(split[0], split[2]);
			return getGridText();
			
			//if there isn't anything then it has to be a value cell
		}else{
			setValueCell(split[0], split[2]);
			return getGridText();
		}
	}

	@Override
	public int getRows()
	{
		//total number of rows
		return 20;
	}

	@Override
	public int getCols()
	{
		//total number of columns
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// uses spreadsheet location to find the location of the cell
		return array[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		//begins the start of the grid
		String grid = "   |";
		
		//fills in the top row with the letters
		for(int i = 0; i < getCols(); i++){
			grid += (char) (i + 'A') + "         |";
		}
		
		//fills in the body or rest of the grid
		for(int i = 1; i <= getRows(); i++){
			//skips to a new line after each row is finished
			grid += "\n";
			
			//fills the first column to 3 characters
			if(i < 10){
				grid += i + "  |";
			}else{
				grid += i + " |";
			}
			
			//sets all the values of each part of the array
			for(int j = 0; j < 12; j++){
				grid += array[i-1][j].abbreviatedCellText() + "|";
			}
		}
		// skips to next line after finishing creating the grid
		grid += "\n";
		return grid;
	}
	
	public String inspectCell(String cellName){
		
		//creating an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation loc = new SpreadsheetLocation(cellName);
		
		//returns the full value of the cell
		return (getCell(loc).fullCellText());
	}
	
	public void clearCell(String location){
		
		//creating an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation loc = new SpreadsheetLocation(location);
		
		//remakes the cell into an empty cell to get rid of the value it had
		array[loc.getRow()][loc.getCol()] = new EmptyCell();
	}
	
	public void newSheet(){
		
		//creates a new grid to make everything empty
		for(int i = 0; i < array.length; i++){
			for( int j = 0; j < array[i].length; j++){
				array[i][j] = new EmptyCell();
			}
		}
	}
	
	public void setCellValue(String loc, String value){
		//creating an instance of spreadsheetLocation to use 
		//the getRow and getCol methods
		SpreadsheetLocation area = new SpreadsheetLocation(loc);
		
		//sets the cell at the location to a textCell and assigns it a value
		array[area.getRow()][area.getCol()] = new TextCell(value);
	}
	
	public void setPercentCell(String loc, String value){
		SpreadsheetLocation area = new SpreadsheetLocation(loc);
		array[area.getRow()][area.getCol()] = new PercentCell(value);
	}
	
	public void setFormulaCell(String loc, String value){
		SpreadsheetLocation area = new SpreadsheetLocation(loc);
		array[area.getRow()][area.getCol()] = new FormulaCell(value);
	}
	
	public void setValueCell(String loc, String value){
		SpreadsheetLocation area = new SpreadsheetLocation(loc);
		array[area.getRow()][area.getCol()] = new ValueCell(value);
	}
}
