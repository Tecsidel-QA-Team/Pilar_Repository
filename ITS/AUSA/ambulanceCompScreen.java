package AUSA;



import org.openqa.selenium.By;
import AUSA.ausaFieldsConfiguration;




public class ambulanceCompScreen extends ausaFieldsConfiguration{

		  
	  public static void ibAmbulance() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(ambLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("E:\\Selenium\\","ambulancia"+timet+".jpg");
		  takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","ambulancia.jpg");
		  Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_txt_Title_box_data")).sendKeys("Ambulance"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(2000);			
			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_txt_legajo_box_data")).sendKeys(+ranNumbr(10000,90000000)+"");			
			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_txt_vehid_box_data")).sendKeys(+ranNumbr(600000000,699999999)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_txt_phone_box_data")).sendKeys(ranYearNumbr(910000000,980000000)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_txt_driver_box_data")).sendKeys(personsT[ranYearNumbr(0,personsT.length-1)]+"");
			selectDropDownClick2("ctl00_ContentZone_ctrlAmbulance_cmb_movedTo_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlAmbulance_cmb_company_cmb_dropdown");
			ocupantesSection();
			Thread.sleep(1000);
			System.out.println("El Componente Ambulancia ha sido creado para la Parte No. "+partText);
			
	  }
	  	public static void ocupantesSection() throws Exception{	  		
	  		int ocuPant = ranYearNumbr(1,4);
	  		for (int ocu = 1; ocu<= ocuPant; ocu++){
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_BtnAddOccupants")).click();
	  			Thread.sleep(500);
	  		}
	  		String ocuPants = driver.findElement(By.xpath("//*[contains(@id,'ctl00_ContentZone_ctrlAmbulance_Ambulance')]")).getAttribute("id");
	  		int ocuPantNumber = Integer.parseInt(ocuPants.substring(41, 43));	  		
	  		int totalOcupant = ocuPantNumber + ocuPant;	
	  		if (ocuPant == 1){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			selectDropDownClick("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocuPantNumber+typeT);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocuPantNumber+phone)).sendKeys(ranYearNumbr(900000000,980000000)+"");
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocuPantNumber+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));	  			
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocuPantNumber+nameLast)).sendKeys(personsT[nameGender]);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocuPantNumber+home)).sendKeys("ESPAÑA");		
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocuPantNumber+other)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);

	  		}else{
	  		for (int ocup = ocuPantNumber; ocup<totalOcupant; ocup++){	  			
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			selectDropDownClick("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocup+typeT);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocup+phone)).sendKeys(ranYearNumbr(900000000,980000000)+"");
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocup+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));	  			
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocup+nameLast)).sendKeys(personsT[nameGender]);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocup+home)).sendKeys("ESPAÑA");		
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlAmbulance_Ambulance"+ocup+other)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);
	  			}
	  		}
	  		Thread.sleep(1000);	  		
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(3000);			 		
	  	}	
      	
}
