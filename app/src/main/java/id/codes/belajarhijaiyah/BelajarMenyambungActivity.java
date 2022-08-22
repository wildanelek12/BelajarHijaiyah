package id.codes.belajarhijaiyah;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import cn.pedant.SweetAlert.SweetAlertDialog;
import id.codes.belajarhijaiyah.Adapter.HijaiyahAdapter;

public class BelajarMenyambungActivity extends AppCompatActivity implements HijaiyahAdapter.ItemClickListener {


    String randomize_hijaiyah[] = {"ا", "ب", "ت", "ث", "ج", "ح", "خ", "د", "ذ", "ر", "ز", "س", "ش", "ص", "ض", "ط", "ظ", "ع", "غ", "ف", "ق", "ك", "ل", "م", "ن", "ه", "و", "ي"};
    String jawaban_list[] = {"ا", "ب", "ت", "ث", "ج", "ح", "خ", "د", "ذ", "ر", "ز", "س", "ش", "ص", "ض", "ط", "ظ", "ع", "غ", "ف", "ق", "ك", "ل", "م", "ن", "ه", "و", "ي"};

    ArrayList<String> jawaban = new ArrayList<String>();

    String hijaiyah = "";
    int index = 1;
    int nilai = 0;
    private ImageView icHome;
    private RecyclerView recyclerView;
    HijaiyahAdapter hijaiyahAdapter;
    private TextView tvJawaban1;
    private TextView tvJawaban3;
    private TextView tvJawaban2;
    private TextView tvSoal;
    private ConstraintLayout clJawaban1;
    private ConstraintLayout clJawaban3;
    private ConstraintLayout clJawaban2;
    private Button btnReset;
    int counter;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_menyambung);
        initView();

        setSoal();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        hijaiyahAdapter = new HijaiyahAdapter(this, jawaban_list);
        hijaiyahAdapter.setClickListener(this);
        recyclerView.setAdapter(hijaiyahAdapter);

        icHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                setSoal();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetKolom();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(jawaban.size()<3){
                    new SweetAlertDialog(BelajarMenyambungActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Terimakasih")
                            .setContentText("Kalian telah menjawab "+counter+ " soal dan "+nilai+ " soal benar")
                            .setConfirmText("Oke")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    finish();
                                }
                            }).show();
                }else {
                    clJawaban1.setBackgroundColor(Color.parseColor("#47BB94"));
                    tvJawaban1.setText(jawaban.get(2));
                    btnReset.setVisibility(View.INVISIBLE);
                    new SweetAlertDialog(BelajarMenyambungActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Terimakasih")
                            .setContentText("Kalian telah menjawab " + counter + " soal dan " + nilai + " soal benar")
                            .setConfirmText("Oke")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                    finish();
                                }
                            }).show();
                }
            }
        });
    }


    public void setSoal() {
        btnReset.setVisibility(View.VISIBLE);
        hijaiyah = "";
        Collections.shuffle(Arrays.asList(randomize_hijaiyah));
        for (int i = 0; i < 3; i++) {
            hijaiyah += randomize_hijaiyah[i];
        }
        tvSoal.setText(hijaiyah);
    }


    private void initView() {

        icHome = (ImageView) findViewById(R.id.ic_home);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tvJawaban1 = (TextView) findViewById(R.id.tv_jawaban_1);
        tvJawaban3 = (TextView) findViewById(R.id.tv_jawaban_3);
        tvJawaban2 = (TextView) findViewById(R.id.tv_jawaban_2);
        tvSoal = (TextView) findViewById(R.id.tv_soal);
        clJawaban1 = (ConstraintLayout) findViewById(R.id.cl_jawaban_1);
        clJawaban3 = (ConstraintLayout) findViewById(R.id.cl_jawaban_3);
        clJawaban2 = (ConstraintLayout) findViewById(R.id.cl_jawaban_2);
        btnReset = (Button) findViewById(R.id.btn_reset);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
    }


    @Override
    public void onItemClick(View view, int position) {
        jawaban.add(hijaiyahAdapter.getItem(position));
        if (jawaban.size() == 1) {
            clJawaban3.setBackgroundColor(Color.parseColor("#47BB94"));
            tvJawaban3.setText(hijaiyahAdapter.getItem(position));
        } else if (jawaban.size() == 2) {
            clJawaban2.setBackgroundColor(Color.parseColor("#47BB94"));
            tvJawaban2.setText(hijaiyahAdapter.getItem(position));
        } else if (jawaban.size() == 3) {
            if (counter < 29) {
                String jawaban_hijaiyah = "";
                for (int i = 0; i < jawaban.size(); i++) {
                    jawaban_hijaiyah += jawaban.get(i);
                }

                if (jawaban_hijaiyah.equals(hijaiyah)) {
                    clJawaban1.setBackgroundColor(Color.parseColor("#47BB94"));
                    tvJawaban1.setText(hijaiyahAdapter.getItem(position));
                    btnReset.setVisibility(View.INVISIBLE);

                    new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Horay")
                            .setContentText("Anda menjawab dengan benar")
                            .setConfirmText("Oke")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    counter++;
                                    nilai++;
                                    setSoal();
                                    resetKolom();
                                    sDialog.dismissWithAnimation();
                                }
                            }).show();
                } else {
                    clJawaban1.setBackgroundColor(Color.parseColor("#47BB94"));
                    tvJawaban1.setText(hijaiyahAdapter.getItem(position));
                    btnReset.setVisibility(View.INVISIBLE);
                    new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Yahh")
                            .setContentText("Anda menjawab dengan salah")
                            .setConfirmText("Oke")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    counter++;
                                    setSoal();
                                    resetKolom();
                                    sDialog.dismissWithAnimation();
                                }
                            }).show();
                }

            } else if (counter >=29 ) {
                clJawaban1.setBackgroundColor(Color.parseColor("#47BB94"));
                tvJawaban1.setText(hijaiyahAdapter.getItem(position));
                btnReset.setVisibility(View.INVISIBLE);
                new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Terimakasih")
                        .setContentText("Kalian telah menjawab " + (counter+1) + " soal dan " + (nilai+1) + " soal benar")
                        .setConfirmText("Oke")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                finish();
                            }
                        }).show();
            }

        }

    }

    void resetKolom() {
        jawaban.clear();
        clJawaban1.setBackgroundColor(Color.parseColor("#ffffff"));
        tvJawaban1.setText("");
        clJawaban2.setBackgroundColor(Color.parseColor("#ffffff"));
        tvJawaban2.setText("");
        clJawaban3.setBackgroundColor(Color.parseColor("#ffffff"));
        tvJawaban3.setText("");
    }
}