package com.virtualsiam.virtualsiamubook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return null;
    }
} //Main Class
