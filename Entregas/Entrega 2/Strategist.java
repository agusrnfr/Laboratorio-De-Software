package rojasGlorioso;

import robocode.JuniorRobot;

public class Strategist implements IStrategist {

	private final IStrategy snakeStrategy = this.new SnakeWithMachineGunStrategy();
	private final IStrategy turtleStrategy = this.new TurtleWithAHelmetStrategy();

	private Strategist() {
	}

	private static class instanceStrategist {
		private static final IStrategist INSTANCE = new Strategist();
	}

	public static IStrategist getInstace() {
		return instanceStrategist.INSTANCE;
	}

	public IStrategy getStrategyForOnRunning(JuniorRobot robot) {
		if (robot.energy < 50) {
			return snakeStrategy;
		} else {
			return turtleStrategy;
		}
	}

	public IStrategy getStrategyForOnScannedRobot(JuniorRobot robot) {
		if (robot.scannedDistance > (robot.fieldHeight * robot.fieldWidth / 1000)) {
			return snakeStrategy;
		} else {
			return turtleStrategy;
		}
	}

	public IStrategy getStrategyForOnHitByBullet(JuniorRobot robot) {
		if (robot.energy < 50) {
			return snakeStrategy;
		} else {
			return turtleStrategy;
		}
	}

	public IStrategy getStrategyForOnHitWall(JuniorRobot robot) {
		if (robot.energy < 50) {
			return snakeStrategy;
		} else {
			return turtleStrategy;
		}
	}

	public IStrategy getStrategyForOnHitRobot(JuniorRobot robot) {
		if (robot.energy < 50) {
			return snakeStrategy;
		} else {
			return turtleStrategy;
		}
	}

	private class SnakeWithMachineGunStrategy implements IStrategy {

		public void run(JuniorRobot robot) {
			robot.turnLeft(90);
			robot.ahead(100);
			robot.turnRight(90);
			robot.ahead(100);
		}

		public void onScannedRobot(JuniorRobot robot) {
			// Posición del Robot
			int posX = robot.robotX;
			int posY = robot.robotY;

			// Datos del robot escaneado
			int scannedDistance = robot.scannedDistance;
			int scannedAngle = robot.scannedAngle;
			int scannedHeading = robot.scannedHeading;
			int scannedVelocity = robot.scannedVelocity == 0 ? 1 : Math.abs(robot.scannedVelocity);

			// Cálculo de la posición del robot
			double enemyX = posX + scannedDistance * Math.sin(Math.toRadians(scannedAngle));
			double enemyY = posY + scannedDistance * Math.cos(Math.toRadians(scannedAngle));

			// Cálculo del tiempo
			double time = scannedDistance / (20 - 3);

			// Cálculo de la posible posición del enemigo
			double futureX = enemyX + Math.sin(Math.toRadians(scannedHeading)) * scannedVelocity * time;
			double futureY = enemyY + Math.cos(Math.toRadians(scannedHeading)) * scannedVelocity * time;

			// Ángulo a disparar
			int futureAngle = (int) Math.toDegrees(Math.atan2(futureX - posX, futureY - posY));

			robot.turnGunTo(futureAngle);
			robot.fire(2);
			robot.turnGunTo(scannedAngle);
		}

		public void onHitByBullet(JuniorRobot robot) {
			int angleBullet = robot.hitByBulletAngle;

			robot.turnTo((angleBullet + 180) % 360);
			robot.turnGunTo(angleBullet);
			robot.ahead(25);
		}

		public void onHitRobot(JuniorRobot robot) {
			int robotBearing = robot.hitRobotBearing;
			int robotAngle = robot.hitRobotAngle;

			robot.turnGunTo(robotAngle);
			robot.fire(3);
			if (robotBearing < 0) {
				robot.back(150);
				robot.turnRight(180);
			} else {
				robot.back(150);
				robot.turnLeft(180);
			}
		}

		public void onHitWall(JuniorRobot robot) {
			int wallBearing = robot.hitWallBearing;

			if (wallBearing < 0) {
				robot.back(50);
				robot.turnRight(180);
			} else {
				robot.back(50);
				robot.turnLeft(180);
			}
		}

	}

	private class TurtleWithAHelmetStrategy implements IStrategy {

		public void run(JuniorRobot robot) {
			robot.ahead(100);
			robot.turnGunTo((robot.gunHeading + 90) % 360);
		}

		public void onScannedRobot(JuniorRobot robot) {
			int scannedAngle = robot.scannedAngle;
			robot.turnGunTo(scannedAngle);
			robot.fire(2);
		}

		public void onHitByBullet(JuniorRobot robot) {
			int angleBullet = robot.hitByBulletAngle;

			robot.turnTo(angleBullet);
			robot.turnGunTo(angleBullet);
			robot.ahead(25);
			robot.fire(3);
		}

		public void onHitRobot(JuniorRobot robot) {
			int robotAngle = robot.hitRobotAngle;

			robot.turnGunTo(robotAngle);
			robot.fire(3);
			robot.back(15);
		}

		public void onHitWall(JuniorRobot robot) {
			int wallBearing = robot.hitWallBearing;

			if (wallBearing < 0) {
				robot.back(50);
				robot.turnRight(180);
			} else {
				robot.back(50);
				robot.turnLeft(180);
			}
		}

	}
}