package com.leeway.athirapb.Activity.Fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Connectivity.HttpRequestForApplyLeave;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForApplyLeave;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link ApplyLeaveFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ApplyLeaveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApplyLeaveFragment extends Fragment implements OnHttpResponceForApplyLeave {
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

    public ApplyLeaveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApplyLeaveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ApplyLeaveFragment newInstance(String param1, String param2) {
        ApplyLeaveFragment fragment = new ApplyLeaveFragment();
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
EditText
    leave_desc,
    leave_date,
    joining_date,
    leave_days;

    private void updateLabel() {

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        leave_date.setText(sdf.format(myCalendar.getTime()));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apply_leave, container, false);


        leave_desc=view.findViewById(R.id.leave_desc);
        leave_date=view.findViewById(R.id.leave_date);
        joining_date=view.findViewById(R.id.joining_date);
        leave_days=view.findViewById(R.id.leave_days);


        myCalendar = Calendar.getInstance();

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = df.format(myCalendar.getTime());
//        joining_date.setText(formattedDate);

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        joining_date.setText(sdf.format(myCalendar.getTime()));
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DATE, dayOfMonth);
                updateLabel();
            }

        };

        leave_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DATE)).show();
            }
        });
        SessionManager sessionManager=new SessionManager(getActivity());
        final String userId=sessionManager.getUserId();

        Button button=view.findViewById(R.id.savedata);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallApi(leave_desc.getText().toString(),leave_date.getText().toString(),joining_date.getText().toString(),leave_days.getText().toString(),userId);
            }
        });
        //Find the +1 button

        return view;
    }

    private void CallApi(String leave_desc, String leave_date, String joining_date, String leave_days, String userId) {

        HttpRequestForApplyLeave httpRequestForApplyLeave=new HttpRequestForApplyLeave(this);

httpRequestForApplyLeave.ApplyLeave(userId,leave_desc,leave_date,joining_date,leave_days);
    }

    @Override
    public void onResume() {
        super.onResume();


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
    public void AddApplyLeaveSuccess(String stautus, Boolean success) {
        Toast.makeText(getActivity(), ""+stautus, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddApplyLeaveFaild(Throwable throwable) {

    }

    @Override
    public void AddApplyLeaveSuccessTrue(String success, boolean b) {
        ClearUi();
        Toast.makeText(getActivity(), ""+success, Toast.LENGTH_SHORT).show();

    }

    private void ClearUi() {

        leave_desc.setText("");
                leave_date.setText("");
                joining_date.setText("");
                leave_days.setText("");

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
