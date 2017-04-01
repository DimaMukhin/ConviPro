package com.convipro.unknown.convipro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by UNKNOWN on 19/07/2016.
 */
public class MainActivityListFragment extends ListFragment {
    final static String EXTRA_OPTION_ID = "com.convipro.unknown.ID";
    private Context context;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();

        String[] options = new String[] { context.getString(R.string.length), context.getString(R.string.mass),
                context.getString(R.string.speed), context.getString(R.string.temperature), context.getString(R.string.volume),
                context.getString(R.string.pressure), context.getString(R.string.angle), context.getString(R.string.frequency),
                context.getString(R.string.energy), context.getString(R.string.digital_storage)};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, options);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        System.out.println("position: " + position + " ID: " + id);
        Intent converter = new Intent(getActivity().getApplicationContext(), Converter.class);
        converter.putExtra(EXTRA_OPTION_ID, id);
        startActivity(converter);
    }

}
