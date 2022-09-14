package practical13;

public class Player {
	private int score;
	private int playCount;
	private int currentNumber;
	private int nextNumber;
	private int bonus;
	
	public Player() {
		this.score = 0;
		this.playCount = 10;
		this.bonus = 0;
	}
	
	// set
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setScore(int score, int addScore) {
		this.score = score + addScore;
	}
	
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	
	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}
	
	public void setNextNumber(int nextNumber) {
		this.nextNumber = nextNumber;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	// get
	public int getScore() {
		return this.score;
	}
	
	public int getPlayCount() {
		return this.playCount;
	}
	
	public int getCurrentNumber() {
		return this.currentNumber;
	}
	
	public int getNextNumber() {
		return this.nextNumber;
	}
	
	public int getBonus() {
		return this.bonus;
	}

}
