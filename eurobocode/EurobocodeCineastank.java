package eurobocode;
import robocode.*;

import java.awt.*;

public class EurobocodeCineastank extends AdvancedRobot
{
	int estrategia;

	public void run() {

		this.estrategia = (int) (Math.random() * 3);

		// Set colors
		setBodyColor(new Color(0, 0, 0));
		setGunColor(new Color(0, 0, 0));
		setRadarColor(new Color(0, 0, 0));
		setBulletColor(new Color(0, 0, 0));
		setScanColor(new Color(0, 0, 0));



		while(true) {
			switch (estrategia) {
				case 0:
					setAhead(100);
					setTurnGunRight(90);
					setTurnRight(90);
					break;
				case 1:
					setTurnGunLeft(90);
					ahead(100);
					turnLeft(90);
					break;
				case 2:
					setTurnGunRight(45);
					ahead(200);
					turnRight(45);
					break;
				default:
					setAhead(200);
					setTurnGunLeft(45);
					setTurnLeft(45);
			}
			execute();
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if(!(e.getName().contains("Eurobocode")))
			fire(3);
	}

	public void onHitByBullet(HitByBulletEvent e) {
		this.estrategia = (int) (Math.random() * 3);
		turnRight(45);
		back(100);
	}

	public void onHitWall(HitWallEvent e) {
		this.estrategia = (int) (Math.random() * 3);
		turnRight(45);
		back(100);
	}
}
