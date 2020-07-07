package com.openclassrooms.entrevoisins.service;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourFavoriteFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();
    private ArrayList favorite = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     *
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }


    @Override
    public List<Neighbour> getFavoriteNeighbours() {

        return favorite;
    }

    @Override
    public void deleteFavoriteNeighbours(Neighbour neighbour) {
        for (int i = 0; i < favorite.size(); i--) {
            if (neighbour.getFavorite() == false) {
                neighbours.remove(neighbour);
            }
        }
    }

    @Override
    public void addFavoriteNeighbours(Neighbour neighbour) {


        for (int i = 0; i < favorite.size(); i++) {
            if (neighbour.getFavorite() == true) {
                neighbours.add(neighbour);
            }
        }

    }
}
