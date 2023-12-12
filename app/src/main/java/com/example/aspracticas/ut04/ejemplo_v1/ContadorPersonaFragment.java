package com.example.aspracticas.ut04.ejemplo_v1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aspracticas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContadorPersonaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContadorPersonaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContadorPersonaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContadorPersonaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContadorPersonaFragment newInstance(String param1, String param2) {
        ContadorPersonaFragment fragment = new ContadorPersonaFragment();
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

    private View rootView;
    TextView suma, resta, tipo;
    int totalP = 0;
    String tipoPersona;

    private static final String PERSONAS_UNO = ".";
    private static final String PERSONAS_CINCO = "O";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView == null) {
            // Inflate the layout for this fragment
            rootView = inflater.inflate(R.layout.u4_ejemplo_v1_contador_persona_fragment, container, false);
        }
        suma = rootView.findViewById(R.id.u4_ejemplo_v1_tVIew_sumar_fragment);
        resta = rootView.findViewById(R.id.u4_ejemplo_v1_tVIew_restar_fragment);
        tipo = rootView.findViewById(R.id.u4_ejemplo_v1_tVIew_tipo_fragment);
        if (observer != null) {
            setTipo(observer.setTipo(), tipo);
        }

        suma.setOnClickListener(v -> {
            if (observer != null) {
                totalP++;
                observer.setNumero(1);
                tipo.setText(tipoPersona + "\n" + mostarPersonas());
            }
        });
        resta.setOnClickListener(v -> {
            if (observer != null && totalP > 0) {
                totalP--;
                observer.setNumero(-1);
                mostarPersonas();
                tipo.setText(tipoPersona + "\n" + mostarPersonas());
            }
        });

        return rootView;
    }

    private Observer observer;

    public void setObserver(com.example.aspracticas.ut04.ejemplo_v1.Observer obs) {
        this.observer = obs;
    }

    public void setTipo(String t, TextView tip) {
        tip.setText(t);
        tipoPersona = t;
    }

    public String mostarPersonas() {
        StringBuilder personas = new StringBuilder();
        for (int i = totalP / 5; i > 0; i--) {
            personas.append(PERSONAS_CINCO);
        }
        for (int i = totalP % 5; i > 0; i--) {
            personas.append(PERSONAS_UNO);

        }
        return personas.toString();
    }


}