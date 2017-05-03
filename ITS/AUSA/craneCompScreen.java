package AUSA;



import org.openqa.selenium.By;




public class craneCompScreen extends ausaFieldsConfiguration{
	private static String nameLast = "_txt_name_box_data";	
	private static String comment = "_txt_comments_box_data";
	private static String DNI = "_txt_dni_box_data";
	private static String typeT = "_cmb_occupant_type_cmb_dropdown";
	
		  
	  public static void ibCrane() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(cranLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("grua.jpg");
		  Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_txt_Title_box_data")).sendKeys("Grúa"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_txt_vehid_box_data")).sendKeys(+ranNumbr(600000000,699999999)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_txt_dni_box_data")).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_txt_responsible_box_data")).sendKeys(personsT[ranYearNumbr(0,personsT.length-1)]+"");;
			selectDropDownClick("ctl00_ContentZone_ctrlCrane_cmb_plate_moved_cmb_dropdown");			
			selectDropDownClick("ctl00_ContentZone_ctrlCrane_cmb_address_cmb_dropdown");
			Thread.sleep(1000);
			ocupantesSection();		
			Thread.sleep(1000);
			System.out.println("El Componente Grúa ha sido creado para la Parte No. "+partText);
	  }
	  	public static void ocupantesSection() throws Exception{	  		
	  		int ocuPant = ranYearNumbr(1,4);
	  		for (int ocu = 1; ocu<= ocuPant; ocu++){
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_BtnAddOccupants")).click();
	  			Thread.sleep(500);
	  		}
	  		
	  		String ocuPants = driver.findElement(By.xpath("//*[contains(@id,'ctl00_ContentZone_ctrlCrane_Crane')]")).getAttribute("id");
	  		int ocuPantNumber = Integer.parseInt(ocuPants.substring(33, 35));
	  		int totalOcupant = ocuPantNumber + ocuPant;	
	  		if (ocuPant == 1){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_Crane"+ocuPantNumber+nameLast)).sendKeys(personsT[nameGender]);	
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_Crane"+ocuPantNumber+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_Crane"+ocuPantNumber+comment)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);

	  		}else{
	  		for (int ocup = ocuPantNumber; ocup<totalOcupant; ocup++){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);	  			
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_Crane"+ocup+nameLast)).sendKeys(personsT[nameGender]);	
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_Crane"+ocup+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlCrane_Crane"+ocup+comment)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);
	  			}
	  		}
	  		Thread.sleep(1000);	  		
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(3000);			 		
	  	}	
      	
}
