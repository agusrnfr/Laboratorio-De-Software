package rojasGlorioso

import robocode.*

class ElectricSheep : JuniorRobot() {
    private var strategy: Strategy = SnakeWithMachineGunStrategy()

    fun getStrategy(): Strategy {
        return this.strategy
    }

    fun setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    override fun run() {
        setColors(white, black, red, gray, red)
        this.getStrategy().run(this)
    }

    override fun onScannedRobot() {
        this.getStrategy().onScannedRobot(this)
    }

    override fun onHitByBullet() {
        this.getStrategy().onHitByBullet(this)
    }

    override fun onHitRobot() {
        this.getStrategy().onHitRobot(this)
    }

    override fun onHitWall() {
        this.getStrategy().onHitWall(this)
    }
}