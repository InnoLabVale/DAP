package com.innovery.mpm.allresource.implementations.gui.util;

import javax.swing.SwingWorker;

import com.innovery.mpm.allresource.implementations.gui.AllResource;
import com.innovery.mpm.allresource.interfaces.gui.AllResourceInterface;

public class Task extends SwingWorker<Void, Void>{
	
	private AllResourceInterface ar;
	private int index;
	
	public Task(AllResource ar, int index){
		this.ar = ar;
		this.index = index;
	}

	protected Void doInBackground() throws Exception {
		
		ar.getBtnView().setEnabled(false);
		for(int i=0; i<9; i++){
			ar.getTabbedPane().setEnabledAt(i, false);
		}
		
		if(index == -1){
			ar.executeGet();
		}
		else{
			ar.executeGetTabs(index);
		}
		return null;
	}
	
	public void done(){
		for(int i=0; i<9; i++){
			ar.getTabbedPane().setEnabledAt(i, true);
		}
		ar.getBtnView().setEnabled(true);
		ar.getProgressBar().setVisible(false);
	}
}
