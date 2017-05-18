package AUSA;



import org.openqa.selenium.By;




public class securityCompScreen extends ausaFieldsConfiguration{
	private static String nameLast = "_txt_name_box_data";	
	private static String comment = "_txt_comments_box_data";
	private static String DNI = "_txt_dni_box_data";
	private static String typeT = "_cmb_occupant_type_cmb_dropdown";
	
		  
	  public static void ibSecurity() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(securLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);		  
		  Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_txt_Title_box_data")).sendKeys("Seguridad Vial"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(2000);
			selectDropDownClick("ctl00_ContentZone_ctrlSecurity_cmb_type_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_txt_responsible_box_data")).sendKeys(personsT[ranYearNumbr(0,personsT.length-1)]+"");;
			selectDropDownClick("ctl00_ContentZone_ctrlSecurity_cmb_mean_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_txt_legajo_box_data")).sendKeys(+ranNumbr(10000,90000000)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_txt_vehid_box_data")).sendKeys(+ranNumbr(600000000,699999999)+"");					
			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_txt_phone_box_data")).sendKeys(ranYearNumbr(910000000,980000000)+"");			
			ocupantesSection();	
			Thread.sleep(1000);
			System.out.println("El Componente Seguridad ha sido creado para la Parte No. "+partText);
	  }
	  	public static void ocupantesSection() throws Exception{	  		
	  		int ocuPant = ranYearNumbr(1,4);
	  		for (int ocu = 1; ocu<= ocuPant; ocu++){
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_BtnAddOccupants")).click();
	  			Thread.sleep(500);
	  		}
	  		
	  		String ocuPants = driver.findElement(By.xpath("//*[contains(@id,'ctl00_ContentZone_ctrlSecurity_Security')]")).getAttribute("id");
	  		int ocuPantNumber = Integer.parseInt(ocuPants.substring(39, 41));
	  		int totalOcupant = ocuPantNumber + ocuPant;	
	  		if (ocuPant == 1){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			selectDropDownClick("ctl00_ContentZone_ctrlSecurity_Security"+ocuPantNumber+typeT);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_Security"+ocuPantNumber+nameLast)).sendKeys(personsT[nameGender]);	
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_Security"+ocuPantNumber+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_Security"+ocuPantNumber+comment)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);

	  		}else{
	  		for (int ocup = ocuPantNumber; ocup<totalOcupant; ocup++){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			selectDropDownClick("ctl00_ContentZone_ctrlSecurity_Security"+ocup+typeT);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_Security"+ocup+nameLast)).sendKeys(personsT[nameGender]);	
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_Security"+ocup+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlSecurity_Security"+ocup+comment)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);
	  			}
	  		}
	  		Thread.sleep(1000);
	  		takeScreenShot("E:\\Selenium\\","Security"+timet+".jpg");
	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","Security"+timet+".jpg");
	  		Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(3000);			 		
	  	}	
      	
}
