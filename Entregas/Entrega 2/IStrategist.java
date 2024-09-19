package rojasGlorioso;

import robocode.JuniorRobot;

public interface IStrategist {
	IStrategy getStrategyForOnRunning(JuniorRobot robot);

	IStrategy getStrategyForOnScannedRobot(JuniorRobot robot);

	IStrategy getStrategyForOnHitByBullet(JuniorRobot robot);

	IStrategy getStrategyForOnHitWall(JuniorRobot robot);

	IStrategy getStrategyForOnHitRobot(JuniorRobot robot);
}
