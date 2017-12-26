package com.leeway.athirapb.Activity.Fragment.TicketsFragment;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.CompletedFragment.OnListFragmentInteractionListenerCompleted;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.dummy.DummyContent.DummyItem;
import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;
import com.leeway.athirapb.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListenerCompleted}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCompletedRecyclerViewAdapter extends RecyclerView.Adapter<MyCompletedRecyclerViewAdapter.ViewHolder> {

    private final List<TicketInfo> mValues;
    private final OnListFragmentInteractionListenerCompleted mListener;
    Context context;
    public MyCompletedRecyclerViewAdapter(List<TicketInfo> items, OnListFragmentInteractionListenerCompleted listener,Context context) {
        mValues = items;
        mListener = listener;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_completed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

            holder.mIdView.setText(mValues.get(position).getTicketHeading());
            holder.mContentView.setText(mValues.get(position).getTicketDesc());
            holder.msg_name.setText(mValues.get(position).getPriority());
            holder.count.setText(mValues.get(position).getAssignDate());
            Glide.with(context).load(mValues.get(position).getTicketImage().toString()).placeholder(context.getResources().getDrawable(R.drawable.user)).into(holder.imageView);


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView msg_name;
        public final TextView count;
        ImageView imageView;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            msg_name = (TextView) view.findViewById(R.id.msg_name);
            count = (TextView) view.findViewById(R.id.count);
            imageView = (ImageView) view.findViewById(R.id.tckt_image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
