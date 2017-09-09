package dir.ui.ghost.tests.pages;

import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.factories.UiDriverFactory;
import arjunasdk.uiauto.interfaces.UiDriver;

public class Tool {

	UiDriver uiDriver;

	public Tool(UiDriver driver) {
		uiDriver = driver;
	}

	public GhostSignin startBrowser() throws Exception {
		RunConfig.logger().info("*************** Stating Browser : ***************");
		RunConfig.logger().debug("Creation of uiDriver object");
		uiDriver = UiDriverFactory.getSelenium();
		RunConfig.logger().info("Creation of UI Driver object is successful (" + uiDriver + ")");
		return new GhostSignin(uiDriver);
	}

	public void closeBrowser() throws Exception {
		RunConfig.logger().info("*************** Closing Browser : ***************");
		RunConfig.logger().info("dir.ui.gost.tests.pages.Tool.closeBrowser()");
		uiDriver.close();
	}

}
