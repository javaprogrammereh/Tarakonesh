package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFERENCES_NAME = "user_shared_preferences";

    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, context.MODE_PRIVATE);
    }

    public userApp get_shared_preferences() {
        userApp user = new userApp();
        user.setFirst_time_run(sharedPreferences.getBoolean("first_time_run", true));
        return user;
    }

    public void set_false_first_time(userApp user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first_time_run", user.getFirst_time_run());
        editor.apply();
    }
}
