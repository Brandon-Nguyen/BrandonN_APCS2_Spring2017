package textExcel;

abstract class RealCell implements Cell {
	
	private String cellContent;
	
	public String getRealCell(){
		return cellContent;
	}
	public void setRealCell(String value){
		cellContent = value;
		
	}
	
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return padAndTruncate();
	}

	public String fullCellText() {
		// TODO Auto-generated method stub
		String returnVal = cellContent;
		double holder = 0.0;
		if(returnVal.contains("%")){
			returnVal = returnVal.substring(0, returnVal.length() - 1);
			holder = Double.parseDouble(returnVal);
			holder = holder / 100.0;
		}else{
			holder = Double.parseDouble(returnVal);
		}
		returnVal = Double.toString(holder);
		return returnVal;
	}
	
	public String padAndTruncate(){
		String returnVal = cellContent;
		if(returnVal.contains("%")){
			returnVal = returnVal.substring(0, returnVal.indexOf("."));
			returnVal += "%";
		}
		System.out.println(returnVal);

		if(returnVal.contains(".") == false && returnVal.contains("%") == false){
			returnVal += ".0";
		}

		if(returnVal.length() >= 10){
			returnVal = cellContent.substring(0, 10);

		}else{
			while(returnVal.length() != 10){
				returnVal += " ";

			}

		}

		return returnVal;
	}
	
	abstract double getDoubleValue();

}
