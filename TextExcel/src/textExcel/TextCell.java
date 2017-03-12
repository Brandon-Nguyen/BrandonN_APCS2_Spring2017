package textExcel;

public class TextCell implements Cell {
	
	private String value;

	public TextCell(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public String padToTen(){
		String returnVal = "";
		if(value.contains("\"") == true){
			returnVal = value.substring(1, value.length() - 1);
		}
		//System.out.println(returnVal);
		if(returnVal.length() == 0){
			returnVal += " ";
		}
		if(returnVal.length() > 10){
			returnVal = returnVal.substring(0, 10);
			//System.out.println(returnVal);
			return returnVal;
		}else{
			while(returnVal.length() != 10){
				returnVal += " ";
				//System.out.println(returnVal);

			}
			return returnVal;
		}
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return padToTen();
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}

}
