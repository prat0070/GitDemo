package DemoMavenProject;

import org.testng.annotations.Test;

public class SeleniumTest {

	@Test
	public void BrowserAutomation() {
		System.out.println("Selenium: FireFox Browser Automation");
		System.out.println("Selenium: Chrome Browser Automation");
	}

	@Test
	public void UIAutomation() {
		System.out.println("Selenium: UIAutomation");
	}
	@Test
	public void UIAutomationMobile() {
		System.out.println("Selenium: UIAutomationMobile");
	}
}