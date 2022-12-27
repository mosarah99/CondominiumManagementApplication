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

public class BookingAdapter extends ArrayAdapter<Booking> {
    Context context;
    List<Booking> arrayBookingList;

    public BookingAdapter(@NonNull Context context, List<Booking>bookingList) {
        super(context, R.layout.booking_item, bookingList);

        this.context = context;
        this.arrayBookingList = bookingList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item,
                null, true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvName = view.findViewById(R.id.txt_name);

        tvID.setText(arrayBookingList.get(position).getBookingID());
        tvName.setText(arrayBookingList.get(position).getFacilityName());

        return view;
    }
}
