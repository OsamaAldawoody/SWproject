package com.example.osamaaldawoody.swproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class post_itemAdapter extends ArrayAdapter<User> {
    public post_itemAdapter(Context context, ArrayList<User> list) {
        super(context,0,list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listPostView = convertView;
        if(listPostView == null) {
            listPostView = LayoutInflater.from(getContext()).inflate(
                    R.layout.posts_list_item, parent, false);
        }
        User currentPostView = getItem(position);
        TextView nameText = (TextView) listPostView.findViewById(R.id.name_post);
        nameText.setText(currentPostView.getName());
        TextView timeText = (TextView) listPostView.findViewById(R.id.time_post);
        timeText.setText(currentPostView.getTime());
        TextView postText = (TextView) listPostView.findViewById(R.id.content_post);
        postText.setText(currentPostView.getPost());
        return listPostView;
    }
}
