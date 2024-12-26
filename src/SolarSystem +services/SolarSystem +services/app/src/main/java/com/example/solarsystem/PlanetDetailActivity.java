package com.example.solarsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;

public class PlanetDetailActivity extends AppCompatActivity {

    private int musicResId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);

        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailMass = findViewById(R.id.detailMass);
        TextView detailRevolution = findViewById(R.id.detailRevolution);
        TextView detailSatellites = findViewById(R.id.detailSatellites);
        TextView detailDiameter = findViewById(R.id.detailDiameter);
        TextView detailGravity = findViewById(R.id.detailGravity);
        TextView detailAtmosphere = findViewById(R.id.detailAtmosphere);
        TextView detailTempRange = findViewById(R.id.detailTempRange);


        Planet planet = (Planet) getIntent().getSerializableExtra("planet");
        if (planet == null) {
            throw new IllegalArgumentException("Planet object is null!");
        }

        detailImage.setImageResource(planet.getImageResId());
        detailName.setText(planet.getName());
        detailMass.setText("Masse: " + planet.getMass() + " kg");
        detailRevolution.setText("Période de révolution: " + planet.getRevolutionPeriod() + " jours");
        detailSatellites.setText("Nombre de satellites: " + planet.getNumberOfSatellites());
        detailDiameter.setText("Diamètre: " + planet.getDiameter() + " km");
        detailGravity.setText("Gravité: " + planet.getGravity() + " m/s²");
        detailAtmosphere.setText("Atmosphère: " + planet.getAtmosphere());
        detailTempRange.setText("Température: " + planet.getMinTemperature() + " °C à " + planet.getMaxTemperature() + " °C");


        musicResId = getMusicResIdForPlanet(planet.getName());

        Intent notificationIntent = new Intent(this, NotificationService.class);
        startService(notificationIntent);

        // lancer music
        Intent playIntent = new Intent(this, MusicService.class);
        playIntent.setAction("PLAY_MUSIC");
        playIntent.putExtra("musicResId", musicResId);
        startService(playIntent);


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }


    @Override
    protected void onPause() {
        super.onPause();
        // Mettre en pause la musique lorsque l'application est en arrière-plan
        Intent pauseIntent = new Intent(this, MusicService.class);
        pauseIntent.setAction("PAUSE_MUSIC");
        startService(pauseIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reprendre la musique lorsque l'application revient au premier plan
        Intent resumeIntent = new Intent(this, MusicService.class);
        resumeIntent.setAction("RESUME_MUSIC");
        startService(resumeIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Arrêter la musique lorsqu'on quitte complètement l'activité
        Intent stopIntent = new Intent(this, MusicService.class);
        stopIntent.setAction("STOP_MUSIC");
        startService(stopIntent);
    }


    private int getMusicResIdForPlanet(String planetName) {
        switch (planetName) {
            case "Mercure":
                return R.raw.mercure;
            case "Vénus":
                return R.raw.venus;
            case "Terre":
                return R.raw.terre;
            case "Mars":
                return R.raw.mars;
            case "Jupiter":
                return R.raw.jupiter;
            case "Saturne":
                return R.raw.saturne;
            case "Uranus":
                return R.raw.uranus;
            case "Neptune":
                return R.raw.neptune;
            default:
                return 0;
        }
    }
}

