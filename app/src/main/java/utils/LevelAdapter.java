package utils;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import app.vocabulary.craftystudio.vocabularymaster.R;

/**
 * Created by Aisha on 6/21/2018.
 */

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.MyViewHolder> {


    public ArrayList<Level> levelNameList;
    ClickListener clickListener;

    Context context;


    public LevelAdapter(Context context, ClickListener clickListener, ArrayList<Level> levelNameList) {
        this.levelNameList = levelNameList;
        this.context = context;
        this.clickListener = clickListener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView levelName;

        public MyViewHolder(View itemView) {
            super(itemView);
            levelName = (TextView) itemView.findViewById(R.id.level_row_name);

        }


        public void onAdapterClick(final ClickListener clickListener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemCLickListener(v, getAdapterPosition());
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.level_row, parent, false);
        return new MyViewHolder(itemView);


    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Level level = levelNameList.get(position);
        holder.levelName.setText(level.getLevelName());
        holder.onAdapterClick(clickListener);

    }


    @Override
    public int getItemCount() {
        return levelNameList.size();
    }


}
