package mx.com.ipn.amaac.tableroDeComunicacion.model;

import mx.com.ipn.amaac.R;

public class Utilidades {

    public static int getBackground(int categoria){
        int d;

        switch (categoria){
            case 1:
                d = R.drawable.pic_border_alimentos;
                break;
            case 2:
                d = R.drawable.pic_border_animales;
                break;
            case 3:
                d = R.drawable.pic_border_familia;
                break;
            case 4:
                d = R.drawable.pic_border_lugares;
                break;
            case 5:
                d = R.drawable.pic_border_profesiones;
                break;
            case 6:
                d = R.drawable.pic_border_verbos;
                break;



            default:
                d = R.drawable.pic_border;
                break;
        }

        return d;
    }



}
