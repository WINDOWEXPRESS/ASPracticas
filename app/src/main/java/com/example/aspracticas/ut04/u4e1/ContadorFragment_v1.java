package com.example.aspracticas.ut04.u4e1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.aspracticas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContadorFragment_v1#newInstance} factory method to
 * create an instance of this fragment.
 */

/*
*
* Pasar datos de activity a fragment
*
*/
public class ContadorFragment_v1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContadorFragment_v1() {
        // Required empty public constructor
    }

    private Observer observer;

    public void setObserver(Observer obs) {
        this.observer = obs;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContadorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContadorFragment_v1 newInstance(String param1, String param2) {
        ContadorFragment_v1 fragment = new ContadorFragment_v1();
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

    private TextView texto;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.u4a1_fragment_contador, container, false);
        }
        texto = rootView.findViewById(R.id.u4a1_tView_fragment);
        texto.setOnClickListener(v -> {
            //El uso de interfaz
           /* if (observer != null) {
                String textoFromActivity = observer.getMsgToActivity("null");
                texto.setText(textoFromActivity);
                Toast.makeText(ContadorFragment_v1.this.getContext(), "Exito", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(ContadorFragment_v1.this.getContext(), "Fracaso", Toast.LENGTH_LONG).show();
            }*/
            Bundle manipulador = getArguments();
            String datoRecibido = manipulador.getString("DATA");
            texto.setText(datoRecibido);
        });
        return rootView;
    }


}