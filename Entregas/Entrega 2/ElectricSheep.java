package rojasGlorioso;

import robocode.JuniorRobot;

public class ElectricSheep extends JuniorRobot {
	private IStrategist strategist = Strategist.getInstace(); // default Strategist

	public void setStrategist(Strategist strategist) {
		this.strategist = strategist;
	}

	@Override
	public void run() {
		setColors(white, black, red, gray, red);
		this.strategist.getStrategyForOnRunning(this).run(this);
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	@Override
	public void onScannedRobot() {
		this.strategist.getStrategyForOnScannedRobot(this).onScannedRobot(this);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	@Override
	public void onHitByBullet() {
		this.strategist.getStrategyForOnHitByBullet(this).onHitByBullet(this);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	@Override
	public void onHitWall() {
		this.strategist.getStrategyForOnHitWall(this).onHitWall(this);
	}

	/**
	 * onHiRobot: What to do when you hit a robot
	 */
	@Override
	public void onHitRobot() {
		this.strategist.getStrategyForOnHitRobot(this).onHitWall(this);
	}

}