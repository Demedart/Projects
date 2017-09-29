package com.example.pc_brestby.quizactivity;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFolseButton;
    private Button mNextButton;
    private Button mReturn;
    private Button mCheatButton;
    private TextView mQuestionTextViev;

    public static final String TAG = "QuizActivity";
    public static final String KEY_INDEX = "index";
    public static final String KEY = "index_1";
    public static final int REQUEST_CODE_CHEAT=0;

    private int mCurrentIndex = 0;
    private boolean mIsCheater;




             private Question[] mQuestionBank = new Question[]{
             new Question(R.string.question_oceans, true),
             new Question(R.string.question_mideast, false),
             new Question(R.string.question_africa, false),
             new Question(R.string.question_americas, true),
              new Question(R.string.question_asia, true),
                 };



    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
         mQuestionTextViev.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
         int messageResId = 0;
        if (mIsCheater){
            messageResId = R.string.judgment_toast;
        }
        else {
            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }
             Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
         }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle)called");
        setContentView(R.layout.activity_quiz);



     mQuestionTextViev=(TextView) findViewById(R.id.question_text_viev);
        mQuestionTextViev.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view){
        mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
            mIsCheater=false;
        updateQuestion();
    }});

        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent i = CheatActivity.newIntent(QuizActivity.this,answerIsTrue);
                startActivityForResult(i,REQUEST_CODE_CHEAT);
            }
        });

    mTrueButton=(Button) findViewById(R.id.true_button);
    mTrueButton.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view){
        checkAnswer(true);
    }});

        mFolseButton=(Button) findViewById(R.id.false_button);
             mFolseButton.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view){
        checkAnswer(false);
    }});

    mReturn=(Button) findViewById(R.id.returnn);
        mReturn.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View view){
        mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
        updateQuestion();
    }});


     mNextButton = (Button)findViewById(R.id.next_button);
      mNextButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
             updateQuestion();
          }
      });


        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);

            }
        updateQuestion();
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode==REQUEST_CODE_CHEAT){
            if (data==null){
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }
}