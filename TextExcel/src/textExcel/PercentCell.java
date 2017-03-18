package textExcel;

public class PercentCell extends RealCell{
	
	private String percent;
	
	public PercentCell(String percent){
		this.percent = percent;
		setRealCell(percent);
	}
	
	public double getDoubleValue(){
		String returnVal = getRealCell();
		returnVal = returnVal.substring(0, returnVal.length() - 1);
		return Double.parseDouble(returnVal) / 100.0;
	}
	
	
}