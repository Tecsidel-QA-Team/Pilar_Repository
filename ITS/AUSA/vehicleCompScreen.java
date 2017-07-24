package AUSA;



import org.openqa.selenium.By;


import org.openqa.selenium.support.ui.Select;

public class vehicleCompScreen extends ausaFieldsConfiguration{
	public static String nameLast = "_txt_name_box_data";
	public static String located = "_cmb_city_cmb_dropdown";
	public static String gender = "_cmb_gender_cmb_dropdown";
	public static String age = "_txt_age_box_data";
	public static String status = "_cmb_status_cmb_dropdown";
	public static String home = "_txt_address_box_data";
	public static String DNI = "_txt_nif_box_data";
	public static String phone = "_txt_phone_box_data";
	public static String description = "_txt_description_box_data"; 
		  
	  public static void ibVehicle() throws Exception {
		  Thread.sleep(1000);		  
		  driver.findElement(By.id(vehLabel)).click();
		  Thread.sleep(1000);
		  driver.switchTo().frame(0);		  
		  Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_Title_box_data")).clear();
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_Title_box_data")).sendKeys("Vehicle"+" - "+ranNumbr(1,99)+" QA" );
			Thread.sleep(2000);
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_type_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_year_box_data")).sendKeys(+ranNumbr(2000,2017)+"");			
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_brake_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_covers_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_mc_part_damage_img_expand")).click();			
			ranSelection("ctl00_ContentZone_ctrlVehicle_mc_part_damage_ctl", 48);
			ranClick("ctl00_ContentZone_ctrlVehicle_mc_part_damage_ctl","0",ad,caMer);
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_maker_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_plate_box_data")).sendKeys(ranNumbr(1,900000000)+"" );
			selectDropDownClick("ctl00_ContentZone_ctrlVehicle_cmb_direction_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_headlights_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_model_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_status_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_referredTo_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_isurance_policy_box_data")).sendKeys("Mafre" );
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_company_cmb_dropdown");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_isurance_cover_cmb_dropdown");
			dateSel(2008,2007);			
			Thread.sleep(500);
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_dt_isurance_expiry_box_date")).sendKeys(sft.format(calF));
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_check_towedUnit")).click();
			
			selectDropDownClick("ctl00_ContentZone_ctrlVehicle_cmb_coupled_type_cmb_dropdown");
			selectDropDownClick("ctl00_ContentZone_ctrlVehicle_cmb_coupled_company_cmb_dropdown");
			dateSel(2017,2019);
			Thread.sleep(500);
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_dt_coupled_expiry_box_date")).sendKeys(sft.format(calF));
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_mc_coupled_pd_img_expand")).click();			
			ranSelection("ctl00_ContentZone_ctrlVehicle_mc_coupled_pd_ctl", 47);
			ranClick("ctl00_ContentZone_ctrlVehicle_mc_coupled_pd_ctl","0",ad,caMer);			
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_coupled_chassis_box_data")).sendKeys("HOME");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_coupled_policy_box_data")).sendKeys(ranYearNumbr(100000,800000)+"");
			selectDropDownClick("ctl00_ContentZone_ctrlVehicle_cmb_coupled_cover_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_check_material")).click();
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_no_picto_box_data")).sendKeys(ranYearNumbr(10000,900000)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_check_orangePlate")).click();
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_top_number_box_data")).sendKeys(ranYearNumbr(1000,40000)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_buttom_number_box_data")).sendKeys(ranYearNumbr(1000,40000)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_check_spilled")).click();
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_injured_tras_owmeans_box_data")).sendKeys(ranYearNumbr(10,999)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_injured_tras_helicopter_box_data")).sendKeys(ranYearNumbr(10,999)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_injured_tras_ambulance_box_data")).sendKeys(ranYearNumbr(10,999)+"");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_deceased_box_data")).sendKeys(ranYearNumbr(10,999)+"");
			int nameGender = ranYearNumbr(0,personsT.length-1);
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_driver_name_box_data")).sendKeys(personsT[nameGender]);
			selectDropDownClick("ctl00_ContentZone_ctrlVehicle_cmb_driver_city_cmb_dropdown");
			String dnidriving = dniLetra(ranYearNumbr(10000000,40000000)); 
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_driver_licenseid_box_data")).sendKeys(dnidriving);
			selectDropDownClick("ctl00_ContentZone_ctrlVehicle_cmb_relationship_cmb_dropdown");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_driver_address_box_data")).sendKeys("HOMETOWN");
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_driver_dni_box_data")).sendKeys(dnidriving);
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_txt_driver_phone_box_data")).sendKeys(ranYearNumbr(910000000,980000000)+"");
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_apparent_status_cmb_dropdown");
			new Select (driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_cmb_driver_gender_cmb_dropdown"))).selectByIndex(genderT[nameGender]);
			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_cmb_driver_gender_cmb_dropdown");
			dateSel(1970,1980);
			Thread.sleep(500);;
			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_dt_driver_birthdate_box_date")).sendKeys(sft.format(calF));
			Thread.sleep(1000);
			ocupantesSection();
			Thread.sleep(1000);
			System.out.println("El Componente Vehiculo ha sido creado para la Parte No. "+partText);
			
	  }
	  	public static void ocupantesSection() throws Exception{
	  		int ocuPant = ranYearNumbr(1,4);
	  		for (int ocu = 1; ocu<= ocuPant; ocu++){
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_BtnAddOccupants")).click();
	  			Thread.sleep(500);
	  		}
	  		String ocuPants = driver.findElement(By.xpath("//*[contains(@id,'ctl00_ContentZone_ctrlVehicle_Vehicle')]")).getAttribute("id");
	  		int ocuPantNumber = Integer.parseInt(ocuPants.substring(37, 39));
	  		int totalOcupant = ocuPantNumber + ocuPant;	
	  		if (ocuPant == 1){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+nameLast)).sendKeys(personsT[nameGender]);
	  			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+located);	  			
	  			new Select (driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+gender))).selectByIndex(genderT[nameGender]);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+age)).sendKeys(ranYearNumbr(30,45)+"");
	  			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+status);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+home)).sendKeys("ESPAÑA");
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+phone)).sendKeys(ranYearNumbr(900000000,980000000)+"");
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocuPantNumber+description)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);
	  		}else{
	  		for (int ocup = ocuPantNumber; ocup<totalOcupant; ocup++){
	  			int nameGender = ranYearNumbr(0,personsT.length-1);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+nameLast)).sendKeys(personsT[nameGender]);
	  			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+located);	  			
	  			new Select (driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+gender))).selectByIndex(genderT[nameGender]);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+age)).sendKeys(ranYearNumbr(30,45)+"");
	  			selectDropDownClick2("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+status);
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+home)).sendKeys("ESPAÑA");
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+DNI)).sendKeys(dniLetra(ranYearNumbr(10000000,40000000)));
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+phone)).sendKeys(ranYearNumbr(900000000,980000000)+"");
	  			driver.findElement(By.id("ctl00_ContentZone_ctrlVehicle_Vehicle"+ocup+description)).sendKeys("QA TESTER TECSIDEL");
	  			Thread.sleep(2500);
	  			}
	  		}
	  		Thread.sleep(1000);
	  		takeScreenShot("E:\\Selenium\\","VehicleComp"+timet+".jpg");
	  		takeScreenShot("E:\\workspace\\Pilar_Repository\\ausaModificaPartes\\attachments\\","VehicleComp"+timet+".jpg");
	  		Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ButtonsZone_BtnSave_IB_Label")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_BtnPnlConfirm")).click();
			Thread.sleep(3000);
	  		
	  	}	
	  		
      	
}
