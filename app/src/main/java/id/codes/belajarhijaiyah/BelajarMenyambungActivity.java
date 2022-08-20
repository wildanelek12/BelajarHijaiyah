package id.codes.belajarhijaiyah;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Collections;

public class BelajarMenyambungActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {


    private String soal[] = {"فتي", "كذب", "كدر", "حكم", "خطي", "معك", "اكل", "ولد", "فصل", "ضرب"};
    String randomize_hijaiyah [] = {"ع","غ","و","ا"};

    ArrayList<String> mylist = new ArrayList<String>();
    String jawaban[][] = {
            {
                    "ب", "ص", "ف", "و", "ش", "ت", "ع", "ب", "ج", "ي"//fataya
            },
            {
                    "ب", "ف", "م", "ء", "ي", "ذ", "ص", "ض", "ج", "ك" // kadzaba
            },
            {
                    "ك", "ي", "ض", "ص", "س", "ح", "ج", "ر", "ب", "د",  //kadaro
            },
            {
                    "س", "د", "ذ", "ث", "ب", "ظ", "ت", "م", "ك", "ح" //hakama
            },
            {
                    "ا", "ت", "ط", "و", "ز", "ي", "ه", "ف", "خ", "ن" //fatoya
            },

            {
                    "ث", "م", "س", "ب", "ه", "ع", "ي", "ش", "ض", "ك"//maaka
            },
            {
                    "و", "ل", "ظ", "ب", "ا", "ك", "م", "ط", "ج", "ش" //akala
            },

            {
                    "ث", "ص", "س", "ش", "ن", "ي", "ظ", "ط", "د", "ل", "و" //walada
            },

            {
                    "ل", "ص", "ز", "و", "ب", "ظ", "م", "ذ", "س", "ف" //fasola
            },
            {
                    "ي", "غ", "ز", "ر", "ح", "ب", "ص", "ن", "ف", " ض" //dhoroba
            },

    };
    private CardView card8;
    private TextView tv8;
    private CardView card9;
    private TextView tv9;
    private CardView card10;
    private TextView tv10;
    private TextView tvSoal;
    private ConstraintLayout clJawaban1;
    private ConstraintLayout clJawaban3;
    private ConstraintLayout clJawaban2;
    private CardView card1;
    private TextView tv1;
    private CardView card2;
    private TextView tv2;
    private CardView card3;
    private TextView tv3;
    private CardView card4;
    private TextView tv4;
    private CardView card5;
    private TextView tv5;
    private CardView card6;
    private TextView tv6;
    private CardView card7;
    private TextView tv7;
    ArrayList<View> views ;
    int index = 0;
    private ImageView icHome;
    ArrayList<String> hijaiyah ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belajar_menyambung);
        initView();
        hijaiyah = new ArrayList<String>();
        views = new ArrayList<View>() ;
