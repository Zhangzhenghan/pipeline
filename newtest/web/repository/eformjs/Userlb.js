// **********************************************//
// user列表 客户端脚本
// 
// @author Artery
// @date 2017-11-10
// @id eff07b2419f179115e5bc6dc1b07e8f0
// **********************************************//




/**
 * 客户端(jqLinkb2293)
 * 
 * @param rc 系统提供的AJAX调用对象
 * @param {rs1.uid} uid
 */
function jqLinkb2293_onClickClient (rc, p_uid){
	Artery.confirmMsg("确认窗口","您确定要删除此记录?", function(bid){
		if(bid=="yes"){
			rc.put("p_uid", p_uid);

			rc.send(function(res){
				if(res=="ok"){
					Artery.showMessage("删除成功");
					Artery.get("jqGrid650bd").reload();
				}else{
					Artery.showError(res);
				}
			});
		}
	});
}