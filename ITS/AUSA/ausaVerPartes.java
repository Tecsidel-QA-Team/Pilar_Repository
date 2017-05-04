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


public class ausaVerPartes extends ausaFieldsConfiguration{
	public static int i = 0;
	public static int xll=0;
	public static boolean inciAcciSel = false;
	public static WebElement supervisorText; public static String supervisorText1;
	public static boolean supervT = false;
	public static String assignedText1;	public static WebElement assignedText;
	public static String partPadreText;
	public static WebElement statusText; public static String statusText1;
	public static String origenText;
	public static String beginDate;
	public static String endDate;
	public static WebElement tempText;	public static String tempText1;
	public static WebElement sevText;	public static String sevText1;
	public static String createdByText;
	public static String updatedByText;
	public static WebElement priorText;	public static String priorText1;
	public static String typeText;
	public static WebElement autopistaText;	public static String autopistaText1;
	public static WebElement bandaText;	public static String bandaText1;
	public static String PkmText;
	public static String PkmText1;
	public static WebElement ramalsText; public static String ramalsText1;
	public static String locateText;
	public static String observacionesText;
	public static WebElement tipoAccidenteText; public static String tipoAccidenteText1;
	public static WebElement tipodeImpactoText; public static String tipodeImpactoText1;
	public static String causasText;
	public static  String informacionComText;
	public static String observacionesCompText;
	public static String notadelcentroText;
	public static WebElement camarasText; public static String camarasText1;
	public static boolean fuegoT = false; public static boolean banquinaT = false;
	public static boolean instalacionesT = false; public static boolean vehiculosV = false;
	public static boolean motosT = false; public static boolean automovilesT = false;
	public static boolean camionesT = false; public static boolean autobusesT = false;
	public static boolean chartersT = false; 
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
			  			takeScreenShot("ausaLoginPage.jpeg");
			  	        driver.findElement(By.id("BoxLogin")).sendKeys("calidad");
		                driver.findElement(By.id("BoxPassword")).sendKeys("calidad");
		                driver.findElement(By.id("BtnLogin")).click();
		                Thread.sleep(3000);
		                takeScreenShot("AusamP.jpeg");
		                String currentWindowHandle = driver.getWindowHandle();		                
		                String lPartes = driver.findElement(By.xpath("//div[7] / div / ul / li[5] / a")).getText();		                
		                Thread.sleep(1000);
		                WebElement Partes = driver.findElement(By.linkText(lPartes));		                
		                action.clickAndHold(Partes).perform();
		                Thread.sleep(2000);
		                String mPartes = driver.findElement(By.xpath("// div[7] / div / ul / li[5] / ul / li / a")).getText();		                
		                driver.findElement(By.linkText(mPartes)).click();
		                Thread.sleep(8000);
		                
