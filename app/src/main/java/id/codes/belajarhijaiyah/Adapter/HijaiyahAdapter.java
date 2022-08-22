package id.codes.belajarhijaiyah.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import id.codes.belajarhijaiyah.BelajarMenyambungActivity;
import id.codes.belajarhijaiyah.R;

public class HijaiyahAdapter extends RecyclerView.Adapter<HijaiyahAdapter.ViewHolder> {

    Context context;
    String [] data;
    private ItemClickListener mClickListener;

    public HijaiyahAdapter(Context context,String[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hijaiyah, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvHijaiyah.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvHijaiyah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHijaiyah = (TextView) itemView.findViewById(R.id.tv_hijaiyah);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public String getItem(int id) {
        return data[id];
    }

    // allows clicks events to be caught
    public void setClickListener(BelajarMenyambungActivity itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
