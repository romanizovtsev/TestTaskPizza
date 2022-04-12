package com.example.testtask.ui.home;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.testtask.R;
import com.example.testtask.databinding.FragmentMenuBinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements LifecycleOwner {


    private HomeViewModel homeViewModel;
    private FragmentMenuBinding binding;
    Context context;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Integer> positionsCategories;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        positionsCategories = new ArrayList<>();
        if (savedInstanceState != null)
            positionsCategories = savedInstanceState.getIntegerArrayList("array");

        binding = FragmentMenuBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = requireActivity();
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(requireActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
        homeViewModel.getUserMutableLiveData().observe(getViewLifecycleOwner(), ListUpdateObserver);

        RadioGroup radioGroup = root.findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(positionsCategories.get(0)!=null) {
                switch (checkedId) {
                    case R.id.radio0:
                        //recyclerView.smoothScrollToPosition(positionsCategories.get(0));
                        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(positionsCategories.get(0), 8);
                        break;
                    case R.id.radio1:

                        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(positionsCategories.get(1), 8);
                        //recyclerView.smoothScrollToPosition(positionsCategories.get(1));

                        // give a delay of one second
                        break;
                    case R.id.radio2:
                        // recyclerView.smoothScrollToPosition(positionsCategories.get(2));
                        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(positionsCategories.get(2), 8);
                        break;
                    case R.id.radio3:
                        //recyclerView.smoothScrollToPosition(positionsCategories.get(3));
                        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(positionsCategories.get(3), 8);
                        break;
                    case R.id.radio4:
                        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(positionsCategories.get(4), 8);
                        break;

                    default:
                        break;
                }
            }
        });

        return root;
    }

    Observer<List<Post>> ListUpdateObserver = new Observer<List<Post>>() {
        @Override
        public void onChanged(List<Post> postList) {
            countPositions(postList);
            recyclerViewAdapter.updatePostList(postList);
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void countPositions(List<Post> postList) {
        positionsCategories.add(0);
        int t = 0;
        for (int i = 0; i < postList.size(); i++) {
            if (postList.get(i).getCategory() > t) {
                positionsCategories.add(i);
                t++;
            }

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("array", positionsCategories);
    }

}