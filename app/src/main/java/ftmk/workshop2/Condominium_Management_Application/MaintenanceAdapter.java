package ftmk.workshop2.Condominium_Management_Application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MaintenanceAdapter extends ArrayAdapter<Maintenance> {
    Context context;
    List<Maintenance> arrayMaintenanceList;

    public MaintenanceAdapter(@NonNull Context context, List<Maintenance>maintenanceList) {
        super(context, R.layout.maintenance_item, maintenanceList);

        this.context = context;
        this.arrayMaintenanceList = maintenanceList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.maintenance_item,
                null, true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayMaintenanceList.get(position).getMaintenanceID());
        tvName.setText(arrayMaintenanceList.get(position).getFacilityName());

        return view;
    }
}
