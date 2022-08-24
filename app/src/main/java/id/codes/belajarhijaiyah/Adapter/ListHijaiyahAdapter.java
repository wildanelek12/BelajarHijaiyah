package id.codes.belajarhijaiyah.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import id.codes.belajarhijaiyah.R;

public class ListHijaiyahAdapter extends RecyclerView.Adapter<ListHijaiyahAdapter.ViewHolder> {
    Context context;
    String[][] data;
    int [] suara;


    public ListHijaiyahAdapter(Context context, String[][] data, int [] suara) {
        this.context = context;
        this.data = data;
        this.suara = suara;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_hijaiyah, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvHijaiyah.setText(data[position][0]);
        holder.tvIndo.setText(data[position][1]);
        holder.clListHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(context,suara[position] );
                mediaPlayer.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout clListHijaiyah;
        private TextView tvHijaiyah;
        private TextView tvIndo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clListHijaiyah = (ConstraintLayout) itemView.findViewById(R.id.cl_list_hijaiyah);
            tvHijaiyah = (TextView) itemView.findViewById(R.id.tv_hijaiyah);
            tvIndo = (TextView) itemView.findViewById(R.id.tv_indo);
        }
    }
}
