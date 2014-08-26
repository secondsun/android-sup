package sup.aerogear.jboss.org.sup.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by summers on 8/26/14.
 */
public class AuthenticatationService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new AccountAuthenticator(this).getIBinder();
    }
}
