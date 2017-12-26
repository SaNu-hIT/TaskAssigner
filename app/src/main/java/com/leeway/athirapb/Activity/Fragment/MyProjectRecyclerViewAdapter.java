package com.leeway.athirapb.Activity.Fragment;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leeway.athirapb.Activity.Fragment.dummy.DummyContent.DummyItem;
import com.leeway.athirapb.Activity.Model.ProjectInfo;
import com.leeway.athirapb.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProjectRecyclerViewAdapter extends RecyclerView.Adapter<MyProjectRecyclerViewAdapter.ViewHolder> {

    private final List<ProjectInfo> mValues;
    private final ProjectFragment.OnListFragmentInteractionListeners mListener;
Context context;
    public MyProjectRecyclerViewAdapter(List<ProjectInfo> items, ProjectFragment.OnListFragmentInteractionListeners listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mIdView.setText(mValues.get(position).getProName());
        holder.mContentView.setText(mValues.get(position).getProDesc());
        holder.msg_name.setText(mValues.get(position).getTeamStrength());
        holder.pro_dates.setText(mValues.get(position).getSubmissionDate());
        holder.count.setText(mValues.get(position).getClientName());
        Glide.with(context).load(mValues.get(position).getProjectImage().toString()).placeholder(context.getResources().getDrawable(R.drawable.user)).into(holder.imageView);

holder.clickid.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        mListener.onListFragmentInteraction(Integer.parseInt(mValues.get(position).getProId()));

    }
});
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView msg_name;
        public final TextView pro_dates;
        public final TextView count;
        public final ImageView imageView;
        CardView clickid;


        public ViewHolder(View view) {
            super(view);

            mIdView = (TextView) view.findViewById(R.id.prjct_name);
            mContentView = (TextView) view.findViewById(R.id.content);
            msg_name = (TextView) view.findViewById(R.id.msg_name);
            pro_dates = (TextView) view.findViewById(R.id.pro_dates);
            count = (TextView) view.findViewById(R.id.count);
            imageView = (ImageView) view.findViewById(R.id.prjct_image);
            clickid = (CardView) view.findViewById(R.id.clickid);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
