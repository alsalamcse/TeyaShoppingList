package mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.hsarme.teya.teyashoppinglist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentListFragment extends Fragment {
    private TextView tvtotal;
    private TextView totalvalue;
    private TextView tvcount;
    private TextView tvcountvalue;
    private ImageButton imbsave;
    private ListView lstvcurrent;


    public CurrentListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_list2, container, false);
        tvtotal= (TextView) view.findViewById(R.id.tvtotal);
        totalvalue=(TextView) view.findViewById(R.id.totalvalue);
        tvcount= (TextView)view.findViewById(R.id.tvcount);
        tvcountvalue=(TextView) view.findViewById(R.id.tvcountvalue);
        imbsave=(ImageButton) view.findViewById(R.id.imbsave);
        lstvcurrent=(ListView) view.findViewById(R.id.lstvcurrent);
        String [] ar={"noor","rimaa","teya","shada"};


        return view;

    }


}
