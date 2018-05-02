package edu.illinois.cs.cs125.dressingadvisor;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdviserFragment extends Fragment {


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

    public void updateTemperatureAndWeather(String temperature, String weather) {

        TextView tv = getView().findViewById(R.id.textView15);
        tv.setText("Temperature = " + temperature + "  :    " + weather + "\nFollowing are preferred clothes");
    }
}
