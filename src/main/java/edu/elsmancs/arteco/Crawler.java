package edu.elsmancs.arteco;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Crawler {

	public static void getURL(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		WebElement generate = driver.findElement(By.id("generate"));
		generate.click();
		WebElement loren = driver.findElement(By.id("lipsum"));
		System.out.print("-----------------------------------------------------------------------------------\n "
				+ "Text : " + loren);
		driver.quit();
	}
	
	public static String mockURL() {
		return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec non nisl lectus. Quisque sapien elit, commodo non lacus nec, accumsan pharetra libero. Donec rhoncus lacinia viverra. Quisque luctus suscipit feugiat. Donec molestie malesuada semper. Donec eleifend felis nec justo pharetra vehicula. Maecenas nisi magna, mollis at tincidunt at, aliquam et sapien. Nulla suscipit ex ut tortor interdum tristique at vehicula eros. Nunc massa sapien, gravida in semper ac, dapibus eu neque. Nunc orci neque, tincidunt eu facilisis sit amet, mollis euismod erat. Morbi finibus diam quis eros venenatis, a varius risus efficitur. Maecenas in ipsum bibendum justo bibendum ultricies a eu nunc.\r\n" + 
				"\r\n" + 
				"Praesent dictum tincidunt diam sed cursus. Vestibulum et placerat nibh. Suspendisse egestas justo pellentesque volutpat luctus. Ut cursus mollis fringilla. Fusce in justo sed purus porta dapibus non ut sem. In neque orci, facilisis quis velit eget, consequat iaculis lorem. Suspendisse efficitur sed augue ac aliquet.\r\n" + 
				"\r\n" + 
				"Mauris ac egestas lacus. Sed elementum turpis a magna hendrerit, quis hendrerit lorem faucibus. Pellentesque et risus odio. Curabitur interdum, nisl eu feugiat pulvinar, urna lectus bibendum lectus, vel malesuada massa quam et metus. Aenean eu purus et metus dapibus accumsan interdum a ligula. Aliquam volutpat gravida feugiat. Maecenas at nunc cursus, aliquam lorem tincidunt, malesuada leo. Donec consequat lobortis tortor a tincidunt.\r\n" + 
				"\r\n" + 
				"Vivamus euismod faucibus ante molestie laoreet. Aliquam erat volutpat. Cras placerat euismod lacinia. Duis eget lorem hendrerit, convallis lacus sed, congue lorem. Proin urna arcu, mattis id tellus nec, pulvinar condimentum velit. Praesent sagittis tincidunt nisi pharetra venenatis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Duis efficitur in elit in imperdiet. Praesent luctus dui ut convallis placerat. Sed dictum faucibus odio id fringilla. Etiam ultricies odio vitae dignissim consequat. Proin elit odio, sollicitudin non magna et, efficitur gravida eros.\r\n" + 
				"\r\n" + 
				"Praesent pellentesque placerat velit, quis aliquam felis consequat sit amet. Aenean ultricies hendrerit purus, et auctor eros pharetra ut. Curabitur accumsan efficitur lectus, vitae convallis velit pretium in. Fusce at nisl porttitor, egestas justo non, fermentum nulla. Fusce in fermentum nibh. Fusce at rhoncus ligula. Mauris placerat congue purus. Sed pulvinar, libero ac malesuada rhoncus, leo felis tincidunt felis, non fringilla lacus purus sed metus. Donec lobortis iaculis quam, sit amet bibendum neque sodales non. Etiam feugiat porta metus nec semper. Donec in sagittis mauris. Nulla ac ante mi.";
	}
}
