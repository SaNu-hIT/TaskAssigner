package com.leeway.athirapb.Activity.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Connectivity.HttpRequestForAddStatus;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddStatus;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link StatusUpdationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatusUpdationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatusUpdationFragment extends Fragment implements OnHttpResponceForAddStatus {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;
    private Calendar myCalendar;

    public StatusUpdationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatusUpdationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatusUpdationFragment newInstance(String param1, String param2) {
        StatusUpdationFragment fragment = new StatusUpdationFragment();
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
    SessionManager sessionManager;

    EditText status_title,status_desc,cur_date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status_updation, container, false);
sessionManager=new SessionManager(getActivity());
        status_title=view.findViewById(R.id.status_title);
        status_desc=view.findViewById(R.id.status_desc);
        cur_date=view.findViewById(R.id.cur_date);
        myCalendar = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(myCalendar.getTime());
        cur_date.setText(formattedDate);

Button button= view.findViewById(R.id.savedata);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        String  userid=sessionManager.getUserId();
        CallApi(status_title.getText().toString(),status_desc.getText().toString(),cur_date.getText().toString(),userid);

    }
});

        return view;
    }

    private void CallApi(String s, String s1, String s2, String userid) {


        HttpRequestForAddStatus httpRequestForAddStatus=new HttpRequestForAddStatus(this);
        httpRequestForAddStatus.ApplyLeave(s,s1,s2,userid);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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
    public void AddAddStatusSuccess(String stautus, Boolean success) {
        Toast.makeText(getActivity(), ""+stautus, Toast.LENGTH_SHORT).show();
        ClaearAll();
    }

    private void ClaearAll() {
        status_title.setText("");
        status_desc.setText("");

    }

    @Override
    public void AddAddStatusFaild(Throwable throwable) {

        Toast.makeText(getActivity(), ""+throwable, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddAddStatusSuccessTrue(String success, boolean b) {
        Toast.makeText(getActivity(), ""+success, Toast.LENGTH_SHORT).show();
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
