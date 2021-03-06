package eurobocode;
import robocode.*;
import java.util.Random;
//import java.awt.Color;

import java.awt.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * RandomTank - a robot by (your name here)
 */
public class EurobocodeRandom extends AdvancedRobot
{
	/**
	 * run: RandomTank's default behavior
	 */
	double velocity, velocity2;
	int randomizer;
	boolean stop;

	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		stop = false;
		velocity = 15;
		velocity2 = 5;
		randomizer = 0;

		// Set colors
		setBodyColor(new Color(0, 0, 0));
		setGunColor(new Color(0, 0, 0));
		setRadarColor(new Color(0, 0, 0));
		setBulletColor(new Color(0, 0, 0));
		setScanColor(new Color(0, 0, 0));



		// Robot main loop
		while(true) {
			switch (randomizer){
				case 0:
						setAhead(velocity);
						setTurnRight(velocity);
						setTurnGunRight(velocity2);
						if(stop)
							break;
						execute();
						break;
				case 1:
						setAhead(velocity);
						setTurnLeft(velocity);
						setTurnGunLeft(velocity2);
						if(stop)
							break;
						execute();
						break;
				case 2:
						setAhead(velocity);
						setTurnGunRight(velocity2);
						if(stop)
							break;
						execute();
						break;
				default:
						randomizer = 0;
						stop = false;
						break;
			}
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if(!(e.getName().contains("Eurobocode")))
			fire(100);
		stop = true;
		randomizer = 3;
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		switch (randomizer){
			case 0:
				randomizer = 1;
				break;
			case 1:
				randomizer = 2;
				break;
			default:
				randomizer = 0;
				break;
		}
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		back(50);
		switch (randomizer){
			case 0:
				randomizer = 1;
				break;
			case 1:
				randomizer = 2;
				break;
			default:
				randomizer = 0;
				break;
		}
	}

	public void onHitRobot(HitRobotEvent e) {
		if(!(e.getName().contains("Eurobocode")))
			fire(1000);
	}
}
