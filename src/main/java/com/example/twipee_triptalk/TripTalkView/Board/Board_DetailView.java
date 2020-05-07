package com.example.twipee_triptalk.TripTalkView.Board;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.twipee_triptalk.Chat.ChatActivity;
import com.example.twipee_triptalk.Chat.ChatAdapter;
import com.example.twipee_triptalk.Chat.ChatData;
import com.example.twipee_triptalk.R;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Model.DataModelBoard;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Model.DataModelComment;
import com.example.twipee_triptalk.TripTalkView.Board.Board_Model.DataModelLike;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class Board_DetailView extends AppCompatActivity implements View.OnClickListener {

    private DataModelBoard board;
    private DataModelComment comment;
    private DataModelLike like;
    private TextView post_title, post_user, post_content;
    private Button mCommentButton;
    private RecyclerView mCommentsRecycler;
    public RecyclerView.LayoutManager mLayoutManager;

    //private CommentAdapter mAdapter;
    private EditText mUserid;
    private EditText mCommentField;
    public static List<DataModelComment> mComment = new ArrayList<>();


    public RecyclerView.Adapter mAdapter;
    private TextView mAuthorView;
    private TextView mTitleView;
    private TextView mBodyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board__detail_view);
        setComp();
        getPostDetail();
        setPost();

    }



    @Override
    public void onStart() {

        super.onStart();

        CommentAdapter();
      //  DataModelBoard post = new DataModelBoard();

       // mAuthorView.setText(post.user_id);
       // mTitleView.setText(post.board_type);
       // mBodyView.setText(post.location);


        //mAdapter = new CommentAdapter(this);
        //mCommentsRecycler.setAdapter(mAdapter);
    }


    private void setComp() {

        //post_title = findViewById(R.id.posts_title);
       // post_content = findViewById(R.id.posts_contents);

        mAuthorView = findViewById(R.id.boardAuthor);
        mTitleView = findViewById(R.id.postTitle);
        mBodyView = findViewById(R.id.postBody);


        mCommentField= findViewById(R.id.fieldCommentText);
        mCommentButton = findViewById(R.id.buttonPostComment);

        mCommentsRecycler = findViewById(R.id.recyclerPostComments);
        mCommentsRecycler.setHasFixedSize(true);


        mCommentButton.setOnClickListener(this);
        mCommentsRecycler.setLayoutManager(new LinearLayoutManager(this));

        mLayoutManager = new LinearLayoutManager(this);
        mCommentsRecycler.setLayoutManager(mLayoutManager);


    }

    @Override
    public void onStop() {

        super.onStop();
        // 이전에 나타난 view 제거하는 clean 필요한데 시붕
    }


    private void getPostDetail() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bld = intent.getExtras();

            Object obj = bld.get("board");
            if (obj != null && obj instanceof DataModelBoard) {
                this.board = (DataModelBoard) obj;
            }
        }
    }

    private void setPost() {

        if (this.board != null) {
           // String title = this.board.getUser_id();
          //  if (title != null) {
           //     mAuthorView.setText(title);
           // }
           // String content = this.board.getBoard_type();
           // if (content != null)
           //     mBodyView.setText(content);
        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.buttonPostComment) {
            postComment();
        }

    }

    private void postComment()
    {

        String commentText = mCommentField.getText().toString();
        DataModelComment comment = new DataModelComment();
        comment.setComment(commentText);

        String authorName = "미정"; //로그인 부분을 만들지 않아서 Userid가 아직 따로 없음. (임시)
        comment.setUser_id(authorName);

        mCommentField.setText(null);


    }

    public void CommentAdapter(){

        mAdapter = new Comment_Adapter(mComment, this);
        mCommentsRecycler.setAdapter(mAdapter);

    }


//    private static class CommentViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView authorView;
//        public TextView bodyView;
//
//
//        public CommentViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            authorView = itemView.findViewById(R.id.commentAuthor);
//            bodyView = itemView.findViewById(R.id.commentBody);
//
//        }
//    }
//
//    private static class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder>{
//
//        private Context mContext;
//
//        private List<DataModelComment> mComments = new ArrayList<>();
//
//        public CommentAdapter(final Context context)
//        {
//            mContext = context;
//
//        }
//
//
//        @Override
//        public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            LayoutInflater inflater = LayoutInflater.from(mContext);
//            View view = inflater.inflate(R.layout.board_comment, parent, false);
//            return new CommentViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
//            DataModelComment comment = mComments.get(position);
//
//            holder.authorView.setText(comment.user_id);
//          //  holder.authorView.setText("시발련아");
//            holder.bodyView.setText(comment.comment);
//        }
//
//        @Override
//        public int getItemCount() {
//
//            return mComments.size();
//        }
//
//
//    }

}