package ws;

import java.util.HashMap;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;

public class HashSubscription extends AbstractTransformer {
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		return adapt((Object[]) src);
	}
	
	public HashMap<String, String> adapt(Object[] src) {
		for(Object aux : src) {
			System.out.println((String)aux);
		}
		HashMap<String, String> result = new HashMap<String,String>();
		result.put("email", (String)src[0]);
		result.put("course", (String)src[1]);
		
		return result;
	}
}
