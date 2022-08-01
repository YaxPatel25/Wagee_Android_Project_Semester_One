package com.example.wagee_android_project_semester_one;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wagee_android_project_semester_one.placeholder.Employee_Name;
import com.example.wagee_android_project_semester_one.placeholder.Employee_Name.EmployeeName;
import com.example.wagee_android_project_semester_one.databinding.FragmentItemBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EmployeeName}.
 * TODO: Replace the implementation with code for your data type.
 */
public class EmployeeNameListRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeNameListRecyclerViewAdapter.ViewHolder> {

    private final List<EmployeeName> mValues;

    public EmployeeNameListRecyclerViewAdapter(List<EmployeeName> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
      /*  holder.mIdView.setText(mValues.get(position).id);*/
        holder.mContentView.setText(mValues.get(position).content);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       /* public final TextView mIdView;*/
        public final TextView mContentView;
        public EmployeeName mItem;


        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());
          /*  mIdView = binding.itemNumber;*/
            mContentView = binding.content;


            itemView.findViewById(R.id.content).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("demo", "onClick:empl  "+Employee_Name.tag);
                    Intent i = new Intent(view.getContext(),Payment.class);
                    i.putExtra("Amount",mContentView.getText());
                    view.getContext().startActivity(i);
                }
            });
        }



        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}