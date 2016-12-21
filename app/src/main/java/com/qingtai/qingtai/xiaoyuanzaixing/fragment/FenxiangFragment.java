package com.qingtai.qingtai.xiaoyuanzaixing.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qingtai.qingtai.xiaoyuanzaixing.R;
import com.qingtai.qingtai.xiaoyuanzaixing.SharePageActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FenxiangFragment extends Fragment {


    public FenxiangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_fenxiang, container, false);

        Button btnGotoShare = (Button) view.findViewById(R.id.btn_test_goto_share_page);
        btnGotoShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FenxiangFragment.this.getContext(), SharePageActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
