package com.anime.ane 
{ 
	/**
	 * @author Rect
	 * @see rectvv@gmail.com
	 * @see www.shadowkong.com
	 * @see github.com/platformanes
	 * @version  Time：2013-5-8 
	 */
	public class AnimeEvents 
	{ 
		public function AnimeEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 *init 
		 */		
		public static const ANIME_SDK_STATUS:String = "AnimeInit";
		/**
		 * 用户登录
		 */
		public static const ANIME_ORDER_STATUS : String = "AnimeOrdersn";
		
		/**
		 * 用户注销
		 */
		public static const ANIME_LOGOUT_STATUS : String = "AnimeExit";
		
		/**
		 * 充值
		 */
		public static const ANIME_PAY_STATUS : String = "AnimePay";
		
		public static const ANIME_SERVER_STATUS : String = "AnimeMcIntentService";
	} 
}