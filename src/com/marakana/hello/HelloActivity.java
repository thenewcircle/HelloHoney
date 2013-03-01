package com.marakana.hello;

import java.net.URI;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class HelloActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
//        String url = "http://html5demos.com/assets/dizzy.mp4";
//        url = "http://www.youtube.com/watch?v=uImk2RgCq_U&webm=1";
//        url = "http://www.youtube.com/demo/google_main.mp4";
//        url = "http://v4.lscache6.c.youtube.com/videoplayback?sparams=id%2Cexpire%2Cip%2Cipbits%2Citag%2Cratebypass%2Coc%3AU0hPR1BRVF9FSkNOOV9IS1hB&fexp=900017&itag=43&ipbits=0&signature=9E2549549DC9EB6589C4FCF92454BADC87E5EC8D.5A83384F9DE97CCEF2C72345A83FDC92BEEA654B&sver=3&ratebypass=yes&expire=1302066000&key=yt1&ip=0.0.0.0&id=92e467b5ad5ad0bf";
//        VideoView videoView = (VideoView) findViewById(R.id.video);
//        videoView.setVideoURI(Uri.parse(url));
//        videoView.start();
        
//        String html = "start<iframe class=\"youtube-player\" type=\"text/html\" width=\"640\" height=\"385\" src=\"http://www.youtube.com/embed/XFRS5j3BOkw\" frameborder=\"1\"></iframe>end";
//        html = "<video width=\"640\" height=\"385\"><source src=\"http://www.youtube.com/watch?v=uImk2RgCq_U&webm=1\" /></video>";
//        WebView webView = (WebView) findViewById(R.id.web);
//        webView.loadData(html, "text/html", "utf-8");
        
     // Make an oauth client (you'll want to change this bit)
        final String JTWITTER_OAUTH_KEY = "this_is_populated";
        final String JTWITTER_OAUTH_SECRET = "this_is_populated";

        OAuthSignpostClient oauthClient = new OAuthSignpostClient(JTWITTER_OAUTH_KEY, 
        JTWITTER_OAUTH_SECRET, "oob");
        // Open the authorisation page in the user's browser
        // On Android, you'd direct the user to URI url = client.authorizeUrl();
        // On a desktop, we can do that like this:
        URI url = oauthClient.authorizeUrl();
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(url.);
        startActivity(myIntent);

        // get the pin
        String v = oauthClient.askUser("Please enter the verification PIN from Twitter");
        oauthClient.setAuthorizationCode(v);
        // Store the authorisation token details for future use
        String[] accessToken = client.getAccessToken();
        // Next time we can use new OAuthSignpostClient(OAUTH_KEY, OAUTH_SECRET, 
//              accessToken[0], accessToken[1]) to avoid authenticating again.

        // Make a Twitter object
        Twitter twitter = new Twitter("my-name", oauthClient);
        // Print Daniel Winterstein's status
        System.out.println(twitter.getStatus("winterstein"));
        // Set my status
        twitter.setStatus("Messing about in Java");

        
    }
}