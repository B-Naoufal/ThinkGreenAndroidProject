package com.club_hayat.ThinkGreen.CATEGORIES;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.club_hayat.ThinkGreen.R;

import java.util.ArrayList;

public class CARTON extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carton);
        Intent intent = getIntent();
        String choicecateg = intent.getStringExtra("choice") ;
        RecyclerView picturesRecycler = (RecyclerView) findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapter pictureAdapterRecyclerView = new PictureAdapter(buildPictures(choicecateg),R.layout.cardview_picture, CARTON.this);
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
    }

    public ArrayList<Picture> buildPictures(String string)
    {

        ArrayList<Picture> VAR = new ArrayList<>();
        ArrayList<Picture> picturesCarton = new ArrayList<>();
        picturesCarton.add(new Picture(R.drawable.minion, "Minions", "Making Minions only by using cardboard", "gBTFl5yS3q4"));
        picturesCarton.add(new Picture(R.drawable.flowerpot, "Flower Pot", "Idea of recycling of cardboard  in flower pot ","Qxl69uhhJmw"));
        picturesCarton.add(new Picture(R.drawable.cardframes, "Cardbo ard Frames ", "Create fun frames from cardboard and decorative paper ", "HpGwolUNkJ4"));
        picturesCarton.add(new Picture(R.drawable.cardboardorganizer, "cardboard organizer", "make a Vintage cardboard organizer simple and practical","OpCaMM9mZ1k "));
        picturesCarton.add(new Picture(R.drawable.coinpurse, "Coin Purse", "How to make a coin purse by recycling a milk carton. " , "nYbvbFYydts"));
        picturesCarton.add(new Picture(R.drawable.giftbox, "GIFT Box ", "How to make a Gift box only by using milk carton","ITz5c_J9rOQ"));
        picturesCarton.add(new Picture(R.drawable.birdfeeder, "Birdfeeder ", "Upcycle and reuse that milk carton to create a bird feeder to bring birds to your yard or garden! ","N0If2Zu1UIY"));
        picturesCarton.add(new Picture(R.drawable.phoneholder, "PHONE HOLDER", "How to make a phone holder from toilet paper rolls. It's easy and inexpressive !","sco6M9O-jZg"));
        picturesCarton.add(new Picture(R.drawable.accessoriesstand, "Accessories Stand", "how to make a tumblry accessories stand(Earrings Holder), using recycled milk carton.","THhsaeJc6vc"));
        picturesCarton.add(new Picture(R.drawable.phonecase, "PHONE CASEE", "how to make a phone case recycling a milk carton. It's very easy!","IsbL57NCR94"));
        picturesCarton.add(new Picture(R.drawable.cardboardlamp, "Cardboard Lamp", "Making a pendant lamp from recycling cardboard, by cutting with templates.","g3MLAKa03fQ"));
        picturesCarton.add(new Picture(R.drawable.homecat, "Home For Cats", "Make some awesome home for cats","k1s-tME89H8"));

                    //   liste des objets en plastique

        ArrayList<Picture> picturesPlastique = new ArrayList<>();
        picturesPlastique.add(new Picture(R.drawable.storagejars, "Storage Jars & Lids", "Cut the bottle into small cylinders, to iron their edges, and use the foam to decorate.", "6R6wz4bQlPo"));
        picturesPlastique.add(new Picture(R.drawable.plasticbottle, "Plastic Bottle ", "Recycle plastic bottles to have handy things used in day to day life  ","hiZM0Pgh28g"));
        picturesPlastique.add(new Picture(R.drawable.tapis, "Carpet recycling ", "Knit plastic bags to have a carpet  ", "IeuGj8Dsk2A"));
        picturesPlastique.add(new Picture(R.drawable.bottlelampe, "plastic bottle to lamp", "Using plastic bottle as a coverage of a night light ","b1SH6u6JGmE"));
        picturesPlastique.add(new Picture(R.drawable.splampe, "Spoon Lamp", "Au lieu de les jeter vérifiez  comment les cuillères en plastique,  peuvent être transformées en une belle lampe." , "ycDB-OHlC8s"));


        //   liste des objets en papier


        ArrayList<Picture> picturesPapier = new ArrayList<>();
        picturesPapier.add(new Picture(R.drawable.sacpapier, "Paper Gift Bag ", "C’est une idée simple qui consiste à utiliser intelligemment les papiers pour faire des beaux sacs à utiliser différemment.", "vJbPs87v0J8"));
        picturesPapier.add(new Picture(R.drawable.boitesecret, " Boite à Secrets", "Découvrir  comment réaliser une petite boite  à partir d’un vieux livre","xFjz5xL3OWQ"));
        picturesPapier.add(new Picture(R.drawable.ppanier, " Panier en Papier", "C’est une technique purement recyclable. Uniquement à base de papier, fabriquez votre petit panier.","dFKAhhKOtr4"));
        //   liste des objets en boites de conserve

        ArrayList<Picture> picturesConserve = new ArrayList<>();
        picturesConserve.add(new Picture(R.drawable.pphare, " Can To Photophore", "Cut the head of the can then , we make consecutive  puncture Using the needle and we add up a candle to get Photophore", "ePRsSPjMkiI"));
        picturesConserve.add(new Picture(R.drawable.cpphare, " Cola Photophore", "after we draw a thin strips we cut it, then we dye it With any available color and we hang it up with the thread and our photophore ", "fvrTdnOCSYg"));
        picturesConserve.add(new Picture(R.drawable.papillion, "Butterflies With Coke", "It's too easy by drawing butterfly anatomy and cuting the shape after filling the color with the color markers(and don’t forget the wings) ","rKDqGKCUonI"));
        picturesConserve.add(new Picture(R.drawable.canningbox, "CANNING BOX", "Draw the canning box and leave it 10 min to dry then Paste the gray tape ", "7v1z7IF36_s"));





        //   liste des objets en verre

        ArrayList<Picture> picturesVerre= new ArrayList<>();
        picturesVerre.add(new Picture(R.drawable.ampoulefl, "Soliflores from old bulbs", "Drill a small hole and pass the thread and hang it on the wall.", "9c62vgtGsAE"));
        picturesVerre.add(new Picture(R.drawable.soap, "soap dispenser ", "Making some awesome JAR SOAP DISPENSER .", "N5zk1OR43Fg"));

        //   liste des objets en Tissu

        ArrayList<Picture> picturesTissu = new ArrayList<>();
        picturesTissu.add(new Picture(R.drawable.pilow, "T-shirt To a Pillow ", "Cut the bottle into small cylinders, to iron their edges, and use the foam to decorate.", "bd3gx3SuTU4"));
        picturesTissu.add(new Picture(R.drawable.nounouss, " *Nounou* ", "This is about how you can create some cute Teddy Bear from a sock.", "JXrzwsa18yI"));
        picturesTissu.add(new Picture(R.drawable.smiley, " coussin smiley ", "Comment faire un coussin smiley pour maison ", "7KSKYIx-1tM"));
        //   liste des objets en Bois

        ArrayList<Picture> picturesBois = new ArrayList<>();
        picturesBois.add(new Picture(R.drawable.bbijoux, "Boite à Bijoux", "C’est une bonne technique pour le recyclage des bâtons de glace. En même temps c’est beau comme une décoration. ", "BNkthZNfhno"));
        picturesBois.add(new Picture(R.drawable.collect_legumes, "ORGANIZER OF WOOD", "construire simplement votre propre organisateur de legumes/fruits facile et très utile", "vVsuCArqonc"));
        picturesBois.add(new Picture(R.drawable.poreille, "Porte boucles d'oreilles", "Profiter des bâtons de glace pour faire des portes boucles d’oreilles que vous pouvez l’utiliser comme des cadeaux ou pour vous-même .C’est simple et facile à réaliser .", "QUk2sTNT0iw"));
        picturesBois.add(new Picture(R.drawable.gdecore, "une boîte décorative ","Vous pouvez utiliser les bâtons pour fabriquer des jolies boites en usant des ", "0eqX6hyIxSk"));


        if (string.equals("CARTON")){
            VAR= picturesCarton;
        }
        if (string.equals("Plastique")){
            VAR= picturesPlastique;
        }
        if (string.equals("papier")){
            VAR= picturesPapier;
        }
        if (string.equals("CANETTES & CONSERVE")){
            VAR= picturesConserve;
        }
        if (string.equals("VERRE")){
            VAR= picturesVerre;
        }
        if (string.equals("TISSU")){
            VAR= picturesTissu;

        }
        if (string.equals("bois")){
            VAR= picturesBois;

        }

        return VAR;




}}