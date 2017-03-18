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
		double holder = Double.parseDouble(returnVal) / 100.0;
		returnVal = Double.toString(holder).substring(0, 10);
		return Double.parseDouble(returnVal);
	}
	
	
}