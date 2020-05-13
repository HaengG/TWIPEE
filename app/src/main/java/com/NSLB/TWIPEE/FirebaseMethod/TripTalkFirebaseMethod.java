package com.NSLB.TWIPEE.FirebaseMethod;

import androidx.annotation.NonNull;

import com.NSLB.TWIPEE.TripTalkView.Board.Board_Model.DataModelBoard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TripTalkFirebaseMethod {
    private static TripTalkFirebaseMethod singleton = new TripTalkFirebaseMethod();
    private DatabaseReference mDatabaseReference = null;
    private FirebaseDatabase mFirebaseDatabase = null;
    public ArrayList<DataModelBoard> BoardData = new  ArrayList<DataModelBoard>();
    public boolean gettingSignal = false;
    public ArrayList<DataModelBoard> CheckList = new  ArrayList<DataModelBoard>();
    public ArrayList<DataModelBoard> FirebaseCheckList = new  ArrayList<DataModelBoard>();
    HashSet<DataModelBoard> Array1;
    public ArrayList<DataModelBoard> BoardArray;

    private TripTalkFirebaseMethod() {
    }

    public static TripTalkFirebaseMethod getInstance()
    {
        return singleton;
    }

    public void DatabaseAccess()
    {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference();
    }

    public ArrayList<DataModelBoard>getBoardData()
    {
        DatabaseAccess();
        mDatabaseReference = mFirebaseDatabase.getReference().child("TRIP_TALK_BOARD");
        BoardData.clear();

        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    DataModelBoard BoardStorage = snapshot.getValue(DataModelBoard.class);
                    BoardData.add(BoardStorage);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return BoardData;
    }

    public ArrayList<DataModelBoard> getNewData()
    {
        DatabaseAccess();
        mDatabaseReference = mFirebaseDatabase.getReference().child("TRIP_TALK_BOARD");
        //BoardData.clear();

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    DataModelBoard BoardStorage = snapshot.getValue(DataModelBoard.class);
                    CheckList.add(BoardStorage);
                    for(int index = 0; index <= BoardData.size(); index++) {
                        if (!BoardData.contains(BoardStorage)) {
                            gettingSignal = true;
                        }
                        else
                        {
                            int a;
                            a=0;
                        }
                        if((index-1 == BoardData.size())&&(gettingSignal == false))
                        {
                            BoardData.add(BoardStorage);
                        }
                        if(gettingSignal == true)
                        {
                            break;
                        }

                    }


                        /*if(FirebaseCheckList.contains(CheckList)) {
                            gettingSignal = true;
                        }
                        else {
                            gettingSignal = false;
                        }
                        if(gettingSignal == false) {
                            gettingSignal = true;
                            BoardData.add(BoardStorage);
                            break;
                        }
                        FirebaseCheckList.clear();
                        CheckList.clear();*/

                }

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return BoardData;
    }

    public boolean DataPush(DataModelBoard BoardInputData)
    {
        DatabaseAccess();
        String Boardkey = mDatabaseReference.child("TRIP_TALK_BOARD").push().getKey();
        Map<String, Object> postValues = BoardInputData.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/TRIP_TALK_BOARD/"+Boardkey,postValues);
        mDatabaseReference.updateChildren(childUpdates);

        return true;
    }
}
