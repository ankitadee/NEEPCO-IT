package com.example.neepco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class data extends AppCompatActivity {
        RecyclerView recyclerView;
    private final DatabaseReference db= FirebaseDatabase.getInstance().getReference();
    private List<NewUserdata> myItemsList = new ArrayList<>();
    ArrayList<NewUserdata> list;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        final RecyclerView recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize (true);

        recyclerView.setLayoutManager(new LinearLayoutManager(  data.this));
        myItemsList= new ArrayList<>();
        recyclerView.setAdapter(new MyAdapter(myItemsList, data.this));


        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

//                myItemsList.clear();
//                for(DataSnapshot UserData : snapshot.child("UserData").getChildren()){
//                    if(UserData.hasChild("mFeed") && UserData.hasChild("mIssue") && UserData.hasChild("mName") && UserData.hasChild("mPhone")){
//                        final String mFeed= UserData.child("mFeed").getValue(String.class);
//                        final String mIssue= UserData.child("mIssue").getValue(String.class);
//                        final String mName= UserData.child("mName").getValue(String.class);
//                        final String mPhone= UserData.child("mPhone").getValue(String.class);
//                        final String mDate= UserData.child("mDate").getValue(String.class);
//                        NewUserdata myItems= new NewUserdata(mFeed,mIssue,mName,mPhone,mDate);
//                        myItemsList.add(myItems);
//                    }
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    NewUserdata newUserdata=dataSnapshot.getValue(NewUserdata.class);
                    myItemsList.add(newUserdata);



                }


                //recyclerView.setAdapter(new MyAdapter(myItemsList,data.this));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}