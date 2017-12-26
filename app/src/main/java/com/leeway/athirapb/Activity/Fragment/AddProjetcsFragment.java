package com.leeway.athirapb.Activity.Fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.cunoraz.tagview.TagView;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.leeway.athirapb.Activity.Adapeters.ImagesAdapter;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForAddProject;
import com.leeway.athirapb.Activity.Connectivity.HttpRequestForListUser;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddNotification;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceForAddProject;
import com.leeway.athirapb.Activity.Interfaces.OnHttpResponceListUser;
import com.leeway.athirapb.Activity.Interfaces.OnImageCloseSelected;
import com.leeway.athirapb.Activity.Model.AddProject.AddProjectBean;
import com.leeway.athirapb.Activity.Model.AddProject.ImageList;
import com.leeway.athirapb.Activity.Model.AddProject.User;
import com.leeway.athirapb.Activity.Model.ListUser.Userinfo;
import com.leeway.athirapb.Activity.SessionManager.SessionManager;
import com.leeway.athirapb.R;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddProjetcsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddProjetcsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddProjetcsFragment extends Fragment implements OnImageCloseSelected, OnHttpResponceForAddProject, OnHttpResponceListUser {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int PERMISSION_REQUEST_CODE = 1;
    SessionManager sessionManager;
    String subcategoryid = "0";
    String catid = "0";
    String event_ids = "0";
    String subcat_ids = "0";
    String venue_types = "0";
    private ProgressDialog progressBar;
    String concept_types = "0";
    List<Uri> mSelected;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;
    ArrayList<File> imagefiles;
    ArrayList<String> imagefilebitmap;
    ArrayList<String> categorySpinnerList;
    ArrayList<String> categorySpinnerIdList;
    ArrayList<String> eventSpinnerList;
    ArrayList<String> venueSpinnerList;
    ArrayList<String> conceptSpinnerList;
    ArrayList<String> eventSpinnerIdList;
    ArrayList<String> SubcategorySpinnerList;
    ArrayList<String> SubcategoryIdSpinnerList;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<byte[]> photos = new ArrayList<>();
    private AddProjetcsFragment.OnFragmentInteractionListener mListener;
    private ImagesAdapter imagesAdapter;
    private List<String> userslisting;
    private List<String> usersidlisting;
    private Calendar myCalendar;
    private MaterialSpinner category;

    public AddProjetcsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddProjetcsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddProjetcsFragment newInstance(String param1, String param2) {
        AddProjetcsFragment fragment = new AddProjetcsFragment();
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


    RecyclerView recyclerView;
    EditText ticket_heading, ticket_desc, assign_date, submission_date, team_strength, client_name, client_phnumber, estimated_cost;

    TagView tagView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_projetcs, container, false);
        category=view.findViewById(R.id.category);
        ticket_heading = view.findViewById(R.id.ticket_heading);
        ticket_desc = view.findViewById(R.id.ticket_desc);
        assign_date = view.findViewById(R.id.assign_date);
        submission_date = view.findViewById(R.id.submission_date);
        team_strength = view.findViewById(R.id.team_strength);
        progressBar = new ProgressDialog(getActivity(),
                ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(false);
        progressBar.setMessage("Loading...");
        progressBar.setCancelable(false);

        progressBar.show();
        client_name = view.findViewById(R.id.client_name);
        client_phnumber = view.findViewById(R.id.client_phnumber);
        estimated_cost = view.findViewById(R.id.estimated_cost);

         tagView=view.findViewById(R.id.tag_group);
        categorySpinnerList = new ArrayList<>();
        eventSpinnerList = new ArrayList<>();
        SubcategorySpinnerList = new ArrayList<>();
        SubcategoryIdSpinnerList = new ArrayList<>();
        categorySpinnerIdList = new ArrayList<>();
        eventSpinnerIdList = new ArrayList<>();
        progressBar.show();
        HttpRequestForListUser httpRequestForListUser=new HttpRequestForListUser(this);
        httpRequestForListUser.getUseList();

        myCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(myCalendar.getTime());
        assign_date.setText(formattedDate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabelnew();
            }

        };

        submission_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();



            }
        });




