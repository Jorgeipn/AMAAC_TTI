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
public class TecnicaRelajacionContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<TecnicaRelajacion> ITEMS = new ArrayList<TecnicaRelajacion>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, TecnicaRelajacion> ITEM_MAP = new HashMap<String, TecnicaRelajacion>();



    static {
        // Add some sample items.

        agregarItem(new TecnicaRelajacion("1","Relajación progresiva"
                ,"Paso 1. El robot: Se le indica al niño que sienta como us piernas y brazos se ponen duras como un robot.\n\n" +
                 "Paso 2. 8 con la cabeza: El niño dejara que su cabeza caiga suelta sobre el pecho y la hará girar lenta y relajadamente trazando un 8 con el movimiento .\n\n" +
                 "Paso 3. Cuello de jirafa: Se estira el cuello cual jirafas. Para ello se levantará el mentón, manteniendo la posición por unos segundos.\n\n" +
                 "Paso 4. Partido de tenis: Se gira la cabeza de izquierda a derecha, como si se estuviese mirando un partido de tenis.\n\n" +
                 "Paso 5. El perrito se sacude: El niño es un perro que acaba de slir del agua. Baja la cabeza y sacude el pelo para que se seque.\n\n" +
                 "Paso 6. El periscopio del submarino emerge: Se entralazan las manos detrás de la cabeza, girando ésta última a derecha e izquierda (la cabeza debe reposar en todo momento en las manos). \nPor último el periscopio emerge a la superficie entonces el niño alargara el cuello durante unos segundos .\n\n" +
                 "Paso 7. Sonrisas de oreja a oreja: se intentará conseguir la más amplia de las sonrisas.\n\n" +
                 "Paso 8. Boca de león: Se abre la boca tanto como se pueda, como un león .\n\n" +
                 "Paso 9. La puerta cerrada: Se cierra la boca presionando con fuerza los labios.\n\n" +
                 "Paso 10. El biberón: Se imita el movimiento de succión que se lleva a cabo al tomar de un biberón.\n\n" +
                 "Paso 11. Un beso muy fuerte: Se adelantan los labios como para dar un fuerte beso.\n\n" +
                 "Paso 12. Ocultación de los dientes: Se pliegan los labios hacia el interior de la boca con el fin de imitar a un señor viejecito que ya no tiene dientes.\n\n" +
                 "Paso 13. Las pedoretas: Se colocan los labios como si se quisiera dar un beso golpeando suabemente con los dedos para soplar y producir un pequeño sonido.\n\n" +
                 "Paso 14. Silbar sin ruido: Se adelantan los labios como si se quisiera dar un silvido pero, tras unos segundos se regresa a la posicion iniciar.\n\n" +
                 "Paso 15. Labios a las orejas: Contrayendo un lado de la cara, se intenta tocar las orejas con los labios. Primero se intenta con un lado, después con el otro y finalmente con los os labios a la vez.\n\n" +
                 "Paso 16. Boca de pez: Con los labios proyectados hacia adelante, los niños juntan y separan los labios como si fueran un pez.\n\n" +
                 "Paso 17. Una hormiga pasea por mi cara: Este ejercicio consiste en transmitir al niño la sensación de que un montón de hormigas caminan por su cara. Se consigue mediante suaves masajes con las yemas de los dedos.\n\n" +
                 "Paso 18. Muecas: Los niños recrean todo tipo de personajes haciendo gestos con la cara.\n\n" +
                 "Paso 19. Concierto de piano en la cara: Los niños recrean en su rostro la acción de tocar un piano con las yemas de sus dedos.\n\n" +
                 "Paso 20. Espuma en la cabeza: los niños imaginarán que tienen espuma en la cabeza. En consecuencia se dan masajes con las yemas de los dedos moviendolos en circulos por toda ésta.\n\n" +
                 "Paso 21. Cara de enojo: El niño finje poner cara de enojo (contrae la musculatura de la frente, las mejillas, la mandibula y los labios).\n\n" +
                 "Paso 22. Los ojos cerrados: Se cierran los párpados con fuerza y se relajan rápidamente .\n\n" +
                 "Paso 23. Moviendo el bigote: El niño se imagina que tiene un bigote, el cual deberá mover e un lado a otro (se desplazan los labios de izquierda a derecha).\n\n" +
                 "Paso 24. Cara de dormido: Se finje tener tanto sueño, que se aflojan todos los músculos.\n\n" +
                 "Paso 25. Enjuagar la boca: Se finje el movimiento de enjuagar la boca (inlando y desinflando las mejillas).\n\n" +
                 "Paso 26. La explosión de los globos: Se inflan las mejillas y se presionan con las yemas de los dedos (se intenta mantener las mejillas infladas, pero el globo termina por desinflarse).\n\n" +
                 "Paso 27. La vaca comelona: EL niño simula masticar moviendo exageradamente la mandibula(con la boca cerrada o abierta).\n\n" +
                "Paso 28. EL arco: Arqueando su cuerpo el niño extiende sus brazos hacia atrás.\n\n" +
                "Paso 29. Volando como mariposa: Se mueven los brazos con suavidad y con las articulaciones lentamente como una mariposa.\n\n" +
                "Paso 30. El balanceo del pendulo: Se levantan los brazos por encima de la cabeza, con los brazos rectos y estirados, basculan a derecha e izquierda, con los ojos cerrados y procurando que la respiración se mantenga siempre libre.\n\n" +
                "Paso 31. Súper fuertes: Se finje levantar algo muy pesado con los brazos tensionados por uno momento, luego se deja caer y se relajan los brazos.\n\n" +
                "Paso 32. El aleteo de los pajaros: Se mueven los brazos en forma de circulos y dejandolos caer al lado del cuerpo parallos al tronco.\n\n" +
                "Paso 33. Los remeros: Se mueven los brazos en forma de circulos omo si se estuviese remando en un bote.\n\n" +
                "Paso 34. El mono cansado: El niño inclina ligeramente el cuerpo hacia delante, deja los brazos sueltos y, con éstos, realiza movimientos de balanceo hacia delante y hacia atrás hasta que sesan por si mismos.\n\n" +
                "Paso 35. El conejo: El niño flexiona su brazo derecho e intenta 'sacar el conejo'. Se tensa y endurece el brazo. Después hay que relajar el brazo. Intentarlo con la izquierda y finalment con los dos a la vez.\n\n" +
                "Paso 36. El abrazo: El niño cuenta uno, dos, tres, con los brazos cruzados y sujetos por las manos contrarias; cuenta tres, dos, uno, y vuelven a la posición inicial (Se puede realizar con un brzo a la vez).\n\n"+
                "Paso 37. El pirata 'Pata de palo': Se coloca una pierna tiesa y dura, se repite con mbas piernas antes de volver a tener las dos piernas reljadas.\n\n"+
                "Paso 38. Huellas en la nieve: Se preionan las plantas de los pies contra el suelo, como si se quisiese dejar marcas en la nieve (Mantener la presión por unos segundos y después relajar los pies).\n\n"+
                "Paso 39. Gigantes y enanos: El niño puede llegar a ser gigante durante unos minutos si estiran todo su cuerpo. tras volver a la normalidad, también son capaces de convertirse en enanos encogiendo, agachando y apretandose mucho (Al final se les recuerda que la posicón normal es la mejor).\n\n"+
                "Paso 40. La momia: El niño se pone completamente rigido en posición de firmes apretando todo su cuerpo, después se le indica que  medida que se va liberando puede ir relajando esa parte del cuerpo. Empezandos liberando la cabeza, los brazos uno por uno, el tronco y por último las piernas.\n\n"+
                "Paso 41. El globo: El niño imaginan que es un globo lleno de aire y a la señal del padre, el niño comienza a sacar el aire lentamente hasta quedar completamente desinflado en el suelo.\n\n"+
                "Paso 42. EL despertar de pinocho: El niño se encuentra en el sulo por el ejercicio anterior por lo que se le indica que ahora es un muñeco de madra y tiene todas sus partes rigidas por lo que no puede moverse, el padre va tocando el cullo del niño, sus brazos, el tronco y por último los pies para condevrtirlo en un niño de verdad (Cada que se toca una parte del niño, éste podra usarla para levantarse).\n\n"+
                "Paso 43. Las doce campanadas: Se cerrarán los ojos y se colocarán las manos rectas delante del pecho una arriba de la otra, después se dejarán caer hacia el cuerpo diciendo 'dongg'. Tras las doce campanadas se continua al siguiente paso.\n\n"+
                "Paso 44. Risas y enfado: EL tutor le pide al niño que se ría mucho, no solo con la cara, sino con todo el cuerpo, que debe de estar muy suelto. Luego le propone que simule enojo, también con todo el cuerpo, esta vez tenso.\n\n"+
                "Paso 45. La alfombra: El niño deberá imaginarse que es una alfombra cupierta de polvo a la que debe de sacudirse, por partes: un brazo, otro, ambos brazos a la vez, una pierna, la otra, el cuello y, por último, el cuerpo entero .\n\n"+

                "\n\n" +
                "Nota: .\n\n"

                ,"https://www.youtube.com/watch?v=ZteyyzIqtvk"
                ,R.drawable.ic_tecnica_relajacion_progresiva));



        agregarItem(new TecnicaRelajacion("2","La velita"
                ,"Paso 1: Sentamos al niño en una silla y en frente habrá una mesa con una vela encendida a 2.5mts de distancia.\n\n" +
                 "Paso 2: Le decimos al niño que tome aire y a través de un soplido intente apagar la vela.\n\n" +
                 "Paso 3: Cada 30seg le acercaremos la vela al niño unos 20cm.\n\n" +
                 "Paso 4: Repetimos los pasos anteriores hasta que el niño logre apagar la vela.\n\n" +
                 "\n\n" +
                 "Nota: El truco está en colocar la vela lejos del niño para que éste tenga que tomar muchas veces aire y al final acercarsela para que pueda apagarla.\n\n" +
                 "Al cabo de 4 o 5 minutos la respiración habrá hecho que el niño se relaje."
                ,"https://www.youtube.com/watch?v=ZteyyzIqtvk"
                ,R.drawable.ic_tecnica_vela));


        agregarItem(new TecnicaRelajacion("3","La marioneta"
                ,"Paso 1: Poner música relajante de fondo.\n\n" +
                 "Paso 2: Recostamos al niño en un lugar comodo. \n\n" +
                 "Paso 3: Le indicamos al niño que contraiga todos sus musculos (piernas, brazos, puños, abdomen) muy rápido.\n\n" +
                 "Paso 4: Le decimos al niño que se mantenga así y contamos hasta 10.\n\n" +
                 "Paso 5: Le indicamos que se ponga flojo como una marioneta.\n\n" +
                 "\n\n" +
                 "Nota: Este ejercicio se basa en contracción y relajación muscular (Se puede repetir tantas veces como se quiera)"
                ,"https://www.youtube.com/watch?v=e8p_k1fuUX0"
                ,R.drawable.ic_tecnica_marioneta));


        agregarItem(new TecnicaRelajacion("4","El globo"
                ,"Paso 1: Poner música relajante de fondo.\n\n" +
                "Paso 2: Le indicamos al niño que se coloque de pie y completamente recto. \n\n" +
                "Paso 3: Se empezará explicandole al niño que se convertirá en un globo que se infla y se desinfla.\n\n" +
                "Paso 4: Después se simulará inflar el globo con una bomba en las manos.\n\n" +
                "Paso 5: Cada vez que se infla el globo el niño levantará los brazos lateralmente e inflara el vientre.\n\n" +
                "Paso 6: Cuando se le indique al niño, deberá poner las manos en su vientre para que el niño deje salir lentamente el aire como si fuera un globo al mismo tiempo que va colocando sus manos en el vientre.\n\n" +
                "Paso 7: Repetimos el proceso varias veces.\n\n" +
                "Paso 8: Por último le indicaremos al niño que se desinfle completamente, éste deberá recostarse lentamente en el suelo (se procede a verificar que brazos y piernas esten completamente 'desinfladas' como un globo).\n\n" +
                "\n\n" +
                "Nota: Este ejercicio se basa en la respiración diafragmática (Se puede repetir tantas veces como se quiera)"
                ,"https://www.youtube.com/watch?v=w5kaKHJzUfE"
                ,R.drawable.ic_tecnica_globo));








    }

    @NonNull
    private static String generarId() {
        return UUID.randomUUID().toString();
    }


    private static void agregarItem(TecnicaRelajacion item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }




    /**
     * A dummy item representing a piece of content.
     */
    public static class TecnicaRelajacion {
        public final String id;
        public final String titulo;
        public final String descripcion;
        public final String fecha;
        public final int idImagen;

        public TecnicaRelajacion(String id, String titulo, String descripcion,String fecha,int idImagen) {
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