		                takeScreenShot("AusapP.jpeg");
		                
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
		                	JavascriptExecutor js = (JavascriptExecutor) driver;		              		                	                		                
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
		                        js.executeScript ("window.scrollBy(2100,0)", "");
		                        Thread.sleep(3000);

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
	  					do{	
	  						Random xl = new Random();
	  						for ( i = 1; i <= tableCount.size(); i++){
	  							xll = xl.nextInt(tableCount.size())+1;
	  							if (xll > i){
	  								xll = xll -1;
	  							}
		  					}
	  						String buscar1 = table.findElement(By.xpath("//table[@id='tableIssues']/tbody/tr"+"["+xll+"]")).getAttribute("id");
	  						String viewClick = buscar1.substring(5);
	  						driver.findElement(By.id("view"+viewClick)).click();
	  						Thread.sleep(5000);		  					
	  					}while (i < tableCount.size());
	  					Thread.sleep(2000);
	  					viewElementContents();  
	  					Thread.sleep(1000);
	  					System.out.println ("El Archivo "+verFile+timet+" ha sido creado");
	  					
	  				}
	  				
	  				public static void viewElementContents() throws Exception{
	  					Thread.sleep(2000);
		                String currentWindowHandle = driver.getWindowHandle();		                
	  					ArrayList<String> wHandle = new ArrayList<String>(driver.getWindowHandles());
	  					for (String window : wHandle) {
		                	Thread.sleep(600);
		                	if (window != currentWindowHandle){
		                		driver.switchTo().window(window);		                		
		                	}
		               }
	  			        Object Partes1 = "#Partes";	  			        
	  			        Assert.assertEquals("#Partes", Partes1);
	  			        driver.switchTo().defaultContent();	  			        
	  			        Thread.sleep(1000);
	  					partText = driver.findElement(By.id("ctl00_ContentZone_txt_id_box_data")).getAttribute("value");
	  					Thread.sleep(1000);
	  					partPadreText = driver.findElement(By.id("ctl00_ContentZone_lnb_parent")).getAttribute("value");
	  					if (partPadreText == null){
	  						partPadreText = "";
	  					}
	  					Thread.sleep(1000);
	  					statusText = new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_status_cmb_dropdown"))).getFirstSelectedOption();
	  					statusText1 = statusText.getText();
	  					origenText = driver.findElement(By.id("ctl00_ContentZone_txt_creationMode_box_data")).getAttribute("value");
	  					beginDate = driver.findElement(By.id("ctl00_ContentZone_dt_opentime_box_date")).getAttribute("value");
	  					endDate = driver.findElement(By.id("ctl00_ContentZone_dt_closetime_box_date")).getAttribute("value");
	  					Thread.sleep(1000);
	  					String templeClass = driver.findElement(By.xpath("//*[contains(@name, '_template$')]")).getAttribute("class");	  					
	  					if (templeClass.equals ("generalDropdown")){
	  						tempText = new Select(driver.findElement(By.id(templateSel))).getFirstSelectedOption();
	  						tempText1 = tempText.getText();	  						
	  					}	  				
	  					if (templeClass.equals("readonlyBox")){
	  						if (driver.findElements(By.id(templateSel)).size()!=0){
	  							tempText1 = templeClass = driver.findElement(By.id(templateSel)).getAttribute("value");
	  						}else{
	  							tempText1 = templeClass = driver.findElement(By.id("ctl00_ContentZone_txt_template_box_data")).getAttribute("value");
	  						}
	  					}
	  					sevText = new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_severity_cmb_dropdown"))).getFirstSelectedOption();
	  					sevText1 = sevText.getText();
	  					createdByText = driver.findElement(By.id("ctl00_ContentZone_txt_creator_box_data")).getAttribute("value");
	  					updatedByText = driver.findElement(By.id("ctl00_ContentZone_txt_updated_box_data")).getAttribute("value");
	  					priorText = new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_priority_cmb_dropdown"))).getFirstSelectedOption();
	  					priorText1 = priorText.getText();
	  					typeText = driver.findElement(By.id("ctl00_ContentZone_txt_type_box_data")).getAttribute("value");
	  					assignedText = new Select(driver.findElement(By.id(asignadoT))).getFirstSelectedOption();
	  					assignedText1 = assignedText.getText();
	  					locateText = driver.findElement(By.id("ctl00_ContentZone_txt_location_box_data")).getAttribute("value");
	  					autopistaText = new Select(driver.findElement(By.id(tValoresT))).getFirstSelectedOption();
	  					autopistaText1 = autopistaText.getText();
	  					bandaText = new Select(driver.findElement(By.id(direcT))).getFirstSelectedOption();
	  					bandaText1 = bandaText.getText();
	  					PkmText = driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmKm_box_data")).getAttribute("value");
	  					PkmText1 = driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmM_box_data")).getAttribute("value");
	  					ramalsText = new Select(driver.findElement(By.id(ramalsT))).getFirstSelectedOption();
	  					ramalsText1 = ramalsText.getText();
	  					observacionesText = driver.findElement(By.id("ctl00_ContentZone_txt_comments_box_data")).getAttribute("value");
	  					if (driver.findElements(By.id(supervisorT)).size()!=0){
	  						supervisorText = new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_assigned_cmb_dropdown"))).getFirstSelectedOption();	  						
		  					supervisorText1 = supervisorText.getText();
		  					supervT = true;
	  		            }
	  					verFile = "verPartesResultados_";
	  					File result = new File("E:\\Selenium\\"+verFile+timet+".txt");
	  					FileOutputStream fis = new FileOutputStream(new File(result.toString()));	  					
	  					PrintStream out = new PrintStream(fis);
	  					PrintStream old = System.out;
	  					System.setOut(out);
	  					System.out.println("#Parte: "+partText);
	  					System.out.println("Padre Parte: "+partPadreText);
	  					System.out.println("Estado: "+statusText1);
	  					System.out.println("Origen: "+origenText);
	  					System.out.println("Fecha Inicio: "+beginDate);
	  					System.out.println("Plantilla: "+tempText1);
	  					System.out.println("Gravedad: "+sevText1);
	  					System.out.println("Creado Por: "+createdByText);
	  					System.out.println("Modificado Por: "+updatedByText);
	  					System.out.println("Fecha Cierre: "+endDate);
	  					System.out.println("Prioridad: "+priorText1);
	  					System.out.println("Tipo: "+typeText);
	  					System.out.println("Asignado: "+assignedText1);
	  					if (supervT){
	  						System.out.println("Supervisor: "+supervisorText1);
	  					}	  					
	  					System.out.println("Autopista: "+autopistaText1);
	  					System.out.println("Banda: "+bandaText1);
	  					System.out.println("PKM(Km+m): "+PkmText+"+"+PkmText1);
	  					System.out.println("Ramales: "+ramalsText1);
	  					System.out.println("Localización: "+locateText);
	  					System.out.println("Observaciones: "+observacionesText);
	  					Thread.sleep(1000);	  					
	  					driver.findElement(By.id(datoBtn)).click();
	  					if (typeText.equals("Incidente") || typeText.equals("Accidente")){
	  						String typeAcc = driver.findElement(By.id("ctl00_ContentZone_mc_typeOfAccident_txt_selected")).getAttribute("value");	  					
		  					System.out.println("Tipo de Accidentes: "+ typeAcc);
		  					String typeImpact = driver.findElement(By.id("ctl00_ContentZone_mc_causal_txt_selected")).getAttribute("value");		  					
		  					System.out.println("Tipo de Impacto: "+typeImpact);
	  					}
	  					String cAparente = driver.findElement(By.id("ctl00_ContentZone_txt_causes_box_data")).getAttribute("value");
	  								if (cAparente == null){
	  										cAparente = "";
	  								}
	  					System.out.println("Causas Aparentes del Hecho: "+cAparente);
	  					
	  					String infoComp = driver.findElement(By.id("ctl00_ContentZone_txt_information_box_data")).getAttribute("value");
									if (infoComp == null){
												infoComp = "";
									}
						System.out.println("Información complementaria: "+infoComp);
						
						String obserGenerales = driver.findElement(By.id("ctl00_ContentZone_txt_observations_box_data")).getAttribute("value");
									if (obserGenerales == null){
											obserGenerales = "";
									}
						System.out.println("Observaciones Generales: "+obserGenerales);
						
						String notaCentro = driver.findElement(By.id("ctl00_ContentZone_txt_note_box_data")).getAttribute("value");
						if (notaCentro == null){
								notaCentro = "";
						}
						System.out.println("Nota del centro de operaciones: "+notaCentro);
						
	  					for (i = 1; i < dOption.length;i++){
		  					String options = driver.findElement(By.xpath("//label[@for="+"'"+dOption[i]+"'"+"]")).getText();
		  					String dOptionChecked = driver.findElement(By.id(dOption[i])).getAttribute("checked");	  					
		  					if (dOptionChecked != null){
		  						if (!options.equals("Vehículos volcados")){
		  							System.out.print("x"+options+"    ");
		  						}
		  							if (options.equals("Vehículos volcados")){	  									  								
		  								System.out.print("xVehículos volcados"+ ": "+ driver.findElement(By.id(vVolcado)).getAttribute("value"));
		  							}
		  							}else{
		  								System.out.print(options+"    ");
		  						}
		  					}
	  					System.out.println("");
	  					if (typeText.equals("Incidente") || typeText.equals("Accidente")){
  							for (int i = 1; i < vOption.length;i++){
  								String options = driver.findElement(By.xpath("//label[@for="+"'"+vOption[i]+"'"+"]")).getText();
  								String vOptionChecked = driver.findElement(By.id(vOption[i])).getAttribute("checked");	  					
  			  					if (vOptionChecked != null){	  			  					
  			  							System.out.print("x"+options+": " +driver.findElement(By.id(vOptionT[i])).getAttribute("value")+"    ");  			  							  			  							
  			  							}else{
  			  								System.out.print(options+"    ");
  			  						}  			  				
  							}
  							
  							System.out.println("");
  						}
	  					WebElement table = driver.findElement(By.xpath("//table[@id='ctl00_ContentZone_TblComponent']"));
	  					List<WebElement> tablC = table.findElements(By.tagName("tr"));	  					
	  					for (int i = 1; i <= tablC.size(); i++){
	  						if (i == 1){
	  							WebElement head1 = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_A']"));
	  							List <WebElement> headtd = head1.findElements(By.tagName("td"));	  							
	  								for (int x = 1; x<=headtd.size(); x++){
	  									String td1 = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_A']/td"+"["+x+"]")).getText();
	  									System.out.printf("%-30s", td1);	  									
	  								}
	  								System.out.println(" ");
	  								for (int a = 1; a <=200; a++){
	  									System.out.print("-");
	  								}
	  								System.out.println(" ");
	  						}
	  							if (i > 1){
	  							WebElement component = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_TblComponent']/tbody/tr"+"["+i+"]"));
	  							List <WebElement> componenttd = component.findElements(By.tagName("td"));
	  								for (int x = 1; x <= componenttd.size();x++){
	  									String td1 = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_TblComponent']/tbody/tr"+"["+i+"]"+"/td"+"["+x+"]")).getText();
	  									System.out.printf("%-30s", td1);
	  									if (x == 7){
	  										System.out.println(" ");
	  									}
	  									
	  										}
		  								}
	  							
	  						}
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