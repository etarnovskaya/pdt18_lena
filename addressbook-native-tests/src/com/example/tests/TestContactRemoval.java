package com.example.tests;

import org.testng.annotations.Test;

public class TestContactRemoval extends TestBase {
	
	@Test
	public void shouldRemoveContact(){
		
		app.getContactHelper().removeContact();
	
	}

}
