package com.leeway.athirapb.Activity.Fragment.StatusListing;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leeway.athirapb.Activity.Connectivity.HttpRequestForListStatus;
import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.Message;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceListStatus;
import com.leeway.athirapb.R;
import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.DummyContent;
import com.leeway.athirapb.Activity.Fragment.StatusListing.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class StatusListingFragment extends Fragment implements OnHttpResponceListStatus {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<Message> ticketsInfoLists;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StatusListingFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static StatusListingFragment newInstance(int columnCount) {
        StatusListingFragment fragment = new StatusListingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list3, container, false);

        // Set the adapter
        ticketsInfoLists=new ArrayList<>();
        HttpRequestForListStatus httpRequestForListStatus=new HttpRequestForListStatus(this);
        httpRequestForListStatus.GetLeave();
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ticketsInfoLists, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void OnListStatusFaild(String s) {

    }

    @Override
    public void OnListStatusSuccessTrue(String success, boolean b, List<Message> ticketsInfoList) {
        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ticketsInfoList, mListener));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
