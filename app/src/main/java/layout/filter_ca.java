package layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.api.hrd.nhamey.R;

public class filter_ca extends Fragment {
    private Spinner filter;
    private String[] stringsFilter;
    private ArrayAdapter<String> arrayAdapter;
    private View v;
    public filter_ca() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_filter_ca, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        filter = (Spinner) getActivity().findViewById(R.id.spinner_filter);
        stringsFilter = getResources().getStringArray(R.array.number_array);
        setFilter(stringsFilter);
    }

    public void setFilter(String[] data){
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, data);
        filter.setAdapter(arrayAdapter);
    }
}
