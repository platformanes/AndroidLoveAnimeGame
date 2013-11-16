package com.anime.func;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.ffcs.android.mc.MCRegistration;
import com.google.gson.Gson;

/**
 * @author Rect
 * @see rectvv@gmail.com
 * @see www.shadowkong.com
 * @see github.com/platformanes
 * @version  Time：2013-5-8 
 */
public class AnimeOrdersn implements FREFunction {

	private String TAG = "AnimeOrdersn";
	private FREContext _context;
	public static String Anime_Ordersn = "";
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null;  
		MCRegistration mc;
		// TODO Auto-generated method stub
		//--------------------------------
		
		if("" == Anime_Ordersn)
		{
			callBack("Anime_Ordersn is null----[温馨提示,需要购买过才可查询 by Rect]");
			return null;
		}
		
		mc = new MCRegistration();
		
		ContentValues data2 = new ContentValues();
		data2.put("appId", AnimeInit.APPID);
		data2.put("ordersn", Anime_Ordersn);			
		data2.put("secretKey", AnimeInit.SECRETKEY);
		Gson gson2 = new Gson();
		String str2 = gson2.toJson(data2);
		try {
			JSONObject jsonObject = new JSONObject(str2);
			String json = jsonObject.getString("mValues");
			callBack("json:"+json);
			mc.commonBussinessFunction(_context.getActivity(), 3, null,
					null, json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			callBack("JSONObject is error");
			return null;
		}
		
		callBack("success");
		//--------------------------------
		
		return result;
	}
	
	public void callBack(String status){
		Log.d(TAG, "----callBack-----"+status);
		_context.dispatchStatusEventAsync(TAG, "callBack:"+status);
	}
}
