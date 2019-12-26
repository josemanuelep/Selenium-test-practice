package selenium.selenium.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {
	
	private WebDriver driver;
	
	//Es lo que debe cumplirse antes de iniciar el test
	//Es el punto de entrada de la prueba
	@Before	
	public void startDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void test() {
				
		String wordToSearch = "Pruebas de software";
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		WebElement searhBox = driver.findElement(By.id("searchInput"));
		WebElement searhButton = driver.findElement(By.id("searchButton"));
		//Send param to searh to the box
		searhBox.sendKeys(wordToSearch);
		searhButton.click();
		WebElement title = driver.findElement(By.id("firstHeading"));
		assertEquals(wordToSearch,title.getText());
	}
}
