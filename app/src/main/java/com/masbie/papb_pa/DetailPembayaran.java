package com.masbie.papb_pa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link History.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link History#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailPembayaran extends AppCompatActivity {

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

    String[] deswhislist = new String[]{
            "Anang Hanafi",
            "Satria Habiburrahman",
            "Firda Priatmayanti",
    };
    String[] desdetail = new String[]{
            "150.000 ",
            "125.000 ",
            "130.000 ",
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_pembayaran);

        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 3; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put("titlewhislist", titlewhislist[i]);
            hm.put("deswhislist", deswhislist[i]);
            hm.put("imagekiri", Integer.toString(imagekiri[i]));
            hm.put("desdetail", desdetail[i]);
            list.add(hm);
        }
        String[] dari = {"imagekiri", "titlewhislist", "deswhislist", "desdetail"};
        int[] ke = {R.id.imagekiri, R.id.titlewhislist, R.id.deswhislist, R.id.desdetailsekali};
        SimpleAdapter simpleAdapter = new SimpleAdapter(DetailPembayaran.this, list, R.layout.listview_detail_pembayaran, dari, ke);
        ListView listView = (ListView) findViewById(R.id.list_view_detail);
        listView.setAdapter(simpleAdapter);


    }




}
