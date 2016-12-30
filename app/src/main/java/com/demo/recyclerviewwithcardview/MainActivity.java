package com.demo.recyclerviewwithcardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";
    ArrayList results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        results = new ArrayList<DataObject>();

        setArraylist();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(results);
        mRecyclerView.setAdapter(mAdapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.margin_cardview);
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

    }

    // Set Arraylist
    private void setArraylist(){
        results.add(0, new DataObject("Cupcake",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(1, new DataObject("Donut",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(2, new DataObject("Eclair",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(3, new DataObject("Froyo",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(4, new DataObject("Gingerbread",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(5, new DataObject("Honeycomb",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(6, new DataObject("Ice Cream Sandwich",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(7, new DataObject("Jelly Bean",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(8, new DataObject("KitKat",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(9, new DataObject("Lollipop",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(10, new DataObject("Marshmallow",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
        results.add(11, new DataObject("Nougat",
                "The RecyclerView widget is a more advanced and flexible version of ListView."));
    }

    // Adapter
    public class MyRecyclerViewAdapter extends RecyclerView
            .Adapter<MyRecyclerViewAdapter
            .DataObjectHolder> {
        private String LOG_TAG = "MyRecyclerViewAdapter";
        private ArrayList<DataObject> mDataset;

        public class DataObjectHolder extends RecyclerView.ViewHolder
                implements View
                .OnClickListener {
            TextView heading;
            TextView description;

            public DataObjectHolder(View itemView) {
                super(itemView);
                heading = (TextView) itemView.findViewById(R.id.textView);
                description = (TextView) itemView.findViewById(R.id.textView2);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                String headingtxt = heading.getText().toString();
                Toast.makeText(getApplicationContext(), pos + " - " + headingtxt, Toast.LENGTH_SHORT).show();
            }
        }

        public MyRecyclerViewAdapter(ArrayList<DataObject> myDataset) {
            mDataset = myDataset;
        }

        @Override
        public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);

            DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
            return dataObjectHolder;
        }

        @Override
        public void onBindViewHolder(DataObjectHolder holder, int position) {
            holder.heading.setText(mDataset.get(position).getHeading());
            holder.description.setText(mDataset.get(position).getDescription());
        }

        public void addItem(DataObject dataObj, int index) {
            mDataset.add(dataObj);
            notifyItemInserted(index);
        }

        public void deleteItem(int index) {
            mDataset.remove(index);
            notifyItemRemoved(index);
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

    }
}
