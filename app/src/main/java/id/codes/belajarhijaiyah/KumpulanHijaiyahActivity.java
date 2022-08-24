package id.codes.belajarhijaiyah;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import id.codes.belajarhijaiyah.Adapter.ListHijaiyahAdapter;

public class KumpulanHijaiyahActivity extends AppCompatActivity {

    private RecyclerView rvKumpulanHijaiyah;
    ListHijaiyahAdapter listHijaiyahAdapter;
    String hijaiyah[][] = {
            {
                    "ا",
                    "Alif"
            },
            {
                    "ب",
                    "Ba'"
            },
            {
                    "ت",
                    "ta'"
            },
            {
                    "ث",
                    "tsa"
            },
            {
                    "ج",
                    "jim"
            },
            {
                    "ح",
                    "ha'"
            },
            {
                    "خ",
                    "kho'"
            },
            {
                    "د",
                    "dal'"
            },
            {
                    "ذ",
                    "dzal'"
            },
            {
                    "ر",
                    "ro"
            },
            {
                    "ز",
                    "za"
            },
            {
                    "س",
                    "sin"
            },
            {
                    "ش",
                    "syin"
            },
            {
                    "ص",
                    "shod"
            },
            {
                    "ض",
                    "dhod"
            },
            {
                    "ط",
                    "tho'"
            },
            {
                    "ظ",
                    "zho"
            },
            {
                    "ع",
                    "ain"
            },
            {
                    "غ",
                    "ghoin"
            },
            {
                    "ف",
                    "fa"
            },
            {
                    "ق",
                    "qof"
            },
            {
                    "ك",
                    "kaf"
            },
            {
                    "ل ",
                    "lam"
            },
            {
                    "م",
                    "mim"
            },
            {
                    "ن",
                    "nun"
            },
            {
                    "هـ",
                    "ha"
            },
            {
                    "و",
                    "waw"
            },
            {
                    "ي",
                    "ya"
            },
            {
                    "ء",
                    "hamzah"
            },
            {
                    "لا",
                    "la"
            }
    };

    int[] suara = {R.raw.alif, R.raw.ba, R.raw.ta, R.raw.tsa, R.raw.jim, R.raw.kha, R.raw.kho, R.raw.dal, R.raw.dzal, R.raw.ro, R.raw.za, R.raw.sin, R.raw.syin, R.raw.shod, R.raw.dhod, R.raw.tho, R.raw.zho, R.raw.ain, R.raw.ghoin, R.raw.fa, R.raw.qof, R.raw.kaf, R.raw.lam, R.raw.mim, R.raw.nun, R.raw.ha, R.raw.waw, R.raw.ya, R.raw.hamzah, R.raw.lamalif};

    private ImageView btnLeft;
    private ImageView btnRight;
    GridLayoutManager gridLayoutManager;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kumpulan_hijaiyah);
        initView();
        gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, true);
        rvKumpulanHijaiyah.setLayoutManager(gridLayoutManager);
        listHijaiyahAdapter = new ListHijaiyahAdapter(this, hijaiyah, suara);
        rvKumpulanHijaiyah.setAdapter(listHijaiyahAdapter);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvKumpulanHijaiyah.getLayoutManager().scrollToPosition(gridLayoutManager.findLastVisibleItemPosition() + 1);
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvKumpulanHijaiyah.getLayoutManager().scrollToPosition(gridLayoutManager.findFirstVisibleItemPosition() - 1);
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
        rvKumpulanHijaiyah = (RecyclerView) findViewById(R.id.rv_kumpulan_hijaiyah);
        btnLeft = (ImageView) findViewById(R.id.btnLeft);
        btnRight = (ImageView) findViewById(R.id.btn_right);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
    }
}