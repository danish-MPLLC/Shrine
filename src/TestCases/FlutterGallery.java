package TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.Base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import util.MobileTouch;

public class FlutterGallery extends Base{
	
	@Test
	public void TestA() throws InterruptedException{
		startUp("RZ8M32HFY4N");
		wait(3);
		
		AndroidElement e=  dr.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Shrine\")"));
				e.click();
				
				wait(3);
				e=  dr.findElement(MobileBy.AndroidUIAutomator("new UiSelector().description(\"NEXT\")"));
				e.click();
				
				wait(3);
				e=  dr.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Open\")"));
				e.click();
				
				wait(3);
				e=  dr.findElement(MobileBy.AndroidUIAutomator("new UiSelector().description(\"CLOTHING\")"));
				e.click();
				
				wait(5);
//				e=  dr.findElement(MobileBy.AndroidUIAutomator("new UiSelector().descriptionContains(\"Walter\")"));
//				e.click();
				
				MobileTouch mobGes = new MobileTouch(dr);
				mobGes.scrollToText("Walter henley (white) $38, Add to cart",MobileTouch.DIRECTION_RIGHT);

	}

}
