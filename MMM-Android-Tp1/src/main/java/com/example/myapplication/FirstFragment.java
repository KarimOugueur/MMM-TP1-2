package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private Button   mButton;
    private EditText mEdit;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button valid = (Button) view.findViewById(R.id.valid);

        valid.setOnClickListener(new View.OnClickListener() {

            @Override
           public void onClick(View view) {

            //    EditText firstname = view.findViewById (R.id.firstname);
           //     String name = firstname.getText().toString();

                EditText lastname = view.findViewById (R.id.lastname);
                String last = lastname.getText().toString();

                EditText city = view.findViewById (R.id.city);
                String c = city.getText().toString();

                EditText birthday = view.findViewById (R.id.birthday);
                String b = birthday.getText().toString();

         //     Toast.makeText(getActivity().getApplicationContext(), name, Toast.LENGTH_SHORT ).show();
                Toast.makeText(getActivity().getApplicationContext(), last , Toast.LENGTH_SHORT ).show();
                Toast.makeText(getActivity().getApplicationContext(), b, Toast.LENGTH_SHORT ).show();
                Toast.makeText(getActivity().getApplicationContext(), c , Toast.LENGTH_SHORT ).show();
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}