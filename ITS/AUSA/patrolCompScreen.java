package AUSA;



import org.openqa.selenium.By;




public class patrolCompScreen extends ausaFieldsConfiguration{
	public static String nameLast = "_txt_name_box_data";	
	public static String comment = "_txt_comments_box_data";
		  
	  public static void ibPatrol() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(patroLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("patrol.jpg");
		  Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_Title_box_data")).sendKeys("Seguridad Vial"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_vehid_box_data")).sendKeys(+ranNumbr(600000000,699999999)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_legajo_box_data")).sendKeys(+ranNumbr(10000,90000000)+"");						
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_phone_box_data")).sendKeys(ranYearNumbr(910000000,980000000)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_responsible_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_responsible_box_data")).sendKeys(personsT[ranYearNumbr(0,personsT.length-1)]+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_txt_driver_box_data")).sendKeys(personsT[ranYearNumbr(0,personsT.length-1)]+"");
			ocupantesSection();
			Thread.sleep(1000);
			System.out.println("El Componente Patrulla ha sido creado para la Parte No. "+partText);
			
	  }
	  	public static void ocupantesSection() throws Exception{	  		
	  		int ocuPant = ranYearNumbr(1,4);
	  		for (int ocu = 1; ocu<= ocuPant; ocu++){
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_BtnAddOccupants")).click();
	  			Thread.sleep(500);
	  		}
	  		
	  		String ocuPants = driver.findElement(By.xpath("//*[contains(@id,'ctl00_ContentZone_ctrlPatrol_Patrol')]")).getAttribute("id");
	  		int ocuPantNumber = Integer.parseInt(ocuPants.substring(35, 37));
	  		int totalOcupant = ocuPantNumber + ocuPant;	
	  		if (ocuPant == 1){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_Patrol"+ocuPantNumber+nameLast)).sendKeys(personsT[nameGender]);	  					
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_Patrol"+ocuPantNumber+comment)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);

	  		}else{
	  		for (int ocup = ocuPantNumber; ocup<totalOcupant; ocup++){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_Patrol"+ocup+nameLast)).sendKeys(personsT[nameGender]);	  					
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlPatrol_Patrol"+ocup+comment)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);
	  			}
	  		}
	  		Thread.sleep(1000);	  		
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(3000);			 		
	  	}	
      	
}
