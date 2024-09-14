package rojasGlorioso;

import robocode.JuniorRobot;

public class ElectricSheep extends JuniorRobot {
	private Strategy strategy;

	public ElectricSheep() {
		this.strategy = new SnakeWithMachineGunStrategy();
	}

	public Strategy getStrategy() {
		return this.strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public void run() {
		setColors(white, black, red, gray, red);
		this.getStrategy().run(this);
	}

	@Override
	public void onScannedRobot() {
		this.getStrategy().onScannedRobot(this);
	}

	@Override
	public void onHitByBullet() {
		this.getStrategy().onHitByBullet(this);
	}

	@Override
	public void onHitRobot() {
		this.getStrategy().onHitRobot(this);
	}

	@Override
	public void onHitWall() {
		this.getStrategy().onHitWall(this);
	}

}