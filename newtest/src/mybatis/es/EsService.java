package mybatis.es;

import java.util.List;
import java.util.Map;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.util.HashMap;

import com.AcloudCoreUtil;
import com.HttpUtils;
import com.thunisoft.artery.util.ArteryWebUtil;
import net.sf.json.JSONObject;
import java.util.ArrayList;

import com.thunisoft.artery.util.uuid.UUIDHelper;

import mybatis.es.dao.EsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EsService implements IEsService{
	
	@Autowired
    private EsMapper mapper;
	@Autowired
	public void insertLogs(List<Map> lists) {
//		mapper.insertLogs(lists);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getlogs(){
		String uuid="";
		String url="http://177.16.124.8:9201/writ_stick_4cpwsw_v1/fycase/_search";
		
		String params = null;//24667497  4676814
		int newnum=4665468;
		while(true){
			List<Map> lists = new ArrayList<Map>();
			params="{\"query\": { \"match_all\": {}},\"from\" : "+newnum+", \"size\" : 200}";
			newnum=newnum+100;
			try {
				String responseText = HttpUtils.post(url,params);
				Map logresult = JSONObject.fromObject(responseText);
				List<Object> logs = (List<Object>) AcloudCoreUtil.getDatabyXpath(logresult, "/hits/hits/_source/QW", true);
				for (int i = logs.size() - 1; i >= 0; i--) {
					Map lmap=new HashMap();
					uuid = UUIDHelper.getUuid();
	                Map log = (Map) logs.get(i);
	                String message =(String) log.get("@value");
	                if(message==null || message==""){
	                	continue;
	                }
	                message=message.trim();
	                String regex = "\"([\"]*)";
	                Pattern pattern = Pattern.compile(regex);
	                Matcher matcher = pattern.matcher(message);

	                String reCT=message;

	                while(matcher.find()){
	                    String itemMatch = "“" + matcher.group(1) + "”";
	                    message=reCT.replace("\""+matcher.group(1)+"\"", itemMatch);
	                }
	            	lmap.put("id", uuid);
	                lmap.put("value", message);
	                lists.add(lmap);
	            }
				JDBC jdbc=new JDBC();
				String sql="insert into es(id,value) values(?,?)";
				jdbc.insertInfo(lists, sql);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

	public static void main(String[] args) {
		EsService es =new EsService();
		es.getlogs();
	}
	

}
