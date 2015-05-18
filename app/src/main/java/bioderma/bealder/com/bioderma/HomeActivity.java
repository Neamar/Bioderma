package bioderma.bealder.com.bioderma;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import bioderma.bealder.com.bioderma.util.SystemUiHider;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class HomeActivity extends Activity {
    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
    }

    public void openWebview(String title, String url, Boolean enableZoom) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        intent.putExtra("enableZoom", enableZoom);

        startActivity(intent);
    }

    public void tryOpen(String packageName, String fallbackUrl) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(fallbackUrl));
            startActivity(myIntent);
        }
    }

    public void openProgram(View view) {
        openWebview("Program", "http://bioderma.yurplan.com/agenda.php", false);
    }

    public void openWhosWho(View view) {
        openWebview("Who's who", "http://bioderma.yurplan.com/atendees.php", false);
    }

    public void openWheretogo(View view) {
        openWebview("Where to go", "https://img.bealder.com/img/313701-plan_hotel.png", true);
    }

    public void openInstagram(View view) {
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/explore/tags/IAMAJACCIO2015/"));
        startActivity(myIntent);
    }

    public void openQrCode(View view) {
        tryOpen("la.droid.qr", "https://play.google.com/store/apps/details?id=la.droid.qr");
    }
}
