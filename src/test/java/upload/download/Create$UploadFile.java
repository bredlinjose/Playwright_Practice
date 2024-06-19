package upload.download;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Create$UploadFile {

	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//input type= file
		
		//multiple file upload
		page.setInputFiles("input#filesToUpload", 
				new Path[] {
						Paths.get("./src/test/resources/Output/loginInfo.json"),
						Paths.get("./src/test/resources/Output/trace.zip"),
						Paths.get("./src/test/resources/Output/loginInfo.json"),
						Paths.get("./src/test/resources/Output/trace.zip"),
						Paths.get("./src/test/resources/Output/loginInfo.json")
				});

		page.close();
		context.close();
		browser.close();
		playwright.close();
		
	}

}