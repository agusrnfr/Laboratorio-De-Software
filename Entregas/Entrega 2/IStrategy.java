package rojasGlorioso;

import robocode.JuniorRobot;

public interface IStrategy {

	void run(JuniorRobot robot);

	void onScannedRobot(JuniorRobot robot);

	void onHitByBullet(JuniorRobot robot);

	void onHitRobot(JuniorRobot robot);

	void onHitWall(JuniorRobot robot);

}
