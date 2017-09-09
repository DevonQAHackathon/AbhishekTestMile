package dir.ui.ghost.tests.pages;

import arjunasdk.audit.HardCoded;
import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.interfaces.UiDriver;
import arjunasdk.uiauto.pageobject.BasePage;
import dir.ui.ghost.tests.enums.GhostPageElements;

public class GhostPost extends BasePage {

	public GhostPost(UiDriver driver) throws Exception {
		super(driver);
		populate("/ghost/PostPage.ini");
	}

	public void createPost(String postTitle, String postDesc) throws Exception {
		RunConfig.logger().debug("Creating post from Post page");
		RunConfig.logger().debug("dir.ui.gost.tests.pages.GostPost.createPost(String, String)");
		RunConfig.logger().debug("Clicked on Post Title");
		element(GhostPageElements.POST_TITLE.toString()).identify().click();
		RunConfig.logger().debug("Entered text in the Post Title field");
		element(GhostPageElements.POST_TITLE.toString()).identify().enterText(postTitle);
		RunConfig.logger().debug("Clicked on the post description");
		element(GhostPageElements.POST_DESC.toString()).identify().click();
		RunConfig.logger().debug("Enter description to the post");
		element(GhostPageElements.POST_DESC.toString()).identify().enterText(postDesc);
		RunConfig.logger().debug("Clicking on the DropDown icon");
		element(GhostPageElements.PUBLISH_BUTTON.toString()).identify().click();
		RunConfig.logger().debug("Clicking on publish");
		element(GhostPageElements.PUBLISH.toString()).identify().click();
		element(GhostPageElements.PUBLISH_NOW.toString()).click();
		HardCoded.sleep("Waiting for publish", 5);
	}

	public GhostDialog deletePost() throws Exception {
		RunConfig.logger().debug("Deleting post from post page");
		RunConfig.logger().debug("dir.ui.gost.tests.pages.GostPost.deletePost()");
		RunConfig.logger().debug("Clicking on the DropDown icon");
		element(GhostPageElements.PUBLISH_BUTTON.toString()).click();
		RunConfig.logger().debug("Clicking on delete");
		element(GhostPageElements.DELETE.toString()).click();
		return new GhostDialog(getUiDriver());
	}

}
