package com.example.student.week7homework2.activity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.student.week7homework2.R;
import com.example.student.week7homework2.adapters.UserAdapter;
import com.example.student.week7homework2.models.User;
import com.example.student.week7homework2.threads.DownloadUsersThread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*runGetUsersThread();
        startUserList();*/
    }

    private void startUserList() {
        /*final RecyclerView recyclerUsers = findViewById(R.id.recycler_users);
        recyclerUsers.setHasFixedSize(true);
        recyclerUsers.setLayoutManager(new LinearLayoutManager(this));
        recyclerUsers.setAdapter(new UserAdapter(this, list));*/
    }

    private void runGetUsersThread() {
        /*Callable<ArrayList<User>> callable = new DownloadUsersThread(this);
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        try {
            list = (ArrayList<User>) futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }

}
