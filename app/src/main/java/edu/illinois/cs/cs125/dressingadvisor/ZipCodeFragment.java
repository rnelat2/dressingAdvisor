package edu.illinois.cs.cs125.dressingadvisor;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZipCodeFragment extends Fragment {
    private static String zipcode = "61801";

    public ZipCodeFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    public static String getZipCode() {
        return zipcode;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View rootView =  inflater.inflate(R.layout.fragment_zip_code, container, false);
        Button b = (Button) rootView.findViewById(R.id.button3);
        b.setOnClickListener(mButtonClickListener);
        return rootView;
    }

    private View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            EditText et = getView().findViewById(R.id.editText4);

            ZipCodeFragment.zipcode = et.getText().toString();
            Log.e("ZipCode", zipcode);

            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Zip Code");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.zipcode_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
