package com.masbie.papb_pa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Contact.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Contact extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Thread threadBackground, threadBackground1;
    private TextView calltext;
    private ImageButton  imagbtadd;
    private  Button imgbt;

    // Deklarasi handler sebagai jembatan antar Thread
    private Handler handler = new Handler();

    public Contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Contact.
     */
    // TODO: Rename and change types and number of parameters
    public static Contact newInstance(String param1, String param2) {
        Contact fragment = new Contact();
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
        View rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        this.calltext = (TextView) rootView.findViewById(R.id.textCall);
        this.imgbt = (Button) rootView.findViewById(R.id.kirimpesan);
        this.imagbtadd = (ImageButton) rootView.findViewById(R.id.add);
        imgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Mengirim pesan....");
                builder.show();
                if (threadBackground == null
                        || threadBackground.getState() == Thread.State.TERMINATED) {
                    threadBackground = new Thread(runnableBackground);

                    // Jalankan Thread
                    threadBackground.start();
                }
            }
        });
        calltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tlp = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:113131313"));
                startActivity(tlp);
            }
        });
        imagbtadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Tunggu Akses....");
                builder.show();
                if (threadBackground1 == null
                        || threadBackground1.getState() == Thread.State.TERMINATED) {
                    threadBackground1 = new Thread(runnableBackground1);

                    // Jalankan Thread
                    threadBackground1.start();
                }
            }
        });
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

    Runnable runnableBackground = new Runnable() {

        @Override
        public void run() {
            try {

                Thread.sleep(2000);
                // Kirimkan angka random ke Thread UI melalui handler
                // Runnable yan dijalankan di Thread UI adalah runnableUI
                handler.post(runnableUI);
            } catch (
                    Exception ex
                    )

            {
            }

            // Tidak boleh mengubah/memanipulasi elemen UI
            // dari Thread yang bukan Thread UI
            //textAngka.setText(angka.toString());
        }


    };

    Runnable runnableUI = new Runnable() {
        @Override
        public void run() {
            Intent imgbt = new Intent(getActivity(), MainActivity.class);
            startActivity(imgbt);
        }
    };
    Runnable runnableBackground1 = new Runnable() {

        @Override
        public void run() {
            try {

                Thread.sleep(2500);
                // Kirimkan angka random ke Thread UI melalui handler
                // Runnable yan dijalankan di Thread UI adalah runnableUI
                handler.post(runnableUI1);
            } catch (
                    Exception ex
                    )

            {
            }

            // Tidak boleh mengubah/memanipulasi elemen UI
            // dari Thread yang bukan Thread UI
            //textAngka.setText(angka.toString());
        }


    };

    Runnable runnableUI1 = new Runnable() {
        @Override
        public void run() {
            Intent kephone = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(kephone, 0);
        }
    };
}
