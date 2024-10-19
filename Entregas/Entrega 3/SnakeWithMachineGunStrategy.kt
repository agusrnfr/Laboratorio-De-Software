package rojasGlorioso

import robocode.*
import kotlin.math.*

class SnakeWithMachineGunStrategy : Strategy {

    override fun run(robot: JuniorRobot) {
        while (true) {
            robot.turnLeft(90)
            robot.turnGunRight(360)
            robot.ahead(100)
            robot.turnRight(90)
            robot.turnGunRight(360)
            robot.ahead(100)
        }
    }

    override fun onScannedRobot(robot: JuniorRobot) {
        val scannedDistance = robot.scannedDistance
        val posX = robot.robotX
        val posY = robot.robotY

        val scannedAngle = robot.scannedAngle
        val scannedHeading = robot.scannedHeading
        val scannedVelocity = robot.scannedVelocity

        val enemyX = posX + scannedDistance * sin(Math.toRadians(scannedAngle.toDouble()))
        val enemyY = posY + scannedDistance * cos(Math.toRadians(scannedAngle.toDouble()))

        val power : Double = if (scannedDistance < 100) 3.0 else 2.0

        val time = scannedDistance / (20 - 3 * power)

        val futureX = enemyX + sin(Math.toRadians(scannedHeading.toDouble())) * scannedVelocity * time
        val futureY = enemyY + cos(Math.toRadians(scannedHeading.toDouble())) * scannedVelocity * time

        val angleToTarget = Math.toDegrees(atan2(futureX - posX, futureY - posY))

        robot.turnGunTo(angleToTarget.toInt())
        robot.fire(power)

        robot.turnGunTo(scannedAngle)

    }

    override fun onHitByBullet(robot: JuniorRobot) {
        val angleBullet = robot.hitByBulletAngle

        robot.turnTo(angleBullet)
        robot.turnGunTo(angleBullet)
    }

    override fun onHitRobot(robot: JuniorRobot) {
        val robotBearing = robot.hitRobotBearing
        val robotAngle = robot.hitRobotAngle

        robot.turnGunTo(robotAngle)
        robot.fire(3.0)
        if (robotBearing < 0) {
            robot.back(150)
            robot.turnRight(180)
        } else {
            robot.back(150)
            robot.turnLeft(180)
        }
    }

    override fun onHitWall(robot: JuniorRobot) {
        val wallBearing = robot.hitWallBearing

        if (wallBearing < 0) {
            robot.back(50)
            robot.turnRight(180)
        } else {
            robot.back(50)
            robot.turnLeft(180)
        }
    }
}