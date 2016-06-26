package com.virtualsiam.virtualsiamubook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by MRRT on 26/6/2559.
 */
public class BookAdapter extends BaseAdapter{

    // Explicit

    private Context context;
    private String[] nameStrings, priceStrings, coverStrings;

    public BookAdapter(String[] priceStrings, Context context,
                       String[] nameStrings,
                       String[] coverStrings) {
        this.priceStrings = priceStrings;
        this.context = context;
        this.nameStrings = nameStrings;
        this.coverStrings = coverStrings;
    }

    @Override
    public int getCount() {
        return nameStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.book_listview, viewGroup, false);

        TextView nameTextView = (TextView) view1.findViewById(R.id.textView7);
        TextView priceTextView = (TextView) view1.findViewById(R.id.textView8);
        ImageView coverImageView = (ImageView) view1.findViewById(R.id.imageView2);

        nameTextView.setText(nameStrings[i]);
        priceTextView.setText(priceStrings[i]);

        Picasso.with(context).load(coverStrings[i]).resize(150,180).into(coverImageView);


        return view1;
    }
} //Main Class
