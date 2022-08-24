package id.codes.belajarhijaiyah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvHijaiyah;
    private ImageView imgHurufHijaiyah;
    private ImageView imgSambungHuruf;
    private ImageView imgPecahHuruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        imgHurufHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,KumpulanHijaiyahActivity.class);
                startActivity(intent);
            }
        });
        imgPecahHuruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BelajarMenyambungActivity.class);
                startActivity(intent);
            }
        });
        imgSambungHuruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GambarHijaiyah.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {

        imgHurufHijaiyah = (ImageView) findViewById(R.id.imgHurufHijaiyah);
        imgSambungHuruf = (ImageView) findViewById(R.id.imgSambungHuruf);
        imgPecahHuruf = (ImageView) findViewById(R.id.imgPecahHuruf);
    }
}