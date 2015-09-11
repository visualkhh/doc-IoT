package exam.Network;

import android.content.*;

public class FreeBR extends BroadcastReceiver {
	public void onReceive(Context context, Intent intent) {
		Intent intent2 = new Intent(context, DownHtml.class);
		intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent2);
	}
}