package net.jesusalvarezarriaga.pasoparametros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context ctx;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        /* El view representa el Layout. Y depende de que widgets utilicemos en el Layout. */
        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.txtItem);
        }
    }

    String[] mdataSet;
    ArrayList<String> datos;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> dataSet) {
        datos = dataSet;
    }

    /* Constructor con contexto. Esto es nuevo. */
    public MyAdapter(ArrayList<String> dataSet, Context ctx) {
        datos = dataSet;
        this.ctx = ctx;
    }

    // Create new views (invoked by the layout manager).
    /* Permite inflar los datos que pasan de XML a Java. */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    /* Es necesario instanciar cada widget con funcionalidad debido a que el adaptador no permite
    funcionalidades específicas en cada widget, en este ejemplo setOnClickListener. */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(datos.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, "Presionando: " + ((TextView)view).getText(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return datos.size();
    }
}