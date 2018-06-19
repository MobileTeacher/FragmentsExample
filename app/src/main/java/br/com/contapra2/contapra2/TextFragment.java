package br.com.contapra2.contapra2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {


    private static final String TEXT_VALUE = "text_value";
    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);
        TextView textView = rootView.findViewById(R.id.center_text);
        if (getArguments() != null){
            textView.setText(getArguments().getString(TEXT_VALUE, "ERRO"));
        }
        return rootView;
    }

    public static TextFragment newInstance(String mainText) {
        Bundle args = new Bundle();
        TextFragment fragment = new TextFragment();
        args.putString(TEXT_VALUE, mainText);
        fragment.setArguments(args);
        Log.d("DEBUG", mainText);

        return fragment;
    }

}
