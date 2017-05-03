package AUSA;



import org.openqa.selenium.By;



public class trafficCompScreen extends ausaFieldsConfiguration{
	  
	  public static void ibTraffic() throws Exception {
		  Thread.sleep(1000);
		  driver.findElement(By.id(traffLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);
		  takeScreenShot("traffic.jpg");
        Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlTraffic_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlTraffic_txt_Title_box_data")).sendKeys("Tiempo"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(500);
			selectDropDownClick("ctl00_ContentZone_ctrlTraffic_cmb_traffic_cmb_dropdown");
			selectDropDownClick("ctl00_ContentZone_ctrlTraffic_cmb_vehicles_hour_cmb_dropdown");			
			driver.findElement(By.id("ctl00_ContentZone_ctrlTraffic_txt_comment_box_data")).sendKeys("This was created by QA Automation Script");			
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(2000);
			System.out.println("El Componente Tráfico ha sido creado para la Parte No. "+partText);
	  }
   	
}

