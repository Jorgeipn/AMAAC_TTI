package mx.com.ipn.amaac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import mx.com.ipn.amaac.dummy.GuiaPadreContent;

import java.util.List;

/**
 * An activity representing a list of guias_padre. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link guiapadreDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class guiapadreListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guiapadre_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        View recyclerView = findViewById(R.id.guiapadre_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.guiapadre_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(GuiaPadreContent.ITEMS));
    }





    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<GuiaPadreContent.GuiaPadre> mValues;

        public SimpleItemRecyclerViewAdapter(List<GuiaPadreContent.GuiaPadre> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.guiapadre_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            // holder.mIdView.setText(mValues.get(position).id);
            holder.mTituloView.setText(mValues.get(position).titulo);
            holder.mResumenView.setText(mValues.get(position).descripcion);
            holder.mFechaView.setText(mValues.get(position).fecha);
            holder.mImageView.setImageResource(mValues.get(position).idImagen);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(guiapadreDetailFragment.ID_ARTICULO, holder.mItem.id);
                        guiapadreDetailFragment fragment = new guiapadreDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.guiapadre_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, guiapadreDetailActivity.class);
                        intent.putExtra(guiapadreDetailFragment.ID_ARTICULO, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            // public final TextView mIdView;
            public final TextView mTituloView;
            public final TextView mResumenView;
            public final TextView mFechaView;
            public final ImageView mImageView;
            public GuiaPadreContent.GuiaPadre mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                // mIdView = (TextView) view.findViewById(R.id.txt_id);
                mTituloView = (TextView) view.findViewById(R.id.txt_titulo);
                mResumenView=(TextView) view.findViewById(R.id.txt_resumen);
                mFechaView=(TextView) view.findViewById(R.id.txt_fecha);
                mImageView=(ImageView) view.findViewById(R.id.iv_miniatura);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTituloView.getText() + "'";
            }
        }
    }
}
