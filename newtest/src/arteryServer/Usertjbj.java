package arteryServer;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import mybatis.dao.UserMapper;
import mybatis.pojo.User;


/**
 * user添加编辑 服务器端逻辑类
 * 
 * @author Artery
 * @date 2017-11-10
 * @id ff66c52d3d83b1e8a2785f07f1c3ab92
 */
public class Usertjbj{
	protected LogicClassContext context = LogicClassContext.getInstance();
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 生成时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public void pkFiled_onShow(Item item) {
		if(context.getRunTimeType().equals("insert")){
			item.set("dataName", "");
		}
	}

	/**
	 * 生成时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public void jqButton6a668_onShow(Item item) {
		if(!context.getRunTimeType().equals("insert")){
			item.set("show", "false");
		}
	}

	/**
	 * 生成时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public void jqButton7874c_onShow(Item item) {
		if(!context.getRunTimeType().equals("update")){
			item.set("show", "false");
		}
	}
	
	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButton6a668_onClickServer(Item item) {
		User record = (User)ArteryParamUtil.getPojo(User.class, "User");
		userMapper.insert(record);
		return "ok";
	}

	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqButton7874c_onClickServer(Item item) {
		User record = (User)ArteryParamUtil.getPojo(User.class, "User");
		userMapper.updateByPrimaryKey(record);
		return "ok";
	}
	
	/**
	 * 数据源查询方法
	 * 
	 * @param qp
	 *            查询参数，只在分页查询时可用，否则为null
	 * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
	 */
	public Object ds_rs1(IQueryInfo qp) {
		return userMapper.selectByPrimaryKey(ArteryParamUtil.getInteger("p_uid"));
	}
}