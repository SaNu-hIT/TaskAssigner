package com.leeway.athirapb.Activity.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.leeway.athirapb.Activity.Activity.DetaildActivity.DetailsActivity;
import com.leeway.athirapb.Activity.Activity.ProjectDetails;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForProject;
import com.leeway.athirapb.Activity.Fragment.dummy.DummyContent;
import com.leeway.athirapb.Activity.Fragment.dummy.DummyContent.DummyItem;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceProject;
import com.leeway.athirapb.Activity.Model.ProjectImage;
import com.leeway.athirapb.Activity.Model.ProjectInfo;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListeners}
 * interface.
 */
public class ProjectFragment extends Fragment implements OnHttpResponceProject {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private OnListFragmentInteractionListeners mListener;
SessionManager sessionManager;
    TextView pname,pdesc;
    ImageView msg,dte,strgnth;
    LinearLayout linearLayout;
    List<ProjectInfo> projectInfoList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProjectFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProjectFragment newInstance(int columnCount) {
        ProjectFragment fragment = new ProjectFragment();
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


    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_project_list, container, false);
        linearLayout=(LinearLayout) view.findViewById(R.id.linr);
        pname=(TextView) view.findViewById(R.id.prjct_name);
        pdesc=view.findViewById(R.id.content);
        msg=view.findViewById(R.id.msg_name);

        strgnth=view.findViewById(R.id.count);
        sessionManager=new SessionManager(getActivity());
        projectInfoList=new ArrayList<>();
        String usrid=sessionManager.getUserId();
        Log.e("user_id:",usrid);
        HttpRequestForProject httpRequestForProject=new HttpRequestForProject(this);
        httpRequestForProject.getProject(usrid,"");
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
             recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyProjectRecyclerViewAdapter(projectInfoList, mListener,getActivity()));
        }

//        if(!usrid.equals(""))
//        {
//            Log.e("user",usrid);
//            HttpRequestForProject httpRequestForProject=new HttpRequestForProject(this);
//            httpRequestForProject.getProject(usrid);
//        }

        // Set the adapter

        //linearLayout=new LinearLayout(getActivity());
//   linearLayout.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               Intent intent=new Intent(getActivity(), ProjectDetails.class);
//               startActivity(intent);
//           }
//       });
//        pname.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getActivity(), ProjectDetails.class);
//                startActivity(intent);
//            }
//        });
      return view;
  }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListeners) {
            mListener = (OnListFragmentInteractionListeners) context;
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
    public void OnProjectFaild(String s) {

        Log.e("P_name",s);

    }

    @Override
    public void OnProjectSuccessTrue(String success, boolean b, List<ProjectInfo> projectInfoList) {

        Log.e("P_name",projectInfoList.get(0).getProName());
        recyclerView.setAdapter(new MyProjectRecyclerViewAdapter(projectInfoList, mListener,getActivity()));
        setData(projectInfoList);


    }


    public interface OnListFragmentInteractionListeners {
        // TODO: Update argument type and name
        void onListFragmentInteraction(int item);



    }
    private void setData(List<ProjectInfo>projectInfoList)
    {
        List<ProjectImage>projectImages;

        Log.e("name:",projectInfoList.get(0).getProName());


    }
}
