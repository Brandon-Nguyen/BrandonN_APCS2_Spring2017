package textExcel;

public class PercentCell extends ValueCell{
	
	private String percent;
	
	public PercentCell(String percent) {
		// TODO Auto-generated constructor stub
		this.percent = percent;
	}

	public double getDoubleValue(){
		String returnVal = percent.substring(0, percent.length() - 2);
		return Integer.parseInt(returnVal);
	}
}
