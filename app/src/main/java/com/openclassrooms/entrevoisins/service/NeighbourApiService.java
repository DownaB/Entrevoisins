package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Get Favorite Neighbours
     * @return {@Link List}
     */

    List<Neighbour> getFavoriteNeighbours();

    /**
     * Delete a Favorite Neighbours
     * @param neighbour
     */

    void deleteFavoriteNeighbours(Neighbour neighbour);

    /**
     * Add a Favorite Neighbours
     * @param neighbour
     */

    void addFavoriteNeighbours(Neighbour neighbour);
}
