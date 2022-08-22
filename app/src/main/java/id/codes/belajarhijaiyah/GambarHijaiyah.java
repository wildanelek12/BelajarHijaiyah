package id.codes.belajarhijaiyah;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GambarHijaiyah extends AppCompatActivity {

    private ImageView imageView4;
    private ImageView icHome;
    private TextView tvSoal;
    private DrawView drawView;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar_hijaiyah);
        initView();
        ViewTreeObserver vto = drawView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                drawView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int width = drawView.getMeasuredWidth();
                int height = drawView.getMeasuredHeight();
                drawView.init(height, width);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawView.clear();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        icHome = (ImageView) findViewById(R.id.ic_home);
        tvSoal = (TextView) findViewById(R.id.tv_soal);
        drawView = (DrawView) findViewById(R.id.drawView);
        btnReset = (Button) findViewById(R.id.btn_reset);
    }
}