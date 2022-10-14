package androidsamples.java.dicegames;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class WalletActivity extends AppCompatActivity {

  private Button mBtnDie;
  private Die mDie;
  private TextView mTxtCoins, mTxtPrevRoll, mTxtSixesRolled, mTxtTotalDiceRolls, mTxtDoubleSixes, mTxtOtherDoubles;
  private WalletViewModel mWalletVM;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wallet);

    mDie = new Die6();
    mWalletVM = new ViewModelProvider(this).get(WalletViewModel.class);

    mTxtCoins = findViewById(R.id.txt_coins);
    mTxtPrevRoll = findViewById(R.id.txt_prev_roll);
    mTxtSixesRolled = findViewById(R.id.txt_single_sixes);
    mTxtTotalDiceRolls = findViewById(R.id.txt_total_rolls);
    mTxtDoubleSixes = findViewById(R.id.txt_double_sixes);
    mTxtOtherDoubles = findViewById(R.id.txt_double_others);
    mBtnDie = findViewById(R.id.btn_die);


    updateUI();


    mBtnDie.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mWalletVM.rollDie();
        updateUI();
        if (mWalletVM.dieValue()==6) Toast.makeText(getApplicationContext(), getResources().getString(R.string.Congratulations), Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void updateUI() {
    mTxtCoins.setText(getResources().getString(R.string.coinsText)+" "+Integer.toString(mWalletVM.balance()));
    mTxtPrevRoll.setText(getResources().getString(R.string.previousRollText)+" "+Integer.toString(mWalletVM.previousRoll()));
    mTxtSixesRolled.setText(getResources().getString(R.string.sixesRolledText)+" "+Integer.toString(mWalletVM.singleSixes()));
    mTxtTotalDiceRolls.setText(getResources().getString(R.string.totalDiceRollsText)+" "+Integer.toString(mWalletVM.totalRolls()));
    mTxtDoubleSixes.setText(getResources().getString(R.string.doubleSixesText)+" "+Integer.toString(mWalletVM.doubleSixes()));
    mTxtOtherDoubles.setText(getResources().getString(R.string.doubleOthersText)+" "+Integer.toString(mWalletVM.doubleOthers()));
    mBtnDie.setText(Integer.toString(mWalletVM.dieValue()));
  }

}