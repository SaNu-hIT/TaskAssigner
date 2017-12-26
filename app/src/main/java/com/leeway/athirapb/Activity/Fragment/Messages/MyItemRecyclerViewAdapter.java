package com.leeway.athirapb.Activity.Fragment.Messages;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leeway.athirapb.Activity.Fragment.DashBoardMain.DashFragments;
import com.leeway.athirapb.Activity.Fragment.Messages.dummy.DummyContent.DummyItem;
import com.leeway.athirapb.Activity.Fragment.Messages.dummy.Message;
import com.leeway.athirapb.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link DashFragments.OnFragmentInteractionListenerss}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<Message> mValues;
    private final DashFragments.OnFragmentInteractionListenerss mListener;

    public MyItemRecyclerViewAdapter(List<Message> items, DashFragments.OnFragmentInteractionListenerss listener) {
       this.mValues = items;
       this.mListener = listener;
        Log.e( "count: ",""+mValues.size() );
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.mIdView.setText(mValues.get(position).getMessageTitle());
        holder.mContentView.setText(mValues.get(position).getUsername());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
//                    mListener.onFragmentInteractions(holder.mItem.toString());
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
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
