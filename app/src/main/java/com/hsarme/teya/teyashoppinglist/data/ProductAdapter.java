package com.hsarme.teya.teyashoppinglist.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsarme.teya.teyashoppinglist.R;
import com.sun.istack.internal.NotNull;

/**
 * Created by user on 21/02/2018.
 */

public class ProductAdapter extends ArrayAdapter<product> {
    /**
     * context
     * rescoure
     */
    public ProductAdapter(@NotNull Context context, @LayoutRes int resouce) {
        super(context, resouce);
    }

    /**
     * todo מספר סידורי של הנתון עצם ממקור הניתונים
     *
     * @param position    the index of one item from the data (object) source. starting from zero
     * @param convertView todo ListView הממשק שיכול להציג אוסף הניתונים לדוגמה
     * @param parent
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.productitem, parent, false);
        TextView itmTvname = (TextView) view.findViewById(R.id.itmTvname);
        TextView itmTvprice = (TextView) view.findViewById(R.id.itmTvprice);
        TextView itmTvamount = (TextView) view.findViewById(R.id.itmTvamount);
        ImageView itmImage=(ImageView)view.findViewById(R.id.itmChblsCompleted);
        CheckBox itmChbIsCompleted=(CheckBox)view.findViewById(R.id.itmCblsCompleted);
        product p =getItem(position);
        itmTvname.setText(p.getName());
        itmTvprice.setText((int) p.getPrice()+"");
        itmTvamount.setText((int) p.getAmount()+"");
        itmChbIsCompleted.setChecked(p.isCompleted());
        return view;
    }

}

