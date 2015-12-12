package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.LanguageInterface;

public class Language implements LanguageInterface{

	private int lang_id;
	
	public int getLangauge(){
		return this.lang_id;
	}
	
	public void setLanguage(int lang_id){
		this.lang_id=lang_id;
	}
}
