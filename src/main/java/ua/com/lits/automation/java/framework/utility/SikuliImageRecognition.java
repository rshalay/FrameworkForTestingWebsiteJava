package ua.com.lits.automation.java.framework.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

public class SikuliImageRecognition {

	private ScreenRegion sRegion;

	public SikuliImageRecognition() {
		sRegion = new DesktopScreenRegion();
	}

	public void clickOnImage(String imageName) {
		File buttonPathFile = new File("src\\test\\resources\\images\\" + imageName);
		Target imageTarget = new ImageTarget(buttonPathFile);
		imageTarget.setMinScore(0.7);
		ScreenRegion r = sRegion.wait(imageTarget, 7000);
		Mouse mouse = new DesktopMouse();
		mouse.click(r.getCenter());
		Robot robot;
		try {
			robot = new Robot();
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
