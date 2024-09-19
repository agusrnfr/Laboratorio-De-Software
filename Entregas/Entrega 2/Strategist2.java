package rojasGlorioso;

import robocode.JuniorRobot;

public class Strategist2 implements IStrategist {

	private final IStrategy fatLionStrategy = this.new FatLionStrategy();
	private final IStrategy flyingEagleStrategy = this.new FlyingEagleStrategy();

	private Strategist2() {
	}

	private static class instanceStrategist {
		private static final IStrategist INSTANCE = new Strategist2();
	}

	public static IStrategist getInstace() {
		return instanceStrategist.INSTANCE;
	}

	public IStrategy getStrategyForOnRunning(JuniorRobot robot) {
		if (robot.energy < 50) {
			return fatLionStrategy;
		} else {
			return flyingEagleStrategy;
		}
	}

	public IStrategy getStrategyForOnScannedRobot(JuniorRobot robot) {
		if (robot.scannedDistance > (robot.fieldHeight * robot.fieldWidth / 1000)) {
			return fatLionStrategy;
		} else {
			return flyingEagleStrategy;
		}
	}

	public IStrategy getStrategyForOnHitByBullet(JuniorRobot robot) {
		if (robot.energy < 50) {
			return fatLionStrategy;
		} else {
			return flyingEagleStrategy;
		}
	}

	public IStrategy getStrategyForOnHitWall(JuniorRobot robot) {
		if (robot.energy < 50) {
			return fatLionStrategy;
		} else {
			return flyingEagleStrategy;
		}
	}

	public IStrategy getStrategyForOnHitRobot(JuniorRobot robot) {
		if (robot.energy < 50) {
			return fatLionStrategy;
		} else {
			return flyingEagleStrategy;
		}
	}

	private class FatLionStrategy implements IStrategy {

		public void run(JuniorRobot robot) {
			robot.turnRight(45);
			robot.ahead(50);
			robot.turnGunTo((robot.gunHeading + 180) % 360);
			robot.fire(2);
		}

		public void onScannedRobot(JuniorRobot robot) {
			int scannedAngle = robot.scannedAngle;
			robot.turnGunTo(scannedAngle);
			robot.fire(3);
		}

		public void onHitByBullet(JuniorRobot robot) {
			robot.turnRight(90);
			robot.back(100);
			robot.fire(2);
		}

		public void onHitRobot(JuniorRobot robot) {
			int robotAngle = robot.hitRobotAngle;
			robot.turnGunTo(robotAngle);
			robot.fire(3);
			robot.back(150);
		}

		public void onHitWall(JuniorRobot robot) {
			robot.turnRight(180);
			robot.ahead(50);
		}
	}

	private class FlyingEagleStrategy implements IStrategy {

		public void run(JuniorRobot robot) {
			robot.ahead(200);
			robot.turnGunTo((robot.gunHeading + 90) % 360);
		}

		public void onScannedRobot(JuniorRobot robot) {
			int scannedAngle = robot.scannedAngle;
			robot.turnGunTo(scannedAngle);
			robot.fire(1);
			robot.ahead(100);
		}

		public void onHitByBullet(JuniorRobot robot) {
			int angleBullet = robot.hitByBulletAngle;
			robot.turnTo(angleBullet + 90);
			robot.ahead(150);
		}

		public void onHitRobot(JuniorRobot robot) {
			int robotAngle = robot.hitRobotAngle;
			robot.turnGunTo(robotAngle);
			robot.fire(2);
			robot.ahead(100);
		}

		public void onHitWall(JuniorRobot robot) {
			robot.turnLeft(90);
			robot.ahead(200);
		}
	}
}