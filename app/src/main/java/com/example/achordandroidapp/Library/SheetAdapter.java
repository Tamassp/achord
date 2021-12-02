package com.example.achordandroidapp.Library;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.achordandroidapp.Editor.BarAdapter;
import com.example.achordandroidapp.R;
import com.example.achordandroidapp.Sheet;

import java.util.List;

public class SheetAdapter extends RecyclerView.Adapter<SheetAdapter.ViewHolder> {

    List<Sheet> sheetList;

    public SheetAdapter(List<Sheet> sheetList){
        this.sheetList = sheetList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.sheet_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(sheetList.get(position).getTitle());
        holder.author.setText(sheetList.get(position).getAuthor());
        holder.key.setText(sheetList.get(position).getKey());
        holder.signature.setText(sheetList.get(position).getTimeSignature());
        //holder.tempo.setText(sheetList.get(position).getTempo());
    }

    @Override
    public int getItemCount() {
        return sheetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView author;
        TextView key;
        TextView signature;
        TextView tempo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameOfSheetElement);
            author = itemView.findViewById(R.id.authorOfSheetElement);
            key = itemView.findViewById(R.id.keyOfSheetElement);
            signature = itemView.findViewById(R.id.signatureOfSheetElement);
            tempo = itemView.findViewById(R.id.tempoOfSheetElement);
        }
    }
}
