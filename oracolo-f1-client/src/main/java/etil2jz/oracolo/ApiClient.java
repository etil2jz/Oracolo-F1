package etil2jz.oracolo;

import okhttp3.OkHttpClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiClient {
	private static final Logger logger = LogManager.getLogger(ApiClient.class);

	private static final String BASE_URL = "http://localhost:8080/api";
	private static final OkHttpClient client = new OkHttpClient();
	private static String jwtToken;

	public static boolean register(String username, String password) {
		return false;
	}

	public static boolean login(String username, String password) {
		return false;
	}
}
