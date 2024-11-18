package com.example.check;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageButton myButton7;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myButton7 = findViewById(R.id.myButton7);
        constraintLayout = findViewById(R.id.constraintLayout);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClick(View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            myButton7.setVisibility(View.INVISIBLE);
            constraintLayout.setBackground(getDrawable(R.drawable.fcvdes));
            Toast.makeText(getApplicationContext(), "Подключение есть \nДобро пожаловать", Toast.LENGTH_SHORT).show();
        } else {
            myButton7.setVisibility(View.INVISIBLE);
            constraintLayout.setBackground(getDrawable(R.drawable.house));
            Toast.makeText(getApplicationContext(), "Подключения нет \nПопробуйте снова", Toast.LENGTH_SHORT).show();
        }
    }
}