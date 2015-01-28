package fragments.basefragment;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class LIstFrag extends ListFragment {

    CoordinatorFrag coordinatorFrag;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
           coordinatorFrag = (CoordinatorFrag)activity;
    }

    public LIstFrag() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String [] shvatim = new String []{"reuven","shimon","levi","yehuda"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1,shvatim);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        int pos = position;

        coordinatorFrag.itemListClicked(pos);
    }
}
