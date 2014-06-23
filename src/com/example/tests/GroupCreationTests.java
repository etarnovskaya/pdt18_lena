
package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class GroupCreationTests extends TestBase{

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++){
		GroupData group = new GroupData();
		
		group.name = generateRandomString();
		group.header = generateRandomString();
		group.footer = generateRandomString();
		list.add(new Object[]{group});
		}
		//.....
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0){
		return "";
		}
		else {
			return "test" + rnd.nextInt();	
		}
	}
	
	
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupPage();
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    app.getGroupHelper().initGroupCreation();
	   	app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returntoGroupsPage();
	    
	    List<GroupData> newList = app.getGroupHelper().getGroups();
//	    assertEquals(newList.size(), oldList.size() + 1);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
  }
  
}