usersidlisting=new ArrayList<>();
userslisting=new ArrayList<>();
        sessionManager = new SessionManager(getActivity());
        imagesAdapter = new ImagesAdapter(getActivity(), photos);
        imagesAdapter.ImageDeleteListner(this);
        recyclerView = view.findViewById(R.id.recyclerView);
        Button button = view.findViewById(R.id.new_adds);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageAdd();

            }
        });
        Button button1 = view.findViewById(R.id.savedata);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String projettid = "1";
                String userid = sessionManager.getUserId();
                CallApi(ticket_heading.getText().toString(), ticket_desc.getText().toString(), assign_date.getText().toString(), submission_date.getText().toString(), team_strength.getText().toString(), "", "", imagefilebitmap, client_name.getText().toString(),client_phnumber.getText().toString(),
                        estimated_cost.getText().toString());

            }
        });

        category.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
//                category_text.setVisibility(View.VISIBLE);
//                progressBar.show();
                catid = categorySpinnerIdList.get(position);
//                getSubcategory(catid);
                tagView.addTags(new String[]{categorySpinnerList.get(position)});
              SubcategoryIdSpinnerList.add(categorySpinnerIdList.get(position));
                Log.e( "subcat: ",""+SubcategoryIdSpinnerList.toString() );
                Log.e("onItemSelected: ", "catid" + catid);
                Log.e("category: ", "cetgory " + categorySpinnerList.get(position));


            }
        });
        imagefiles = new ArrayList<>();
        imagefilebitmap = new ArrayList<>();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new AddProjetcsFragment.GridSpacingItemDecoration(3, dpToPx(3), false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(imagesAdapter);

//        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getActivity());
//        recyclerView_new.setLayoutManager(mLayoutManager2);
        return view;
    }

    private void updateLabelnew() {



            String myFormat = "yyyy-MM-dd"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

            submission_date.setText(sdf.format(myCalendar.getTime()));



    }

    private void CallApi(String s, String s1, String s2, String s3, String team_strength,
                         String proid, String useid, ArrayList<String> imagefilebitmap,
                         String client_name, String client_phnumber, String estimated_cost) {

        AddProjectBean sendTickets = new AddProjectBean();
        sendTickets.setProName(s);
        sendTickets.setProDesc(s1);
        sendTickets.setAssignDate(s2);
        sendTickets.setSubmissionDate(s3);
        sendTickets.setTeamStrength(team_strength);
        sendTickets.setClientName(client_name);
        sendTickets.setClientPhnumber(client_phnumber);
        sendTickets.setEstimatedCost(estimated_cost);




        List<ImageList> mImageList = new ArrayList<ImageList>();
        for (int i = 0; i < imagefilebitmap.size(); i++) {
            ImageList imageList = new ImageList();
            String image = imagefilebitmap.get(i).toString();


            imageList.setImagedata(image);
            imageList.setFileName("remark");
            mImageList.add(imageList);
        }

        List<User> userslist = new ArrayList<User>();
        for (int i = 0; i < SubcategoryIdSpinnerList.size(); i++) {
           User user=new User();


            user.setUserId(SubcategoryIdSpinnerList.get(i));

            userslist.add(user);
        }
        sendTickets.setImageList(mImageList);
        sendTickets.setUsers(userslist);
        HttpRequestForAddProject httpRequestForAddTickets = new HttpRequestForAddProject(this);
        httpRequestForAddTickets.AddTickets(sendTickets);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteractionAddTickets(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddProjetcsFragment.OnFragmentInteractionListener) {
            mListener = (AddProjetcsFragment.OnFragmentInteractionListener) context;
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


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {

            return true;

        } else {

            return false;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 3 && resultCode == RESULT_OK) {


            Log.e("", "mulipple images");


            mSelected = Matisse.obtainResult(data);


            Log.d("Matisse", "mSelected: " + mSelected);

            Log.e("Count: ", "" + mSelected.size());
            for (int ui = 0; ui < mSelected.size(); ui++) {
                String filePath = mSelected.get(ui).toString();
                try {
                    Bitmap bmp = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(mSelected.get(ui)));
                    String ss = getEncoded64ImageStringFromBitmap(bmp);
                    byte[] imageByteArray = Base64.decode(ss, Base64.DEFAULT);

                    Log.e("", "onImagePicked: " + ss);
                    imagefilebitmap.add(ss);
                    photos.add(imageByteArray);
                    imagesAdapter.notifyDataSetChanged();
                    Log.e("", "onImagePicked: " + ss);
                    Log.e("", "imageByteArray: " + imageByteArray);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Log.e("filePath: ", "" + filePath);

            }


        } else {
            Log.e("onActivityResult: ", "asibfkdas");
            //                if (requestCode == 0) {

            Log.e("", "onImagePicked");

            EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
                @Override
                public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                    //Some error handling
                    e.printStackTrace();
                }


                @Override
                public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {


                    String filePath = imageFile.getPath();
                    Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                    String ss = getEncoded64ImageStringFromBitmap(bitmap);
                    Log.e("", "onImagePicked: " + ss);
                    imagefilebitmap.add(ss);
//                    photos.add(imageFile);
                    imagesAdapter.notifyDataSetChanged();


                }


                @Override
                public void onCanceled(EasyImage.ImageSource source, int type) {
                    //Cancel handling, you might wanna remove taken photo if it was canceled
                    if (source == EasyImage.ImageSource.CAMERA) {
                        File photoFile = EasyImage.lastlyTakenButCanceledPhoto(getActivity());
                        if (photoFile != null) photoFile.delete();
                    }
                }
            });
        }

    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE)) {

            Toast.makeText(getActivity(), "GPS permission allows us to access location data. Please allow in App Settings for additional functionality.", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    private void openCamarasMultipple() {


        if (checkPermission()) {

            Matisse.from(this)
                    .choose(MimeType.allOf())
                    .countable(true)
                    .maxSelectable(9)
                    .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.grid_expected_size))
                    .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                    .thumbnailScale(0.85f)
                    .imageEngine(new GlideEngine())
                    .forResult(3);

//            EasyImage.openGallery(this, 0);
        } else {

            requestPermission();
//            EasyImage.openGallery(this, 0);
            Log.e("TAG", "no premissino");
        }

    }

    public void ImageAdd() {
        openCamarasMultipple();

//        openCamars();

    }

    @Override
    public void OnClickImageClose(View view, int Position) {
        imagefilebitmap.remove(Position);
        photos.remove(Position);
        imagesAdapter.notifyDataSetChanged();

    }


    @Override
    public void AddProjectSuccess(String stautus, Boolean success) {
        ClearAll();
        Toast.makeText(getActivity(), "" + stautus, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void AddProjectFaild(Throwable throwable) {
        Toast.makeText(getActivity(), "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void AddProjectSuccessTrue(String success, boolean b) {
        ClearAll();
        Toast.makeText(getActivity(), "" + success, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnListUserFail(String s) {

    }

    @Override
    public void OnListUserSuccessTrue(String success, boolean b, List<Userinfo> ticketsInfoList) {



        categorySpinnerList.clear();
        categorySpinnerList.add("Add employee");
        categorySpinnerIdList.add("0");
        for (int i = 0; i < ticketsInfoList.size(); i++) {
            String name = ticketsInfoList.get(i).getUsername();
            String id = ticketsInfoList.get(i).getUserId().toString();
            categorySpinnerList.add(name);
            Log.e("", "CATEGORYLIST: " + name);
            categorySpinnerIdList.add(id);

        }

        progressBar.cancel();
        category.setItems(categorySpinnerList);

    }




//    public void CallApi(String ticket_heading,String pro_id,String userId,String ticket_desc,String assign_date,String submission_date,String priority)

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
        void onFragmentInteractionAddTickets(Uri uri);
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
//    EditText ticket_heading, ticket_desc, assign_date, submission_date, team_strength, client_name, client_phnumber, estimated_cost;

    private void ClearAll() {

        ticket_heading.setText("");
        ticket_desc.setText("");assign_date.setText("");submission_date.setText("");ticket_heading.setText("");estimated_cost.setText("");
        client_name.setText("");
        client_phnumber.setText("");
        estimated_cost.setText("");
        imagefilebitmap.clear();
        imagefiles.clear();
        imagefilebitmap.clear();
        photos.clear();
        imagesAdapter.notifyDataSetChanged();
        team_strength.setText("");
        tagView.removeAll();
        SubcategoryIdSpinnerList.clear();





    }
    public String getEncoded64ImageStringFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        byte[] byteFormat = stream.toByteArray();
        // get the base 64 string
        String imgString = Base64.encodeToString(byteFormat, Base64.NO_WRAP);
        return imgString;
    }


}
