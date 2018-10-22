package com.antelope.android.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    /**
     * @param convertView 用于将之前加载好的布局进行缓存，以便之后可以进行重用。
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;

        //布局重用
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.iv);
            viewHolder.textView = view.findViewById(R.id.tv);

            //调用setTag()，将ViewHolder对象存储在View中。
            view.setTag(viewHolder);

        } else {
            view = convertView;

            //调用getTag()，把ViewHolder重新取出。
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }

    /*内部类ViewHolder类，用于对控件的实例进行缓存，
    这样可以不用每次在getView方法中调用View的findViewById()方法来获取一次控件的实例。*/
    class ViewHolder {

        ImageView imageView;

        TextView textView;

    }

}
