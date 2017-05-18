package AUSA;

import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.util.Loader;
import org.junit.*;
import org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.junit.Assert.*;

//import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileOutputStream;

//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.apache.commons.io.FileUtils;


public class ausaDelPartes extends ausaFieldsConfiguration{
	public static int i = 0;
	public static int xll=0;
	public static String errorText;
	
	
	
	  @Before
	  public  void setUp() throws Exception{
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			  /*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			  cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);			  
			  cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
		  
		  		ChromeOptions opts =  new ChromeOptions();
		  		opts.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
				driver = new ChromeDriver(opts);  
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		  
	  }
	  @Test
	  public void ausaITSpage() throws Exception{
		  try{
			  				  		
			  			Actions action = new Actions (driver);
			  			driver.get(baseUrl);
			  			if (driver.getPageSource().contains("No se puede acceder a este sitio web") || driver.getPageSource().contains("Service Unavailable"))
		                {                    
		                    System.out.println("ITS NO ESTA DISPONIBLE");
		                    return;
		                }			  			
			  			Thread.sleep(2000);
			  			borrarArchivosTemp("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\");
			  			takeScreenShot("E:\\Selenium\\","ausaLoginPageCrearPartes"+timet+".jpg");
			  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\","ausaLoginPageCrearPartes"+timet+".jpg");			  			
			  	        driver.findElement(By.id("BoxLogin")).sendKeys("calidad");
		                driver.findElement(By.id("BoxPassword")).sendKeys("calidad");
		                driver.findElement(By.id("BtnLogin")).click();
		                Thread.sleep(3000);
		                takeScreenShot("E:\\Selenium\\","AusamP"+timet+".jpg");
			  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\","AusamP"+timet+".jpg");		                
		                String currentWindowHandle = driver.getWindowHandle();		                
		                String lPartes = driver.findElement(By.xpath("//div[7] / div / ul / li[5] / a")).getText();		                
		                Thread.sleep(1000);
		                WebElement Partes = driver.findElement(By.linkText(lPartes));		                
		                action.clickAndHold(Partes).perform();
		                Thread.sleep(2000);
		                String mPartes = driver.findElement(By.xpath("// div[7] / div / ul / li[5] / ul / li / a")).getText();		                
		                driver.findElement(By.linkText(mPartes)).click();
		                Thread.sleep(8000);
		                takeScreenShot("E:\\Selenium\\","AusapP"+timet+".jpg");
			  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\","AusapP"+timet+".jpg");		                		                
		                if (lPartes.equals("Issues")){
		                	Types = "All";
		                }else{
		                	Types = "Todos";
		                }
		                ArrayList<String> wHandle = new ArrayList<String>(driver.getWindowHandles());	                
		               for (String window : wHandle) {
		                	Thread.sleep(600);
		                	if (window != currentWindowHandle){
		                		driver.switchTo().window(window);		                		
		                		
		                	}
		               }
							Object Partes1 = mPartes;
							Assert.assertEquals(mPartes, Partes1);
							
		                Thread.sleep(1500);
		                driver.findElement(By.id("ctl00_ContentZone_imgShow")).click();
		                Thread.sleep(500);
		                selectDropDownClick("ctl00_ContentZone_cmb_assigned_cmb_dropdown");
		                Thread.sleep(800);
		                elementClick("ctl00_ButtonsZone_BtnSearch_IB_Label");
		                Thread.sleep(1000);               
		                if (driver.findElements(By.xpath("//div[@class='toast-item toast-type-error']/p")).size()!=0){
		                	errorText = driver.findElement(By.xpath("//div[@class='toast-item toast-type-error']/p")).getText();
		                	takeScreenShot("E:\\Selenium\\","errorSearch"+timet+".jpg");
				  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\","errorSearch"+timet+".jpg");		                	  						
	  						System.out.println("ERROR EN BUSQUEDA: "+errorText+ ". Ver Imagen de Captura Busqueda.jpeg");
		                }else{
		                    	borrarElement();
		                    }
		                
		                
		            }
		            catch (Exception e)
		            {
		                e.printStackTrace();//System.out.println(e.getStackTrace());
		                return;
		            }
	  }   
	  				public static void borrarElement() throws Exception{
	  					Thread.sleep(1000);
	  					WebElement table = driver.findElement(By.cssSelector("tbody tr td table#tableIssues.generalTable"));
	  					List <WebElement> tableCount = table.findElements(By.tagName("tr"));
	  					ArrayList<String> delPart = new ArrayList<String>();
	  					int x = 0;
	  					do{		  						
	  						for ( i = 1; i  <=  tableCount.size(); i++){	  							
	  							String buscar1 = table.findElement(By.xpath("//table[@id='tableIssues']/tbody/tr"+"["+i+"]/td[16]/input[3]")).getAttribute("id");
	  							if (buscar1.contains("addComm")){
	  								buscar1 = table.findElement(By.xpath("//table[@id='tableIssues']/tbody/tr"+"["+i+"]/td[16]/input[4]")).getAttribute("id");
	  							}
	  							if (buscar1.contains("delete")){
	  								delPart.add(buscar1);
	  								x = x+1;
	  							}
	  							
	  						}	  
	  						Thread.sleep(100);
	  					}while (i < tableCount.size());
	  						Random xl = new Random();
	  					for (i = 1; i <= delPart.size(); i++){
  							xll = xl.nextInt(delPart.size())+1;
  							if (xll > delPart.size()-1){
  								xll = xll -1;
  							}
  							if (xll < 0){
  								xll = 0;
  							}
	  					}
	  					driver.findElement(By.id(delPart.get(xll))).click();
	  					if (driver.findElements(By.xpath("//div[@class='toast-item toast-type-error']/p")).size()!=0){
	  				    	takeScreenShot("E:\\Selenium\\","noIssuesDeleted"+timet+".jpg");
				  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\","noIssuesDeleted"+timet+".jpg");
	  						Thread.sleep(500);
	  						errorText = driver.findElement(By.xpath("//div[@class='toast-item toast-type-error']/p")).getText();	  					
	  						System.out.println("ERROR AL ELIMINAR PARTE: "+errorText+ ". Ver Imagen de Captura noIssuesDeleted.jpeg");
	  						return;
	  					}
	  					Thread.sleep(1000);
	  					driver.findElement(By.id("popup_ok")).click();
	  					Thread.sleep(1000);
  				    	takeScreenShot("E:\\Selenium\\","parteEliminada"+timet+".jpg");
			  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBorrarPartes\\attachments\\","parteEliminada"+timet+".jpg");
	  					System.out.println ("Se ha Eliminado la Parte "+ delPart.get(xll).substring(7) + " Correctamente. Vea Imagen de Captura Mensaje de Confirmación de Elemento Borrado");
	  				}
	  				
       @After
  public void tearDown() throws Exception {
    driver.quit();    
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      org.junit.Assert.fail(verificationErrorString);
    }
  }
       

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  
  	
}