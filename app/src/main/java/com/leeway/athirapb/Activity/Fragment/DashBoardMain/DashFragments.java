package com.leeway.athirapb.Activity.Fragment.DashBoardMain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Connectivity.HttpRequestForMessage;
import com.leeway.athirapb.Activity.Fragment.Messages.MyItemRecyclerViewAdapter;
import com.leeway.athirapb.Activity.Fragment.Messages.dummy.Message;
import com.leeway.athirapb.Activity.Fragment.Status.Employee_status;
import com.leeway.athirapb.Activity.Fragment.Status.StatusFragment;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceMessage;
import com.leeway.athirapb.Activity.OnFragmentActionClick;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListenerss} interface
 * to handle interaction events.
 * Use the {@link DashFragments#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashFragments extends Fragment implements OnHttpResponceMessage{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentActionClick onFragmentActionClick;
    private OnFragmentInteractionListenerss mListener;
//    FloatingActionButton floatingActionButton;
TextView name,id;
    private RecyclerView recyclerView;
    private List<Message> ticketsInfoList;
    private TextView id_useruser;

    //SharedPreferences sh;
    public DashFragments() {
        super();
        // Required empty public constructor
    }
//    @SuppressLint("ValidFragment")
//    public DashFragments(OnFragmentActionClick onFragmentActionClick) {
//        super();
//        this.onFragmentActionClick = onFragmentActionClick;
//        onFragmentActionClick.onClick();
//    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static DashFragments newInstance(String param1, String param2) {
        DashFragments fragment = new DashFragments();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_dash_fragments, container, false);
        SessionManager sessionManager=new SessionManager(getActivity());
        ticketsInfoList=new ArrayList<>();
name=(TextView)view.findViewById(R.id.names);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerview);




id=(TextView)view.findViewById(R.id.userid);
        id_useruser=(TextView)view.findViewById(R.id.id_useruser);
name.setText(sessionManager.getUsername());
       id.setText(sessionManager.getPhone());
        id_useruser.setText(sessionManager.getEmail());

//        floatingActionButton=view.findViewById(R.id.floating);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "ygftuygu", Toast.LENGTH_SHORT).show();
//                getFragmentManager().beginTransaction().add(R.id.container,new StatusFragment()).commit();
////                Intent intent= new Intent(getActivity(),StatusFragment);
////                startActivity(intent);
//            }
//        });

        HttpRequestForMessage httpRequestForMessage=new HttpRequestForMessage(this);
        httpRequestForMessage.getMessage(sessionManager.getUserId(),"");

        // Set the adapter

            Context context = view.getContext();
//            recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ticketsInfoList,mListener));



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteractions("");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerss) {
            mListener = (OnFragmentInteractionListenerss) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void OnMessageFaild(String s) {

    }

    @Override
    public void OnMessageSuccessTrue(String success, boolean b, List<Message> ticketsInfoList) {

        recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ticketsInfoList,mListener));

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListenerss {
        // TODO: Update argument type and name
        void onFragmentInteractions(String uri);
    }



}
