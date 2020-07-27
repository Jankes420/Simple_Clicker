
public class Score {
	private int liczbaPunktow;
	private int kredyty;
	private double upgradeCount=0;
	private double upgradeCountPerSecond=0;
	private double upgradeCost=50;
	private double upgradeCostPerSecond=200;
	private double bonus;
	private int bonusPerSecond=0;
	Score(){
		
	}
	
	void dodajPunkt() {
		this.liczbaPunktow+=1+this.bonus;
		this.kredyty+=1+this.bonus;
	}
	
	int podajWynik() {
		return liczbaPunktow;
	}
	
	int podajKredyty() {
		return kredyty;
	}
	
	void ulepszenie() {
		if (this.podajKredyty()>=this.upgradeCount*2+this.upgradeCost) {
			this.bonus+=1+upgradeCount*0.6;
			this.kredyty-=this.upgradeCount*0.2+this.upgradeCost;
			this.upgradeCount+=1;
			this.upgradeCost+=Math.pow(this.upgradeCount, 3);
		}
	}
	
	void ulepszeniePerSekunda() {
		if (this.podajKredyty()>=this.upgradeCountPerSecond*2+this.upgradeCostPerSecond) {
			this.bonusPerSecond+=1;
			this.kredyty-=this.upgradeCountPerSecond*0.2+this.upgradeCostPerSecond;
			this.upgradeCountPerSecond+=1;
			this.upgradeCostPerSecond+=Math.pow(this.upgradeCountPerSecond, 4);
		}
	}
	
	double podajKosztUlepszenia() {
		return upgradeCost;
	}
	
	void dodajPunktPerSekunda() {
		this.liczbaPunktow+=this.bonusPerSecond;
		this.kredyty+=this.bonusPerSecond;
	}
	
	double ulepszeniePoziom() {
		return this.upgradeCount;
	}
	double ulepszeniePoziomPerSekunda() {
		return this.upgradeCountPerSecond;
	}
	double podajKosztUlepszeniaNaSekunde() {
		return this.upgradeCostPerSecond;
	}

}
