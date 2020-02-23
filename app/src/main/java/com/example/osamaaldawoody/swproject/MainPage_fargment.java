package com.example.osamaaldawoody.swproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainPage_fargment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View postview = inflater.inflate(R.layout.fragment_main_page_fargment,container,false);

        ListView postView =(ListView) postview.findViewById(R.id.posts_list);

        ArrayList<User> posts_list = new ArrayList<User>();
        posts_list.add(new User("osama ashraf","11:01 am","لا إله الا الله"));
        posts_list.add(new User("osama khalel","11:30 am","سبحان الله والحمد لله ولا اله الا الله والله اكبر "));
        posts_list.add(new User("osama ashraf","11:02 am","صلى على محمد"));
        posts_list.add(new User("elsaid ellithi","11:49 am","يا حى يا قيوم برحمتك استغيث اصلح لى شأنى كله ولا تكلنى الى نفسى طرفة عين "));
        posts_list.add(new User("eslam elhawy","11:40 am","ربنا افتح بيننا وبين قومنا بالحق وانت خير الفاتحين "));
        posts_list.add(new User("osama mohamed","11:33 am","ربنا عليك توكلنا واليك أنبنا واليك المصير"));
        posts_list.add(new User("elsaid ellithi","11:52 am","لا اله الا انت سبحانك انى كنت من الظالمين"));
        posts_list.add(new User("osama ashraf","11:01 am","لا إله الا الله"));
        posts_list.add(new User("osama khalel","11:30 am","سبحان الله والحمد لله ولا اله الا الله والله اكبر "));
        posts_list.add(new User("osama ashraf","11:02 am","صلى على محمد"));
        posts_list.add(new User("elsaid ellithi","11:49 am","يا حى يا قيوم برحمتك استغيث اصلح لى شأنى كله ولا تكلنى الى نفسى طرفة عين "));
        posts_list.add(new User("eslam elhawy","11:40 am","ربنا افتح بيننا وبين قومنا بالحق وانت خير الفاتحين "));
        posts_list.add(new User("osama mohamed","11:33 am","ربنا عليك توكلنا واليك أنبنا واليك المصير"));
        posts_list.add(new User("elsaid ellithi","11:52 am","لا اله الا انت سبحانك انى كنت من الظالمين"));

        post_itemAdapter adapter = new post_itemAdapter(getActivity(),posts_list);
        postView.setAdapter(adapter);
        return postview;
    }

}
