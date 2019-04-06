package com.example.extralesson.api;

import com.example.extralesson.models.Lesson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LessonsApi {

    @GET("lessons/")
    Call<List<Lesson>> getLessons();

}
