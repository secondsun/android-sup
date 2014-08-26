package sup.aerogear.jboss.org.sup;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;

import sup.aerogear.jboss.org.sup.util.Constants;

/**
 * Created by summers on 8/26/14.
 */
public class StartupActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        AccountManager am = AccountManager.get(this);
        Account[] accounts = am.getAccountsByType(Constants.SUP_ACCOUNT_TYPE);

        if (accounts.length == 0) {
            am.addAccount(Constants.SUP_ACCOUNT_TYPE, null, null, null, this, null, null);
        }
    }
}
