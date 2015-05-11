package bioderma.bealder.com.bioderma;

import android.app.Activity;
import android.content.Intent;
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

    public void openWebview(String title, String url) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);

        startActivity(intent);
    }

    public void openProgram(View view) {
        openWebview("Program", "https://google.fr");
    }

    public void openWhosWho(View view) {
        openWebview("Who's who", "https://google.fr");
    }

    public void openWheretogo(View view) {
        openWebview("Where to go", "https://google.fr");
    }
}
