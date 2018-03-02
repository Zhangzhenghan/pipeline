// **********************************************//
// ceshi 客户端脚本
// 
// @author Administrator
// @date 2017-11-09
// @id 297ea75ccd7941600a77e96d69f83ef1
// **********************************************//
/**
 * onClickClient(jqButtonfd90d)
 * 
 * @param  rc 系统提供的AJAX调用对象
 */
function jqButtonfd90d_onClickClient (rc){
//	Artery.showMessage("提示消息...");
//	alert(Artery.get("jqInput84782").getValue());//消息提示，显示文本框中输入的内容
//	rc.put("send",Artery.get("jqInput84782").getValue());
	rc.send(function (result){
		
	})
	
}
/**
 * 验证脚本(jqInput84782)
 * 
 * @param  rc 系统提供的AJAX调用对象
 * @param  value 控件的值
 */
function jqInput84782_onValidClient (rc, value){
	
}
/**
 * 验证脚本(jqSelectListea3a6)
 * 
 * @param  rc 系统提供的AJAX调用对象
 * @param  value 控件的值
 */
function jqSelectListea3a6_onValidClient (rc, valueText){
	var value = this.getValue();
	rc.put("value", value);
	rc.put("valueText", valueText);
	rc.asyn = false;
	rc.send();
	if (rc.result == "ok") {
		return true;
	}
	return "验证不通过";
}