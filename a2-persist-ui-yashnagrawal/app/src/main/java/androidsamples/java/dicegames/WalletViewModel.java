package androidsamples.java.dicegames;

import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {
  private static final String TAG = "WallerViewModel";
  private static final int WIN_VALUE = 6;
  private static final int INCREMENT = 5;

  private int mBalance;
  public Die mDie;

  private int mTotalRolls;
  private int mSingleSixes;
  private int mDoubleSixes;
  private int mPreviousRoll;
  private int mDoubleOthers;
  private int temp;



  /**
   * The no argument constructor.
   */
  public WalletViewModel() {
    mBalance=0;
    mTotalRolls=0;
    mSingleSixes=0;
    mDoubleSixes=0;
    mDoubleOthers=0;
    mPreviousRoll=0;
    temp=0;
    mDie = new Die6();
  }

  /**
   * Reports the current balance.
   *
   */
  public int balance() {
    return mBalance;
  }

  public void setBalance(int balance){
    mBalance=balance;
  }

  /**
   * Rolls the {@link Die} in the wallet and implements the changes accordingly.
   */
  public void rollDie() {
    mPreviousRoll=temp;
    mDie.roll();
    mTotalRolls++;
//    Log.d(TAG, "die = "+mDie.value());
    if (mDie.value() == WIN_VALUE) {
      mBalance += INCREMENT;
      mSingleSixes++;
//      Log.d(TAG, "new balance = " + mBalance);
      if (mDie.value()==mPreviousRoll) {
        mDoubleSixes++;
        mBalance+=5;
      }
    }
    else if (mDie.value()==mPreviousRoll) {
      mDoubleOthers++;
      mBalance-=5;
    }
    temp=mDie.value();
  }

  /**
   * Reports the current value of the {@link Die}.
   *
   */
  public int dieValue() {
    // TODO implement method
    return mDie.value();
  }

  /**
   * Reports the number of single (or first) sixes rolled so far.
   *
   */
  public int singleSixes() {
    // TODO implement method
    return mSingleSixes;
  }

  /**
   * Reports the total number of dice rolls so far.
   *
   */
  public int totalRolls() {
    // TODO implement method
    return mTotalRolls;
  }

  /**
   * Reports the number of times two sixes were rolled in a row.
   *
   */
  public int doubleSixes() {
    // TODO implement method
    return mDoubleSixes;
  }

  /**
   * Reports the number of times any other number was rolled twice in a row.
   *
   */

  public int doubleOthers() {
    // TODO implement method
    return mDoubleOthers;
  }

  /**
   * Reports the value of the die on the previous roll.
   *
   */
  public int previousRoll() {
    // TODO implement method
    return mPreviousRoll;
  }

}
