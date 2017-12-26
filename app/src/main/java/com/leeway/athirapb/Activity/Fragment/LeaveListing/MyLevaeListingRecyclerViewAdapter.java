package com.leeway.athirapb.Activity.Fragment.LeaveListing;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leeway.athirapb.Activity.Fragment.LeaveListing.LeaveListingFragment.OnListFragmentInteractionListener;
import com.leeway.athirapb.Activity.Fragment.LeaveListing.dummy.DummyContent.DummyItem;
import com.leeway.athirapb.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLevaeListingRecyclerViewAdapter extends RecyclerView.Adapter<MyLevaeListingRecyclerViewAdapter.ViewHolder> {

    private final List<Message> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyLevaeListingRecyclerViewAdapter(List<Message> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;

        Log.e( "size",""+items.size() );
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_levaelisting, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mIdView.setText(mValues.get(position).getLeaveDate());
        holder.mContentView.setText("Reson :"+mValues.get(position).getLeaveDesc());
        holder.days.setText("Days :"+mValues.get(position).getLeaveDays());

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
        public final TextView mContentView,days;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            days = (TextView) view.findViewById(R.id.days);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
