package com.sankar.appdevlab.ui.Upload.CropDisplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sankar.appdevlab.R;

import java.util.ArrayList;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.ViewHolders> {
    private Context context;
    private ArrayList<String> arrayList;
    public CustomAdapter(Context context, ArrayList<String> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;

    }
    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_crop_name, parent, false);
        ViewHolders viewHolder = new ViewHolders(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolders holder, int position) {
        holder.name.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder
    {
        private TextView name;
        public ViewHolders(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
