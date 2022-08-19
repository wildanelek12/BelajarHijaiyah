package id.codes.belajarhijaiyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GambarHijaiyah extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {
    private static final String TAG = GambarHijaiyah.class.getSimpleName();
    private TextView textView;
    private Button button;
    private ImageView imageView;
    private static final String IMAGE_VIEW_TAG = "LAUNCHER LOGO";
    private static final String TEXT_VIEW_TAG = "DRAG TEXT";
    private static final String BUTTON_VIEW_TAG = "DRAG BUTTON";

    private String soal[] = {"فتي", "كذب", "كدر", "حكم", "خطي", "معك", "اكل", "ولد", "فصل", "ضرب"};
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
                    "ث", "م", "س", "ب", "ه", "ع", "ي" , "ش","ض", "ك"//maaka
            },
            {
                    "و", "ل", "ظ", "ب", "ا", "ك", "م", "ط", "ج", "ش" //akala
            },

            {
                    "ث","ص","س","ش","ن","ي","ظ","ط","د","ل","و" //walada
            },

            {
                     "ل", "ص", "ز", "و", "ب", "ظ", "م", "ذ", "س", "ف" //fasola
            },
            {
            "ي", "غ", "ز", "ر", "ح", "ب", "ص", "ن", "ف"," ض" //dhoroba
            },

        };
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar_hijaiyah);
        findViews();
        implementEvents();
        }
private void findViews(){
        textView=(TextView)findViewById(R.id.label);
        textView.setTag(TEXT_VIEW_TAG);
        imageView=(ImageView)findViewById(R.id.image_view);
        imageView.setTag(IMAGE_VIEW_TAG);
        button=(Button)findViewById(R.id.button);
        button.setTag(BUTTON_VIEW_TAG);
        }
private void implementEvents(){
        //add or remove any view that you don't want to be dragged
        textView.setOnLongClickListener(this);
        imageView.setOnLongClickListener(this);
        button.setOnLongClickListener(this);

        //add or remove any layout view that you don't want to accept dragged view
        findViewById(R.id.top_layout).setOnDragListener((View.OnDragListener)this);
        findViewById(R.id.left_layout).setOnDragListener(this);
        findViewById(R.id.right_layout).setOnDragListener(this);
        }
public boolean onLongClick(View view){
        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item=new ClipData.Item((CharSequence)view.getTag());

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        String[]mimeTypes={ClipDescription.MIMETYPE_TEXT_PLAIN};

        ClipData data=new ClipData(view.getTag().toString(),mimeTypes,item);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(view);

        // Starts the drag
        view.startDrag(data//data to be dragged
        ,shadowBuilder //drag shadow
        ,view//local data about the drag and drop operation
        ,0//no needed flags
        );

        //Set view visibility to INVISIBLE as we are going to drag the view
        view.setVisibility(View.INVISIBLE);
        return true;
        }

// This is the method that the system calls when it dispatches a drag event to the
// listener.
@Override
public boolean onDrag(View view,DragEvent event){
        // Defines a variable to store the action type for the incoming event
        int action=event.getAction();
        // Handles each of the expected events
        switch(action){
        case DragEvent.ACTION_DRAG_STARTED:
        // Determines if this View can accept the dragged data
        if(event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
        return true;
        }

        return false;

        case DragEvent.ACTION_DRAG_ENTERED:
        view.invalidate();
        return true;
        case DragEvent.ACTION_DRAG_LOCATION:
        // Ignore the event
        return true;
        case DragEvent.ACTION_DRAG_EXITED:
        view.invalidate();
        return true;
        case DragEvent.ACTION_DROP:
        // Gets the item containing the dragged data
        ClipData.Item item=event.getClipData().getItemAt(0);

        // Gets the text data from the item.
        String dragData=item.getText().toString();

        // Displays a message containing the dragged data.
        Toast.makeText(this,"Dragged data is "+dragData,Toast.LENGTH_SHORT).show();

        // Turns off any color tints

        // Invalidates the view to force a redraw
        view.invalidate();

        View v=(View)event.getLocalState();
        ViewGroup owner=(ViewGroup)v.getParent();
        owner.removeView(v);//remove the dragged view
        LinearLayout container=(LinearLayout)view;//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
        container.addView(v);//Add the dragged view
        v.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE

        // Returns true. DragEvent.getResult() will return true.
        return true;
        case DragEvent.ACTION_DRAG_ENDED:
        // Turns off any color tinting

        // Invalidates the view to force a redraw
        view.invalidate();

        // Does a getResult(), and displays what happened.
        if(event.getResult())
        Toast.makeText(this,"The drop was handled.",Toast.LENGTH_SHORT).show();

        else
        Toast.makeText(this,"The drop didn't work.",Toast.LENGTH_SHORT).show();


        // returns true; the value is ignored.
        return true;

// An unknown action type was received.
default:
        Log.e("DragDrop Example","Unknown action type received by OnDragListener.");
        break;
        }
        return false;
        }


@Override
public void onPointerCaptureChanged(boolean hasCapture){
        super.onPointerCaptureChanged(hasCapture);
        }
        }