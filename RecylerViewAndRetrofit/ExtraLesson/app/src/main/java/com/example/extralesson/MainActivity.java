package com.example.extralesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.extralesson.adapters.LessonsRecyclerViewAdapter;
import com.example.extralesson.models.Lesson;
import com.example.extralesson.network.NetworkService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lessonsRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lessonsRecyclerView = findViewById(R.id.lessons_recycler_view);

        NetworkService
                .getInstance()
                .getLessonsApi()
                .getLessons()
                .enqueue(new Callback<List<Lesson>>() {

                    @Override
                    public void onResponse(Call<List<Lesson>> call, Response<List<Lesson>> response) {
                        if (response.isSuccessful()) {
                            List<Lesson> lessons = response.body();
                            lessonsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            lessonsRecyclerView.setAdapter(new LessonsRecyclerViewAdapter(MainActivity.this, lessons));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Lesson>> call, Throwable t) {
                        t.printStackTrace();
                    }

                });
    }
}
