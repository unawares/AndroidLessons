package com.example.extralesson.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.extralesson.R;
import com.example.extralesson.models.Lesson;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class LessonsRecyclerViewAdapter extends RecyclerView.Adapter<LessonsRecyclerViewAdapter.LessonViewHolder> {

    private Context context;
    private List<Lesson> lessons;

    public LessonsRecyclerViewAdapter(Context context, List<Lesson> lessons) {
        this.context = context;
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item, parent, false);
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder lessonViewHolder, int position) {
        Lesson lesson = lessons.get(position);
        lessonViewHolder.bind(lesson);
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class LessonViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private TextView price;
        private TextView date;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
        }

        public void bind(Lesson lesson) {
            DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy HH:mm");
            title.setText(lesson.getTitle());
            description.setText(lesson.getDescription());
            price.setText(lesson.getPrice().toString());
            date.setText(dateFormat.format(lesson.getDate()));
        }

    }

}
