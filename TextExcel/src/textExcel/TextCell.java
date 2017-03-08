package textExcel;

public class TextCell implements Cell {
	
	private String value;

	public TextCell(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public String padToTen(){
		if(value.length() > 10){
			return value.substring(0, 10);
		}else{
			for(int i = 0; i < 10 - value.length(); i++){
				value += " ";
			}
			return value;
		}
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return "|" + padToTen() + "|";
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}

}
