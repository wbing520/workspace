package cs.androidfun.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

	public static final String EXTRA_ANSWER_IS_TRUE = "cs.android.geoquizcheat.answer_is_true";
	private static final String EXTRA_ANSWER_IS_TURE = null;
	public static final String EXTRA_ANSWER_SHOWN="cs.androidfun.geoquiz.answer_shown";
	private boolean mAnswerIsTrue;
	
	private TextView mAnswerTextView;
	private Button mShowAnswer;
	
	private void setAnswerShownResult(boolean isAnswerShown){
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TURE, false);
		
		mAnswerTextView =(TextView)findViewById(R.id.answerTextView);
		mShowAnswer=(Button)findViewById(R.id.showAnswerButton);
		setAnswerShownResult(false);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mAnswerIsTrue){
					mAnswerTextView.setText(R.string.true_button);
				}else{
					mAnswerTextView.setText(R.string.false_button);
				}
				setAnswerShownResult(true);
			}
		});
	}
	}
