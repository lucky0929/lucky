package org.dateplanner.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

@Service
public class TestService {

	public String getData() { return "I am a boy"; }
	
	public JSONObject facebookLogin(String code) throws Exception{
		URL url = new URL("https://graph.facebook.com/v2.11/oauth/access_token?client_id=2032128690391759&redirect_uri=http://localhost/login/facebookLogin.do&client_secret=74be2c0fbdd71bddd240b3597ffaedea&code="+code);
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection(); 
//		urlConn.disconnect();
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(),"UTF-8"));
		JSONObject items = (JSONObject) JSONValue.parseWithException(br);
		String token = (String) items.get("access_token");
		
		URL url2 = new URL("https://graph.facebook.com/v2.11/me?fields=id,name,picture,gender,age_range&access_token="+token);
		HttpURLConnection urlConn2 = (HttpURLConnection)url2.openConnection();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(urlConn2.getInputStream(),"UTF-8"));
		JSONObject info = (JSONObject) JSONValue.parseWithException(br2);
		
		return info;
	}
	
	// (Receive authCode via HTTPS POST)

	public String google(String code) throws Exception{
//		if (request.getHeaders('X-Requested-With') == null) {
			// Without the `X-Requested-With` header, this request could be forged. Aborts.
//		}

		// Set path to the Web application client_secret_*.json file you downloaded from the
		// Google API Console: https://console.developers.google.com/apis/credentials
		// You can also find your Web application client ID and client secret from the
		// console and specify them directly when you create the GoogleAuthorizationCodeTokenRequest
		// object.
		String CLIENT_SECRET_FILE = "/path/to/client_secret.json";
		String authCode = code;
		String REDIRECT_URI = "";
		// Exchange auth code for access token
		GoogleClientSecrets clientSecrets =
				GoogleClientSecrets.load(
						JacksonFactory.getDefaultInstance(), new FileReader(CLIENT_SECRET_FILE));
		GoogleTokenResponse tokenResponse =
				new GoogleAuthorizationCodeTokenRequest(
						new NetHttpTransport(),
						JacksonFactory.getDefaultInstance(),
						"https://www.googleapis.com/oauth2/v4/token",
						clientSecrets.getDetails().getClientId(),
						clientSecrets.getDetails().getClientSecret(),
						authCode
						/*REDIRECT_URI*/)  // Specify the same redirect URI that you use with your web
				// app. If you don't have a web version of your app, you can
				// specify an empty string.
				.execute();

		String accessToken = tokenResponse.getAccessToken();

		// Use access token to call API
		GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);
		Drive drive =
				new Drive.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
				.setApplicationName("Auth Code Exchange Demo")
				.build();
		File file = drive.files().get("appfolder").execute();

		// Get profile info from ID token
		GoogleIdToken idToken = tokenResponse.parseIdToken();
		GoogleIdToken.Payload payload = idToken.getPayload();
		String userId = payload.getSubject();  // Use this value as a key to identify a user.
		String email = payload.getEmail();
		boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		String name = (String) payload.get("name");
		String pictureUrl = (String) payload.get("picture");
		String locale = (String) payload.get("locale");
		String familyName = (String) payload.get("family_name");
		String givenName = (String) payload.get("given_name");
		
		return userId;
	} //class TestService;
}