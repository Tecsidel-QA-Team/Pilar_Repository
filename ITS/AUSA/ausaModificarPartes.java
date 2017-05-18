package AUSA;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import AUSA.ausaFieldsConfiguration;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class ausaModificarPartes extends ausaFieldsConfiguration{
	    public static String mPartes;
	    public static int i;
	    public static int xll;
	    public static int selComp;
	    public static String compT;
	    
	    
 @Before
 public  void setUp() throws Exception {
	 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	  /*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	  cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);			  
	  cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
		ChromeOptions chromeLocation =  new ChromeOptions();
		chromeLocation.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		driver = new ChromeDriver(chromeLocation);  
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
 	}
 
 	@Test
 	public void ausaIssuesUpdate() throws Exception{
 		  try{ 	 		
 			  
	  			Actions action = new Actions (driver);
	  			driver.get(baseUrl);
	  			if (driver.getPageSource().contains("No se puede acceder a este sitio web") || driver.getPageSource().contains("Service Unavailable"))
              {                    
                  System.out.println("ITS NO ESTA DISPONIBLE");
                  return;
              }			  			
	  			Thread.sleep(2000);
	  			borrarArchivosTemp("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\");
	  			takeScreenShot("E:\\Selenium\\","ausaLoginPageCrearPartes"+timet+".jpg");
	  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","ausaLoginPageCrearPartes"+timet+".jpg");	  			
	  	      driver.findElement(By.id("BoxLogin")).sendKeys("calidad");
              driver.findElement(By.id("BoxPassword")).sendKeys("calidad");
              driver.findElement(By.id("BtnLogin")).click();
              Thread.sleep(3000);
              	takeScreenShot("E:\\Selenium\\","AusamP"+timet+".jpg");
	  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","AusamP"+timet+".jpg");              
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
          		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","AusapP"+timet+".jpg");
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
					WebElement nexTab = driver.findElement(By.tagName("body"));
		               nexTab.sendKeys(Keys.CONTROL + "\t");
		               driver.switchTo().defaultContent();
              Thread.sleep(3000);		                		                		                              			              		                	                		                
              elementClick("ctl00_ButtonsZone_BtnSearch_IB_Label");
              Thread.sleep(6000);                
              if (isElementPresent(By.id("tableIssues"))){
              	WebElement table = driver.findElement(By.cssSelector("tbody tr td table#tableIssues.generalTable"));
                  List<WebElement> tableCount = table.findElements(By.tagName("tr"));
                  if (tableCount.size() == 1)
                  {
                      System.out.println("Ningún parte encontrado para los criterios de selección introducidos");
                      return;
                  }
                  else
                  {
                  	buscarElement();
                  }
              }else
              {
                  System.out.println("No hubo Elementos Encontrados");
                  return;
              }
              
          }
          catch (Exception e)
          {
        	  //e.getCause();
              e.printStackTrace();//System.out.println(e.getStackTrace());
        	  //Exception a = new Exception ("No Such Element Found");       	  
              return;
          }
}   
			public static void buscarElement() throws Exception{
				Thread.sleep(1000);
				WebElement table = driver.findElement(By.cssSelector("tbody tr td table#tableIssues.generalTable"));
				List <WebElement> tableCount = table.findElements(By.tagName("tr"));
				do{	
					Random xl = new Random();
					for ( i = 1; i < tableCount.size(); i++){
						xll = xl.nextInt(i)+1;
						if (xll > i){
							xll = xll -1;
						}
					}
					String buscar1 = table.findElement(By.xpath("//table[@id='tableIssues']/tbody/tr"+"["+xll+"]")).getAttribute("id");
					String editClick = buscar1.substring(5);
					driver.findElement(By.id("edit"+editClick)).click();
					Thread.sleep(5000);		  					
				}while (i < tableCount.size());
				Thread.sleep(2000);
				updatePartes();
	            Thread.sleep(1500);
	            driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
	            Thread.sleep(1000);	            
			}
 	
 	
	public static void updatePartes() throws Exception{
		Thread.sleep(2000);
		ArrayList<String> wHandle = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wHandle.get(2));		                 			
			Object Partes1 = "#Partes";
       		Assert.assertEquals("#Partes", Partes1);
       		Thread.sleep(1000);
       		partText = driver.findElement(By.id("ctl00_ContentZone_txt_id_box_data")).getAttribute("value");
               selectDropDownClick("ctl00_ContentZone_cmb_parent_cmb_dropdown");
               selectDropDownClick("ctl00_ContentZone_cmb_status_cmb_dropdown");
               Thread.sleep(400);
               WebElement statusSel = new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_status_cmb_dropdown"))).getFirstSelectedOption();
               String statusSelT = statusSel.getText();
               if (statusSelT.equals("Abierto") || statusSelT.equals("Re-Abierto")){
            	   selectDropDownClick("ctl00_ContentZone_cmb_template_cmb_dropdown");
            	   Thread.sleep(500);
               }
               if (driver.findElements(By.id("popup_ok")).size() !=0){
            	   driver.findElement(By.id("popup_ok")).click();
            	   Thread.sleep(100);
               }   
               tipoSel = driver.findElement(By.id("ctl00_ContentZone_txt_type_box_data")).getAttribute("value");
               selectDropDownClick(prioritySel);               
        //Filling out all data
            selectDropDownClick(gravedadT);//Gravedad
            selectDropDownClick(asignadoT);//Asignado            
            if (driver.findElements(By.id(supervisorT)).size()!=0){
            	selectDropDownClick(supervisorT);//Supervisor            	
            }
            Thread.sleep(3000);
            selectDropDownClick(tValoresT);//Tramo Lista Valores
            Thread.sleep(1000);
            notEmptyDropDown(direcT);
            driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmKm_box_data")).clear();
            driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmKm_box_data")).sendKeys(ranNumbr(10,900)+"");
            driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmM_box_data")).clear();
            driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmM_box_data")).sendKeys(ranNumbr(1,900)+"");
            Thread.sleep(1000);
            notEmptyDropDown(ramalsT);
            driver.findElement(By.id(locationT)).clear();
            driver.findElement(By.id(locationT)).sendKeys("Modified Argentina");            
            driver.findElement(By.id(observaT)).sendKeys("     ___QA issue Modifyed by Automation Script");
            Thread.sleep(500);
            datosSection();
            Thread.sleep(1000);
            ranclickOption(dOption, 1, dOption.length);
            Thread.sleep(3000);
            if (driver.findElement(By.id(dOption[4])).isSelected()){
            	driver.findElement(By.id(vVolcado)).clear();
            	driver.findElement(By.id(vVolcado)).sendKeys(ranNumbr(1,99)+"");
            }
            Thread.sleep(2000);
            if (tipoSel.equals("Incidente")|| tipoSel.equals("Accidente")){
            	ranclickOption(vOption, 1, vOption.length);
            	for (int  i = 1; i < vOption.length;i++){            		
            		if (driver.findElement(By.id(vOption[i])).isSelected()){
            			Thread.sleep(1000);
            			driver.findElement(By.id(vOptionT[i])).clear();
            			driver.findElement(By.id(vOptionT[i])).sendKeys(ranNumbr(1,99)+"");;
            		}
            	}
            }	
            Thread.sleep(500);
        	takeScreenShot("E:\\Selenium\\","modifyParte"+timet+".jpg");
  	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","modifyParte"+timet+".jpg");
            infoComponents();
               
                  
		}
	
	public static void datosSection() throws Exception{
        Thread.sleep(1500);
        driver.findElement(By.id(datoBtn)).click();
    	Thread.sleep(1000);
        if (tipoSel.equals("Incidente")|| tipoSel.equals("Accidente")){  
        	if (driver.findElements(By.id(typeAccidentes)).size()!=0){
        		driver.findElement(By.id(typeAccidentes)).click();
        		ranSelection("ctl00_ContentZone_mc_typeOfAccident_ctl","ctl00_ContentZone_mc_typeOfAccident_ctl".length());
                ranClick("ctl00_ContentZone_mc_typeOfAccident_ctl","0",ad,caMer);
                driver.findElement(By.id(typeAccidentes)).click();
        		Thread.sleep(400);
        	}	
        	if (driver.findElements(By.id(typeImpacto)).size()!=0){
        		driver.findElement(By.id(typeImpacto)).click();        		
        		ranSelection("ctl00_ContentZone_mc_causal_ctl","ctl00_ContentZone_mc_causal_ctl".length());
                ranClick("ctl00_ContentZone_mc_causal_ctl","0",ad,caMer);
                driver.findElement(By.id(typeImpacto)).click();
        		Thread.sleep(500);
        	}	
        	
        }	
        driver.findElement(By.id("ctl00_ContentZone_txt_causes_box_data")).clear();
        driver.findElement(By.id("ctl00_ContentZone_txt_causes_box_data")).sendKeys("This was modified by automation script for Test Purpose");
        driver.findElement(By.id("ctl00_ContentZone_txt_information_box_data")).clear();
        driver.findElement(By.id("ctl00_ContentZone_txt_information_box_data")).sendKeys("This was modified by automation script for Test Purpose");
        driver.findElement(By.id("ctl00_ContentZone_txt_observations_box_data")).clear();
        driver.findElement(By.id("ctl00_ContentZone_txt_observations_box_data")).sendKeys("This was modified by automation script for Test Purpose");
        driver.findElement(By.id("ctl00_ContentZone_txt_note_box_data")).clear();
        driver.findElement(By.id("ctl00_ContentZone_txt_note_box_data")).sendKeys("This was modified by automation script for Test Purpose");
        Thread.sleep(500);
        driver.findElement(By.id(cameraSel)).click();
        Thread.sleep(1000);            
        ranSelection("ctl00_ContentZone_mcCameras_ctl","ctl00_ContentZone_mcCameras_ctl".length());
        ranClick("ctl00_ContentZone_mcCameras_ctl","0",ad,caMer);        
        Thread.sleep(1000);
        driver.findElement(By.id(cameraSel)).click();
 		}
	
	
	public static void infoComponents() throws Exception{
		Thread.sleep(3000);
		List<WebElement> infoComp = driver.findElements(By.xpath("//span[contains(@id,'ctl00_ContentZone_BtnAdd')]"));
	if (infoComp.size()!=0){	
		for (int i = 1; i <= infoComp.size(); i++){
			selComp = ranNumbr(1,infoComp.size());	
		}		
			compT = driver.findElement(By.xpath("//div"+"["+selComp+"]/a/div/span[contains(@id,'ctl00_ContentZone_BtnAdd')]")).getAttribute("class");
				//compT = "IB_weather";
			switch (compT){
				case "IB_comunication":			Thread.sleep(1000);
												AUSA.communicationCompScreen.ibCommunication();
												break;
				case "IB_vehicle":				Thread.sleep(1000);
												AUSA.vehicleCompScreen.ibVehicle();
												break;
				case "IB_person":				Thread.sleep(1000);
												AUSA.personCompScreen.ibPerson();
												break;
				case "IB_patrol":				Thread.sleep(1000);
												AUSA.patrolCompScreen.ibPatrol();
												break;
				case "IB_security":				Thread.sleep(1000);
												AUSA.securityCompScreen.ibSecurity();				
												break;
				case "IB_ambulance":			Thread.sleep(1000);
												AUSA.ambulanceCompScreen.ibAmbulance();
												break;
				case "IB_crane":				Thread.sleep(1000);
												AUSA.craneCompScreen.ibCrane();
												break;
				case "IB_weather":				Thread.sleep(1000);
												AUSA.weatherCompScreen.ibWeather();
												break;
				case "IB_trafic":				Thread.sleep(1000);
												AUSA.trafficCompScreen.ibTraffic();
												break;
				case "IB_roadway":				Thread.sleep(1000);
												AUSA.calzadaCompScreen.ibCalzada();
												break;				
				case "IB_insideInformation":	Thread.sleep(1000);
												AUSA.infoCompScreen.ibInformation();
												break;
				case "IB_inconvenientShedule":	Thread.sleep(1000);
												AUSA.inconCompScreen.ibInconveniente();
												break;
				default:						System.out.println(compT+" No está implementado");
												break;
			}
	}else{
		System.out.println("La parte No. "+partText + " no contiene componentes");
		return;
	}
		
	
	}
	
	
	private static boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
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

	
@After
public void tearDown() throws Exception {
  driver.quit();
  String verificationErrorString = verificationErrors.toString();
  if (!"".equals(verificationErrorString)) {
    org.junit.Assert.fail(verificationErrorString);
  }
}
 	
}