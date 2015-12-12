/**
 * This class contains methods to read the XML file containing all options released.
 */

package com.innovery.mpm.allresource.implementations.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptions;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptionsInterface;
import com.innovery.mpm.allresource.interfaces.util.SubscriberOptionFinderInterface;
import com.innovery.mpm.allresource.interfaces.util.bean.ActivatedSubscriberResourceInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

/**
 * 
 * @author Daniela R. Auricchio, Valerio Boschi
 *
 */
public class SubscriberOptionFinder implements SubscriberOptionFinderInterface{
	
	private DAPBeanInterface components;

	public List<ActivatedSubscriberOptionsInterface> executeSubscriberOptionFinder(ActivatedSubscriberResourceInterface value_extracted_from_user, String market, String ctype) throws JDOMException, IOException{
		
		List<ActivatedSubscriberOptionsInterface> subscriberOptionList = new ArrayList<ActivatedSubscriberOptionsInterface>();
		ActivatedSubscriberOptionsInterface tmp;
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		if(market.equals(DAPBeanInterface.CONSUMER)){
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				doc = builder.build(getClass().getResourceAsStream(components.XML_LIST_CONSUMER_PREPAID_PATH()));
			}
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				doc = builder.build(getClass().getResourceAsStream(components.XML_LIST_CONSUMER_POSTPAID_PATH()));
			}
		}
		else if(market.equals(DAPBeanInterface.CORPORATE)){
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				doc = builder.build(getClass().getResourceAsStream(components.XML_LIST_CORPORATE_PREPAID_PATH()));
			}
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				doc = builder.build(getClass().getResourceAsStream(components.XML_LIST_CORPORATE_POSTPAID_PATH()));
			}
		}
		
		@SuppressWarnings("null")
		Element root = doc.getRootElement();
		
		List<Element> ropz_list = root.getChildren();
		
		Iterator<Element> ropz_list_iterator = ropz_list.iterator();
		
		/* for each ropz */
		while (ropz_list_iterator.hasNext()){
			
			tmp = new ActivatedSubscriberOptions();
			Element ropz = ropz_list_iterator.next();
		    List<Element> ropz_resource_type_list = ropz.getChildren();
		    Iterator<Element> ropz_resource_type_list_iterator = ropz_resource_type_list.iterator();
		    int go_on = 0;

		    while(ropz_resource_type_list_iterator.hasNext()){
   
		    	Element ropz_resource_type = ropz_resource_type_list_iterator.next();
		    	List<Element> resource_list_per_type = ropz_resource_type.getChildren();

		    	if(resource_list_per_type.size()!=0){
		    		Iterator<Element> resource_list_per_type_iterator = resource_list_per_type.iterator();
		    		while(resource_list_per_type_iterator.hasNext() && go_on!=-1){
		    			
		    			Element single_resource_type = resource_list_per_type_iterator.next();
		    			
	    				String tag_name = single_resource_type.getName();
	    				String tag_value = single_resource_type.getText();
	    				
	    				if(tag_name.equals("dedicated_account")){
	    					if(value_extracted_from_user.getDaList().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					else{
	    						go_on = -1;
	    						break;
	    					}
	    				}
	    				else if(tag_name.equals("accumulator") && go_on!=-1){
	    					if(value_extracted_from_user.getAccumulatorList().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					else{
	    						go_on = -1;
	    						break;
	    					}
	    				}
	    				else if(tag_name.equals("offer_id") && go_on!=-1){
	    					if(value_extracted_from_user.getOfferList().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					else{
	    						go_on = -1;
	    						break;
	    					}
	    				}
	    				else if(tag_name.equals("faf") && go_on!=-1){
	    					if(value_extracted_from_user.getFafList().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					else{
	    						go_on = -1;
	    						break;
	    					}
	    				}
	    				
	    				else if(tag_name.equals("pplan") && go_on!=-1){
	    					if(value_extracted_from_user.getPplanList().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					/**
	    					 * le promo prevedono uno tra due pplan. L'utente ne ha uno solo di volta in volta e per far si che 
	    					 * venga riconosciuto uno o l'altro promotion plan, stato tolto l'else
	    					 */
	    				}
	    				
	    				else if(tag_name.equals("uc") && go_on!=-1){
	    					if(value_extracted_from_user.getUC().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					else{
	    						go_on = -1;
	    						break;
	    					}
	    				}
	    				else if(tag_name.equals("ut") && go_on!=-1){
	    					if(value_extracted_from_user.getUT().contains(tag_value)){
	    						go_on = 1;
	    					}
	    					else{
	    						go_on = -1;
	    						break;
	    					}
	    				}
	    				else if(tag_name.equals("service_code") && go_on!=-1){
	    					Element service_code_root = ((Element) single_resource_type.getParent());
	    					List<Element> all_service_code = service_code_root.getChildren();
	    					Element service_code_found = serviceCodeExtraction(all_service_code, value_extracted_from_user.getServiceCode());
	    					
	    					if(service_code_found!=null){
	    						tmp.setDiscount(service_code_found.getAttributeValue("discount"));
	    					}
	    					else {
	    						tmp.setDiscount("-");
	    					}
	    				}
		    		}
		    	}
		    	
		    	if(resource_list_per_type.size()==0  && go_on!=-1){
		    		String tag_name = ropz_resource_type.getName();
		    		String tag_value = ropz_resource_type.getText();
		    		if(tag_name.equals("community_id")){
    					if(tag_value.equals(value_extracted_from_user.getCommunity())){
    						go_on = 1;
    					}
    					else{
    						go_on = -1;
    						break;
    					}
    				}
		    		else if(tag_name.equals("service_offerings") && go_on!=-1){
		    			boolean converted_service_offering = serviceOfferingConverter(tag_value, value_extracted_from_user.getSo());
    					if(converted_service_offering==true){
    						go_on = 1;
    					}
    					else{
    						go_on = -1;
    						break;
    					}
    				}
		    		else if(tag_name.equals("agi") && go_on!=-1){
    					if(tag_value.equals(value_extracted_from_user.getAgi())){
    						go_on = 1;
    					}
    					else{
    						go_on = -1;
    						break;
    					}
    				}
		    	}
		    }
		    
	    	if(go_on==1){
	    		tmp.setMaster(ropz.getAttributeValue("code"));
	    		subscriberOptionList.add(tmp);
	    	}
		}

		return subscriberOptionList;
	}
	
	boolean serviceOfferingConverter(String service_offering_string_decimal, String service_offering_from_user){
		StringBuffer service_offering_from_user_inverted = new StringBuffer(service_offering_from_user);
		service_offering_from_user_inverted.reverse();
		
		int user_service_offering_integer_decimal = Integer.parseInt(service_offering_string_decimal);
		int service_offering_bit_index = (int) (Math.log10(user_service_offering_integer_decimal)/Math.log10(2));
		
		if(service_offering_from_user_inverted.substring(service_offering_bit_index, service_offering_bit_index+1).equals("1")){
			return true;
		}
		return false;
	}
	
	private Element serviceCodeExtraction(List<Element> service_code_list, List<String> promotion_service_code ){
		for(int i=0; i<service_code_list.size(); i++){
			String service_code_of_option = service_code_list.get(i).getText();
			if(promotion_service_code.contains(service_code_of_option)){
				return service_code_list.get(i);
			}
		}
		return null; 
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
