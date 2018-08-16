package com.example.student.week7homework2.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.week7homework2.R;
import com.example.student.week7homework2.models.User;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    private final Context context;
    private final List<User> list;

    public UserAdapter(final Context context, final List<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_user, parent,false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, final int position) {
        final String imageUrl = list.get(position).getUrl();
        Picasso.get().load(imageUrl).into(holder.userImage);
        holder.textTitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class UserViewHolder extends RecyclerView.ViewHolder {
        private CircularImageView userImage;
        private TextView textTitle;
        UserViewHolder(View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.title_user);
            userImage = itemView.findViewById(R.id.image_user);
        }
    }
}
