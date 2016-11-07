package mx.com.ipn.amaac.tableroDeComunicacion.adaptadores;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import mx.com.ipn.amaac.MainActivity;
import mx.com.ipn.amaac.R;
import mx.com.ipn.amaac.tableroDeComunicacion.db.DBHelper;
import mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma;
import mx.com.ipn.amaac.tableroDeComunicacion.model.Utilidades;

import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.PIC_NORMAL;
import static mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma.PIC_SELECCIONADO;


/**
 * Created by Jorge Lopez
 * Angel Fierro
 * on 31/10/2016.
 */
public class TableroDeComunicacion_main extends AppCompatActivity implements TextToSpeech.OnInitListener {


    private DBHelper dbHandler;
    private DiferenteAdapter adapter;
    private TextToSpeech textToSpeech;

    private List<Pictograma> picto_seleccionados=new ArrayList<Pictograma>();
    private GridLayoutManager mLayoutManager;
//    private PictogramaFraseAdapter adapterFrase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictograma_list_main);
        textToSpeech = new TextToSpeech( this, this );
        View recyclerView = findViewById(R.id.pictograma_list_categoria);
        assert recyclerView != null;
        dbHandler = new DBHelper(this);
        //InicializarDatos();
        InicializarAdaptador(recyclerView);

    }


    public void go_to_pp(View view){
        startActivity(new Intent(this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
        finish();
    }


    /////////////////////////////////////////////////////////////////////////////

    public void playFrase(View view){

        String x= getTextDatosSeleccionados(picto_seleccionados);
        speak(x);

        //Toast.makeText(getApplicationContext(), x , Toast.LENGTH_LONG).show();
    }

    public void deleteFrase(View view){

        getTextDatosSeleccionados2(picto_seleccionados);


//        Toast.makeText(getApplicationContext(), x , Toast.LENGTH_LONG).show();
    }

    public String getTextDatosSeleccionados(List<Pictograma> items){
        String frase="";

        for(int i=0; i<items.size(); i++){
            frase += items.get(i).getNombre()+ " ";
        }

        return frase;
    }

    public void getTextDatosSeleccionados2(List<Pictograma> items){

        picto_seleccionados.clear();
        mostrarDatosSeleccionados(picto_seleccionados);
        View recyclerView2 = findViewById(R.id.pictograma_list_frase);

        assert recyclerView2 != null;

        adapter = new DiferenteAdapter(picto_seleccionados);
        setupRecyclerView((RecyclerView) recyclerView2,(DiferenteAdapter) adapter,PIC_SELECCIONADO);

    }

    public void Delete(int index){
        picto_seleccionados.remove(index);
        mostrarDatosSeleccionados(picto_seleccionados);
        View recyclerView2 = findViewById(R.id.pictograma_list_frase);

        assert recyclerView2 != null;

        adapter = new DiferenteAdapter(picto_seleccionados);
        setupRecyclerView((RecyclerView) recyclerView2,(DiferenteAdapter) adapter,PIC_SELECCIONADO);

    }


/////////////////////////////////////////////////////////////////////////

    public void Guardar(String nombre,int categoria,int idDrawable,int tipo){
        Pictograma nuevo_pictograma=new Pictograma(nombre,categoria,idDrawable,tipo);
        picto_seleccionados.add(nuevo_pictograma);
        mostrarDatosSeleccionados(picto_seleccionados);
        View recyclerView2 = findViewById(R.id.pictograma_list_frase);

        assert recyclerView2 != null;

        adapter = new DiferenteAdapter(picto_seleccionados);
        setupRecyclerView((RecyclerView) recyclerView2,(DiferenteAdapter) adapter,PIC_SELECCIONADO);

    }

    public  void mostrarDatosSeleccionados(List<Pictograma> items){
        Iterator m=items.iterator();
        System.out.println("*************************************");
        System.out.println("El arreglo contiene: "+items.size()+" elementos");
        while (m.hasNext())
            System.out.println("\n"+m.next());
        System.out.println("*************************************");
    }

    public void InicializarAdaptador(View recyclerView){
        Log.d("leyendo", "Se estan leyendo los datos de la base de datos");
        List<Pictograma> picto = dbHandler.getAllUsers();
        System.out.println("********");
        adapter = new DiferenteAdapter(picto);
        System.out.println("********");
        setupRecyclerView((RecyclerView) recyclerView,(DiferenteAdapter) adapter,PIC_NORMAL);

    }


    /*

    public void InicializarDatos(){
        dbHandler = new DBHelper(this);

        Log.d("count", "--> "+dbHandler.count());

        if(dbHandler.count()==0){
            Log.d("agregar", "Se  agregaran nuevos pictogramas");

            //============ VERBOS AUXILIARES
            dbHandler.addUser(new Pictograma("Estoy", 6,R.drawable.ic_tablero_verbos_aux_estar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Necesito", 6,R.drawable.ic_tablero_verbos_aux_necesitar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Puedo", 6,R.drawable.ic_tablero_verbos_aux_poder ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Quiero", 6,R.drawable.ic_tablero_verbos_aux_querer ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Saber", 6,R.drawable.ic_tablero_verbos_aux_saber ,Pictograma.PIC_NORMAL));

            //============ RESPUESTAS
            dbHandler.addUser(new Pictograma("Bien", 5,R.drawable.ic_tablero_respuestas_bien ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Mal", 5,R.drawable.ic_tablero_respuestas_mal ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("No entiendo", 5,R.drawable.ic_tablero_respuestas_no_entiendo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sí", 5,R.drawable.ic_tablero_respuestas_si ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("No", 5,R.drawable.ic_tablero_respuestas_no ,Pictograma.PIC_NORMAL));


            //============ BEBIDAS
            dbHandler.addUser(new Pictograma("Agua", 1,R.drawable.ic_tablero_alimentos_bebidas_agua ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Jugo", 1,R.drawable.ic_tablero_alimentos_bebidas_jugo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Leche", 1,R.drawable.ic_tablero_alimentos_bebidas_leche ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Refresco", 1,R.drawable.ic_tablero_alimentos_bebidas_refresco ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Te", 1,R.drawable.ic_tablero_alimentos_bebidas_te ,Pictograma.PIC_NORMAL));

            //============ FRUTAS
            dbHandler.addUser(new Pictograma("Cerezas", 1,R.drawable.ic_tablero_alimentos_frutas_cereza ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Durazno", 1,R.drawable.ic_tablero_alimentos_frutas_durazno ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Fresa", 1,R.drawable.ic_tablero_alimentos_frutas_fresa ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Limón", 1,R.drawable.ic_tablero_alimentos_frutas_limon ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Mango", 1,R.drawable.ic_tablero_alimentos_frutas_mango ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Manzana", 1,R.drawable.ic_tablero_alimentos_frutas_manzana ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Melón", 1,R.drawable.ic_tablero_alimentos_frutas_melon ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Naranja", 1,R.drawable.ic_tablero_alimentos_frutas_naranja ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Papaya", 1,R.drawable.ic_tablero_alimentos_frutas_papaya ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pera", 1,R.drawable.ic_tablero_alimentos_frutas_pera ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Piña", 1,R.drawable.ic_tablero_alimentos_frutas_pina ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Platano", 1,R.drawable.ic_tablero_alimentos_frutas_platano ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sandia", 1,R.drawable.ic_tablero_alimentos_frutas_sandia ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Toronja", 1,R.drawable.ic_tablero_alimentos_frutas_toronja ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Uvas", 1,R.drawable.ic_tablero_alimentos_frutas_uvas ,Pictograma.PIC_NORMAL));

            //============ VERDURAS
            dbHandler.addUser(new Pictograma("Aguacate", 1,R.drawable.ic_tablero_alimentos_verduras_aguacate ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ajo", 1,R.drawable.ic_tablero_alimentos_verduras_ajos ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Brócoli", 1,R.drawable.ic_tablero_alimentos_verduras_brocoli ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Calabaza", 1,R.drawable.ic_tablero_alimentos_verduras_calabaza ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cebolla", 1,R.drawable.ic_tablero_alimentos_verduras_cebolla ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Coliflor", 1,R.drawable.ic_tablero_alimentos_verduras_coliflor ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Chicharos", 1,R.drawable.ic_tablero_alimentos_verduras_chicharos ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Chile", 1,R.drawable.ic_tablero_alimentos_verduras_chile ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Espinacas", 1,R.drawable.ic_tablero_alimentos_verduras_espinacas ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Hongos", 1,R.drawable.ic_tablero_alimentos_verduras_hongos ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Jitomate", 1,R.drawable.ic_tablero_alimentos_verduras_tomate ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Lechuga", 1,R.drawable.ic_tablero_alimentos_verduras_lechuga ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Maíz", 1,R.drawable.ic_tablero_alimentos_verduras_maiz ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Papa", 1,R.drawable.ic_tablero_alimentos_verduras_patata ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pepino", 1,R.drawable.ic_tablero_alimentos_verduras_pepino ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Zanahoria", 1,R.drawable.ic_tablero_alimentos_verduras_zanahoria ,Pictograma.PIC_NORMAL));

            //============ COMIDA
            dbHandler.addUser(new Pictograma("Arroz", 1,R.drawable.ic_tablero_alimentos_comida_arroz ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Carne", 1,R.drawable.ic_tablero_alimentos_comida_carne ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cereal", 1,R.drawable.ic_tablero_alimentos_comida_cereale ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Huevo", 1,R.drawable.ic_tablero_alimentos_comida_huevo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pan", 1,R.drawable.ic_tablero_alimentos_comida_pan ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pescado", 1,R.drawable.ic_tablero_alimentos_comida_pescado ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pollo", 1,R.drawable.ic_tablero_alimentos_comida_pollo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sopa", 1,R.drawable.ic_tablero_alimentos_comida_sopa ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Tortilla", 1,R.drawable.ic_tablero_alimentos_comida_tortilla ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Queso", 1,R.drawable.ic_tablero_alimentos_comida_queso ,Pictograma.PIC_NORMAL));

            //============ POSTRES
            dbHandler.addUser(new Pictograma("Flan", 1,R.drawable.ic_tablero_alimentos_postres_flan ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Helado", 1,R.drawable.ic_tablero_alimentos_postres_helado ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Paleta", 1,R.drawable.ic_tablero_alimentos_postres_paleta ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Palomitas", 1,R.drawable.ic_tablero_alimentos_postres_palomitas ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pastel", 1,R.drawable.ic_tablero_alimentos_postres_pastel ,Pictograma.PIC_NORMAL));

            //============ COMIDA GENERAL
            dbHandler.addUser(new Pictograma("Almuerzo", 1,R.drawable.ic_tablero_alimentos_comida_general_almuerzo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cena", 1,R.drawable.ic_tablero_alimentos_comida_general_cena ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Comida", 1,R.drawable.ic_tablero_alimentos_comida_general_comida ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Desayuno", 1,R.drawable.ic_tablero_alimentos_comida_general_desayuno ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Postre", 1,R.drawable.ic_tablero_alimentos_comida_general_postre ,Pictograma.PIC_NORMAL));

            //============ ANIMALES
            dbHandler.addUser(new Pictograma("Ardilla", 2,R.drawable.ic_tablero_animales_ardilla ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Boa", 2,R.drawable.ic_tablero_animales_serpiente ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ballena", 2,R.drawable.ic_tablero_animales_ballena ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cocodrilo", 2,R.drawable.ic_tablero_animales_cocodrilo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Delfín", 2,R.drawable.ic_tablero_animales_delfin ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Elefante", 2,R.drawable.ic_tablero_animales_elefante ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Flamenco", 2,R.drawable.ic_tablero_animales_flamenco ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Gato", 2,R.drawable.ic_tablero_animales_gato ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Hiena", 2,R.drawable.ic_tablero_animales_hiena ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Iguana", 2,R.drawable.ic_tablero_animales_iguana ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Jirafa", 2,R.drawable.ic_tablero_animales_jirafa ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Koala", 2,R.drawable.ic_tablero_animales_koala ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("León", 2,R.drawable.ic_tablero_animales_leon ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Mono", 2,R.drawable.ic_tablero_animales_mono ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Nutria", 2,R.drawable.ic_tablero_animales_nutria ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ñu", 2,R.drawable.ic_tablero_animales_nu ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Oso", 2,R.drawable.ic_tablero_animales_oso ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pez", 2,R.drawable.ic_tablero_animales_pez ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Quetzal", 2,R.drawable.ic_tablero_animales_quetzal ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Res", 2,R.drawable.ic_tablero_animales_res ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sapo", 2,R.drawable.ic_tablero_animales_sapo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Tortuga", 2,R.drawable.ic_tablero_animales_tortuga ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Urraca", 2,R.drawable.ic_tablero_animales_urraca ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Vaca", 2,R.drawable.ic_tablero_animales_vaca ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Wapití", 2,R.drawable.ic_tablero_animales_wapiti ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Yak", 2,R.drawable.ic_tablero_animales_yak ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Zorro", 2,R.drawable.ic_tablero_animales_zorro ,Pictograma.PIC_NORMAL));

            //============ VERBOS
            dbHandler.addUser(new Pictograma("Arreglar", 6,R.drawable.ic_tablero_verbos_arreglar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ayudar", 6,R.drawable.ic_tablero_verbos_ayudar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Bailar", 6,R.drawable.ic_tablero_verbos_bailar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Bajar", 6,R.drawable.ic_tablero_verbos_bajar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Beber", 6,R.drawable.ic_tablero_verbos_beber ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Buscar", 6,R.drawable.ic_tablero_verbos_buscar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Caminar", 6,R.drawable.ic_tablero_verbos_caminar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cantar", 6,R.drawable.ic_tablero_verbos_cantar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Celebrar", 6,R.drawable.ic_tablero_verbos_celebrar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cocinar", 6,R.drawable.ic_tablero_verbos_cocinar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Compartir", 6,R.drawable.ic_tablero_verbos_compartir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Comprar", 6,R.drawable.ic_tablero_verbos_comprar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Correr", 6,R.drawable.ic_tablero_verbos_correr ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Crear", 6,R.drawable.ic_tablero_verbos_crear ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Dar", 6,R.drawable.ic_tablero_verbos_dar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Despertarse", 6,R.drawable.ic_tablero_verbos_despertarse ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Dormir", 6,R.drawable.ic_tablero_verbos_dormir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Entrar", 6,R.drawable.ic_tablero_verbos_entrar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Escribir", 6,R.drawable.ic_tablero_verbos_escribir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Escuchar", 6,R.drawable.ic_tablero_verbos_escuchar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Estudiar", 6,R.drawable.ic_tablero_verbos_estudiar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ganar", 6,R.drawable.ic_tablero_verbos_ganar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Girar", 6,R.drawable.ic_tablero_verbos_girar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Guardar", 6,R.drawable.ic_tablero_verbos_guardar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Hablar", 6,R.drawable.ic_tablero_verbos_hablar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Hacer", 6,R.drawable.ic_tablero_verbos_hacer ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Herir", 6,R.drawable.ic_tablero_verbos_herir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Huir", 6,R.drawable.ic_tablero_verbos_huir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ir", 6,R.drawable.ic_tablero_verbos_ir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Leer", 6,R.drawable.ic_tablero_verbos_leer ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Llamar", 6,R.drawable.ic_tablero_verbos_llamar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Mojar", 6,R.drawable.ic_tablero_verbos_mojar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Nadar", 6,R.drawable.ic_tablero_verbos_nadar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Perder", 6,R.drawable.ic_tablero_verbos_perder ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Poner", 6,R.drawable.ic_tablero_verbos_poner ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Probar", 6,R.drawable.ic_tablero_verbos_probar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Regalar", 6,R.drawable.ic_tablero_verbos_regalar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Salir", 6,R.drawable.ic_tablero_verbos_salir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Saltar", 6,R.drawable.ic_tablero_verbos_saltar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Secar", 6,R.drawable.ic_tablero_verbos_secar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sentarse", 6,R.drawable.ic_tablero_verbos_sentarse ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ser", 6,R.drawable.ic_tablero_verbos_ser ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Subir", 6,R.drawable.ic_tablero_verbos_subir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Tener", 6,R.drawable.ic_tablero_verbos_tener ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Trabajar", 6,R.drawable.ic_tablero_verbos_trabajar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Usar", 6,R.drawable.ic_tablero_verbos_usar ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Venir", 6,R.drawable.ic_tablero_verbos_venir ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Ver", 6,R.drawable.ic_tablero_verbos_ver ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Vestirse", 6,R.drawable.ic_tablero_verbos_vestirse ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Volar", 6,R.drawable.ic_tablero_verbos_volar ,Pictograma.PIC_NORMAL));

            //============ OBJETOS
            dbHandler.addUser(new Pictograma("Calzón", 4,R.drawable.ic_tablero_objetos_calzon ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cama", 4,R.drawable.ic_tablero_objetos_cama ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Camisa", 4,R.drawable.ic_tablero_objetos_camisa ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Carro", 4,R.drawable.ic_tablero_objetos_carro ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Celular", 4,R.drawable.ic_tablero_objetos_celular ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Chamarra", 4,R.drawable.ic_tablero_objetos_chamarra ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Computadora", 4,R.drawable.ic_tablero_objetos_computadora ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cuchara", 4,R.drawable.ic_tablero_objetos_cuchara ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Cuchillo", 4,R.drawable.ic_tablero_objetos_cuchillo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Dulces", 4,R.drawable.ic_tablero_objetos_dulces ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Falda", 4,R.drawable.ic_tablero_objetos_falda ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Globos", 4,R.drawable.ic_tablero_objetos_globos ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Hoy", 4,R.drawable.ic_tablero_objetos_hoy ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Jabón", 4,R.drawable.ic_tablero_objetos_jabon ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Juguete", 4,R.drawable.ic_tablero_objetos_juguete ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Lentes", 4,R.drawable.ic_tablero_objetos_lentes ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Luna", 4,R.drawable.ic_tablero_objetos_luna ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Luz", 4,R.drawable.ic_tablero_objetos_luz ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Mesa", 4,R.drawable.ic_tablero_objetos_mesa ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Mochila", 4,R.drawable.ic_tablero_objetos_mochila ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Muñeca", 4,R.drawable.ic_tablero_objetos_muneca ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Música", 4,R.drawable.ic_tablero_objetos_musica ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pantalones", 4,R.drawable.ic_tablero_objetos_pantalones ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Paz", 4,R.drawable.ic_tablero_objetos_paz ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Película", 4,R.drawable.ic_tablero_objetos_pelicula ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Peluche", 4,R.drawable.ic_tablero_objetos_peluche ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Pis", 4,R.drawable.ic_tablero_objetos_pis ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Plato", 4,R.drawable.ic_tablero_objetos_plato ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Popo", 4,R.drawable.ic_tablero_objetos_popo ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Puerta", 4,R.drawable.ic_tablero_objetos_puerta ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Radio", 4,R.drawable.ic_tablero_objetos_radio ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Refrigerador", 4,R.drawable.ic_tablero_objetos_refrigerador ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Silla", 4,R.drawable.ic_tablero_objetos_silla ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sillón", 4,R.drawable.ic_tablero_objetos_sillon ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Sol", 4,R.drawable.ic_tablero_objetos_sol ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Suéter", 4,R.drawable.ic_tablero_objetos_sueter ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Televisión", 4,R.drawable.ic_tablero_objetos_television ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Tenedor", 4,R.drawable.ic_tablero_objetos_tenedor ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Tenis", 4,R.drawable.ic_tablero_objetos_tenis ,Pictograma.PIC_NORMAL));
            dbHandler.addUser(new Pictograma("Zapatos", 4,R.drawable.ic_tablero_objetos_zapatos ,Pictograma.PIC_NORMAL));

            Log.d("agregaron", "Se  agregaron nuevos pictogramas");
        }


        // Reading all contacts
    }

    */


    private void setupRecyclerView(@NonNull RecyclerView recyclerView, DiferenteAdapter adapter, int tipo) {

        recyclerView.setAdapter(adapter);
        if (tipo==0){
            recyclerView.setLayoutManager(new GridLayoutManager(this,5));
        }else{
            recyclerView.setLayoutManager(new GridLayoutManager(this,8));
        }

        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        /*si cambiáramos de idea y quisiéramos mostrar los datos de forma tabular tan sólo tendríamos
         que cambiar la asignación del LayoutManager anterior y utilizar un GridLayoutManager, al que
         pasaremos como parámetro el número de columnas a mostrar.*/
    }
    /*****************************************************************************************************
     *    En esta parte se implementa y reproduce con voz el nombre del pictograma seleccionado
     *****************************************************************************************************/
    @Override
    public void onInit(int status) {
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
            Toast toast=Toast.makeText(TableroDeComunicacion_main.this,"ola",Toast.LENGTH_SHORT);
            toast.show();

        }
    }

    private void speak( String str )
    {
        textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
        textToSpeech.setSpeechRate( 0.0f );
        textToSpeech.setPitch( 0.0f );
    }


    @Override
    protected void onDestroy()
    {
        if ( textToSpeech != null )
        {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    /*******************************************************************************************************
     *                                    Fin de TextoSpeech
     *******************************************************************************************************/

    public class DiferenteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        //private ArrayList<Pictograma> mDataSet;
        private List<Pictograma> mValues;

        public DiferenteAdapter(List<Pictograma> items) {
            this.mValues = items;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType){
                case PIC_NORMAL:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pictograma_categoria_content, parent, false);
                    return new PictogramaViewHolder(view);
                case PIC_SELECCIONADO:
                    view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pictograma_frase_content, parent, false);
                    return new FraseViewHolder(view);

            }
            return null;
        }

        @Override
        public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
            Pictograma object= mValues.get(position);
            if (object != null) {
                switch (object.getTipo()) {
                    case PIC_NORMAL:
                        ((PictogramaViewHolder) holder).mNombreView.setText(mValues.get(position).nombre);
                        ((PictogramaViewHolder) holder).mImageView.setImageResource(mValues.get(position).idDrawable);
                        ((PictogramaViewHolder) holder).mImageView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria()));

                        break;
                    case PIC_SELECCIONADO:
                        ((FraseViewHolder) holder).mNombreViewFrase.setText(mValues.get(position).nombre);
                        ((FraseViewHolder) holder).mImageViewFrase.setImageResource(mValues.get(position).idDrawable);
                        ((FraseViewHolder) holder).mImageViewFrase.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria()));

                        break;
                }
            }


        /* ************* Esta es la linea para colorear el pictograma de acuerdo a su categoria de pictograma **********************************************************************/
            // holder.mNombreView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria())); //Solo colorear el texto
            // holder.mImageView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria())); //Colorear

            //holder.mView.setBackgroundResource(Utilidades.getBackground(mValues.get(position).getCategoria())); //Colorear

            /*************************************************************************************************************************************************************************/
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
        @Override
        public int getItemViewType(int position) {
            if (mValues != null) {
                final  Pictograma object = mValues.get(position);
                if (object != null) {
                    return object.getTipo();
                }
            }
            return 0;
        }

        public  class PictogramaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            //campos respectivos de un item Pictograma

            // public final TextView mIdView;
            public final ImageView mImageView;
            private final TextView mNombreView;

            Pictograma mItem;

            public PictogramaViewHolder(View view) {
                super(view);


                view.setOnClickListener(this);

                // mIdView = (TextView) view.findViewById(R.id.txt_id);
                mImageView = (ImageView) view.findViewById(R.id.iv_PicElemento_categoria_comunicador);
                mNombreView = (TextView) view.findViewById(R.id.tv_PicElemento_categoria_comunicador);
            }

            @Override
            public void onClick(View v) {

                int posicion=getAdapterPosition();
                Pictograma m= mValues.get(posicion);

           /* Toast toast=Toast.makeText(v.getContext(), mItem.getNombre(), Toast.LENGTH_SHORT);

            View toastView = toast.getView();
            toastView.setBackgroundResource(R.color.colorAccent);
            toast.setGravity(Gravity.RIGHT | Gravity.BOTTOM, 0, 0);//BOTTOM /END
            toast.show();*/
                // v.setBackgroundResource(Utilidades.getBackground(m.getCategoria()));
                Locale locSpanish = new Locale("spa", "MEX");
                textToSpeech.setLanguage(locSpanish);
                speak(m.getNombre());

                //Instanciamos un nuevo Toast
                Toast _mToast = new Toast(getApplicationContext());

                //Definimos la ubicación del Toast
                _mToast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
                _mToast.setDuration(Toast.LENGTH_SHORT);


                //Instanciamos un LayoutInflater donde definimos el archivo XML a utilizar (R.layout.layout_toast) e
                // indicamos el el objeto [LinearLayout] contenedor (R.id.Linearlayout_toast)
                LayoutInflater inflater = getLayoutInflater();
                View custom_toast = inflater.inflate(R.layout.toast,
                        (ViewGroup) findViewById(R.id.Linearlayout_toast));

                //Instanciamos un nuevo TextView y lo asociamos al del layout
                TextView textToast = (TextView) custom_toast.findViewById(R.id.toast_textView);

                //Aqui definimos el texto que se mostrará en el Toast
                textToast.setText(m.getNombre());

                //Añadimos la vista al Toast y lo mostramos
                _mToast.setView(custom_toast);
                _mToast.show();

                Guardar(m.getNombre(), m.getCategoria(), m.getIdDrawable(),Pictograma.PIC_SELECCIONADO);


            }
        }
        ////////////////////////////////////////////////////////////////////////////
        public class FraseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public final View mView;

            public  final ImageView mImageViewFrase;
            public  final TextView mNombreViewFrase;
            public  Pictograma mItem;


            public FraseViewHolder(View view) {
                super(view);
                mView = view;
                mImageViewFrase=(ImageView) view.findViewById(R.id.iv_PicElemento_frase_comunicador);
                mNombreViewFrase=(TextView) view.findViewById(R.id.tv_PicElemento_frase_comunicador);

                view.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();



                Delete(position);

                //Pictograma pictograma_frase = mValues.get(position);
                //String x= position + " - " + pictograma_frase.getNombre();
                //Toast.makeText(getApplicationContext(), x , Toast.LENGTH_LONG).show();

            }
        }






        ////////////////////////////////////////////////////////////////////
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
}
