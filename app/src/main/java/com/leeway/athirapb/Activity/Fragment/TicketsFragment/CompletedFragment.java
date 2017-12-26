package com.leeway.athirapb.Activity.Fragment.TicketsFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leeway.athirapb.Activity.Activity.Sign_in;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForTickets;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.dummy.DummyContent;
import com.leeway.athirapb.Activity.Fragment.TicketsFragment.dummy.DummyContent.DummyItem;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceNull;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceTickets;
import com.leeway.athirapb.Activity.Model.ProjectInfo;
import com.leeway.athirapb.Activity.Model.Tickets.TicketInfo;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListenerCompleted}
 * interface.
 */
public class CompletedFragment extends Fragment implements OnHttpResponceTickets {
    OnHttpResponceNull onHttpResponceNull;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListenerCompleted mListener;
    List<TicketInfo> ticketsInfoListss;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    RecyclerView recyclerView;
    public CompletedFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CompletedFragment newInstance(int columnCount) {
        CompletedFragment fragment = new CompletedFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_list, container, false);
        ticketsInfoListss=new ArrayList<>();
        // Set the adapter
        SessionManager sessionManager=new SessionManager(getActivity());
        String userid=sessionManager.getUserId();

if (!userid.equals("")) {
    HttpRequestForTickets httpRequestForTickets = new HttpRequestForTickets(this);
    httpRequestForTickets.getTickets(userid,"1");
}
else
{

    onHttpResponceNull.OnLoginNull("null loguin");
}

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyCompletedRecyclerViewAdapter(ticketsInfoListss, mListener,getActivity()));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListenerCompleted) {
            mListener = (OnListFragmentInteractionListenerCompleted) context;
            onHttpResponceNull= (OnHttpResponceNull) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListenerCompleted");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void OnTicketsFaild(String s) {

    }

    @Override
    public void OnTicketsSuccessTrue(String success, boolean b, List<TicketInfo> ticketsInfoList) {
        recyclerView.setAdapter(new MyCompletedRecyclerViewAdapter(ticketsInfoList, mListener,getActivity()));
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
    public interface OnListFragmentInteractionListenerCompleted {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
