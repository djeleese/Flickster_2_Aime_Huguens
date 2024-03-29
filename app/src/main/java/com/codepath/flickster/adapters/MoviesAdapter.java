package com.codepath.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



import com.bumptech.glide.Glide;
import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

 public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
     Context context;
     List<Movie> movies;

     public MoviesAdapter(Context context, List<Movie> movie) {
         this.context = context;
         this.movies = movie;
     }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         Log.d("smile","oncreateViewHolder");
         View view=LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
         return new ViewHolder(view);

     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
         //Log.d("smile","onBindViewHolder:", + i);
         Movie movie= movies.get(i);
// Bind the  movies data into the view holder

         viewHolder.bind(movie);
     }

     @Override
     public int getItemCount() {
         return movies.size();
     }

     class ViewHolder extends RecyclerView.ViewHolder{
         TextView tvTitle;
         TextView tvOverview;
         ImageView ivPoster;
         public ViewHolder(@NonNull View itemView) {
             super( itemView );
             tvTitle=itemView.findViewById(R.id.tvTitle);
             tvOverview=itemView.findViewById(R.id.tvOverview);
             ivPoster=itemView.findViewById(R.id.ivPoster);
         }

         public void bind(Movie movie) {
             tvTitle.setText(movie.getTitle());
             tvOverview.setText(movie.getOverview());
             Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
         }
     }




}
