package com.okcodex1.doctor24sylhet.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.okcodex1.doctor24sylhet.Model.Modelclass;
import com.okcodex1.doctor24sylhet.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Myholder> {
    private int lastPosition = -1;
    int row_index = -1;


    private static final String TAG = "CustomAdapter";
    Context context;
    List<Modelclass> list;

    private CustomAdapter2.OnItemClickListener mListener;

    public interface OnItemClickListener {

        void onItemClick(Modelclass modelclass);

    }
    public void setOnItemClickListener(CustomAdapter2.OnItemClickListener listener) {
        mListener = listener;
    }


    public CustomAdapter(Context context, List<Modelclass> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sampledoctorslist, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        Modelclass modelclass = list.get(position);

        holder.allname.setText(modelclass.getName());
        holder.qualification.setText(modelclass.getQualification());
        holder.image.setImageResource(modelclass.getImage());

        Log.d(TAG, "onBindViewHolder: " + modelclass.getName());
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Myholder extends RecyclerView.ViewHolder {
        TextView allname, qualification;
        ImageView image;


        public Myholder(@NonNull View itemView) {
            super(itemView);

            allname = itemView.findViewById(R.id.LtextviewID);
            qualification = itemView.findViewById(R.id.LtextviewID1);
            image = itemView.findViewById(R.id.LcircularimageId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {

                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {

                            mListener.onItemClick(list.get(getAdapterPosition()));
                        }
                    }

                }
            });
        }

    }


    public void setSearchOperation(List<Modelclass> newlist) {

        list = new ArrayList<>();
        list.clear();
        list.addAll(newlist);
        notifyDataSetChanged();


   }
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            //TranslateAnimation anim = new TranslateAnimation(0,-1000,0,-1000);
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            //anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            anim.setDuration(550);//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            lastPosition = position;

        }
    }
}
