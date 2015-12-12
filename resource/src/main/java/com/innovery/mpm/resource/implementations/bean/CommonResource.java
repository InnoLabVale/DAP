package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.AccountGroupIdInterface;
import com.innovery.mpm.resource.interfaces.bean.AccumulatorInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommunityIdInterface;
import com.innovery.mpm.resource.interfaces.bean.DedicatedAccountInterface;
import com.innovery.mpm.resource.interfaces.bean.FafInterface;
import com.innovery.mpm.resource.interfaces.bean.LanguageInterface;
import com.innovery.mpm.resource.interfaces.bean.MainBalanceInterface;
import com.innovery.mpm.resource.interfaces.bean.OfferIdInterface;
import com.innovery.mpm.resource.interfaces.bean.PamInterface;
import com.innovery.mpm.resource.interfaces.bean.PromotionPlanInterface;
import com.innovery.mpm.resource.interfaces.bean.SIMExpInterface;
import com.innovery.mpm.resource.interfaces.bean.SUPExpInterface;
import com.innovery.mpm.resource.interfaces.bean.ServiceClassInterface;
import com.innovery.mpm.resource.interfaces.bean.ServiceOfferingsInterface;
import com.innovery.mpm.resource.interfaces.bean.ShareAccountInterface;

public class CommonResource implements CommonResourceInterface {

	private String resourceSelected;
	private String msisdn;
	private String market;
	private String action;
	
	private AccountGroupIdInterface accountGroupId;
	private AccumulatorInterface accumulator;
	private CommunityIdInterface communityId;
	private DedicatedAccountInterface dedicatedAccount;
	private FafInterface faf;
	private LanguageInterface language;
	private MainBalanceInterface mainBalance;
	private OfferIdInterface offerId;
	private PamInterface pam;
	private PromotionPlanInterface promotionPlan;
	private ServiceClassInterface serviceClass;
	private ServiceOfferingsInterface serviceOfferings;
	private ShareAccountInterface shareAccount;
	private SIMExpInterface sim;
	private SUPExpInterface sup;
	
	public String getResourceSelected() {
		return resourceSelected;
	}

	public void setResourceSelected(String resourceSelected) {
		this.resourceSelected = resourceSelected;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public String getMarket() {
		return market;
	}

	public String getAction() {
		return action;
	}

	public AccountGroupIdInterface getAccountGroupId() {
		return accountGroupId;
	}

	public void setAccountGroupId(AccountGroupIdInterface accountGroupId) {
		this.accountGroupId = accountGroupId;
	}

	public AccumulatorInterface getAccumulator() {
		return accumulator;
	}

	public void setAccumulator(AccumulatorInterface accumulator) {
		this.accumulator = accumulator;
	}

	public CommunityIdInterface getCommunityId() {
		return communityId;
	}

	public void setCommunityId(CommunityIdInterface communityId) {
		this.communityId = communityId;
	}

	public DedicatedAccountInterface getDedicatedAccount() {
		return dedicatedAccount;
	}

	public void setDedicatedAccount(DedicatedAccountInterface dedicatedAccount) {
		this.dedicatedAccount = dedicatedAccount;
	}

	public FafInterface getFaf() {
		return faf;
	}

	public void setFaf(FafInterface faf) {
		this.faf = faf;
	}

	public LanguageInterface getLanguage() {
		return language;
	}

	public void setLanguage(LanguageInterface language) {
		this.language = language;
	}

	public MainBalanceInterface getMainBalance() {
		return mainBalance;
	}

	public void setMainBalance(MainBalanceInterface mainBalance) {
		this.mainBalance = mainBalance;
	}

	public OfferIdInterface getOfferId() {
		return offerId;
	}

	public void setOfferId(OfferIdInterface offerId) {
		this.offerId = offerId;
	}

	public PamInterface getPam() {
		return pam;
	}

	public void setPam(PamInterface pam) {
		this.pam = pam;
	}

	public PromotionPlanInterface getPromotionPlan() {
		return promotionPlan;
	}

	public void setPromotionPlan(PromotionPlanInterface promotionPlan) {
		this.promotionPlan = promotionPlan;
	}

	public ServiceClassInterface getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(ServiceClassInterface serviceClass) {
		this.serviceClass = serviceClass;
	}

	public ServiceOfferingsInterface getServiceOfferings() {
		return serviceOfferings;
	}

	public void setServiceOfferings(ServiceOfferingsInterface serviceOfferings) {
		this.serviceOfferings = serviceOfferings;
	}

	public ShareAccountInterface getShareAccount() {
		return shareAccount;
	}

	public void setShareAccount(ShareAccountInterface shareAccount) {
		this.shareAccount = shareAccount;
	}

	public SIMExpInterface getSim() {
		return sim;
	}

	public void setSim(SIMExpInterface sim) {
		this.sim = sim;
	}

	public SUPExpInterface getSup() {
		return sup;
	}

	public void setSup(SUPExpInterface sup) {
		this.sup = sup;
	}
}
