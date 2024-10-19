package rojasGlorioso

import robocode.JuniorRobot

interface Strategy {
    fun run(robot: JuniorRobot)
    fun onScannedRobot(robot: JuniorRobot)
    fun onHitByBullet(robot: JuniorRobot)
    fun onHitRobot(robot: JuniorRobot)
    fun onHitWall(robot: JuniorRobot)
}