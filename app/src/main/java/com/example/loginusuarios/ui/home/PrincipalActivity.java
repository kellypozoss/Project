package com.example.loginusuarios.ui.home;

import androidx.appcompat.app.AppCompatActivity;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.os.Build;
import android.view.View;
import android.widget.Button;


import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.view.PieChartView;
import lecho.lib.hellocharts.model.SliceValue;
import android.graphics.Color;
import android.os.Bundle;

import com.example.loginusuarios.R;
import com.example.loginusuarios.RatingActivity;

import java.util.ArrayList;
import java.util.List;


public class PrincipalActivity extends AppCompatActivity {


    PieChartView pieChartView;
    Button btnRating, btnNotificacion;
    private PendingIntent pendingIntent;
    private final static String CHANNEL_ID = "NOTIFICACION";
    private final static int NOTIFICACION_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnRating = (Button) findViewById(R.id.btnRating);
        btnNotificacion = (Button) findViewById(R.id.btnNotificacion);
        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotificationChannel();
                createNotification();
            }
        });

        PieChartView pieChartView = findViewById(R.id.chart);

        pieChartView = findViewById(R.id.chart);

        List pieData = new ArrayList<>();
        pieData.add(new SliceValue(55, Color.BLUE).setLabel("55% Lleno"));
        pieData.add(new SliceValue(45, Color.LTGRAY).setLabel("45% Vacío"));


        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("AGUA EN EL TINACO").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#1A2586"));
        pieChartView.setPieChartData(pieChartData);



    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.soltar);
        builder.setContentTitle("WATER CARE");
        builder.setContentText("Alerta! Su tinaco se esta quedando sin agua");
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
    }


    public void rating(View view){
        Intent intent = new Intent(PrincipalActivity.this, RatingActivity.class);
        startActivity(intent);
    }
}
