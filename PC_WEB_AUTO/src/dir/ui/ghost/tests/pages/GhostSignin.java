package dir.ui.ghost.tests.pages;

import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.interfaces.UiDriver;
import arjunasdk.uiauto.pageobject.BasePage;
import dir.ui.ghost.tests.enums.GhostPageElements;

public class GhostSignin extends BasePage {

	public GhostSignin(UiDriver driver) throws Exception {
		super(driver);
		populate("/ghost/Login.ini");
	}

	public GhostDashBoard signIn(String email, String password) throws Exception {
		RunConfig.logger().info("Signin to Gost");
		RunConfig.logger().debug("dir.ui.gost.tests.pages.GostSignin.signIn(String, String)");
		goTo("http://iamchandramouli.com/login");
		RunConfig.logger().debug("Entering Email ID");
		element(GhostPageElements.EMAIL.toString()).identify().enterText(email);
		RunConfig.logger().info("Entered Email ID");
		RunConfig.logger().debug("Entering user password");
		element(GhostPageElements.PASSWORD.toString()).identify().enterText(password);
		RunConfig.logger().info("Entered user password");
		RunConfig.logger().debug("Clicking on Submit");
		element(GhostPageElements.SUBMIT.toString()).identify().click();
		RunConfig.logger().info("Clicked on Submit");
		return new GhostDashBoard(getUiDriver());
	}
}
