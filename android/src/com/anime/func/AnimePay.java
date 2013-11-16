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
public class AnimePay implements FREFunction {

	private String TAG = "AnimePay";
	private FREContext _context;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		MCRegistration mc;
		String goodName = null;
		String goodSn = "10001";
		String goodPrice = "0.1";
		int goodNum = 1;
		String extention = null;
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做付费的操作 
		try
		{
			goodName = arg1[0].getAsString();
			goodSn = arg1[1].getAsString();
			goodPrice = arg1[2].getAsString();
			goodNum = arg1[3].getAsInt();
			extention = arg1[4].getAsString();
			
			callBack("goodName:"+goodName);
			callBack("goodSn:"+goodSn);
			callBack("goodPrice:"+goodPrice);
			callBack("goodNum:"+goodNum);
			callBack("extention:"+extention);
		}
		catch (Exception e) {
			// TODO: handle exception
			callBack("argv is error");
			return null;
		}
		
		mc = new MCRegistration();
		ContentValues data = new ContentValues();
		data.put("appId", AnimeInit.APPID);
		data.put("price", goodPrice);
		data.put("goodname", goodName);
		data.put("goodsn", goodSn);
		data.put("num", goodNum);
		data.put("secretKey", AnimeInit.SECRETKEY);
		data.put("extention", extention);
		Gson gson = new Gson();
		String str = gson.toJson(data);
		
		try {
			JSONObject jsonObject = new JSONObject(str);
			String json = jsonObject.getString("mValues");	
			callBack("json:"+json);
			mc.commonBussinessFunction(_context.getActivity(), 2, null,
					null, json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			callBack("JSONObject or mc is error");
			return null;
		}
		
		callBack("success");
		//--------------------------------
		
		return result;
	}
	
	public void callBack(String status){
		Log.d(TAG, "---callBack------"+status);
		_context.dispatchStatusEventAsync(TAG, "callBack:"+status);
	}
}
