package AUSA;



import org.openqa.selenium.By;



public class calzadaCompScreen extends ausaFieldsConfiguration{
	  
	  public static void ibCalzada() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(roadLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("calzada.jpg");
        Thread.sleep(1000);        
			driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_txt_Title_box_data")).sendKeys("Calzada"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(500);
			selectDropDownClick("ctl00_ContentZone_ctrlRoadway_cmb_status_cmb_dropdown");
			Thread.sleep(100);
			driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_mc_roadCleaning_img_expand")).click();
			ranSelection("ctl00_ContentZone_ctrlRoadway_mc_roadCleaning_ctl",51);
			ranClick("ctl00_ContentZone_ctrlRoadway_mc_roadCleaning_ctl","0",ad,caMer);
			driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_txt_road_free_box_data")).sendKeys(ranNumbr(1,9)+"");
	        driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_txt_numRoadClose_box_data")).sendKeys(ranNumbr(1,20)+"");
	        driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_mc_highwayDamage_img_expand")).click();
	        Thread.sleep(100);	        
			ranSelection("ctl00_ContentZone_ctrlRoadway_mc_highwayDamage_ctl",52);
			ranClick("ctl00_ContentZone_ctrlRoadway_mc_highwayDamage_ctl","0",ad,caMer);
			driver.findElement(By.id("ctl00_ContentZone_ctrlRoadway_txt_comment_box_data")).sendKeys("This was created by QA Automation Script");			
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(2000);
			System.out.println("El Componente Calzada ha sido creado para la Parte No. "+partText);
	  }
   	
}
class infoCompScreen extends ausaFieldsConfiguration{
	public static void ibInformation() throws Exception {
		Thread.sleep(1000);
		  driver.findElement(By.id(infoLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("information.jpg");
      Thread.sleep(1000);        
			driver.findElement(By.id("ctl00_ContentZone_ctrlInsideInformation_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlInsideInformation_txt_Title_box_data")).sendKeys("Información Interna"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(500);
			driver.findElement(By.id("ctl00_ContentZone_ctrlInsideInformation_txt_comment_box_data")).sendKeys("This was created by QA Automation Script");
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(2000);
			System.out.println("El Componente Información ha sido creado para la Parte No. "+partText);
	}

}

class inconCompScreen extends ausaFieldsConfiguration{
	public static void ibInconveniente() throws Exception{
		Thread.sleep(1000);
		  driver.findElement(By.id(inconLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("inconveniente.jpg");
		  Thread.sleep(1000);
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_txt_Title_box_data")).clear();
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_txt_Title_box_data")).sendKeys("Información Interna"+" - "+ranNumbr(1,99)+" QA" );
		  Thread.sleep(500);
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_check_has_congestion")).click();
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_check_has_rushHour")).click();
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_check_has_laneCut")).click();
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_checkWorks")).click();
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_txt_works_area_box_data")).sendKeys("This was created by QA Automation Script");
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_txt_not_determined_box_data")).sendKeys("This was created by QA Automation Script");
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_CheckComment")).click();
		  driver.findElement(By.id("ctl00_ContentZone_ctrlInconvenientShedule_txt_comment_box_data")).sendKeys("This was created by QA Automation Script");;
		  Thread.sleep(1000);
		  System.out.println("El Componente Inconveniente ha sido creado para la Parte No. "+partText);
		  
		  
	}
	
}