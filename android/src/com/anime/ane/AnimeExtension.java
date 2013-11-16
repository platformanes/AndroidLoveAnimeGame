package com.anime.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version  Time：2013-5-8 
 */
public class AnimeExtension implements FREExtension {

	@Override
	public FREContext createContext(String arg0) {
		// TODO Auto-generated method stub
		return new AnimeContext();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

}
