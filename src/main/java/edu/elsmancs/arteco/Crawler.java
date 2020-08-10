package edu.elsmancs.arteco;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Crawler {
	
	/* Intento de utilitzar Selenium para parsear la URL, fallido
	public static void getURL(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement generate = driver.findElement(By.id("generate"));
		generate.click();
		WebElement loren = driver.findElement(By.id("lipsum"));
		System.out.print("-----------------------------------------------------------------------------------\n"
				+ "Text : " + loren +
				"\n-----------------------------------------------------------------------------------");
		driver.quit();
	}
	*/
	
	public static String getURLJSoup(String url) {
		String output = "";
		Document loren;
		try {
			loren = Jsoup.connect(url).get();
			Elements content = loren.select("#lipsum p");
			
			for (Element line : content) {
				output += line.text() + " </p> ";
			}
			System.out.print("-----------------------------------------------------------------------------------"
					+ "\nText : " + output +
					"\n-----------------------------------------------------------------------------------\n");
			
		} catch (IOException e) {
			System.out.print("La URL no es correcta");
		}
		return output;
	}
	
	public static String mockURL() {
		return "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam sed velit a ante eleifend condimentum quis ac nisi. Praesent at viverra ex. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Sed fringilla enim erat, vitae egestas mauris auctor eu. Ut viverra iaculis orci non posuere. Cras pretium enim posuere ligula auctor, ac hendrerit sapien mattis. In placerat, risus vitae placerat fringilla, ante velit lobortis urna, sit amet facilisis augue nisi id ipsum. Fusce nisl dui, eleifend id aliquam eu, laoreet nec dolor.</p>" + 
				"<p> Integer dictum mi id magna malesuada, eu congue orci facilisis. Aliquam lacus lorem, tincidunt et venenatis eu, dapibus quis velit. Nulla efficitur metus sed tellus dictum, in condimentum urna dignissim. Nulla nec tellus mauris. Duis quis sodales quam. Cras vestibulum rutrum libero. Nullam efficitur tincidunt tellus ut mollis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Fusce elementum et orci ac ultricies. Integer placerat tempus fringilla. Praesent rhoncus magna odio, sit amet eleifend felis hendrerit a. Phasellus commodo sodales metus vulputate luctus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec pretium finibus porttitor.</p>" + 
				"<p> Nunc aliquam, orci sed lacinia dignissim, nulla purus molestie urna, quis fermentum leo massa at elit. Nunc dolor mi, sollicitudin a turpis nec, molestie mattis nunc. Curabitur pellentesque sapien purus, vitae blandit mi porta quis. Sed ac eros et arcu suscipit fringilla. In ornare quam nunc, quis imperdiet lacus pretium at. Nulla facilisi. Pellentesque eu posuere ex. Nam ac malesuada ante, a laoreet metus. Pellentesque sodales eleifend fringilla. Duis nec elementum massa.</p>" + 
				"<p> Cras volutpat facilisis ante. Phasellus gravida lobortis ligula vitae aliquam. Quisque vitae arcu eget dui faucibus lobortis id id ipsum. Aliquam nunc erat, imperdiet vitae tempor id, ornare in tellus. Aenean ut tellus ut sapien consectetur ultrices. Nullam ullamcorper aliquet nibh, eget placerat augue venenatis sed. Proin maximus vestibulum pretium. Nulla vel dictum eros. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas condimentum sollicitudin mauris sed egestas. Phasellus volutpat purus ut lorem dictum porttitor. Integer augue velit, bibendum a metus vitae, rhoncus luctus dolor. Curabitur et tellus non dolor fermentum dapibus sit amet sagittis nulla. Etiam orci dui, finibus id velit ut, dictum malesuada ante. Maecenas egestas suscipit ligula, sed porta lectus cursus quis.</p>" + 
				"<p> Mauris ipsum urna, aliquet id convallis sed, finibus et felis. Aliquam accumsan leo lectus, at placerat ex consequat et. Integer efficitur ultrices nibh, quis imperdiet ligula volutpat at. Vivamus vitae nibh id nulla iaculis dapibus sit amet vitae nulla. Nulla finibus tristique elit, eu pharetra tellus consectetur et. Duis sed dolor tempor, eleifend justo sed, condimentum eros. Nam magna neque, volutpat id varius non, maximus quis dui. Duis efficitur porttitor mauris at laoreet. Duis rhoncus eget neque semper commodo. Nulla quis erat et metus iaculis iaculis nec at orci.</p>";
	}
}
