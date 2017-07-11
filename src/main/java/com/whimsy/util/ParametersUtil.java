package com.whimsy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 瀵瑰弬鏁扮殑澶勭悊鍙婇亶鍘嗗伐鍏�
 * 
 * @author wangbo
 *
 */
public class ParametersUtil {

	private final static Logger logger = LoggerFactory.getLogger(ParametersUtil.class);

	/**
	 * 鑾峰彇request璇锋眰涓墍鏈夊弬鏁板苟杞寲鎴怣ap瀵硅薄
	 * 
	 * @param params
	 *          {@code HttpServletRequest} 瀵硅薄鐨� <code>getParameterMap() <code> 鏂规硶鑾峰彇鍒扮殑鍊�
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> getParameters(Map<?, ?> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<?> set = params.entrySet();
		for (Object obj : set) {
			if (obj instanceof Entry) {
				Entry<?, ?> entry = (Entry<?, ?>) obj;
				if (entry.getValue() instanceof String[]) {
					String[] values = (String[]) entry.getValue();
					if (values.length > 1) {
						result.put(entry.getKey().toString().replaceAll("\\[\\]", ""), values);
					} else {
						result.put(entry.getKey().toString(), values[0]);
					}
				}
			}
		}
		return result;
	}

	/**
	 * 鑾峰彇request璇锋眰涓墍鏈夊弬鏁板苟杞寲鎴怣ap瀵硅薄锛岀涓�涓弬鏁颁箣鍚庣殑姣忎竴娆″弬鏁板�间负闇�瑕佹媶鍒嗙殑瀛楃涓�
	 * 
	 * @param params
	 *          {@code HttpServletRequest} 瀵硅薄鐨� <code>getParameterMap() <code> 鏂规硶鑾峰彇鍒扮殑鍊�
	 * @param parseParameterNames
	 * @return
	 */
	public static Map<String, Object> getParameters(Map<?, ?> params, String... parseParameterNames) {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<?> set = params.entrySet();
		for (Object obj : set) {
			for (String name : parseParameterNames) {
				if (obj instanceof Entry) {
					Entry<?, ?> entry = (Entry<?, ?>) obj;
					if (entry.getKey().toString().equals(name)) {
						result.put(entry.getKey().toString(), parseString(((String[]) entry.getValue())[0].trim(), ","));
						break;
					} else {
						result.put(entry.getKey().toString(), ((String[]) entry.getValue())[0].trim());
					}
				}
			}
		}
		return result;
	}

	/**
	 * 閬嶅巻map涓殑鍏冪礌
	 * 
	 * @param map
	 *          瑕侀亶鍘嗙殑map瀵硅薄
	 */
	public static void getAllMapElements(Map<?, ?> map) {
		logger.trace("寮�濮嬫娴嬩紶鍏ュ弬鏁般�傘�傘�傘�傘�傘��");
		if (map != null) {
			if (map.size() != 0) {
				Set<?> set = map.entrySet();
				logger.trace("Map鐨勯暱搴︿负" + map.size());
				for (Object entry : set) {
					if (entry instanceof Entry) {
						Entry<?, ?> elemetnt = (Entry<?, ?>) entry;
						logger.trace(elemetnt.getKey() + " , " + elemetnt.getValue());
					}
				}
			} else {
				logger.trace("浼犲叆Map闀垮害涓�0锛屼笉鑳介亶鍘�");
			}
		} else {
			logger.trace("鑾峰彇Map澶辫触锛岃纭浼犲叆Map鏄惁涓虹┖");
		}
		logger.trace("妫�娴嬩紶鍏ュ弬鏁板畬姣曘�傘�傘�傘�傘�傘��");
	}

	/**
	 * 閬嶅巻鎵�鏈塴ist
	 * 
	 * @param list
	 *          瑕侀亶鍘嗙殑list
	 * 
	 */
	public static void getAllArray(List<Object> list) {
		logger.trace("寮�濮嬫娴嬩紶鍏ュ弬鏁般�傘�傘�傘�傘�傘��");
		logger.trace("瑕侀亶鍘嗙殑List闆嗗悎闀垮害涓猴細" + list.size());
		for (int i = 0; i < list.size(); i++) {
			logger.trace("瑕侀亶鍘嗙殑List闆嗗悎闀垮害涓猴細" + list.get(i));
		}
		logger.trace("妫�娴嬩紶鍏ュ弬鏁板畬姣曘�傘�傘�傘�傘�傘��");
	}

	public static String[] parseString(String str, String regex) {
		return str.split(regex);
	}

	/**
	 * 灏唈s鐨刼bejct瀵硅薄鍚堝苟鎴怞AVA鐨凩ist瀵硅薄
	 * 
	 * @param params
	 * @return
	 */
	public static Map<?, ?> mergeJSObjectToList(Map params, String MapName) {
		Map result = new HashMap();
		Map maps = new HashMap();
		Set<String> keys = params.keySet();
		String prefix = "";
		for (String str : keys) {
			if (Pattern.matches("\\w+\\[\\w{0,}]", str)) {
				prefix = str.substring(0, str.indexOf("["));
				String key = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
				Map map = new HashMap();
				if (maps.containsKey(prefix)) {
					((Map) maps.get(prefix)).put(key, params.get(str));
				} else {
					map.put(key, params.get(str));
					maps.put(prefix, map);
				}
			} else {
				result.put(str, params.get(str));
			}
		}
		result.put(MapName, convertMapToList(maps));
		return result;
	}

	/**
	 * 灏唈s鐨刼bejct瀵硅薄鍚堝苟鎴怞AVA鐨凪ap瀵硅薄
	 * 
	 * @param params
	 * @return
	 */
	public static Map<String, Object> mergeJSObjectToMap(Map<?, ?> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		Set<?> keys = params.keySet();
		String prefix = "";
		for (Object obj : keys) {
			String str = obj.toString();
			if (Pattern.matches("\\w+\\[.{0,}]", str)) {
				prefix = str.substring(0, str.indexOf("["));
				String key = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
				Map<String, Object> map = new HashMap<String, Object>();
				if (result.containsKey(prefix)) {
					((Map) result.get(prefix)).put(key, params.get(str));
				} else {
					map.put(key, params.get(str));
					result.put(prefix, map);
				}
			} else {
				result.put(str, params.get(str));
			}
		}
		return result;
	}

	/**
	 * 灏哅ap 杞寲涓� List
	 * 
	 * @param source
	 * @return
	 */
	public static List<?> convertMapToList(Map<?, ?> source) {
		List<Object> result = new ArrayList<Object>();
		Set<?> set = source.keySet();
		for (Object key : set) {
			result.add(source.get(key));
		}
		return result;
	}

	public static List<?> sortList(List<?> list, Comparable<?> obj) {
		return null;
	}
}
