package cs.androidfun.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private static final String TAG = "QuizActivity";
	
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	
	private TrueFalse[] mQuestionBank = new TrueFalse[]{
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_asia,true),
			new TrueFalse(R.string.question_place,false),
	};
	
	private int mCurrentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);
        
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);
        
        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), R.string.true_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(true);
			}
		});
        
        mFalseButton =(Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), R.string.false_toast, Toast.LENGTH_SHORT).show();
				checkAnswer(false);
			}
		});
        
        mNextButton=(Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentIndex =(mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});
        
        updateQuestion();
    }
    
  
    private void updateQuestion(){
    	int question = mQuestionBank[mCurrentIndex].getQuestion();
    	mQuestionTextView.setText(question);
    }
    
    private void checkAnswer(boolean userPressedTrue){
    	boolean answerIsTrue= mQuestionBank[mCurrentIndex].isTrueQuestion();
    	
    	int messageResId= 0;
    	if(userPressedTrue == answerIsTrue){
    		messageResId = R.string.true_toast;    		
    	}else{
    		messageResId = R.string.false_toast;
    	}
    	
    	Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart(){
    	super.onStart();
    	Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause(){
    	super.onPause();
    	Log.d(TAG, "onPause() called");
    }
    @Override
    public void onResume(){
    	super.onStart();
    	Log.d(TAG, "onResume() called");
    }
    @Override
    public void onStop(){
    	super.onStop();
    	Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	Log.d(TAG, "onDestroy() called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }
    
}