//        setAwalJawaban();
//        setSoal();
        icHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                setSoal();
                setAwalJawaban();
            }
        });
        implementEvents();

        mylist.add("ع");
        mylist.add("غ");
        mylist.add("و");
        mylist.add("ا");

        Collections.shuffle(mylist);
        String hijaiyah_new = "";
        for (int i = 1; i < mylist.size() ; i++) {
            hijaiyah_new += mylist.get(i);
        }
        tvSoal.setText(hijaiyah_new);
        Toast.makeText(this, hijaiyah_new, Toast.LENGTH_SHORT).show();

    }

    public void implementEvents() {
        card1.setOnLongClickListener(this);
        card2.setOnLongClickListener(this);
        card3.setOnLongClickListener(this);
        card4.setOnLongClickListener(this);
        card5.setOnLongClickListener(this);
        card6.setOnLongClickListener(this);
        card7.setOnLongClickListener(this);
        card8.setOnLongClickListener(this);
        card9.setOnLongClickListener(this);
        card10.setOnLongClickListener(this);


        clJawaban1.setOnDragListener(this);
        clJawaban2.setOnDragListener(this);
        clJawaban3.setOnDragListener(this);
    }


    public void setSoal() {
        tvSoal.setText(soal[index]);
    }

    void setAwalJawaban(){

        setJawaban(tv1,0,card1);
        setJawaban(tv2,1,card2);
        setJawaban(tv3,2,card3);
        setJawaban(tv4,3,card4);
        setJawaban(tv5,4,card5);
        setJawaban(tv6,5,card6);
        setJawaban(tv7,6,card7);
        setJawaban(tv8,7,card8);
        setJawaban(tv9,8,card9);
        setJawaban(tv10,9,card10);
    }

    public void setJawaban(TextView textView,int indexText,CardView cardView) {

        textView.setText(jawaban[index][indexText]);
        textView.setTag(jawaban[index][indexText]);
        cardView.setTag(jawaban[index][indexText]);
    }



    private void initView() {
        card8 = (CardView) findViewById(R.id.card_8);
        tv8 = (TextView) findViewById(R.id.tv_8);
        card9 = (CardView) findViewById(R.id.card_9);
        tv9 = (TextView) findViewById(R.id.tv_9);
        card10 = (CardView) findViewById(R.id.card_10);
        tv10 = (TextView) findViewById(R.id.tv_10);
        tvSoal = (TextView) findViewById(R.id.tv_soal);
        clJawaban1 = (ConstraintLayout) findViewById(R.id.cl_jawaban_1);
        clJawaban3 = (ConstraintLayout) findViewById(R.id.cl_jawaban_3);
        clJawaban2 = (ConstraintLayout) findViewById(R.id.cl_jawaban_2);
        card1 = (CardView) findViewById(R.id.card_1);
        tv1 = (TextView) findViewById(R.id.tv_1);
        card2 = (CardView) findViewById(R.id.card_2);
        tv2 = (TextView) findViewById(R.id.tv_2);
        card3 = (CardView) findViewById(R.id.card_3);
        tv3 = (TextView) findViewById(R.id.tv_3);
        card4 = (CardView) findViewById(R.id.card_4);
        tv4 = (TextView) findViewById(R.id.tv_4);
        card5 = (CardView) findViewById(R.id.card_5);
        tv5 = (TextView) findViewById(R.id.tv_5);
        card6 = (CardView) findViewById(R.id.card_6);
        tv6 = (TextView) findViewById(R.id.tv_6);
        card7 = (CardView) findViewById(R.id.card_7);
        tv7 = (TextView) findViewById(R.id.tv_7);
        icHome = (ImageView) findViewById(R.id.ic_home);
    }

    @Override
    public boolean onLongClick(View view) {
        ClipData.Item item=new ClipData.Item((CharSequence)view.getTag());
        String[]mimeTypes={ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data=new ClipData(view.getTag().toString(),mimeTypes,item);
        View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(view);
        view.startDrag(data//data to be dragged
                ,shadowBuilder //drag shadow
                ,view//local data about the drag and drop operation
                ,1//no needed flags
        );
        return true;
    }

    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int action=dragEvent.getAction();

        switch(action){
            case DragEvent.ACTION_DRAG_STARTED:
                if(dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
                    return true;
                }
                return false;
            case DragEvent.ACTION_DRAG_ENTERED:
                view.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the dragEvent
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                return true;
            case DragEvent.ACTION_DROP:


                    ConstraintLayout container = (ConstraintLayout) view;
                    if (container.getChildCount() >= 1) {
                        return true;
                    } else {

                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                        String dragData = item.getText().toString();
                        view.invalidate();

                        View v = (View) dragEvent.getLocalState();
                        ViewGroup owner = (ViewGroup) v.getParent();
                        owner.removeView(v);//remove the dragged view
                        //caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                        container.addView(v);//Add the dragged view
                        hijaiyah.add(dragData);
                        views.add(v);
                        v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                        if(hijaiyah.size()==3){

                            String hijaiyahjawaban = "";
                            for (int i = 0; i < hijaiyah.size() ; i++) {
                                hijaiyahjawaban+=hijaiyah.get(i);
                            }
                            Toast.makeText(this, hijaiyahjawaban, Toast.LENGTH_LONG).show();
                            index++;
                            clJawaban1.removeAllViewsInLayout();
                            clJawaban2.removeAllViewsInLayout();
                            clJawaban3.removeAllViewsInLayout();
                            setSoal();
                            setAwalJawaban();

                            hijaiyah.clear();
                            return true;
                        }

                        return true;


                }
            case DragEvent.ACTION_DRAG_ENDED:
                // Turns off any color tinting
                // Invalidates the view to force a redraw
                view.invalidate();
                return true;
            default:
                Log.e("DragDrop Example","Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }
}