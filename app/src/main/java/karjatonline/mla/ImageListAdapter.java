package karjatonline.mla;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ImageListAdapter extends ArrayAdapter<ImageItem> {
    Context context;
    int layoutResourceId;
//    int[] data;
    ArrayList<ImageItem> data;

    //List<string_item> data=null;

    //    public PreportListAdapter(Context context, int resource, ArrayList<String[]> ad) {
    public ImageListAdapter(Context context, int resource, ArrayList<ImageItem> data) {
//        super(context, resource, objects);
        super(context,resource,data);
        this.context = context;
        this.data=data;
//        this.ad=ad;
        this.layoutResourceId = resource;
    }

    static class myHolder {

        ImageView iv;
        TextView tv;
        //int noContact=0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageListAdapter.myHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);

            holder = new ImageListAdapter.myHolder();
            holder.iv=convertView.findViewById(R.id.iv);
            holder.tv=convertView.findViewById(R.id.tv);

            convertView.setTag(holder);


        } else {
            holder = (ImageListAdapter.myHolder) convertView.getTag();
        }

        ImageItem item = data.get(position);
       //                                 holder.tv.setText(item.getTitle());
        holder.iv.setImageBitmap(item.getImage());

        return convertView;
    }
}
