package mx.com.ipn.amaac.dummy;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import mx.com.ipn.amaac.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class GuiaPadreContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<GuiaPadre> ITEMS = new ArrayList<GuiaPadre>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, GuiaPadre> ITEM_MAP = new HashMap<String,GuiaPadre>();



    static {
        // Add some sample items.

        agregarItem(new GuiaPadre("1","1 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_guia_padre_customer_service));
        agregarItem(new GuiaPadre("2","2 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_guia_padre_customer_service_1));
        agregarItem(new GuiaPadre("3","3 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_guia_padre_technology));
        agregarItem(new GuiaPadre("4","4 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_guia_padre_technology_1));
        agregarItem(new GuiaPadre("5","5 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_guia_padre_telemarketer));
        agregarItem(new GuiaPadre("6","6 formas para relajar tu estres","Muchos creen que solo realizar ejercicios de cardio los hará perder de peso y...","17 de Enero",R.drawable.ic_menu_guia_padre_telemarketer));

    }

    @NonNull
    private static String generarId() {
        return UUID.randomUUID().toString();
    }


    private static void agregarItem(GuiaPadre item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }




    /**
     * A dummy item representing a piece of content.
     */
    public static class GuiaPadre {
        public final String id;
        public final String titulo;
        public final String descripcion;
        public final String fecha;
        public final int idImagen;

        public GuiaPadre(String id, String titulo, String descripcion,String fecha,int idImagen) {
            this.id = id;
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.fecha=fecha;
            this.idImagen=idImagen;
        }

        @Override
        public String toString() {
            return titulo;
        }
    }
}
