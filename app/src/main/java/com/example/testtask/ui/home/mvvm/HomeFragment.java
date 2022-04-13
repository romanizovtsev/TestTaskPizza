package com.example.testtask.ui.home.mvvm;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtask.R;
import com.example.testtask.databinding.FragmentMenuBinding;
import com.example.testtask.ui.home.network.Post;
import com.example.testtask.ui.home.mvvm.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeFragment extends Fragment implements LifecycleOwner {


    private HomeViewModel homeViewModel;
    private FragmentMenuBinding binding;
    Context context;
    Button b0, b1, b2, b3, b4;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Integer> positionsCategories;
    final int button0 = R.id.radio0, button1 = R.id.radio1, button2 = R.id.radio2, button3 = R.id.radio3, button4 = R.id.radio4;

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
        b0 = root.findViewById(button0);
        b1 = root.findViewById(button1);
        b2 = root.findViewById(button2);
        b3 = root.findViewById(button3);
        b4 = root.findViewById(button4);

        RadioGroup radioGroup = root.findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            switch (checkedId) {
                case button0:
                    b0.setTextColor(getResources().getColor(R.color.pink2));
                    b1.setTextColor(getResources().getColor(R.color.grey_text));
                    b2.setTextColor(getResources().getColor(R.color.grey_text));
                    b3.setTextColor(getResources().getColor(R.color.grey_text));
                    b4.setTextColor(getResources().getColor(R.color.grey_text));
                    //recyclerView.smoothScrollToPosition(positionsCategories.get(0));
                    try {
                        ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).scrollToPositionWithOffset(positionsCategories.get(0), 8);
                    } catch (Exception e) {
                        Log.d("smth went", "wrong");
                    }

                    break;
                case button1:
                    b0.setTextColor(getResources().getColor(R.color.grey_text));
                    b1.setTextColor(getResources().getColor(R.color.pink2));
                    b2.setTextColor(getResources().getColor(R.color.grey_text));
                    b3.setTextColor(getResources().getColor(R.color.grey_text));
                    b4.setTextColor(getResources().getColor(R.color.grey_text));

                    //recyclerView.smoothScrollToPosition(positionsCategories.get(1));
                    try {
                        ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).scrollToPositionWithOffset(positionsCategories.get(1), 8);
                    } catch (Exception e) {
                        Log.d("smth went", "wrong");
                    }
                    break;
                case button2:
                    b0.setTextColor(getResources().getColor(R.color.grey_text));
                    b1.setTextColor(getResources().getColor(R.color.grey_text));
                    b2.setTextColor(getResources().getColor(R.color.pink2));
                    b3.setTextColor(getResources().getColor(R.color.grey_text));
                    b4.setTextColor(getResources().getColor(R.color.grey_text));
                    // recyclerView.smoothScrollToPosition(positionsCategories.get(2));
                    try {
                        ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).scrollToPositionWithOffset(positionsCategories.get(2), 8);
                    } catch (Exception e) {
                        Log.d("smth went", "wrong");
                    }
                    break;
                case button3:
                    b0.setTextColor(getResources().getColor(R.color.grey_text));
                    b1.setTextColor(getResources().getColor(R.color.grey_text));
                    b2.setTextColor(getResources().getColor(R.color.grey_text));
                    b3.setTextColor(getResources().getColor(R.color.pink2));
                    b4.setTextColor(getResources().getColor(R.color.grey_text));
                    //recyclerView.smoothScrollToPosition(positionsCategories.get(3));
                    try {
                        ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).scrollToPositionWithOffset(positionsCategories.get(3), 8);
                    } catch (Exception e) {
                        Log.d("smth went", "wrong");
                    }
                    break;
                case button4:
                    b0.setTextColor(getResources().getColor(R.color.grey_text));
                    b1.setTextColor(getResources().getColor(R.color.grey_text));
                    b2.setTextColor(getResources().getColor(R.color.grey_text));
                    b3.setTextColor(getResources().getColor(R.color.grey_text));
                    b4.setTextColor(getResources().getColor(R.color.pink2));
                    //recyclerView.smoothScrollToPosition(positionsCategories.get(4));
                    try {
                        ((LinearLayoutManager) Objects.requireNonNull(recyclerView.getLayoutManager())).scrollToPositionWithOffset(positionsCategories.get(4), 8);
                    } catch (Exception e) {
                        Log.d("smth went", "wrong");
                    }
                    break;

                default:
                    break;

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
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("array", positionsCategories);
    }

}