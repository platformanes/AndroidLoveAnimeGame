package com.anime.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.ffcs.android.mc.BusinessFunction;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version  Time：2013-5-8 
 */
public class AnimeInit implements FREFunction {

	private String TAG = "AnimeInit";
	private FREContext _context;
	public  static String APPID = "dm_open_test";								
	public  static String SECRETKEY = "02d5efced14e2bf6ef24045df1cfd495";
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		McIntentService.setFreContext(context);
		// TODO Auto-generated method stub
		//--------------------------------
		try
		{
			APPID = arg1[0].getAsString();
			SECRETKEY = arg1[1].getAsString();
			
			callBack("APPID:"+APPID);
			callBack("SECRETKEY:"+SECRETKEY);
		}
		catch (Exception e) {
			// TODO: handle exception
			callBack("arge is error");
			return null;
		}
		//初始化SDK
		BusinessFunction.getInstance(_context.getActivity()).startCoreService();
		//在这里做初始化的操作 我这里直接传回。。
		callBack("success");
		//--------------------------------
		
		return result;
	}
	
	public void callBack(String status){
		Log.d(TAG, "----callBack-----"+status);
		_context.dispatchStatusEventAsync(TAG, "callBack:"+status);
	}

}
