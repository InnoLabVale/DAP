package com.innovery.mpm.subscriber.implementations.gui.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTariffPlanInterface;

public class SubscriberTariffPlan implements SubscriberTariffPlanInterface {

	private DAPBeanInterface components;
	
	private ButtonGroup marketaButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private JComboBox tariffPlanComboboxSelection;
	private String[] tariffPlanList;
	
	
	@Override
	public String[] compileTariffPlanComboBox(String current_market, String current_ctype){
		SAXBuilder builder = new SAXBuilder();
		InputStream fileResource = null;
		Document doc = null;
		String[] tariff_plan_list = null;
		
		if(current_market.equals(DAPBeanInterface.CONSUMER)){
			if(current_ctype.equals(DAPBeanInterface.PREPAID)){
				fileResource = getClass().getResourceAsStream(components.TARIFFPLAN_CONSUMER_PREPAID_PATH());
			}
			else if(current_ctype.equals(DAPBeanInterface.POSTPAID)){
				fileResource = getClass().getResourceAsStream(components.TARIFFPLAN_CONSUMER_POSTPAID_PATH());
			}
		}
		
		else if(current_market.equals(DAPBeanInterface.CORPORATE)){
			if(current_ctype.equals(DAPBeanInterface.PREPAID)){
				fileResource = getClass().getResourceAsStream(components.TARIFFPLAN_CORPORATE_PREPAID_PATH());
			}
			else if(current_ctype.equals(DAPBeanInterface.POSTPAID)){
				fileResource = getClass().getResourceAsStream(components.TARIFFPLAN_CORPORATE_POSTPAID_PATH());
			}
		}
		
		try {
			doc = builder.build(fileResource);
			List<Element> tagList = doc.getRootElement().getChildren();
			
			tariff_plan_list = new String[tagList.size()+1];
			tariff_plan_list[0] = "select...";
			
			for(int i=0; i<tagList.size(); i++){
				Element tariff_plan_extracted = tagList.get(i);
				String tariff_plan_id = tariff_plan_extracted.getAttributeValue("id");
				tariff_plan_list[i+1] = tariff_plan_id;
				
				tariffPlanComboboxSelection.setModel(new DefaultComboBoxModel(tariff_plan_list));
			}
			
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tariff_plan_list;
	}

	@Override
	public void updateTariffPlanComboList(){
		if(marketaButtonGroup.getSelection()!=null && ctypeButtonGroup.getSelection()!=null){
			tariffPlanList = compileTariffPlanComboBox(marketaButtonGroup.getSelection().getActionCommand(), ctypeButtonGroup.getSelection().getActionCommand());
			tariffPlanComboboxSelection.setModel(new DefaultComboBoxModel(tariffPlanList));
		}
		else{
			tariffPlanComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT));
		}
	}

	@Override
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	@Override
	public void setMarketaButtonGroup(ButtonGroup marketaButtonGroup) {
		this.marketaButtonGroup = marketaButtonGroup;
	}

	@Override
	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	@Override
	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection) {
		this.tariffPlanComboboxSelection = tariffPlanComboboxSelection;
	}

	@Override
	public void setTariffPlanList(String[] tariffPlanList) {
		this.tariffPlanList = tariffPlanList;
	}
}