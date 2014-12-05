package com.parse.starter;

//import java.util.Scanner;

import android.app.Application;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.PushService;
import com.parse.SignUpCallback;


public class ParseApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // Add your initialization code here

    Parse.initialize(this, "wRxgdWYi8ihBguJB0JUNveNFrEgpoeOi2kn7Zb0T", "YvMevyPJ63zD5cSjDScxyll4q92V8ryHeJoqmXUx");
    //PushService.setDefaultPushCallback(this, Jive.class);
    
    //  //create a new user 
    ParseUser user = new ParseUser();
    user.setUsername("KevinBlohm");
    user.setPassword("TestPass");
    user.setEmail("kblohm13@gmail.com");
      
    // other fields can be set just like with ParseObject
    user.put("phone", "415-298-8213");
      
  
    user.signUpInBackground(new SignUpCallback() {
      public void done(ParseException e) {
        if (e == null) {
          // Hooray! Let them use the app now.
        } else {
          // Sign up didn't succeed. Look at the ParseException
          // to figure out what went wrong
        }
      }
    });
    
    ParseObject testObject = new ParseObject("TestObject");
    testObject.put("foo", "you");
    testObject.saveInBackground();
    
    ParseObject EnterEvent = new ParseObject("EnterEvent");
    EnterEvent.put("foo", "you");
    EnterEvent.saveInBackground();
    
    //Scanner sc = new Scanner(System.in);
    ParseObject Input = new ParseObject("Input");
    Input.put("foo", "name");
    Input.saveInBackground();

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
      
    // If you would like all objects to be private by default, remove this line.
    defaultACL.setPublicReadAccess(true);
    
    ParseACL.setDefaultACL(defaultACL, true);
    
    ParseQuery<ParseObject> query = ParseQuery.getQuery("Input");
    query.getInBackground("xWMyZ4YEGZ", new GetCallback<ParseObject>() {
      public void done(ParseObject object, ParseException e) {
        if (e == null) {
        	System.out.println("Input");
        	System.out.println("name2");
          // object will be your game score
        } else {
          System.out.println("oops");
        }
      }
    });
    
    //String event = Input.getString("Input");
    //System.out.println(event);
    
    
  }
}


