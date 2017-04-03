//Brandon Nguyen, 2nd Period
package textExcel;

import java.util.Arrays;

public class FormulaCell extends RealCell{
	
	private String formula;
	private Cell[][] grid;

	public FormulaCell(String formula, Cell[][] spreadsheet) {
		// TODO Auto-generated constructor stub
		this.formula = formula;
		this.grid = spreadsheet;
		setRealCell(formula);
	}

	public double getDoubleValue(){
		String input = getRealCell().substring(2, getRealCell().length() - 2);
		input = input.trim();
		String[] formula = input.split(" ");
		if(formula.length == 1){
			return Double.parseDouble(formula[0]);
		}
		if((formula[0].toUpperCase().equals("AVG")) || (formula[0].toUpperCase().equals("SUM"))){
			
			String cell = formula[1].toUpperCase().substring(0, formula[1].indexOf('-'));
			String newCell = formula[1].toUpperCase().substring(0, formula[1].indexOf('-'));
			String ending = formula[1].toUpperCase().substring(formula[1].indexOf('-') + 1);

			if(formula[0].toUpperCase().equals("AVG")){
				double count = 0.0;

				int startRow = Integer.parseInt(cell.toUpperCase().substring(1));
				char startCol = (char)(cell.charAt(0));
				int endRow = Integer.parseInt(ending.toUpperCase().substring(1));
				char endCol = (char) (ending.charAt(0));
				
				for(char i = startCol; i <= endCol; i++ ){
					
					if(startCol != endCol){
						for(int j = startRow; j <= 20; j++){
							SpreadsheetLocation loc = new SpreadsheetLocation(i + "" + j);
							//System.out.println((int)i - 'A' + "" + j);
							if(grid[loc.getRow()][loc.getCol()] instanceof RealCell){
								count++;
							}
							//System.out.println("count" + count);
						}
						startRow = 1;
					}else{
						for(int j = startRow; j <= endRow; j++){
							SpreadsheetLocation loc = new SpreadsheetLocation(i + "" + j);
							if(grid[loc.getRow()][loc.getCol()] instanceof RealCell){
								count++;
							}
							//System.out.println("count" + count);
						}
					}
				}
				double save = sum(cell, newCell, ending) / count;
				System.out.println( "hallo :" + getRealCell() +"exit value avg " + save);
				return (sum(cell, newCell, ending)) / count;
			}else{
				double save = sum(cell, newCell, ending);
				System.out.println("hallo :" + getRealCell() +"exit value sum " + save);
				return (sum (cell, newCell, ending));
			}
		}else{
		
			double sum;
			
			if(formula[0].toUpperCase().charAt(0) >= 'A' && formula[0].toUpperCase().charAt(0) <='L'){
				formula[0] = formula[0].toUpperCase();
				//System.out.println(formula[i]);
				SpreadsheetLocation cell = new SpreadsheetLocation(formula[0]);
				if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
					sum = ((RealCell)grid[cell.getRow()][cell.getCol()]).getDoubleValue();
				}else{
					sum = 0.0;
				}
			}else{
				sum = Double.parseDouble(formula[0]);
			}

			for(int i = 1; i < formula.length - 1; i += 2 ){
				double num;
				
				if(formula[i + 1].toUpperCase().charAt(0) >= 'A' && formula[i + 1].toUpperCase().charAt(0) <='L'){
						formula[i + 1] = formula[i + 1].toUpperCase();
						//System.out.println(formula[i]);
						SpreadsheetLocation loc = new SpreadsheetLocation(formula[i + 1]);
						if(grid[loc.getRow()][loc.getCol()] instanceof RealCell){
							num = ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
						}else{
							num = 0.0;
						}
						//System.out.println(grid[cell.getRow()][cell.getCol()].abbreviatedCellText());
						

				}else{
					num = Double.parseDouble(formula[i + 1]);
				}
				
				
				if(formula[i].equals("*")){
					sum = sum * num;
				}else if(formula[i].equals("/")){
					sum = sum / num;
				}else if(formula[i].equals("+")){
					sum = sum + num;
				}else{
					sum = sum - num;
				}

				//System.out.println(" :( " + formula[i+2]);
				//System.out.println(" ahhh : " +storeVal);
			}

			return sum;
		}
	}
	
	public double sum(String cell, String newCell, String end){	
		
		SpreadsheetLocation loc = new SpreadsheetLocation(newCell);
		
		if(newCell.equals(end)){
			if(grid[loc.getRow()][loc.getCol()] instanceof RealCell){
				return ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
			}else{
				return 0.0;
			}
		}
		
		if(Character.toUpperCase(cell.charAt(0)) != Character.toUpperCase(end.charAt(0)) 
				&& Integer.parseInt(cell.substring(1)) == Integer.parseInt(end.substring(1))){
			newCell = ((char)(newCell.charAt(0) + 1)) + cell.substring(1);
			
		}else if( Character.toUpperCase(cell.charAt(0)) == Character.toUpperCase(end.charAt(0))
				&& Integer.parseInt(cell.substring(1)) <= Integer.parseInt(end.substring(1))){
			
			newCell = Character.toString(cell.charAt(0)) + (Integer.parseInt(newCell.substring(1)) + 1);
			
		}else{
			if(Integer.parseInt(newCell.substring(1)) < Integer.parseInt(end.substring(1))){
				
				newCell = Character.toString(newCell.charAt(0)) + (Integer.parseInt(newCell.substring(1)) + 1);

				
			}else if(Integer.parseInt(newCell.substring(1)) == Integer.parseInt(end.substring(1))){
				
				newCell = ((char)(newCell.charAt(0) + 1)) + "" + 1;
				
			}else{
				newCell = ((char)(newCell.charAt(0) + 1)) + "" + cell.substring(1);
				
			}
		}

		double first;
		if(grid[loc.getRow()][loc.getCol()] instanceof RealCell){
			 first = ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
			return (first + sum(cell, newCell, end));
		}else{
			return sum(cell, newCell, end);
		}
	}

}
