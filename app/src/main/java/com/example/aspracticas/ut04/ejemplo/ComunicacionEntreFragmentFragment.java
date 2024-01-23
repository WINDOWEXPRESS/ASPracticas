package com.example.aspracticas.ut04.ejemplo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aspracticas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ComunicacionEntreFragmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ComunicacionEntreFragmentFragment extends Fragment {
    private static final double COLOR_RANGE = 256;
    TextView textView;


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ComunicacionEntreFragmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ComunicacionEntreFragmentFragment.
     */

    public static ComunicacionEntreFragmentFragment newInstance(String param1, String param2) {
        ComunicacionEntreFragmentFragment fragment = new ComunicacionEntreFragmentFragment();
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
        View layout =  inflater.inflate(R.layout.u4e_fragment_comunicacion_entre_fragment, container, false);

        textView = layout.findViewById(R.id.u4ejemplo_tView_fragment);


        textView.setOnClickListener((v) -> {
            int r ,g,b;
            r = (int) (Math.random() * COLOR_RANGE);
            g = (int) (Math.random() * COLOR_RANGE);
            b = (int) (Math.random() * COLOR_RANGE);
            int c = Color.argb(
                    (int) (Math.random() * COLOR_RANGE),
                    r,
                    g,
                    b
            );
            textView.setBackgroundColor(c);
            textView.setText(String.format("R : %d , G : %d , B : %d",r,g,b));

            if(getId() == R.id.u4_ejemplo_fCView_colo1){
                ComunicacionEntreFragmentFragment cf = (ComunicacionEntreFragmentFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.u4_ejemplo_fCView_colo2);
                cf.setTextColor(textView.getText().toString()+"  :  "+cf.getId());
            }else{
                ComunicacionEntreFragmentFragment cf = (ComunicacionEntreFragmentFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.u4_ejemplo_fCView_colo1);
                cf.setTextColor(textView.getText().toString()+"  :  "+cf.getId());
            }

        });

        return layout;
    }
    public void setTextColor(String t){
        textView.append("\n"+t);
    }
}