package arteryServer;

import com.thunisoft.artery.parse.dataset.domain.IQueryInfo;
import com.thunisoft.artery.parse.support.context.LogicClassContext;

/**
 * b 服务器端逻辑类
 * 
 * @author Administrator
 * @date 2017-11-10
 * @id 97211d461500d71f7ade7bf0cca0bd59
 */
public class B {

	protected LogicClassContext context = LogicClassContext.getInstance();

	/**
	 * 数据源查询方法
	 * 
	 * @param qp
	 *            查询参数，只在分页查询时可用，否则为null
	 * @return Object 当为分页查询时，需要返回IPagableData对象，否则可为任意pojo
	 */
	public Object ds_rs1(IQueryInfo qp) {
		return context.queryPageDataBySql("select u_name,password from User", qp);
	}
	

}