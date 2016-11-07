package mx.com.ipn.amaac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity{

    private static final long SPLASH_SCREEN_DELAY = 3000;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        preferences = getSharedPreferences("TerminosYCondiciones", MODE_PRIVATE);
        final boolean TERMINOS_Y_CONDICIONES= preferences.getBoolean("opcion", false);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Cuando pasen los 3 segundos, pasamos a la actividad princuipal de la aplicación
                Intent intent= new Intent(SplashScreen.this, TerminosYCondiciones.class);
                if(TERMINOS_Y_CONDICIONES == true){
                    intent= new Intent(SplashScreen.this, MainActivity.class);
                }

                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN_DELAY);

    }










}
