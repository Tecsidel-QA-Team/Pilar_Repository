package AUSA;


import java.util.ArrayList;
import AUSA.ausaFieldsConfiguration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;






public class ausaBuscarPartes extends ausaFieldsConfiguration{
	
	
	  @Before
	  public  void setUp() throws Exception{
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			  /*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			  cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);			  
			  cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/					  
			  driver = new ChromeDriver();			  
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		  
	  }
	  @Test
	  public void ausaITSpage() throws Exception{
		  try{
			  				  		
			  			Actions action = new Actions (driver);
			  			driver.get(baseUrl);
			  			if (driver.getPageSource().contains("No se puede acceder a este sitio web"))
		                {                    
		                    System.out.println("ITS NO ESTA DISPONIBLE");
		                    return;
		                }			  			
			  			Thread.sleep(2000);
			  			borrarArchivosTemp("E:\\workspace\\Pilar_Repository\\ausaBuscarPartes\\attachments\\");
			  			takeScreenShot("E:\\Selenium\\","ausaLoginPage"+timet+".jpg");
			  			takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBuscarPartes\\attachments\\","ausaLoginPage"+timet+".jpg");			  			
			  	        driver.findElement(By.id("BoxLogin")).sendKeys("00001");
		                driver.findElement(By.id("BoxPassword")).sendKeys("00001");
		                driver.findElement(By.id("BtnLogin")).click();
		                Thread.sleep(3000);		                
		                String currentWindowHandle = driver.getWindowHandle();		                
		                String lPartes = driver.findElement(By.xpath("//div[7] / div / ul / li[5] / a")).getText();		                
		                Thread.sleep(1000);
		                WebElement Partes = driver.findElement(By.linkText(lPartes));		                
		                action.clickAndHold(Partes).perform();
		                Thread.sleep(2000);
		                String mPartes = driver.findElement(By.xpath("// div[7] / div / ul / li[5] / ul / li / a")).getText();		                
		                driver.findElement(By.linkText(mPartes)).click();
		                Thread.sleep(8000);
		                takeScreenShot("E:\\Selenium\\","AusaMainPage"+timet+".jpg");
			  			takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBuscarPartes\\attachments\\","AusaMainPage"+timet+".jpg");		                
		                if (lPartes.equals("Issues")){
		                	Types = "All";
		                }else{
		                	Types = "Todos";
		                }		                
		                ArrayList<String> wHandle = new ArrayList<String>(driver.getWindowHandles());
		                //driver.switchTo().window(availableWindows.get(1));		                
		                //System.out.println(driver.switchTo().window(availableWindows.get(1)).getTitle());
		                
		               for (String window : wHandle) {
		                	Thread.sleep(600);
		                	if (window != currentWindowHandle){
		                		driver.switchTo().window(window);		                		
		                		 //Partes1 = Partes1.toString();
		                		//System.out.println(Partes1);
		                		
		                	}
		               }
		                    
							Object Partes1 = mPartes;
							Assert.assertEquals(mPartes, Partes1);
		                    
		                Thread.sleep(3000);
		                driver.findElement(By.id("ctl00_ContentZone_imgShow")).click();
		                Thread.sleep(2000);
		                selectDropDownClick("ctl00_ContentZone_cmb_quantity_cmb_dropdown");
		                		String Tipo = driver.findElement(By.id("ctl00_ContentZone_mc_type_txt_selected")).getAttribute("value");
		                		String Gravedad = driver.findElement(By.id("ctl00_ContentZone_mc_severity_txt_selected")).getAttribute("value");
		                		String  Estado = driver.findElement(By.id("ctl00_ContentZone_mc_status_txt_selected")).getAttribute("value");
		                		String Origen = driver.findElement(By.id("ctl00_ContentZone_mc_creationMode_txt_selected")).getAttribute("value");
		                		String Prioridad = driver.findElement(By.id("ctl00_ContentZone_mc_priority_txt_selected")).getAttribute("value");
		                	JavascriptExecutor js = (JavascriptExecutor) driver;		              		                
		                Thread.sleep(500);
		                
                		if (Tipo.equals(Types)){
                					driver.findElement(By.id("ctl00_ContentZone_mc_type_img_expand")).click();
	                    			Thread.sleep(1000);
	                    			clickAll("ctl00_ContentZone_mc_type_ctl", 45, 53);
	                    			Thread.sleep(600);
	                    			ranClick("ctl00_ContentZone_mc_type_ctl","", 43, 43);// Elección de elemento del campo Tipo
	                    			Thread.sleep(500);
                				}
	                    						
                		if (Gravedad.equals(Types)){
                					driver.findElement(By.id("ctl00_ContentZone_mc_severity_img_expand")).click();
		                    		Thread.sleep(1000);
		                    		clickAll("ctl00_ContentZone_mc_severity_ctl", 33, 39);
		                    		Thread.sleep(600);
		                    		ranClick("ctl00_ContentZone_mc_severity_ctl","", 31, 31);// Elección de elemento del campo Tipo
		                    		Thread.sleep(500);
                				}
		                    					
                		if (Estado.equals(Types)){
                					driver.findElement(By.id("ctl00_ContentZone_mc_status_img_expand")).click();
		                    		Thread.sleep(1000);
		                    		clickAll("ctl00_ContentZone_mc_status_ctl", 45, 53);
		                    		Thread.sleep(600);
		                    		ranClick("ctl00_ContentZone_mc_status_ctl","", 43, 43);// Elección de elemento del campo Tipo
		                    		Thread.sleep(500);
                				}	
		                    					
                		if (Origen.equals(Types)){
                					driver.findElement(By.id("ctl00_ContentZone_mc_creationMode_img_expand")).click();
		                    		Thread.sleep(1000);
		                    		clickAll("ctl00_ContentZone_mc_creationMode_ctl", 23, 27);
		                    		Thread.sleep(600);
		                    		ranClick("ctl00_ContentZone_mc_creationMode_ctl", "",21, 21);// Elección de elemento del campo Tipo		                
		                    		Thread.sleep(500);
                				}	
		                    					
                		if (Prioridad.equals(Types)){
                					driver.findElement(By.id("ctl00_ContentZone_mc_priority_img_expand")).click();
		                    		Thread.sleep(1000);
		                    		clickAll("ctl00_ContentZone_mc_priority_ctl", 45, 53);
		                    		Thread.sleep(600);
		                    		ranClick("ctl00_ContentZone_mc_priority_ctl", "",43, 43);// Elección de elemento del campo Tipo
		                    		Thread.sleep(500);
		                		}	
		                /*selectDropDownClick("ctl00_ContentZone_cmb_assigned_cmb_dropdown");
		                System.Threading.Thread.Sleep(1000);
		                selectDropDownClick("ctl00_ContentZone_cmd_supervisor_cmb_dropdown");*/
		                Thread.sleep(1500);
		                elementClick("ctl00_ButtonsZone_BtnSearch_IB_Label");
		                Thread.sleep(6000);                
		                if (isElementPresent(By.id("tableIssues"))){
		                	WebElement table = driver.findElement(By.cssSelector("tbody tr td table#tableIssues.generalTable"));
		                    //WebElement table = driver.findElement(By.id("tableIssues"));
		                    //String tabletr = driver.findElement(By.tagName("tr")).toString();
		                	
		                    List<WebElement> tableCount = table.findElements(By.tagName("tr"));
		                    
		                    if (tableCount.size() == 1)
		                    {
		                        System.out.println("Ningún parte encontrado para los criterios de selección introducidos");
		                    }
		                    else
		                    {
		                    	//html body form#aspnetForm div#contentDiv div#content div.pageMainDiv div table  tbody tr#issue_690.generalRowSelected td#actions_issue_690 input#delete_690
		                        System.out.println("Se han encontrado " +tableCount.size()+ " Registro/s");
		                        //System.out.println(tableCount.get(tableCount.));
		                        js.executeScript ("window.scrollBy(2100,0)", "");
		                        Thread.sleep(3000);

		                    }
		                }else
		                {
		                    System.out.println("No hubo Elementos Encontrados");
		                }

		                takeScreenShot("E:\\Selenium\\","AusaSearchPageResult"+timet+".jpg");
			  			takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaBuscarPartes\\attachments\\","AusaSearchPageResult"+timet+".jpg");
		            }
		            catch (Exception e)
		            {
		                e.printStackTrace();//System.out.println(e.getStackTrace());
		                return;
		            }
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
  
  

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public static void ZoomIn() throws Exception{
	  WebElement html = driver.findElement(By.tagName("html"));
	  for (int i = 0; i<2; i++){
		  html.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
	  }
  }
  public static int ranNumbr(int min, int max) {
	  Random rand = new Random();
	  numbering = min+rand.nextInt((max-min)+1);
	  return numbering;
	  
  }
  
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
	
}