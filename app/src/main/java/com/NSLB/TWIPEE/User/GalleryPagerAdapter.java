package com.NSLB.TWIPEE.User;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.NSLB.TWIPEE.R;

import java.util.ArrayList;

public class GalleryPagerAdapter extends PagerAdapter {
    private Context mContext = null;
    private ArrayList<Uri> lstUri = new ArrayList<>();

    public GalleryPagerAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container , int position) {
        View view=null;
        GalleryViewHolder holder;
        if (mContext !=null){
            LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.galleryimage, container,false);
            holder=new GalleryViewHolder();
            holder.galleryview=(ImageView)view.findViewById(R.id.galleryimage);
            if (lstUri.size()>0)
                holder.galleryview.setImageURI(lstUri.get(position));
        }
        container.addView(view);
        return view;
    }

    public void addItem(Uri uri){
        lstUri.add(uri);
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((View)object);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(View)object);
    }
    class GalleryViewHolder{
        ImageView galleryview;
    }
}
