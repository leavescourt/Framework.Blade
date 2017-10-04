package com.bingbinlee.blade.portal.service.impl;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.utils.HttpClientUtil;
import com.bingbinlee.blade.common.utils.JsonUtils;
import com.bingbinlee.blade.pojo.TbItemDesc;
import com.bingbinlee.blade.pojo.TbItemParamItem;
import com.bingbinlee.blade.portal.pojo.ItemInfo;
import com.bingbinlee.blade.portal.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品信息管理Service
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITME_INFO_URL}")
	private String ITME_INFO_URL;
	@Value("${ITEM_DESC_URL}")
	private String ITEM_DESC_URL;
	@Value("${ITEM_PARAM_URL}")
	private String ITEM_PARAM_URL;

	@Override
	public ItemInfo getItemById(Long itemId) {

		try {
			//调用rest的服务查询商品基本信息
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
			if (!StringUtils.isBlank(json)) {
				BladeResult bladeResult = BladeResult.formatToPojo(json, ItemInfo.class);
				if (bladeResult.getStatus() == 200) {
					ItemInfo item = (ItemInfo) bladeResult.getData();
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 	取商品描述
	 * @author	libingbin2015@aliyun.com
	 * @date	2016年10月1日下午9:11:51
	 */
	@Override
	public String getItemDescById(Long itemId) {
		try {
			//查询商品描述
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
			//转换成java对象
			BladeResult bladeResult = BladeResult.formatToPojo(json, TbItemDesc.class);
			if (bladeResult.getStatus() == 200) {
				TbItemDesc itemDesc = (TbItemDesc) bladeResult.getData();
				//取商品描述信息
				String result = itemDesc.getItemDesc();
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据商品id查询规格参数
	 * @author	libingbin2015@aliyun.com
	 * @date	2016年10月1日下午9:11:51
	 */
	@Override
	public String getItemParam(Long itemId) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
			//把json转换成java对象
			BladeResult bladeResult = BladeResult.formatToPojo(json, TbItemParamItem.class);
			if (bladeResult.getStatus() == 200) {
				TbItemParamItem itemParamItem = (TbItemParamItem) bladeResult.getData();
				String paramData = itemParamItem.getParamData();
				//生成html
				// 把规格参数json数据转换成java对象
				List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
				StringBuffer sb = new StringBuffer();
				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
				sb.append("    <tbody>\n");
				for(Map m1:jsonList) {
					sb.append("        <tr>\n");
					sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
					sb.append("        </tr>\n");
					List<Map> list2 = (List<Map>) m1.get("params");
					for(Map m2:list2) {
						sb.append("        <tr>\n");
						sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
						sb.append("            <td>"+m2.get("v")+"</td>\n");
						sb.append("        </tr>\n");
					}
				}
				sb.append("    </tbody>\n");
				sb.append("</table>");
				//返回html片段
				return sb.toString();
			}
				 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}

}
