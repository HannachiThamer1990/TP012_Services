package com.example.solarsystem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Mercure", R.drawable.mercure, 57.9, 3.285e23, 87.4, 0, 4879, 3.7, "Quasi inexistante", -200, 430,R.raw.mercure));
        planets.add(new Planet("Vénus", R.drawable.venus, 108.2, 4.867e24, 224.7, 0, 12104, 8.87, "CO2, N2", -90, 460,R.raw.venus));
        planets.add(new Planet("Terre", R.drawable.terre, 149.6, 5.972e24, 365.2, 1, 12756, 9.81, "N2, O2", -60, 60,R.raw.terre));
        planets.add(new Planet("Mars", R.drawable.mars, 227.9, 6.39e23, 686.9, 2, 6792, 3.711, "CO2, N2", -140, 20,R.raw.mars));
        planets.add(new Planet("Jupiter", R.drawable.jupiter, 778.5, 1.898e27, 4332.6, 79, 142984, 24.79, "H2, He", -150, -100,R.raw.jupiter));
        planets.add(new Planet("Saturne", R.drawable.saturne, 1427.0, 5.683e26, 10759, 83, 120536, 10.44, "H2, He", -180, -120,R.raw.saturne));
        planets.add(new Planet("Uranus", R.drawable.uranus, 2871.0, 8.681e25, 30687, 27, 51118, 8.69, "H2, He", -200, -200,R.raw.uranus));
        planets.add(new Planet("Neptune", R.drawable.neptune, 4495.1, 1.024e26, 60190, 14, 49530, 11.15, "H2, He", -200, -200,R.raw.neptune));



        PlanetAdapter adapter = new PlanetAdapter(this, planets);
        recyclerView.setAdapter(adapter);
    }
}
