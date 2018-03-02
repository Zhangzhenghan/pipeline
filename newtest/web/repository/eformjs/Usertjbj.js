// **********************************************//
// user添加编辑 客户端脚本
// 
// @author Artery
// @date 2017-11-10
// @id ff66c52d3d83b1e8a2785f07f1c3ab92
// **********************************************//

/**
 * 客户端(jqButton6a668)
 * 
 * @param rc 系统提供的AJAX调用对象
 */
function jqButton6a668_onClickClient (rc){
	Artery.get("jqFormAreac87a4").submit(function(res){
		if(res=="ok"){
			Artery.showMessage("添加成功");
			Artery.getWin().get("jqGrid650bd").reload();
			Artery.getWin().close();
		}else{
			Artery.showError(res);
		}
	});
}

/**
 * 客户端(jqButton7874c)
 * 
 * @param rc 系统提供的AJAX调用对象
 */
function jqButton7874c_onClickClient (rc){
	Artery.get("jqFormAreac87a4").submit(function(res){
		if(res=="ok"){
			Artery.showMessage("保存成功");
			Artery.getWin().get("jqGrid650bd").reload();
			Artery.getWin().close();
		}else{
			Artery.showError(res);
		}
	});
}

/**
 * 客户端(jqButton9c97a)
 * 
 * @param rc 系统提供的AJAX调用对象
 */
function jqButton9c97a_onClickClient (rc){
	Artery.getWin().close();
}