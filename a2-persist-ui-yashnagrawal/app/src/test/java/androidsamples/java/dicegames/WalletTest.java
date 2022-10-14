package androidsamples.java.dicegames;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WalletTest {
  @Test
  public void addition_isCorrect() {
    assertEquals  (4, 2 + 2);
  }

  @Test
  public void singleSix_increases_balance_by_5() {
    WalletViewModel wvm= new WalletViewModel();
    Die6 d = mock(Die6.class);
    wvm.mDie=d;


    when(d.value()).thenReturn(6);
    wvm.rollDie();
    assertThat(wvm.balance(), is(5));
  }

  @Test
  public void doubleSix_increases_balance_by_10(){
    WalletViewModel wvm= new WalletViewModel();
    Die6 d = mock(Die6.class);
    wvm.mDie=d;
    when(d.value()).thenReturn(6);
    wvm.rollDie();
    wvm.rollDie();
    assertThat(wvm.balance(), is(15));
  }
  @Test
  public void DoubleOne_decreases_balance_by_5(){
    WalletViewModel wvm= new WalletViewModel();
    Die6 d = mock(Die6.class);
    wvm.mDie=d;
    when(d.value()).thenReturn(1);
    wvm.rollDie();
    wvm.rollDie();
    assertThat(wvm.balance(), is(-5));
  }

  @Test
  public void single_one_does_not_change_balance(){
    WalletViewModel wvm = new WalletViewModel();
    Die6 d = mock(Die6.class);
    wvm.mDie=d;
    when(d.value()).thenReturn(1);
    wvm.rollDie();
    assertThat(wvm.balance(), is(0));
  }

  @Test
  public void one_followed_by_two_updates_Previous_Roll_to_one(){
    WalletViewModel wvm= new WalletViewModel();
    Die6 d = mock(Die6.class);
    wvm.mDie=d;
    when(d.value()).thenReturn(1);
    wvm.rollDie();
    when(d.value()).thenReturn(2);
    wvm.rollDie();
    assertThat(wvm.previousRoll(), is(1));
  }

}