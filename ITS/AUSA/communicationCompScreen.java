package AUSA;




import org.openqa.selenium.By;


public class communicationCompScreen extends ausaFieldsConfiguration{
	  
	  public static void ibCommunication() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(comLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("communication.jpg");
          Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_Title_box_data")).sendKeys("Communication"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(500);
			selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_type_cmb_dropdown");
			Thread.sleep(1000);
			selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_mean_cmb_dropdown");
			Thread.sleep(1000);
			selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_motive_cmb_dropdown");
			Thread.sleep(1000);
			selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_type_ori_des_cmb_dropdown");
			Thread.sleep(2000);
			notEmptyDropDown("ctl00_ContentZone_ctrlComunication_cmb_ori_des_cmb_dropdown");
			Thread.sleep(500);
			selectDropDownClick("ctl00_ContentZone_ctrlComunication_cmb_importance_cmb_dropdown");
			Thread.sleep(500);
			driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_subject_box_data")).sendKeys("Created by Automation Script");
			driver.findElement(By.id("ctl00_ContentZone_ctrlComunication_txt_comment_box_data")).sendKeys("This Communication was created by an automation script for testing purpose");
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(2000);
			System.out.println("El Componente Comunicación ha sido creado para la Parte No. "+partText);
		  
	  }
	  
     	
}
