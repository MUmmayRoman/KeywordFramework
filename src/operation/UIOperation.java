package operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIOperation {     //This Class shows all the Keywords Options.
	
WebDriver driver;
	
	public UIOperation(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void perform(Properties p, String operation, String objectName, String objectType, String value) throws Exception {
		
		System.out.println("");
		switch (operation.toUpperCase()) {
		
		case "CLICK":
			
			//perform click
			driver.findElement(this.getObject(p,objectName,objectType)).click();
			break;
			
		case "SETTEXT":
			
			//Set text on control
			driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(value);
			break;
			
		case "GOTOURL":
			
			//Get url of application
			driver.get(p.getProperty(value));
			break;
			
		case "GETTEXT":
			
			//Get text of an element
			driver.findElement(this.getObject(p,objectName,objectType)).getText();
			break;
			
			default:
				break;
				
		}
	}
	
	/**
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	
	private By getObject(Properties p,String objectName, String objectType) throws Exception {
		
		//Find by xpath
		if(objectType.equalsIgnoreCase("XPATH")) {
			
			return By.xpath(p.getProperty(objectName));
		}
		
		//Find by id
		if(objectType.equalsIgnoreCase("ID")) {
					
			return By.id(p.getProperty(objectName));
		}
		
		//Find by xpath
		if(objectType.equalsIgnoreCase("TAGNAME")) {
					
			return By.tagName(p.getProperty(objectName));
		}
		
		
		// Find by class
		else if(objectType.equalsIgnoreCase("CLASSNAME")) {
			
			return By.className(p.getProperty(objectName));
		}
		
		
		// Find by name
		else if(objectType.equalsIgnoreCase("NAME")) {
			
			return By.name(p.getProperty(objectName));
		}
		
		
		// Find by css
		else if(objectType.equalsIgnoreCase("CSS")) {
			
			return By.cssSelector(p.getProperty(objectName));
		}
		
		
		// Find by link
		else if(objectType.equalsIgnoreCase("LINK")) {
			
			return By.linkText(p.getProperty(objectName));
		}
		
		
		// Find by partial link
		else if(objectType.equalsIgnoreCase("PARTIALLINK")) {
			
			return By.partialLinkText(p.getProperty(objectName));
		}
		
		
		else {
			
			throw new Exception("Wrong Object type");
		}
		
	}

}
