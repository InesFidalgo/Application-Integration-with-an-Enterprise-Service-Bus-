import java.util.concurrent.Callable;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterApp{

	public static void main(String[] args) {
		try {
			new TwitterApp().call("Teste TESTE 123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void call(String text){
		String tokenS = "V2bujj0zOsHys6oVDeyTnZNHd";
		String tokenA = "cLaq6NNr0HTTf47pO5rxu1LLROrhYUINMogx43XPAQDchjhpEa";
		// The factory instance is re-useable and thread safe.
	    TwitterFactory factory = new TwitterFactory();
	    AccessToken accessToken = loadAccessToken();
	    Twitter twitter = factory.getInstance();
	    twitter.setOAuthConsumer(tokenS, tokenA);
	    twitter.setOAuthAccessToken(accessToken);
	    Status status=null;
		try {
			status = twitter.updateStatus(text);
		} catch (TwitterException e) {
			System.out.println("erro twitter");
		}
	}
	
	  private static AccessToken loadAccessToken(){
	    String token = "810538140855373825-DfTKpt8xTASdWgO8OB1OhlyqK0sZjkW";
	    String tokenSecret = "TljtQNCaxz74OekGIlk4Qu9PvEH33wBmo51Lun1Hm92w3";
	    return new AccessToken(token, tokenSecret);
	  }
}