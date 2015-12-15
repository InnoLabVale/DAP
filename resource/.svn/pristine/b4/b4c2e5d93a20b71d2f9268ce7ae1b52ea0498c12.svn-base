package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.interfaces.action.ActionCommonResourceInterface;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.action.ActionServiceOfferingsInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionCommonResource implements ActionCommonResourceInterface{
	
	private DAPBeanInterface components;
	
	public String ExecuteCaiCommand(CommonResourceInterface resourceBean){
		
		if(resourceBean.getResourceSelected().equals(AIRActions.ACCOUNT_GRUOP_ID)){
			
			ActionResourceInterface actionElement = new ActionAccountGroupId();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("ACCOUNT GROUP ID GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("ACCOUNT GROUP ID UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.ACCUMULATOR)){
			
			ActionResourceInterface actionElement = new ActionAccumulator();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("ACCUMULATOR CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("ACCUMULATOR DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("ACCUMULATOR GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("ACCUMULATOR UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.COMMUNITY)){
			
			ActionResourceInterface actionElement = new ActionCommunity();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("COMMUNITY ID GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET) || resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("COMMUNITY ID UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.DEDICATED_ACCOUNT)){
			
			ActionResourceInterface actionElement = new ActionDedicated();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("DEDICATED ACCOUNT CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("DEDICATED ACCOUNT DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("DEDICATED ACCOUNT GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("DEDICATED ACCOUNT UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.FAF)){
			
			ActionResourceInterface actionElement = new ActionFaf();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("FAF CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("FAF DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("FAF GET");
				return actionElement.get(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.LANGUAGE)){
			
			ActionResourceInterface actionElement = new ActionLanguage();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("LANGUAGE GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("LANGUAGE UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.BALANCE)){
			
			ActionResourceInterface actionElement = new ActionMainBalance();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("MAIN BALANCE GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("MAIN BALANCE UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.OFFER)){
			
			ActionResourceInterface actionElement = new ActionOfferId();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("OFFER ID CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("OFFER ID DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("OFFER ID GET");
				return actionElement.get(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.PAM)){
			
			ActionResourceInterface actionElement = new ActionPam();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("PAM CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("PAM DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("PAM GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("PAM UPDATE");
				return actionElement.update(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_RUN)){
				components.getLogger().info("PAM RUN");
				return actionElement.run(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.PROMOTION_PLAN)){
			
			ActionResourceInterface actionElement = new ActionPromotionPlan();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("PROMOTION PLAN CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("PROMOTION PLAN DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("PROMOTION PLAN GET");
				return actionElement.get(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.SERVICE_CLASS)){
			
			ActionResourceInterface actionElement = new ActionServiceClass();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("SERVICE CLASS GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("SERVICE CLASS UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.SERVICE_OFFERING)){
			
			ActionServiceOfferingsInterface actionElement = new ActionServiceOffering();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				if(resourceBean.getServiceOfferings().isBit()){
					components.getLogger().info("SERVICE OFFERINGS CREATE BIT");
					return actionElement.createBit(resourceBean);
				}
				else if(!resourceBean.getServiceOfferings().isBit()){
					components.getLogger().info("SERVICE OFFERINGS CREATE DECIMAL");
					return actionElement.createDecimal(resourceBean);
				}
				
			}
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				if(resourceBean.getServiceOfferings().isBit()){
					components.getLogger().info("SERVICE OFFERINGS DELETE BIT");
					return actionElement.deleteBit(resourceBean);
				}
				else if(!resourceBean.getServiceOfferings().isBit()){
					components.getLogger().info("SERVICE OFFERINGS DELETE DECIMAL");
					return actionElement.deleteDecimal(resourceBean);
				}
				
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("SERVICE OFFERINGS GET");
				return actionElement.get(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.SHARE_ACCOUNT)){
			
			ActionResourceInterface actionElement = new ActionShareAccount();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_CREATE)){
				components.getLogger().info("SHARE ACCOUNT CREATE");
				return actionElement.create(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				components.getLogger().info("SHARE ACCOUNT DELETE");
				return actionElement.delete(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("SHARE ACCOUNT GET");
				return actionElement.get(resourceBean);
			}
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.SIM)){
			
			ActionResourceInterface actionElement = new ActionSIMExp();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("SIM EXPIRY DATE GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("SIM EXPIRY DATE UPDATE");
				return actionElement.update(resourceBean);
			}
			
		}
		
		else if(resourceBean.getResourceSelected().equals(AIRActions.SUP)){
			
			ActionResourceInterface actionElement = new ActionSUPExp();
			actionElement.setComponents(components);
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_GET)){
				components.getLogger().info("SUPERVISION EXPIRY DATE GET");
				return actionElement.get(resourceBean);
			}
			else if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_SET)){
				components.getLogger().info("SUPERVISION EXPIRY DATE UPDATE");
				return actionElement.update(resourceBean);
			}
		}
		
		return null;
	}
	
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
