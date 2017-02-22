package mx.com.ipn.amaac;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//import mx.com.ipn.amaac.tableroDeComunicacion.adaptadores.TableroDeComunicacion_main;
import mx.com.ipn.amaac.tableroDeComunicacion.db.DBHelper;
import mx.com.ipn.amaac.tableroDeComunicacion.model.Pictograma;

public class TerminosYCondiciones extends AppCompatActivity {

    SharedPreferences preferences;
    private DBHelper dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_y_condiciones);

        preferences = getSharedPreferences("TerminosYCondiciones", MODE_PRIVATE);
        boolean TERMINOS_Y_CONDICIONES= preferences.getBoolean("opcion", false);

    }

    public void TYC_aceptar(View view){
        SharedPreferences.Editor editor= preferences.edit();
        editor.putBoolean("opcion", true);
        editor.commit();

        cargarPictogramas();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void TYC_rechazar(View view){
        finish();
    }

    private void cargarPictogramas(){
        dbHandler = new DBHelper(this);
        Log.d("count_TYC", "--> "+dbHandler.count());

        if(dbHandler.count()==0){
            Log.d("agregar_TYC", "Se  agregaran nuevos pictogramas");

            //============ VERBOS AUXILIARES
            dbHandler.insertPictograma(new Pictograma("Estoy", 6,R.drawable.ic_tablero_verbos_aux_estar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Necesito", 6,R.drawable.ic_tablero_verbos_aux_necesitar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Puedo", 6,R.drawable.ic_tablero_verbos_aux_poder ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Quiero", 6,R.drawable.ic_tablero_verbos_aux_querer ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Saber", 6,R.drawable.ic_tablero_verbos_aux_saber ,Pictograma.PIC_NORMAL));

            //============ RESPUESTAS
            dbHandler.insertPictograma(new Pictograma("Bien", 5,R.drawable.ic_tablero_respuestas_bien ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mal", 5,R.drawable.ic_tablero_respuestas_mal ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("No entiendo", 5,R.drawable.ic_tablero_respuestas_no_entiendo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sí", 5,R.drawable.ic_tablero_respuestas_si ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("No", 5,R.drawable.ic_tablero_respuestas_no ,Pictograma.PIC_NORMAL));


            //============ BEBIDAS
            dbHandler.insertPictograma(new Pictograma("Agua", 1,R.drawable.ic_tablero_alimentos_bebidas_agua ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Jugo", 1,R.drawable.ic_tablero_alimentos_bebidas_jugo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Leche", 1,R.drawable.ic_tablero_alimentos_bebidas_leche ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Refresco", 1,R.drawable.ic_tablero_alimentos_bebidas_refresco ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Te", 1,R.drawable.ic_tablero_alimentos_bebidas_te ,Pictograma.PIC_NORMAL));

            //============ FRUTAS
            dbHandler.insertPictograma(new Pictograma("Cerezas", 1,R.drawable.ic_tablero_alimentos_frutas_cereza ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Durazno", 1,R.drawable.ic_tablero_alimentos_frutas_durazno ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Fresa", 1,R.drawable.ic_tablero_alimentos_frutas_fresa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Limón", 1,R.drawable.ic_tablero_alimentos_frutas_limon ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mango", 1,R.drawable.ic_tablero_alimentos_frutas_mango ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Manzana", 1,R.drawable.ic_tablero_alimentos_frutas_manzana ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Melón", 1,R.drawable.ic_tablero_alimentos_frutas_melon ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Naranja", 1,R.drawable.ic_tablero_alimentos_frutas_naranja ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Papaya", 1,R.drawable.ic_tablero_alimentos_frutas_papaya ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pera", 1,R.drawable.ic_tablero_alimentos_frutas_pera ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Piña", 1,R.drawable.ic_tablero_alimentos_frutas_pina ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Platano", 1,R.drawable.ic_tablero_alimentos_frutas_platano ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sandia", 1,R.drawable.ic_tablero_alimentos_frutas_sandia ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Toronja", 1,R.drawable.ic_tablero_alimentos_frutas_toronja ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Uvas", 1,R.drawable.ic_tablero_alimentos_frutas_uvas ,Pictograma.PIC_NORMAL));

            //============ VERDURAS
            dbHandler.insertPictograma(new Pictograma("Aguacate", 1,R.drawable.ic_tablero_alimentos_verduras_aguacate ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ajo", 1,R.drawable.ic_tablero_alimentos_verduras_ajos ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Brócoli", 1,R.drawable.ic_tablero_alimentos_verduras_brocoli ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Calabaza", 1,R.drawable.ic_tablero_alimentos_verduras_calabaza ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cebolla", 1,R.drawable.ic_tablero_alimentos_verduras_cebolla ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Coliflor", 1,R.drawable.ic_tablero_alimentos_verduras_coliflor ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Chicharos", 1,R.drawable.ic_tablero_alimentos_verduras_chicharos ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Chile", 1,R.drawable.ic_tablero_alimentos_verduras_chile ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Espinacas", 1,R.drawable.ic_tablero_alimentos_verduras_espinacas ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hongos", 1,R.drawable.ic_tablero_alimentos_verduras_hongos ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Jitomate", 1,R.drawable.ic_tablero_alimentos_verduras_tomate ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Lechuga", 1,R.drawable.ic_tablero_alimentos_verduras_lechuga ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Maíz", 1,R.drawable.ic_tablero_alimentos_verduras_maiz ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Papa", 1,R.drawable.ic_tablero_alimentos_verduras_patata ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pepino", 1,R.drawable.ic_tablero_alimentos_verduras_pepino ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Zanahoria", 1,R.drawable.ic_tablero_alimentos_verduras_zanahoria ,Pictograma.PIC_NORMAL));

            //============ COMIDA
            dbHandler.insertPictograma(new Pictograma("Arroz", 1,R.drawable.ic_tablero_alimentos_comida_arroz ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Carne", 1,R.drawable.ic_tablero_alimentos_comida_carne ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cereal", 1,R.drawable.ic_tablero_alimentos_comida_cereale ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Huevo", 1,R.drawable.ic_tablero_alimentos_comida_huevo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pan", 1,R.drawable.ic_tablero_alimentos_comida_pan ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pescado", 1,R.drawable.ic_tablero_alimentos_comida_pescado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pollo", 1,R.drawable.ic_tablero_alimentos_comida_pollo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sopa", 1,R.drawable.ic_tablero_alimentos_comida_sopa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tortilla", 1,R.drawable.ic_tablero_alimentos_comida_tortilla ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Queso", 1,R.drawable.ic_tablero_alimentos_comida_queso ,Pictograma.PIC_NORMAL));

            //============ POSTRES
            dbHandler.insertPictograma(new Pictograma("Flan", 1,R.drawable.ic_tablero_alimentos_postres_flan ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Helado", 1,R.drawable.ic_tablero_alimentos_postres_helado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Paleta", 1,R.drawable.ic_tablero_alimentos_postres_paleta ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Palomitas", 1,R.drawable.ic_tablero_alimentos_postres_palomitas ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pastel", 1,R.drawable.ic_tablero_alimentos_postres_pastel ,Pictograma.PIC_NORMAL));

            //============ COMIDA GENERAL
            dbHandler.insertPictograma(new Pictograma("Almuerzo", 1,R.drawable.ic_tablero_alimentos_comida_general_almuerzo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cena", 1,R.drawable.ic_tablero_alimentos_comida_general_cena ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Comida", 1,R.drawable.ic_tablero_alimentos_comida_general_comida ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Desayuno", 1,R.drawable.ic_tablero_alimentos_comida_general_desayuno ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Postre", 1,R.drawable.ic_tablero_alimentos_comida_general_postre ,Pictograma.PIC_NORMAL));

            //============ ANIMALES
            dbHandler.insertPictograma(new Pictograma("Ardilla", 2,R.drawable.ic_tablero_animales_ardilla ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Boa", 2,R.drawable.ic_tablero_animales_serpiente ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ballena", 2,R.drawable.ic_tablero_animales_ballena ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cocodrilo", 2,R.drawable.ic_tablero_animales_cocodrilo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Delfín", 2,R.drawable.ic_tablero_animales_delfin ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Elefante", 2,R.drawable.ic_tablero_animales_elefante ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Flamenco", 2,R.drawable.ic_tablero_animales_flamenco ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Gato", 2,R.drawable.ic_tablero_animales_gato ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hiena", 2,R.drawable.ic_tablero_animales_hiena ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Iguana", 2,R.drawable.ic_tablero_animales_iguana ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Jirafa", 2,R.drawable.ic_tablero_animales_jirafa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Koala", 2,R.drawable.ic_tablero_animales_koala ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("León", 2,R.drawable.ic_tablero_animales_leon ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mono", 2,R.drawable.ic_tablero_animales_mono ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Nutria", 2,R.drawable.ic_tablero_animales_nutria ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ñu", 2,R.drawable.ic_tablero_animales_nu ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Oso", 2,R.drawable.ic_tablero_animales_oso ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pez", 2,R.drawable.ic_tablero_animales_pez ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Quetzal", 2,R.drawable.ic_tablero_animales_quetzal ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Res", 2,R.drawable.ic_tablero_animales_res ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sapo", 2,R.drawable.ic_tablero_animales_sapo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tortuga", 2,R.drawable.ic_tablero_animales_tortuga ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Urraca", 2,R.drawable.ic_tablero_animales_urraca ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Vaca", 2,R.drawable.ic_tablero_animales_vaca ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Wapití", 2,R.drawable.ic_tablero_animales_wapiti ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Yak", 2,R.drawable.ic_tablero_animales_yak ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Zorro", 2,R.drawable.ic_tablero_animales_zorro ,Pictograma.PIC_NORMAL));

            //============ VERBOS
            dbHandler.insertPictograma(new Pictograma("Arreglar", 6,R.drawable.ic_tablero_verbos_arreglar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ayudar", 6,R.drawable.ic_tablero_verbos_ayudar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Bailar", 6,R.drawable.ic_tablero_verbos_bailar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Bajar", 6,R.drawable.ic_tablero_verbos_bajar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Beber", 6,R.drawable.ic_tablero_verbos_beber ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Buscar", 6,R.drawable.ic_tablero_verbos_buscar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Caminar", 6,R.drawable.ic_tablero_verbos_caminar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cantar", 6,R.drawable.ic_tablero_verbos_cantar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Celebrar", 6,R.drawable.ic_tablero_verbos_celebrar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cocinar", 6,R.drawable.ic_tablero_verbos_cocinar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Compartir", 6,R.drawable.ic_tablero_verbos_compartir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Comprar", 6,R.drawable.ic_tablero_verbos_comprar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Correr", 6,R.drawable.ic_tablero_verbos_correr ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Crear", 6,R.drawable.ic_tablero_verbos_crear ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Dar", 6,R.drawable.ic_tablero_verbos_dar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Despertarse", 6,R.drawable.ic_tablero_verbos_despertarse ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Dormir", 6,R.drawable.ic_tablero_verbos_dormir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Entrar", 6,R.drawable.ic_tablero_verbos_entrar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Escribir", 6,R.drawable.ic_tablero_verbos_escribir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Escuchar", 6,R.drawable.ic_tablero_verbos_escuchar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Estudiar", 6,R.drawable.ic_tablero_verbos_estudiar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ganar", 6,R.drawable.ic_tablero_verbos_ganar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Girar", 6,R.drawable.ic_tablero_verbos_girar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Guardar", 6,R.drawable.ic_tablero_verbos_guardar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hablar", 6,R.drawable.ic_tablero_verbos_hablar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hacer", 6,R.drawable.ic_tablero_verbos_hacer ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Herir", 6,R.drawable.ic_tablero_verbos_herir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Huir", 6,R.drawable.ic_tablero_verbos_huir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ir", 6,R.drawable.ic_tablero_verbos_ir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Leer", 6,R.drawable.ic_tablero_verbos_leer ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Llamar", 6,R.drawable.ic_tablero_verbos_llamar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mojar", 6,R.drawable.ic_tablero_verbos_mojar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Nadar", 6,R.drawable.ic_tablero_verbos_nadar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Perder", 6,R.drawable.ic_tablero_verbos_perder ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Poner", 6,R.drawable.ic_tablero_verbos_poner ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Probar", 6,R.drawable.ic_tablero_verbos_probar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Regalar", 6,R.drawable.ic_tablero_verbos_regalar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Salir", 6,R.drawable.ic_tablero_verbos_salir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Saltar", 6,R.drawable.ic_tablero_verbos_saltar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Secar", 6,R.drawable.ic_tablero_verbos_secar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sentarse", 6,R.drawable.ic_tablero_verbos_sentarse ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ser", 6,R.drawable.ic_tablero_verbos_ser ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Subir", 6,R.drawable.ic_tablero_verbos_subir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tener", 6,R.drawable.ic_tablero_verbos_tener ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Trabajar", 6,R.drawable.ic_tablero_verbos_trabajar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Usar", 6,R.drawable.ic_tablero_verbos_usar ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Venir", 6,R.drawable.ic_tablero_verbos_venir ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Ver", 6,R.drawable.ic_tablero_verbos_ver ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Vestirse", 6,R.drawable.ic_tablero_verbos_vestirse ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Volar", 6,R.drawable.ic_tablero_verbos_volar ,Pictograma.PIC_NORMAL));

            //============ OBJETOS
            dbHandler.insertPictograma(new Pictograma("Calzón", 4,R.drawable.ic_tablero_objetos_calzon ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cama", 4,R.drawable.ic_tablero_objetos_cama ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Camisa", 4,R.drawable.ic_tablero_objetos_camisa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Carro", 4,R.drawable.ic_tablero_objetos_carro ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Celular", 4,R.drawable.ic_tablero_objetos_celular ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Chamarra", 4,R.drawable.ic_tablero_objetos_chamarra ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Computadora", 4,R.drawable.ic_tablero_objetos_computadora ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cuchara", 4,R.drawable.ic_tablero_objetos_cuchara ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cuchillo", 4,R.drawable.ic_tablero_objetos_cuchillo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Dulces", 4,R.drawable.ic_tablero_objetos_dulces ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Falda", 4,R.drawable.ic_tablero_objetos_falda ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Globos", 4,R.drawable.ic_tablero_objetos_globos ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hoy", 4,R.drawable.ic_tablero_objetos_hoy ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Jabón", 4,R.drawable.ic_tablero_objetos_jabon ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Juguete", 4,R.drawable.ic_tablero_objetos_juguete ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Lentes", 4,R.drawable.ic_tablero_objetos_lentes ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Luna", 4,R.drawable.ic_tablero_objetos_luna ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Luz", 4,R.drawable.ic_tablero_objetos_luz ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mesa", 4,R.drawable.ic_tablero_objetos_mesa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mochila", 4,R.drawable.ic_tablero_objetos_mochila ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Muñeca", 4,R.drawable.ic_tablero_objetos_muneca ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Música", 4,R.drawable.ic_tablero_objetos_musica ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pantalones", 4,R.drawable.ic_tablero_objetos_pantalones ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Paz", 4,R.drawable.ic_tablero_objetos_paz ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Película", 4,R.drawable.ic_tablero_objetos_pelicula ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Peluche", 4,R.drawable.ic_tablero_objetos_peluche ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pis", 4,R.drawable.ic_tablero_objetos_pis ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Plato", 4,R.drawable.ic_tablero_objetos_plato ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Popo", 4,R.drawable.ic_tablero_objetos_popo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Puerta", 4,R.drawable.ic_tablero_objetos_puerta ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Radio", 4,R.drawable.ic_tablero_objetos_radio ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Refrigerador", 4,R.drawable.ic_tablero_objetos_refrigerador ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Silla", 4,R.drawable.ic_tablero_objetos_silla ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sillón", 4,R.drawable.ic_tablero_objetos_sillon ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sol", 4,R.drawable.ic_tablero_objetos_sol ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Suéter", 4,R.drawable.ic_tablero_objetos_sueter ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Televisión", 4,R.drawable.ic_tablero_objetos_television ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tenedor", 4,R.drawable.ic_tablero_objetos_tenedor ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tenis", 4,R.drawable.ic_tablero_objetos_tenis ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Zapatos", 4,R.drawable.ic_tablero_objetos_zapatos ,Pictograma.PIC_NORMAL));

            //============ ESTADOS DE ANIMO
            dbHandler.insertPictograma(new Pictograma("Aburrido", 3,R.drawable.ic_tablero_estados_animo_aburrido ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Asustado", 3,R.drawable.ic_tablero_estados_animo_asustado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cansado", 3,R.drawable.ic_tablero_estados_animo_cansado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Confundido", 3,R.drawable.ic_tablero_estados_animo_confundido ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Enamorado", 3,R.drawable.ic_tablero_estados_animo_enamorado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Enfermo", 3,R.drawable.ic_tablero_estados_animo_enfermo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Enojado", 3,R.drawable.ic_tablero_estados_animo_enojado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Feliz", 3,R.drawable.ic_tablero_estados_animo_feliz ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hambriento", 3,R.drawable.ic_tablero_estados_animo_hambriento ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Pensativo", 3,R.drawable.ic_tablero_estados_animo_pensativo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Saludable", 3,R.drawable.ic_tablero_estados_animo_saludable ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Somnoliento", 3,R.drawable.ic_tablero_estados_animo_somnoliento ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Sorprendido", 3,R.drawable.ic_tablero_estados_animo_sorprendido ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Triste", 3,R.drawable.ic_tablero_estados_animo_triste ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Vergüenza", 3,R.drawable.ic_tablero_estados_animo_verguenza ,Pictograma.PIC_NORMAL));

            //============ LUGARES
            dbHandler.insertPictograma(new Pictograma("Casa", 12,R.drawable.ic_tablero_lugares_casa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Cine", 12,R.drawable.ic_tablero_lugares_cine ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Escuela", 12,R.drawable.ic_tablero_lugares_escuela ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hospital", 12,R.drawable.ic_tablero_lugares_hospital ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Iglesia", 12,R.drawable.ic_tablero_lugares_iglesia ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mercado", 12,R.drawable.ic_tablero_lugares_mercado ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Museo", 12,R.drawable.ic_tablero_lugares_museo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Parque", 12,R.drawable.ic_tablero_lugares_parque ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tienda", 12,R.drawable.ic_tablero_lugares_tienda ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Zoológico", 12,R.drawable.ic_tablero_lugares_zoologico ,Pictograma.PIC_NORMAL));

            //============ FAMILIA
            dbHandler.insertPictograma(new Pictograma("Abuelita", 10,R.drawable.ic_tablero_familia_abuelita ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Abuelito", 10,R.drawable.ic_tablero_familia_abuelito ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hermana", 10,R.drawable.ic_tablero_familia_hermana ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Hermano", 10,R.drawable.ic_tablero_familia_hermano ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Mamá", 10,R.drawable.ic_tablero_familia_mama ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Papá", 10,R.drawable.ic_tablero_familia_papa ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Prima", 10,R.drawable.ic_tablero_familia_prima ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Primo", 10,R.drawable.ic_tablero_familia_primo ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tía", 10,R.drawable.ic_tablero_familia_tia ,Pictograma.PIC_NORMAL));
            dbHandler.insertPictograma(new Pictograma("Tío", 10,R.drawable.ic_tablero_familia_tio ,Pictograma.PIC_NORMAL));



            Log.d("agregaron_TYC", "Se  agregaron nuevos pictogramas");
        }


        // Reading all contacts
    }



}
