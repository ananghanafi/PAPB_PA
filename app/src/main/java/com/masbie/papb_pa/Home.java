package com.masbie.papb_pa;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // Deklarasi thread
    private Thread threadBackground;

    // Deklarasi handler sebagai jembatan antar Thread
    private Handler handler = new Handler();
    private Integer angka = 0;
    ImageView promo1, promo2, promo3;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FloatingActionButton floatinglogin;
    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
//        Thread timer = new Thread() {
//            public void run() {
//                int time = 0;
//                while (time <= 7000) {
//                    System.out.println("yaini"+time);
//                    try {
//                        sleep(100);
//                        time = +2000;
//                        System.out.println("yainilagi"+time+" ");
//                        if (time == 2000) {
////                            ImageView pr=(ImageView) getView().findViewById(R.id.runnable);
////                            pr.setImageResource(R.drawable.ic_menu_share);
//                         //   promo1.setImageResource(R.drawable.contact);
//                            promo3.setVisibility(View.INVISIBLE);
//                promo2.setVisibility(View.INVISIBLE);
//               promo1.setVisibility(View.VISIBLE);
//                        }
//                        if (time == 5000) {
//                            ImageView pr1=(ImageView) getView().findViewById(R.id.runnable);
//                            pr1.setImageResource(R.drawable.ic_menu_gallery);
//                           // promo1.setImageResource(R.drawable.histrory);
//                        }
//                        if (time == 7000) {
//                            ImageView pr2=(ImageView) getView().findViewById(R.id.runnable);
//                            pr2.setImageResource(R.drawable.histrory);
//                           // promo1.setImageResource(R.drawable.ic_exit);
//                        }
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//
//        };
//        timer.start();

        if (threadBackground == null
                || threadBackground.getState() == Thread.State.TERMINATED) {
            threadBackground = new Thread(runnableBackground);

            // Jalankan Thread
            threadBackground.start();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        this.promo1 = (ImageView) rootView.findViewById(R.id.runnable);
        this.promo2 = (ImageView) rootView.findViewById(R.id.runnable1);
        this.promo3 = (ImageView) rootView.findViewById(R.id.runnable2);
        return rootView;
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        floatinglogin = (FloatingActionButton) view.findViewById(R.id.tologin);
        floatinglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Login.class);
                getActivity().startActivity(i);

            }
        });


    }

    Runnable runnableBackground = new Runnable() {

        @Override
        public void run() {
            for (angka = 0; angka <= 4; angka++) {
                try {
                    if (angka == 1) {
                        // Kirimkan angka random ke Thread UI melalui handler
                        // Runnable yan dijalankan di Thread UI adalah runnableUI
                        handler.post(runnableUI);
                        // Set delay sebelum menggenerate angka lainnya.
                        Thread.sleep(2500);

                    } else if (angka == 2) {
                        // Kirimkan angka random ke Thread UI melalui handler
                        // Runnable yan dijalankan di Thread UI adalah runnableUI
                        handler.post(runnableUI1);

                        // Set delay sebelum menggenerate angka lainnya.
                        Thread.sleep(2500);

                    } else if (angka == 3) {
                        // Kirimkan angka random ke Thread UI melalui handler
                        // Runnable yan dijalankan di Thread UI adalah runnableUI
                        handler.post(runnableUI2);

                        // Set delay sebelum menggenerate angka lainnya.
                        Thread.sleep(2500);

                    } else {
                        angka = 0;

                    }


                    // Jika terjadi exception, yaitu pada saat sleep tombol stop diklik
                    // Telan exceptionnya
                } catch (
                        Exception ex
                        )

                {
                }

                // Tidak boleh mengubah/memanipulasi elemen UI
                // dari Thread yang bukan Thread UI
                //textAngka.setText(angka.toString());
            }

        }
    };

    Runnable runnableUI = new Runnable() {
        @Override
        public void run() {
            promo3.setVisibility(View.INVISIBLE);
            promo2.setVisibility(View.INVISIBLE);
            promo1.setVisibility(View.VISIBLE);
        }
    };
    Runnable runnableUI1 = new Runnable() {
        @Override
        public void run() {
            promo1.setVisibility(View.INVISIBLE);
            promo3.setVisibility(View.INVISIBLE);
            promo2.setVisibility(View.VISIBLE);
        }
    };
    Runnable runnableUI2 = new Runnable() {
        @Override
        public void run() {
            promo1.setVisibility(View.INVISIBLE);
            promo2.setVisibility(View.INVISIBLE);
            promo3.setVisibility(View.VISIBLE);
        }
    };


}
