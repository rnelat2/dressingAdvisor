package edu.illinois.cs.cs125.dressingadvisor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdviserFragment extends Fragment {
    int TopsIDs[] = {
            R.drawable.t1,
            R.drawable.t2,
            R.drawable.t3,
            R.drawable.t4,
            R.drawable.t5,
    };

    int BottomsIDs[] = {
            R.drawable.b1,
            R.drawable.b2,
            R.drawable.b3,
            R.drawable.b4,
            R.drawable.b5,
    };

    int ShoesIDs[] = {
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
    };
    static final Random random = new Random();

    public AdviserFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_adviser, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Adviser");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.adviser_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    int nextRandom(int max) {
        return Math.abs(random.nextInt(max));
    }

    public void updateTemperatureAndWeather(String temperature, String weather) {

        TextView tv = getView().findViewById(R.id.textView15);
        tv.setText("Temperature = " + temperature + "  :    " + weather + "\nFollowing are preferred clothes");

        ImageView t1 = getView().findViewById(R.id.imageViewT1);
        ImageView t2 = getView().findViewById(R.id.imageViewT2);
        ImageView t3 = getView().findViewById(R.id.imageViewT3);

        t1.setImageResource(TopsIDs[nextRandom(TopsIDs.length)]);
        t2.setImageResource(TopsIDs[nextRandom(TopsIDs.length)]);
        t3.setImageResource(TopsIDs[nextRandom(TopsIDs.length)]);

        ImageView b1 = getView().findViewById(R.id.imageViewB1);
        ImageView b2 = getView().findViewById(R.id.imageViewB2);
        ImageView b3 = getView().findViewById(R.id.imageViewB3);

        b1.setImageResource(BottomsIDs[nextRandom(BottomsIDs.length)]);
        b2.setImageResource(BottomsIDs[nextRandom(BottomsIDs.length)]);
        b3.setImageResource(BottomsIDs[nextRandom(BottomsIDs.length)]);


        ImageView s1 = getView().findViewById(R.id.imageViewS1);
        ImageView s2 = getView().findViewById(R.id.imageViewS2);
        ImageView s3 = getView().findViewById(R.id.imageViewS3);

        s1.setImageResource(ShoesIDs[nextRandom(ShoesIDs.length)]);
        s2.setImageResource(ShoesIDs[nextRandom(ShoesIDs.length)]);
        s3.setImageResource(ShoesIDs[nextRandom(ShoesIDs.length)]);



    }
}
