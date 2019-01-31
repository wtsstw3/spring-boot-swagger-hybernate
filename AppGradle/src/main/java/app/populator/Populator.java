package app.populator;

import app.model.AbstractModel;
import app.dto.AbstractData;

import java.util.List;

/**
 * Created by Black on 12.02.2018.
 */
public interface Populator<SOURCE extends AbstractModel, TARGET extends AbstractData> {
    void populate(SOURCE var1, TARGET var2);

    void populateList(List<SOURCE> var1, List<TARGET> var2);
}
