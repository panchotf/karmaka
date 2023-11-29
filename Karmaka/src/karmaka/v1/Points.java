package karmaka.v1;

public enum Points {
	Un(1), Deux(2), Trois(3);
	
	private int points;
	
	Points(int points){
		this.points = points;
	}
	
	public int getpoints() {
		return points;
	}
}
