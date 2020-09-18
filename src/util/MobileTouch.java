package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MobileTouch {
	// scroll from different coordinates
	// scroll from different elements
	
	public static final double TOP_MARGIN=.20;
	public static final double BOTTOM_MARGIN=.90;
	public static final double LEFT_MARGIN=.05;
	public static final double RIGHT_MARGIN=.95;
	public static final String DIRECTION_TOP="top";
	public static final String DIRECTION_BOTTOM="bottom";
	public static final String DIRECTION_RIGHT="right";
	public static final String DIRECTION_LEFT="left";
	public static final int SCROLL_DURATION=3;
	public static final int MAX_SCROLL_COUNTER = 50;
	
	
	
	AndroidDriver<AndroidElement> driver;
	Dimension dim;
	DeviceUtil device;
	TouchAction act;


	
	public MobileTouch(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		dim = driver.manage().window().getSize();
		device = new DeviceUtil(driver);
		act = new TouchAction(driver);
	}
	
	public void scrollToText(String text, String direction) {
	scrollToVisibleElementOnScreen("new UiSelector().descriptionContains(\""+text+"\")", "androidUIAutomatior",direction);
		
		
	}
	
	// viable to make
	public void scrollToVisibleElementOnScreen(String locator,String locatorStrat, String direction) {
		int counter =0;
		while(!device.isElementPresent(locator, locatorStrat)) {
			if(direction.equals(DIRECTION_TOP)) {
				int startY = getEndPointOfScreen(DIRECTION_BOTTOM);
				int endY = getEndPointOfScreen(DIRECTION_TOP);
				verticalScroll(startY, endY);
				// stable operation
			} else if(direction.equals(DIRECTION_BOTTOM)) {
				
			}else if(direction.equals(DIRECTION_RIGHT)) {
				
			}else if(direction.equals(DIRECTION_LEFT)) {
				
			}
			if(counter == MAX_SCROLL_COUNTER) {
				// report error
				break;
			}
		}
		scrollTowards(locator, locatorStrat,direction);

		// do the adjustment
		
	}
	// assume that element is found and visible
	public void scrollTowards(String locator,String locatorStrat,String direction) {
		if(direction.equals(DIRECTION_TOP)) {
			int topY=getEndPointOfScreen(DIRECTION_TOP); 
			
			AndroidElement e = null;
			
				if(locatorStrat.equals("id"))
					e = driver.findElement(By.id(locator));
				else if(locatorStrat.equals("xpath"))
					e = driver.findElement(By.xpath(locator));
				else if(locatorStrat.equals("androidUIAutomatior"))
					e = driver.findElement(MobileBy.AndroidUIAutomator(locator));
				
				
			verticalScroll(e.getLocation().y, topY);
		}
		
	}
	
	
	
	
	
	
	
	public int getCenterXofElement(AndroidElement e) {
		return e.getLocation().x + (e.getSize().width/2);
	}
	
	public int getCenterYofElement(AndroidElement e) {
		return e.getLocation().y + (e.getSize().height/2);
	}
	
	public int getEndPointOfScreen(String direction) {
		int height = dim.height;
		int width = dim.width;
		
		if(direction.equals(DIRECTION_TOP)) {
			return (int)(height*TOP_MARGIN);
		}else if(direction.equals(DIRECTION_BOTTOM)) {
			return (int)(height*BOTTOM_MARGIN);
		}else if(direction.equals(DIRECTION_RIGHT)) {
			return (int)(width*RIGHT_MARGIN);
		}else if(direction.equals(DIRECTION_LEFT)) {
			return (int)(width*LEFT_MARGIN);
		}
	
		return -1;
	
	}
	
	public void horizontalScroll(int startX, int endX) {
		int middleY = dim.height/2;
		
		act
		.press(PointOption.point(startX,middleY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(SCROLL_DURATION)))
		.moveTo(PointOption.point(endX,middleY))
		.release()
		.perform();

	}
	
    public void verticalScroll(int startY, int endY) {
    	
		int middleX = dim.width/2;
		act
		.press(PointOption.point(middleX,startY))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(SCROLL_DURATION)))
		.moveTo(PointOption.point(middleX,endY))
		.release()
		.perform();

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
