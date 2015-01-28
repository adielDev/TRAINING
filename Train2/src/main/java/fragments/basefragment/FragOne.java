package fragments.basefragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.training.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragOne extends android.support.v4.app.Fragment {

    View fragView;
    TextView textView;

    public FragOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragView = inflater.inflate(R.layout.fragment_frag_one, container,false);
        textView = (TextView) fragView.findViewById(R.id.tvOne);
        return  fragView;
    }

    public void displayIndex (int index ){

        String s = String.valueOf(index);
        textView.setText(s);

    }


}
