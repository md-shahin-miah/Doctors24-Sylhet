package com.okcodex1.doctor24sylhet.Adapter;

import android.content.Context;
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

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Myholder> {
    private int lastPosition = -1;
    int row_index = -1;
    public static Clicklistener clicklistener;

    Context context;
    List<Modelclass> list;


    public MyAdapter2(Context context, List<Modelclass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.samplelayout, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {


        Modelclass model = list.get(position);
        holder.allname.setText(model.getName());
        holder.qualification.setText(model.getQualification());
        holder.imageView.setImageResource(model.getImage());
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myholder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView allname, qualification;
        ImageView imageView;

        public Myholder(@NonNull final View itemView) {
            super(itemView);
            allname = itemView.findViewById(R.id.NameId);
            qualification = itemView.findViewById(R.id.QualificationID);
            imageView = itemView.findViewById(R.id.CircularImageID);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


        }

        @Override
        public void onClick(View v) {
            clicklistener.onItemClick(getAdapterPosition(), v);

        }

        @Override
        public boolean onLongClick(View v) {
            clicklistener.onItemLongClick(getAdapterPosition(), v);
            return false;
        }
    }

    public interface Clicklistener {

        void onItemClick(int position, View v);

        void onItemLongClick(int position, View v);

    }

    public void setOnItemClickListener(MyAdapter2.Clicklistener clicklistener) {
        MyAdapter2.clicklistener = clicklistener;
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
