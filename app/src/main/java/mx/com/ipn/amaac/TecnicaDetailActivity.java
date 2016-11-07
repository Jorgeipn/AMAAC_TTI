package mx.com.ipn.amaac;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v4.app.NavUtils;
        import android.support.v7.widget.Toolbar;
        import android.view.Menu;
        import android.view.View;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.app.ActionBar;
        import android.view.MenuItem;
        import android.widget.TextView;

/**
 * An activity representing a single Consejo detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link TecnicaListActivity}.
 */
public class TecnicaDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnica_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(TecnicaDetailFragment.ID_ARTICULO ,
                    getIntent().getStringExtra(TecnicaDetailFragment.ID_ARTICULO ));
            TecnicaDetailFragment fragment = new TecnicaDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.tecnica_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalle_articulo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this,new Intent(this, TecnicaListActivity.class));
            return true;
        }

        else if(id == R.id.acccion_favoritos) {


            TextView titulo = (TextView) findViewById(R.id.fecha);
            String link = titulo.getText().toString();

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
        }


            return super.onOptionsItemSelected(item);
    }
}
