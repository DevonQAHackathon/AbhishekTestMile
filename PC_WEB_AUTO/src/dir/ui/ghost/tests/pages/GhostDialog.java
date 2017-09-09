package dir.ui.ghost.tests.pages;

import arjunasdk.audit.HardCoded;
import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.interfaces.UiDriver;
import arjunasdk.uiauto.pageobject.BasePage;
import dir.ui.ghost.tests.enums.GhostPageElements;

public class GhostDialog extends BasePage {

	public GhostDialog(UiDriver driver) throws Exception {
		super(driver);
		populate("/ghost/Dialog.ini");
	}

	public GhostDashBoard delete() throws Exception {
		RunConfig.logger().debug("Deletion Dialog");
		RunConfig.logger().debug("dir.ui.gost.tests.pages.GostDialog.delete()");
		RunConfig.logger().debug("Waiting for the presence on delete dialog");
		element(GhostPageElements.DELETE.toString()).waitForPresence();
		RunConfig.logger().debug("Clicking on delete button");
		element(GhostPageElements.DELETE_BUTTON.toString()).click();
		HardCoded.sleep("Waiting for post to be deleted", 3);
		return new GhostDashBoard(getUiDriver());
	}

}
