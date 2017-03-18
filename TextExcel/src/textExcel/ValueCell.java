package textExcel;

public class ValueCell extends RealCell{
	
	private String value;
	
	public ValueCell(String num){
		this.value = num;
		setRealCell(num);

	}
	
	public double getDoubleValue(){
		System.out.println(Double.parseDouble(getRealCell()));
		return Double.parseDouble(getRealCell());
	}

}
