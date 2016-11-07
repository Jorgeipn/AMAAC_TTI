package mx.com.ipn.amaac;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import mx.com.ipn.amaac.dummy.TecnicaRelajacionContent;

/**
 * A fragment representing a single Tecnica detail screen.
 * This fragment is either contained in a {@link TecnicaListActivity}
 * in two-pane mode (on tablets) or a {@link TecnicaDetailActivity}
 * on handsets.
 */
public class TecnicaDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ID_ARTICULO = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private TecnicaRelajacionContent.TecnicaRelajacion itemDetalldo;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TecnicaDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ID_ARTICULO)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            itemDetalldo = TecnicaRelajacionContent.ITEM_MAP.get(getArguments().getString(ID_ARTICULO));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(itemDetalldo.titulo);//el contenido dentro ded  i barra
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tecnica_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (itemDetalldo != null) {
            ((TextView) v.findViewById(R.id.tecnica_detail)).setText(itemDetalldo.descripcion);
            ((TextView) v.findViewById(R.id.fecha)).setText(itemDetalldo.fecha);
        }

        return v;
    }
}
