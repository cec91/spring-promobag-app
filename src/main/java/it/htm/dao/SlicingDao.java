package it.htm.dao;

import it.htm.entity.Slicing;
import it.htm.entity.Task;

import java.util.List;

/**
 * Created by vincenzo on 27/11/16.
 */
public interface SlicingDao {
    public List<Slicing> retrieveSlicingByCompId(int slicing_id);
    Slicing retrieveSlicingById(int slicing_id);
}
