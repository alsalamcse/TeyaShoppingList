package mainlistfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hsarme.teya.teyashoppinglist.R;
import com.hsarme.teya.teyashoppinglist.data.product;
import com.hsarme.teya.teyashoppinglist.data.ProductAdapter;

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

    private ProductAdapter productAdapter;





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

        productAdapter=new ProductAdapter(getContext(),R.layout.productitem);
        lstvcurrent.setAdapter(productAdapter);
//
        readAndListen();



        return view;

    }

    //read and listen data from firebase
    private void readAndListen()
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();// to get user email.. user info
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        DatabaseReference reference;// 3nwan entrnet
        //todo לקבלת קישט=ור למסך הניתונים שלנו
        //todo קישור הינו לשורש של המסך הניתונים
        //7. saving data on the firebase database
        reference= FirebaseDatabase.getInstance().getReference();
        // 8. add completeListener to check if the insertion done
        
        //// todo בפעם הראשונה שמופעל המאזין מרבלים בעתק לכל הנתונים תחת כתובת זו 
        reference.child(email).child("my list").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) //// todo העתק מהנותנים שהורדנו 
            {
                productAdapter.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren())
                {
                    product p=ds.getValue(product.class);
                    Log.d("SL",p.toString());
                    productAdapter.add(p);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
