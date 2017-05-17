package it.htm.dao;

import it.htm.entity.Component;

import java.util.List;

public interface ComponentDao {

    List<Component> retrieveComponentByArchId(int id);
}
