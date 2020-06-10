package com.hananelsaid.hp.madarsofttask.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hananelsaid.hp.madarsofttask.R;
import com.hananelsaid.hp.madarsofttask.model.UserData;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.HolderClass> {
    private Context context;
    private List<UserData> usersList;


    @NonNull
    @Override
    public HolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.userrow, parent, false);
        HolderClass holderClass = new HolderClass(view);
        return holderClass;

    }

    @Override
    public void onBindViewHolder(@NonNull HolderClass holder, int position) {
        UserData user = usersList.get(position);
        holder.tvName.setText(user.getName());
        holder.tvAge.setText(user.getAge());
        holder.tvJobTitle.setText(user.getJobTitle());
        holder.tvGender.setText(user.getGender());
        Log.i("TAG1", "onBindViewHolder: "+user.getAge());

    }

    @Override
    public int getItemCount() {
        return usersList != null ? usersList.size() : 0;
    }

    public void setData(List<UserData> usersList) {
        this.usersList = usersList;
        notifyDataSetChanged();

    }

    class HolderClass extends RecyclerView.ViewHolder {
        TextView tvName, tvAge, tvGender,tvJobTitle;


        public HolderClass(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvGender = itemView.findViewById(R.id.tvGender);
            tvJobTitle=itemView.findViewById(R.id.tvJobTitle);
        }
    }

}
