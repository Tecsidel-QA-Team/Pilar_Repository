package AUSA;

import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import AUSA.ausaFieldsConfiguration;
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


public class ausaAddComm extends ausaFieldsConfiguration{
	public static int i = 0;
	public static int xll=0;
	public static WebElement newCom;
	public static String newComSel;	
	public static WebElement comMean; public static String comMeanSel;
	public static String comTitle;	
	public static WebElement motiveD;	public static String motiveSel;
	public static WebElement originC;	public static String originSel;	
	public static WebElement originC_DestinaC;	public static String originC_DestSel;
	public static WebElement importanceC;	public static String importanceSel;
	public static String matterCom;
	public static String commentCom;
	public static String verFile;
	
	
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
			  			borrarArchivosTemp("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\");			  			
			  			takeScreenShot("E:\\Selenium\\","ausaLoginPage"+timet+".jpg");
			  			takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaAgregarComPartes\\attachments\\","ausaLoginPage_"+timet+".jpg");
			  	        driver.findElement(By.id("BoxLogin")).sendKeys("calidad");
		                driver.findElement(By.id("BoxPassword")).sendKeys("calidad");
		                driver.findElement(By.id("BtnLogin")).click();
		                Thread.sleep(3000);
		                takeScreenShot("E:\\Selenium\\","AusamP"+timet+".jpg");
			  			takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaAgregarComPartes\\attachments\\","AusamP"+timet+".jpg");		                
		                String currentWindowHandle = driver.getWindowHandle();		                
		                String lPartes = driver.findElement(By.xpath("//div[7] / div / ul / li[5] / a")).getText();		                
		                Thread.sleep(1000);
		                WebElement Partes = driver.findElement(By.linkText(lPartes));		                
		                action.clickAndHold(Partes).perform();
		                Thread.sleep(2000);
		                String mPartes = driver.findElement(By.xpath("// div[7] / div / ul / li[5] / ul / li / a")).getText();		                
		                driver.findElement(By.linkText(mPartes)).click();
		                Thread.sleep(8000);
		                takeScreenShot("E:\\Selenium\\","AusapP"+timet+".jpeg");
			  			takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaAgregarComPartes\\attachments\\","AusapP"+timet+".jpg");
		               
		                
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
		                e.printStackTrace();//System.out.println(e.getStackTrace());
		                return;
		            }
	  }   
	  				
					public static void buscarElement() throws Exception{
	  					Thread.sleep(1000);
	  					WebElement table = driver.findElement(By.cssSelector("tbody tr td table#tableIssues.generalTable"));
	  					List <WebElement> tableCount = table.findElements(By.tagName("tr"));
	  					ArrayList<String> addComm = new ArrayList<String>();
	  					int x = 0;
	  					do{		  						
	  						for ( i = 1; i  <=  tableCount.size(); i++){	  							
	  							String buscar1 = table.findElement(By.xpath("//table[@id='tableIssues']/tbody/tr"+"["+i+"]/td[16]/input[3]")).getAttribute("id");  							
	  							if (buscar1.contains("addComm")){	  								
	  								addComm.add(buscar1); 
	  								x = x+1;
	  							}
	  						}
	  							Thread.sleep(500);
	  					}while (i < tableCount.size());
	  					Random xl = new Random();
	  					for (i = 1; i < addComm.size(); i++){
  							xll = xl.nextInt(addComm.size())+1;
  							if (xll > addComm.size()-1){
  								xll = xll -1;
  							}
  							if (xll < 0){
  								xll = 0;
  							}
	  					}
	  					driver.findElement(By.id(addComm.get(xll))).click();
	  					Thread.sleep(2000);
	  					createCommunication();
	  					Thread.sleep(1000);
	  					grabarFichero();  
	  					Thread.sleep(1000);
	  					crearFichero();
	  					Thread.sleep(1000);
	  					System.out.println ("Se ha creado una Comunicación a la parte "+ addComm.get(xll).substring(8) + " y se ha creado un Archivo Log " +verFile+timet+" con los datos agregados");
	  				}
	  				
	  				public static void createCommunication() throws Exception{
	  					Thread.sleep(1000);
	  					driver.switchTo().frame(0);
	  					driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_Title_box_data")).clear();
	  					driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_Title_box_data")).sendKeys("Communication"+" - "+ranNumbr(1,99)+" QA Automation" );
	  					Thread.sleep(500);
	  					selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_type_cmb_dropdown");
	  					Thread.sleep(500);
	  					selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_mean_cmb_dropdown");
	  					Thread.sleep(500);
	  					selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_motive_cmb_dropdown");
	  					Thread.sleep(1000);
	  					selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_type_ori_des_cmb_dropdown");
	  					Thread.sleep(1000);
	  					notEmptyDropDown("ctl00_ContentZone_ctrlComunication_cmb_ori_des_cmb_dropdown");		
	  					Thread.sleep(1000);	  				    
	  					selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_importance_cmb_dropdown");
	  					Thread.sleep(500);
	  					driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_subject_box_data")).sendKeys("Created by Automation Script");
	  					driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_comment_box_data")).sendKeys("This Communication was created by an automation script for testing purpose");
	  					Thread.sleep(1000);
	  					//takeScreenShot("addCommScr_"+timet+".jpeg");
	  					Thread.sleep(500);
	  					
	  				}
	  				
	  				public static void grabarFichero() throws Exception{
	  					Thread.sleep(1500);
	  					comTitle = driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_Title_box_data")).getAttribute("value");
	  					newCom = new Select(driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_cmb_type_cmb_dropdown"))).getFirstSelectedOption();
	  					newComSel = newCom.getText();
	  					 if (newComSel.equals(null)){
	  						 newComSel = "";
	  					 }
	  					 comMean = new Select(driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_cmb_mean_cmb_dropdown"))).getFirstSelectedOption();
	  					 comMeanSel = comMean.getText();
	  						 if (comMeanSel.equals(null)){
	  							 comMeanSel = "";
	  						 }
	  						 motiveD = new Select(driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_cmb_motive_cmb_dropdown"))).getFirstSelectedOption();
	  						 motiveSel = motiveD.getText();
	  							 if (motiveSel.equals(null)){
	  								 motiveSel = "";
	  							 } 
	  					    originC = new Select(driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_cmb_type_ori_des_cmb_dropdown"))).getFirstSelectedOption();  
	  						originSel = originC.getText();
	  						 	if (originSel.equals(null)){
	  						 		originSel = "";
	  						 	}
	  						 if (originSel!=null){	
	  						 	originC_DestinaC = new Select (driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_cmb_ori_des_cmb_dropdown"))).getFirstSelectedOption();
	  						 	originC_DestSel = originC_DestinaC.getText();
	  						 		if (originC_DestSel.equals(null)){
	  						 			originC_DestSel = "";
	  						 		}
	  						 	}else{
	  						 		originC_DestSel = "";
	  						 	}
	  						 	importanceC = new Select (driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_cmb_importance_cmb_dropdown"))).getFirstSelectedOption();
	  						 		importanceSel = importanceC.getText();
	  						 			if (importanceSel.equals(null)){
	  						 				importanceSel = "";
	  						 			}
	  						 	matterCom = driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_subject_box_data")).getAttribute("value");
	  						 	commentCom = driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_comment_box_data")).getAttribute("value");
	  						 	Thread.sleep(1000);	  						 	  						 
	  						 	driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
	  						 	Thread.sleep(500);
	  							}
	  					
	  					public static void crearFichero() throws Exception{
	  						Thread.sleep(500);
	  						verFile = "addComArchivo_";
	  						File result = new File("E:\\Selenium\\"+verFile+timet+".txt");
	  						File resultTmp = new File("E:\\workspace\\Pilar_Repository\\ausaAgregarComPartes\\attachments\\"+verFile+timet+".txt");	  						
	  						FileOutputStream fis = new FileOutputStream(new File(result.toString()));
	  						FileOutputStream fis2 = new FileOutputStream(new File(resultTmp.toString()));
	  						PrintStream out = new PrintStream(fis);
	  						PrintStream out2 = new PrintStream(fis2);
	  						PrintStream old = System.out;
	  						System.setOut(out);
	  						System.setOut(out2);
	  						System.out.println ("Titulo de Comunicación: "+comTitle);
						 	System.out.println("Tipo de Comunicación: "+newComSel);
						 	System.out.println("Medio de Comunicación: "+comMeanSel);
						 	System.out.println("Motivo de Comunicación: "+motiveSel);
						 	System.out.println("Tipo Origen Destion: "+originSel);
						 	System.out.println("Origen/Destino: "+originC_DestSel);
						 	System.out.println("Importancia: "+importanceSel);
						 	System.out.println("Asunto: "+matterCom);
						 	System.out.println("Observaciones: "+commentCom);
							fis.close();
	  						System.out.flush();
	  						System.setOut(old);
	  						
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
  
  private static boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
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