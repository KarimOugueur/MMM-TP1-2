package com.istic.mmm.tp1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.appcompat.app.AppCompatActivity;
import com.istic.mmm.tp1.databinding.FragmentFirstBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ShareInfoVM clientData;
    private Button mButton;
    private EditText mEdit;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        setHasOptionsMenu(true);
       // binding = FragmentFirstBinding.inflate(inflater, container, false);

        // DataBinding
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // MC: once the view is created, we can initialize the data (here in First Fragment)
        clientData = new ViewModelProvider(requireActivity()).get(ShareInfoVM.class);

        // and set a value to it. De note that as soon as setdata is called,
        // all the interfaces connected to the Viewmodel are notified.
        // So if there's no other fragment, then nothing happens,
        // but if the Fragment2 is displayed at the same time (eg on a tablet), then
        // the second fragment is updated!
        clientData.setdata(new Client(32,"Toto","12/12/2020"));


        Button valid = (Button) view.findViewById(R.id.valid);
        valid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText firstname = view.getRootView().findViewById(R.id.name);
                String name = firstname.getText().toString();

                EditText lastname = view.getRootView().findViewById(R.id.lastname);
                String last = lastname.getText().toString();

                EditText city = view.getRootView().findViewById(R.id.city);
                String c = city.getText().toString();

                Toast.makeText(getActivity().getApplicationContext(), name, Toast.LENGTH_SHORT ).show();
            //    Toast.makeText(getActivity().getApplicationContext(), last , Toast.LENGTH_SHORT ).show();
            //    Toast.makeText(getActivity().getApplicationContext(), c , Toast.LENGTH_SHORT ).show();
            }
        });

    }
    @Override
    public void onCreateOptionsMenu(Menu menu , MenuInflater menuInflater){

        menuInflater.inflate(R.menu.menu_tp1, menu);
        menuInflater.inflate(R.menu.phone_number, menu);
        menuInflater.inflate(R.menu.cityofbirth, menu);

        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.reset) {

            ((EditText) getView().getRootView().findViewById(R.id.name)).setText("");
            ((EditText) getView().getRootView().findViewById(R.id.lastname)).setText("");
            ((EditText) getView().getRootView().findViewById(R.id.city)).setText("");

            return true;
        }

        if (id == R.id.phone_number) {

            ((EditText) getView().getRootView().findViewById(R.id.phone)).setVisibility(1);

            return true;
        }

        if(id==R.id.cityofBirth){
            // Spinner element
            Spinner spinner = (Spinner) getView().getRootView().findViewById(R.id.spinnerCountry);
            String spi = spinner.getSelectedItem().toString();
            String url = "https://www."+spi+".fr";

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}