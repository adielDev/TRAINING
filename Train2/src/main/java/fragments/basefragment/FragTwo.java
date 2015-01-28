package fragments.basefragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.training.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragTwo extends android.support.v4.app.Fragment {

    View fragView;
    public FragTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.fragment_frag_two, container,false);
        return  fragView;
    }


}
