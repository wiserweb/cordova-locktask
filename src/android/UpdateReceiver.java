package mrmcduff.cordova.plugin.locktask;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            System.out.println("Lock task application start after boot");
            Intent newIntent = new Intent(context, LockTaskActivity.class);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(newIntent);
        } else if(intent.getAction().equals("android.intent.action.MY_PACKAGE_REPLACED")){
            System.out.println("Lock task application restarting after upgrade");
            Intent newIntent = new Intent(context, LockTaskActivity.class);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(newIntent);
        }
    }
}
