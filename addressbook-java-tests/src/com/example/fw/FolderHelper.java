package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;


public class FolderHelper {
	private  ApplicationManager manager;

	public FolderHelper(ApplicationManager applicationManager){
		this.manager = applicationManager;
		
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(manager.getApplication());
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			list.add("" + child);			
		}
		return new Folders(list);
	}
	public void createFolder(String foldername) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(manager.getApplication());
		new JTextFieldOperator(dialog).setText(foldername);
		new JButtonOperator(dialog, "OK").push();
	}

}
