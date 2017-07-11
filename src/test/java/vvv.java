import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class vvv {
	public static void main(String[] args) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Object> resultList = new ArrayList<Object>();
		result.put("a", 1);
		resultList.add(0,result);
		System.out.println(resultList);
		result = new HashMap<String, Object>();
		result.put("a", 2);
		resultList.add(1,result);
		System.out.println(resultList);
		result = new HashMap<String, Object>();
		result.put("a", 3);
		resultList.add(2,result);
		System.out.println(resultList);
	}
}
