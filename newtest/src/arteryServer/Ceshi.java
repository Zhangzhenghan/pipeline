package arteryServer;

import com.mchange.lang.StringUtils;
import com.mchange.v1.util.CollectionUtils;
import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;

/**
 * ceshi 服务器端逻辑类
 * 
 * @author Administrator
 * @date 2017-11-09
 * @id 297ea75ccd7941600a77e96d69f83ef1
 */
public class Ceshi {

	protected LogicClassContext context = LogicClassContext.getInstance();

	
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButtonfd90d_onClickServer(Item item) {
		System.out.println(ArteryParamUtil.getString("send"));//
		return null;
	}


	
	/**
	 * 验证时脚本({itemid})
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqInput84782_onValidServer(Item item) {
		String value = ArteryParamUtil.getString("value");
		return null;
	}



	/**
	 * 数据源查询方法
	 * 
	 * @param qp
	 *            查询参数，只在分页查询时可用，否则为null
	 * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
	 */
	public Object ds_rs1(IQueryInfo qp) {
		return context.queryPageDataBySql("select u_name from User", qp);
//		return null;
	}
	

}