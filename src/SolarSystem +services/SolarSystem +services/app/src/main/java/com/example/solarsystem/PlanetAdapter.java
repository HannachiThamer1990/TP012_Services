package com.example.solarsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Adapter pour gérer les données de la liste des planètes et afficher leurs informations dans un RecyclerView.
public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private Context context; // Contexte de l'activité ou de l'application.
    private List<Planet> planetList; // Liste des objets Planet à afficher.

    // Constructeur pour initialiser le contexte et la liste des planètes.
    public PlanetAdapter(Context context, List<Planet> planetList) {
        this.context = context;
        this.planetList = planetList;
    }

    /**
     * Méthode appelée pour créer une nouvelle instance de ViewHolder.
     *
     * @param parent   Le ViewGroup dans lequel la nouvelle vue sera ajoutée après avoir été liée
     *                 à une position de l'adaptateur.
     * @param viewType Le type de vue de la nouvelle vue (non utilisé ici).
     * @return Une instance de PlanetViewHolder contenant la vue créée.
     */
    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Gonfle le layout XML pour un élément de la liste.
        View view = LayoutInflater.from(context).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view); // Retourne le ViewHolder créé.
    }

    /**
     * Méthode appelée pour mettre à jour les données d'un élément de la liste.
     *
     * @param holder   Le ViewHolder à mettre à jour avec les données.
     * @param position La position de l'élément dans la liste de données.
     */
    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        // Récupère l'objet Planet correspondant à la position actuelle.
        Planet planet = planetList.get(position);

        // Met à jour les vues du ViewHolder avec les données de la planète.
        holder.planetName.setText(planet.getName());
        holder.planetDistance.setText("Distance: " + planet.getDistanceFromSun() + " million km");
        holder.planetImage.setImageResource(planet.getImageResId());

        // Définit un écouteur de clic sur l'élément de la liste pour ouvrir une activité de détail.
        holder.itemView.setOnClickListener(v -> {
            // Prépare une Intent pour démarrer l'activité PlanetDetailActivity.
            Intent intent = new Intent(context, PlanetDetailActivity.class);
            intent.putExtra("planet", planet); // Passe l'objet Planet en extra.
            context.startActivity(intent); // Démarre l'activité.
        });
    }

    /**
     * Retourne le nombre total d'éléments dans la liste.
     *
     * @return Le nombre d'éléments dans planetList.
     */
    @Override
    public int getItemCount() {
        return planetList.size();
    }

    // Classe interne pour définir le ViewHolder, qui contient les vues pour un élément de la liste.
    static class PlanetViewHolder extends RecyclerView.ViewHolder {
        TextView planetName, planetDistance; // Vues pour afficher le nom et la distance de la planète.
        ImageView planetImage; // Vue pour afficher l'image de la planète.

        /**
         * Constructeur pour initialiser les vues du ViewHolder.
         *
         * @param itemView La vue racine d'un élément de la liste.
         */
        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            // Associe les vues aux ID définis dans le fichier XML item_planet.
            planetName = itemView.findViewById(R.id.planetName);
            planetDistance = itemView.findViewById(R.id.planetDistance);
            planetImage = itemView.findViewById(R.id.planetImage);
        }
    }
}
