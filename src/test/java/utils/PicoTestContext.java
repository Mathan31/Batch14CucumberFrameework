package utils;

import pages.PagesManager;

public class PicoTestContext {
	
	private BrowserBase browserBase;
	private PagesManager pagesManager;
	
	public PicoTestContext() {
		browserBase = new BrowserBase();
		pagesManager = new PagesManager(browserBase.launchChromeBrowser());
	}
	
	public BrowserBase getBrowserBase() {
		return browserBase;
	}

	public PagesManager getPagesManager() {
		return pagesManager;
	}
	
}
