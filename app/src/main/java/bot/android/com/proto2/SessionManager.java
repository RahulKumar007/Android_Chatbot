package bot.android.com.proto2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import static android.content.SharedPreferences.Editor;

/**
 * Created by admin on 07-04-2017.
 */

public class SessionManager {
    private final Context context;
    SharedPreferences pref;
    Editor editor;
    int MODE;
    private static final String PREF_NAME = "Notepad";
    public static final String IS_LOGGED = "IsLoggedIn";
    public static final String KEY_EMAIL = "email";
    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, MODE);
        editor = pref.edit();
    }
     public void createLoginSession(String email){
         editor.putBoolean(IS_LOGGED, true);
         editor.putString(KEY_EMAIL, email);
         editor.commit();
     }
     public HashMap<String, String> getUserDetails(){
         HashMap<String, String> user = new HashMap<String, String>();
         user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
         return user;
     }
    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }
    public void logoutUser(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGGED, false);
    }
}

