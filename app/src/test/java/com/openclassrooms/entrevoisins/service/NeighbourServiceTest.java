package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void getNeighboursFavoriteWithSuccess() {
        List<Neighbour> neighbourActual = new ArrayList<>();
        List<Neighbour> neighbourExpected = new ArrayList<>();
        neighbourActual = service.getFavoriteNeighbours();
        neighbourExpected = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbourActual, IsIterableContainingInAnyOrder.containsInAnyOrder(neighbourExpected.toArray()));
    }


    @Test
    public void addNeighboursFavoriteWithSuccess() {
        Neighbour addNeighbour = service.getFavoriteNeighbours();
        service.addFavoriteNeighbours(addNeighbour);
        assertTrue(service.getNeighbours().contains(addNeighbour));
    }

    @Test


    public void deleteNeighboursFavoriteWithSuccess() {
        Neighbour neighbourToDelete = service.getFavoriteNeighbours();
        service.deleteFavoriteNeighbours(neighbourToDelete)
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }
}
}
}
