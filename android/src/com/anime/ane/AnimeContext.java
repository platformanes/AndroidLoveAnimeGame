package com.anime.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.anime.func.AnimeExit;
import com.anime.func.AnimeInit;
import com.anime.func.AnimeOrdersn;
import com.anime.func.AnimePay;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version  Time：2013-5-8 
 */
public class AnimeContext extends FREContext {
	/**
	 * INIT sdk
	 */
	public static final String ANIME_FUNCTION_INIT = "anime_function_init";
	/**
	 * 查询
	 */
	public static final String ANIME_FUNCTION_ORDER = "anime_function_ordersn";
	/**
	 * 付费Key
	 */
	public static final String ANIME_FUNCTION_PAY = "anime_function_pay";
	/**
	 * 退出Key
	 */
	public static final String ANIME_FUNCTION_EXIT = "anime_function_exit";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
//	       //映射
		   map.put(ANIME_FUNCTION_INIT, new AnimeInit());
	       map.put(ANIME_FUNCTION_ORDER, new AnimeOrdersn());
	       map.put(ANIME_FUNCTION_PAY, new AnimePay());
	       map.put(ANIME_FUNCTION_EXIT, new AnimeExit());
	       return map;
	}

}
