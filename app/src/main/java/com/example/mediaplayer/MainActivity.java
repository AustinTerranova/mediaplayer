package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public Button previous;
    public Button play;
    public Button next;
    public TextView title;
    public ImageView imageView;
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    boolean mediaStopped;
    boolean media2Stopped;
    boolean media3Stopped;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        previous = findViewById(R.id.prev);
        play = findViewById(R.id.play);
        next = findViewById(R.id.next);
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.textView);
        next = findViewById(R.id.next);
        System.out.println(play.getText());
        mediaPlayer = MediaPlayer.create(this, R.raw.joyful);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.clouds);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.quasarise);
        final int imageResource1 = getResources().getIdentifier("@drawable/clouds", null, this.getPackageName());
        final int imageResource2 = getResources().getIdentifier("@drawable/joyful", null, this.getPackageName());
        final int imageResource3 = getResources().getIdentifier("@drawable/quasarise", null, this.getPackageName());
        imageView.setImageResource(imageResource1);

        previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(index);
                if(index == 1 ){
                    index -= 1;
                    if(media2Stopped){
                        try{
                            mediaPlayer2.prepare();
                            media2Stopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer2.start();
                    imageView.setImageResource(imageResource1);
                    title.setText("clouds");

                    if(mediaPlayer.isPlaying()){
                        mediaStopped = true;
                        mediaPlayer.stop();

                    }
                    if(mediaPlayer3.isPlaying()){
                        media3Stopped = true;
                        mediaPlayer3.stop();

                    }
                    //mediaPlayer3.pause();

                } else if(index == 2) {
                    index -= 1;
                    if(media3Stopped){
                        try{
                            mediaPlayer3.prepare();
                            media3Stopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer3.start();
                    imageView.setImageResource(imageResource3);
                    title.setText("quasarise");
                    if(mediaPlayer2.isPlaying()){
                        media2Stopped = true;
                        mediaPlayer2.stop();

                    }
                    if(mediaPlayer.isPlaying()){
                        mediaStopped = true;
                        mediaPlayer.stop();

                    }
                    // mediaPlayer.pause();
                    //mediaPlayer2.pause();
                    // play first song
                    //playSong(0);
                    //currentSongIndex = 0;
                }else {
                    if(mediaStopped){
                        try{
                            mediaPlayer.prepare();
                            mediaStopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer.start();
                    imageView.setImageResource(imageResource2);
                    title.setText("joyful");
                    if(mediaPlayer2.isPlaying()){
                        media2Stopped = true;
                        mediaPlayer2.stop();

                    }
                    if(mediaPlayer3.isPlaying()){
                        media3Stopped = true;
                        mediaPlayer3.stop();

                    }
                    //mediaPlayer2.reset();
                    //mediaPlayer3.reset();
                    index = 2;
                }


            }

        });
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            //mediaPlayer.start();
            CharSequence text = play.getText();
            System.out.println(play.getText());


            if(play.getText().equals("Play")){
                play.setText("Pause");
                if(index == 1 ){
                    //index += 1;
                    if(media2Stopped){
                        try{
                            mediaPlayer2.prepare();
                            media2Stopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer2.start();
                    if(mediaPlayer.isPlaying()){
                        mediaStopped = true;
                        mediaPlayer.stop();


                    }
                    if(mediaPlayer3.isPlaying()){
                        media3Stopped = true;
                        mediaPlayer3.stop();

                    }
                    //mediaPlayer3.pause();

                } else if(index == 2) {
                    //index += 1;
                    if(media3Stopped){
                        try{
                            mediaPlayer3.prepare();
                            media3Stopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer3.start();
                    if(mediaPlayer2.isPlaying()){
                        media2Stopped = true;
                        mediaPlayer2.stop();

                    }
                    if(mediaPlayer.isPlaying()){
                        mediaStopped = true;
                        mediaPlayer.stop();

                    }
                    // mediaPlayer.pause();
                    //mediaPlayer2.pause();
                    // play first song
                    //playSong(0);
                    //currentSongIndex = 0;
                    play.setText("Pause");
                }else {
                    if(mediaStopped){
                        try{
                            mediaPlayer.prepare();
                            mediaStopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer.start();
                    if(mediaPlayer2.isPlaying()){
                        media2Stopped = true;
                        mediaPlayer2.stop();

                    }
                    if(mediaPlayer3.isPlaying()){
                        media3Stopped = true;
                        mediaPlayer3.stop();

                    }
                    //mediaPlayer2.reset();
                    //mediaPlayer3.reset();
                    //index = 1;
                }


            }else{

                if(play.getText().equals("Pause")){
                    play.setText("Play");
                    System.out.println(index);
                    if(index == 1 ){
                        //index += 1;



                        mediaPlayer2.stop();



                        //mediaPlayer3.pause();

                    } else if(index == 2) {





                        mediaPlayer3.stop();



                    }

                }else {




                    mediaPlayer.stop();

                }



            }














            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println(index);


                if(index == 1 ){
                    index += 1;
                    if(media2Stopped){
                        try{
                            mediaPlayer2.prepare();
                            media2Stopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer2.start();
                    imageView.setImageResource(imageResource1);
                    title.setText("clouds");
                    if(mediaPlayer.isPlaying()){
                        mediaStopped = true;
                        mediaPlayer.stop();

                    }
                    if(mediaPlayer3.isPlaying()){
                        media3Stopped = true;
                        mediaPlayer3.stop();

                    }
                    //mediaPlayer3.pause();

                } else if(index == 2) {
                    index += 1;
                    if(media3Stopped){
                        try{
                            mediaPlayer3.prepare();
                            media3Stopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer3.start();
                    imageView.setImageResource(imageResource3);
                    title.setText("quasarise");
                    if(mediaPlayer2.isPlaying()){
                        media2Stopped = true;
                        mediaPlayer2.stop();

                    }
                    if(mediaPlayer.isPlaying()){
                        mediaStopped = true;
                        mediaPlayer.stop();

                    }
                   // mediaPlayer.pause();
                    //mediaPlayer2.pause();
                    // play first song
                    //playSong(0);
                    //currentSongIndex = 0;
                }else {
                    if(mediaStopped){
                        try{
                            mediaPlayer.prepare();
                            mediaStopped = false;
                        } catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer.start();
                    imageView.setImageResource(imageResource2);
                    title.setText("joyful");
                    if(mediaPlayer2.isPlaying()){
                        media2Stopped = true;
                        mediaPlayer2.stop();

                    }
                    if(mediaPlayer3.isPlaying()){
                        media3Stopped = true;
                        mediaPlayer3.stop();

                    }
                    //mediaPlayer2.reset();
                    //mediaPlayer3.reset();
                    index = 1;
                }

            }

        });
    }
}
