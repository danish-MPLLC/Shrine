package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class Base {
	
	public AndroidDriver<AndroidElement> dr;

	

	public String appPackageName="io.flutter.demo.gallery";
	public String appActivity="io.flutter.demo.gallery.MainActivity";
	
	public void startUp(String androidPhone_UDID) throws InterruptedException
	{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.DEVICE_NAME,androidPhone_UDID);
	cap.setCapability(MobileCapabilityType.UDID, androidPhone_UDID);
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, 10);
	//cap.setCapability(MobileCapabilityType.APP, new File(apkPath).getAbsolutePath());
	cap.setCapability("appPackage", appPackageName);
	cap.setCapability("appActivity", appActivity);
	cap.setCapability(MobileCapabilityType.NO_RESET, "true");
	cap.setCapability(MobileCapabilityType.FULL_RESET, "false");
	 try {
		dr= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(7000);
		//dr.quit();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	}
	

	public void wait(int waitTimeInSec) {
		try {
			Thread.sleep(waitTimeInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
