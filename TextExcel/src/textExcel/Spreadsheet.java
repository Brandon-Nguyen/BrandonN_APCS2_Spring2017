package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] array = new Cell [getRows()][getCols()];
	
	public Spreadsheet(){
		for(int i = 0; i < array.length; i++){
			for( int j = 0; j < array[i].length; j++){
				array[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		String[] split = command.split(" ");
		split[0] = split[0].toUpperCase();
		if(command.length() <= 3){
			
			SpreadsheetLocation loc = new SpreadsheetLocation(split[0]);
			return (getCell(loc).fullCellText());
			
		}else if(command.contains("clear")){
			if(split.length == 2){
				SpreadsheetLocation loc = new SpreadsheetLocation(split[1]);
				//System.out.println(split[1]);
				//System.out.println(loc.getRow());
				//System.out.println(loc.getCol());
				array[loc.getRow()][loc.getCol()] = new EmptyCell();
				//System.out.println();
				return getGridText();
				
			}else{
				for(int i = 0; i < array.length; i++){
					for( int j = 0; j < array[i].length; j++){
						array[i][j] = new EmptyCell();
					}
				}
				return getGridText();
			}
		}else if(split.length >= 3){
			SpreadsheetLocation area = new SpreadsheetLocation(split[0]);
			System.out.println(split[0]);
			System.out.println(split[1]);
			System.out.println(split[2]);
			String combinedStr = split[2];
			int i = 3;
			while(i < split.length){
				combinedStr += " " + split[i];
				i++;
			}
			array[area.getRow()][area.getCol()] = new TextCell(combinedStr);
			System.out.println(getCell(area).fullCellText());
			getGridText();
			
		}
		
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		System.out.println(loc.getRow());
		System.out.println(loc.getCol());
		return array[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String grid = "   |";
		for(int i = 0; i < getCols(); i++){
			grid += (char) (i + 'A') + "         |";
		}
		for(int i = 1; i <= getRows(); i++){
			grid += "\n";
			if(i < 10){
				grid += i + "  |";
			}else{
				grid += i + " |";
			}
			for(int j = 0; j < 12; j++){
				grid += array[i-1][j].abbreviatedCellText() + "|";
			}
		}
		grid += "\n";
		return grid;
	}

}
