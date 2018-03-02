package arteryServer;

import mybatis.es.EsService;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;

/**
 * 测试表单 服务器端逻辑类
 * 
 * @author Administrator
 * @date 2018-01-30
 * @id 32b8b434f02bf9d4c4bc814b79fcaf0e
 */
public class Csbd {

	protected LogicClassContext context = LogicClassContext.getInstance();
	@Autowired
	private EsService esservice;

	/**
	 *  按钮
	 * 
	 * @param item
	 *            控件对象
	 */
	public void jqButton47c48_onShow(Item item) {
		esservice.getlogs();
	}
	

}