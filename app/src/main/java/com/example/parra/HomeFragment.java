package com.example.parra;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.parra.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

        private  CardView car_card, motor_card, taxi_card, tri_card;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        car_card = view.findViewById(R.id.car_card);
        motor_card = view.findViewById(R.id.motor_card);
        taxi_card = view.findViewById(R.id.taxi_card);
        tri_card = view.findViewById(R.id.tri_card);

        car_card.setOnClickListener(this);
        motor_card.setOnClickListener(this);
        taxi_card.setOnClickListener(this);
        tri_card.setOnClickListener(this);
    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        car_card = (CardView) findViewById(R.id.car_card);
//        motor_card = motor_card.findViewById(R.id.motor_card);
//        taxi_card = taxi_card.findViewById(R.id.taxi_card);
//        tri_card = tri_card.findViewById(R.id.tri_card);
//
//        car_card.setOnClickListener(this);
//        motor_card.setOnClickListener(this);
//        taxi_card.setOnClickListener(this);
//        tri_card.setOnClickListener(this);
//    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.car_card : i = new Intent(getActivity(), Car.class);
                startActivity(i);
            break;
            case R.id.motor_card : i = new Intent(getActivity(), Motorcycle.class);
                startActivity(i);
                break;
            case R.id.taxi_card : i = new Intent(getActivity(), Taxi.class);
                startActivity(i);
                break;
            case R.id.tri_card : i = new Intent(getActivity(), Tricycle.class);
                startActivity(i);
                break;
        }

    }
}
