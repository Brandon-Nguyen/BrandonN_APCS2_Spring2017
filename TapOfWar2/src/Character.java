
public class Character {
	private String character;
	
	public Character(String character){
		this.character = character;
	}
	
	public String getCharacter(){
		return character;
	}
	
	public int getEnergy(){
		int random = (int)(Math.random() * 100); 
		if(character.equals("small man")){
			if(random > 30){
				return getPullStrength();
			}else{
				return (int)(getPullStrength() / 2);
			}
		}else if(character.equals("big man")){
			if(random > 70){
				return getPullStrength();
			}else{
				return (int)(getPullStrength() / 2);
			}
		}
		return 0;
	}
	
	public int getPullStrength(){
		if(character.equals("small man")){
			return 10;
		}else if(character.equals("big man")){
			return 20;
		}
		return 0;
	}
}
