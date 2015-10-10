package com.nansoft.msp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nansoft.msp.R;
import com.nansoft.msp.model.Event;

/**
 * Created by Carlos on 24/08/2015.
 */
public class EventAdapter extends ArrayAdapter<Event> {

    int mLayoutResourceId;
    ViewHolder holder;
    Context mContext;

    public EventAdapter(Context context)
    {
        super(context, R.layout.item_event);
        mContext = context;
        mLayoutResourceId = R.layout.item_event;
    }

    // regresa la vista de cada elemento de la lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        final Event currentItem = getItem(position);


        // verificamos si la fila que se va dibujar no existe
        if (row == null) {
            // si es así la creamos
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
            ViewHolder holder = new ViewHolder();

            holder.imgLogoEvento = (ImageView) row.findViewById(R.id.imgLogoEvento);
            holder.txtvTituloEvento = (TextView) row.findViewById(R.id.txtvTituloEvento);
            holder.txtvFechaEvento = (TextView) row.findViewById(R.id.txtvFechaEvento);

            row.setTag(holder);

        }
        // en caso contrario la recuperamos
        ViewHolder holder = (ViewHolder) row.getTag();

        Glide.with(mContext)
                .load(currentItem.getPictureURL().trim())
                .asBitmap()
                .fitCenter()
                .placeholder(R.drawable.load_picture)
                .error(R.drawable.fail_picture)
                .into(holder.imgLogoEvento);

        holder.txtvTituloEvento.setText(currentItem.getName());
        holder.txtvFechaEvento.setText(currentItem.getDate());


        return row;

    }

    // guarda el estado de cada vista la primera vez que se dibuja
    static class ViewHolder {
        protected ImageView imgLogoEvento;
        protected TextView txtvTituloEvento;
        protected TextView txtvFechaEvento;
    }


}
