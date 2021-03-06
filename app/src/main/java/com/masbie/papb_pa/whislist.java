package com.masbie.papb_pa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link whislist.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link whislist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class whislist extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    String[] titlewhislist = new String[]{
            "Baju biru ",
            "Baju hitam ",
            "Baju hijau ",
    };
    int[] imagekiri = new int[]{
            R.drawable.bajubirudepan,
            R.drawable.bajuhitamdepan,
            R.drawable.bajuhijaudepan,
    };
//    int[] imagebawah = new int[]{
//            R.drawable.paket,
//            R.drawable.paket,
//            R.drawable.paket,
//    };    int[] imagebawah1 = new int[]{
//            R.drawable.kirim,
//            R.drawable.kirim,
//            R.drawable.kirim,
//    };    int[] imagebawah2 = new int[]{
//            R.drawable.diterimawar,
//            R.drawable.diterima,
//            R.drawable.diterima,
//    };
    String[] deswhislist = new String[]{
            "Selesai ",
            "Masih dalam perjalanan ",
            "Masih dalam perjalanan",
    };

    public whislist() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment whislist.
     */
    // TODO: Rename and change types and number of parameters
    public static whislist newInstance(String param1, String param2) {
        whislist fragment = new whislist();
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
        View v = inflater.inflate(R.layout.fragment_whislist, container, false);
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("titlewhislist", titlewhislist[i]);
            hm.put("deswhislist", deswhislist[i]);
            hm.put("imagekiri", Integer.toString(imagekiri[i]));
//            hm.put("imagebawah", Integer.toString(imagebawah[i]));
//            hm.put("imagebawah1", Integer.toString(imagebawah1[i]));
//            hm.put("imagebawah2", Integer.toString(imagebawah2[i]));
            list.add(hm);
        }
        String[] dari = {"imagekiri", "titlewhislist", "deswhislist"};
        int[] ke = {R.id.imagekiri, R.id.titlewhislist, R.id.deswhislist};
        SimpleAdapter simpleAdapter = new SimpleAdapter(v.getContext(), list, R.layout.listview_whislist, dari, ke);
        ListView listView = (ListView) v.findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);
        return v;
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
