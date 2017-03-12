package textExcel;

public class TextCell implements Cell {
	
	private String value;

	public TextCell(String value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}
	public void padToTen(){
		if(value.contains("\"") == true){
			value = value.substring(1, value.length() - 1);
		}
		System.out.println(x);
		
		if(value.length() > 10){
			value = value.substring(0, 10);
		}else{
			for(int i = 0; i <= 14 - value.length() - 1; i++){
				value += " ";
			}
		}
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		padToTen();
		return value;
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}

}
