package DemoMavenProject;

import org.testng.annotations.Test;

public class AppiumTest {

	@Test
	public void nativeAppAndroid()
	{
		System.out.println("Appium : Native App");
	}
	@Test
	public void iosApp()
	{
		System.out.println("Appium:IOS App");
	}
	@Test
	public void nativePlayStore()
	{
		System.out.println("Appium Play Store: Native App");
	}
}
