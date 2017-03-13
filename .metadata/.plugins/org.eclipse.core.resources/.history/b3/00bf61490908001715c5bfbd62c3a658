package textExcel;

//Update this file with your own code.

public class SpreadsheetLocationCheckpoint1 implements Location
{
	int row;
	int col;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row - 1;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return col;
    }
    
    public SpreadsheetLocationCheckpoint1(String cellName)
    {
        // TODO: Fill this out with your own code
    	col = cellName.charAt(0) - 'A';
    	row = Integer.parseInt(cellName.substring(1));
    }
}