package arteryServer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.thunisoft.artery.parse.dataset.domain.IPagableData;
import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.dataset.mybatis.IMybatisQueryWrapper;
import com.thunisoft.artery.parse.support.context.LogicClassContext;
import com.thunisoft.artery.plugin.base.Item;
import com.thunisoft.artery.util.ArteryParamUtil;
import mybatis.dao.UserMapper;
/**
 * user列表 服务器端逻辑类
 * 
 * @author Artery
 * @date 2017-11-10
 * @id eff07b2419f179115e5bc6dc1b07e8f0
 */
public class Userlb{
	protected LogicClassContext context = LogicClassContext.getInstance();
	
	@Autowired
	private UserMapper userMapper;
	/**
	 * 数据源查询方法
	 * 
	 * @param qp
	 *            查询参数，只在分页查询时可用，否则为null
	 * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
	 */
	public Object ds_rs1(IQueryInfo qp) {
		IPagableData answer = context.queryPageDataForMybatis(qp, new IMybatisQueryWrapper() {
			
			public Collection executeQuery() {
				return userMapper.selectAll();
			}
		});
		return answer;
	}

	/**
	 * 点击时脚本
	 * 
	 * @param item
	 *            控件对象
	 */
	public Object jqLinkb2293_onClickServer(Item item) {
		userMapper.deleteByPrimaryKey(ArteryParamUtil.getInteger("p_uid"));
		return "ok";
	}

}