package AUSA;

import java.io.File;
import java.io.FileOutputStream;
import AUSA.ausaFieldsConfiguration;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.*;

public class ausaCrearPartes extends ausaFieldsConfiguration{
	public static int i = 0;public static int volNumber;
	public static String [] cameraSelT = new String[i];
	public static boolean [] cameraOpt = new boolean[i];
	public static List <WebElement> mcCamerasS; public static int camCount = 0;	
	public static String parteNumber;public static String comTitle;
	public static int xll=0; public static String typeAcc; public static String [] options1 = new String [vOption.length];
	public static String typeImpact; public static String cAparente;
	public static WebElement newCom; public static String infoComp;public static String motiveSel;
	public static WebElement comMean; public static String obserGenerales;
	public static WebElement motiveD; public static String notaCentro;
	public static WebElement originC; public static String [] options = new String[dOption.length];
	public static boolean [] vOptionTSel = new boolean[vOption.length];
	public static boolean vOptionSel;
	public static int  [] vOptionNumber = new int[vOption.length] ;
	public static WebElement originC_DestinaC;public static boolean [] dOptionChecked = new boolean[dOption.length];
	public static WebElement importanceC;public static String vOptionChecked;	
	public static boolean errorCreate = false; public static String newComSel;
	public static boolean inciAcciSel = false; public static String matterCom;
	public static WebElement supervisorText; public static String supervisorText1;
	public static boolean supervT = false;public static String comMeanSel;
	public static String assignedText1;	public static WebElement assignedText;
	public static WebElement statusText; public static String statusText1;
	public static String beginDate;	public static String commentCom;
	public static String tempText1; public static String originSel;
	public static WebElement sevText;	public static String sevText1;
	public static WebElement priorText;	public static String priorText1;
	public static String typeText;public static String originC_DestSel;
	public static WebElement autopistaText;	public static String autopistaText1;
	public static WebElement bandaText;	public static String bandaText1;
	public static String PkmText;public static String importanceSel;
	public static String PkmText1;
	public static WebElement ramalsText; public static String ramalsText1;
	public static String locateText;
	public static String observacionesText;
	public static WebElement tipoAccidenteText; public static String tipoAccidenteText1;
	public static WebElement tipodeImpactoText; public static String tipodeImpactoText1;
	public static String causasText;
	public static  String informacionComText;
	public static String observacionesCompText;
	public static String vVolcadosT;
	public static String notadelcentroText;
	public static WebElement camarasText; public static String camarasText1;
	public static boolean fuegoT = false; public static boolean banquinaT = false;
	public static boolean instalacionesT = false; public static boolean vehiculosV = false;
	public static boolean motosT = false; public static boolean automovilesT = false;
	public static boolean camionesT = false; public static boolean autobusesT = false;
	public static boolean chartersT = false; 
	private static String verFile;
	    public static String mPartes;
	    public static String lPartes;
	    public static String currentWindowHandle;

 
 public static void setUp() throws Exception {
	 
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
 	public void ausaIssuescreate() throws Exception{
 		setUp();
 		driver.get(baseUrl);
		Actions action = new Actions (driver);
        
			if (driver.getPageSource().contains("No se puede acceder a este sitio web")|| driver.getPageSource().contains("Service Unavailable"))
        {                    
            fail("ITS NO ESTA DISPONIBLE");
            return;
        }			  			
			Thread.sleep(2000);
			borrarArchivosTemp("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\");
		takeScreenShot("E:\\Selenium\\","ausaLoginPageCrearPartes"+timet+".jpg");
  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\","ausaLoginPageCrearPartes"+timet+".jpg");			
	    driver.findElement(By.id("BoxLogin")).sendKeys("calidad");
        driver.findElement(By.id("BoxPassword")).sendKeys("calidad");
        driver.findElement(By.id("BtnLogin")).click();
        Thread.sleep(3000);
		takeScreenShot("E:\\Selenium\\","AusamPCrearPartes"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\","AusamPCrearPartes"+timet+".jpg");			        
        currentWindowHandle = driver.getWindowHandle();		                
        lPartes = driver.findElement(By.xpath("//div[7] / div / ul / li[5] / a")).getText();		                
        Thread.sleep(1000);
        WebElement Partes = driver.findElement(By.linkText(lPartes));		                
        action.clickAndHold(Partes).perform();
        Thread.sleep(2000);
        mPartes = driver.findElement(By.xpath("// div[7] / div / ul / li[5] / ul / li / a")).getText();		                
        driver.findElement(By.linkText(mPartes)).click();
        Thread.sleep(8000);
        takeScreenShot("E:\\Selenium\\","AusapPCrearPartes"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\","AusapPCrearPartes"+timet+".jpg");        
        ArrayList<String> wHandle = new ArrayList<String>(driver.getWindowHandles());
        
       for (String window : wHandle) {
        	Thread.sleep(600);
        	if (window != currentWindowHandle){
        		driver.switchTo().window(window);		                		

        	}
       }           
			Object Partes1 = mPartes;
			Assert.assertEquals(mPartes, Partes1);
        driver.findElement(By.id(createBtn)).click();
        Thread.sleep(3000);
        selectDropDownClick(templateSel);
        //new Select (driver.findElement(By.id(templateSel))).selectByVisibleText("Accidente");
        driver.findElement(By.id(templateBtn)).click();
        Thread.sleep(4000);               
        createPartes();
 	}
 	
 	
	public void createPartes() throws Exception{
		Thread.sleep(2000);
		ArrayList<String> wHandle = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wHandle.get(2));		                 			
			Object Partes1 = "#Partes";
       		Assert.assertEquals("#Partes", Partes1);
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
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
            Thread.sleep(2000);
            notEmptyDropDown(direcT); //Banda
            driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmKm_box_data")).sendKeys(ranNumbr(10,900)+"");//PKM
            driver.findElement(By.id("ctl00_ContentZone_ctlPkm_txt_PkmM_box_data")).sendKeys(ranNumbr(1,900)+""); // PKM ext.
            Thread.sleep(1000);
            notEmptyDropDown(ramalsT); //Ramal
            driver.findElement(By.id(locationT)).sendKeys("Buenos Aires"); //Localización
            Thread.sleep(1000);            
            datosSection();
            Thread.sleep(3000);
            ranclickOption(dOption, 1, dOption.length);
            Thread.sleep(1000);
            if (driver.findElement(By.id(dOption[4])).isSelected()){
            	volNumber = ranNumbr(1,99);
            	driver.findElement(By.id(vVolcado)).sendKeys(volNumber+"");
            }
            
            Thread.sleep(2000);
            if (tipoSel.equals("Incidente")|| tipoSel.equals("Accidente")){
            	ranclickOption(vOption, 1, vOption.length);
            	Thread.sleep(2000);
            	for (int  i = 1; i < vOption.length;i++){ 
            		if (driver.findElement(By.id(vOption[i])).isSelected()){
            			Thread.sleep(1000);
            			vOptionNumber[i] = ranNumbr(1,99);
            			driver.findElement(By.id(vOptionT[i])).sendKeys(vOptionNumber[i]+"");
            		}
            	}
            }	
            
            Thread.sleep(500);
            if (driver.findElements(By.id(communicationField)).size()!=0)
            {
                communicationSection();
            }else{
            	driver.findElement(By.id(observaT)).sendKeys("QA issue created by Automation Script"); //Observaciones
            }
            Thread.sleep(1000);
            takeScreenShot("E:\\Selenium\\","crearPartesDataScr"+timet+".jpg");
    		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\","crearPartesDataScr"+timet+".jpg");
            Thread.sleep(1500);
            grabarDatosFichero();
            Thread.sleep(1000);
            driver.findElement(By.id(issueCreateBtn)).click();
            Thread.sleep(2000);                        
            ArrayList<String> multipleTabs = new ArrayList<String>   (driver.getWindowHandles());            
            if (multipleTabs.size() > 2){
            String errorText = driver.findElement(By.xpath("//div[@class='toast-item toast-type-error']/p")).getText();
            	errorCreate = true;
            	crearFichero();
            	System.out.println("Ver Archivo de Datos " + verFile+timet+ " y reproducir error manualmente");
            	fail("ERROR EN CREAR PARTE: "+errorText);
            	return;            	
            }
            else{
            	errorCreate = false;
            	driver.switchTo().window(multipleTabs.get(1));
            	Partes1 = mPartes;
				Assert.assertEquals(mPartes, Partes1);
				WebElement table = driver.findElement(By.cssSelector("tbody tr td table#tableIssues.generalTable"));		
				String buscar1 = table.findElement(By.xpath("//table[@id='tableIssues']/tbody/tr[1]")).getAttribute("id");
  				parteNumber = buscar1.substring(6);
  				Thread.sleep(1000);
  				crearFichero();
            	System.out.println("Se ha creado parte No. "+parteNumber+" correctamente. Verificar archivo log "+verFile+timet+" con los datos creados");
            	Thread.sleep(1500);
            }
	}
	
	public void datosSection() throws Exception{
        Thread.sleep(1500);
        driver.findElement(By.id(datoBtn)).click();
    	Thread.sleep(1000);
        if (tipoSel.equals("Incidente")|| tipoSel.equals("Accidente")){        	
        	driver.findElement(By.id(typeAccidentes)).click();
        	Thread.sleep(500);
        	ranClick("ctl00_ContentZone_mc_typeOfAccident_ctl","",19,23);
        	Thread.sleep(400);
        	driver.findElement(By.id(typeImpacto)).click();
        	Thread.sleep(500);
        	ranClick("ctl00_ContentZone_mc_causal_ctl","",19,23);
        	Thread.sleep(500);
        }	
        driver.findElement(By.id("ctl00_ContentZone_txt_causes_box_data")).sendKeys("This was written by automation scrript for Test Purpose");
        driver.findElement(By.id("ctl00_ContentZone_txt_information_box_data")).sendKeys("This was written by automation scrript for Test Purpose");
        driver.findElement(By.id("ctl00_ContentZone_txt_observations_box_data")).sendKeys("This was written by automation scrript for Test Purpose");
        driver.findElement(By.id("ctl00_ContentZone_txt_note_box_data")).sendKeys("This was written by automation scrript for Test Purpose");
        Thread.sleep(500);
        driver.findElement(By.id(cameraSel)).click();
        Thread.sleep(500);     
        ranSelection("ctl00_ContentZone_mcCameras_ctl","ctl00_ContentZone_mcCameras_ctl".length());
        ranClick("ctl00_ContentZone_mcCameras_ctl","0",ad,caMer);
        Thread.sleep(600);
        driver.findElement(By.id(cameraSel)).click();
        Thread.sleep(1000);
 	}
	
	public void communicationSection() throws Exception{
		Thread.sleep(1000);
		driver.findElement(By.id(communicationField)).clear();
		driver.findElement(By.id(communicationField)).sendKeys("Communication"+" - "+ranNumbr(1,99)+" QA Automation" );
		Thread.sleep(500);
		selectDropDownClick(newCommunication);
		Thread.sleep(500);
		selectDropDownClick(medioField);
		Thread.sleep(500);
		selectDropDownClick(motiveField);
		Thread.sleep(500);
		selectDropDownClick(originDestination);
		Thread.sleep(2000);
			driver.findElement(By.id(observaT)).sendKeys("QA issue created by Automation Script"); //Observaciones
			Thread.sleep(1500);	
		notEmptyDropDown(originDest);		
		Thread.sleep(1000);
		originC = new Select(driver.findElement(By.id(originDestination))).getFirstSelectedOption();  
		originSel = originC.getText();
		 if (originSel==null){	
		 	originC_DestinaC = new Select (driver.findElement(By.id(originDest))).getFirstSelectedOption();
		 	originC_DestSel = originC_DestinaC.getText();
		 		if (originC_DestSel != null){
		 			driver.findElement(By.id(observaT)).clear();
		 			driver.findElement(By.id(observaT)).sendKeys(originC_DestSel); //Observaciones
		 		}
		 	}
	     Thread.sleep(1500);
		selectDropDownClick(importanceField);
		Thread.sleep(500);
		driver.findElement(By.id(subjectField)).sendKeys("Created by Automation Script");
		driver.findElement(By.id(commentField)).sendKeys("This Communication was created by an automation script for testing purpose");
		Thread.sleep(2000);
		
	}
	public static void grabarDatosFichero() throws Exception{
			beginDate = driver.findElement(By.id("ctl00_ContentZone_dt_opentime_box_date")).getAttribute("value");
			tempText1 = driver.findElement(By.id("ctl00_ContentZone_txt_template_box_data")).getAttribute("value");
			sevText = new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_severity_cmb_dropdown"))).getFirstSelectedOption();
			sevText1 = sevText.getText();
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
			Thread.sleep(1000);	  					
			if (typeText.equals("Incidente") || typeText.equals("Accidente")){
				typeAcc = driver.findElement(By.id("ctl00_ContentZone_mc_typeOfAccident_txt_selected")).getAttribute("value");	  									
				typeImpact = driver.findElement(By.id("ctl00_ContentZone_mc_causal_txt_selected")).getAttribute("value");		  					
				
			}
			cAparente = driver.findElement(By.id("ctl00_ContentZone_txt_causes_box_data")).getAttribute("value");
						if (cAparente == null){
								cAparente = "";
						}
			infoComp = driver.findElement(By.id("ctl00_ContentZone_txt_information_box_data")).getAttribute("value");
					if (infoComp == null){
								infoComp = "";
					}
			obserGenerales = driver.findElement(By.id("ctl00_ContentZone_txt_observations_box_data")).getAttribute("value");
					if (obserGenerales == null){
							obserGenerales = "";
					}
			notaCentro = driver.findElement(By.id("ctl00_ContentZone_txt_note_box_data")).getAttribute("value");
					if (notaCentro == null){
						notaCentro = "";
					}
					mcCamerasS = driver.findElements(By.xpath("//*[contains(@id, 'ctl00_ContentZone_mcCameras_ctl')]"));
					cameraOpt  = new boolean [mcCamerasS.size()];
					cameraSelT = new String[mcCamerasS.size()];
					String [] del2 = new String[mcCamerasS.size()];
					driver.findElement(By.id(cameraSel)).click();
		            	for (i = 0; i<= mcCamerasS.size()-1;i++){		            		
		            		del2 [i] = mcCamerasS.get(i).getAttribute("id");
		            		cameraOpt[i] = driver.findElement(By.xpath("//*[@id="+"'"+del2[i]+"'"+"]")).isSelected();
		            		if (cameraOpt[i]){
		            			camCount = camCount + 1;
		            			cameraSelT[i]=driver.findElement(By.xpath("//label[@for="+"'"+del2[i]+"'"+"]")).getText();
		            		}
		            	}
		            	Thread.sleep(1000);
		            	driver.findElement(By.id(cameraSel)).click();
			for (i = 1; i < dOption.length;i++){
					options[i] = driver.findElement(By.xpath("//label[@for="+"'"+dOption[i]+"'"+"]")).getText();
					dOptionChecked[i] = driver.findElement(By.id(dOption[i])).isSelected();
					if (options[i].equals("Vehículos volcados")){	  									  								
						vVolcadosT = "Vehiculos volcados";
					}
				}
			
			if (typeText.equals("Incidente") || typeText.equals("Accidente")){
				for (int i = 1; i < vOption.length;i++){
					options1[i] = driver.findElement(By.xpath("//label[@for="+"'"+vOption[i]+"'"+"]")).getText();
					vOptionTSel[i] = driver.findElement(By.id(vOption[i])).isSelected();					
					}
			if (driver.findElements(By.id(communicationField)).size()!=0){	
				comTitle = driver.findElement(By.id(communicationField)).getAttribute("value");
				newCom = new Select(driver.findElement(By.id(newCommunication))).getFirstSelectedOption();
				newComSel = newCom.getText();
				 if (newComSel.equals(null)){
					 newComSel = "";
				 }
				 comMean = new Select(driver.findElement(By.id(medioField))).getFirstSelectedOption();
				 comMeanSel = comMean.getText();
					 if (comMeanSel.equals(null)){
						 comMeanSel = "";
					 }
					 motiveD = new Select(driver.findElement(By.id(motiveField))).getFirstSelectedOption();
					 motiveSel = motiveD.getText();
						 if (motiveSel.equals(null)){
							 motiveSel = "";
						 } 
				    originC = new Select(driver.findElement(By.id(originDestination))).getFirstSelectedOption();  
					originSel = originC.getText();
					 	if (originSel.equals(null)){
					 		originSel = "";
					 	}
					 if (originSel!=null){	
					 	originC_DestinaC = new Select (driver.findElement(By.id(originDest))).getFirstSelectedOption();
					 	originC_DestSel = originC_DestinaC.getText();
					 		if (originC_DestSel.equals(null)){
					 			originC_DestSel = "";
					 		}
					 	}else{
					 		originC_DestSel = "";
					 	}
					 	importanceC = new Select (driver.findElement(By.id(importanceField))).getFirstSelectedOption();
					 		importanceSel = importanceC.getText();
					 			if (importanceSel.equals(null)){
					 				importanceSel = "";
					 			}
					 	matterCom = driver.findElement(By.id(subjectField)).getAttribute("value");
					 	commentCom = driver.findElement(By.id(commentField)).getAttribute("value");
						}
					}
			
	}
		public static void crearFichero() throws Exception {
			if (errorCreate){
				verFile = "crearPartesResultdosErrFile_";
			} else{
				verFile = "crearPartesResultadosSuccess_";
			}
			File result = new File("E:\\Selenium\\"+verFile+timet+".txt");			
			File resultTmp = new File("E:\\workspace\\Pilar_Repository\\ausaCrearPartes\\attachments\\"+verFile+timet+".txt");				
				FileOutputStream fis = new FileOutputStream(new File(result.toString()));
				FileOutputStream fis2 = new FileOutputStream(new File(resultTmp.toString()));
				PrintStream out = new PrintStream(fis);
				PrintStream out2 = new PrintStream(fis2);
				PrintStream old = System.out;
				System.setOut(out);
				System.setOut(out2);
			if (parteNumber!=null){
				System.out.println("#Parte: "+parteNumber);
			}									
			System.out.println("Fecha Inicio: "+beginDate);
			System.out.println("Plantilla: "+tempText1);
			System.out.println("Gravedad: "+sevText1);
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
			if (typeText.equals("Incidente") || typeText.equals("Accidente")){
				System.out.println("Tipo de Accidentes: "+ typeAcc);
				System.out.println("Tipo de Impacto: "+typeImpact);
			}
			System.out.println("Causas Aparentes del Hecho: "+cAparente);
			System.out.println("Información complementaria: "+infoComp);
			System.out.println("Observaciones Generales: "+obserGenerales);
			System.out.println("Nota del centro de operaciones: "+notaCentro);
    			if (camCount > 1){
    				System.out.print("Camaras Seleccionadas: ");
    			}else{
    				System.out.print("Camara Seleccionada: ");
    			}
			for (i = 0; i<= mcCamerasS.size()-1;i++){
				if (cameraOpt[i]){
						if (camCount > 1){
							System.out.print(cameraSelT[i]+"; ");
						}else{
							System.out.print(cameraSelT[i]);
						}
        			}
			}
			System.out.println("");
			System.out.println("");
			for (i = 1; i < dOption.length;i++){
				if (dOptionChecked[i]){
					if (!options[i].equals("Vehículos volcados")){
						System.out.print("x"+options[i]+"    ");
					}
						if (options[i].equals("Vehículos volcados")){	  									  								
							System.out.print("xVehículos volcados"+ ": "+ volNumber);
						}
						}else{
							System.out.print(options[i]+"    ");
					}
				}
			System.out.println("");
			if (typeText.equals("Incidente") || typeText.equals("Accidente")){
				for (int i = 1; i < vOption.length;i++){
					if (vOptionTSel[i]){	  			  					
							System.out.print("x"+options1[i]+": "+vOptionNumber[i]+"    ");  			  							  			  							
							}else{
								System.out.print(options1[i]+"    ");
						}  			  				
				}
			}
			if (driver.findElements(By.id(communicationField)).size()!=0){
				System.out.println("");
				System.out.println("");
					 	System.out.println ("Titulo de Comunicación: "+comTitle);
					 	System.out.println("Tipo de Comunicación: "+newComSel);
					 	System.out.println("Medio de Comunicación: "+comMeanSel);
					 	System.out.println("Motivo de Comunicación: "+motiveSel);
					 	System.out.println("Tipo Origen Destion: "+originSel);
					 	System.out.println("Origen/Destino: "+originC_DestSel);
					 	System.out.println("Importancia: "+importanceSel);
					 	System.out.println("Asunto: "+matterCom);
					 	System.out.println("Observaciones: "+commentCom);
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
}