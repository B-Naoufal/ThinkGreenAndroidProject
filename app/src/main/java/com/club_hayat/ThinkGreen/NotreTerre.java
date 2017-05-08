package com.club_hayat.ThinkGreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class  NotreTerre extends AppCompatActivity {

private SliderLayout  mDemoSlider ;
    //mDemoSlider = new SliderLayout(context,"");

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notre_terre);

        //mDemoSlider = new SliderLayout(NotreTerre.this);
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        LinkedHashMap<String,Integer> file_maps = new LinkedHashMap <String, Integer>();
        file_maps.put("L'homme constriut et subit",R.drawable.hommeresponsable);
        file_maps.put("Il faut tirer la sonnette d'alarme",R.drawable.planetesouffre);
        file_maps.put("Des conséquences déjà visibles", R.drawable.a);
        file_maps.put("Barque échouée dans le désert " +
                "au milieu des montagnes…", R.drawable.b);
        file_maps.put("Forêt ravagée par le feu dans l’état " +
                "du Victoria en Australie", R.drawable.c);
        file_maps.put("Glacier en train de fondre en plein milieu de l'Arctique", R.drawable.d);
        file_maps.put("Ours polaire désorienté par la modification " +
                "de son environnement naturel au Canada", R.drawable.e);
        file_maps.put("Tornade orageuse au dessus des plaines dans le Colorado aux USA", R.drawable.f);
        file_maps.put("Terre touchée par de fortes sécheresses" +
                " dont les plantations sont les premières victimes", R.drawable.g);
        file_maps.put(" Des blocs de glace dispersés en Antarctique", R.drawable.i);
        file_maps.put("Glacier de Jokulsarlon dans le parc National de Skaftafell en Islande",R.drawable.j);
        file_maps.put("Aux Etats-Unis, le barrage de Glen Canyon victime de crues " +
                "qui lui ont fait atteindre son plus haut niveau en 1980", R.drawable.k);
        file_maps.put(" Une étude a estimé que chaque année 1,36 millions de Chinois en décèdent", R.drawable.m);
        file_maps.put("problèmes respiratoires & pollution atmosphérique principalement en ville ", R.drawable.n);
        file_maps.put("Save Money & Energy", R.drawable.peutfaire);
        file_maps.put("Notre reve", R.drawable.ecocity);
        file_maps.put("Passons à l'acte ", R.drawable.action);
        file_maps.put("Nous avons les outils nécessaires",R.drawable.actes);
        file_maps.put("Tout est clair maintenant", R.drawable.f1);
        file_maps.put("A vous de choisir ", R.drawable.f2);
        file_maps.put("Un meilleur avenir ", R.drawable.f3);
        for(String name : file_maps.keySet()){
        TextSliderView textSliderView = new TextSliderView(NotreTerre.this);
        // initialize a SliderLayout
        textSliderView
        .description(name)
        .image(file_maps.get(name));
        mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);

}

    @Override
    protected void onStop() {
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }
}