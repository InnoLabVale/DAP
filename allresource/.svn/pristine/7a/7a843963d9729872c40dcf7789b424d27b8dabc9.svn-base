package com.innovery.mpm.allresource.implementations.util;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.innovery.mpm.allresource.interfaces.gui.AllResourceInterface;
import com.innovery.mpm.allresource.interfaces.util.AllResourceNotificationConnectionWarningInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class AllResourceNotificationConnectionWarning implements AllResourceNotificationConnectionWarningInterface {
	
	private AllResourceInterface reference;
	private DAPBeanInterface components;
	
	public void notify(String msg){
		if(msg.equals(components.getErrorMessages().get_NOT_LOGGED_WARN())){
			
			UIManager.put("OptionPane.yesButtonText", "Relog");  
			UIManager.put("OptionPane.noButtonText", "Cancel");
			
			int response = JOptionPane.showOptionDialog(null, components.getErrorMessages().get_NOT_LOGGED_WARN(), "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			
			if(response == JOptionPane.YES_OPTION){
				
				String redirect;
				
				if(components.getConnectionManagerCai().getSession().isSessionAvailable()){
					redirect = components.getConnectionManagerCai().reconnectionCai(msg);
				}
				else {
					redirect = components.getConnectionManagerStandard().reconnectionStandard(msg);
				}
				
				if (redirect==null ||
					redirect.equals(components.getErrorMessages().get_NOT_LOGGED_ERROR()) || 
					redirect.equals(components.getErrorMessages().get_MPM_CONNECTION_ERROR()) || 
					redirect.equals(components.getErrorMessages().get_MPM_ERROR())){
					
					reference.getBtnView().setText("Home");
					reference.getBtnView().setActionCommand("home");
					reference.getBtnView().doClick();
				}
				else if (redirect.equals(components.getErrorMessages().get_RELOGGED())) {
					UIManager.put("OptionPane.okButtonText", "Ok");
					JOptionPane.showMessageDialog(null, components.getErrorMessages().get_RELOGGED(),"", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		
		else if(msg.equals(components.getErrorMessages().get_MPM_CONNECTION_WARN())){
			UIManager.put("OptionPane.yesButtonText", "Home");  
			UIManager.put("OptionPane.noButtonText", "Cancel");
			int response = JOptionPane.showOptionDialog(null, components.getErrorMessages().get_MPM_CONNECTION_WARN(), "", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			if(response == JOptionPane.YES_OPTION){
				reference.getBtnView().setText("Home");
				reference.getBtnView().setActionCommand("home");
				reference.getBtnView().doClick();
			}
		}
	}

	public void setReference(AllResourceInterface reference) {
		this.reference = reference;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
