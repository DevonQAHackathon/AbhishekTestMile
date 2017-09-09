package dir.ui.ghost.tests;

import arjunasdk.config.RunConfig;
import arjunasdk.ddauto.interfaces.DataRecord;
import arjunasdk.uiauto.interfaces.UiDriver;
import dir.ui.ghost.tests.pages.GhostDashBoard;
import dir.ui.ghost.tests.pages.GhostDialog;
import dir.ui.ghost.tests.pages.GhostPost;
import dir.ui.ghost.tests.pages.GhostSignin;
import dir.ui.ghost.tests.pages.Tool;
import unitee.annotations.AfterClassInstance;
import unitee.annotations.BeforeClassInstance;
import unitee.annotations.Data;
import unitee.annotations.DriveWithDataArray;
import unitee.annotations.DriveWithDataFile;
import unitee.annotations.Instances;
import unitee.annotations.Skip;
import unitee.annotations.TestClass;
import unitee.interfaces.TestVariables;

@Instances(count = 2, instanceThreads = 2)
@TestClass
public class GhostTestClass {

	UiDriver driver;
	Tool browser;
	GhostSignin sigin;
	GhostDashBoard dashBoard;
	GhostPost post;
	GhostDialog dialog;

	@BeforeClassInstance
	public void launchTool() throws Exception {
		browser = new Tool(driver);
		sigin = browser.startBrowser();
	}

	@Instances(2)
	@DriveWithDataFile(path = "posts.ini")
	public void addPost(TestVariables testVar) throws Exception {
		DataRecord rec = testVar.record();
		String email = rec.string("userName");
		String password = rec.string("password");
		RunConfig.logger().info("Gost SignIn");
		RunConfig.logger().debug("dir.ui.gost.tests.GostTestClass.signIn()");
		RunConfig.logger().debug("Signing into gost account");
		dashBoard = sigin.signIn(email, password);
		RunConfig.logger().info("Returning Gost Dash Board on Success");

		String postDesc = "POST 1 : " + email;
		String postTitle = "Data for the Fist Post";
		RunConfig.logger().info("Adding a post in Gost");
		RunConfig.logger().debug("dir.ui.gost.tests.GostTestClass.addPost()");
		RunConfig.logger().debug("Clicking on New Story Button");
		post = dashBoard.clickNewStory();
		RunConfig.logger().info("Clicked on New Story");
		RunConfig.logger().debug("Creating post with title : " + postTitle);
		post.createPost(postTitle, postDesc);
		RunConfig.logger().info("Created Post with Title :" + postTitle);
		RunConfig.logger().debug("Clicking on contents");
		dashBoard.clickContents();
		RunConfig.logger().info("Returning to DashBoard");

		RunConfig.logger().info("Siging out from Gost");
		RunConfig.logger().debug("dir.ui.gost.tests.GostTestClass.sigOut()");
		RunConfig.logger().debug("Signing out using url");
		dashBoard.signOut();
		RunConfig.logger().info("Signed out form Gost");
	}

	// @Instances(2)
	@Skip
	@DriveWithDataArray({ @Data({ "POST 1" }), @Data({ "POST 2" }) })
	public void deletePost(TestVariables testVar) throws Exception {
		DataRecord record = testVar.record();
		String postName = record.stringAt(0);
		RunConfig.logger().info("Deleting Post from Gost");
		RunConfig.logger().debug("dir.ui.gost.tests.GostTestClass.deletePost(String)");
		RunConfig.logger().debug("Clicking on the post : " + postName);
		post = dashBoard.clickPost(postName);
		RunConfig.logger().info("Clicked on the post");
		RunConfig.logger().debug("Clicking on delete from the drop down");
		dialog = post.deletePost();
		RunConfig.logger().info("Clicked on the delete from drop down");
		RunConfig.logger().debug("Clicking on the delete button");
		dashBoard = dialog.delete();
		RunConfig.logger().info("Clicked on the delete button");
	}

	public void sigOut() throws Exception {
		RunConfig.logger().info("Siging out from Gost");
		RunConfig.logger().debug("dir.ui.gost.tests.GostTestClass.sigOut()");
		RunConfig.logger().debug("Signing out using url");
		dashBoard.signOut();
		RunConfig.logger().info("Signed out form Gost");
	}

	@AfterClassInstance
	public void closeTool() throws Exception {
		browser.closeBrowser();
	}

}
