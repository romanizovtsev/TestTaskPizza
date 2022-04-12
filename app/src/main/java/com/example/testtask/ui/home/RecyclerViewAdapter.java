package com.example.testtask.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testtask.R;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Post> postList;
    Context context;

    public RecyclerViewAdapter(Context contextArg) {
        this.context = contextArg;
        this.postList = new List<Post>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(@Nullable Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Post> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Post post) {
                return false;
            }

            @Override
            public boolean remove(@Nullable Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Post> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Post> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Post get(int i) {
                return null;
            }

            @Override
            public Post set(int i, Post post) {
                return null;
            }

            @Override
            public void add(int i, Post post) {

            }

            @Override
            public Post remove(int i) {
                return null;
            }

            @Override
            public int indexOf(@Nullable Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(@Nullable Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<Post> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Post> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Post> subList(int i, int i1) {
                return null;
            }
        };
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Post post = postList.get(position);
        RecyclerViewViewHolder viewHolder = (RecyclerViewViewHolder) holder;

        viewHolder.txtView_title.setText(post.getTitle());
        viewHolder.txtView_description.setText(post.getDescription());
        viewHolder.buttBuy.setText("от " + post.getCost() + " руб");
        Glide.with(context).load(post.getImage()).into(viewHolder.imgView);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void updatePostList(final List<Post> postList) {
        this.postList.clear();
        this.postList = postList;
        notifyDataSetChanged();
    }

    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtView_title;
        TextView txtView_description;
        Button buttBuy;


        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.image);
            txtView_title = itemView.findViewById(R.id.title);
            txtView_description = itemView.findViewById(R.id.description);
            buttBuy = itemView.findViewById(R.id.buy);


        }
    }
}