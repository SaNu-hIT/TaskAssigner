package com.leeway.athirapb.Activity.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Connectivity.HttpRequestForAddNews;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddNews;
import com.leeway.athirapb.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddNotification.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddNotification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNotification extends Fragment implements OnHttpResponceForAddNews {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText noticiationtext;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddNotification() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddNotification.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNotification newInstance(String param1, String param2) {
        AddNotification fragment = new AddNotification();
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
Button add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_add_notification, container, false);

       noticiationtext=view.findViewById(R.id.message);
       add=view.findViewById(R.id.add_noti);



       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
        callAPi();
           }
       });

       return view;
    }

    private void callAPi() {
        if(noticiationtext.getText().equals("")) {
            noticiationtext.setFocusable(true);
            noticiationtext.setError("Require Message");
            return;
        }
        else
        {

            HttpRequestForAddNews httpRequestForAddNews = new HttpRequestForAddNews(this);
            httpRequestForAddNews.AddNews(noticiationtext.getText().toString());

        }
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
    public void AddNewsSuccess(String stautus, Boolean success) {
        Toast.makeText(getActivity(), ""+stautus, Toast.LENGTH_SHORT).show();
        Snackbar.make(getView(), stautus, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void AddNewsFaild(Throwable throwable) {

    }

    @Override
    public void AddNewsSuccessTrue(String success, boolean b) {
        Toast.makeText(getActivity(), ""+success, Toast.LENGTH_SHORT).show();
        noticiationtext.setText("");
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
