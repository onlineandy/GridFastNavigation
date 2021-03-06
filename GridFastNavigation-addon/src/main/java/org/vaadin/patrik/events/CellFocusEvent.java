package org.vaadin.patrik.events;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.components.grid.MultiSelectionModel;

@SuppressWarnings("serial")
public class CellFocusEvent<T> extends Component.Event {

    private int row;
    private int col;
    private boolean rowChanged;
    private boolean colChanged;
    private T item;
    private int offset = 0;
    
    public CellFocusEvent(Component source, int row, int col, boolean rowChanged, boolean colChanged, T item) {
        super(source);
        this.row = row;
        this.col = col;
        this.item = item;
        Grid<T> grid = (Grid<T>) source;
        if (grid.getSelectionModel() instanceof MultiSelectionModel) offset = 1;
    }

    /**
     * Get index of the row which was edited
     * 
     * @return Index of the row which is edited, -1 if focus in Header/Footer
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Return true if the row was changed from the previously known value
     */
    public boolean wasRowChanged() {
        return rowChanged;
    }
    
    /**
     * Get currently focused column index
     */
    public int getColumnIndex() {
        return col-offset;
    }
      
    /**
     * Return true if the column was changed from the previously known value
     */
    public boolean wasColumnChanged() {
        return colChanged;
    }
    
    /**
     * Get item which where focus is from underlying datasource
     * 
     * @return item where focus is, null if focus in Header/Footer 
     */
	public T getItem() {
		return item;
	}

}
