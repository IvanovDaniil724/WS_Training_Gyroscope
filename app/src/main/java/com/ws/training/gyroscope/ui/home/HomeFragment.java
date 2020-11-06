package com.ws.training.gyroscope.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ws.training.gyroscope.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public static Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        context = this.getContext();

        RecyclerView HomeRecyclerView = root.findViewById(R.id.HomeRecyclerView);
        HomeRecyclerView.setAdapter(new HomeRecyclerViewAdapter(root));
        HomeRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));


        return root;
    }
}

class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeViewHolder>
{
    View root;
    public HomeRecyclerViewAdapter(View root)
    {
        this.root = root;
    }

    @NonNull
    @Override
    public HomeRecyclerViewAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(HomeFragment.context);
        View view = inflater.inflate(R.layout.fragment_item_home, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_fragmentWithCircles);
            }
        });

        return new HomeRecyclerViewAdapter.HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyclerViewAdapter.HomeViewHolder holder, int position) {
        Log.e("item", String.valueOf(position));

        holder.ItemName.setText("Category " + String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder
    {
        final TextView ItemName;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName = itemView.findViewById(R.id.ItemName_TextView);
        }
    }
}