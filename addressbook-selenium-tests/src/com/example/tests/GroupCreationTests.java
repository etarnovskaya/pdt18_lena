
package com.example.tests;

import org.testng.annotations.Test;
//import org.junit.*;

public class GroupCreationTests extends TestBase{
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    goToGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupName = "group name1";
    group.groupHeader = "header1";
    group.groupFooter = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    openGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("group1", "header", "footer"));
    submitGroupCreation();
    openGroupsPage();
  }
}
