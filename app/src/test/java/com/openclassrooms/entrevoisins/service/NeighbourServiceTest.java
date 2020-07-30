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
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
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
        Neighbour neighbour = service.getNeighbours().get(0);
        service.addFavoriteNeighbours(neighbour);
        assertEquals(1,service.getFavoriteNeighbours().size());
        assertTrue(service.getFavoriteNeighbours().stream().map(Neighbour::getId).collect(Collectors.toList()).contains(neighbour.getId()));
        assertTrue(service.getFavoriteNeighbours().stream().map(Neighbour::getName).collect(Collectors.toList()).contains(neighbour.getName()));
        assertTrue(service.getFavoriteNeighbours().stream().map(Neighbour::getAvatarUrl).collect(Collectors.toList()).contains(neighbour.getAvatarUrl()));
        assertTrue(service.getFavoriteNeighbours().stream().map(Neighbour::getAddress).collect(Collectors.toList()).contains(neighbour.getAddress()));
        assertTrue(service.getFavoriteNeighbours().stream().map(Neighbour::getPhoneNumber).collect(Collectors.toList()).contains(neighbour.getPhoneNumber()));

    }

    @Test
    public void deleteNeighboursFavoriteWithSuccess() {
        Neighbour neighbour = service.getFavoriteNeighbours().get(0);
        service.deleteFavoriteNeighbours(neighbour);
        assertFalse(service.getFavoriteNeighbours().contains(neighbour));
    }
}


