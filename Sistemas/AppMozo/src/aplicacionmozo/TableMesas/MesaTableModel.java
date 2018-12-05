/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionmozo.TableMesas;

import entidades.Mesa;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juan, Ignacio
 */
public class MesaTableModel extends AbstractTableModel {

    Mesa[][] mesas;

    public MesaTableModel(Mesa[][] mesas) {
        this.mesas = mesas;
    }

    @Override
    public int getRowCount() {
        return mesas.length;
    }

    @Override
    public int getColumnCount() {
        return mesas[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return mesas[rowIndex][columnIndex];
    }

}
