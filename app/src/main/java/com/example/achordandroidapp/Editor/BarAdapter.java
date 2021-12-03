package com.example.achordandroidapp.Editor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.achordandroidapp.R;

import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.ViewHolder> {

    List<Bar> bars;
    OnListItemClickListener onListItemClickListener;
    public BarAdapter(List<Bar> bars, OnListItemClickListener listener){
        this.bars = bars;
        onListItemClickListener = listener;
    }


    @NonNull
    @Override
    public BarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.bar_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BarAdapter.ViewHolder holder, int position) {
        holder.chord1.setText(bars.get(position).getChord1());
    }

    @Override
    public int getItemCount() {
        return bars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView chord1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    onListItemClickListener.onClick(getAdapterPosition());
                }
            });
            chord1 = itemView.findViewById(R.id.chord1);
        }
    }
    //Testing onclick
    public interface OnListItemClickListener{
        void onClick(int position);
    }
}
