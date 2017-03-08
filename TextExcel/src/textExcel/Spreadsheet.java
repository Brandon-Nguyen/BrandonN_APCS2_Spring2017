package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] array;
	
	public Spreadsheet(){
		array = new Cell [20][12];
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
		if(command.length() <= 3){
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return (getCell(loc).fullCellText());
			
		}else if(command.contains("clear")){
			if(command.length() > 7){
				String[] split = command.split(" ");
				SpreadsheetLocation loc = new SpreadsheetLocation(command);
				clear(loc);
				return getGridText();
			}else{
				for(int i = 0; i < array.length; i++ ){
					for(char j = 'a'; j < array[i].length; j++){
						array[j][i] = new EmptyCell();
					}
				}
				return getGridText();
			}
		}else if(command.split(" ").length == 3){
			String[] split = command.split(" ");
			SpreadsheetLocation area = new SpreadsheetLocation(command);
			Cell loc = getCell(area);
			loc = new TextCell(split[2]);
			
		}
		
		return "";
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return array.length;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return array[1].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return array[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		String grid = "   ";
		for(int i = 0; i < 12; i++){
			grid = "|" + (char) (i + 'A') + "         |";
		}
		for(int i = 0; i < 20; i++){
			grid += "/n";
			if(i < 10){
				grid = i + "  ";
			}else{
				grid = i + " ";
			}
			for(int j = 0; j < 12; j++){
				grid = array[i][j].abbreviatedCellText();
			}
		}
		return grid;
	}
	
	public void clear(Location command){
		Cell location = getCell(command);
		location = new EmptyCell();
	}

}
