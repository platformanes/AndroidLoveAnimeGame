package com.anime.func;

import java.util.ArrayList;
import org.json.JSONObject;

import com.adobe.fre.FREContext;
import com.ffcs.android.mc.MCBaseIntentService;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class McIntentService extends MCBaseIntentService {
	
	private static FREContext _context;
	
	private String TAB = "AnimeMcIntentService";
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			String str = "";
			switch (msg.what) {
			case -1:
				str += "resultCode:" + msg.getData().getInt("r");
				str += "\t seq:" + msg.getData().getString("seq");
				break;
			case 0:
				str += "resultCode:" + msg.getData().getInt("r");
				str += "\t seq:" + msg.getData().getString("seq");
				str += "\t status:" + msg.getData().getInt("status");
				str += "\t 订单号:" + msg.getData().getString("ordersn");
				break;
			case 1:
				str += "resultCode:" + msg.getData().getInt("r");
				str += "\t seq:" + msg.getData().getString("seq");
				str += "\t 订单号:" + msg.getData().getString("ordersn");
				break;
			case 2:
				str += "resultCode:" + msg.getData().getInt("r");
				str += "\t seq:" + msg.getData().getString("seq");
				str += "\t 订单号:" + msg.getData().getString("ordersn");
				break;
			}

			callBack(str + "\r\n");
			// Toast.makeText(McIntentService.this,seq, 3000).show();
		};
	};
	
	public void callBack(String status){
		Log.d(TAB, "----返回-------"+status);
		if(null != _context)
			_context.dispatchStatusEventAsync(TAB, "回调:"+status);
		else
			Log.d(TAB, "---context is null-");
	}
	
	public static void setFreContext(FREContext ctx)
	{
		_context = ctx;
	}
	
	@Override
	public void handleMessage(ArrayList<JSONObject> messages) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleSMSReceipt(String seqid, String receiptResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCommonBussiness(Bundle bundle) {
		int bt = bundle.getInt("bt");
		switch (bt) {
		case -1:// 返回err信息
			callBack("错误代码  r >>>>>>>>>> " + bundle.getInt("r")
					+ "  ：： seq >>>>>>>>>> " + bundle.getString("seq")
					+ "  pn ====>>>" + getPackageName());
			break;
		case 0:// 返回订单查询结果
			callBack("查询结果  r >>>>>>>>>> " + bundle.getInt("r")
					+ "  ：： seq >>>>>>>>>> " + bundle.getString("seq")
					+ "  pn ====>>>" + getPackageName());
			break;
		case 1:// 返回订购或退订结果
			callBack("订购结果   r >>>>>>>>>> " + bundle.getInt("r")
					+ "  ：： ordersn >>>>>>>>>> " + bundle.getString("ordersn")
					+ "  ：： seq >>>>>>>>>> " + bundle.getString("seq")
					+ "  pn ====>>>" + getPackageName());
			
			callBack(bundle.getString("ordersn"));
			AnimeOrdersn.Anime_Ordersn = bundle.getString("ordersn");
			break;
		case 2:// 返回轮询结果
			callBack("支付结果   r >>>>>>>>>> " + bundle.getInt("r")
					+ "  ：： ordersn >>>>>>>>>> " + bundle.getString("ordersn")
					+ "  ：： seq >>>>>>>>>> " + bundle.getString("seq")
					+ "  pn ====>>>" + getPackageName());
			callBack(bundle.getString("ordersn"));
			AnimeOrdersn.Anime_Ordersn = bundle.getString("ordersn");
			break;
		default:
			break;
		}
		Message msg = mHandler.obtainMessage();
		msg.what = bt;
		msg.setData(bundle);
		msg.sendToTarget();
	}
}
