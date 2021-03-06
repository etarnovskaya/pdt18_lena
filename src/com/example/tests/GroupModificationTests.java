package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.Random;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group){
		app.navigateTo().mainPage();
	    app.navigateTo().groupsPage();
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    app.getGroupHelper().modifyGroup(index, group);
		
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	
		assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
}
