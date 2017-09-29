package com.example.pc_brestby.quizactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    public static final String EXTRA_ANSWER_IS_TRUE="com.example.pc_brestby.quizactivity.answer_is_true";
    public static final String EXTRA_ANSWER_SHOW="com.example.pc_brestby.quizactivity.answer_shown";

    private boolean mAnswerIsTrue;
    private TextView mAnswerTextViev;
    private Button mShowAnswer;

    public static Intent newIntent(Context packageContext,boolean answerIsTrue){

        Intent i = new Intent(packageContext,CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE,answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShown(Intent result){

        return result.getBooleanExtra(EXTRA_ANSWER_SHOW,false);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextViev = (TextView)findViewById(R.id.answer_text_viev);

        mShowAnswer = (Button)findViewById(R.id.show_answer_button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue){
                    mAnswerTextViev.setText(R.string.true_button);
                }
                else {
                    mAnswerTextViev.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
    }
    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW,isAnswerShown);
        setResult(RESULT_OK,data);
    }
}
