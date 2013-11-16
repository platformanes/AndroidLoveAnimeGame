package com.anime.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * @author Rect
	 * @see rectvv@gmail.com
	 * @see www.shadowkong.com
	 * @see github.com/platformanes
	 * @version  Time：2013-5-8 
	 */
	public class AnimeExtension extends EventDispatcher 
	{ 
		public static const ANIME_FUNCTION_INIT:String = "anime_function_init";//与java端中Map里的key一致
		public static const ANIME_FUNCTION_ORDER:String = "anime_function_ordersn";//与java端中Map里的key一致
		public static const ANIME_FUNCTION_PAY:String = "anime_function_pay";//与java端中Map里的key一致
		public static const ANIME_FUNCTION_EXIT:String = "anime_function_exit";//与java端中Map里的key一致
		
		public static const EXTENSION_ID:String = "com.anime.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:AnimeExtension; 
		public function AnimeExtension(target:IEventDispatcher=null)
		{
			super(target);
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			
		} 
		
		//第二个为参数，会传入java代码中的FREExtension的createContext方法
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():AnimeExtension
		{
			if(_instance == null) 
				_instance = new AnimeExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		/**
		 *init发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function AnimeInit(appID:String,appSecretkey:String):String{
			if(extContext ){
				return extContext.call(ANIME_FUNCTION_INIT,appID,appSecretkey) as String;
			}
			return "call login failed";
		} 
		
		/**
		 *登录发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function AnimeOrdersn(key:int):String{
			if(extContext ){
				return extContext.call(ANIME_FUNCTION_ORDER,key) as String;
			}
			return "call login failed";
		} 
		/**
		 * 
		 * @param goodName
		 * @param goodSn
		 * @param goodPrice
		 * @param goodNum
		 * @param extention
		 * @return 
		 * 
		 */			 
		public function AnimePay(goodName:String,goodSn:String,goodPrice:String,goodNum:int,extention:String):String{
			if(extContext){ 
				return extContext.call(ANIME_FUNCTION_PAY,goodName,goodSn,goodPrice,goodNum,extention)as String;
			}
			return "call pay failed";
		}
		
		/**
		 *退出SDK时候调用   这个函数只在退出游戏的时候调用  
		 * @param key
		 * @return 
		 * 
		 */		
		public function AnimeExit(key:int):String{
			if(extContext){ 
				return extContext.call(ANIME_FUNCTION_EXIT,key) as String;
			}
			return "call exit failed";
		}
	} 
}