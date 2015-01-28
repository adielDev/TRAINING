package fragments.basefragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.training.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FRagThree extends android.support.v4.app.Fragment {

    View fragView;
    public FRagThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragView = inflater.inflate(R.layout.fragment_frag_three, container,false);
        return  fragView;
    }


}
