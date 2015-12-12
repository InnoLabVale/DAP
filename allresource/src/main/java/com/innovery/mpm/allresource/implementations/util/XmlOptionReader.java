package com.innovery.mpm.allresource.implementations.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.jdom2.JDOMException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean.OptionBean;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.OptionBeanInterface;
import com.innovery.mpm.allresource.interfaces.util.XmlOptionReaderInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

/**
 * 
 * 
 * @author Daniela R. Auricchio
 *
 */
public class XmlOptionReader implements XmlOptionReaderInterface{
	
	private DAPBeanInterface components;
	
	public OptionBeanInterface getOptionDetails(String optPattern, String market, String ctype) throws JDOMException, IOException, SAXException, ParserConfigurationException, XPathExpressionException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setExpandEntityReferences(false);
		Document source = null;

		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expr = null;
		if (market.equals(DAPBeanInterface.CONSUMER)) {
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				source = factory.newDocumentBuilder().parse(getClass().getResourceAsStream(components.XML_LIST_CONSUMER_PREPAID_PATH()));
			}
			
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				source = factory.newDocumentBuilder().parse(getClass().getResourceAsStream(components.XML_LIST_CONSUMER_POSTPAID_PATH()));
			}
			expr = xpath.compile("//ropz[@code=\"" + optPattern + "\"]");
		} else if (market.equals(DAPBeanInterface.CORPORATE)) {
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				source = factory.newDocumentBuilder().parse(getClass().getResourceAsStream(components.XML_LIST_CORPORATE_PREPAID_PATH()));
			}
			
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				source = factory.newDocumentBuilder().parse(getClass().getResourceAsStream(components.XML_LIST_CORPORATE_POSTPAID_PATH()));
			}
			expr = xpath.compile("//opt[@code=\"" + optPattern + "\"]");
		}

		/* List of 'ropz' tags with attribute */
		@SuppressWarnings("null")
		NodeList ropzNodes = (NodeList) expr.evaluate(source, XPathConstants.NODESET);
		

		return iterateOverXml(ropzNodes).get(0);
	}
	
	/**
	 * Iterate over a ROPZ nodeList
	 * Common method to scan ROPZ or OPT XML file
	 * 
	 * @param ropzNodes
	 * @return
	 */
	private List<OptionBeanInterface> iterateOverXml(NodeList ropzNodes){
		
		List<OptionBeanInterface> ropzList = new ArrayList<OptionBeanInterface>();
		OptionBean tmp;
		NamedNodeMap attrs;

		List<String> alString = null;

		/* For every ropz */
		for (int node = 0; node < ropzNodes.getLength(); node++) {

			tmp = new OptionBean();

			/* Get the attribute = ropz code */
			attrs = ropzNodes.item(node).getAttributes();
			tmp.setMaster(((Attr) attrs.item(0)).getValue());


			/* Get childs of ropz */
			NodeList ropzChildNodes = ropzNodes.item(node).getChildNodes();
			/* For every ropz child */
			for (int ropzChildNode = 0; ropzChildNode < ropzChildNodes
					.getLength(); ropzChildNode++) {

				//description
				if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("description")) {
					tmp.setDescription(ropzChildNodes.item(ropzChildNode)
							.getTextContent());
				}
				
				//service codes
				else if (ropzChildNodes.item(ropzChildNode).getNodeName().equals("service_code_list")) {
					NodeList scodeNodes = ropzChildNodes.item(ropzChildNode).getChildNodes();
					alString = new ArrayList<String>();
					List<String> discounts = new ArrayList<String>();
					List<String> sc_discount = new ArrayList<String>();
					for (int i = 0; i < scodeNodes.getLength(); i++) {
						if ((scodeNodes.item(i).getAttributes().item(0)).getNodeValue().equals("NULL")) {
							alString.add(scodeNodes.item(i).getTextContent().trim());
						}else{
							//discounts
							discounts.add((scodeNodes.item(i).getAttributes().item(0)).getNodeValue());
							sc_discount.add(scodeNodes.item(i).getTextContent());
						}
					}
					tmp.setSc(alString);
					tmp.setDiscounts(discounts);
					tmp.setSc_discounts(sc_discount);
				}
				

				// ACC
				else if (ropzChildNodes.item(ropzChildNode).getNodeName().equals("accumulator_list")) {
					NodeList accumulatorNodes = ropzChildNodes.item(ropzChildNode).getChildNodes();
					alString = new ArrayList<String>();
					for (int i = 0; i < accumulatorNodes.getLength(); i++) {
						alString.add(accumulatorNodes.item(i).getTextContent().trim());
					}
					tmp.setAccumulatorList(alString);
				}

				// DAs
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("dedicated_account_list")) {
					NodeList dedAccountNodes = ropzChildNodes.item(
							ropzChildNode).getChildNodes();
					alString = new ArrayList<String>();
					for (int i = 0; i < dedAccountNodes.getLength(); i++) {
						alString.add(dedAccountNodes.item(i).getTextContent());
					}
					tmp.setDaList(alString);
				}

				// faf
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("faf_list")) {
					NodeList fafNodes = ropzChildNodes.item(ropzChildNode)
							.getChildNodes();
					alString = new ArrayList<String>();
					for (int i = 0; i < fafNodes.getLength(); i++) {
						alString.add(fafNodes.item(i).getTextContent());
					}
					tmp.setFafList(alString);
				}

				// Offer id
				else if (ropzChildNodes.item(ropzChildNode).getNodeName().equals("offer_id_list")) {
					 NodeList offerNodes = ropzChildNodes.item(ropzChildNode).getChildNodes();
					 alString = new ArrayList<String>();
					 for (int i = 0; i < offerNodes.getLength(); i++) {
					 alString.add(offerNodes.item(i).getTextContent());
					 }
					tmp.setOfferIdList(alString);
				}

				// COMMUNITY
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("community_id")) {
					tmp.setCommunity(ropzChildNodes.item(ropzChildNode)
							.getTextContent());
				}

				// service offering
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("service_offerings")) {
					tmp.setSo(ropzChildNodes.item(ropzChildNode)
							.getTextContent());
				}

				// PPLAN
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("promotion_plan")) {
					tmp.setPplan(ropzChildNodes.item(ropzChildNode)
							.getTextContent());
				}

				// AGI
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("agi")) {
					tmp.setAgi(ropzChildNodes.item(ropzChildNode)
							.getTextContent());
				}

				// UC
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("UC_list")) {
					NodeList ucNodes = ropzChildNodes.item(ropzChildNode)
							.getChildNodes();
					alString = new ArrayList<String>();
					for (int i = 0; i < ucNodes.getLength(); i++) {
						alString.add(ucNodes.item(i).getTextContent());
					}
					tmp.setUC(alString);
				}

				// UT
				else if (ropzChildNodes.item(ropzChildNode).getNodeName()
						.equals("UT_list")) {
					NodeList utNodes = ropzChildNodes.item(ropzChildNode)
							.getChildNodes();
					alString = new ArrayList<String>();
					for (int i = 0; i < utNodes.getLength(); i++) {
						alString.add(utNodes.item(i).getTextContent());
					}
					tmp.setUT(alString);
				}

			}

			ropzList.add(tmp);
		}
		
		return ropzList;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
