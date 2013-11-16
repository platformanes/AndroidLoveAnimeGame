package com.anime.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version  Time：2013-5-8 
 */
public class AnimeExit implements FREFunction {

	private String TAG = "AnimeExit";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做清理环境的操作 我这里直接传回。。
		AnimeInit.APPID = null;
		AnimeInit.SECRETKEY = null;
		AnimeOrdersn.Anime_Ordersn = null;
		callBack("success");
		//--------------------------------
		
		return result;
	}

	/**
	 * 清理环境回调 把清理环境结果传给AS端
	 */
	public void callBack(String status){
		Log.d(TAG, "---------清理环境返回-------");
		_context.dispatchStatusEventAsync(TAG, "清理环境回调:"+status);
	}

}
