package dir.ui.ghost.tests.pages;

import java.util.List;

import arjunasdk.config.RunConfig;
import arjunasdk.uiauto.interfaces.UiDriver;
import arjunasdk.uiauto.interfaces.UiElement;
import arjunasdk.uiauto.pageobject.BasePage;
import dir.ui.ghost.tests.enums.GhostPageElements;

public class GhostDashBoard extends BasePage {

	public GhostDashBoard(UiDriver driver) throws Exception {
		super(driver);
		populate("/ghost/DashBoard.ini");
	}

	public GhostPost clickNewStory() throws Exception {
		RunConfig.logger().info("Creating New Post");
		RunConfig.logger().debug("dir.ui.gost.tests.pages.GostDashBoard.createNewPost(String, String)");
		RunConfig.logger().debug("Clicking on New Story button");
		element(GhostPageElements.NEW_POST_BUTTON.toString()).identify().click();
		RunConfig.logger().info("Clicked on New Story");
		return new GhostPost(getUiDriver());
	}

	public GhostDashBoard clickContents() throws Exception {
		RunConfig.logger().info("Returning to Gost Dashboard");
		RunConfig.logger().debug("dir.ui.gost.tests.pages.GostDashBoard.clickContents()");
		RunConfig.logger().debug("Clicking on Contents link");
		element(GhostPageElements.CONTENT.toString()).click();
		RunConfig.logger().info("Returned to Dashboard");
		return new GhostDashBoard(getUiDriver());
	}

	public GhostSignin signOut() throws Exception {
		// goTo("http://www.iamchandramouli.com/ghost/signout");
		element(GhostPageElements.USER_PROFILE.toString()).click();
		element(GhostPageElements.SIGNOUT.toString()).click();
		return new GhostSignin(getUiDriver());
	}

	public GhostPost clickPost(String postName) throws Exception {
		UiElement temp = null;
		RunConfig.logger().debug("Iterating through existing post");
		List<UiElement> posts = element(GhostPageElements.ALL_POSTS.toString()).getAllInstances();
		for (UiElement post : posts) {
			RunConfig.logger().debug("Fetching post name : ");
			String pName = post.getText();
			RunConfig.logger().debug("Post name is :" + pName);
			if (pName.equals(postName)) {
				RunConfig.logger().debug("Post found");
				temp = post;
				break;
			}
		}
		temp.click();
		element(GhostPageElements.POST_CONTENT.toString()).click();
		RunConfig.logger().info("Clicked on the Post :" + temp.getText());
		return new GhostPost(getUiDriver());
	}

	public boolean isPostPresent(String postName) throws Exception {
		RunConfig.logger().debug("Iterating through existing post");
		List<UiElement> posts = element(GhostPageElements.ALL_POSTS.toString()).getAllInstances();
		for (UiElement post : posts) {
			RunConfig.logger().debug("Fetching post name : ");
			String pName = post.getText();
			RunConfig.logger().debug("Post name is :" + pName);
			if (pName.equals(postName)) {
				RunConfig.logger().debug("Post found");
				return true;
			}
		}
		RunConfig.logger().info("Post not found");
		return false;
	}

}
