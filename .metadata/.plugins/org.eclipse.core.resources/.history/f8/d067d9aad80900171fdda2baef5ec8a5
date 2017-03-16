package textExcel;

abstract class RealCell implements Cell {
	
	private String cellContent;
	
	public RealCell(String value) {
		// TODO Auto-generated constructor stub
		cellContent = value;
	}

	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		String returnVal = cellContent;
		if(returnVal.length() >= 10){
			returnVal = cellContent.substring(0, 10);
		}else{
			returnVal += " ";
		}
		
		return returnVal;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return cellContent;
	}
	
	abstract double getDoubleValue();

}
